/*
 * JavaClassAsNativeMultipleFieldContainerGenXML.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeMultipleFieldContainerXML;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.BehaviorOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsCPPClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;


/**
 *
 * @author  jmarranz
 */


public class JavaClassAsNativeMultipleFieldContainerGenXML
{
    protected JavaClassAsNativeMultipleFieldContainerGen javaClassGen;
    protected FileCodeGenXML fileCodeGenXML;
    protected JNIEasyImpl jniEasy;
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerGenXML
     */
    public JavaClassAsNativeMultipleFieldContainerGenXML(FileCodeGenXML fileCodeGenXML,JNIEasyImpl jniEasy)
    {
        this.fileCodeGenXML = fileCodeGenXML;
        this.jniEasy = jniEasy;
    }
    
    public static JavaClassAsNativeMultipleFieldContainerGenXML newClassGenXML(FileCodeGenXML fileCodeGenXML,JNIEasyImpl jniEasy)
    {
        return new JavaClassAsNativeMultipleFieldContainerGenXML(fileCodeGenXML,jniEasy);
    }
    
    public JavaClassAsNativeMultipleFieldContainerGen getJavaClassAsMultipleFieldContainerGen()
    {
        return javaClassGen;
    }
    
    public void parse(Element classNode,TreeWalker walker,CodeGenContext ctx)
    {
        try
        {
            // Ej. <class name="SimpleClassName" libraryPath="User32.dll" [extends="BaseClass"] [implements="interfaces]>
           
            String simpleName = JavaClassAsNativeCapableXML.getSimpleClassName(classNode);
            String packageName = fileCodeGenXML.getFileCodeGen().getPackage().getName();
            String className = packageName + "." + simpleName;
            
            // ojo no pasamos el nombre de la clase completo
            // pues al generar código no es necesario.
            this.javaClassGen = JavaClassAsCPPClassGen.newJavaClassAsCPPClassGen(className,jniEasy);
            javaClassGen.setSimpleName(simpleName);
            
            Attr extendsAtt = classNode.getAttributeNode("extends");
            if (extendsAtt != null)
                javaClassGen.setBaseClass(extendsAtt.getValue());
            
            Attr implementsAtt = classNode.getAttributeNode("implements");
            if (implementsAtt != null)
                javaClassGen.setInterfaces(implementsAtt.getValue());            
            
            JavaClassAsNativeMultipleFieldContainerImpl javaClass = javaClassGen.getJavaClassAsMultipleFieldContainer();
            JavaClassAsNativeMultipleFieldContainerXML javaClassXML = (JavaClassAsNativeMultipleFieldContainerXML)JavaClassAsNativeCapableXML.newJavaClassAsNativeCapableXML(javaClass);
            javaClassXML.parse(classNode, walker);
            if (javaClass.getLibraryPath() == null)
                throw new JNIEasyException("libraryPath is mandatory");
            
            parseMembers(classNode,walker,ctx);
            
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,classNode);
        }      
    }    
    
    public void parseMembers(Element classNode,TreeWalker walker,final CodeGenContext ctx)
    {
        XMLTask childTask = new XMLTask()
        {
            int methods = 0;

            public void doTask(Element memberNode,TreeWalker walker,int counter)
            {
                try
                {
                    // <method/constructor/field/fieldMethod/freeCode>  
                    String tagName = memberNode.getTagName();

                    if (FreeCodeGenXML.isFreeCodeNode(tagName))
                        javaClassGen.addFreeCode(FreeCodeGenXML.parse(memberNode));
                    else
                    {
                        MemberOfClassGenXML accessObjOfClassGenXML = MemberOfClassGenXML.newMemberOfClassGenXML(tagName,javaClassGen);
                        accessObjOfClassGenXML.parse(memberNode,walker,ctx);                        
                        MemberOfClassGen accessObjOfClassGen = accessObjOfClassGenXML.getMemberOfClassGen();
                        if (accessObjOfClassGen instanceof FieldOfClassGen)
                        {
                            javaClassGen.addField((FieldOfClassGen)accessObjOfClassGen);
                        }
                        else
                        {
                            BehaviorOfClassGen behaviorGen = (BehaviorOfClassGen)accessObjOfClassGen;
                            behaviorGen.setIndex(methods);
                            javaClassGen.addBehavior(behaviorGen);  

                            methods++;                            
                        }
                    }
                }
                catch(JNIEasyXMLException ex)
                {
                    throw ex;
                }        
                catch(Exception ex)
                {
                    throw new JNIEasyXMLException(ex,memberNode);
                }                      
            }
        };

        TreeWalkerUtil.processChildElements(walker, childTask);        
    }
}
