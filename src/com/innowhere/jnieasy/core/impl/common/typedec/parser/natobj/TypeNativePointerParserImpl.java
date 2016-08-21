/*
 * TypeNativePointerParserImpl.java
 *
 * Created on 24 de agosto de 2006, 19:45
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;

/**
 *
 * @author jmarranz
 */
public class TypeNativePointerParserImpl extends TypeNativeCapableParserImpl
{
    
    /** Creates a new instance of TypeNativePointerParserImpl */
    public TypeNativePointerParserImpl(TypeNativePointerImpl typeDec)
    {
        super(typeDec);
    }
    
    public TypeNativePointerImpl getTypeNativePointer()
    {
        return (TypeNativePointerImpl)typeDec;
    }
    
    public void parse(SourceCode blockContent,TaskContext ctx)
    {
        // Esperamos { TipoObjPorRef }
        
        TypeNativePointerImpl typeDec = getTypeNativePointer();
        
        String addressedDec = blockContent.getContent();
        VarTypeNativeObjectImpl addressedVarType = (VarTypeNativeObjectImpl)VarTypeNativeParserImpl.newVarTypeNative(addressedDec, ctx);
        typeDec.setAddressedVarTypeNativeObject(addressedVarType);    
    }
}
