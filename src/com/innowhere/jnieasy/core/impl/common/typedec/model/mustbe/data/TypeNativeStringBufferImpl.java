/*
 * TypeNativeStringBufferImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBufferInterface;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringBufferRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data.TypeNativeStringBufferRender;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;

public class TypeNativeStringBufferImpl extends TypeNativeStringBasedImpl implements TypeNativeStringBufferInterface
{
    /** Creates a new instance of TypeNativeStringBufferImpl */
    public TypeNativeStringBufferImpl(ClassTypeNativeStringBufferImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeStringBufferImpl(ClassTypeNativeStringBufferImpl dataType,TypeNativeStringBufferWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public ClassTypeNativeStringBufferImpl getStringType()
    {
        return (ClassTypeNativeStringBufferImpl)dataType;
    } 

    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeStringBufferRender(this);
    }
    
    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStringBufferRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }        

}
