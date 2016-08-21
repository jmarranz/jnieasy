/*
 * CallbackPrefix.java
 *
 * Created on 28 de enero de 2004, 21:15
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_32;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.mem.x86.RetNearPop;
import com.innowhere.jnieasy.core.impl.jni.JNIEasyNative;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.impl.mem.x86.CallbackMachineCodeX86;

public abstract class CallbackMachineCodeX86_32 extends CallbackMachineCodeX86
{
   
    /** Creates a new instance of CallbackPrefix */
    public CallbackMachineCodeX86_32()
    {      
    }
    
    public static CallbackMachineCodeX86_32 createCallbackMachineCodeX86_32()
    {
        if (JNIEasyNative.isMacOSX())
            return new CallbackMachineCodeX86_32MacOSX();            
        else
            return new CallbackMachineCodeX86_32Default(); // Linux y MSVC
    }
    
    public void compile(NativeBuffer buff,long mgrAddress,long funcAddress,long stackSizeParams)
    {
        buff.setBuffer(0,m_codePattern); // copia el contenido en buff

        // Estamos en 32 bits, hay que hacer casts
        
        int address = (int)buff.getValue();       
        MovToReg32Const32.setParam(address + m_movThisInstPos,(int)mgrAddress);
        MovToReg32Const32.setParam(address + m_movFuncInstPos,(int)funcAddress);        
        RetNearPop.setStackSize(address + m_retInstPos,(short)stackSizeParams);
    }

}
