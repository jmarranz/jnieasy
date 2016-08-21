/*
 * ConstructorOfClassXML.java
 *
 * Created on 7 de septiembre de 2005, 11:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ConstructorSignatureXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.MemberOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.ConstructorOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.MemberOfClassGenXML;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.ConstructorOfClassGenXML;
import org.w3c.dom.Element;
import org.w3c.dom.traversal.TreeWalker;

/**
 *
 * @author jmarranz
 */
public class ConstructorOfClassXML extends BehaviorOfClassXML
{
   
    /** Creates a new instance of ConstructorOfClassXML */
    public ConstructorOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        super(javaClass);
    }
    
    public static ConstructorOfClassXML newConstructorOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        return new ConstructorOfClassXML(javaClass);
    }
    
    public static boolean isConstructor(String tagName)
    {
        return "constructor".equals(tagName);
    }    

    public ConstructorOfClassImpl getConstructorOfClass()
    {
        return (ConstructorOfClassImpl)memberOfClass;
    }    
    
    public void setConstructorOfClass(ConstructorOfClassImpl memberOfClass)
    {
        setMemberOfClass(memberOfClass);
    }
    
    public void parse(Element constrNode,TreeWalker walker,TaskContext ctx)
    {
        ClassTypeNativeMultipleFieldContainerImpl thisClassType = (ClassTypeNativeMultipleFieldContainerImpl)getJavaClassAsNativeCapable().getClassTypeNativeCapable();
                
        ConstructorSignatureXML sigXML = ConstructorSignatureXML.newConstructorSignatureXML();
        sigXML.setThisClassType(thisClassType);
        sigXML.parse(constrNode,walker,ctx);
        NativeConstructorSignatureImpl sig = sigXML.getConstructorSignature();

        ConstructorOfClassImpl constr = ConstructorOfClassImpl.newConstructorOfClass(sig,thisClassType);
        setConstructorOfClass(constr);
    }
    
    public MemberOfClassGenXML newMemberOfClassGenXML(JavaClassAsNativeMultipleFieldContainerGen classGen)    
    {
        return new ConstructorOfClassGenXML(this,classGen);
    }
    
    public MemberOfClassEnhancerXML newMemberOfClassEnhancerXML(JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return new ConstructorOfClassEnhancerXML(this,(JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer);
    }

}
