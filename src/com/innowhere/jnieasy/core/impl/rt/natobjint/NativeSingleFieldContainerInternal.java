/*
 * ObjectFieldContainerInternal.java
 *
 * Created on 29 de septiembre de 2005, 13:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjint;
import com.innowhere.jnieasy.core.data.NativeSingleFieldContainer;
import com.innowhere.jnieasy.core.mem.NativeStateManager;

/**
 *
 * @author jmarranz
 */
public interface NativeSingleFieldContainerInternal extends NativeSingleFieldContainer,NativeFieldContainerInternal
{
    public Object jnieasyGetInternalValue();
    public void jnieasySetInternalValue(Object obj);    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr);
    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr);        
}
