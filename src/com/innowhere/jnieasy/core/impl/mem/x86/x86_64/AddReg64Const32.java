/*
 * Mov.java
 *
 * Created on 28 de enero de 2004, 20:31
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_64;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class AddReg64Const32 extends ASMInstruction
{

/*
    El sumando no puede ser de 64 bits (max 32)
  
    bytecode           ASM  

    48 05 const32       add         rax,const32
    48 81 C1 const32    add         rcx,const32
    ...
    48 81 C7 const32    add         rdi,const32 

    (48 es el prefijo REX.W)  
*/
    
    protected static byte m_prefix = 0x48;     
    protected byte m_opcode1;
    protected byte m_opcode2;    
    protected int m_reg;    
    protected int m_param; 
    
    /** Creates a new instance of Mov */
    public AddReg64Const32(int reg, int param)
    {
        m_reg = reg;
        m_param = param;
        
        if (reg == Register64.RAX) m_opcode1 = (byte)0x05;
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
        memIt.setByte(m_prefix);          
        memIt.setByte(m_opcode1);
        if (m_reg != Register64.RAX)
            memIt.setByte(m_opcode2);
        memIt.setInt(m_param);
    }
    
    public int memorySize()
    {
        if (m_reg == Register64.RAX)
            return 1 + 1 + 4;
        else           
            return 1 + 2 + 4;
    }    
}
