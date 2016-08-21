
package com.innowhere.jnieasy.core.impl.mem; 

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.mem.NativeManager;

public class NativeBufferImpl extends NativeAddressImpl implements NativeBuffer
{
    protected long size = TypeSizes.getUNKNOWN_SIZE(); // En caso de tamaño desconocido es attachment (es válido)
    protected boolean needFree = false;
    protected boolean executable = false;
    
    public NativeBufferImpl(int size) 
    {
        this(size,false);
    }

    public NativeBufferImpl(long size,boolean executable) 
    {
        boolean mustBeKnown = executable;
        checkSize(size,mustBeKnown);
        this.size = size;
        this.executable = executable;
    }    
    
    protected void finalize() throws Throwable
    {
        free();        
        super.finalize();        
    }
                
    public static NativeBufferImpl createBuffer(long size,boolean executable,boolean malloc)
    {
        NativeBufferImpl buff = new NativeBufferImpl(size,executable);
        if (malloc) buff.malloc();
        return buff;
    }            
   
    public static void checkSize(long size,boolean mustBeKnown)
    {
        // El tamaño puede ser cero, en el caso cero malloc crea un puntero pero no reserva memoria (para su gestión interna sí pero esta no es accesible)
        // y si es -1 indica tamaño desconocido (puede ser error o no)
        if (size == 0)
            return;
        
        if (size == TypeSizes.getUNKNOWN_SIZE())
        {
            if (mustBeKnown)
                throw new JNIEasyException("Memory size cannot be unknown"); 
            else
                return; // Es válida
        }
        
        if (size < 0) 
            throw new JNIEasyException("Memory size cannot be negative");
    }
        
    public long malloc()
    {
        if (needFree) 
        {
            free(); 
        }
       
        checkSize(this.size,true);           
        
        long addr = BufferNative.malloc(this.size,executable); // la función C malloc(0) también funciona y devuelve una dirección no nula y puede hacerse disconnect
        if (addr == 0) 
            throw new JNIEasyException("Cannot allocate native memory, probably out of memory");
        
        needFree = true;        

        setValue( addr );
        return addr;
    }

    public void realloc(long size)
    {
        // Por ahora no es público
        if (executable) throw new JNIEasyException("Cannot realloc executable memory");
        
        checkSize(size,true); 
        
        long addr = BufferNative.realloc(getValue(),size);
        setValue( addr );        
        this.size = size;        
    }
    
    public boolean ownsMemory()
    {
        return needFree;
    }    
    
    public boolean isAttached()
    {
        return !needFree;
    }        
    
    public boolean isAttachedTo(NativeAddress address,long offset)
    {
        if (ownsMemory()) return false;// No está attached

        NativeAddress parentAdress = getParentAddress();
        if (parentAdress == null) return false;
        return ((parentAdress.getValue() == address.getValue()) && 
                (getOffset() == offset)); // true si ya ha sido attached previamente y exactamente como se quiere, es una optimización
    }        
    
    public void attach(long address)
    {
        attach(new NativeAddressImpl(address), 0);
    }
    
    public void attach(NativeAddress address,long offset)
    {
        setValue( address, offset );
    }    
    
    public void free()
    {
        free(false);
    }
    
    public void free(boolean force)
    {    
        if (force) disconnect(NativeManager.FORCE_FREE_MEMORY);
        else disconnect(NativeManager.FREE_MEMORY);
    }
    
    public void disconnect()
    {
        disconnect(NativeManager.NOT_FREE_MEMORY);
    }
    
    public void disconnect(int freeMemMode)
    {
        if (freeMemMode == NativeManager.NOT_FREE_MEMORY)
        {
            needFree = false; 
            // Es sólo disconnect, evita que en posteriores llamadas se libere la memoria nativa, cuidado con esto pues puede crear memory leaks            
        }        
        else
        {
            // En el caso de FORCE_FREE_MEMORY se eliminará la memoria aunque no fuera el propietario
            if ((needFree && (freeMemMode == NativeManager.FREE_MEMORY))
                || (freeMemMode == NativeManager.FORCE_FREE_MEMORY))
            {
                BufferNative.free(getValue(),executable);
                needFree = false; 
                setInvalid(); // Para evitar que se use posteriormente el buffer con la dirección "destruida"
            }             
        }          
    }

    
    public long size()
    {
        return size;
    }    

