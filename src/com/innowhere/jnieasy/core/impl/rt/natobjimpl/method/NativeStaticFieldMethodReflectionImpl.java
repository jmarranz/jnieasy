/*
 * NativeStaticFieldMethodReflectionImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeStaticFieldCallback;
import com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature;

public class NativeStaticFieldMethodReflectionImpl extends NativeFieldMethodReflectionImpl implements NativeStaticFieldMethodReflection,NativeStaticFieldCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeStaticFieldMethodReflectionImpl
     */
    public NativeStaticFieldMethodReflectionImpl()
    {
    }
    
    public static NativeStaticFieldMethodReflectionImpl newStaticField()
    {
        return new NativeStaticFieldMethodReflectionImpl();
    }  

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new StaticFieldCallbackStateManagerImpl();
    }       

    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)getBehaviorSignature();
    }    

    public NativeStaticFieldMethodSignatureRuntimeImpl jnieasyGetStaticFieldMethodSignatureRuntime()
    {
        return (NativeStaticFieldMethodSignatureRuntimeImpl)getBehaviorSignature();
    }        
    
    public Object onCall(int opcode,Object value)
    {
        return jnieasyOnCall(null,opcode,value);
    }
    
    public Object call(int opcode,Object value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().call(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),value});
    }

    public boolean callBoolean(int opcode,boolean value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callBoolean(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),Boolean.valueOf(value)});
    }        
    
    public byte callByte(int opcode,byte value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callByte(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Byte(value)});
    }        
    
    public char callChar(int opcode,char value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callChar(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Character(value)});
    }        
    
    public short callShort(int opcode,short value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callShort(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Short(value)});
    }        

    public int callInt(int opcode,int value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callInt(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Integer(value)});
    }        
 
    public long callLong(int opcode,long value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callLong(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Long(value)});
    }        
 
    public float callFloat(int opcode,float value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callFloat(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Float(value)});
    }        
    
    public double callDouble(int opcode,double value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callDouble(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),new Double(value)});
    }        
    
    public Object callObject(int opcode,Object value)
    {
        return jnieasyGetStaticFieldMethodSignatureRuntime().callObject(this,jnieasyGetAddress(),new Object[]{new Integer(opcode),value});
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
   
    public Object jnieasyNewInstance()
    {
        return new NativeStaticMethodReflectionImpl();
    }   
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeStaticMethodReflectionImpl[len];
    }     
       
}
