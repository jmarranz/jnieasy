/*
 * CallbackMachineCodeImpl.java
 *
 * Created on 28 de enero de 2004, 20:24
 */

package com.innowhere.jnieasy.core.impl.mem;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.jni.JNIEasyNative;
import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.CallbackMachineCodeX86_32;
import com.innowhere.jnieasy.core.impl.mem.x86.x86_64.CallbackMachineCodeX86_64;
import java.util.*;

public abstract class CallbackMachineCodeImpl implements CallbackMachineCode
{
    protected List m_instruc = new ArrayList();
    protected int m_memorySize = 0;
    
    /**
     * Creates a new instance of CallbackMachineCodeImpl
     */
    public CallbackMachineCodeImpl()
    {
    }
    
    public static CallbackMachineCodeImpl createMachineCode()
    {
        // Por ahora solo x86
        if (JNIEasyNative.getPlatformAddressSize() == 4)
            return CallbackMachineCodeX86_32.createCallbackMachineCodeX86_32();          
        else
            return CallbackMachineCodeX86_64.createCallbackMachineCodeX86_64();        
    }
    
    public void addInstruction(ASMInstruction inst)
    {
        m_instruc.add(inst);
        m_memorySize += inst.memorySize();
    }
    
    public ASMInstruction getInstruction(int index)
    {
        return (ASMInstruction)m_instruc.get(index);
    }
/*    
    public int getRelativeAddressEnd(int index)
    {
        int pos = 0;
        for (int i=0; i <= index; i++ )
        {
            ASMInstruction inst = (ASMInstruction)m_instruc.get(i);
            pos += inst.memorySize();
        }
        return pos;
    }
*/    
    public void compile(NativeBufferIteratorImpl memIt)
    {
        for (int i=0; i < m_instruc.size(); i++ )
        {
            ASMInstruction inst = (ASMInstruction)m_instruc.get(i);
            inst.compile(memIt);
        }
    }
    
    public long memorySize()
    {
        return m_memorySize;
    }    
    
    public int memorySize32()
    {
        return m_memorySize;
    }
}
