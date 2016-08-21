/*
 * ClassTypeDLLFieldImpl.java
 *
 * Created on 1 de abril de 2005, 12:42
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;


public abstract class ClassTypeDLLFieldImpl extends ClassTypeDLLBehaviorImpl
{
    
    /**
     * Creates a new instance of ClassTypeDLLFieldImpl
     */
    public ClassTypeDLLFieldImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeDLLField(ClassTypeManagerImpl mgr)
    {
        ClassTypeCFieldMethodImpl.registerClassTypeCFieldMethod(mgr);  
    }    
}
