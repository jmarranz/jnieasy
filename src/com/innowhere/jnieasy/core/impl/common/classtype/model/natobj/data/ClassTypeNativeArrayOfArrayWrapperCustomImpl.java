/*
 * ClassTypeNativeArrayOfArrayWrapperImpl.java
 *
 * Created on 3 de diciembre de 2004, 11:04
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeArrayOfArrayWrapperCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectArrayWrapperRuntimeImpl;

public class ClassTypeNativeArrayOfArrayWrapperCustomImpl extends ClassTypeNativeArrayOfArrayWrapperImpl implements ClassTypeCustomEnhanced
{
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayWrapperImpl
     */
    public ClassTypeNativeArrayOfArrayWrapperCustomImpl(String className, ClassTypeNativeArrayOfArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr)
    {
        super(wrappedType,classTypeMgr,true);
        
        this.className = className;
    }   
   
    public static ClassTypeNativeArrayOfArrayWrapperCustomImpl newClassTypeNativeArrayOfArrayWrapperCustom(String containerClassName,String arrayClassName,ClassTypeNativeArrayImpl compType,JNIEasyImpl jniEasy)
    {
        ClassTypeNativeArrayOfArrayImpl wrappedType = new ClassTypeNativeArrayOfArrayImpl(arrayClassName,compType);
        return new ClassTypeNativeArrayOfArrayWrapperCustomImpl(containerClassName,wrappedType,jniEasy.getClassTypeManager()); 
    }
    
    // Es llamada desde la clase del usuario enhanced (contenedora de un array) 
    public static ClassTypeNativeArrayOfArrayWrapperCustomImpl registerClassTypeNativeArrayOfArrayWrapperCustom(String containerClassName,String arrayClassName,ClassTypeNativeArrayImpl compType,JNIEasyImpl jniEasy)
    {
        ClassTypeManagerImpl mgr = jniEasy.getClassTypeManager();
        ClassTypeNativeArrayOfArrayWrapperCustomImpl classType = (ClassTypeNativeArrayOfArrayWrapperCustomImpl)mgr.findClassType(containerClassName);
        if (classType != null) return classType;
        
        classType = newClassTypeNativeArrayOfArrayWrapperCustom(containerClassName,arrayClassName,compType,jniEasy); 
        classType.registerClassType();
  
// Si se quisiera que fuera el gestor wrapper por defecto del tipo Java
//classType.getClassTypeNativeArrayOfArray().registerClassType(true);        
        
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

    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeArrayOfArrayWrapperCustomRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeArrayOfArrayWrapperImpl(this);
    }    

    public TypeNativeImpl newTypeNative()
    {
        TypeNativeObjectArrayWrapperImpl typeDec = (TypeNativeObjectArrayWrapperImpl)super.newTypeNative();
        
        JavaClassAsNativeObjectArrayWrapperRuntimeImpl.copyDimensionsTo(this,typeDec);
        
        return typeDec;
    }    

    public TypeCanBeNativeCapableWrapperImpl newTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableImpl typeDecWrapped)
    {
        TypeNativeObjectArrayWrapperImpl typeDec = (TypeNativeObjectArrayWrapperImpl)super.newTypeCanBeNativeCapableWrapper(typeDecWrapped);
        
        JavaClassAsNativeObjectArrayWrapperRuntimeImpl.copyDimensionsTo(this,typeDec);
        
        return typeDec;
    }     
    
}
