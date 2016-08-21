/*
 * TypeNativeCapableArrayImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeCapableArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeCapableArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;



public class TypeNativeCapableArrayImpl extends TypeNativeObjectArrayImpl
{
    /**
     * Creates a new instance of TypeNativeCapableArrayImpl
     */
    public TypeNativeCapableArrayImpl(ClassTypeNativeCapableArrayImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeCapableArrayImpl(ClassTypeNativeCapableArrayImpl dataType,TypeNativeCapableArrayWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeCapableArrayImpl(ClassTypeNativeCapableArrayImpl dataType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType,varTypeComp);
    }

    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeCompRt,RuntimeContext ctx)
    {
        return new TypeNativeCapableArrayRuntimeImpl(this,javaClass,isPrimary,varTypeCompRt,ctx);        
    }   

}

