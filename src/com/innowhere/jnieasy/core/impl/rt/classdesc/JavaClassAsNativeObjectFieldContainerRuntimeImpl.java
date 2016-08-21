/*
 * JavaClassAsNativeObjectFieldContainerRuntimeImpl.java
 *
 * Created on 29 de septiembre de 2005, 14:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeObjectFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeFieldDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeObjectFieldContainerDescriptor;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeObjectFieldContainerRuntimeImpl extends JavaClassAsNativeFieldContainerRuntimeImpl implements NativeObjectFieldContainerDescriptor
{
    protected FieldOfClassAsNativeObjectFieldContainerRuntimeImpl fieldRt;
    
    /**
     * Creates a new instance of JavaClassAsNativeObjectFieldContainerRuntimeImpl
     */
    public JavaClassAsNativeObjectFieldContainerRuntimeImpl(JavaClassAsNativeObjectFieldContainerImpl javaClass,ClassTypeNativeFieldContainerRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
        
    public NativeFieldDescriptor getField()
    {
        return (NativeFieldDescriptor)fieldRt;
    }
    
    public FieldOfClassRuntimeImpl getFieldDescriptor()
    {
        return fieldRt;
    }    
    
    public void setFieldDescriptor(String fieldName,VarTypeNative varTypeDec)
    {
        VarTypeNativeRuntimeImpl varTypeDecRt = (VarTypeNativeRuntimeImpl)varTypeDec;        
        this.fieldRt = (FieldOfClassAsNativeObjectFieldContainerRuntimeImpl)newFieldOfClassRuntime(fieldName,varTypeDecRt);
    }            
}
