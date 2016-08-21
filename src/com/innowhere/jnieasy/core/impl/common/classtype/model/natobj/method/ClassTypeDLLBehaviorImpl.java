/*
 * ClassTypeDLLMethodImpl.java
 *
 * Created on 15 de octubre de 2004, 20:48
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeDLLBehaviorRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;



public abstract class ClassTypeDLLBehaviorImpl extends ClassTypeNativeCapableImpl
{
    
    /**
     * Creates a new instance of ClassTypeDLLMethodImpl
     */
    public ClassTypeDLLBehaviorImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeDLLBehavior(ClassTypeManagerImpl mgr)
    {
        ClassTypeCPPConstructorImpl.registerClassTypeCPPConstructor(mgr);
        ClassTypeDLLMethodImpl.registerClassTypeDLLMethod(mgr);
        ClassTypeDLLFieldImpl.registerClassTypeDLLField(mgr);     
    }

    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeDLLBehaviorRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