    public void boundsCheck(long offset, long relsize) 
    {
        if (getValue() == 0) throw new JNIEasyException("Buffer is invalid");
        
        if (offset < 0)
            throw new JNIEasyException("Memory offset is negative");            
        
        if (this.size == TypeSizes.getUNKNOWN_SIZE()) return;  // Permitimos acceder a zonas de memoria de tamaño desconocido por el NativeBuffer
        
        if (offset + relsize > this.size)
            throw new JNIEasyException("Data size is greater than native memory allocated");
    }
 
    public byte getByte(long offset) 
    {
        boundsCheck(offset, TypeSizes.getByteSize());
        return BufferNative.getByte(getValue(),offset);
    }

    public boolean getBoolean(long offset) 
    {
        boundsCheck(offset, TypeSizes.getBooleanSize());
        return BufferNative.getBoolean(getValue(),offset);
    }

    public char getChar(long offset) 
    {
        boundsCheck(offset, TypeSizes.getCharSize());
        return BufferNative.getChar(getValue(),offset);
    }

    public short getShort(long offset) 
    {
        boundsCheck(offset, TypeSizes.getShortSize());
        return BufferNative.getShort(getValue(),offset);
    }
    
    public int getInt(long offset) 
    {
        boundsCheck(offset, TypeSizes.getIntSize());
        return BufferNative.getInt(getValue(),offset);
    }

    public long getLong(long offset) 
    {
        boundsCheck(offset, TypeSizes.getLongSize());
        return BufferNative.getLong(getValue(),offset);
    }

    public float getFloat(long offset) 
    {
        boundsCheck(offset, TypeSizes.getFloatSize());
        return BufferNative.getFloat(getValue(),offset);
    }

    public double getDouble(long offset) 
    {
        boundsCheck(offset, TypeSizes.getDoubleSize());
        return BufferNative.getDouble(getValue(),offset);
    }

    public long getAddress(long offset) 
    {
        if (TypeSizes.getADDRESS() == 4) // 32 bits
            return getInt(offset);
        else 
            return getLong(offset);
    }

    public String getAnsiString(long offset) 
    {
        int len = BufferNative.getStringLength(getValue(),offset);        
        // Si len es 0 el resultado es una cadena vacía ""
        byte[] buf = new byte[len];
        getByteArray(offset, buf, 0, len);
        byte strnull = getByte(offset + len); // No hace nada, simplemente nos asegura de que verdaderamente hay un nulo final
        return new String(buf);
    }

    public static String getNewestString(String value,String newValue)
    {
        // newValue no deberería ser nulo nunca
        if (value == null) return newValue;
        if (value.equals(newValue))
            return value; // Así reafirmamos la idea de que el "valor" en el buffer no ha cambiado (el objeto por tanto tampoco)
        else 
            return newValue;
    }    
    
    public String getAnsiString(long offset, String value)
    {
        String newValue = getAnsiString(offset);
        return getNewestString(value,newValue);
    }        
   
    public String getUnicodeString(long offset) 
    {
        int len = BufferNative.getStringUnicodeLength(getValue(),offset);        
        // Si len es 0 el resultado es una cadena vacía L""        
        if (TypeSizes.getWCharTSize() == 2)
        {
            // Si len es 0 el resultado es una cadena vacía L""
            char[] buf = new char[len];
            getCharArray(offset, buf, 0, len);
            char strnull = getChar(offset + len * TypeSizes.getCharSize()); // No hace nada, simplemente nos asegura de que verdaderamente hay un nulo final
            return new String(buf);
        }
        else // Caso de 4, Linux
        {
            char[] strbuf = new char[len];            
            for(int i = 0; i < len; i++)
                strbuf[i] = (char)getInt(offset + i * TypeSizes.getIntSize()); // Coge los 2 primeros bytes  
            int strnull = getInt(offset + len * TypeSizes.getIntSize()); // No hace nada, simplemente nos asegura de que verdaderamente hay un nulo final           
            return new String(strbuf);
        }
    }
    
    public String getUnicodeString(long offset, String value)
    {
        String newValue = getUnicodeString(offset);
        return getNewestString(value,newValue);
    }        
    
    public StringBuffer getAnsiStringBuffer(long offset) 
    {
        return getAnsiStringBuffer(offset,new StringBuffer());
    }    
    
