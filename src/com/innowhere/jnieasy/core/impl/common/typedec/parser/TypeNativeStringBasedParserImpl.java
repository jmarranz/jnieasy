/*
 * TypeNativeStringBasedParserImpl.java
 *
 * Created on 14 de septiembre de 2005, 18:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

/**
 *
 * @author jmarranz
 */
public class TypeNativeStringBasedParserImpl extends TypeNativeParserImpl
{
    
    /**
     * Creates a new instance of TypeNativeStringBasedParserImpl
     */
    public TypeNativeStringBasedParserImpl(TypeNativeStringBasedInterface typeDec)
    {
        super((TypeNativeImpl)typeDec);
    }

    public TypeNativeStringBasedInterface getTypeNativeStringBasedInterface()
    {
        return (TypeNativeStringBasedInterface)typeDec;
    }
    
    public void parse(SourceCode blockContent,TaskContext ctx)
    {
        // Esperamos { ANSI | UNICODE } también en minúsculas y con macros
        
        TypeNativeStringBasedInterface typeDec = getTypeNativeStringBasedInterface();

        String encodingExpr = blockContent.getContent();
        typeDec.setEncodingExpr(encodingExpr);    
    }
    
    public static int parseEncoding(String encodingName)
    {
        // Se espera: 
        // ANSI | UNICODE  o 
        // ansi | unicode
        encodingName = encodingName.toUpperCase();        
        int encoding;
        if (encodingName.equals("ANSI"))
            encoding = StringEncoding.ANSI;
        else if (encodingName.equals("UNICODE"))
            encoding = StringEncoding.UNICODE;  
        else throw new JNIEasyException("Bad encoding string name :" + encodingName);        
        
        return encoding;
    }
}
