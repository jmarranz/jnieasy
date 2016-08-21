/*
 * NativeObjectFieldContainerStateManagerDefaultImpl.java
 *
 * Created on 7 de octubre de 2005, 17:50
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
public class NativeObjectFieldContainerStateManagerDefaultImpl extends NativeObjectFieldContainerStateManagerImpl
{
    
    /**
     * Creates a new instance of NativeObjectFieldContainerStateManagerDefaultImpl
     */
    public NativeObjectFieldContainerStateManagerDefaultImpl()
    {
    }    
    
    protected void setNewAuxObjectsArray()
    {
        // No son necesarios
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
        // Es el caso de NativeIntegerObjectImpl etc
        return 1;
    }
        
    public int getAbsAuxNativeObjectIndex(int absFieldIndex)
    {
        return -1; // No se necesita auxiliar
    }        
}
