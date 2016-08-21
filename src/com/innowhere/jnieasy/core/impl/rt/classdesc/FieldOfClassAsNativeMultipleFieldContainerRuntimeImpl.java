/*
 * FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl.java
 *
 * Created on 29 de junio de 2005, 13:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeFieldStructureDescriptor;
import java.lang.reflect.Field;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl extends FieldOfClassRuntimeImpl implements NativeFieldStructureDescriptor
{
    protected int auxNativeObjectIndex = -1;    
    protected long alignSize = 1;
    
    /**
     * Creates a new instance of FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl
     */
    public FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl(FieldOfClassAsNativeMultipleFieldContainerImpl accessObjectClass,Field field,JavaClassAsNativeMultipleFieldContainerRuntimeImpl javaClass)
    {
        super(accessObjectClass,field,javaClass);
    }
    
    public FieldOfClassAsNativeMultipleFieldContainerImpl getFieldOfClassAsMultipleFieldContainer()
    {
        return (FieldOfClassAsNativeMultipleFieldContainerImpl)memberOfClass;
    }
    
    public JavaClassAsNativeMultipleFieldContainerRuntimeImpl getJavaClassAsNativeMultipleFieldContainerRuntime()
    {
        return (JavaClassAsNativeMultipleFieldContainerRuntimeImpl)javaClass;
    }
    
    public long alignSize()
    {
	return alignSize;
    }
    
    public void setDesiredAlignSize(String desiredAlignSizeExpr)
    {
        long desiredAlignSize = getRuntimeManager().getTypeManagerRuntime().parseMemorySizeWithMacros(desiredAlignSizeExpr); 
        
        // Si se ha especificado alignSize para el field, tiene prioridad el específico del field sobre el definido para toda la estructura                    
        if (desiredAlignSize == TypeSizes.getUNKNOWN_SIZE())
            desiredAlignSize = getJavaClassAsNativeMultipleFieldContainerRuntime().getDesiredAlignSize();        
        else 
            NativeTypeManagerRuntimeImpl.checkAlignSize(desiredAlignSize);
            
        // Aún especificado explícitamente o el de la estructura, no puede imponerse si es mayor que el "natural", se impone si es menor
        long naturalAlignSize = varTypeRt.preferredAlignSize();        
        this.alignSize = Math.min(naturalAlignSize,desiredAlignSize);        
    }
    
    public int getIndex()
    {
        return getFieldOfClassAsMultipleFieldContainer().getIndex();
    }

    public void setIndex(int index)
    {
        getFieldOfClassAsMultipleFieldContainer().setIndex(index);     
    }    

    public int getAbsIndex()
    {
        return getFieldOfClassAsMultipleFieldContainer().getAbsIndex();
    }

    public void setAbsIndex(int index)
    {
        getFieldOfClassAsMultipleFieldContainer().setAbsIndex(index);
    }        
    
    public int getAbsAuxNativeObjectIndex()
    {
        return auxNativeObjectIndex;
    }

    public void setAbsAuxNativeObjectIndex(int auxNativeObjectIndex)
    {
        this.auxNativeObjectIndex = auxNativeObjectIndex;
    }
    
    public long size()
    {
        return getVarTypeNativeRuntime().size();          
    }
}
