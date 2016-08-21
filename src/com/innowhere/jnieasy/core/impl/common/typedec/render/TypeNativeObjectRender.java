/*
 * TypeNativeObjectRender.java
 *
 * Created on 18 de marzo de 2004, 17:23
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectImpl;

public abstract class TypeNativeObjectRender extends TypeNativeRender
{
    /** Creates a new instance of TypeNativeObjectRender */
    public TypeNativeObjectRender(TypeNativeObjectImpl typeDec)
    {
        super(typeDec);
    }

    public TypeNativeObjectImpl getTypeNativeObject()
    {
        return (TypeNativeObjectImpl)typeDec;
    }

    public String convertFromObject(String paramName)
    {
        String className = getTypeNativeObject().getClassName();
        return "(" + className + ")" + paramName;
    }
    
    public String returnCastToObject(String code)    
    {
        return "return " + code;
    }

    public String castToObject(String code)    
    {
        return code;
    }    

}
