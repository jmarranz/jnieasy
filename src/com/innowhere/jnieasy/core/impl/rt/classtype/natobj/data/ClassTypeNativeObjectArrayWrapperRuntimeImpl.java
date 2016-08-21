/*
 * ClassTypeNativeObjectArrayWrapperRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 19:54
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeObjectArrayWrapperRuntimeImpl extends ClassTypeNativeArrayWrapperRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayWrapperRuntimeImpl
     */
    public ClassTypeNativeObjectArrayWrapperRuntimeImpl(ClassTypeNativeObjectArrayWrapperImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public static ClassTypeNativeObjectArrayWrapperImpl registerCustomObjectArrayWrapperType(Class containerClass,Class arrayClass,RuntimeContext ctx)
    {
        ClassTypeNativeObjectArrayWrapperImpl dataType = (ClassTypeNativeObjectArrayWrapperImpl)ctx.findClassType(containerClass.getName());
        if (dataType != null)
            return dataType; // Ya registrado (quizás durante el enhancement)
        
        // Caso de arrays
        Class componentClass = arrayClass.getComponentType();
        ClassTypeNativeImpl compType = ctx.getClassType(componentClass);
        if (componentClass.isArray())
            return ClassTypeNativeArrayOfArrayWrapperCustomImpl.registerClassTypeNativeArrayOfArrayWrapperCustom(containerClass.getName(),arrayClass.getName(),(ClassTypeNativeArrayImpl)compType,ctx.getJNIEasy());
        else
            return ClassTypeNativeCapableArrayWrapperCustomImpl.registerClassTypeNativeCapableArrayWrapperCustom(containerClass.getName(),arrayClass.getName(),(ClassTypeNativeCapableImpl)compType,ctx.getJNIEasy());
    }    
}
