/*
 * ClassTypeDLLMethodImpl.java
 *
 * Created on 1 de abril de 2005, 12:42
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeDLLMethodImpl extends ClassTypeDLLBehaviorImpl
{
    
    /**
     * Creates a new instance of ClassTypeDLLMethodImpl
     */
    public ClassTypeDLLMethodImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeDLLMethod(ClassTypeManagerImpl mgr)
    {
        ClassTypeCMethodImpl.registerClassTypeCMethod(mgr);
        ClassTypeCPPMethodImpl.registerClassTypeCPPMethod(mgr);   
    }    
}
