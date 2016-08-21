/*
 * TypeNativePointerDefaultImpl.java
 *
 * Created on 30 de septiembre de 2005, 13:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativePointerDefaultRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativePointerDefaultXML;

/**
 *
 * @author jmarranz
 */
public class TypeNativePointerDefaultImpl extends TypeNativePointerImpl
{
    
    /**
     * Creates a new instance of TypeNativePointerDefaultImpl
     */
    public TypeNativePointerDefaultImpl(ClassTypeNativePointerDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativePointerDefaultRender(this);
    }

    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePointerDefaultXML(this);
    }       
}
