/*
 * JavaClassAsNativeMultipleFieldContainerGen.java
 *
 * Created on 29 de junio de 2005, 13:27
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.codegen.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeMultipleFieldContainerGen extends JavaClassAsNativeFieldContainerGen
{
    protected FileCodeGen fileGen;    
    protected List methods = new ArrayList();
    protected List fields = new ArrayList();    
    protected List freeCodes = new ArrayList();
    protected String simpleName;
    protected String baseClass;
    protected String interfaces;    
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerGen
     */
    public JavaClassAsNativeMultipleFieldContainerGen(JavaClassAsNativeMultipleFieldContainerImpl javaClass)
    {
        super(javaClass);
    }
   
    public String getFullName()
    {
        return javaClass.getClassTypeNativeCapable().getClassName();        
    }
    
    public String getSimpleName()
    {
        return simpleName;
    }
    
    public void setSimpleName(String simpleName)
    {
        this.simpleName = simpleName;
    }    
    
    public JavaClassAsNativeMultipleFieldContainerImpl getJavaClassAsMultipleFieldContainer()
    {
        return (JavaClassAsNativeMultipleFieldContainerImpl)javaClass;
    }
    
    public ClassTypeNativeMultipleFieldContainerImpl getClassTypeMultipleFieldContainer()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)javaClass.getClassTypeNativeCapable();
    }

    
    public void addFreeCode(FreeCodeGen freeCode)
    {
        freeCodes.add(freeCode);
    }
    
    public List getFreeCodes()
    {
        return freeCodes;
    }    
    
    public void addBehavior(BehaviorOfClassGen method)
    {
        methods.add(method);
    }

    public List getMethods()
    {
        return methods;
    }
    
    public void addField(FieldOfClassGen field)
    {
        fields.add(field);
    }
    
    public List getFields()
    {
        return fields;
    }
    
    /**
     * Getter for property fileGen.
     * @return Value of property fileGen.
     */
    public FileCodeGen getFileCodeGen()
    {
        return fileGen;
    }
    
    /**
     * Setter for property fileGen.
     * @param fileGen New value of property fileGen.
     */
    public void setFileCodeGen(FileCodeGen fileGen)
    {
        this.fileGen = fileGen;
    }    

    public String getBaseClass()
    {
        return baseClass;
    }

    public void setBaseClass(String baseClass)
    {
        this.baseClass = baseClass;
    }

    public String getInterfaces()
    {
        return interfaces;
    }

    public void setInterfaces(String interfaces)
    {
        this.interfaces = interfaces;
    }
}
