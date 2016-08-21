/*
 * Mov.java
 *
 * Created on 28 de enero de 2004, 20:31
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_32;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class MovToReg32Reg32 extends ASMInstruction
{

/*   bytecode           ASM  

    8B C0                mov         eax,eax
    ...
    8B C7                mov         eax,edi

    8B C8                mov         ecx,eax
    ...
    8B CF                mov         ecx,edi

    8B D0                mov         edx,eax
    ...
    8B D7                mov         edx,edi
    ...
*/
    protected byte m_opcode1;
    protected byte m_opcode2;    
    protected int m_reg1;    
    protected int m_reg2;    
    protected int m_param; 
    
    /** Creates a new instance of Mov */
    public MovToReg32Reg32(int reg1, int reg2)
    {
        m_reg1 = reg1;
        m_reg2 = reg2;        
        
        m_opcode1 = (byte)0x8B;
        m_opcode2 = (byte)0xC0;
        m_opcode2 += 8*reg1; 
        m_opcode2 += reg2;
    }
   
    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_opcode1);
        memIt.setByte(m_opcode2);
    }
    
    public int memorySize()
    {
        return 2;
    }    
}
