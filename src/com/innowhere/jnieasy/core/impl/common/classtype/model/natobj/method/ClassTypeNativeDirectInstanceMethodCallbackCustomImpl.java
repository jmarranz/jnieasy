/*
 * ClassTypeNativeDirectInstanceMethodCallbackCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectInstanceMethodCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCustomEnhanced;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;



public class ClassTypeNativeDirectInstanceMethodCallbackCustomImpl extends ClassTypeNativeDirectInstanceMethodCallbackImpl implements ClassTypeCustomEnhanced
{

    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceMethodCallbackCustomImpl
     */
    public ClassTypeNativeDirectInstanceMethodCallbackCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }   
        
    public static ClassTypeNativeDirectInstanceMethodCallbackCustomImpl registerClassTypeNativeDirectInstanceMethodCallbackCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeDirectInstanceMethodCallbackCustomImpl classType = (ClassTypeNativeDirectInstanceMethodCallbackCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeNativeDirectInstanceMethodCallbackCustomImpl(className,mgr);
        classType.registerClassType();
        return classType;
    }
    
    public String getVMClassName()
    {
        return className;
    }    
    
    public String getVMClassImplName()
    {
        return className;
    }
    
    public boolean isCustom()
    {
        return true;
    }
    
    public static ClassTypeNativeDirectInstanceMethodCallbackCustomImpl newNativeDirectInstanceMethodCallbackCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeNativeDirectInstanceMethodCallbackCustomImpl(className,jniEasy.getClassTypeManager());
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeDirectInstanceMethodCallbackCustomRuntimeImpl(this,rtMgr);
    }      

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeDirectInstanceMethodCallbackImpl(this);
    }    

}
