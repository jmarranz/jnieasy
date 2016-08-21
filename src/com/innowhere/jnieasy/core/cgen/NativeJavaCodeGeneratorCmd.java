/*
 * DLLInterfaceGenerator.java
 *
 * Created on 26 de marzo de 2004, 18:39
 */

package com.innowhere.jnieasy.core.cgen;

import com.innowhere.jnieasy.core.JNIEasy;

/**
 * <code>NativeJavaCodeGeneratorCmd</code> generates code of user defined classes 
 * with methods working usually as proxies of DLL methods, using the command line.
 * 
 * @author Jose M. Arranz Santamaria
 */

public class NativeJavaCodeGeneratorCmd 
{
  
    private static void showUsage()
    {
        String usage = "Bad params.\n";
        usage += "Usage: java " + NativeJavaCodeGeneratorCmd.class.getName() + " [-enhanceOnLoad includeImportList [-excludeImports excludeImportList]] xmlDescriptorPath  outputDir";
        System.out.println(usage);        
    }
    
    /**
     * Generates code of native classes using the command line.
     * <p>
     * Usage: 
     * <blockqoute><pre>
     * java com.innowhere.jnieasy.core.NativeJavaCodeGeneratorCmd [-enhanceOnLoad <i>includeImportList</i> [-excludeImports <i>excludeImportList</i>]] <i>xmlDescriptorPath</i>  <i>outputDir</i>
     * </pre></blockquote>     
     * 
     * Where <code>includeImportList</code> is the ';' separated list of import
     * expressions, as specified in {@link com.innowhere.jnieasy.core.enh.NativeEnhancer#enableOnLoad(String[],String[],ClassLoader)},
     * and <code>excludeImportList</code> is the excluded list. 
     * 
     * <code>xmlDescriptorPath</code> is the XML generation descriptor file of classes to
     * generate, and <i>outputDir</i> is the directory root to save generated classes,
     * as described in {@link NativeJavaCodeGenerator#generate(String,String)}.
     * 
     * @param args the command line arguments
     * @see NativeJavaCodeGenerator#generate(String,String,String[],String[])
     */   
    
    public static void main(String[] args) throws Throwable
    {    
        String[] includeImports = null;
        String[] excludeImports = null;
        String filePath;
        String outputPath;
        try
        {
            int i = 0;
            if (args[0].equals("-enhanceOnLoad"))
            {
                includeImports = args[1].split(";");
                i = 2;
                if (args[2].equals("-excludeImports"))
                {
                    excludeImports = args[3].split(";");
                    i = 4;
                }
            }

            filePath = args[i];
            outputPath = args[i + 1];
        }
        catch(Exception ex)
        {
            showUsage();
            return;
        }
        
        JNIEasy jnieasy = JNIEasy.get();
        jnieasy.load(); // se necesita pues las clases se cargan como Class lo cual ejecuta las rutinas estáticas
        jnieasy.getJavaCodeGenerator().generate(filePath,outputPath,includeImports,excludeImports);
    }
}
