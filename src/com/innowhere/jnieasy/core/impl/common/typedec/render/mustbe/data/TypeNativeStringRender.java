/*
 * TypeNativeStringRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;


public class TypeNativeStringRender extends TypeNativeStringBasedRender
{
    
    /** Creates a new instance of TypeNativeStringRender */
    public TypeNativeStringRender(TypeNativeStringImpl typeDec)
    {
        super(typeDec);
    }
    
    public String getDeclareTypeMethodName()
    {
        if (stringInfoRender.declaredEncoding())
            return "decString";
        else
            return "dec";
    }    
}
