/*
 * TypeNativeMemberReflectionRender.java
 *
 * Created on 7 de diciembre de 2004, 14:41
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMemberReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data.TypeCanBeNativeCapableRender;


public abstract class TypeNativeMemberReflectionRender extends TypeCanBeNativeCapableRender
{
    
    /**
     * Creates a new instance of TypeNativeMemberReflectionRender
     */
    public TypeNativeMemberReflectionRender(TypeNativeMemberReflectionImpl typeDec)
    {
        super(typeDec);
    }
    
}
