/*
 * TypeNativeStringBufferRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;


public class TypeNativeStringBufferRender extends TypeNativeStringBasedRender
{
    
    /** Creates a new instance of TypeNativeStringBufferRender */
    public TypeNativeStringBufferRender(TypeNativeStringBufferImpl typeDec)
    {
        super(typeDec);
    }
    
    public String getDeclareTypeMethodName()
    {
        if (stringInfoRender.declaredEncoding())
            return "decStringBuffer";
        else
            return "dec";
    }    
}
