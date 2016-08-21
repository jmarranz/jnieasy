/*
 * Mov.java
 *
 * Created on 28 de enero de 2004, 20:31
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_64;

import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.*;
import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;


public class MovToReg64Const64 extends ASMInstruction
{

/*   bytecode           ASM  

    48 B8 Cte64           mov  rax,Cte64
    48 B9 Cte64           mov  rcx,Cte64
    48 BA Cte64           mov  rdx,Cte64
    48 BB Cte64           mov  rbx,Cte64 
    ...
    (48 es el prefijo REX.W)
*/
    protected static byte m_prefix = 0x48;    
    protected byte m_opcode;
    protected int m_reg;    
    protected long m_param; 
    
    /** Creates a new instance of Mov */
    public MovToReg64Const64(int reg, long param)
    {
        m_reg = reg;
        m_param = param;
        
        m_opcode = (byte)0xB8;
        m_opcode += reg;
    }

    public void setParam(int param)
    {
        m_param = param;
    }
    
    public static void setParam(long addrInst,long param)
    {
        BufferNative.setLong(addrInst,2,param); // El parámetro está en el byte 2 empezando desde cero
    }    
    
    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_prefix);        
        memIt.setByte(m_opcode);
        memIt.setLong(m_param);
    }
    
    public int memorySize()
    {
        return 1 + 1 + 8; 
    }    
}
