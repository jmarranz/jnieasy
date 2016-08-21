/*
 * ClassTypeUnionCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsUnionImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeUnionCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public class ClassTypeUnionCustomImpl extends ClassTypeUnionImpl implements ClassTypeCustomEnhanced
{
   
    /**
     * Creates a new instance of ClassTypeUnionCustomImpl 
     */
    public ClassTypeUnionCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }

    public static ClassTypeUnionCustomImpl newUnionCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeUnionCustomImpl(className,jniEasy.getClassTypeManager());
    }
    
    public static ClassTypeUnionCustomImpl registerClassTypeUnionCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeUnionCustomImpl classType = (ClassTypeUnionCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeUnionCustomImpl(className,mgr);
        classType.registerClassType();
        return classType;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeUnionCustomRuntimeImpl(this,rtMgr);
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
        return new JavaClassAsUnionImpl(this);
    }
}
