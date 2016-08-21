/*
 * TypeNativeMemberReflectionWrapperRender.java
 *
 * Created on 30 de marzo de 2005, 12:24
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMemberReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeCanBeNativeCapableWrapperRender;

public abstract class TypeNativeMemberReflectionWrapperRender extends TypeCanBeNativeCapableWrapperRender
{
    
    /**
     * Creates a new instance of TypeNativeMemberReflectionWrapperRender
     */
    public TypeNativeMemberReflectionWrapperRender(TypeNativeMemberReflectionWrapperImpl typeDec)
    {
        super(typeDec);
    }
}
