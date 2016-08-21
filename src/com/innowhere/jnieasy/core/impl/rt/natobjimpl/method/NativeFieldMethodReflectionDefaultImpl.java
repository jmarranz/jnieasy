/*
 * NativeFieldMethodReflectionDefaultImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethodReflection;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.StaticFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldCallback;
import com.innowhere.jnieasy.core.method.NativeStaticFieldCallback;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature;
import com.innowhere.jnieasy.core.typedec.NativeInstanceFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeStaticFieldMethodSignature;

public class NativeFieldMethodReflectionDefaultImpl extends NativeFieldMethodReflectionImpl implements NativeStaticFieldMethodReflection,NativeInstanceFieldMethodReflection,NativeStaticFieldCallback,NativeInstanceFieldCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeFieldMethodReflectionDefaultImpl
     */
    public NativeFieldMethodReflectionDefaultImpl()
    {
    }
    
    public static NativeFieldMethodReflectionDefaultImpl newFieldMethodReflectionDefaultImpl()
    {
        return new NativeFieldMethodReflectionDefaultImpl();
    }  
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        NativeBehaviorSignature sig = getBehaviorSignature();        
        if (sig instanceof NativeStaticFieldMethodSignature)
            return new StaticFieldCallbackStateManagerImpl();            
        else        
            return new InstanceFieldCallbackStateManagerImpl();
    }      

    public NativeStaticFieldMethodSignature getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignature)getBehaviorSignature();
    }    
    
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)getBehaviorSignature();
    }        

    public NativeStaticFieldMethodSignatureRuntimeImpl jnieasyGetStaticFieldMethodSignatureRuntime()
    {
        return (NativeStaticFieldMethodSignatureRuntimeImpl)getBehaviorSignature();
    }      
    
    public NativeInstanceFieldMethodSignatureRuntimeImpl jnieasyGetInstanceFieldMethodSignatureRuntime()
    {
        return (NativeInstanceFieldMethodSignatureRuntimeImpl)getBehaviorSignature();
    }    
    
    public Object jnieasyGetDefaultReturnValue()
    {
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
        return sig.getDefaultReturnValue();
    }
    
    public Object onCall(Object obj,int opcode,Object value)
    {
        return jnieasyOnCall(obj,opcode, value);
    }
    
    public Object onCall(int opcode,Object value)
    {
        return jnieasyOnCall(null,opcode,value);
    }


    public Object jnieasyNewInstance()
    {
        return new NativeFieldMethodReflectionDefaultImpl();
    }       
    
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeFieldMethodReflectionDefaultImpl[len];
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
    
    public Object call(Object obj,int opcode,Object value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().call(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),value});
    }

    public boolean callBoolean(Object obj,int opcode,boolean value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callBoolean(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),Boolean.valueOf(value)});
    }        
    
    public byte callByte(Object obj,int opcode,byte value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callByte(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Byte(value)});
    }        
    
    public char callChar(Object obj,int opcode,char value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callChar(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Character(value)});
    }        
    
    public short callShort(Object obj,int opcode,short value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callShort(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Short(value)});
    }        

    public int callInt(Object obj,int opcode,int value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callInt(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Integer(value)});
    }        
 
    public long callLong(Object obj,int opcode,long value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callLong(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Long(value)});
    }        
 
    public float callFloat(Object obj,int opcode,float value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callFloat(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Float(value)});
    }        
    
    public double callDouble(Object obj,int opcode,double value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callDouble(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),new Double(value)});
    }        
    
    public Object callObject(Object obj,int opcode,Object value)
    {
        return jnieasyGetInstanceFieldMethodSignatureRuntime().callObject(this,jnieasyGetAddress(),obj,new Object[]{new Integer(opcode),value});
    }        
    
    public Object get(Object obj)
    {
        return call(obj,GET,jnieasyGetDefaultReturnValue());
    }

    public boolean getBoolean(Object obj)
    {
        return callBoolean(obj,GET,false);
    }

    public byte getByte(Object obj)
    {
        return callByte(obj,GET,(byte)0);        
    }

    public char getChar(Object obj)
    {
        return callChar(obj,GET,(char)0);        
    }

    public double getDouble(Object obj)
    {
        return callDouble(obj,GET,0);        
    }

    public float getFloat(Object obj)
    {
        return callFloat(obj,GET,0);        
    }

    public int getInt(Object obj)
    {
        return callInt(obj,GET,0);        
    }

    public long getLong(Object obj)
    {
        return callLong(obj,GET,0);        
    }

    public short getShort(Object obj)
    {
        return callShort(obj,GET,(short)0);        
    }

    public Object getSet(Object obj,Object value)
    {
        return call(obj,GET,value);
    }

    public void set(Object obj,Object value)
    {
        call(obj,SET,value);
    }

    public void setBoolean(Object obj,boolean value)
    {
        callBoolean(obj,SET,value);        
    }

    public void setByte(Object obj,byte value)
    {
        callByte(obj,SET,value);        
    }

    public void setChar(Object obj,char value)
    {
        callChar(obj,SET,value);        
    }

    public void setDouble(Object obj,double value)
    {
        callDouble(obj,SET,value);        
    }

    public void setFloat(Object obj,float value)
    {
        callFloat(obj,SET,value);        
    }

    public void setInt(Object obj,int value)
    {
        callInt(obj,SET,value);        
    }

    public void setLong(Object obj,long value)
    {
        callLong(obj,SET,value);        
    }

    public void setShort(Object obj,short value)
    {
        callShort(obj,SET,value);        
    }    
   
}
