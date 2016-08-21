/*
 * ClassTypeStructureRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 20:12
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeStructureImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeStructureRuntimeImpl extends ClassTypeNativeSeparatedFieldContainerRuntimeImpl
{
    
    /** Creates a new instance of ClassTypeStructureRuntimeImpl */
    public ClassTypeStructureRuntimeImpl(ClassTypeStructureImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
}
