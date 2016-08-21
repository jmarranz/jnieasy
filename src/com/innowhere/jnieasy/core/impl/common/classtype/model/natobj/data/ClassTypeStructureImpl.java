/*
 * ClassTypeStructureImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;

public abstract class ClassTypeStructureImpl extends ClassTypeNativeSeparatedFieldContainerImpl
{
    
    /** Creates a new instance of ClassTypeStructureImpl */
    public ClassTypeStructureImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeStructure(ClassTypeManagerImpl mgr)
    {
        ClassTypeStructureDefaultImpl.registerClassTypeStructureDefault(mgr);
    }   
    
    public static ClassTypeStructureImpl newClassTypeStructure(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeStructureCustomImpl.newStructureCustomType(valueClass.getName(),jniEasy);
    }    

    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(Structure.class,valueClass);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
