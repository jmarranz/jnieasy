/*
 * DLLInterfaceGenerator.java
 *
 * Created on 26 de marzo de 2004, 18:39
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import java.util.*;
import com.innowhere.jnieasy.core.impl.*;
import java.io.File;

public class Generator
{
    protected List files = new LinkedList();
    protected List includes = new LinkedList();
    protected File fileIn; 
    protected File fileOut;    
    protected String relFilePath; // Sólo es útil si es procesado como un include 

    protected JNIEasyImpl jniEasy;
    
    /** Creates a new instance of DLLInterfaceGenerator */
    public Generator(JNIEasyImpl jniEasy)
    {
        this.jniEasy = jniEasy;
    }
    
    public JNIEasyImpl getJNIEasy()
    {
        return jniEasy;
    }
    
    public List getFiles()
    {
        return files;
    }

    public List getIncludes()
    {
        return includes;
    }    
    
    public void addFileCodeGen(FileCodeGen fileGen)
    {
        files.add(fileGen);
    }
    
    public void addInclude(Generator generator)
    {
        includes.add(generator);                
    }

    public String getFileInputPath()
    {
        return fileIn.getAbsolutePath();
    }

    public File getFileInput()
    {
        return fileIn;
    }    
    
    public void setFileInput(File fileIn)
    {
        this.fileIn = fileIn;
    }
 
    /**
     * Getter for property outputPath.
     * @return Value of property outputPath.
     */
    public String getFileOutputPath()
    {
        return fileOut.getAbsolutePath();
    }
    
    /**
     * Setter for property outputPath.
     * @param outputPath New value of property outputPath.
     */
    public void setFileOutput(File fileOut)
    {
        this.fileOut = fileOut;
    }
    
}