    public StringBuffer getUnicodeStringBuffer(long offset) 
    {
        return getUnicodeStringBuffer(offset,new StringBuffer());
    }    
    
    public static StringBuffer copyToStringBuffer(String str,StringBuffer buf)
    {
        if (buf == null) buf = new StringBuffer();
        buf.delete(0, buf.length()); // Eliminamos la cadena almacenada (length() devolverá cero), no confundir con la capacidad que sigue siendo la misma
        buf.append(str);        
        return buf;
    }
    
    public StringBuffer getAnsiStringBuffer(long offset, StringBuffer buf) 
    {
        String str = getAnsiString(offset);
        buf = copyToStringBuffer(str,buf);
        return buf;
    }
    
    public char getAnsiStringBufferChar(long offset, StringBuffer buf,int index) 
    {
        char res = (char)getByteArray(offset,index);
        if (buf != null) // así admitiría cadenas muy grandes de longitud desconocida y no necesaria
            buf.setCharAt(index,res);
        return res;
    }    
    
    public void setAnsiStringBufferChar(long offset, StringBuffer buf,int index,char newValue) 
    {
        setByteArray(offset,index,(byte)newValue);
        if (buf != null) // así admitiría cadenas muy grandes de longitud desconocida y no necesaria
            buf.setCharAt(index,newValue);
    }        
    
    public char getUnicodeStringBufferChar(long offset, StringBuffer buf,int index) 
    {
        char res = (char)getCharArray(offset,index);
        if (buf != null) // así admitiría cadenas muy grandes de longitud desconocida y no necesaria
            buf.setCharAt(index,res);
        return res;
    }    
    
    public void setUnicodeStringBufferChar(long offset, StringBuffer buf,int index,char newValue) 
    {
        setCharArray(offset,index,newValue);
        if (buf != null) // así admitiría cadenas muy grandes de longitud desconocida y no necesaria
            buf.setCharAt(index,newValue);
    }        
    
    public StringBuffer getUnicodeStringBuffer(long offset, StringBuffer buf)
    {
        String str = getUnicodeString(offset);
        buf = copyToStringBuffer(str,buf);
        return buf;
    }    
    
   
    public int getAnsiStringLength(long offset)
    {
        boundsCheck(offset,0);        
        int len = BufferNative.getStringLength(getValue(),offset);
        boundsCheck(offset,len);
        return len;
    }

    public int getUnicodeStringLength(long offset)
    {
        boundsCheck(offset,0);
        int len = BufferNative.getStringUnicodeLength(getValue(),offset);
        boundsCheck(offset,len);
        return len;        
    }
    
    public byte[] getByteArray(long offset, byte[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getByteSize());
        BufferNative.getByteArray(getValue(), offset, buf, index, length);
        return buf;
    }    

    public boolean[] getBooleanArray(long offset, boolean[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getBooleanSize());
        BufferNative.getBooleanArray(getValue(), offset, buf, index, length);
        return buf;        
    }    
    
    public short[] getShortArray(long offset, short[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getShortSize());
        BufferNative.getShortArray(getValue(), offset, buf, index, length);
        return buf;        
    }

    public char[] getCharArray(long offset, char[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getCharSize());
        BufferNative.getCharArray(getValue(), offset, buf, index, length);
        return buf;        
    }

    public int[] getIntArray(long offset, int[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getIntSize());
        BufferNative.getIntArray(getValue(), offset, buf, index, length);
        return buf;        
    }

    public long[] getLongArray(long offset, long[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getLongSize());
        BufferNative.getLongArray(getValue(), offset, buf, index, length);
        return buf;        
    }

    public long[] getAddressArray(long offset, long[] buf, int index, int length) 
    {
        if (TypeSizes.getADDRESS() == 4)
        {
            boundsCheck(offset, length * TypeSizes.getIntSize());
            for(int i = 0; i < length; i++)
                buf[index + i] = BufferNative.getInt(getValue(), offset + i * TypeSizes.getIntSize());                
            return buf;
        }
        else
        {
            return getLongArray(offset,buf,index,length);
        }     
    }    
    
    public float[] getFloatArray(long offset, float[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getFloatSize());
        BufferNative.getFloatArray(getValue(), offset, buf, index, length);
        return buf;        
    }

