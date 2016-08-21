/*
 * Push.java
 *
 * Created on 29 de enero de 2004, 18:58
 */

package com.innowhere.jnieasy.core.impl.mem.x86;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class PopReg extends ASMInstruction
{
/* bytecode  ASM
    58          pop eax
    59          pop ecx
    5A          pop edx
    5B          pop ebx
    ...
   Idem para los registros de 64 bit en modo 64 bit   
*/
    protected byte m_opcode;
    protected int m_reg; 
    
    /** Creates a new instance of Push */
    public PopReg(int reg)
    {
        m_reg = reg;
        m_opcode = 0x58;
        m_opcode += reg;
    }
   
    public void compile(NativeBufferIteratorImpl memIt)
    {
        memIt.setByte(m_opcode);
    }
    
    public int memorySize()
    {
        return 1;
    }
}
