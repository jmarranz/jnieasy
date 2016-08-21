/*
 * ClassTypeNativeArrayOfArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeArrayOfArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayOfArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;



public class ClassTypeNativeArrayOfArrayImpl extends ClassTypeCanBeNativeCapableArrayImpl
{
    protected String vmClassName;
    
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayImpl
     */
    public ClassTypeNativeArrayOfArrayImpl(String className,ClassTypeNativeArrayImpl compType)
    {
        super(compType);
        this.vmClassName = toJNIArrayClassName(className);
    }
    
    public static void registerClassTypeNativeArrayOfArray(ClassTypeManagerImpl mgr)
    {
        // Nada que registrar pues no es fijo
    }     
    
    public static ClassTypeNativeArrayOfArrayImpl newCustomNativeArrayOfArrayType(String className,ClassTypeNativeArrayImpl compType,TaskContext ctx)
    {     
        ClassTypeNativeArrayOfArrayImpl classType = new ClassTypeNativeArrayOfArrayImpl(className,compType);
        ClassTypeNativeArrayOfArrayWrapperDefaultImpl wrapperClassType = new ClassTypeNativeArrayOfArrayWrapperDefaultImpl(classType, ctx.getClassTypeManager(),true);
        return classType;
    }       

    public ClassTypeNativeArrayOfArrayWrapperImpl getClassTypeNativeArrayOfArrayWrapper()
    {
        return (ClassTypeNativeArrayOfArrayWrapperImpl)wrapperClassType;
    }
    
    public String getVMClassName()
    {
        return vmClassName;
    }
        
    public Class getDefaultImplClass()    
    {
        // Hay que especificar el ClassLoader
        return null;
    }
    
    public Object newValueDefaultClass(int length)
    {
        // Nos falta el Class para crear el array por reflection
        throw new JNIEasyException("INTERNAL ERROR");
    }    
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeArrayOfArrayImpl(this);
    }     
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeArrayOfArrayImpl(this,(TypeNativeArrayOfArrayWrapperImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativeArrayOfArrayImpl(this,varTypeComp);
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeArrayOfArrayRuntimeImpl(this,rtMgr);
    }


}

