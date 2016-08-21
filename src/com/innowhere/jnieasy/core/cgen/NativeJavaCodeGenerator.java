/*
 * NativeJavaCodeGenerator.java
 *
 * Created on 1 de febrero de 2005, 21:04
 */

package com.innowhere.jnieasy.core.cgen;

import com.innowhere.jnieasy.core.*;
import java.net.URL;

/**
 * The <code>NativeJavaCodeGenerator</code> is the interface used to generate code
 * of user defined clasess with methods working usually as proxies 
 * of DLL methods
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see JNIEasy#getJavaCodeGenerator()
 */

public interface NativeJavaCodeGenerator
{
    /**
     * Generates the code of the user defined classes specified in the XML file located
     * with the <code>filePath</code> parameter. The XML file is a XML generation descriptor.
     * <p>
     * The resulting classes will be saved in the directory specified with the
     * <code>outputDir<code> parameter, this directory is the starting point to
     * resolve relative paths used in XML descriptors.
     * <p>
     * There is no name convention to XML generation descriptor files,
     * but is recommended to keep symmetry with the enhancing format:
     *  <blockquote>
     *  <i>SimpleClassName</i>.jnieasy.gen.xml
     *  </blockquote>
     * because a generated class can be enhanced (if needed as a native capable class) 
     * and needs a XML enhancement descriptor too.
     * <p>
     * For instance, if the XML file specified by <code>filePath</code>
     * includes other XML descriptor file in a relative subdirectory named "mysubdir", then
     * a described class in this XML, named <code>MyClass</code>, will be saved on
     * <code><pre>outputDir + "/mysubdir/MyClass.java"</pre></code>
     * <p>
     * In the code generation process, native information of related native
     * capable classes (parameter or member field types etc), is needed by
     * the framework, they must be enhanced on filesystem or enhanced
     * on load: if <code>includeImports</code> is not <code>null</code>
     * the on load enhancement is enabled before code generation invoking the method
     * {@link com.innowhere.jnieasy.core.enh.NativeEnhancer#enableOnLoad(String[],String[])} passing
     * <code>includeImports</code> and <code>excludeImports</code>
     * as parameters, this way related classes not need be enhanced on filesystem.
     * If <code>includeImports</code> is <code>null</code> <code>excludeImports</code>
     * is ignored.
     * <p>
     * Code generation is recommended when mapping C methods of dynamic link libraries
     * with many exported methods and only a few of them are used in the program.
     *
     * @param filePath the location of XML file listing the classes to generate
     * @param outputDir the directory root to save generated files
     * @param includeImports the classes to enhance on load if needed. Can be null.
     * @param excludeImports the classes to exclude of enhancing on load. Can be null.
     */
    public void generate(String filePath,String outputDir,String[] includeImports,String[] excludeImports);
    
    /**
     * Generates the code of the user defined native capable classes specified in the XML file located
     * with the <code>filePath</code> parameter. The XML file is a XML generation descriptor.
     *
     * Current implementation is:
     * <blockquote><code>
     * return generate(filePath,outputDir,null,null);
     * </code></blockquote>
     *
     * @param filePath the location of XML file listing the classes to generate
     * @param outputDir the directory root to save generated files
     * @see #generate(String,String,String[],String[])
     */
    public void generate(String filePath,String outputDir);
}
