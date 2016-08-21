/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;


/**
 *
 * @author  jmarranz
 */

public abstract class ClassTypeUnionImpl extends ClassTypeNativeMultipleFieldContainerImpl
{
    
    /** Creates a new instance of MethodType */
    public ClassTypeUnionImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeUnion(ClassTypeManagerImpl mgr)
    {
        ClassTypeUnionDefaultImpl.registerClassTypeUnionDefault(mgr);       
    }
    
    public static ClassTypeUnionImpl newClassTypeUnion(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeUnionCustomImpl.newUnionCustomType(valueClass.getName(),jniEasy);
    }   
 
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(Union.class,valueClass);
    }    
}
