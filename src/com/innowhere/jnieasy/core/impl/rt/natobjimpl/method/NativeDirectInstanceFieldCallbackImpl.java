/*
 * NativeDirectInstanceFieldCallbackImpl.java
 *
 * Created on 12 de febrero de 2004, 11:25
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.statemgr.InstanceFieldCallbackStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeInstanceFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.*;

public abstract class NativeDirectInstanceFieldCallbackImpl extends NativeDirectFieldCallbackImpl implements NativeDirectInstanceFieldCallback
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeDirectInstanceFieldCallbackImpl
     */
    public NativeDirectInstanceFieldCallbackImpl()
    {
    }    
    
    public long jnieasyGetSize()
    {
        return InstanceFieldCallbackStateManagerImpl.memorySize();
    }  

    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new InstanceFieldCallbackStateManagerImpl();
    }    
    
    public NativeInstanceFieldMethodSignature getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignature)getBehaviorSignature();
    }    

    public NativeInstanceFieldMethodSignatureRuntimeImpl jnieasyGetInstanceFieldMethodSignatureRuntime()
    {
        return (NativeInstanceFieldMethodSignatureRuntimeImpl)getBehaviorSignature();
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
    
    public Object onCall(Object obj,int opcode,Object value)
    {
        return jnieasyOnCall(obj,opcode,value);
    }

    public abstract Object jnieasyOnCall(Object obj,int opcode,Object value);


}
