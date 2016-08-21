/*
 * TypeNativeStringBufferWrapperRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBufferWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperImpl;

public class TypeNativeStringBufferWrapperRender extends TypeNativeStringBasedWrapperRender
{
    
    /** Creates a new instance of TypeNativeStringBufferWrapperRender */
    public TypeNativeStringBufferWrapperRender(TypeNativeStringBufferWrapperImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativeStringBufferWrapperImpl getTypeNativeStringBufferWrapper()
    {
        return (TypeNativeStringBufferWrapperImpl)typeDec;
    }
    
    public String getDeclareTypeMethodName()
    {
        if (stringInfoRender.declaredEncoding())
            return "decStringBuffer";
        else
            return "dec";
    }    
}
