/*
 * NativeTransactionImpl.java
 *
 * Created on 5 de octubre de 2005, 18:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.txn.Synchronization;
import com.innowhere.jnieasy.core.txn.NativeTransaction;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerImpl;
import com.innowhere.jnieasy.core.txn.Status;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author jmarranz
 */
public class NativeTransactionImpl implements NativeTransaction
{
    protected int status = Status.STATUS_NO_TRANSACTION;
    protected boolean rollbackOnly = false;
    protected Synchronization sync;
    protected Set enrolled = new HashSet();
    protected NativeManagerImpl nativeMgr;
    protected Thread thread;
    
    /**
     * Creates a new instance of NativeTransactionImpl
     */
    public NativeTransactionImpl(NativeManagerImpl nativeMgr,Thread thread)
    {
        this.nativeMgr = nativeMgr;
        this.thread = thread;
    }

    public boolean enroll(NativeStateManagerImpl stateMgr)
    {
        // Insertamos el NativeStateManager y no el propio objeto porque todos los objetos
        // son nativos en este caso y porque así evitamos interferencias de posibles equals()
        // y hashCode() definidos por el usuario
        if (!isActive()) return false;
        
        if (enrolled.add(stateMgr))
        {
            stateMgr.begin(this);        
            return true;
        }
        else throw new JNIEasyException("INTERNAL ERROR");      
    }

    public boolean unenroll(NativeStateManagerImpl stateMgr)
    {
        if (!isActive()) return false;
        
        return enrolled.remove(stateMgr);    
    }    
    
    public void begin()
    {
        if (status == Status.STATUS_ACTIVE) throw new JNIEasyException("Transaction is already active");
        this.status = Status.STATUS_ACTIVE;
        nativeMgr.addTransaction(thread,this);
    }

    public void commit()
    {
        if (status != Status.STATUS_ACTIVE) throw new JNIEasyException("Transaction is not active");
        if (rollbackOnly) throw new JNIEasyException("Transaction is marked as rollback only, cannot be committed");
        if (sync != null) sync.beforeCompletion();        
        this.status = Status.STATUS_COMMITTING;        
        
        for(Iterator it = enrolled.iterator(); it.hasNext(); )
        {
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)it.next();            
            NativeCapable obj = stateMgr.getNativeCapable();
            synchronized (obj) // Para asegurar que otros hilos que lo toquen se paren
            {
                stateMgr.commit();
            }
        }
        
        enrolled.clear();
        this.status = Status.STATUS_COMMITTED;
        finalizeTransaction();      
    }

    public void rollback()
    {
        this.status = Status.STATUS_ROLLING_BACK;
        
        for(Iterator it = enrolled.iterator(); it.hasNext(); )
        {
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)it.next();
            NativeCapable obj = stateMgr.getNativeCapable();
            synchronized (obj) // Para asegurar que otros hilos que lo toquen se paren
            {            
                stateMgr.rollback();
            }
        }
        
        enrolled.clear();        
        finalizeTransaction();
    }

    public void finalizeTransaction()
    {
        if (sync != null) sync.afterCompletion(this.status); 
        this.status = Status.STATUS_NO_TRANSACTION;
        nativeMgr.removeTransaction(thread);        
    }
    
    public boolean getRollbackOnly()
    {
        return rollbackOnly;
    }

    public void setRollbackOnly()
    {
        this.rollbackOnly = true;
    }
    
    public int getStatus()
    {
        return status;
    }

    public boolean isActive()
    {
        return status == Status.STATUS_ACTIVE;
    }

    public Synchronization getSynchronization()
    {
        return sync;
    }
    
    public void setSynchronization(Synchronization sync)
    {
        this.sync = sync;
    }    
}
