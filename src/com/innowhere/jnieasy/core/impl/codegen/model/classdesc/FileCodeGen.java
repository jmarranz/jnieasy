/*
 * DLLGen.java
 *
 * Created on 26 de marzo de 2004, 19:09
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportList;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.PackageDec;


public class FileCodeGen
{
    protected String name;
    protected PackageDec pkg = new PackageDec();
    protected ImportList importList = new ImportList();
    protected JavaClassAsNativeMultipleFieldContainerGen javaClassGen; // Por ahora sólo admitimos una clase
    protected Generator generator;
    
    /** Creates a new instance of DLLGen */
    public FileCodeGen(Generator generator)
    {
        this.generator = generator;
    }

    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }

    public PackageDec getPackage()
    {
        return pkg;
    }
    
    public JavaClassAsNativeMultipleFieldContainerGen getJavaClassAsMultipleFieldContainerGen()
    {
        return javaClassGen;
    }    
    
    public void setJavaClassAsMultipleFieldContainerGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        this.javaClassGen = classGen;
    }
    
    public Generator getGenerator()
    {
        return generator;
    }
    
    public String getJavaFilePath()
    {
        return generator.getFileOutputPath() + "/" + getName() + ".java";
    }
    
    public String getJavaClassFilePath()
    {
        return generator.getFileOutputPath() + "/" + getName() + ".class";
    }    

    public ImportList getImportList()
    {
        return importList;
    }
}
