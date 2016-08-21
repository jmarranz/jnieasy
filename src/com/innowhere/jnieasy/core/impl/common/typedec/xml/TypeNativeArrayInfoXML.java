/*
 * ArrayEmbeddedInfoXML.java
 *
 * Created on 3 de enero de 2005, 21:43
 */

package com.innowhere.jnieasy.core.impl.common.typedec.xml;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.xml.VarTypeNativeXML;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInfo;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;



public class TypeNativeArrayInfoXML
{
    protected TypeNativeArrayInterface typeDec;
            
    /** Creates a new instance of ArrayEmbeddedInfoXML */
    public TypeNativeArrayInfoXML(TypeNativeArrayInterface typeDec)
    {
        this.typeDec = typeDec;
    }
    
    private void parseLength(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            //<field/component ... [length="num"] />

            TypeNativeArrayInfo arrayInfo = typeDec.getTypeNativeArrayInfo();
            
            Attr attLength = typeNode.getAttributeNode("length");
            if (attLength != null)
                arrayInfo.setLength(Integer.parseInt(attLength.getValue()));
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,typeNode);
        }         
    }
    
    public static Element getComponentChildNode(TreeWalker walker,boolean mustExist)
    {
        // <component ... >
        return TreeWalkerUtil.firstChildElement(walker, "component", mustExist);
    }
    
    public void parse(Element typeNode,TreeWalker walker,TaskContext ctx)
    {
        try
        {
            // <component ... >
            Element compNode = getComponentChildNode(walker,false);
            if (compNode != null)
            {              
                TypeNativeArrayInfo arrayInfo = typeDec.getTypeNativeArrayInfo();
                VarTypeNativeImpl compVarType = arrayInfo.getComponentVarType();
                VarTypeNativeXML compVarTypeXML = VarTypeNativeXML.newVarTypeNativeXML(compVarType);
                compVarTypeXML.parse(compNode,walker,ctx);  
                
                TreeWalkerUtil.parentElement(walker);
            }
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,typeNode);
        }         
        
        parseLength(typeNode,walker,ctx);
    }    
    
    public void parseToCompleteDeclaration(Element typeNode,TreeWalker walker,TypeNativeArrayWrapperImpl typeDec,TaskContext ctx)
    {
        // Es llamada en el caso de wrapper tal y como NativeArrayOfArray 
        // en donde no se conoce el tipo componente hasta que no se procesa
        // el nodo <component>
        try
        {
            // <component ... >
            Element compNode = getComponentChildNode(walker,true); // es obligatorio
            
            VarTypeNativeXML compVarTypeXML = VarTypeNativeXML.newVarTypeNativeXML(compNode,walker,null,ctx);
            compVarTypeXML.parse(compNode,walker,ctx);

            VarTypeNativeImpl varCompType = compVarTypeXML.getVarTypeNative();
            TypeNativeArrayImpl typeDecArray = TypeNativeArrayImpl.newTypeNativeArray(varCompType,ctx);
            typeDec.setTypeCanBeNativeCapable(typeDecArray);                        
           
            TreeWalkerUtil.parentElement(walker);
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,typeNode);
        }         
        
        parseLength(typeNode,walker,ctx);        
    }        
}
