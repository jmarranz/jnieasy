/*
 * TypeNativeStringInfoRuntime.java
 *
 * Created on 11 de enero de 2005, 18:48
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.StringEncodingImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeStringBasedParserImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

public class TypeNativeStringInfoRuntime
{
    protected int encoding = -1; // no definido
    protected TypeNativeStringBasedRuntime typeDec;
    
    /**
     * Creates a new instance of TypeNativeStringInfoRuntime
     */
    public TypeNativeStringInfoRuntime(TypeNativeStringBasedRuntime typeDec)
    {
        this.typeDec = typeDec;
    }
    
    
    /**
     * Getter for property encoding.
     * @return Value of property encoding.
     */
    public int getEncoding()
    {
        if (encoding == -1) // no definido
        {
            int encoding;
            String encodingExpr = typeDec.getTypeNativeStringBasedInterface().getEncodingExpr();
            if (encodingExpr == null)
            {
                encoding = typeDec.getDefaultEncoding();
            }
            else
            {
                RuntimeManagerImpl rtMgr = typeDec.getRuntimeManager();
                encoding = toEncoding(encodingExpr,rtMgr.getTypeManagerRuntime());
            }
            
            checkValidEncoding(typeDec,encoding);
            
            this.encoding = encoding;
        }

        return encoding;
    }
    
    /**
     * Setter for property encoding.
     * @param encoding New value of property encoding.
     */
    public void setEncoding(int encoding)
    {
        checkValidEncoding(typeDec,encoding);
           
        this.encoding = encoding;
        
        if (!typeDec.isFixedEncoding())
        {
            // Para que el renderizado sea correcto 
            String encodingExpr = StringEncodingImpl.asString(encoding);
            typeDec.getTypeNativeStringBasedInterface().setEncodingExpr(encodingExpr);
        }
    }

    public static int toEncoding(String encodingExpr,NativeTypeManagerRuntimeImpl typeMgr)
    {
        String encodingName = typeMgr.parseNameWithMacros(encodingExpr);
        return TypeNativeStringBasedParserImpl.parseEncoding(encodingName);    
    }
    
    public static void checkValidEncoding(TypeNativeStringBasedRuntime typeDec,int encoding)
    {
        StringEncodingImpl.checkEncoding(encoding);
        
        if (!typeDec.isValidEncoding(encoding))
            throw new JNIEasyException("Invalid string encoding, must be: " + StringEncodingImpl.asString(typeDec.getDefaultEncoding()));
    }

}
