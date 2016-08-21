/*
 * ClassTypeNativeFieldCallbackDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 12:42
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeNativeFieldCallbackDefaultImpl extends ClassTypeNativeCallbackDefaultImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeFieldCallbackDefaultImpl 
     */
    public ClassTypeNativeFieldCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeFieldCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticFieldCallbackDefaultImpl.registerClassTypeNativeStaticFieldCallbackDefault(mgr);  
        ClassTypeNativeInstanceFieldCallbackDefaultImpl.registerClassTypeNativeInstanceFieldCallbackDefault(mgr);          
    } 
}
