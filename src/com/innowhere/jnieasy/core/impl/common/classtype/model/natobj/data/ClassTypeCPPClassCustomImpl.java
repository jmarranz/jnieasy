/*
 * ClassTypeCPPClassCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsCPPClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeCPPClassCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public class ClassTypeCPPClassCustomImpl extends ClassTypeCPPClassImpl implements ClassTypeCustomEnhanced
{
   
    /**
     * Creates a new instance of ClassTypeCPPClassCustomImpl 
     */
    public ClassTypeCPPClassCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }

    public static ClassTypeCPPClassCustomImpl newCPPClassCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeCPPClassCustomImpl(className,jniEasy.getClassTypeManager());
    }
    
    public static ClassTypeCPPClassCustomImpl registerClassTypeCPPClassCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeCPPClassCustomImpl classType = (ClassTypeCPPClassCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeCPPClassCustomImpl(className,mgr);
        classType.registerClassType();
        return classType;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeCPPClassCustomRuntimeImpl(this,rtMgr);
    }    
    
    public String getVMClassName()
    {
        return className;
    } 
    
    public String getVMClassImplName()
    {
        return className;
    }
    
    
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsCPPClassImpl(this);
    }
}
