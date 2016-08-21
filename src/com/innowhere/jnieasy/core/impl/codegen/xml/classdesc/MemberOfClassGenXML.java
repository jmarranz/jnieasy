/*
 * MemberOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:53
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.MemberOfClassXML;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MemberOfClassImpl;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;


public abstract class MemberOfClassGenXML
{
    protected MemberOfClassXML memberOfClassXML;
    protected MemberOfClassGen memberOfClassGen;
    protected JavaClassAsNativeMultipleFieldContainerGen javaClassGen;
    
    /**
     * Creates a new instance of MemberOfClassXML
     */
    public MemberOfClassGenXML(MemberOfClassXML accessObjOfClassXML,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        this.memberOfClassXML = accessObjOfClassXML;
        this.javaClassGen = classGen;
    }
    
    public static MemberOfClassGenXML newMemberOfClassGenXML(String tagName,JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        MemberOfClassXML accessObjOfClassXML = MemberOfClassXML.newMemberOfClassXML(tagName,classGen.getJavaClassAsNativeCapable());
        return accessObjOfClassXML.newMemberOfClassGenXML(classGen);                
    }
    
    /**
     * Getter for property javaClassGen.
     * @return Value of property javaClassGen.
     */
    public JavaClassAsNativeMultipleFieldContainerGen getJavaClassAsMultipleFieldContainerGen()
    {
        return javaClassGen;
    }
    
    /**
     * Setter for property javaClassGen.
     * @param javaClassGen New value of property javaClassGen.
     */
    public void setJavaClassAsMultipleFieldContainerGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        this.javaClassGen = classGen;
    }
    
    public MemberOfClassGen getMemberOfClassGen()
    {
        return memberOfClassGen;
    }
    
    public void setMemberOfClassGen(MemberOfClassGen memberOfClassGen)
    {
        this.memberOfClassGen = memberOfClassGen;
    }    
    
    public void parse(Element accObjNode,TreeWalker walker,CodeGenContext ctx)
    {
        MemberOfClassImpl memberOfClass = memberOfClassXML.getMemberOfClass();        
        if (memberOfClass.mustHaveName())
            memberOfClass.setName(MemberOfClassXML.getName(accObjNode));        
    }    

}
