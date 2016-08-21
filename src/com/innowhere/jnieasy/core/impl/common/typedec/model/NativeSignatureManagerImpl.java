/*
 * NativeSignatureManagerImpl.java
 *
 * Created on 30 de enero de 2006, 9:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;

import com.innowhere.jnieasy.core.impl.common.signat.model.CallConvImpl;
import com.innowhere.jnieasy.core.typedec.CallConv;

/**
 *
 * @author jmarranz
 */
public class NativeSignatureManagerImpl
{
    protected int callConvDefault = CallConv.STD_CALL;
    
    /**
     * Creates a new instance of NativeSignatureManagerImpl
     */
    public NativeSignatureManagerImpl()
    {
    }    
    
    public int getDefaultCallConv()
    {
        return callConvDefault;
    }
    

    public void setDefaultCallConv(int callConv)
    {
        CallConvImpl.checkCallConvention(callConv);
           
        this.callConvDefault = callConv;
    }    
}
