/*
 * ClassTypeNativeArrayOfArrayWrapperImpl.java
 *
 * Created on 3 de diciembre de 2004, 11:04
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeArrayOfArrayWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeArrayOfArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;




public class ClassTypeNativeArrayOfArrayWrapperDefaultImpl extends ClassTypeNativeArrayOfArrayWrapperImpl
{
    public static final Class INTERFACE = NativeArrayOfArray.class;
    public static final Class CLASS = NativeArrayOfArrayDefaultImpl.class;    

    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayWrapperImpl
     */
    public ClassTypeNativeArrayOfArrayWrapperDefaultImpl(ClassTypeNativeArrayOfArrayImpl wrappedType,ClassTypeManagerImpl classTypeMgr,boolean isDefault)
    {
        super(wrappedType,classTypeMgr,isDefault);
    }    
    
    public static void registerClassTypeNativeArrayOfArrayWrapperDefault(ClassTypeManagerImpl mgr)
    {
        // Nada que registrar pues es incompleto
    }     

    public static ClassTypeNativeArrayOfArrayWrapperDefaultImpl newClassTypeNativeArrayOfArrayWrapperDefault(TaskContext ctx)
    {
        // ojo es incompleto
        return new ClassTypeNativeArrayOfArrayWrapperDefaultImpl(null,ctx.getClassTypeManager(),false);
    }
    
    public void registerClassType()
    {
        // Impide el registro por si acaso
    }    
    
    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 

    public String getVMClassImplName()
    {
        return CLASS.getName();
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeArrayOfArrayWrapperDefaultRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     


}
