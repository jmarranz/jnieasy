/*
 * TxnInstanceStatus.java
 *
 * Created on 11 de octubre de 2005, 19:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;

import com.innowhere.jnieasy.core.impl.rt.NativeTransactionImpl;

/**
 *
 * @author jmarranz
 */
public class TxnInstanceStatus
{
    protected boolean allocatedInsideTxn;
    protected boolean updatedInsideTxn;        
    protected boolean freedInsideTxn;
    protected boolean canSaveFields = true;
    protected NativeTransactionImpl txn;
    
    /**
     * Creates a new instance of TxnInstanceStatus 
     */
    public TxnInstanceStatus(NativeTransactionImpl txn)
    {
        this.txn = txn;
    }

    public NativeTransactionImpl getTransaction()
    {
        return txn;
    }
    
    public boolean isAllocatedInsideTxn()
    {
        return allocatedInsideTxn;
    }    
    
    public void allocatedInsideTxn()
    {
        this.allocatedInsideTxn = true;
    }
    
    public boolean isUpdatedInsideTxn()
    {
        return updatedInsideTxn;
    }
    
    public void updatedInsideTxn()
    {
        this.updatedInsideTxn = true;
    }    
    
    public boolean isFreedInsideTxn()
    {
        return freedInsideTxn;
    }
    
    public void freedInsideTxn()
    {
        this.freedInsideTxn = true;
    }    

    public boolean canSaveFields()
    {
        return canSaveFields;
    }    
    
    public void setCanSaveFields(boolean canSaveFields)
    {
        this.canSaveFields = canSaveFields;
    }

}
