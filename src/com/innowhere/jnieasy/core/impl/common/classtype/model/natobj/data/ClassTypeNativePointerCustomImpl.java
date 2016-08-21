/*
 * ClassTypeNativePointerCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 11:04
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePointerCustomRuntimeImpl;

public class ClassTypeNativePointerCustomImpl extends ClassTypeNativePointerImpl implements ClassTypeCustomEnhanced
{
    protected String containerClassName;
            
    /**
     * Creates a new instance of ClassTypeNativePointerCustomImpl
     */
    public ClassTypeNativePointerCustomImpl(String containerClassName,ClassTypeNativeObjectImpl addressedType,ClassTypeManagerImpl classTypeMgr)
    {
        super(addressedType,classTypeMgr);
        
        this.containerClassName = containerClassName;        
    }
    
    public static ClassTypeNativePointerCustomImpl newClassTypeNativePointerCustomType(String containerClassName,ClassTypeNativeObjectImpl addressedType,JNIEasyImpl jniEasy)
    { 
        return new ClassTypeNativePointerCustomImpl(containerClassName,addressedType,jniEasy.getClassTypeManager());
    }

    public static ClassTypeNativePointerCustomImpl registerClassTypeNativePointerCustom(String containerClassName,ClassTypeNativeObjectImpl addressedType,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativePointerCustomImpl classType = (ClassTypeNativePointerCustomImpl)mgr.findClassType(containerClassName);
        if (classType != null) return classType;
        
        classType = newClassTypeNativePointerCustomType(containerClassName,addressedType,jniEasy);
        classType.registerClassType();
        return classType;
    }
    
    public String getVMClassName()
    {
        return containerClassName;
    }     
    
    public String getVMClassImplName()
    {
        return containerClassName;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativePointerCustomRuntimeImpl(this,rtMgr);
    }

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativePointerImpl(this);
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativePointerCustomImpl(this);
    }        
}
