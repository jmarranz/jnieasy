/*
 * NativeFieldContainerStateManagerDefaultImpl.java
 *
 * Created on 14 de septiembre de 2005, 13:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.JNIEasyException;


/**
 *
 * @author jmarranz
 */
public class NativeFieldContainerStateManagerDefaultImpl extends NativeFieldContainerStateManagerImpl
{
    
    /**
     * Creates a new instance of NativeFieldContainerStateManagerDefaultImpl
     */
    public NativeFieldContainerStateManagerDefaultImpl()
    {
    }    
    
    protected void setNewAuxObjectsArray()
    {
        // No son necesarios
    }

    public void setFieldValueTxn(int fieldIndex, Object fieldValue)
    {
        // No se conocen los atributos
        throw new JNIEasyException("INTERNAL ERROR");        
    }

    public Object getFieldValueTxn(int fieldIndex)
    {
        // No se conocen los atributos
        throw new JNIEasyException("INTERNAL ERROR");        
    }

    public int getAbsoluteTxnFieldCount()
    {
        // No se conocen los atributos
        throw new JNIEasyException("INTERNAL ERROR");        
    }
    
    public int getAbsAuxNativeObjectIndex(int absFieldIndex)
    {
       throw new JNIEasyException("INTERNAL ERROR"); // No se conocen los fields
    }        
}
