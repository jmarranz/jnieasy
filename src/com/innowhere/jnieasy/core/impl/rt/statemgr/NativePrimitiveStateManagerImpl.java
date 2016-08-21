/*
 * NativePrimitiveStateManagerImpl.java
 *
 * Created on 14 de septiembre de 2005, 13:24
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
public class NativePrimitiveStateManagerImpl extends NativeSingleFieldContainerStateManagerImpl
{
    
    /** Creates a new instance of NativePrimitiveStateManagerImpl */
    public NativePrimitiveStateManagerImpl()
    {
    }    
    
    protected void setNewAuxObjectsArray()
    {
        // No se necesitan
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
        // No se necesitan auxiliares
        return -1;
    }
}
