/*
 * ClassTypeNativeFieldContainerImpl.java
 *
 * Created on 14 de septiembre de 2005, 11:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

import com.innowhere.jnieasy.core.data.NativeFieldContainer;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeFieldContainerImpl extends ClassTypeNativeCapableImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeFieldContainerImpl
     */
    public ClassTypeNativeFieldContainerImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeFieldContainer(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeSingleFieldContainerImpl.registerClassTypeSingleFieldContainer(mgr);
        ClassTypeNativeMultipleFieldContainerImpl.registerClassTypeMultipleFieldContainer(mgr);      
    }
    
    public static ClassTypeNativeFieldContainerImpl newCustomClassTypeFieldContainer(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (ClassTypeNativeMultipleFieldContainerImpl.isAssignableFrom(valueClass))
            return ClassTypeNativeMultipleFieldContainerImpl.newCustomClassTypeMultipleFieldContainer(valueClass, ctx);
        else if (ClassTypeNativeSingleFieldContainerImpl.isAssignableFrom(valueClass))
            return ClassTypeNativeSingleFieldContainerImpl.newCustomClassTypeSingleFieldContainer(valueClass,ctx);
        return null;
    }        
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeFieldContainer.class,valueClass);
    }        
}
