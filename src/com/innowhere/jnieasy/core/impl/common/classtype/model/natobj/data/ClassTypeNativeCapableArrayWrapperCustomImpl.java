/*
 * ClassTypeNativeCapableArrayWrapperCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 11:04
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayCustomImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableArrayWrapperCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectArrayWrapperRuntimeImpl;

public class ClassTypeNativeCapableArrayWrapperCustomImpl extends ClassTypeNativeCapableArrayWrapperImpl implements ClassTypeCustomEnhanced
{
    protected String containerClassName;
            
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayWrapperCustomImpl
     */
    public ClassTypeNativeCapableArrayWrapperCustomImpl(String containerClassName,ClassTypeNativeCapableArrayCustomImpl wrappedType,ClassTypeManagerImpl classTypeMgr)
    {
        super(wrappedType,classTypeMgr,true);
        
        this.containerClassName = containerClassName;
    }
    
    public static ClassTypeNativeCapableArrayWrapperCustomImpl newClassTypeNativeCapableArrayWrapperCustom(String containerClassName,String arrayClassName,ClassTypeNativeCapableImpl compType,JNIEasyImpl jniEasy)
    {
        ClassTypeNativeCapableArrayCustomImpl wrappedType = new ClassTypeNativeCapableArrayCustomImpl(arrayClassName,compType);    
        return new ClassTypeNativeCapableArrayWrapperCustomImpl(containerClassName,wrappedType,jniEasy.getClassTypeManager());        
    }

    public static ClassTypeNativeCapableArrayWrapperCustomImpl registerClassTypeNativeCapableArrayWrapperCustom(String containerClassName,String arrayClassName,ClassTypeNativeCapableImpl compType,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeCapableArrayWrapperCustomImpl classType = (ClassTypeNativeCapableArrayWrapperCustomImpl)mgr.findClassType(containerClassName);
        if (classType != null) return classType;
        
        classType = newClassTypeNativeCapableArrayWrapperCustom(containerClassName,arrayClassName,compType,jniEasy);
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
        return new ClassTypeNativeCapableArrayWrapperCustomRuntimeImpl(this,rtMgr);
    }

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeCapableArrayWrapperImpl(this);
    }
    
    public TypeNativeImpl newTypeNative()
    {
        TypeNativeObjectArrayWrapperImpl typeDec = (TypeNativeObjectArrayWrapperImpl)super.newTypeNative();
        
        JavaClassAsNativeObjectArrayWrapperRuntimeImpl.copyDimensionsTo(this,typeDec);

        return typeDec;
    }    
}
