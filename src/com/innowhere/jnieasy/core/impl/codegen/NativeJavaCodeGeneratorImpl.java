/*
 * DLLInterfaceGenerator.java
 *
 * Created on 26 de marzo de 2004, 18:39
 */

package com.innowhere.jnieasy.core.impl.codegen;

import com.innowhere.jnieasy.core.cgen.NativeJavaCodeGenerator;
import com.innowhere.jnieasy.core.impl.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.Generator;
import com.innowhere.jnieasy.core.impl.codegen.xml.classdesc.GeneratorXML;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;

public class NativeJavaCodeGeneratorImpl implements NativeJavaCodeGenerator
{
    protected JNIEasyImpl jniEasy;
    
    /** Creates a new instance of DLLInterfaceGenerator */
    public NativeJavaCodeGeneratorImpl(JNIEasyImpl jniEasy)
    {
        this.jniEasy = jniEasy;
    }
    
    public JNIEasyImpl getJNIEasy()
    {
        return jniEasy;
    }
    
    public void generate(String filePath, String outputPath, String[] includeImports,String[] excludeImports)
    {    
        JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)getJNIEasy().getJNIEasyLib();
        dll.checkLicense(4 /*JAVA_CODE_GENERATION */,0);
        
        if (includeImports != null)
            jniEasy.getEnhancer().enableOnLoad(includeImports,excludeImports);
        
        GeneratorXML genXML = GeneratorXML.newGeneratorXML(jniEasy);
        //Generator generator = genXML.getGenerator();
        genXML.parse(filePath,outputPath);

        //GeneratorRender genFile = GeneratorRender.newGeneratorRender(generator);
        //genFile.generate();
    }
    
    public void generate(String filePath, String outputPath)
    {  
        generate(filePath,outputPath,null,null);
    }    
}
