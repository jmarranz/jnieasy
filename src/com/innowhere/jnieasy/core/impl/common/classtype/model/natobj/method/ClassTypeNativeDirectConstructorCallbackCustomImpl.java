/*
 * ClassTypeNativeDirectConstructorCallbackCustomImpl.java
 *
 * Created on 8 de julio de 2005, 11:27
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeDirectConstructorCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCustomEnhanced;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectConstructorCallbackCustomImpl extends ClassTypeNativeDirectConstructorCallbackImpl implements ClassTypeCustomEnhanced
{
    /**
     * Creates a new instance of ClassTypeNativeDirectConstructorCallbackCustomImpl
     */
    public ClassTypeNativeDirectConstructorCallbackCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }
    
    public static ClassTypeNativeDirectConstructorCallbackCustomImpl registerClassTypeNativeDirectConstructorCallbackCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeDirectConstructorCallbackCustomImpl classType = (ClassTypeNativeDirectConstructorCallbackCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeNativeDirectConstructorCallbackCustomImpl(className,mgr);
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
    
    public static ClassTypeNativeDirectConstructorCallbackCustomImpl newNativeDirectConstructorCallbackCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeNativeDirectConstructorCallbackCustomImpl(className,jniEasy.getClassTypeManager());
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeDirectConstructorCallbackCustomRuntimeImpl(this,rtMgr);
    }  

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeDirectConstructorCallbackImpl(this);
    }          

}
