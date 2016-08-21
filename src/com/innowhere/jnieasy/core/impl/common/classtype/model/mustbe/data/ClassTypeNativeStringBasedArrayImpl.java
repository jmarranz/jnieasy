/*
 * ClassTypeNativeStringBasedImpl.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeStringBasedArrayRuntimeImpl;


public abstract class ClassTypeNativeStringBasedArrayImpl extends ClassTypeCanBeNativeCapableArrayImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedImpl
     */
    public ClassTypeNativeStringBasedArrayImpl(ClassTypeNativeStringBasedImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativeStringBasedArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStringArrayImpl.registerClassTypeNativeStringArray(mgr);        
        ClassTypeNativeStringBufferArrayImpl.registerClassTypeNativeStringBufferArray(mgr);         
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeStringBasedArrayRuntimeImpl(this,rtMgr);
    }    
}
