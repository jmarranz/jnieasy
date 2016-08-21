/*
 * NativeFieldContainerInternal.java
 *
 * Created on 14 de septiembre de 2005, 12:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjint;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.data.NativeFieldContainer;

/**
 *
 * @author jmarranz
 */
public interface NativeFieldContainerInternal extends NativeCapableInternal,NativeFieldContainer
{
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr);
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr);        
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr);
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr);        
}
