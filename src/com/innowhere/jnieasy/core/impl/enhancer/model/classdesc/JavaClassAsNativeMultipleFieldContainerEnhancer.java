/*
 * JavaClassAsNativeMultipleFieldContainerEnhancer.java
 *
 * Created on 11 de diciembre de 2004, 21:01
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancerXML;
import com.innowhere.jnieasy.core.impl.enhancer.xml.classdesc.JavaClassAsNativeCapableEnhancerXML;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import java.util.ArrayList;
import java.util.List;

public abstract class JavaClassAsNativeMultipleFieldContainerEnhancer extends JavaClassAsNativeFieldContainerEnhancer
{
    protected ArrayList behaviors = new ArrayList();    
    protected String desiredAlignSize = Long.toString(TypeSizes.getUNKNOWN_SIZE());  // el valor de alineamiento de los atributos de la estructura que queremos aplicar
    protected List fields = new ArrayList(); 
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerEnhancer
     */
    public JavaClassAsNativeMultipleFieldContainerEnhancer(JavaClassAsNativeMultipleFieldContainerImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);        
    }
    
    public ClassTypeNativeMultipleFieldContainerImpl getClassTypeMultipleFieldContainer()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)getClassTypeNativeCapable();
    }
    
    public JavaClassAsNativeMultipleFieldContainerImpl getJavaClassAsMultipleFieldContainer()
    {
        return (JavaClassAsNativeMultipleFieldContainerImpl)javaClass;
    }
        
    public boolean getDefaultAllMethods()
    {
        return false;
    }    
    
    public boolean getDefaultAllFields()
    {
        return true;
    }
    
    public void addField(FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnh)
    {
        FieldOfClassAsNativeMultipleFieldContainerImpl field = fieldEnh.getFieldOfClassAsMultipleFieldContainer();
        field.setIndex(getFieldsCount());
        field.setAbsIndex(getAbsFieldsCount());     
        
        fields.add(fieldEnh);
    }
    
    public List getFields()
    {
        return fields;
    }
    
    public int getFieldsCount()
    {
        return fields.size();
    }    
    
    public int getAbsFieldsCount()
    {
        return fields.size();
    }
    
    public String getDesiredAlignSize()
    {
        return desiredAlignSize;
    }

    public void setDesiredAlignSize(String desiredAlignSize)
    {
        this.desiredAlignSize = desiredAlignSize;
    }
    
    public ArrayList getBehaviors()
    {
        return behaviors;
    }    
    
    public boolean addBehavior(BehaviorOfClassEnhancer methodEnhancer)
    {
        methodEnhancer.setIndex(behaviors.size());
        return behaviors.add(methodEnhancer);
    }

    public boolean writeFile(String outputDir)
    {
        if (super.writeFile(outputDir))
        {
            for(int i=0; i < behaviors.size(); i++)
            {
                BehaviorOfClassEnhancer behavior = (BehaviorOfClassEnhancer)behaviors.get(i);
                if (!behavior.isOnLibrary() && !behavior.isUseReflection())
                {
                    JavaClassAsNativeDirectCallbackEnhancer callback = behavior.getJavaClassAsNativeDirectCallbackEnhancer();
                    callback.writeFile(outputDir);
                }
            }
            return true;
        }
        else return false;            
    }    
    
    public JavaClassAsNativeCapableEnhancerXML newJavaClassAsNativeCapableEnhancerXML()
    {
        return new JavaClassAsNativeMultipleFieldContainerEnhancerXML(this);
    }       
}
