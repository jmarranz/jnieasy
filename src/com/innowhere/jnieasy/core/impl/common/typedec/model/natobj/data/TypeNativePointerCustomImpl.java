/*
 * TypeNativePointerCustomImpl.java
 *
 * Created on 30 de septiembre de 2005, 13:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerCustomImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativePointerCustomRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativePointerCustomXML;

/**
 *
 * @author jmarranz
 */
public class TypeNativePointerCustomImpl extends TypeNativePointerImpl
{
    
    /**
     * Creates a new instance of TypeNativePointerCustomImpl
     */
    public TypeNativePointerCustomImpl(ClassTypeNativePointerCustomImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativePointerCustomRender(this);
    }

    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePointerCustomXML(this);
    }        
}
