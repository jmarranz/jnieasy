/*
 * TypeNativeObjectArrayDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeObjectArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeObjectArrayDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public class TypeNativeObjectArrayDefaultImpl extends TypeNativeObjectArrayImpl
{
    /**
     * Creates a new instance of TypeNativeObjectArrayDefaultImpl
     */
    public TypeNativeObjectArrayDefaultImpl(ClassTypeNativeObjectArrayDefaultImpl dataType)
    {
        super(dataType);
    }

    public TypeNativeObjectArrayDefaultImpl(ClassTypeNativeObjectArrayDefaultImpl dataType,TypeNativeObjectArrayWrapperDefaultImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeObjectArrayDefaultImpl(ClassTypeNativeObjectArrayDefaultImpl dataType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType,varTypeComp);
    }
    
    public TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeCompRt,RuntimeContext ctx)
    {
        return new TypeNativeObjectArrayDefaultRuntimeImpl(this,javaClass,isPrimary,varTypeCompRt,ctx);        
    }        
}

