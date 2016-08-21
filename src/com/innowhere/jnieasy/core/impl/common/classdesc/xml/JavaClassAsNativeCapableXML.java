/*
 * ClassGen.java
 *
 * Created on 26 de marzo de 2004, 19:10
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.xml;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.util.XMLUtil;
import org.w3c.dom.*;


/**
 *
 * @author  jmarranz
 */


public abstract class JavaClassAsNativeCapableXML
{
    protected JavaClassAsNativeCapableImpl javaClass;
    
    /** Creates a new instance of ClassGen */
    public JavaClassAsNativeCapableXML(JavaClassAsNativeCapableImpl javaClass)
    {
        this.javaClass = javaClass;
    }
    
    public static JavaClassAsNativeCapableXML newJavaClassAsNativeCapableXML(JavaClassAsNativeCapableImpl javaClass)
    {
        return javaClass.newJavaClassAsNativeCapableXML();
    }
    
    public static String getSimpleClassName(Element classNode)
    {
        return XMLUtil.getAttribute(classNode,"name");
    }
}
