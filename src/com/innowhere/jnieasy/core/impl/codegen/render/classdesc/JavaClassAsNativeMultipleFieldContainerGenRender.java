/*
 * JavaClassAsNativeMultipleFieldContainerGenRender.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */

import com.innowhere.jnieasy.core.mem.DynamicLibrary;
import java.io.*;
import java.util.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.BehaviorOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FreeCodeGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;



public class JavaClassAsNativeMultipleFieldContainerGenRender
{
    protected JavaClassAsNativeMultipleFieldContainerGen javaClassGen;
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerGenRender
     */
    public JavaClassAsNativeMultipleFieldContainerGenRender(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        this.javaClassGen = classGen;
    }
    
    public static JavaClassAsNativeMultipleFieldContainerGenRender newJavaClassAsMultipleFieldContainerGenRender(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new JavaClassAsNativeMultipleFieldContainerGenRender(classGen);
    }
    
    public JavaClassAsNativeMultipleFieldContainerGen getJavaClassAsMultipleFieldContainerGen()
    {
        return javaClassGen;
    }
    
    public String generate()
    {
        JavaClassAsNativeMultipleFieldContainerImpl javaClass = javaClassGen.getJavaClassAsMultipleFieldContainer();
        
        String decBaseClass = "";
        if (javaClassGen.getBaseClass() != null)
            decBaseClass = " extends " + javaClassGen.getBaseClass() + " ";
        StringBuffer decInterfaces = new StringBuffer();
        if (javaClassGen.getInterfaces() != null)
            decInterfaces.append( " implements " + javaClassGen.getInterfaces() + " " );        
       
        StringBuffer code = new StringBuffer();
        code.append( "public class " + javaClassGen.getSimpleName() + decBaseClass + decInterfaces + " \n" );
        code.append( "{ \n" );        
        code.append( "    public static " + JNIEasy.class.getName() + " jnieasyRoot = " + JNIEasy.class.getName() + ".get(); \n" );
        code.append( "    public static " + DynamicLibrary.class.getName() + " jnieasyDLL = jnieasyRoot.getDLLManager().get(\"" + javaClass.getLibraryPathToUpper() + "\"); \n" );        
        code.append( "    public static " + NativeBehavior.class.getName() + "[] jnieasyMethodList = new " + NativeBehavior.class.getName() + "[ " + javaClassGen.getMethods().size() + " ]; \n" );
        
        code.append( "\n" );
        
        for(Iterator it = javaClassGen.getFreeCodes().iterator(); it.hasNext(); )
        {
            FreeCodeGen freeCodeGen = (FreeCodeGen)it.next();
            FreeCodeGenRender freeCodeRender = FreeCodeGenRender.newFreeCodeGenRender(freeCodeGen);
            code.append( freeCodeRender.generate() );
            code.append( "\n" );     
        }        
        
        for(Iterator it = javaClassGen.getFields().iterator(); it.hasNext(); )
        {
            FieldOfClassGen fieldGen = (FieldOfClassGen)it.next();
            FieldOfClassGenRender fieldRender = FieldOfClassGenRender.newFieldOfClassGenRender(fieldGen);
            code.append( fieldRender.generate() );
            code.append( "\n" );            
        }        
        
        for(Iterator it = javaClassGen.getMethods().iterator(); it.hasNext(); )
        {
            BehaviorOfClassGen methodGen = (BehaviorOfClassGen)it.next();
            BehaviorOfClassGenRender methodRender = BehaviorOfClassGenRender.newBehaviorOfClassGenRender(methodGen);
            code.append( methodRender.generate() );
            code.append( "\n" );           
        }
        
        code.append( "}" );
        
        return code.toString();
    }
}
