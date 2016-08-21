/*
 * ClassTypeNativeDirectStaticMethodCallbackCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectStaticMethodCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectStaticMethodCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCustomEnhanced;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;




public class ClassTypeNativeDirectStaticMethodCallbackCustomImpl extends ClassTypeNativeDirectStaticMethodCallbackImpl implements ClassTypeCustomEnhanced
{
   
    /**
     * Creates a new instance of ClassTypeNativeDirectStaticMethodCallbackCustomImpl
     */
    public ClassTypeNativeDirectStaticMethodCallbackCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }
    
    public static ClassTypeNativeDirectStaticMethodCallbackCustomImpl registerClassTypeNativeDirectStaticMethodCallbackCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeDirectStaticMethodCallbackCustomImpl classType = (ClassTypeNativeDirectStaticMethodCallbackCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeNativeDirectStaticMethodCallbackCustomImpl(className,mgr);
        classType.registerClassType();
        return classType;
    }
    
    public static ClassTypeNativeDirectStaticMethodCallbackCustomImpl newNativeDirectStaticMethodCallbackCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeNativeDirectStaticMethodCallbackCustomImpl(className,jniEasy.getClassTypeManager());
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
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeDirectStaticMethodCallbackCustomRuntimeImpl(this,rtMgr);
    }      

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeDirectStaticMethodCallbackImpl(this);
    }
            
}
