/*
 * ClassTypeNativeMethodCallbackDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 12:42
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeNativeMethodCallbackDefaultImpl extends ClassTypeNativeCallbackDefaultImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeMethodCallbackDefaultImpl 
     */
    public ClassTypeNativeMethodCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeMethodCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticMethodCallbackDefaultImpl.registerClassTypeNativeStaticMethodCallbackDefault(mgr);
        ClassTypeNativeInstanceMethodCallbackDefaultImpl.registerClassTypeNativeInstanceMethodCallbackDefault(mgr);   
    }  
}
