/*
 * NativeTransaction.java
 *
 * Created on 5 de octubre de 2005, 18:10
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.txn;

/**
 *
 * @author Jose M. Arranz Santamaria
 */
public interface NativeTransaction
{
    public void begin();
    public void commit();
    public void rollback();
    public boolean isActive();
    public boolean getRollbackOnly();
    public void setRollbackOnly();
    public int getStatus();
    public void setSynchronization(Synchronization sync);
    public Synchronization getSynchronization();    
}
