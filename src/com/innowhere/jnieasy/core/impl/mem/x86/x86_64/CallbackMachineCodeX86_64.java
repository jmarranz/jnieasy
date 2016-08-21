/*
 * CallbackPrefix.java
 *
 * Created on 28 de enero de 2004, 21:15
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_64;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.impl.mem.x86.CallbackMachineCodeX86;
import com.innowhere.jnieasy.core.impl.mem.x86.RetNearPop;
import com.innowhere.jnieasy.core.mem.NativeBuffer;

public abstract class CallbackMachineCodeX86_64 extends CallbackMachineCodeX86
{
    /** Creates a new instance of CallbackPrefix */
    public CallbackMachineCodeX86_64()
    {
    }

    public static CallbackMachineCodeX86_64 createCallbackMachineCodeX86_64()
    {
/*
        if (JNIEasyNative.isMacOSX())
            return new CallbackMachineCodeX86_64MacOSX();
        else
 */
            return new CallbackMachineCodeX86_64Default(); // Linux y MSVC
    }
    
    public void compile(NativeBuffer buff,long mgrAddress,long funcAddress,long stackSizeParams)
    {
        buff.setBuffer(0,m_codePattern); // copia el contenido en buff

        long address = buff.getValue();
        MovToReg64Const64.setParam(address + m_movThisInstPos,mgrAddress);
        MovToReg64Const64.setParam(address + m_movFuncInstPos,funcAddress);
        RetNearPop.setStackSize(address + m_retInstPos,(short)stackSizeParams);
    }

}
