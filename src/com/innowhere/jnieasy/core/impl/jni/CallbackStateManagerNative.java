/*
 * CallbackStateManagerNative.java
 *
 * Created on 12 de enero de 2006, 19:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.jni;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.CallbackStateManagerImpl;
import java.lang.ref.WeakReference;

/**
 *
 * @author jmarranz
 */
public class CallbackStateManagerNative
{
    protected CallbackStateManagerImpl parent;
    
    /**
     * Creates a new instance of CallbackStateManagerNative
     */
    public CallbackStateManagerNative(CallbackStateManagerImpl parent)
    {
        this.parent = parent;
    }
    
    public long registerInDLL(int returnType,int callConv)
    {
        return registerInDLL(new WeakReference(this),returnType,callConv);        
    }
    
    private native long registerInDLL(WeakReference weakRef,int returnType,int callConv);
    
    public static native void unregisterInDLL(long address);
 
    
    // ¡Desde aquí son llamadas via JNI por código nativo! 
    // NO CAMBIAR NI OFUSCAR
    
    public void onCallVoid(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        if (res != null) throw new JNIEasyException("Return value must be null when return type is void"); 
        return;
    }

    public boolean onCallBoolean(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Boolean)res).booleanValue();
    }

    public byte onCallByte(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Byte)res).byteValue();
    }
    
    public char onCallChar(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Character)res).charValue();
    }
    
    public short onCallShort(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Short)res).shortValue();
    }
    
    public int onCallInt(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Integer)res).intValue();
    }
    
    public long onCallLong(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Long)res).longValue();
    }
  
    public float onCallFloat(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Float)res).floatValue();
    }
    
    public double onCallDouble(long stackAddress)
    {
        Object res = parent.onCallAnyType(stackAddress);
        return ((Double)res).doubleValue();
    }

    public long onCallPointer(long stackAddress)
    {
        // No puede ser el retorno un String etc (un can be native object)
        // ver BehaviorSignatureImpl.checkReturnValidOfCallback()
        NativeCapable res = (NativeCapable)parent.onCallAnyType(stackAddress);
        if (res == null) return 0;
                
        NativeManagerImpl nativeMgr = (NativeManagerImpl)parent.getNativeManager();
        synchronized(res)
        {
            nativeMgr.makeNative(res); // Si ya es native no hace nada
            return res.jnieasyGetNativeStateManager().getBuffer().getValue();
        }
    }           
}
