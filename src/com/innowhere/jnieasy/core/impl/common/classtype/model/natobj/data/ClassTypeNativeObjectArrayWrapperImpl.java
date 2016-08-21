/*
 * ClassTypeNativeObjectArrayWrapperImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.MetaFieldWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectArrayWrapperEnhancer;


public abstract class ClassTypeNativeObjectArrayWrapperImpl extends ClassTypeNativeArrayWrapperImpl
{
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayWrapperImpl
     */
    public ClassTypeNativeObjectArrayWrapperImpl(ClassTypeNativeObjectArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }
    
    public static void registerClassTypeNativeObjectArrayWrapper(ClassTypeManagerImpl mgr)
    {
        ClassTypeCanBeNativeCapableArrayWrapperImpl.registerClassTypeCanBeNativeCapableArrayWrapper(mgr);
        ClassTypeNativeCapableArrayWrapperImpl.registerClassTypeNativeCapableArrayWrapper(mgr);
        ClassTypeNativeObjectArrayWrapperDefaultImpl.registerClassTypeNativeObjectArrayWrapperDefault(mgr);
    }
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeObjectArray.class,valueClass);
    }
    
    public static MetaClassWrapper getMetaClassCandidateArrayField(MetaClassWrapper clasz)
    {
        // útil para arrays custom
        MetaFieldWrapper field = JavaClassAsNativeObjectArrayWrapperEnhancer.getCandidateArrayField(clasz);
        return field.getType();
    }        
    
    public static ClassTypeNativeObjectArrayWrapperImpl newCustomClassTypeNativeObjectArrayWrapper(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (!valueClass.isInterface())
        {        
            // PROBABLEMENTE NO PASE POR AQUI NUNCA
            // EN EL FUTURO SE ELIMINARA
            
            MetaClassWrapper fieldClass = getMetaClassCandidateArrayField(valueClass);
            
            ClassTypeNativeObjectArrayImpl arrayCompType = (ClassTypeNativeObjectArrayImpl)ctx.getClassType(fieldClass);
            ClassTypeNativeImpl compType = arrayCompType.getArrayInfo().getComponentType();
            String arrayClassName = arrayCompType.getVMClassImplName();
            
            // Será una clase: ClassTypeCustomNativeCapableArrayImpl o ClassTypeNativeArrayOfArrayImpl
            // porque los demás arrays están registrados desde el principio y no pasarían por aquí
            if (ClassTypeNativeCapableArrayWrapperImpl.isAssignableFrom(valueClass))
                return ClassTypeNativeCapableArrayWrapperImpl.newCustomClassTypeNativeCapableArrayWrapper(valueClass,arrayClassName, (ClassTypeNativeCapableImpl)compType,ctx.getJNIEasy());
            else if (ClassTypeCanBeNativeCapableArrayWrapperImpl.isAssignableFrom(valueClass))
                return ClassTypeCanBeNativeCapableArrayWrapperImpl.newCustomClassTypeCanBeNativeCapableArrayWrapper(valueClass,arrayClassName,(ClassTypeCanBeNativeCapableImpl)compType,ctx.getJNIEasy());
        }
        else if (NativeArrayOfArray.class.getName().equals(valueClass.getName()))
        {
            return ClassTypeNativeArrayOfArrayWrapperDefaultImpl.newClassTypeNativeArrayOfArrayWrapperDefault(ctx);
        }
        else
        {
            throw new JNIEasyException("Not valid as type declaration : " + valueClass.getName());
        }
        
        return null;
    }

}
