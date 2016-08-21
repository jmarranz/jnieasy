/*
 * Mov.java
 *
 * Created on 28 de enero de 2004, 20:31
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_32;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.jni.*;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;


public class MovToReg32Const32 extends ASMInstruction
{

/*   bytecode           ASM  

    B8 Cte32           mov         eax,Cte32
    B9 Cte32           mov         ecx,Cte32
    BA Cte32           mov         edx,Cte32
    BB Cte32           mov         ebx,Cte32 
    ...
*/
    protected byte m_opcode;
    protected int m_reg;    
    protected int m_param; 
    
    /** Creates a new instance of Mov */
    public MovToReg32Const32(int reg, int param)
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
    
    public static void setParam(int addrInst,int param)
    {
        BufferNative.setInt(addrInst,1,param); // El parámetro está en el byte 1 empezando desde cero
    }    
    
    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_opcode);
        memIt.setInt(m_param);
    }
    
    public int memorySize()
    {
        return 1 + 4;
    }    
}
