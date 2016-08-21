/*
 * CanBeNativeCapableInternal.java
 *
 * Created on 22 de julio de 2005, 17:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjint;

import com.innowhere.jnieasy.core.data.CanBeNativeCapable;
import com.innowhere.jnieasy.core.mem.NativeStateManager;



/**
 *
 * @author jmarranz
 */
public interface CanBeNativeCapableInternal extends CanBeNativeCapable,NativeObjectFieldContainerInternal
{
    public boolean jnieasyIsFixedSize();
    public void jnieasySetValue(Object newValue,NativeStateManager stateMgr);  
    public Object jnieasyNewWrappedValue();
    public Object jnieasyCloneValue(Object valueToClone,Object cloneCtx,NativeStateManager stateMgr);
}
