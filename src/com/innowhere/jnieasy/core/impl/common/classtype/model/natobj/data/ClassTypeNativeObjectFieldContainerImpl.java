/*
 * ClassTypeNativeObjectFieldContainerImpl.java
 *
 * Created on 29 de septiembre de 2005, 13:09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

import com.innowhere.jnieasy.core.data.NativeObjectFieldContainer;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeObjectFieldContainerImpl extends ClassTypeNativeSingleFieldContainerImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeObjectFieldContainerImpl
     */
    public ClassTypeNativeObjectFieldContainerImpl(ClassTypeNativeObjectImpl fieldClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(fieldClassType,classTypeMgr);      
    }
    
    public static void registerClassTypeNativeObjectFieldContainer(ClassTypeManagerImpl mgr)
    {
        ClassTypeCanBeNativeCapableWrapperImpl.registerClassTypeCanBeNativeCapableWrapper(mgr);
        ClassTypeNativePointerImpl.registerClassTypeNativePointer(mgr);        
    }
    
    public static ClassTypeNativeObjectFieldContainerImpl newCustomClassTypeNativeObjectFieldContainer(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (ClassTypeCanBeNativeCapableWrapperImpl.isAssignableFrom(valueClass))
            return ClassTypeCanBeNativeCapableWrapperImpl.newCustomClassTypeCanBeNativeCapableWrapper(valueClass,ctx);            
        else if (ClassTypeNativePointerImpl.isAssignableFrom(valueClass))
            return ClassTypeNativePointerImpl.newCustomClassTypeNativePointer(valueClass,ctx);
        return null;
    }        
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeObjectFieldContainer.class,valueClass);
    }            
}
