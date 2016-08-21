/*
 * ClassTypeStructureCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsStructureImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeStructureCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public class ClassTypeStructureCustomImpl extends ClassTypeStructureImpl implements ClassTypeCustomEnhanced
{
   
    /**
     * Creates a new instance of ClassTypeStructureCustomImpl 
     */
    public ClassTypeStructureCustomImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        this.className = className;
    }

    public static ClassTypeStructureCustomImpl newStructureCustomType(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeStructureCustomImpl(className,jniEasy.getClassTypeManager());
    }    
    
    public static ClassTypeStructureCustomImpl registerClassTypeStructureCustom(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeStructureCustomImpl classType = (ClassTypeStructureCustomImpl)mgr.findClassType(className);
        if (classType != null) return classType;
        
        classType = new ClassTypeStructureCustomImpl(className,mgr);
        classType.registerClassType();
        return classType;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeStructureCustomRuntimeImpl(this,rtMgr);
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
        return new JavaClassAsStructureImpl(this);
    }
}
