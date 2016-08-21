/*
 * CallbackPrefix.java
 *
 * Created on 28 de enero de 2004, 21:15
 */

package com.innowhere.jnieasy.core.impl.mem.x86;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.mem.*;

public abstract class CallbackMachineCodeX86 extends CallbackMachineCodeImpl
{
    protected int m_movThisInstPos;
    protected int m_movFuncInstPos;
    protected int m_retInstPos;
    protected NativeBufferImpl m_codePattern;

    /** Creates a new instance of CallbackPrefix */
    public CallbackMachineCodeX86()
    {
        buildIntructions();

        // Aunque es código ejecutable, este buffer sirve de patrón para hacer
        // copias en los demás, por lo que este buffer no es ejecutado.
        m_codePattern = NativeBufferImpl.createBuffer( memorySize(),false,true);
        NativeBufferIteratorImpl memIt = (NativeBufferIteratorImpl)m_codePattern.newBufferIterator();
        compile(memIt);
    }

    protected abstract void buildIntructions();

    protected void finalize() throws Throwable
    {
        m_codePattern.free();
        super.finalize();
    }

}
