/*
 * NativePointerStateManagerImpl.java
 *
 * Created on 28 de septiembre de 2005, 15:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeSingleFieldContainerInternal;


/**
 *
 * @author jmarranz
 */
public class NativePointerStateManagerImpl extends NativeObjectFieldContainerStateManagerImpl
{
    
    /**
     * Creates a new instance of NativePointerStateManagerImpl
     */
    public NativePointerStateManagerImpl()
    {
    }   
    
    protected void setNewAuxObjectsArray()
    {
        if (needAuxObjects())
            setNewAuxObjectsArray(1);
    }    
    
    public Object getFieldValueTxn(int fieldIndex)
    {
        // fieldIndex siempre será cero        
        NativeSingleFieldContainerInternal value = getSingleFieldContainerInternal();
        return value.getValue();                  
    }    
    
    public void setFieldValueTxn(int fieldIndex,Object fieldValue)
    {
        // fieldIndex siempre será cero         
        NativeSingleFieldContainerInternal value = getSingleFieldContainerInternal();          
        value.setValue(fieldValue);       
    }    
    
    public int getAbsoluteTxnFieldCount()
    {     
        return 1;
    }          
    
    public int getAbsAuxNativeObjectIndex(int absFieldIndex)
    {
        // absFieldIndex siempre será cero         
        if (needAuxObjects())            
            return absFieldIndex;
        else
            return -1; // No se necesita auxiliar
    }        
}
