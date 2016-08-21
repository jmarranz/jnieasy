/*
 * NativeFieldContainerStateManagerImpl.java
 *
 * Created on 14 de septiembre de 2005, 12:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.NativeTransactionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeFieldContainerInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import java.util.ArrayList;



/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldContainerStateManagerImpl extends NativeStateManagerImpl
{
    protected ArrayList auxObjects;
    protected Object[] fieldsTxn;    
    protected boolean[] fieldsTxnSaved;    
    
    
    /**
     * Creates a new instance of NativeFieldContainerStateManagerImpl
     */
    public NativeFieldContainerStateManagerImpl()
    {
    }   
    
    public void saveFieldTxn(int fieldIndex)
    {
        if (fieldIndex == -1)
        {
            for(int i = 0; i < fieldsTxnSaved.length; i++)
            {
                saveFieldTxn(i);
            }
        }
        else
        {
            if (!fieldsTxnSaved[fieldIndex]) // Se salva una vez por transacción
            {
                Object fieldValue = getFieldValueTxn(fieldIndex);

                fieldsTxn[fieldIndex] = fieldValue;
                fieldsTxnSaved[fieldIndex] = true;
            }
        }
    }    
    
    public void saveAllFieldsTxn()
    {
        if (fieldsTxnSaved != null)
        {
            for(int i = 0; i < fieldsTxnSaved.length; i++)
            {
                saveFieldTxn(i);
            }            
        }        
    }
    
    public void begin(NativeTransactionImpl txn)
    {
        // Hay que ver la transacción desde el punto de vista de la memoria nativa
        // más que desde el punto de vista de los fields del objeto Java, lo que
        // guardamos es la foto de la memoria nativa a través de los objetos Java.
        
        super.begin(txn);

        int count = getAbsoluteTxnFieldCount();
        if (count > 0)
        {
            this.fieldsTxn = new Object[count];
            this.fieldsTxnSaved = new boolean[count];
        }
    }
        
    public void rollbackFields()
    {
        if (fieldsTxnSaved != null)
        {
            for(int i = 0; i < fieldsTxnSaved.length; i++)
            {
                if (fieldsTxnSaved[i])
                {
                    Object fieldValue = fieldsTxn[i];
                    setFieldValueTxn(i, fieldValue);
                    fieldsTxnSaved[i] = false;
                }
            }
        }    
    }
    
    public void rollback()
    {
        super.rollback(); 
        
        this.fieldsTxn = null;
        this.fieldsTxnSaved = null;                       
    }

    public void commit()
    {
        super.commit();
        
        this.fieldsTxn = null;
        this.fieldsTxnSaved = null;        
    }
    
    
    public abstract Object getFieldValueTxn(int fieldIndex);
    
    public abstract void setFieldValueTxn(int fieldIndex,Object fieldValue);
    
    public abstract int getAbsoluteTxnFieldCount();   

    public void setNewAuxObjectsArray(int size)
    {
        if (auxObjects != null)
        {
            auxObjects.clear();
            if (size > 0) auxObjects.ensureCapacity(size);
        }
        else
        {
            if (size > 0)
                this.auxObjects = new ArrayList(size);
            else
                this.auxObjects = new ArrayList(); // capacidad de 10 por defecto
        }
        
        for(int i = 0; i < size; i++)
            auxObjects.add(null);
    }
    
    public void incrementAuxObjectsArray(int newSize)
    {
        int size = auxObjects.size();
        for(int i = 1; i <= newSize - size; i++)
            auxObjects.add(null);        
    }
    
    public boolean isMemoryExecutable()
    {
        return false;
    }
    
    public NativeFieldContainerInternal getFieldContainer()
    {
        return (NativeFieldContainerInternal)value;
    }
    
    public CanBeNativeCapableInternal getAuxObject(int index)
    {
        if (index >= auxObjects.size())
        {
            // Se da en el caso de arrays proxy en donde no se conoce el tamaño
            incrementAuxObjectsArray(index + 1);
        }

        return (CanBeNativeCapableInternal)auxObjects.get(index);
    }

    public void setAuxObject(int index,CanBeNativeCapableInternal newValue)
    {
        if (index >= auxObjects.size())
        {
            // Se da en el caso de arrays proxy en donde no se conoce el tamaño
            incrementAuxObjectsArray(index + 1);
        }

        auxObjects.set(index,newValue);
    }    
    
    public void detachFields(int freeMemMode,boolean deep)
    {
        getFieldContainer().jnieasyDetachFields(freeMemMode,deep,this);
        
        super.detachFields(freeMemMode,deep);
    }  

    public void makeNativeFields(int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        setNewAuxObjectsArray();
        
        getFieldContainer().jnieasyUnFetchFields(unFetchMode,unfetchCtx,attachCopyCtx,this);        
                
        super.makeNativeFields(unFetchMode,unfetchCtx,attachCopyCtx);
    }
    
    public void attachFields()
    {
        setNewAuxObjectsArray();
        
        // No necesitamos hacer attach a los fields pues cuando se accedan
        // por primera vez se hará el attachment o se creará el auxiliar
        // correspondiente y se hará el attachment, de esta manera hacemos
        // nativos los objetos "bajo demanda" y ganamos tiempo si no se usan, 
        // hay que tener en cuenta que el attach no toca la memoria nativa y la memoria nativa manda
        // Siempre el usuario puede hacer un unFetch deep tras el attach para asegurarse de
        // que todo el árbol de objetos queda nativo.
        
        super.attachFields();        
    }    
    
    public void attachCopy(NativeCapableInternal detachedCopy,AttachCopyContext ctx)
    {
        getFieldContainer().jnieasyAttachCopy(detachedCopy,ctx,this);        
        
        super.attachCopy(detachedCopy, ctx);
    }
    
    public void fetch(int mode,FetchUnFetchContext fetchCtx)
    {
        getFieldContainer().jnieasyFetchFields(mode,fetchCtx,this);    
        
        super.fetch(mode, fetchCtx);
    }
   
    public void unFetch(int mode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {       
        getFieldContainer().jnieasyUnFetchFields(mode,unfetchCtx,attachCopyCtx,this);   
        
        super.unFetch(mode, unfetchCtx, attachCopyCtx);
    }    

    protected abstract void setNewAuxObjectsArray();
    
    public void txnSaveBeforeUpdate(int fieldIndex)
    {    
        if (txnMarkUpdate())
            saveFieldTxn(fieldIndex);
    }
    
    public boolean txnMarkFreed()
    {        
        boolean res = super.txnMarkFreed();
        if (res)
        {
            // Va a ser destruida la memoria, hemos de salvar primero 
            // todos los fields para que en el rollback podamos restaurar
            // la memoria como estaba (aunque en otro "lugar" físico)
            saveAllFieldsTxn();
        }
        return res;
    }
    
    public long getAddress(int fieldIndex,long offset)
    {
        return buffer.getAddress(offset);
    }
    
    public void setAddress(int fieldIndex,long offset, long value)
    {
        txnSaveBeforeUpdate(fieldIndex);
        buffer.setAddress(offset,value);
    }   
    
    public byte getByte(int fieldIndex,long offset)
    {
        return buffer.getByte(offset);
    }
    
    public boolean getBoolean(int fieldIndex,long offset)
    {
        return buffer.getBoolean(offset);
    }    
    
    public char getChar(int fieldIndex,long offset)
    {
        return buffer.getChar(offset);
    }
    
    public short getShort(int fieldIndex,long offset)
    {
        return buffer.getShort(offset);
    }
    
    public int getInt(int fieldIndex,long offset)
    {
        return buffer.getInt(offset);
    }
    
    public long getLong(int fieldIndex,long offset)
    {
        return buffer.getLong(offset);
    }
    
    public float getFloat(int fieldIndex,long offset)
    {
        return buffer.getFloat(offset);
    }
    
    public double getDouble(int fieldIndex,long offset)
    {
        return buffer.getDouble(offset);
    }        
    

    public void setByte(int fieldIndex,long offset, byte value)
    {
        txnSaveBeforeUpdate(fieldIndex);
        buffer.setByte(offset, value);
    }
    
    public void setBoolean(int fieldIndex,long offset, boolean value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setBoolean(offset, value);
    }
    
    public void setChar(int fieldIndex,long offset, char value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setChar(offset, value);
    }
    
    public void setShort(int fieldIndex,long offset, short value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setShort(offset, value);
    }
    
    public void setInt(int fieldIndex,long offset, int value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setInt(offset, value);
    }
    
    public void setLong(int fieldIndex,long offset, long value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setLong(offset, value);
    }
    
    public void setFloat(int fieldIndex,long offset, float value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setFloat(offset, value);
    }
    
    public void setDouble(int fieldIndex,long offset, double value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setDouble(offset, value);
    }
    
    public String getAnsiString(int fieldIndex,long offset,String value)
    {
        return buffer.getAnsiString(offset, value);
    }
    
    public void setAnsiString(int fieldIndex,long offset, String value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setAnsiString(offset,value);
    }
    
    public String getUnicodeString(int fieldIndex,long offset,String value)
    {
        return buffer.getUnicodeString(offset,value);
    }
    
    public void setUnicodeString(int fieldIndex,long offset, String value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setUnicodeString(offset,value);
    }
    
    public StringBuffer getAnsiStringBuffer(int fieldIndex,long offset,StringBuffer value)
    {
        return buffer.getAnsiStringBuffer(offset, value);
    }
    
    public void setAnsiStringBuffer(int fieldIndex,long offset, StringBuffer value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setAnsiStringBuffer(offset, value);
    }    


    public StringBuffer getUnicodeStringBuffer(int fieldIndex,long offset,StringBuffer value)
    {
        return buffer.getUnicodeStringBuffer(offset, value);
    }
    
    public void setUnicodeStringBuffer(int fieldIndex,long offset, StringBuffer value)
    {
        txnSaveBeforeUpdate(fieldIndex);        
        buffer.setUnicodeStringBuffer(offset, value);
    }    
    
    public char getAnsiStringBufferChar(int fieldIndex,long offset,StringBuffer value,int index)
    {
        return buffer.getAnsiStringBufferChar(offset, value,index);
    }        
    
    public void setAnsiStringBufferChar(int fieldIndex,long offset,StringBuffer value,int index,char newValue)
    {
        txnSaveBeforeUpdate(fieldIndex);         
        buffer.setAnsiStringBufferChar(offset, value,index,newValue);
    }        
    
    public char getUnicodeStringBufferChar(int fieldIndex,long offset,StringBuffer value,int index)
    {
        return buffer.getUnicodeStringBufferChar(offset, value,index);
    }    

    public void setUnicodeStringBufferChar(int fieldIndex,long offset,StringBuffer value,int index,char newValue)
    {
        txnSaveBeforeUpdate(fieldIndex);         
        buffer.setUnicodeStringBufferChar(offset, value,index,newValue);
    }    
    
    public byte[] getByteArray(long offset, byte[] buf)
    {
        return buffer.getByteArray(offset,buf,0, buf.length);
    }
    
    public void setByteArray(long offset, byte[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setByteArray(offset, buf, 0, buf.length);
    }
    
    public boolean[] getBooleanArray(long offset, boolean[] buf)
    {
        return buffer.getBooleanArray(offset,buf,0, buf.length);
    }
    
    public void setBooleanArray(long offset, boolean[] buf) 
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setBooleanArray(offset, buf, 0, buf.length);
    }
    
    public char[] getCharArray(long offset, char[] buf)
    {
        return buffer.getCharArray(offset,buf,0, buf.length);
    }
    
    public void setCharArray(long offset, char[] buf) 
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setCharArray(offset, buf, 0, buf.length);
    }
    
    public short[] getShortArray(long offset, short[] buf)
    {
        return buffer.getShortArray(offset,buf,0, buf.length);
    }
    
    public void setShortArray(long offset, short[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setShortArray(offset, buf, 0, buf.length);
    }
    
    public int[] getIntArray(long offset, int[] buf)
    {
        return buffer.getIntArray(offset,buf,0, buf.length);
    }

    public void setIntArray(long offset, int[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setIntArray(offset, buf, 0, buf.length);
    }
    
    public long[] getLongArray(long offset, long[] buf)
    {
        return buffer.getLongArray(offset,buf,0, buf.length);
    }
    
    public void setLongArray(long offset, long[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setLongArray(offset, buf, 0, buf.length);
    }  
/*    
    public long[] getAddressArray(long offset, long[] buf)
    {
        return buffer.getAddressArray(offset,buf,0, buf.length);
    }        
    
    public void setAddressArray(long offset, long[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setAddressArray(offset, buf, 0, buf.length);
    }
*/    
    public float[] getFloatArray(long offset, float[] buf)
    {
        return buffer.getFloatArray(offset,buf,0, buf.length);
    }
        
    public void setFloatArray(long offset, float[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setFloatArray(offset, buf, 0, buf.length);
    }
    
    public double[] getDoubleArray(long offset, double[] buf)
    {
        return buffer.getDoubleArray(offset,buf,0, buf.length);
    }    

    public void setDoubleArray(long offset, double[] buf)
    {
        txnSaveBeforeUpdate(-1);         
        buffer.setDoubleArray(offset, buf, 0, buf.length);
    }    
    
    public byte getByteArray(long offset, int index)
    {
        return buffer.getByteArray(offset,index);
    }
        
    public void setByteArray(long offset, int index, byte value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setByteArray(offset,index,value);
    }
    
    public boolean getBooleanArray(long offset, int index) 
    {
        return buffer.getBooleanArray(offset,index);
    }
    
    public void setBooleanArray(long offset, int index, boolean value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setBooleanArray(offset,index,value);
    }
    
    public char getCharArray(long offset, int index)
    {
        return buffer.getCharArray(offset,index);
    }
    
    public void setCharArray(long offset, int index, char value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setCharArray(offset,index,value);
    }
    
    public short getShortArray(long offset, int index)
    {
        return buffer.getShortArray(offset,index);
    }
    
    public void setShortArray(long offset, int index, short value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setShortArray(offset,index,value);
    }
    
    public int getIntArray(long offset, int index)
    {
        return buffer.getIntArray(offset,index);
    }
        
    public void setIntArray(long offset, int index, int value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setIntArray(offset,index,value);
    }
    
    public long getLongArray(long offset, int index)
    {
        return buffer.getLongArray(offset,index);
    }
    
    public void setLongArray(long offset, int index, long value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setLongArray(offset,index,value);
    }
/*    
    public long getAddressArray(long offset, int index)
    {
        return buffer.getAddressArray(offset,index);
    }
    
    public void setAddressArray(long offset, int index, long value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setAddressArray(offset,index,value);
    }    
*/    
    public float getFloatArray(long offset, int index)
    {
        return buffer.getFloatArray(offset,index);
    }
    
    public void setFloatArray(long offset, int index, float value)
    {
        txnSaveBeforeUpdate(index);        
        buffer.setFloatArray(offset,index,value);
    }
    
    public double getDoubleArray(long offset, int index) 
    {
        return buffer.getDoubleArray(offset,index);
    }
        
    public void setDoubleArray(long offset, int index, double value)   
    {
        txnSaveBeforeUpdate(index);        
        buffer.setDoubleArray(offset,index,value);
    }    
    
    public abstract int getAbsAuxNativeObjectIndex(int absFieldIndex);    
}
