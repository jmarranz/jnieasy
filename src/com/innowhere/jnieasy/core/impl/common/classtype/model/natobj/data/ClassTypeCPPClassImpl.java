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
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.CPPClassDefaultImpl;

/**
 *
 * @author  jmarranz
 */

public abstract class ClassTypeCPPClassImpl extends ClassTypeNativeSeparatedFieldContainerImpl
{
    
    /** Creates a new instance of MethodType */
    public ClassTypeCPPClassImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeCPPClass(ClassTypeManagerImpl mgr)
    {
        ClassTypeCPPClassDefaultImpl.registerClassTypeCPPClassDefault(mgr);       
    }
    
    public static ClassTypeCPPClassImpl newClassTypeCPPClass(MetaClassWrapper valueClass,JNIEasyImpl jniEasy)
    {
        return ClassTypeCPPClassCustomImpl.newCPPClassCustomType(valueClass.getName(),jniEasy);
    }   
 
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(CPPClass.class,valueClass);
    }    
}
