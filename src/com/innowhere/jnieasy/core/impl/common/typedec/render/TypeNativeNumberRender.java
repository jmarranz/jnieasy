/*
 * TypeNativeNumberRender.java
 *
 * Created on 8 de julio de 2005, 19:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeNumberImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeNumberRender extends TypeNativePrimitiveRender
{
    
    /**
     * Creates a new instance of TypeNativeNumberRender
     */
    public TypeNativeNumberRender(TypeNativeNumberImpl typeDec)
    {
        super(typeDec);
    }
    
}
