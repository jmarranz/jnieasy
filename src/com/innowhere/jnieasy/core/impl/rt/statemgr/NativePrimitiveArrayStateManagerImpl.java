/*
 * NativePrimitiveArrayStateManagerImpl.java
 *
 * Created on 4 de octubre de 2005, 9:11
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
public class NativePrimitiveArrayStateManagerImpl extends NativeArrayStateManagerImpl
{
    
    /**
     * Creates a new instance of NativePrimitiveArrayStateManagerImpl
     */
    public NativePrimitiveArrayStateManagerImpl()
    {
    }    

    protected void setNewAuxObjectsArray()
    {
        // NO se necesitan
    }
    
    public int getAbsAuxNativeObjectIndex(int absFieldIndex)
    {
        return -1; // No se necesita auxiliar
    }        
}
