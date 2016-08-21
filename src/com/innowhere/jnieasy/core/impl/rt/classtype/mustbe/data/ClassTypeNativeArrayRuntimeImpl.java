/*
 * ClassTypeNativeArrayRuntimeImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:20
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;



public abstract class ClassTypeNativeArrayRuntimeImpl extends ClassTypeCanBeNativeCapableRuntimeImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeArrayRuntimeImpl
     */
    public ClassTypeNativeArrayRuntimeImpl(ClassTypeNativeArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
        
    public static String getClassName(Class cls)
    {
        // Se supone que cls es un array normal Java
        // un simple Class.getName() no vale pues devuelve
        // el nombre en formato JNI.
        return ClassTypeNativeRuntimeImpl.getClassName(cls.getComponentType()) + "[]";
    }

    public ClassTypeNativeArrayImpl getClassTypeArray()
    {
        return (ClassTypeNativeArrayImpl)classType;
    }
    
    public ClassTypeNativeRuntimeImpl getClassTypeComponent()
    {
        ClassTypeNativeArrayImpl classType = getClassTypeArray();
        return classType.getComponentType().getClassTypeRuntime();  
    }
    
    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown array size");
    }        
    
    public int getLength(Object value)
    {
        return getClassTypeArray().getLength(value);
    }
    
    public abstract Object newArrayValue(int length);
}
