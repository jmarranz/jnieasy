/*
 * CallbackStateManagerImpl.java
 *
 * Created on 24 de septiembre de 2004, 13:20
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.mem.CallbackMachineCodeImpl;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.signat.ParameterDecListRuntime;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;

public abstract class CallbackStateManagerImpl extends NativeStateManagerImpl
{
    protected static final CallbackMachineCode machineCodePattern = CallbackMachineCodeImpl.createMachineCode();
    
    protected long handle; // No confundir este handle con la dirección de la callback
    protected CallbackStateManagerNative jniPort = new CallbackStateManagerNative(this);
    
    /**
     * Creates a new instance of CallbackStateManagerImpl 
     */
    public CallbackStateManagerImpl()
    {
    }

    public void allocateBuffer(NativeManagerImpl memMgr,NativeCapableInternal value,boolean isAuxiliar)
    {
        super.allocateBuffer(memMgr,value,isAuxiliar);

        bindNative();
    }
    
    public NativeCallback getCallback()
    {
        return (NativeCallback)value;
    }

    public boolean isMemoryExecutable()
    {
        return true;
    }
    
    public static long memorySize()
    {
        return machineCodePattern.memorySize();
    }
    
    public long getHandle()
    {
        return handle;
    }
    
    public void detachBuffer(int freeMemMode)
    {
        if (freeMemMode >= NativeManager.FREE_MEMORY)
            unbindNative();
        super.detachBuffer(freeMemMode);
    }    
        
    public void bindNative()
    {
        unbindNative();
        NativeBehaviorSignatureRuntimeImpl sig = getBehaviorSignature();
        sig.checkReturnValidOfCallback();
        
        int resType = sig.getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime().returnTypeCode();
        int callConv = sig.getCallConv();
        this.handle = jniPort.registerInDLL(resType,callConv);

        JNIEasyLibraryImpl jnieasyDLL = (JNIEasyLibraryImpl)nativeMgr.getJNIEasy().getJNIEasyLib();
        long funcAddr = jnieasyDLL.getOnCallAddress(resType);
        
        long stackSize = 0;
        if (callConv == CallConv.STD_CALL) stackSize = sig.getParameterDecList().stackSize();
        machineCodePattern.compile(buffer,handle,funcAddr,stackSize);
    }

    public void unbindNative()
    {
        /* Es fundamental definir para que se libere en la DLL la WeakReference que
         * es un objeto global.
         */
        if (handle != 0)
        {
            jniPort.unregisterInDLL(handle);
            handle = 0; 
        }        
    }
    
    public NativeBehaviorSignatureRuntimeImpl getBehaviorSignature()
    {
        return (NativeBehaviorSignatureRuntimeImpl)getCallback().getBehaviorSignature();    
    }
        
    public abstract Object onCallGeneric(Object[] args);
    
    public Object onCallAnyType(long stackAddress)
    {    
        NativeBehaviorSignatureRuntimeImpl sig = getBehaviorSignature();
        ParameterDecListRuntime paramDecList = sig.getParameterDecList();
        
        long size = paramDecList.stackSize();
        NativeBufferImpl buffer = NativeBufferImpl.createBuffer(size,false,false);
        // No hacemos malloc, viene a ser un attach, pues es el stack, pero
        // gracias a tener el size se chequea si se desborda o no
        buffer.attach(stackAddress);

        Object[] params = paramDecList.pop(buffer);
        Object res = onCallGeneric(params);

        // No hacemos wrapp ni nada por el estilo si el objeto
        // es unwrapped, pues al hacer wrapp
        // se crea un nuevo objeto asociado a memoria nativa
        // dicho objeto se perderá via GC al salir de esta función
        // por lo que la dirección de memoria devuelta no valdrá
        // Sencillamente no vale devolver un unwrapp cuando se espera
        // NativeCapable aunque se pudiera envolver en el mismo

        sig.getReturnTypeNativeRuntime().checkValue(res);
        return res;
    }
}
