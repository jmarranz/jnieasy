/*
 * ClassTypeNativeSeparatedFieldContainerImpl.java
 *
 * Created on 13 de octubre de 2005, 19:08
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

import com.innowhere.jnieasy.core.data.NativeSeparatedFieldContainer;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeSeparatedFieldContainerImpl extends ClassTypeNativeMultipleFieldContainerImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeSeparatedFieldContainerImpl
     */
    public ClassTypeNativeSeparatedFieldContainerImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeSeparatedFieldContainer(ClassTypeManagerImpl mgr)
    {
        ClassTypeStructureImpl.registerClassTypeStructure(mgr);
        ClassTypeCPPClassImpl.registerClassTypeCPPClass(mgr);        
    }       
    
    public static ClassTypeNativeSeparatedFieldContainerImpl newCustomClassTypeSeparatedFieldContainer(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (ClassTypeStructureImpl.isAssignableFrom(valueClass))
            return ClassTypeStructureImpl.newClassTypeStructure(valueClass,ctx.getJNIEasy());
        else if (ClassTypeCPPClassImpl.isAssignableFrom(valueClass))
            return ClassTypeCPPClassImpl.newClassTypeCPPClass(valueClass,ctx.getJNIEasy());
        return null;
    }        
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeSeparatedFieldContainer.class,valueClass);
    }        
}
