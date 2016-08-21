/*
 * MethodOfClassXML.java
 *
 * Created on 28 de febrero de 2005, 20:58
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;


/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.MemberOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.MethodOfClassEnhancerXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.MemberOfClassGenXML;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.MethodOfClassGenXML;
import org.w3c.dom.*;

import com.innowhere.jnieasy.core.impl.util.*;
import org.w3c.dom.traversal.TreeWalker;



public class MethodOfClassXML extends BehaviorOfClassXML
{
   
    /** Creates a new instance of MethodOfClassXML */
    public MethodOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        super(javaClass);
    }
    
    public static MethodOfClassXML newMethodOfClassXML(JavaClassAsNativeCapableImpl javaClass)
    {
        return new MethodOfClassXML(javaClass);
    }
    
    public static boolean isMethod(String tagName)
    {
        return "method".equals(tagName);
    }    
    
    public MethodOfClassImpl getMethodOfClass()
    {
        return (MethodOfClassImpl)memberOfClass;
    }    
    
    public void setMethodOfClass(MethodOfClassImpl memberOfClass)
    {
        setMemberOfClass(memberOfClass);
    }
 
    public MemberOfClassGenXML newMemberOfClassGenXML(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new MethodOfClassGenXML(this,classGen);
    }  
    
    public MemberOfClassEnhancerXML newMemberOfClassEnhancerXML(JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return new MethodOfClassEnhancerXML(this, classEnhancer);
    }        
}
