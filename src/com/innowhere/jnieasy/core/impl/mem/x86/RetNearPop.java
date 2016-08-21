/*
 * Push.java
 *
 * Created on 29 de enero de 2004, 18:58
 */

package com.innowhere.jnieasy.core.impl.mem.x86;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class RetNearPop extends ASMInstruction
{
/*  bytecode            ASM

    C2 cte16             ret        cte16
*/
    protected byte m_opcode;
    protected short m_stackSize;

    /** Creates a new instance of Push */
    public RetNearPop(short stack)
    {
        m_opcode = (byte)0xC2;
        m_stackSize = stack;
    }

    public void setStackSize(short size)
    {
        m_stackSize = size;
    }

    public static void setStackSize(long addrInst,short size)
    {
        BufferNative.setShort(addrInst,1,size); // El parámetro está en el byte 1 empezando desde cero
    }

    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_opcode);
        memIt.setShort(m_stackSize);
    }

    public int memorySize()
    {
        return 1 + 2;
    }

}
