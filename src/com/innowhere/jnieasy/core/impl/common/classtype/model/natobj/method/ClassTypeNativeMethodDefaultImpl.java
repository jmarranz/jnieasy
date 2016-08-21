/*
 * ClassTypeNativeMethodDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 12:42
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeNativeMethodDefaultImpl extends ClassTypeNativeBehaviorDefaultImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeMethodDefaultImpl 
     */
    public ClassTypeNativeMethodDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeMethodDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticMethodDefaultImpl.registerClassTypeNativeStaticMethodDefault(mgr);
        ClassTypeNativeInstanceMethodDefaultImpl.registerClassTypeNativeInstanceMethodDefault(mgr);   
    }  
}
