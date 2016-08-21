/*
 * TypeNativeStringBufferWrapperImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBufferInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeStringBufferWrapperRender;


public abstract class TypeNativeStringBufferWrapperImpl extends TypeNativeStringBasedWrapperImpl implements  TypeNativeStringBufferInterface
{
    /** Creates a new instance of TypeNativeStringBufferWrapperImpl */
    public TypeNativeStringBufferWrapperImpl(ClassTypeNativeStringBufferWrapperImpl dataType)
    {
        super(dataType);
    }
                     
    public TypeNativeStringBufferWrapperImpl(ClassTypeNativeStringBufferWrapperImpl dataType,TypeNativeStringBufferImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }
    
    public ClassTypeNativeStringBufferWrapperImpl getStringWrapperType()
    {
        return (ClassTypeNativeStringBufferWrapperImpl)dataType;
    }
   
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeStringBufferWrapperRender(this);
    }
}
