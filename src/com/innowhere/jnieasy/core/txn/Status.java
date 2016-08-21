/*
 * Status.java
 *
 * Created on 20 de enero de 2006, 18:26
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.txn;

/**
 * The <code>Status</code> interface defines static variables used for 
 * transaction status codes.
 *
 * This interface is similar, almost identical, to Java Enterprise Edition's 
 * <code>javax.transaction.Status</code>. This interface is not used to avoid 
 * any dependency, not really needed, with JEE infrastructure.
 *
 * The states STATUS_PREPARED and STATUS_PREPARING are never used because 
 * have no sense in native transactions (there is no two-phase commit).
 *
 * @author Jose M. Arranz Santamaria
 */
public interface Status
{
    // Los valores, comentarios y significado de las constantes son tomados de javax.transaction.Status    
    // de la implementación:
    // http://fisheye.cenqua.com/java.net/viewrep/glassfish/transaction-api/src/java/javax/transaction/Status.java?r=1.2
    // y de la especificación:
    // http://java.sun.com/products/jta/jta-1_0_1B-doc/javax/transaction/Status.html
    
    /**
     * A transaction is associated with the target object and it is in the
     * active state. An implementation returns this status after a
     * transaction has been started, unless the transaction has been marked 
     * for rollback.
     */  
    public final static int STATUS_ACTIVE = 0;

    /**
     * A transaction is associated with the target object and it has been
     * marked for rollback, perhaps as a result of a setRollbackOnly operation.
     */  
    public final static int STATUS_MARKED_ROLLBACK = 1;

    /**
     * Not used.
     */  
    public final static int STATUS_PREPARED = 2;
 
    /**
     * A transaction is associated with the target object and it has been
     * committed. 
     */  
    public final static int STATUS_COMMITTED = 3;

    /**
     * A transaction is associated with the target object and the outcome
     * has been determined to be rollback.
     */  
    public final static int STATUS_ROLLEDBACK = 4;

    /**
     * A transaction is associated with the target object but its
     * current status cannot be determined. This is a transient condition
     * and a subsequent invocation will ultimately return a different status.
     */  
    public final static int STATUS_UNKNOWN = 5;

    /**
     * No transaction is currently associated with the target object. This
     * will occur after a transaction has completed.
     */  
    public final static int STATUS_NO_TRANSACTION = 6;

    /**
     * Not used.
     */  
    public final static int STATUS_PREPARING = 7;

    /**
     * A transaction is associated with the target object and it is in the
     * process of committing. An implementation returns this status if it
     * has decided to commit but has not yet completed the committing process. 
     * This occurs because the implementation is probably waiting for 
     * responses from one or more native objects.
     */  
    public final static int STATUS_COMMITTING = 8;

    /**
     * A transaction is associated with the target object and it is in the
     * process of rolling back. An implementation returns this status if
     * it has decided to rollback but has not yet completed the process.
     * The implementation is probably waiting for responses from one or more
     * native objects.
     */  
    public final static int STATUS_ROLLING_BACK = 9;    

}
