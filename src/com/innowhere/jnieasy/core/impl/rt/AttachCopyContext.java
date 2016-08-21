/*
 * AttachCopyContext.java
 *
 * Created on 18 de agosto de 2005, 8:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;

/**
 *
 * @author jmarranz
 */
public class AttachCopyContext
{
    protected NativeCapableInternal fromObj;
    protected NativeCapableInternal toObj;
    
    /** Creates a new instance of AttachCopyContext */
    public AttachCopyContext(NativeCapableInternal fromObj,NativeCapableInternal toObj)
    {
        this.fromObj = fromObj;
        this.toObj = toObj;
    }
    
    public NativeCapableInternal fromObject()
    {
        return fromObj;
    }
    
    public NativeCapableInternal toObject()
    {
        return toObj;
    }    
}
