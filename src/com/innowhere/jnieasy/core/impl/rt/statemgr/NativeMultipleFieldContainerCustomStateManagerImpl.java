/*
 * NativeMultipleFieldContainerCustomStateManagerImpl.java
 *
 * Created on 12 de septiembre de 2005, 14:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.data.NativeUserDefinedClass;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeMultipleFieldContainerInternal;


/**
 *
 * @author jmarranz
 */
public class NativeMultipleFieldContainerCustomStateManagerImpl extends NativeFieldContainerStateManagerImpl
{
    protected JavaClassAsNativeMultipleFieldContainerRuntimeImpl classInfo; // La clase más derivada del objeto
    
    /**
     * Creates a new instance of NativeMultipleFieldContainerCustomStateManagerImpl
     */
    public NativeMultipleFieldContainerCustomStateManagerImpl(JavaClassAsNativeMultipleFieldContainerRuntimeImpl classInfo)
    {
        this.classInfo = classInfo;
    }    
   
    public NativeMultipleFieldContainerInternal getMultipleFieldContainerInternal()
    {
        return (NativeMultipleFieldContainerInternal)value;
    }
    
    protected void setNewAuxObjectsArray()
    {
        JavaClassAsNativeMultipleFieldContainerRuntimeImpl classInfo = (JavaClassAsNativeMultipleFieldContainerRuntimeImpl)((NativeUserDefinedClass)value).jnieasyGetNativeClassDescriptor();
        int auxObjectsNum = classInfo.getAbsAuxNativeObjectCount();
        if (auxObjectsNum == 0) return;

        setNewAuxObjectsArray(auxObjectsNum);
    }        

    public Object getFieldValueTxn(int fieldIndex)
    {
        NativeMultipleFieldContainerInternal value = getMultipleFieldContainerInternal();
        return value.jnieasyGetField(fieldIndex);                
    }
    
    public void setFieldValueTxn(int fieldIndex,Object fieldValue)
    {
        NativeMultipleFieldContainerInternal value = getMultipleFieldContainerInternal();        
        value.jnieasySetField(fieldIndex, fieldValue);        
    }
    
    public int getAbsoluteTxnFieldCount()
    {
        NativeMultipleFieldContainerInternal value = getMultipleFieldContainerInternal();
        return value.jnieasyGetAbsoluteFieldCount();        
    }
    
    public int getAbsAuxNativeObjectIndex(int absFieldIndex)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = (FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo.getAbsoluteField(absFieldIndex);
        return attInfo.getAbsAuxNativeObjectIndex(); // si no se necesita será -1            
    }
}
