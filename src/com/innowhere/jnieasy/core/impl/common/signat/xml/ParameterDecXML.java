/*
 * ParameterDecImpl.java
 *
 * Created on 26 de marzo de 2004, 19:12
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;


/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.MethodHeaderDeclarationImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;



public class ParameterDecXML extends MethodHeaderDeclarationXML
{
    protected int number; // debe empezar desde uno
    
    /**
     * Creates a new instance of ParameterDecImpl
     */
    public ParameterDecXML(int number)
    {
        this.number = number;
    }
    
    public static ParameterDecXML newParameterDecXML(int number)
    {
        return new ParameterDecXML(number);
    }
    
    public ParameterDecImpl getParameterDec()
    {
        return (ParameterDecImpl)type;
    }
    
    public void parse(Element paramNode,TreeWalker walker,ClassTypeNativeImpl dataType,TaskContext ctx)
    {    
        super.parse(paramNode,walker,dataType,ctx);

        try
        {
            // Ej. <param [name="a"] [varargs="true|false" [...] />  

            Attr attName = paramNode.getAttributeNode("name");
            if (attName != null)
            {
                ParameterDecImpl paramDec = getParameterDec();
                paramDec.setName(attName.getValue());  
            }
            
            Attr attVarargs = paramNode.getAttributeNode("varargs");
            if (attVarargs != null)
            {
                ParameterDecImpl paramDec = getParameterDec();
                paramDec.setVarArgs(XMLUtil.getBooleanValue(attVarargs));  
            }            
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,paramNode);
        }           
    }
    
    public MethodHeaderDeclarationImpl newMethodHeaderDeclaration(VarTypeNativeImpl varType)
    {
        ParameterDecImpl paramDec = new ParameterDecImpl(varType);
        paramDec.setParamNumber(number);
        return paramDec;
    }
    
}
