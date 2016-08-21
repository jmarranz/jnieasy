/*
 * Synchronization.java
 *
 * Created on 5 de octubre de 2005, 18:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.txn;

/**
 * The transaction manager supports a synchronization mechanism that allows the 
 * interested party to be notified before and after the transaction completes. 
 * Using the {@link NativeTransaction#setSynchronization(Synchronization)} method, 
 * a Synchronization object is registered in the transaction  
 * associated with the target transaction object.
 * 
 * It is conceptually similar, almost identical, to the Java Enterprise Edition's 
 * interface javax.transaction.Synchronization. This interface is not used to avoid
 * any dependency, not really needed, with JEE infrastructure.
 *
 * @author Jose M. Arranz Santamaria
 */
public interface Synchronization
{
    /**
     * The beforeCompletion method is called by the transaction manager prior 
     * to the start of the transaction commit process. 
     *
     * @see NativeTransaction#commit()
     */
    public void beforeCompletion();
    
    /**
     * This method is called by the transaction manager after the transaction 
     * is committed or rolled back.
     *
     * @param status the status of the transaction completion.
     * @see Status     
     */
    public void afterCompletion(int status);
}
