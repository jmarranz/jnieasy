/*
 * TypeNativeStringWrapperRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringWrapperImpl;

public class TypeNativeStringWrapperRender extends TypeNativeStringBasedWrapperRender
{
    
    /** Creates a new instance of TypeNativeStringWrapperRender */
    public TypeNativeStringWrapperRender(TypeNativeStringWrapperImpl typeDec)
    {
        super(typeDec);
    }
   
    public TypeNativeStringWrapperImpl getTypeNativeStringWrapper()
    {
        return (TypeNativeStringWrapperImpl)typeDec;
    }
    
    public String getDeclareTypeMethodName()
    {
        if (stringInfoRender.declaredEncoding())
            return "decString";
        else
            return "dec";
    }       

}
