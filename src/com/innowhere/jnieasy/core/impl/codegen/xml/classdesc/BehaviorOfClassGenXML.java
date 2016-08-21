/*
 * BehaviorOfClassGenXML.java
 *
 * Created on 28 de febrero de 2005, 20:54
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.BehaviorOfClassXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.BehaviorOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;


public abstract class BehaviorOfClassGenXML extends MemberOfClassGenXML
{
    /** Creates a new instance of BehaviorOfClassGenXML */
    public BehaviorOfClassGenXML(BehaviorOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        super(accessObjOfClassXML,classGen);
    }
    
    public BehaviorOfClassGen getBehaviorOfClassGen()
    {
        return (BehaviorOfClassGen)memberOfClassGen;
    }
    
    public BehaviorOfClassXML getBehaviorOfClassXML()
    {
        return (BehaviorOfClassXML)memberOfClassXML;
    }                
    
    public void parse(Element accObjNode,TreeWalker walker,CodeGenContext ctx)
    {
        BehaviorOfClassXML behOfClassXML = getBehaviorOfClassXML();
        
        behOfClassXML.parseNativeName(accObjNode);
        
        super.parse(accObjNode,walker,ctx);
    }        
}
