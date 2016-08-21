/*
 * Mov.java
 *
 * Created on 28 de enero de 2004, 20:31
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_32;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class AddReg32Const32 extends ASMInstruction
{

/*   bytecode           ASM  

    05 const32       add         eax,const32
    81 C1 const32    add         ecx,const32
    ...
    81 C7 const32    add         edi,const32 
*/
    
    protected byte m_opcode1;
    protected byte m_opcode2;    
    protected int m_reg;    
    protected int m_param; 
    
    /** Creates a new instance of Mov */
    public AddReg32Const32(int reg, int param)
    {
        m_reg = reg;
        m_param = param;
        
        if (reg == Register32.EAX) m_opcode1 = (byte)0x05;
        else 
        {
            m_opcode1 = (byte)0x81;
            m_opcode2 = (byte)0xC0;
            m_opcode2 += reg;
        }
    }

    public void setParam(int param)
    {
        m_param = param;
    }
    
    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_opcode1);
        if (m_reg != Register32.EAX)
            memIt.setByte(m_opcode2);
        memIt.setInt(m_param);
    }
    
    public int memorySize()
    {
        if (m_reg == Register32.EAX)
            return 1 + 4;
        else           
            return 2 + 4;
    }    
}
