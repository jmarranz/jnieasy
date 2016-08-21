/*
 * ClassTypeNativeSingleFieldContainerImpl.java
 *
 * Created on 7 de octubre de 2005, 12:13
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

import com.innowhere.jnieasy.core.data.NativeSingleFieldContainer;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeSingleFieldContainerImpl extends ClassTypeNativeFieldContainerImpl
{
    protected ClassTypeNativeImpl fieldClassType;
    
    /**
     * Creates a new instance of ClassTypeNativeSingleFieldContainerImpl
     */
    public ClassTypeNativeSingleFieldContainerImpl(ClassTypeNativeImpl fieldClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.fieldClassType = fieldClassType;  
    }
    
    public static void registerClassTypeSingleFieldContainer(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveWrapperImpl.registerClassTypeNativePrimitiveWrapper(mgr);                       
        ClassTypeNativeObjectFieldContainerImpl.registerClassTypeNativeObjectFieldContainer(mgr);
    }    
    
    public static ClassTypeNativeSingleFieldContainerImpl newCustomClassTypeSingleFieldContainer(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (ClassTypeNativeObjectFieldContainerImpl.isAssignableFrom(valueClass))
            return ClassTypeNativeObjectFieldContainerImpl.newCustomClassTypeNativeObjectFieldContainer(valueClass,ctx);           
        return null;
    }      
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeSingleFieldContainer.class,valueClass);
    }    
    
    public ClassTypeNativeImpl getFieldClassType()
    {
        return fieldClassType;
    }    
}
