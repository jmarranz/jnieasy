/*
 * ClassTypeNativePointerImpl.java
 *
 * Created on 23 de septiembre de 2005, 17:37
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

import com.innowhere.jnieasy.core.data.NativePointer;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativePointerEnhancer;


/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativePointerImpl extends ClassTypeNativeObjectFieldContainerImpl
{
    /**
     * Creates a new instance of ClassTypeNativePointerImpl
     */
    public ClassTypeNativePointerImpl(ClassTypeNativeObjectImpl fieldClassType,ClassTypeManagerImpl classTypeMgr)
    {
        super(fieldClassType,classTypeMgr);
    }
    
    public static void registerClassTypeNativePointer(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePointerDefaultImpl.registerClassTypeNativePointerDefault(mgr);                       
    }
    
    public static MetaClassWrapper getMetaClassCandidatePointerField(MetaClassWrapper valueClass)
    {
        MetaFieldWrapper field = JavaClassAsNativePointerEnhancer.getCandidatePointerField(valueClass);
        return field.getType();
    }    
    
    public static ClassTypeNativePointerImpl newCustomClassTypeNativePointer(MetaClassWrapper valueClass,TaskContext ctx)
    {
        // PROBABLEMENTE NO PASE POR AQUI NUNCA
        // EN EL FUTURO SE ELIMINARA
       
        MetaClassWrapper fieldClass = getMetaClassCandidatePointerField(valueClass);
        ClassTypeNativeObjectImpl pointerClassType = (ClassTypeNativeObjectImpl)ctx.getClassType(fieldClass);
      
        return ClassTypeNativePointerCustomImpl.newClassTypeNativePointerCustomType(valueClass.getName(),pointerClassType,ctx.getJNIEasy());
    }        
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativePointer.class,valueClass);
    }       
    
    public ClassTypeNativeObjectImpl getAddressedClassTypeNativeObject()
    {
        return (ClassTypeNativeObjectImpl)fieldClassType;
    }

}
