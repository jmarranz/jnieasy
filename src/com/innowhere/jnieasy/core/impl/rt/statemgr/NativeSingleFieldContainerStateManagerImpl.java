/*
 * NativeSingleFieldContainerStateManagerImpl.java
 *
 * Created on 7 de octubre de 2005, 12:43
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.impl.rt.NativeTransactionImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeSingleFieldContainerInternal;


/**
 *
 * @author jmarranz
 */
public abstract class NativeSingleFieldContainerStateManagerImpl extends NativeFieldContainerStateManagerImpl
{   
    /**
     * Creates a new instance of NativeSingleFieldContainerStateManagerImpl
     */
    public NativeSingleFieldContainerStateManagerImpl()
    {
    }    
    
    public NativeSingleFieldContainerInternal getSingleFieldContainerInternal()
    {
        return (NativeSingleFieldContainerInternal)value;
    }
        
  
}
