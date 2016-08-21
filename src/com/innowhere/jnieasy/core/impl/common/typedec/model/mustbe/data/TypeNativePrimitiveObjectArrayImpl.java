/*
 * StringArrayType.java
 *
 * Created on 16 de noviembre de 2004, 19:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;



public class TypeNativePrimitiveObjectArrayImpl extends TypeCanBeNativeCapableArrayImpl
{
    /** Creates a new instance of StringArrayType */
    public TypeNativePrimitiveObjectArrayImpl(ClassTypeNativePrimitiveObjectArrayImpl dataType)
    {
        super(dataType);
    }  
    
    public TypeNativePrimitiveObjectArrayImpl(ClassTypeNativePrimitiveObjectArrayImpl dataType,TypeNativePrimitiveObjectArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativePrimitiveObjectArrayImpl(ClassTypeNativePrimitiveObjectArrayImpl dataType,VarTypeNativeImpl varTypeDecComp)
    {
        super(dataType,varTypeDecComp);
    }  
    
   
    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeDecCompRt,RuntimeContext ctx)
    {
        return new TypeNativePrimitiveObjectArrayRuntimeImpl(this,javaClass,isPrimary,varTypeDecCompRt,ctx);        
    }            
}
