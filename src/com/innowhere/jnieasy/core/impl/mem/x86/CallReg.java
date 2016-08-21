/*
 * Fld.java
 *
 * Created on 29 de enero de 2004, 19:46
 */

package com.innowhere.jnieasy.core.impl.mem.x86;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class CallReg extends ASMInstruction
{
/*
    http://www.governmentsecurity.org/archive/t12435.html
   
      bytecode           ASM  
    FF D0                call        eax
    FF D1                call        ecx
    FF D2                call        edx
    FF D3                call        ebx
    FF D4                call        esp
    FF D5                call        ebp
    FF D6                call        esi
    FF D7                call        edi
  
   Idem para los registros de 64 bit en modo 64 bit  
*/
    protected byte m_opcode1;
    protected byte m_opcode2;
    protected int m_reg;
    
    /** Creates a new instance of Fld */
    public CallReg(int reg)
    {
        m_reg = reg;
        m_opcode1 = (byte)0xFF;
        m_opcode2 = (byte)0xD0;
        m_opcode2 += reg;
    }
    
    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_opcode1); memIt.setByte(m_opcode2);
    }
    
    public int memorySize()
    {
        return 2;
    }
}
