/*
 * JavaClassAsCPPClassGen.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsCPPClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCPPClassCustomImpl;


public class JavaClassAsCPPClassGen extends JavaClassAsNativeSeparatedFieldContainerGen
{
    
    /**
     * Creates a new instance of JavaClassAsCPPClassGen 
     */
    public JavaClassAsCPPClassGen(JavaClassAsCPPClassImpl javaClass)
    {
        super(javaClass);
    }
    
    public static JavaClassAsCPPClassGen newJavaClassAsCPPClassGen(String className,JNIEasyImpl jniEasy)
    {
        ClassTypeCPPClassCustomImpl classType = ClassTypeCPPClassCustomImpl.newCPPClassCustomType(className,jniEasy);
        JavaClassAsCPPClassImpl javaClass = (JavaClassAsCPPClassImpl)classType.getJavaClassAsNativeCapable();            
        return new JavaClassAsCPPClassGen(javaClass);
    }

}
