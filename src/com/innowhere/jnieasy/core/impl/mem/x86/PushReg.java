/*
 * Push.java
 *
 * Created on 29 de enero de 2004, 18:58
 */

package com.innowhere.jnieasy.core.impl.mem.x86;

import com.innowhere.jnieasy.core.impl.mem.ASMInstruction;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;

public class PushReg extends ASMInstruction
{
/* bytecode  ASM
    50          push eax
    51          push ecx
    52          push edx
    53          push ebx
    ...    
   Idem para los registros de 64 bit en modo 64 bit 
*/
    protected byte m_opcode;
    protected int m_reg; 
    
    /** Creates a new instance of Push */
    public PushReg(int reg)
    {
        m_reg = reg;
        m_opcode = 0x50;
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
