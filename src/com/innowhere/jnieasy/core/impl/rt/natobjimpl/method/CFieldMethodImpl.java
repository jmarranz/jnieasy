
package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method; 
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CFieldMethodInternal;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.CFieldMethodStateManagerImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;

public class CFieldMethodImpl extends DLLBehaviorImpl implements CFieldMethodInternal
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    public CFieldMethodImpl() 
    {
    }   
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();
    }    
    
    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)getBehaviorSignature();
    }    

    public NativeStaticFieldMethodSignatureRuntimeImpl jnieasyGetStaticFieldMethodSignatureRuntime()
    {
        return (NativeStaticFieldMethodSignatureRuntimeImpl)getBehaviorSignature();
    }        
    
    public Object jnieasyNewInstance()
    {
        return new CFieldMethodImpl();
    }
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new CFieldMethodImpl[len];
    }     
    
    public Object jnieasyGetDefaultReturnValue()
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().getDefaultReturnValue();
    }

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new CFieldMethodStateManagerImpl();
    }     
    
    public long jnieasyGetSize()
    {
        // Redefine el método por defecto
        // El tamaño de la variable estática en memoria
        return jnieasyGetStaticFieldMethodSignatureRuntime().getReturnTypeNativeRuntime().getVarTypeNativeRuntime().size();
    }    
  
    public NativeDirectStaticFieldCallback jnieasyNewNativeDirectStaticFieldCallbackAuxiliar()
    {
        // Creando aquí la instancia aseguramos que se usa el ClassLoader del contenedor
        NativeDirectStaticFieldCallbackToCFieldMethodImpl auxMethod = new NativeDirectStaticFieldCallbackToCFieldMethodImpl(this);    
        return auxMethod;
    }
    
    public Object call(int opcode,Object value)
    {
        int resTypeCode = jnieasyGetStaticFieldMethodSignatureRuntime().getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime().returnTypeCode();
        switch(resTypeCode)
        {
            //case ClassTypeRuntimeImpl.VOID :   callVoid(container,opcode,args); return null;
            case ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN : return Boolean.valueOf(callBoolean(opcode,((Boolean)value).booleanValue()));
            case ClassTypeNativeRuntimeImpl.CHAR_RETURN :   return new Character(callChar(opcode,((Character)value).charValue()));            
            case ClassTypeNativeRuntimeImpl.SHORT_RETURN :  return new Short(callShort(opcode,((Short)value).shortValue()));            
            case ClassTypeNativeRuntimeImpl.INT_RETURN :    return new Integer(callInt(opcode,((Integer)value).intValue()));            
            case ClassTypeNativeRuntimeImpl.LONG_RETURN :   return new Long(callLong(opcode,((Long)value).longValue())); 
            case ClassTypeNativeRuntimeImpl.FLOAT_RETURN :  return new Float(callFloat(opcode,((Float)value).floatValue()));
            case ClassTypeNativeRuntimeImpl.DOUBLE_RETURN : return new Double(callDouble(opcode,((Double)value).doubleValue()));
            case ClassTypeNativeRuntimeImpl.POINTER_RETURN :  return callObject(opcode,value);
        }
        throw new JNIEasyException("INTERNAL ERROR: Not valid return type");        
    }

    public synchronized boolean callBoolean(int opcode,boolean value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();
        switch(opcode)
        {
            case GET : 
                return stateMgr.getBoolean();
            case SET : 
                stateMgr.setBoolean(value);
                return value;
            case GET_SET : 
                boolean oldValue = stateMgr.getBoolean();
                stateMgr.setBoolean(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        }        
    }        
    
    public synchronized byte callByte(int opcode,byte value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.BYTE_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();
        switch(opcode)
        {
            case GET : 
                return stateMgr.getByte();
            case SET : 
                stateMgr.setByte(value);
                return value;
            case GET_SET : 
                byte oldValue = stateMgr.getByte();
                stateMgr.setByte(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        
    
    public synchronized char callChar(int opcode,char value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.CHAR_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();
        switch(opcode)
        {
            case GET : 
                return stateMgr.getChar();
            case SET : 
                stateMgr.setChar(value);
                return value;
            case GET_SET : 
                char oldValue = stateMgr.getChar();
                stateMgr.setChar(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        
    
    public synchronized short callShort(int opcode,short value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.SHORT_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();  
        switch(opcode)
        {
            case GET : 
                return stateMgr.getShort();
            case SET : 
                stateMgr.setShort(value);
                return value;
            case GET_SET : 
                short oldValue = stateMgr.getShort();
                stateMgr.setShort(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        

    public synchronized int callInt(int opcode,int value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.INT_RETURN);

        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();  
        switch(opcode)
        {
            case GET : 
                return stateMgr.getInt();
            case SET : 
                stateMgr.setInt(value);
                return value;
            case GET_SET : 
                int oldValue = stateMgr.getInt();
                stateMgr.setInt(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        
 
    public synchronized long callLong(int opcode,long value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.LONG_RETURN);

        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();  
        switch(opcode)
        {
            case GET : 
                return stateMgr.getLong();
            case SET : 
                stateMgr.setLong(value);
                return value;
            case GET_SET : 
                long oldValue = stateMgr.getLong();
                stateMgr.setLong(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        
 
    public synchronized float callFloat(int opcode,float value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.FLOAT_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();  
        switch(opcode)
        {
            case GET : 
                return stateMgr.getFloat();
            case SET : 
                stateMgr.setFloat(value);
                return value;
            case GET_SET : 
                float oldValue = stateMgr.getFloat();
                stateMgr.setFloat(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        
    
    public synchronized double callDouble(int opcode,double value)
    {
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.DOUBLE_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();  
        switch(opcode)
        {
            case GET : 
                return stateMgr.getDouble();
            case SET : 
                stateMgr.setDouble(value);
                return value;
            case GET_SET : 
                double oldValue = stateMgr.getDouble();
                stateMgr.setDouble(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        } 
    }        

    public synchronized Object callObject(int opcode,Object value)
    {
        // Recordar que sólo admitimos como retorno punteros (caso de estructuras) por lo que 
        // también es tratado como puntero el argumento
        jnieasyGetStaticFieldMethodSignatureRuntime().checkSelectedMethod(ClassTypeNativeRuntimeImpl.POINTER_RETURN);
        
        CFieldMethodStateManagerImpl stateMgr = (CFieldMethodStateManagerImpl)jnieasyGetNativeStateManager();  
        switch(opcode)
        {
            case GET : 
                return stateMgr.getObject();
            case SET : 
                stateMgr.setObject(value);
                return value;
            case GET_SET : 
                Object oldValue = stateMgr.getObject();
                stateMgr.setObject(value);
                return oldValue; 
            default: throw new JNIEasyException("Invalid field access code");
        }   
    }        
   
    public Object get()
    {
        return call(GET,jnieasyGetDefaultReturnValue());
    }

    public boolean getBoolean()
    {
        return callBoolean(GET,false);
    }

    public byte getByte()
    {
        return callByte(GET,(byte)0);        
    }

    public char getChar()
    {
        return callChar(GET,(char)0);        
    }

    public double getDouble()
    {
        return callDouble(GET,0);        
    }

    public float getFloat()
    {
        return callFloat(GET,0);        
    }

    public int getInt()
    {
        return callInt(GET,0);        
    }

    public long getLong()
    {
        return callLong(GET,0);        
    }

    public short getShort()
    {
        return callShort(GET,(short)0);        
    }

    public Object getSet(Object value)
    {
        return call(GET_SET,value);
    }

    public void set(Object value)
    {
        call(SET,value);
    }

    public void setBoolean(boolean value)
    {
        callBoolean(SET,value);        
    }

    public void setByte(byte value)
    {
        callByte(SET,value);        
    }

    public void setChar(char value)
    {
        callChar(SET,value);        
    }

    public void setDouble(double value)
    {
        callDouble(SET,value);        
    }

    public void setFloat(float value)
    {
        callFloat(SET,value);        
    }

    public void setInt(int value)
    {
        callInt(SET,value);        
    }

    public void setLong(long value)
    {
        callLong(SET,value);        
    }

    public void setShort(short value)
    {
        callShort(SET,value);        
    }    

    
}

