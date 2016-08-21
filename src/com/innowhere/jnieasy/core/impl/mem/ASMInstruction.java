/*
 * ASMInstruction.java
 *
 * Created on 28 de enero de 2004, 20:26
 */

package com.innowhere.jnieasy.core.impl.mem;


public abstract class ASMInstruction
{
    
    /** Creates a new instance of ASMInstruction */
    public ASMInstruction()
    {
    }
    
    public abstract void compile(NativeBufferIteratorImpl memIt);
    public abstract int memorySize();
}
