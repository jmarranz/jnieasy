/*
 * DLLInterfaceGenerator.java
 *
 * Created on 26 de marzo de 2004, 18:39
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import java.io.*;
import org.w3c.dom.*;
import org.w3c.dom.traversal.TreeWalker;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.*;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FileCodeGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.Generator;
import com.innowhere.jnieasy.core.impl.codegen.render.classdesc.FileCodeGenRender;


public class GeneratorXML
{
    protected Generator generator;
    
    /** Creates a new instance of DLLInterfaceGenerator */
    protected GeneratorXML(Generator generator)
    {
        this.generator = generator;
    }

    public static GeneratorXML newGeneratorXML(JNIEasyImpl jnieasy)
    {
        return new GeneratorXML(new Generator(jnieasy));
    }
    
    public Generator getGenerator()
    {
        return generator;
    }

    public void parse(String filePath,String outputPath)
    {
        final File fileIn = new File(filePath);
        final File fileOut = new File(outputPath);        
        try
        {
            generator.setFileInput(fileIn);
            generator.setFileOutput(fileOut);

            Document doc = XMLUtil.parse(filePath);

            // <jniEasyJavaCodeGen version="x.y>
            Element jniEasyDLL = XMLUtil.getDocumentElement(doc,"jniEasyJavaCodeGen");
            
            int[] version = JNIEasyImpl.parseVersion(XMLUtil.getAttribute(jniEasyDLL,"version"));
            if (version[0] < 1) throw new JNIEasyException("Bad version number, must be >= 1");
           
            TreeWalker walker = TreeWalkerUtil.createTreeWalker(jniEasyDLL);

            XMLTask fileGenOrIncludeTask = new XMLTask()
            {
                public void doTask(Element fileGenOrIncludeNode,TreeWalker walker,int counter)
                {
                    try
                    {
                        String tagName = fileGenOrIncludeNode.getTagName();
                        if (tagName.equals("fileGen")) // <fileGen>
                        {
                            FileCodeGenXML fileGenXML = FileCodeGenXML.newFileCodeGenXML(generator);
                            if (fileGenXML.parse(fileGenOrIncludeNode,walker))
                            {
                                FileCodeGen fileGen = fileGenXML.getFileCodeGen();
                                generator.addFileCodeGen(fileGen);  

                                FileCodeGenRender fileGenRender = FileCodeGenRender.newFileCodeGenRender(fileGen);
                                fileGenRender.generate();                            
                            }
                        }
                        else if (tagName.equals("include")) // <include>
                        {
                            String fileIncPath = XMLUtil.getAttribute(fileGenOrIncludeNode,"file");

                            GeneratorXML generatorIncXML = GeneratorXML.newGeneratorXML(generator.getJNIEasy());
                            Generator generatorInc = generatorIncXML.getGenerator();
                            generator.addInclude(generatorInc);

                            String incInputPath = Util.formAbsoluteFilePath(fileIn.getParent(),fileIncPath);
                            String incOutputPathDir = Util.formAbsoluteFilePath(fileOut.getAbsolutePath(),fileIncPath);                        
                            incOutputPathDir = new File(incOutputPathDir).getParent();
                            generatorIncXML.parse(incInputPath,incOutputPathDir);
                        }
                        else throw new JNIEasyException("Tag name must be <fileGen> or <include>");
                    }
                    catch(JNIEasyXMLException ex)
                    {
                        throw ex;
                    }        
                    catch(Exception ex)
                    {
                        throw new JNIEasyXMLException(ex,fileGenOrIncludeNode);
                    }                          
                }
            };
            
            TreeWalkerUtil.processChildElements(walker,fileGenOrIncludeTask);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Processing archive: " + fileIn.getAbsolutePath(),ex);
        }            
    }    
}
