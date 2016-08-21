/*
 * ClassTypeNativeDirectInstanceFieldCallbackCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCustomEnhanced;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;


public class ClassTypeNativeDirectInstanceFieldCallbackCustomImpl extends ClassTypeNativeDirectInstanceFieldCallbackImpl implements ClassTypeCustomEnhanced
{
  
    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceFieldCallbackCustomImpl
     */
    public ClassTypeNativeDirectInstanceFieldCallbackCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }   
        
    public static ClassTypeNativeDirectInstanceFieldCallbackCustomImpl registerClassTypeNativeDirectInstanceFieldCallbackCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeDirectInstanceFieldCallbackCustomImpl classType = (ClassTypeNativeDirectInstanceFieldCallbackCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeNativeDirectInstanceFieldCallbackCustomImpl(className,mgr);
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
    
    public static ClassTypeNativeDirectInstanceFieldCallbackCustomImpl newNativeDirectInstanceFieldCallbackCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeNativeDirectInstanceFieldCallbackCustomImpl(className,jniEasy.getClassTypeManager());
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeDirectInstanceFieldCallbackCustomRuntimeImpl(this,rtMgr);
    }      

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeDirectInstanceFieldCallbackImpl(this);
    }    

}
