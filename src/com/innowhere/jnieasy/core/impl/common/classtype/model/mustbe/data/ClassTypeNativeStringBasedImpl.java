/*
 * ClassTypeNativeStringBasedImpl.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeStringBasedRuntimeImpl;

public abstract class ClassTypeNativeStringBasedImpl extends ClassTypeCanBeNativeCapableImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedImpl
     */
    public ClassTypeNativeStringBasedImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeStringBased(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringImpl.registerClassTypeString(mgr);        
        ClassTypeNativeStringBufferImpl.registerClassTypeStringBuffer(mgr); 
    }       
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeStringBasedRuntimeImpl(this,rtMgr);
    }        
}
