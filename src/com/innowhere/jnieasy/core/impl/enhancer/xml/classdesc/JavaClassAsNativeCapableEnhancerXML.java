/*
 * EnhancedClass.java
 *
 * Created on 18 de marzo de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc;
import java.util.*;
import javassist.*;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsCPPClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeObjectArrayWrapperEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativePointerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsStructureEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsUnionEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageListEnhancer;

import java.net.URL;

public abstract class JavaClassAsNativeCapableEnhancerXML
{
    public static final String STRUCTURE = "structure";
    public static final String UNION = "union";    
    public static final String ARRAY = "array";    
    public static final String CLASS = "class";    
    public static final String CALLBACK = "callback";    
    public static final String POINTER = "pointer"; 
    
    protected JavaClassAsNativeCapableEnhancer javaClassEnh;
    
    /** Creates a new instance of EnhancedClass */
    public JavaClassAsNativeCapableEnhancerXML(JavaClassAsNativeCapableEnhancer javaClassEnh)
    {
        this.javaClassEnh = javaClassEnh;
    }    
    
    public JavaClassAsNativeCapableEnhancer getJavaClassAsNativeCapableEnhancer()
    {
        return javaClassEnh;
    }
    
    public static JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML(JavaClassAsNativeMultipleFieldContainerEnhancer typeEnh)
    {
        return typeEnh.newJavaClassAsNativeCapableEnhancerXML();
    }
    
    public static JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML(Element classNode,TreeWalker walker,CtClass ctClass,EnhancerSourceFileContext ctx)
    {
        String type = XMLUtil.getAttribute(classNode,"type");
        
        JavaClassAsNativeCapableEnhancer javaClassEnh;
        if (type.equals(ARRAY))
        {
            CtField ctField = JavaClassAsNativeObjectFieldContainerEnhancerXML.getCtFieldFromXMLDirectly(classNode,ctClass);
            javaClassEnh = JavaClassAsNativeObjectArrayWrapperEnhancer.newJavaClassAsNativeObjectArrayEnhancer(ctClass,ctField,ctx);
        }
        else if (type.equals(POINTER))
        {
            CtField ctField = JavaClassAsNativeObjectFieldContainerEnhancerXML.getCtFieldFromXMLDirectly(classNode,ctClass);            
            javaClassEnh = JavaClassAsNativePointerEnhancer.newJavaClassAsNativePointerEnhancer(ctClass,ctField,ctx);        
        }
        else if (type.equals(STRUCTURE))
            javaClassEnh = JavaClassAsStructureEnhancer.newJavaClassAsStructureEnhancer(ctClass,ctx.getParentContext());
        else if (type.equals(CLASS))
            javaClassEnh = JavaClassAsCPPClassEnhancer.newJavaClassAsCPPClassEnhancer(ctClass,ctx.getParentContext());
        else if (type.equals(UNION))
            javaClassEnh = JavaClassAsUnionEnhancer.newJavaClassAsUnionEnhancer(ctClass,ctx.getParentContext());
        else if (type.equals(CALLBACK))
            javaClassEnh = JavaClassAsNativeDirectCallbackEnhancerXML.newJavaClassAsNativeDirectCallbackEnhancerXML(classNode,walker,ctClass,ctx);        
        else
            throw new JNIEasyException("Not valid type name: " + type);
        
        return javaClassEnh.newJavaClassAsNativeCapableEnhancerXML();
    }

    public static JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(URL filePath,CtClass ctClass,EnhancerSharedContext ctx)
    {     
        String className = ctClass.getName();
        PackageListEnhancerXML pkgListXML = PackageListEnhancerXML.newPackageListEnhancerXML();
        pkgListXML.parse(filePath,null,ctx);        
        PackageListEnhancer pkgListEnh = pkgListXML.getPackageListEnhancer();
       
        String packageName = Util.getPackagePart(className);
        
        // Cogemos el package que coincida el nombre
        // en teoría debe haber uno, pero así nos preparamos para la posibilidad
        // de búsqueda de muchas clases en un único archivo también para 
        // el caso de enhancer on load
       
        PackageEnhancer pkgEnh = null;
        LinkedList pkgs = pkgListEnh.getPackages();
        for(Iterator it=pkgs.iterator(); it.hasNext(); )
        {
            PackageEnhancer pkgEnhIt = (PackageEnhancer)it.next();
            if (packageName.equals(pkgEnhIt.getPackageDec().getName()))
            {
                pkgEnh = pkgEnhIt;
                break;
            }
        }
        if (pkgEnh == null)
            throw new JNIEasyException("Not found package : " + packageName + " on XML file: " + filePath);
        
        // Buscamos la clase ahora
        JavaClassAsNativeCapableEnhancer classEnh = null;
        LinkedList classes = pkgEnh.getClasses();
        
        for(Iterator it=classes.iterator(); it.hasNext(); )
        {
            JavaClassAsNativeCapableEnhancer classEnhIt = (JavaClassAsNativeCapableEnhancer)it.next();
            if (className.equals(classEnhIt.getName()))
            {
                classEnh = classEnhIt;
                break;
            }
        }

        if (classEnh == null)
            throw new JNIEasyException("Not found class : " + className + " on XML file: " + filePath);

        return classEnh;
    }
    
    public static String getSimpleClassName(Element classNode)
    {
        return JavaClassAsNativeCapableXML.getSimpleClassName(classNode);
    }
    
    public static JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(String className,Element classNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {        
        JavaClassAsNativeCapableEnhancer classEnh;
        
        CtClass ctClass = ctx.getCtClass(className);

        JavaClassAsNativeCapableEnhancerXML classEnhXML = newJavaClassAsNativeCapableEnhancerXML(ctClass,classNode,walker,ctx);
        classEnh = classEnhXML.getJavaClassAsNativeCapableEnhancer(); 

        return classEnh;        
    }

    public static JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML(CtClass ctClass,Element classNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {        
        // <class name="ToEnhanceClass" type="structure|class|array">
            
        JavaClassAsNativeCapableEnhancerXML classEnhXML = newJavaClassAsNativeCapableEnhancerXML(classNode,walker,ctClass,ctx);

        JavaClassAsNativeCapableEnhancer classEnhancer = classEnhXML.getJavaClassAsNativeCapableEnhancer();

        if (classEnhancer.isEnhanced())
        {
            // Crea un JavaClassAsNativeCapableEnhancer para cumplir pues no será necesario "enhancearlo"
            // Evitamos el parseo del resto del XML
            classEnhancer.setEnhanced(true);       
        }
        else
            classEnhXML.parse(classNode,walker,ctx);        
        
        return classEnhXML;
    }
    
    public void parse(Element classNode,TreeWalker walker,EnhancerSourceFileContext ctx)
    {    
       
        parseFieldsAndMethods(classNode,walker,ctx);
    }
    
    public abstract void parseFieldsAndMethods(Element classNode, TreeWalker walker, EnhancerSourceFileContext ctx);
    public abstract FieldOfClassEnhancerXML newFieldOfClassEnhancerXML();         
}
