/*
 * NativeEnhancer.java
 *
 * Created on 28 de enero de 2005, 21:20
 */

package com.innowhere.jnieasy.core.enh;

import com.innowhere.jnieasy.core.*;
import java.net.URL;

/**
 * The <code>NativeEnhancer</code> is the interface used to perform enhancement tasks with 
 * user defined native capable classes.
 * <p>
 * An enhanced class (on filesystem or enhanced on load) contains the complementary
 * native information needed by the framework (native memory layout etc) 
 * to create and manage native instances.
 * <p>
 * If an enhanced class is used first time and loaded as usual, the class register 
 * itself into the framework.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see JNIEasy#getEnhancer()
 */

public interface NativeEnhancer
{
    /**
     * Returns the JNIEasy parent object.
     *
     */      
    public JNIEasy getJNIEasy();
    
    /** 
     * Enables the runtime enhancement of user defined native capable classes. 
     *
     * A new <code>ClassLoader</code> is created, registered with 
     * com.innowhere.jnieasy.core.typedec.NativeTypeManager#setClassLoader(ClassLoader)
     * and returned, 
     * this ClassLoader will be the default of the framework, and 
     * {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#getClassLoader} will return it.
     * <p>
     * The new ClassLoader is an <i>enhancer</i> ClassLoader: 
     * if the class to load is a user defined native capable it will be enhanced
     * in memory previously to register in the JVM with <code>ClassLoader.defineClass()</code>,
     * if the class is already 
     * enhanced nothing will be done and will be registered normally. 
     * This way, is not necessary a previous enhancement step, because is performed 
     * on runtime automatically when the class is first time used.
     * <p>
     * To enhance a user native capable class on runtime, the ClassLoader needs 
     * to locate the XML native information of the class, this archive is located using
     * <code>ClassLoader.getResource(String)</code> (implies it must be in the classpath of the
     * parent ClassLoader) and must follow this name convention:
     *  <blockquote>
     *  <i>SimpleClassName</i>.jnieasy.enh.xml
     *  </blockquote>
     * For instance: if class name is <code>mypkg1.mypkg2.MyClass</code> , <code>getResource()</code> is 
     * invoked with the parameter: <code>mypkg1/mypkg2/MyClass.jnieasy.enh.xml</code>, if found and valid the class 
     * is enhanced.
     * The <code>parent</code> parameter specifies the parent ClassLoader, the enhancer ClassLoader does not 
     * follow a pure delegation model:
     * <p> 
     * <ol>
     * <li>Delegates to parent if class name match with an exclude import of 
     * the list specified with <code>excludeImports</code> parameter. 
     * <li>Is loaded by self if class name match with an include import of 
     * the list specified with <code>includeImports</code> parameter
     *  or is an internal native wrapper class.
     * <li>Otherwise, delegates to parent.
     * </ol>
     * <p>
     * Specifying what load by self first and what delegate after, is possible enhancing on runtime and 
     * running in any type of "class loading managed environment" because the enhancer 
     * ClassLoader does not need to be the root loader.
     *
     * But when using runtime enhancement, is necessary to load with the enhancer ClassLoader
     * all classes that manipulate native classes, because if a normal class uses a native capable  
     * class and this has not been loaded before, then it will be loaded with the ClassLoader of the normal class, 
     * but if a native capable class not enhanced is loaded with the parent ClassLoader, then it never will be enhanced
     * and never will be native.
     *
     * Achieve that is not very difficult: enable the enhancer before executing any native related code, and 
     * load the starting class explicitly with the enhancer ClassLoader.
     * <p>
     * For instance:
     * <blockquote><pre>
     * String[] included = new String[] { "myapp.nativemgrcode.*" };
     * ClassLoader enhancerCL = enhancer.enableOnLoad(included,null,myParentClassLoader);
     * Class clsStart = Class.forName("myapp.nativemgrcode.Start",true, enhancerCL); 
     * // Start class implements StartInterface
     * StartInterface start = (StartInterface)clsStart.newInstance(); 
     * start.run();
     * </pre></blockquote>
     * 
     * The <code>includeImports</code> and <code>excludeImports</code> parameters are 
     * String arrays with the "import formatted" criteria to include or exclude 
     * (delegate) the class loading. The import format is explained in 
     * {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#setDefaultImports(String[])}. 
     * <p> 
     *
     * The enhancer ClassLoader implements the interface {@link NativeEnhancerClassLoader} to 
     * identification purposes.
     *
     * @param includeImports the included list of classes using Java import syntax
     * @param excludeImports the excluded list of classes using Java import syntax. Can be null
     * @param parent the parent ClassLoader 
     * @return the new enhancer ClassLoader
     *
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#getClassLoader()
     */        
    public ClassLoader enableOnLoad(String[] includeImports,String[] excludeImports,ClassLoader parent);
    
    /**
     * Enables the runtime enhancement of user defined native capable classes using the default ClassLoader
     * of the framework as parent.
     * 
     * Current implementation is:
     * <blockquote><pre>
     * ClassLoader parent = getJNIEasy().getTypeManager().getClassLoader();
     * return enableOnLoad(includeImports,excludeImports,parent);     
     * </pre></blockquote>
     * 
     * 
     * @param includeImports the included list of classes using Java import syntax
     * @param excludeImports the excluded list of classes using Java import syntax, can be null
     * @return the new enhancer ClassLoader
     * @see NativeEnhancer#enableOnLoad(String[],String[],ClassLoader)
     */
    public ClassLoader enableOnLoad(String[] includeImports,String[] excludeImports);
    
    /**
     * Enhances the user defined native capable classes specified in the XML file located 
     * with the <code>filePath</code> parameter.
     *
     * The XML file is a XML enhancement descriptor. 
     *
     * The resulting classes will be saved in the directory specified with the 
     * <code>outputDir</code> parameter, using the equivalent relative directory tree 
     * of the package of each class to save.
     *
     * For instance, if MyClass.class is enhanced and represents mypkg1.mypkg2.MyClass, then
     * the enhanced .class is saved as file: 
     * <code>outputDir + "/" + "mypkg1/mypkg2/MyClass.class"</code>
     *
     * The default ClassLoader as returned by {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#getClassLoader}
     * will be used to locate class files, is not necessary an enhancer ClassLoader. 
     *
     * Enhanced class files do not need XML descriptors anymore to create native objects.
     *
     * @param filePath the location of XML file listing the classes to enhance
     * @param outputDir the directory to save enhanced files
     */    
    public void enhance(URL filePath,String outputDir);    
}
