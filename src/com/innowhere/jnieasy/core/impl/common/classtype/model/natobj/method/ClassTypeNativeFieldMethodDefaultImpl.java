/*
 * ClassTypeNativeFieldMethodDefaultImpl.java
 *
 * Created on 1 de abril de 2005, 12:42
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeNativeFieldMethodDefaultImpl extends ClassTypeNativeBehaviorDefaultImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeFieldMethodDefaultImpl 
     */
    public ClassTypeNativeFieldMethodDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeFieldMethodDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticFieldMethodDefaultImpl.registerClassTypeNativeStaticFieldMethodDefault(mgr);  
        ClassTypeNativeInstanceFieldMethodDefaultImpl.registerClassTypeNativeInstanceFieldMethodDefault(mgr);          
    } 
}
