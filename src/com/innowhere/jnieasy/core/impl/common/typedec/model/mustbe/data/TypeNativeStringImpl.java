/*
 * TypeNativeStringImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data.TypeNativeStringRender;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;


public class TypeNativeStringImpl extends TypeNativeStringBasedImpl implements TypeNativeStringInterface
{
   
    /**
     * Creates a new instance of TypeNativeStringImpl
     */
    public TypeNativeStringImpl(ClassTypeNativeStringImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeStringImpl(ClassTypeNativeStringImpl dataType,TypeNativeStringWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public ClassTypeNativeStringImpl getStringType()
    {
        return (ClassTypeNativeStringImpl)dataType;
    }
   
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeStringRender(this);
    }

    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStringRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }

}
