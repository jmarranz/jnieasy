/*
 * TypeNativeBehaviorParserImpl.java
 *
 * Created on 24 de agosto de 2006, 19:49
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.parser.NativeBehaviorSignatureParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeBehaviorInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;

/**
 *
 * @author jmarranz
 */
public class TypeNativeBehaviorParserImpl extends TypeNativeParserImpl
{
    
    /** Creates a new instance of TypeNativeBehaviorParserImpl */
    public TypeNativeBehaviorParserImpl(TypeNativeBehaviorInterface typeDec)
    {
        super((TypeNativeImpl)typeDec);
    }
    
    public TypeNativeBehaviorInterface getTypeNativeBehaviorInterface()
    {
        return (TypeNativeBehaviorInterface)typeDec;
    }
    
    public void parse(SourceCode blockContent,TaskContext ctx)
    {
        NativeBehaviorSignatureImpl sig = NativeBehaviorSignatureParserImpl.parseBehaviorSignature(blockContent,ctx);
        getTypeNativeBehaviorInterface().setBehaviorSignature(sig); 
    }
}
