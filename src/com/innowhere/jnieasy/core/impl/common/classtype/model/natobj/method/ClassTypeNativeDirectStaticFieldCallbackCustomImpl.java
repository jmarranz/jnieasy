/*
 * ClassTypeNativeDirectStaticFieldCallbackCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectStaticFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectStaticFieldCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCustomEnhanced;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;



public class ClassTypeNativeDirectStaticFieldCallbackCustomImpl extends ClassTypeNativeDirectStaticFieldCallbackImpl implements ClassTypeCustomEnhanced
{

    /**
     * Creates a new instance of ClassTypeNativeDirectStaticFieldCallbackCustomImpl
     */
    public ClassTypeNativeDirectStaticFieldCallbackCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }
    
    public static ClassTypeNativeDirectStaticFieldCallbackCustomImpl registerClassTypeNativeDirectStaticFieldCallbackCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeDirectStaticFieldCallbackCustomImpl classType = (ClassTypeNativeDirectStaticFieldCallbackCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeNativeDirectStaticFieldCallbackCustomImpl(className,mgr);
        classType.registerClassType();
        return classType;
    }
    
    public static ClassTypeNativeDirectStaticFieldCallbackCustomImpl newNativeDirectStaticFieldCallbackCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeNativeDirectStaticFieldCallbackCustomImpl(className,jniEasy.getClassTypeManager());
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
        return new ClassTypeNativeDirectStaticFieldCallbackCustomRuntimeImpl(this,rtMgr);
    }      

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeDirectStaticFieldCallbackImpl(this);   
    }
      
}
