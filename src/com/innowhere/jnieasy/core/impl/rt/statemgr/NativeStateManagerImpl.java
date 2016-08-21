/*
 * PointerValue.java
 *
 * Created on 16 de enero de 2004, 9:18
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;



/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.JavaAllocatedObjectRegistry;
import com.innowhere.jnieasy.core.impl.rt.NativeTransactionImpl;

public abstract class NativeStateManagerImpl implements NativeStateManager
{
    protected NativeBufferImpl buffer;
    protected NativeCapableInternal value;
    protected NativeManagerImpl nativeMgr;
    protected TxnInstanceStatus txnStatus;
    protected boolean isAuxiliar = false; // Se define pero no se usa (por ahora)
    
    /** Creates a new instance of PointerValue */
    public NativeStateManagerImpl()
    {
    }    

    protected void finalize() throws Throwable
    {
        // Hay que tener en cuenta que finalize se realiza de forma asíncrona
        // por el hilo del garbage collector
        // Unicamente liberamos la memoria (si es necesario) los fields etc
        // se liberarán solitos cuando el gc lo diga, así evitamos el tener que sincronizar 
        // las llamadas que se hagan en este método. En el caso del buffer dicho
        // objeto es únicamente referenciado por este objeto (o debe serlo), 
        // que está perdido (por eso se llama a finalize) por lo que no es necesario
        // sincronizar el detachBuffer(int)
        
        detachBuffer(NativeManager.FREE_MEMORY);
        super.finalize();        
    }    
    
    public void init(NativeManager nativeMgr,NativeCapableInternal value,boolean isAuxiliar)
    {
        this.value = value;
        this.nativeMgr = (NativeManagerImpl)nativeMgr;
        this.isAuxiliar = isAuxiliar;
        
        this.buffer = NativeBufferImpl.createBuffer(value.jnieasyGetSize(),isMemoryExecutable(),false);               
    }
    
    public void allocateBuffer(NativeManagerImpl nativeMgr,NativeCapableInternal value,boolean isAuxiliar)
    {
        init(nativeMgr,value,isAuxiliar);
                
        txnMarkAllocated();
        
        buffer.malloc();
        ((NativeManagerImpl)nativeMgr).getJavaAllocatedObjectRegistry().registerObject(this);       
    }
    
    public void attachBuffer(NativeAddress address,long offset,NativeManagerImpl nativeMgr,NativeCapableInternal value,boolean isAuxiliar)
    {
        init(nativeMgr,value,isAuxiliar);
        
        buffer.attach(address,offset);        
    }
    
    public void detachBuffer(int freeMemMode)
    {
        if (buffer.ownsMemory())
        {
            if (freeMemMode >= NativeManager.FREE_MEMORY)
                txnMarkFreed(); // Sabemos que se destruirá con seguridad la memoria
  
            // Ya sea liberando memoria o no, no puede quedar en el registro un objeto detached
            JavaAllocatedObjectRegistry registry = nativeMgr.getJavaAllocatedObjectRegistry();
            registry.removeObject(this); // Eliminamos la WeakReference asociada que a fin de cuentas es un objeto global y aunque no nos sujeta ocupa memoria
        }
        buffer.disconnect(freeMemMode);
    }        
    
    public void attach(NativeAddress address,long offset,NativeManagerImpl nativeMgr,NativeCapableInternal value,boolean isAuxiliar)
    {         
        value.jnieasySetNativeStateManager(this);
        
        attachBuffer(address, offset, nativeMgr, value,isAuxiliar);         
      
        attachFields();
    }
    
    public void makeNativeAttach(NativeAddress address,long offset,NativeManagerImpl nativeMgr,NativeCapableInternal value,boolean isAuxiliar,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        value.jnieasySetNativeStateManager(this);
        
        attachBuffer(address, offset, nativeMgr, value,isAuxiliar);
        
        makeNativeShared(unFetchMode,unfetchCtx,attachCopyCtx);              
    }
    
    public void makeNative(NativeManagerImpl nativeMgr,NativeCapableInternal value,boolean isAuxiliar,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        value.jnieasySetNativeStateManager(this); 
        
        allocateBuffer(nativeMgr, value,isAuxiliar);                   
        
        makeNativeShared(unFetchMode,unfetchCtx,attachCopyCtx);
    }
        
    private void makeNativeShared(int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        // Evitamos que se salve en la transacción la memoria recién creada que todavía no ha sido definida por el makeNativeFields, pues este método se aplica a objetos embebidos dentro de otro al que se hace un makeNative normal        
        enrollInActiveTxn(); // Se enrola si existe
        TxnInstanceStatus txnStatus = getCurrentThreadTxnInstanceStatus();
        if (txnStatus != null) txnStatus.setCanSaveFields(false);  
        makeNativeFields(unFetchMode, unfetchCtx, attachCopyCtx);
        if (txnStatus != null) txnStatus.setCanSaveFields(true);    
    }
    
    public void detach(int freeMemMode,boolean deep)
    {       
        detachBuffer(freeMemMode);
        
        value.jnieasySetNativeStateManager(null); // para evitar que en relaciones cíclicas (al llamar detachFields) se vuelva a intentar hacer disconnect de este        
       
        detachFields(freeMemMode, deep);
    }
        
    public void free()
    {
        detach(NativeManager.FREE_MEMORY,false);
    }
    
    public JNIEasy getJNIEasy()
    {
        return nativeMgr.getJNIEasy();
    }

    public abstract boolean isMemoryExecutable();

   
    public void attachCopy(NativeCapableInternal detachedCopy,AttachCopyContext ctx)
    {
        // se redefine
    }
    
    public void makeNativeFields(int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        // se redefine
    }
    
    public void attachFields()
    {
        // se redefine
    }
    
    public void detachFields(int freeMemMode,boolean deep)
    {
        // se redefine
    }    
    
    public void fetch(int mode,FetchUnFetchContext fetchCtx)
    {
        // se redefine
    }

    public void unFetch(int mode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        // se redefine        
    }
    
    public NativeBuffer getBuffer()
    {
        return buffer;
    }

    public NativeCapable getNativeCapable()    
    {
        return value;
    }

    public NativeManager getNativeManager()
    {
        return nativeMgr;
    }
    
    public TxnInstanceStatus getTxnInstanceStatus()
    {
        return txnStatus;
    }
    
    public TxnInstanceStatus getCurrentThreadTxnInstanceStatus()
    {
        TxnInstanceStatus txnStatus = getTxnInstanceStatus();
        if (txnStatus == null) return null;
        
        NativeTransactionImpl txn = nativeMgr.findCurrentWorkingTransaction();
        if (txnStatus.getTransaction() != txn)
            return null;
        return txnStatus;
    }    
    
    public boolean isInsideTxn()
    {
        return txnStatus != null;
    }
    
    public boolean isInsideTxn(NativeTransactionImpl txn)
    {
        TxnInstanceStatus txnStatus = getTxnInstanceStatus();
        if (txnStatus == null) return false;
        
        return (txnStatus.getTransaction() == txn);
    }
    
    public void begin(NativeTransactionImpl txn)
    {
        if (this.txnStatus != null) 
            throw new JNIEasyException("Object is already in a transaction in another thread: " + getNativeCapable());
        this.txnStatus = new TxnInstanceStatus(txn);
    }
    
    public void commit()
    {
        this.txnStatus = null;        
    }
    
    public void rollback()
    {       
        if (txnStatus.isFreedInsideTxn())
            nativeMgr.makeNative(value,isAuxiliar); // Ojo, se genera un nuevo NativeStateManager
        
        if (txnStatus.isUpdatedInsideTxn() || txnStatus.isFreedInsideTxn())
            rollbackFields();
        
        if (txnStatus.isAllocatedInsideTxn())
            nativeMgr.detach(value,NativeManager.FREE_MEMORY,false); 
        
        this.txnStatus = null;        
    }
    
    public void rollbackFields()
    {
        // se redefine
    }
    
    public boolean enrollInActiveTxn()
    {
        // Devuelve true si hay una transacción activa *y* 
        // está enrolado en la transacción.
        
        // Suponemos que un objeto no puede estar en dos transacciones a la vez
        NativeTransactionImpl txn = (NativeTransactionImpl)nativeMgr.findCurrentWorkingTransaction();
        if (txn == null) return false;

        // Es posible que la transacción no sea activa y el StateManager esté dentro de la transacción,
        // ocurre durante el commit o el rollback, hemos de evitar en estos casos tocar la transacción
        // por eso preguntamos antes a la propia transacción si es activa           
        if (!txn.isActive()) return false;  

        // Puede estar dentro de una transacción y no ser activa por lo de antes porque está
        // commiting/rollbacking, o bien la transacción es de otro hilo.
        // por eso preguntamos al final
        if (isInsideTxn(txn))
            return true; // Ya fue añadido.        
        
        return txn.enroll(this); 
    }

    public boolean txnMarkAllocated()
    {    
        if (!enrollInActiveTxn())
            return false; // No hay transacción activa

        txnStatus.allocatedInsideTxn();
        return true;
    }    
    
    public boolean txnMarkFreed()
    {    
        if (!enrollInActiveTxn())
            return false; // No hay transacción activa
        
        txnStatus.freedInsideTxn();
        return true;
    }        
    
    public boolean txnMarkUpdate()
    {    
        if (!enrollInActiveTxn())
            return false; // No hay transacción activa

        if (txnStatus.canSaveFields())
        {
            txnStatus.updatedInsideTxn();
            return true;
        }
        else return false;
    }    
}
