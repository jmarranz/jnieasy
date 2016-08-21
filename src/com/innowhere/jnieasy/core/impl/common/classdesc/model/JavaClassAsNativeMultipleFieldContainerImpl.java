/*
 * JavaClassAsNativeMultipleFieldContainerImpl.java
 *
 * Created on 17 de junio de 2005, 9:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeMultipleFieldContainerXML;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeMultipleFieldContainerImpl extends JavaClassAsNativeFieldContainerImpl
{
    protected JavaClassAsNativeSeparatedFieldContainerImpl classSuper; // las uniones no pueden servir de base, y es null si es una union
    protected String libraryPath;
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerImpl
     */
    public JavaClassAsNativeMultipleFieldContainerImpl(ClassTypeNativeMultipleFieldContainerImpl classType)
    {
        super(classType);
    }

    public JavaClassAsNativeSeparatedFieldContainerImpl getClassSuper()
    {
        return classSuper;
    }

    public void setClassSuper(JavaClassAsNativeSeparatedFieldContainerImpl classSuper)
    {
        this.classSuper = classSuper;
    }    
    
    public String getLibraryPathToUpper()
    {
        if (libraryPath != null)
            return libraryPath;
        else if (classSuper != null)
            return classSuper.getLibraryPathToUpper();
        else
            return null;           
    }
    
    public String getLibraryPath()
    {
        return libraryPath;
    }
    
    public void setLibraryPath(String libraryPath)
    {
        this.libraryPath = libraryPath;
    }
    
    public FieldOfClassImpl newFieldOfClass(VarTypeNativeImpl varType)
    {
        return new FieldOfClassAsNativeMultipleFieldContainerImpl(this,varType);
    }
    
    public JavaClassAsNativeCapableXML newJavaClassAsNativeCapableXML()    
    {
        return new JavaClassAsNativeMultipleFieldContainerXML(this);
    }
}