    public double[] getDoubleArray(long offset, double[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getDoubleSize());
        BufferNative.getDoubleArray(getValue(), offset, buf, index, length);
        return buf;        
    }
    
    public byte getByteArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getByteSize());
        return BufferNative.getByte(getValue(), offset + index * TypeSizes.getByteSize());
    }
        
    public boolean getBooleanArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getBooleanSize());
        return BufferNative.getBoolean(getValue(), offset + index * TypeSizes.getBooleanSize());
    }
    
    public char getCharArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getCharSize());
        return BufferNative.getChar(getValue(), offset + index * TypeSizes.getCharSize());
    }    
    
    public short getShortArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getShortSize());
        return BufferNative.getShort(getValue(), offset + index * TypeSizes.getShortSize());
    }    
    
    public int getIntArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getIntSize());
        return BufferNative.getInt(getValue(), offset + index * TypeSizes.getIntSize());
    }
    
    public long getLongArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getLongSize());
        return BufferNative.getLong(getValue(), offset + index * TypeSizes.getLongSize());
    }
    
    public long getAddressArray(long offset, int index) 
    {
        if (TypeSizes.getADDRESS() == 4)
            return getIntArray(offset,index);
        else
            return getLongArray(offset,index);
    }    
    
    public float getFloatArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getFloatSize());
        return BufferNative.getFloat(getValue(), offset + index * TypeSizes.getFloatSize());
    }
    
    public double getDoubleArray(long offset, int index) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getDoubleSize());
        return BufferNative.getDouble(getValue(), offset + index * TypeSizes.getDoubleSize());
    }
    
    public void setByte(long offset, byte value) 
    {
        boundsCheck(offset, TypeSizes.getByteSize());
        BufferNative.setByte(getValue(),offset,value);
    }    

    public void setBoolean(long offset, boolean value) 
    {
        boundsCheck(offset, TypeSizes.getBooleanSize());
        BufferNative.setBoolean(getValue(),offset,value);
    }

    public void setChar(long offset, char value) 
    {
        boundsCheck(offset, TypeSizes.getCharSize());
        BufferNative.setChar(getValue(),offset,value);
    }

    public void setShort(long offset, short value) 
    {
        boundsCheck(offset, TypeSizes.getShortSize());
        BufferNative.setShort(getValue(),offset,value);
    }

    public void setInt(long offset, int value) 
    {
        boundsCheck(offset, TypeSizes.getIntSize());
        BufferNative.setInt(getValue(),offset,value);
    }

    public void setLong(long offset, long value) 
    {
        boundsCheck(offset, TypeSizes.getLongSize());
        BufferNative.setLong(getValue(),offset,value);
    }

    public void setFloat(long offset, float value) 
    {
        boundsCheck(offset, TypeSizes.getFloatSize());
        BufferNative.setFloat(getValue(),offset,value);
    }

    public void setDouble(long offset, double value) 
    {
        boundsCheck(offset, TypeSizes.getDoubleSize());
        BufferNative.setDouble(getValue(),offset,value);
    }

    public void setAddress(long offset, long value) 
    {       
        if (TypeSizes.getADDRESS() == 4) // 32 bits
            setInt(offset,(int)value);
        else
            setLong(offset,value);       
    }

    public void setAnsiString(long offset, String value) 
    {
        byte[] buf = value.getBytes();
        int len = buf.length;
        setByteArray(offset, buf, 0, len);
        setByte(offset + len,(byte)0); // El 0 final
    }

    public void setUnicodeString(long offset, String value) 
    {             
        int len = value.length();        
        if (TypeSizes.getWCharTSize() == 2)
        {                
            char[] buf = value.toCharArray();            
            setCharArray(offset, buf, 0, len);
            setChar(offset + len * TypeSizes.getCharSize(),'\0'); // El 0 final
        }
        else // Linux, 4 bytes
        {            
            for(int i = 0; i < len; i++)
            {
                int ch = value.charAt(i);
                setInt(offset + i * TypeSizes.getIntSize(), ch);
            }
            setInt(offset + len * TypeSizes.getIntSize(),0); // El 0 final
        }
    }

    public void setAnsiStringBuffer(long offset, StringBuffer value) 
    {
        String str = value.toString();
        setAnsiString(offset,str);
    }

    public void setUnicodeStringBuffer(long offset, StringBuffer value) 
    {
        String str = value.toString();
        setUnicodeString(offset,str);
    }
    
    public void setByteArray(long offset, byte[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getByteSize());
        BufferNative.setByteArray(getValue(), offset, buf, index, length);
    }

    public void setBooleanArray(long offset, boolean[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getBooleanSize());
        BufferNative.setBooleanArray(getValue(), offset, buf, index, length);
    }
    
    public void setShortArray(long offset, short[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getShortSize());
        BufferNative.setShortArray(getValue(), offset, buf, index, length);
    }

    public void setCharArray(long offset, char[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getCharSize());
        BufferNative.setCharArray(getValue(), offset, buf, index, length);
    }

    public void setIntArray(long offset, int[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getIntSize());
        BufferNative.setIntArray(getValue(), offset, buf, index, length);
    }

    public void setLongArray(long offset, long[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getLongSize());
        BufferNative.setLongArray(getValue(), offset, buf, index, length);
    }

    public void setAddressArray(long offset, long[] buf, int index, int length) 
    {
        if (TypeSizes.getADDRESS() == 4)
        {        
            boundsCheck(offset, length * TypeSizes.getIntSize());
            for(int i = 0; i < length; i++)
            {
                int value = (int)buf[index + i];
                BufferNative.setInt(getValue(), offset + i * TypeSizes.getIntSize(),value);         
            }
        }
        else
        {
            setLongArray(offset,buf,index,length);
        }
    }    
   
    public void setFloatArray(long offset, float[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getFloatSize());
        BufferNative.setFloatArray(getValue(), offset, buf, index, length);
    }

    public void setDoubleArray(long offset, double[] buf, int index, int length) 
    {
        boundsCheck(offset, length * TypeSizes.getDoubleSize());
        BufferNative.setDoubleArray(getValue(), offset, buf, index, length);
    }

    public void setByteArray(long offset, int index, byte value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getByteSize());
        BufferNative.setByte(getValue(), offset + index * TypeSizes.getByteSize(), value);
    } 

    public void setBooleanArray(long offset, int index, boolean value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getBooleanSize());
        BufferNative.setBoolean(getValue(), offset + index * TypeSizes.getBooleanSize(), value);
    }    
    
    public void setCharArray(long offset, int index, char value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getCharSize());
        BufferNative.setChar(getValue(), offset + index * TypeSizes.getCharSize(), value);
    }
    
    public void setShortArray(long offset, int index, short value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getShortSize());
        BufferNative.setShort(getValue(), offset + index * TypeSizes.getShortSize(), value);
    }
    
    public void setIntArray(long offset, int index, int value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getIntSize());
        BufferNative.setInt(getValue(), offset + index * TypeSizes.getIntSize(), value);
    }    

    public void setLongArray(long offset, int index, long value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getLongSize());
        BufferNative.setLong(getValue(), offset + index * TypeSizes.getLongSize(), value);
    }    
    
    public void setAddressArray(long offset, int index, long value) 
    {
        if (TypeSizes.getADDRESS() == 4)
            setIntArray(offset,index,(int)value);
        else
            setLongArray(offset,index,value);
    }        
    
    public void setFloatArray(long offset, int index, float value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getFloatSize());
        BufferNative.setFloat(getValue(), offset + index * TypeSizes.getFloatSize(), value);
    }

    public void setDoubleArray(long offset, int index, double value) 
    {
        boundsCheck(offset, (index + 1) * TypeSizes.getDoubleSize());
        BufferNative.setDouble(getValue(), offset + index * TypeSizes.getDoubleSize(), value);
    }
       

        
    public NativeBuffer getBuffer(long offset,long size)
    {
        boundsCheck(offset, size);        
        NativeBufferImpl buffer = new NativeBufferImpl(size,this.executable);
        buffer.attach(this,offset);
        return buffer;
    }
    
    public void setBuffer(long offset, NativeBuffer value) 
    {
        long length = value.size();
        if (length == TypeSizes.getUNKNOWN_SIZE())
            throw new JNIEasyException("Undefined memory size, cannot copy the buffer");
        boundsCheck(offset, length);
        BufferNative.copyFrom(getValue(), offset, value.getValue(),length);
    }
     
    public NativeBufferIterator newBufferIterator()
    {
        return new NativeBufferIteratorImpl(this);
    }
}



