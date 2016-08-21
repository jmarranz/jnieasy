/*
 * JavaClassAsNativeCapableImpl.java
 *
 * Created on 17 de junio de 2005, 9:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;



/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeCapableImpl
{
    protected ClassTypeNativeCapableImpl classType;
   
    
    /**
     * Creates a new instance of JavaClassAsNativeCapableImpl
     */
    public JavaClassAsNativeCapableImpl(ClassTypeNativeCapableImpl classType)
    {
        this.classType = classType;
    }
    
    public ClassTypeNativeCapableImpl getClassTypeNativeCapable()
    {
        return (ClassTypeNativeCapableImpl)classType;
    }
    
    public abstract String getLibraryPathToUpper();    
    
    public abstract JavaClassAsNativeCapableXML newJavaClassAsNativeCapableXML();
    public abstract JavaClassAsNativeCapableEnhancer newJavaClassAsNativeCapableEnhancer(EnhancerSharedContext ctx);
    public abstract FieldOfClassImpl newFieldOfClass(VarTypeNativeImpl varType);
}
