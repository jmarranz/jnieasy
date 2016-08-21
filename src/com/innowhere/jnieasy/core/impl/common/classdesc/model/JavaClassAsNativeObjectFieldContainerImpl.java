/*
 * JavaClassAsNativeObjectFieldContainerImpl.java
 *
 * Created on 29 de septiembre de 2005, 13:35
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeObjectFieldContainerImpl extends JavaClassAsNativeFieldContainerImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeObjectFieldContainerImpl
     */
    public JavaClassAsNativeObjectFieldContainerImpl(ClassTypeNativeObjectFieldContainerImpl classType)
    {
        super(classType);
    }

    public String getLibraryPathToUpper()
    {
        // No se usa
        return null;        
    }    

    public JavaClassAsNativeCapableXML newJavaClassAsNativeCapableXML()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
    
    public FieldOfClassImpl newFieldOfClass(VarTypeNativeImpl varType)
    {
        return new FieldOfClassAsNativeObjectFieldContainerImpl(this,(VarTypeNativeObjectImpl)varType);
    }        
}
