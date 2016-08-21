/*
 * CallbackMachineCode.java
 *
 * Created on 18 de enero de 2006, 8:56
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.mem;

import com.innowhere.jnieasy.core.mem.NativeBuffer;

/**
 *
 * @author jmarranz
 */
public interface CallbackMachineCode
{
    public void compile(NativeBuffer buff,long mgrAddress,long funcAddress,long stackSizeParams);
    public long memorySize();
}
