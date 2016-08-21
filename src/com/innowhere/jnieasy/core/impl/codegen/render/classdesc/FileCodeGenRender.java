/*
 * DLLGen.java
 *
 * Created on 26 de marzo de 2004, 19:09
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.io.*;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.ImportListRender;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FileCodeGen;


public class FileCodeGenRender
{
    protected FileCodeGen fileGen;
    
    /** Creates a new instance of DLLGen */
    public FileCodeGenRender(FileCodeGen fileGen)
    {
        this.fileGen = fileGen;
    }
    
    public FileCodeGen getFileCodeGen()
    {
        return fileGen;
    }
    
    public static FileCodeGenRender newFileCodeGenRender(FileCodeGen fileGen)
    {
        return new FileCodeGenRender(fileGen);
    }
/*
    public boolean hasChanged(String code,String outputPath)
    {
        // Comprobamos si ya existe y el contenido es exactamente igual al que
        // que se ha generado        
        File fileIn = new File(outputPath);  
        if (!fileIn.exists()) return true;
        
        String codeOnFile = "";
        try
        {
            InputStreamReader streamIn = new InputStreamReader(new BufferedInputStream(new FileInputStream(fileIn)));
            char[] buffer = new char[2*1024];

            int readed;
            while((readed = streamIn.read(buffer, 0, buffer.length)) != -1) 
            {
                codeOnFile += new String(buffer,0,readed);
            }        
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }        
   
        return !codeOnFile.equals(code);
    }
*/    
    public void generate()
    {
        try
        {
            String code = generateCode();   
         
            String outputPath = fileGen.getJavaFilePath(); 
/*           
            // Si ya existe y el contenido es exactamente igual al que
            // que generamos no actualizamos el archivo y así evitamos que
            // se recompile de nuevo.
            if (!hasChanged(code,outputPath))                          
                return; 
*/         
            
            PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath));
            writer.print(code);
            writer.close();
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public String generateCode()
    {
        StringBuffer code = new StringBuffer();
        
        code.append( "// " + fileGen.getName() + "\n" );
        code.append( "package " + fileGen.getPackage().getName() + "; \n" );
        code.append( "\n" );
        
        // Los imports sólo son necesarios cuando haya clases definidas por el usuario
        // que no existen (no compiladas todavía) y por tanto no se pudo saber cual es
        // nombre absoluto en tiempo de generación
        ImportListRender importListRender = ImportListRender.newImportListRender(fileGen.getImportList());
        code.append( importListRender.generate() );
        code.append( "\n" );
        
        JavaClassAsNativeMultipleFieldContainerGen classGen = fileGen.getJavaClassAsMultipleFieldContainerGen();
        JavaClassAsNativeMultipleFieldContainerGenRender classGenRender = JavaClassAsNativeMultipleFieldContainerGenRender.newJavaClassAsMultipleFieldContainerGenRender(classGen);
        code.append( classGenRender.generate() );
        
        return code.toString();   
    }    
}
