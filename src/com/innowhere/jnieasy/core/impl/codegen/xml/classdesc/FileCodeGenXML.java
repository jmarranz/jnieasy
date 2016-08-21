/*
 * DLLGen.java
 *
 * Created on 26 de marzo de 2004, 19:09
 */

package com.innowhere.jnieasy.core.impl.codegen.xml.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyXMLException;
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;
import java.io.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.ImportListXML;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FileCodeGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.Generator;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.util.TreeWalkerUtil;
import com.innowhere.jnieasy.core.impl.util.XMLTask;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;


public class FileCodeGenXML
{
    protected FileCodeGen fileGen;
    
    /** Creates a new instance of DLLGen */
    public FileCodeGenXML(FileCodeGen fileGen)
    {
        this.fileGen = fileGen;
    }
    
    public FileCodeGen getFileCodeGen()
    {
        return fileGen;
    }
    
    public static FileCodeGenXML newFileCodeGenXML(Generator generator)
    {
        return new FileCodeGenXML(new FileCodeGen(generator));
    }

    public boolean parse(Element codeGenNode,TreeWalker walker)
    {
        try
        {
            // Ej. <fileGen name="SimpleFileName">
            fileGen.setName(XMLUtil.getAttribute(codeGenNode,"name"));

            // Ahora ya tenemos toda la información para localizar el futuro archivo .java y .class
            // Sólo generamos si el archivo .java es más viejo o igual que el XML fuente (pues la precisión en milisegundos es imprecisa, pueden ocurrir muchas cosas dentro del mismo milisegundo)
            File fileInput = fileGen.getGenerator().getFileInput(); // El XML origen
            File fileOutput = new File(fileGen.getJavaFilePath());
            if (fileOutput.exists() && (fileOutput.lastModified() > fileInput.lastModified()))
                return false; // El caso igual no lo consideramos por dudoso
            
            // es posible que el .class exista de un anterior proceso y que esté
            // en el CLASSPATH más aún si está el onload enhancer puesto, para evitar que interfiera 
            // nos lo cargamos
            new File(fileGen.getJavaClassFilePath()).delete();
            
                // <package name="test.com.innowhere.jnieasy.core" />
                Element packageNode = TreeWalkerUtil.firstChildElement(walker,"package",true);
                fileGen.getPackage().setName(XMLUtil.getAttribute(packageNode,"name"));
                
                parseImportsAndClasses(packageNode,walker);
          
                TreeWalkerUtil.parentElement(walker);  
                
            return true;
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,codeGenNode);
        }                 
    }

    public void parseImportsAndClasses(Element packageNode,TreeWalker walker)
    {
        try
        {
            // <imports> ... </imports>
            Element importsNode = TreeWalkerUtil.firstChildElement(walker,"imports",true);
            ImportListXML importListXML = ImportListXML.newImportListXML(fileGen.getImportList());
            importListXML.parse(importsNode,walker);

            parseClasses(walker); // <class ... /> que siguen

            TreeWalkerUtil.parentElement(walker);  
        }
        catch(JNIEasyXMLException ex)
        {
            throw ex;
        }        
        catch(Exception ex)
        {
            throw new JNIEasyXMLException(ex,packageNode);
        }        
    }

    public void parseClasses(TreeWalker walker)
    {    
        final CodeGenContext ctx = new CodeGenContext(fileGen, fileGen.getGenerator().getJNIEasy());
        final JNIEasyImpl jniEasy = ctx.getJNIEasy();

        final FileCodeGenXML thisFileCodeGenXML = this;
        XMLTask classTask = new XMLTask()
        {
            public void doTask(Element classNode,TreeWalker walker,int counter)
            {
                // <class name="ToEnhanceClass" ...>
                JavaClassAsNativeMultipleFieldContainerGenXML classGenXML = JavaClassAsNativeMultipleFieldContainerGenXML.newClassGenXML(thisFileCodeGenXML,jniEasy);
                classGenXML.parse(classNode,walker,ctx);                            
                JavaClassAsNativeMultipleFieldContainerGen classGen = classGenXML.getJavaClassAsMultipleFieldContainerGen();
                fileGen.setJavaClassAsMultipleFieldContainerGen(classGen);
                classGen.setFileCodeGen(fileGen); 
            }
        };

        TreeWalkerUtil.processElementsToEnd(walker, classTask,"class");        
    }
}
