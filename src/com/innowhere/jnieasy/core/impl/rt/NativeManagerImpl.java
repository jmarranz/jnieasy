/*
 * NativeMemoryManager.java
 *
 * Created on 4 de diciembre de 2003, 11:49
 */

package com.innowhere.jnieasy.core.impl.rt;
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.jni.JNIEasyNative;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.listener.AttachCopyLifecycleEvent;
import com.innowhere.jnieasy.core.listener.AttachCopyLifecycleListener;
import com.innowhere.jnieasy.core.listener.AttachCopyCallback;
import com.innowhere.jnieasy.core.listener.AttachLifecycleEvent;
import com.innowhere.jnieasy.core.listener.AttachLifecycleListener;
import com.innowhere.jnieasy.core.listener.AttachCallback;
import com.innowhere.jnieasy.core.listener.DetachCopyLifecycleEvent;
import com.innowhere.jnieasy.core.listener.DetachCopyLifecycleListener;
import com.innowhere.jnieasy.core.listener.DetachCopyCallback;
import com.innowhere.jnieasy.core.listener.DetachLifecycleEvent;
import com.innowhere.jnieasy.core.listener.DetachLifecycleListener;
import com.innowhere.jnieasy.core.listener.DetachCallback;
import com.innowhere.jnieasy.core.listener.FetchLifecycleEvent;
import com.innowhere.jnieasy.core.listener.FetchLifecycleListener;
import com.innowhere.jnieasy.core.listener.FetchCallback;
import com.innowhere.jnieasy.core.listener.InstanceLifecycleListener;
import com.innowhere.jnieasy.core.listener.MakeNativeLifecycleEvent;
import com.innowhere.jnieasy.core.listener.MakeNativeLifecycleListener;
import com.innowhere.jnieasy.core.listener.MakeNativeCallback;
import com.innowhere.jnieasy.core.listener.UnFetchLifecycleEvent;
import com.innowhere.jnieasy.core.listener.UnFetchLifecycleListener;
import com.innowhere.jnieasy.core.listener.UnFetchCallback;
import com.innowhere.jnieasy.core.txn.NativeTransaction;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NativeManagerImpl implements NativeManager
{
    protected int defaultFetchMode = Fetch.FAST;
    protected int defaultUnFetchMode = UnFetch.FAST;    
    
    protected RuntimeManagerImpl rtMgr;
    protected JavaAllocatedObjectRegistry allocObjectRegistry = new JavaAllocatedObjectRegistry();
    protected Map txns = new HashMap();
            
    protected ListInstanceLifecycleListener attachCopyListeners = new ListInstanceLifecycleListener();
    protected ListInstanceLifecycleListener attachListeners = new ListInstanceLifecycleListener();    
    protected ListInstanceLifecycleListener detachCopyListeners = new ListInstanceLifecycleListener();
    protected ListInstanceLifecycleListener detachListeners = new ListInstanceLifecycleListener();
    protected ListInstanceLifecycleListener fetchListeners = new ListInstanceLifecycleListener();
    protected ListInstanceLifecycleListener makeNativeListeners = new ListInstanceLifecycleListener();
    protected ListInstanceLifecycleListener unFetchListeners = new ListInstanceLifecycleListener();    
    
    protected boolean rtCheck = true;
    
    /** Creates a new instance of NativeMemoryManager */
    public NativeManagerImpl(RuntimeManagerImpl rtMgr)
    {
        this.rtMgr = rtMgr;
    }
   
    public static int getDefaultFetchMode(NativeCapableInternal nativeObj)
    {
        // Si es null realmente da igual el valor que se devuelva pues no se usará        
        // No hace falta sincronizar si devuelve un object no null siempre tiene un NativeManager asociado
        NativeStateManager stateMgr = nativeObj.jnieasyGetNativeStateManager();
        if (stateMgr == null)
            return Fetch.FAST;
        return stateMgr.getNativeManager().getDefaultFetchMode();
    }
    
    public static int getDefaultUnFetchMode(NativeCapableInternal nativeObj)
    {
        // Si es null realmente da igual el valor que se devuelva pues no se usará        
        // No hace falta sincronizar si devuelve un object no null siempre tiene un NativeManager asociado        
        NativeStateManager stateMgr = nativeObj.jnieasyGetNativeStateManager();
        if (stateMgr == null)
            return UnFetch.FAST;
        return stateMgr.getNativeManager().getDefaultUnFetchMode();
    }    
    
    public int getPlatformAddressSize()
    {
        return JNIEasyNative.getPlatformAddressSize();
    }
    
    public int getDefaultFetchMode()
    {
        return defaultFetchMode;
    }
    
    public void setDefaultFetchMode(int mode)
    {
        this.defaultFetchMode = mode;
    }    
    
    public int getDefaultUnFetchMode()
    {
        return defaultUnFetchMode;
    }
    
    public void setDefaultUnFetchMode(int mode)
    {
        this.defaultUnFetchMode = mode;
    }
    
    public static void checkNativeCapable(Object obj)
    {
        if (obj == null) throw new JNIEasyException("Object is null");
        if (!(obj instanceof NativeCapable))
            throw new JNIEasyException("Object is not native capable (does not implement NativeCapable");
    }     
    
    public static void checkNative(Object obj)
    {
        checkNativeCapable(obj);
        if (((NativeCapable)obj).jnieasyGetNativeStateManager() == null)
            throw new JNIEasyException("Object is not native");        
    }    
    
    public void setRuntimeChecking(boolean check)
    {
        this.rtCheck = check;
    }
    
    public boolean isRuntimeChecking()    
    {
        return rtCheck;
    }
    
    public JNIEasy getJNIEasy()
    {
        return rtMgr.getJNIEasy();
    }
    
    public RuntimeContext getDefaultRuntimeContext()
    {
        return rtMgr.getDefaultRuntimeContextNotUsingImports();
    }
    
    public NativeBuffer allocateBuffer(long size)
    {
        return NativeBufferImpl.createBuffer(size,false,true);
    }
    
    public NativeBuffer attachBuffer(long address)
    {
         return attachBuffer(address, TypeSizes.getUNKNOWN_SIZE());
    }
    
    public NativeBuffer attachBuffer(long address,long size)
    {
        NativeBufferImpl buff = NativeBufferImpl.createBuffer(size,false,false);
        buff.attach(address);
        return buff;
    }    
    
    public NativeAddress newAddress(long address)
    {
        return new NativeAddressImpl(address);
    }
    
    public NativeAddress newAddress(NativeAddress address,long offset)
    {
        return new NativeAddressImpl(address,offset);
    }
    
    public void addInstanceLifecycleListener(InstanceLifecycleListener listener,Class[] classes)
    {
        // Lo insertamos en la colección correspondiente, el dividir en varias
        // colecciones es únicamente para el rendimiento al buscar el listener 
        // que recoge cierto evento y para simplificar un poco la programación.         
        if (listener instanceof AttachCopyLifecycleListener)
            attachCopyListeners.addListener(listener, classes);
        else if (listener instanceof AttachLifecycleListener)
            attachListeners.addListener(listener, classes);
        else if (listener instanceof DetachCopyLifecycleListener)
            detachCopyListeners.addListener(listener, classes);
        else if (listener instanceof DetachLifecycleListener)
            detachListeners.addListener(listener, classes);
        else if (listener instanceof FetchLifecycleListener)
            fetchListeners.addListener(listener, classes);
        else if (listener instanceof MakeNativeLifecycleListener)
            makeNativeListeners.addListener(listener, classes);
        else if (listener instanceof UnFetchLifecycleListener)
            unFetchListeners.addListener(listener, classes);
    }    
    
    public void removeInstanceLifecycleListener(InstanceLifecycleListener listener)
    {
        if (listener instanceof AttachCopyLifecycleListener)
            attachCopyListeners.removeListener(listener);
        else if (listener instanceof AttachLifecycleListener)
            attachListeners.removeListener(listener);
        else if (listener instanceof DetachCopyLifecycleListener)
            detachCopyListeners.removeListener(listener);
        else if (listener instanceof DetachLifecycleListener)
            detachListeners.removeListener(listener);
        else if (listener instanceof FetchLifecycleListener)
            fetchListeners.removeListener(listener);
        else if (listener instanceof MakeNativeLifecycleListener)
            makeNativeListeners.removeListener(listener);
        else if (listener instanceof UnFetchLifecycleListener)
            unFetchListeners.removeListener(listener);
    }    
   
    public boolean makeNative(Object obj)
    {
        return makeNative((NativeCapableInternal)obj,false);
    }
        
    public boolean makeNative(Object obj,long address)
    {
        return makeNative(obj,newAddress(address),0);   
    }    
    
    public boolean makeNative(Object obj,NativeAddress addr, long offset)
    {
        return makeNativeAttach((NativeCapableInternal)obj,false, addr,offset,null,getDefaultUnFetchMode(), null,null);
    }        
    
    public boolean attach(Object obj,long address)
    {
        return attach(obj,newAddress(address),0);
    }    
    
    public boolean attach(Object obj,NativeAddress addr,long offset)
    {
        return attach((NativeCapableInternal)obj,false,addr,offset);
    }          
    
    public boolean makeNative(NativeCapableInternal obj,boolean isAuxiliar)
    {    
        return makeNative(obj,isAuxiliar,getDefaultUnFetchMode(), null,null);        
    }
    
    public boolean makeNative(NativeCapableInternal obj,boolean isAuxiliar,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {       
        if (obj == null) throw new JNIEasyException("Null object");        
        synchronized (obj)
        {
            if (obj.jnieasyGetNativeStateManager() != null) return false; // nada que hacer, ya es nativo
            
            ArrayList listeners = makeNativeListeners.findListeners(obj.getClass());
            MakeNativeLifecycleEvent event = null;
            if (listeners != null) event = new MakeNativeLifecycleEvent(obj);            
            if (listeners != null)
            {                            
                for(int i = 0; i < listeners.size(); i++)
                {
                    MakeNativeLifecycleListener listener = (MakeNativeLifecycleListener)listeners.get(i);
                    listener.preMakeNative(event);
                }
            }        

            if (obj instanceof MakeNativeCallback)
                ((MakeNativeCallback)obj).jnieasyPreMakeNative(); // Prepara los atributos antes de ser nativos

            NativeStateManagerImpl stateManager = (NativeStateManagerImpl)obj.jnieasyNewNativeStateManager();
            stateManager.makeNative(this,obj,isAuxiliar,unFetchMode, unfetchCtx, attachCopyCtx);

            if (obj instanceof MakeNativeCallback)
                ((MakeNativeCallback)obj).jnieasyPostMakeNative();
            
            
            if (listeners != null)
            {                            
                for(int i = 0; i < listeners.size(); i++)
                {
                    MakeNativeLifecycleListener listener = (MakeNativeLifecycleListener)listeners.get(i);
                    listener.postMakeNative(event);
                }
            } 
            
            /* Aseguramos que la memoria se corresponde con los fields (los propios fields NativeCapable ya lo han hecho en la llamada jnieasyMakeNativeFields)
             * es necesario pues partimos del principio de que "la memoria manda", por tanto tras el makeNativeFields si no hacemos el unFetchStatic al hacer un get
             * de un atributo se obtendrá el valor de la memoria que es desconocido pues está recién creada.
             * Así también podemos pasar el objeto como argumento a un método nativo pues la memoria coincide con el objeto Java
             **/
            return true;
        }
    }                

    
    public boolean makeNativeAttach(NativeCapableInternal obj,boolean isAuxiliar,NativeAddress address, long offset,TypeNativeRuntimeImpl typeDecEmbed,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        if (obj == null) throw new JNIEasyException("Null object");
        synchronized (obj)
        {
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)obj.jnieasyGetNativeStateManager();
            if (stateMgr != null)
            {
                if (stateMgr.getBuffer().isAttachedTo(address,offset))
                    return false; // Ya está attached a este buffer y con este offset
                throw new JNIEasyException("Is already native and not attached to address: " + address.getValue() + " offset: " + offset);
            }

            ArrayList listeners = makeNativeListeners.findListeners(obj.getClass());
            MakeNativeLifecycleEvent event = null;
            if (listeners != null) event = new MakeNativeLifecycleEvent(obj, address, offset);
            if (listeners != null)
            {             
                for(int i = 0; i < listeners.size(); i++)
                {
                    MakeNativeLifecycleListener listener = (MakeNativeLifecycleListener)listeners.get(i);
                    listener.preMakeNative(event);
                }
            }        

            if (obj instanceof MakeNativeCallback)
                ((MakeNativeCallback)obj).jnieasyPreMakeNative(address, offset);  // Permite preparar los fields antes de ser nativos

            if (typeDecEmbed != null) obj.jnieasySetType(typeDecEmbed);
            NativeStateManagerImpl stateManager = (NativeStateManagerImpl)obj.jnieasyNewNativeStateManager();        
            stateManager.makeNativeAttach(address,offset, this, obj,isAuxiliar,unFetchMode, unfetchCtx, attachCopyCtx); 

            if (obj instanceof MakeNativeCallback)
                ((MakeNativeCallback)obj).jnieasyPostMakeNative();
            
            if (listeners != null)
            {             
                for(int i = 0; i < listeners.size(); i++)
                {
                    MakeNativeLifecycleListener listener = (MakeNativeLifecycleListener)listeners.get(i);
                    listener.preMakeNative(event);
                }
            }
            
            /* Comentarios idem que el jnieasyMakeNative sin attachment */ 
            return true;
        }
    }    

    
    public boolean attach(NativeCapableInternal obj,boolean isAuxiliar,NativeAddress addr,long offset)
    {
        return attach(obj,isAuxiliar,addr,offset,null);
    }          
    
    public boolean attach(NativeCapableInternal obj,boolean isAuxiliar,NativeAddress address, long offset,TypeNativeRuntimeImpl typeDecEmbed)
    {
        if (obj == null) throw new JNIEasyException("Null object");
        synchronized (obj)
        {    
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)obj.jnieasyGetNativeStateManager();      
            if (stateMgr != null)
            {
                if (stateMgr.getBuffer().isAttachedTo(address,offset))
                    return false; // Ya está attached a este buffer y con este offset
                throw new JNIEasyException("Is already native and not attached to address: " + address.getValue() + " offset: " + offset);
            }

            ArrayList listeners = attachListeners.findListeners(obj.getClass());
            AttachLifecycleEvent event = null;
            if (listeners != null) event = new AttachLifecycleEvent(obj,address, offset);
            if (listeners != null)        
            {
                for(int i = 0; i < listeners.size(); i++)
                {
                    AttachLifecycleListener listener = (AttachLifecycleListener)listeners.get(i);
                    listener.preAttach(event);
                }
            }        

            if (obj instanceof AttachCallback)
                ((AttachCallback)obj).jnieasyPreAttach(address, offset);   // Permite hacer algo con los fields antes de que representen el mundo nativo   

            if (typeDecEmbed != null) obj.jnieasySetType(typeDecEmbed);            
            NativeStateManagerImpl stateManager = (NativeStateManagerImpl)obj.jnieasyNewNativeStateManager();        
            stateManager.attach(address,offset, this, obj,isAuxiliar);  

            if (obj instanceof AttachCallback)
                ((AttachCallback)obj).jnieasyPostAttach();  // Permite por ejemplo sincronizar atributos no nativos con los ahora nativos, no pasamos el address porque lo podemos obtener ya por el NativeStateManager

            if (listeners != null)        
            {
                for(int i = 0; i < listeners.size(); i++)
                {
                    AttachLifecycleListener listener = (AttachLifecycleListener)listeners.get(i);
                    listener.postAttach(event);
                }
            }

            // Sólo tocaremos los fields NativeCapable que ya estén, cuando se accedan los demás (primitivos y CanBe) ya se hará attachment, pues la memoria nativa es la que manda y hagamos lo que
            // hagamos ahora cuando se accedan (lectura) se redefinirán de nuevo a partir de la memoria nativa
            return true;    
        }
    }    
  
    public boolean free(Object obj)
    {
        return detach(obj,FREE_MEMORY,false);
    }
    
    public boolean detach(Object obj)
    {
        return detach(obj,NOT_FREE_MEMORY,false);
    }    
    
    public boolean detach(Object obj,int freeMemMode,boolean deep)
    {
        if (obj == null) throw new JNIEasyException("Null object");        

        return detach((NativeCapableInternal)obj,freeMemMode,deep);
    }
   
    public boolean detach(NativeCapableInternal obj,int freeMemMode,boolean deep)
    {        
        synchronized (obj)
        {            
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)obj.jnieasyGetNativeStateManager();
            if (stateMgr == null) return false; // Nada que hacer, ya detached

            ArrayList listeners = detachListeners.findListeners(obj.getClass());
            DetachLifecycleEvent event = null;
            if (listeners != null) event = new DetachLifecycleEvent(obj,freeMemMode);
            if (listeners != null)
            {             
                for(int i = 0; i < listeners.size(); i++)
                {
                    DetachLifecycleListener listener = (DetachLifecycleListener)listeners.get(i);
                    listener.preDetach(event);
                }
            }         

            if (obj instanceof DetachCallback)
                ((DetachCallback)obj).jnieasyPreDetach(freeMemMode); // Permite interaccionar con el mundo nativo antes de desconectar

            stateMgr.detach(freeMemMode, deep); // Lo hacemos lo último pues en el jnieasyDetach puede haber fields embebidos
            
            if (obj instanceof DetachCallback)
                ((DetachCallback)obj).jnieasyPostDetach(); // Como notificación de que ha sido desconectada (y la memoria quizás destruida) sirve a modo de destructor

            if (listeners != null)
            {             
                for(int i = 0; i < listeners.size(); i++)
                {
                    DetachLifecycleListener listener = (DetachLifecycleListener)listeners.get(i);
                    listener.postDetach(event);
                }
            }      
        }
        return true;
    }   
    
    public Object detachCopy(Object obj)   
    {
        return clone(obj);
    }    
    
    public Object clone(Object obj)
    {
        // Podría ser pública pero no está decidido
        if (obj == null) throw new JNIEasyException("Null object");         
        return clone((NativeCapableInternal)obj,new CloneContext());        
    }    

    public NativeCapableInternal clone(NativeCapableInternal obj,CloneContext cloneCtx)
    {
        if (obj == null) return null; 
        synchronized(obj)
        {
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();
            if (stateMgr == null)
                throw new JNIEasyException("Object is not native");         

            // Consideramos el caso de referencias circulares en donde hubiera sido ya clonado antes
            NativeCapableInternal cloned = cloneCtx.findCloned(stateMgr);
            if (cloned == null)
            {
                DetachCopyLifecycleEvent event = null;
                ArrayList listeners = detachCopyListeners.findListeners(obj.getClass());                
                // Por ahora no tenemos el objeto clonado
                if (listeners != null) event = new DetachCopyLifecycleEvent(obj);
                if (listeners != null)        
                {
                    for(int i = 0; i < listeners.size(); i++)
                    {
                        DetachCopyLifecycleListener listener = (DetachCopyLifecycleListener)listeners.get(i);
                        listener.preDetachCopy(event);
                    }
                } 

                if (obj instanceof DetachCopyCallback)
                    ((DetachCopyCallback)obj).jnieasyPreDetachCopy();  // Permite anular atributos nativos o no que no sean clonables por ejemplo

                try
                {
                cloned = (NativeCapableInternal)obj.jnieasyClone(); 
                }
                catch(CloneNotSupportedException ex)
                {
                    throw new JNIEasyException(ex);
                }
                cloneCtx.add(stateMgr, cloned);

                // Hay que tener en cuenta que el Object.jnieasyClone() no hace un jnieasyClone profundo
                // clona las referecias pero no los objetos referenciados.           

                cloned.jnieasyReplaceFieldsWithCloned(cloneCtx,stateMgr);  // Ojo, usará el NativeStateManager del objeto original (y el array de objs auxiliares), pero sólo es para clonar, no afecta al original            
                cloned.jnieasySetNativeStateManager(null);  

                if (obj instanceof DetachCopyCallback)
                    ((DetachCopyCallback)obj).jnieasyPostDetachCopy(cloned);             

                if (listeners != null)        
                {
                    event.setDetachedCopy(cloned);
                    for(int i = 0; i < listeners.size(); i++)
                    {
                        DetachCopyLifecycleListener listener = (DetachCopyLifecycleListener)listeners.get(i);
                        listener.postDetachCopy(event);
                    }
                }            
            }

            return cloned;
        }
    }    
    
    public void attachCopy(Object obj,Object detachedCopy)    
    {
        if (obj == null) throw new JNIEasyException("Null object");        
        NativeCapableInternal nativeObj = (NativeCapableInternal)obj;        
        synchronized (obj)
        {        
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)nativeObj.jnieasyGetNativeStateManager();            
            if (stateMgr == null)
                throw new JNIEasyException("Object is not native");  
   
            ArrayList listeners = attachCopyListeners.findListeners(obj.getClass());
            if (listeners != null)        
            {
                AttachCopyLifecycleEvent event = new AttachCopyLifecycleEvent(obj,detachedCopy);            
                for(int i = 0; i < listeners.size(); i++)
                {
                    AttachCopyLifecycleListener listener = (AttachCopyLifecycleListener)listeners.get(i);
                    listener.preAttachCopy(event);
                }
            }

            if (obj instanceof AttachCopyCallback)
                ((AttachCopyCallback)obj).jnieasyPreAttachCopy(); // Sirve para preparar antes de copiar

            AttachCopyContext ctx = new AttachCopyContext((NativeCapableInternal)detachedCopy,(NativeCapableInternal)nativeObj);
            stateMgr.attachCopy((NativeCapableInternal)detachedCopy, ctx);

            if (obj instanceof AttachCopyCallback)
                ((AttachCopyCallback)obj).jnieasyPostAttachCopy(detachedCopy); // Sirve para para hacer ajustes tras la copia, por ejemplo copia de atributos no nativos

            if (listeners != null)        
            {
                AttachCopyLifecycleEvent event = new AttachCopyLifecycleEvent(obj,detachedCopy);             
                for(int i = 0; i < listeners.size(); i++)
                {
                    AttachCopyLifecycleListener listener = (AttachCopyLifecycleListener)listeners.get(i);
                    listener.postAttachCopy(event);
                }
            }        
        }
    }
    
    public void fetch(Object obj)
    {    
        fetch(obj,getDefaultFetchMode());
    }
    
    public void fetch(Object obj,int mode)
    {
        if (obj == null) throw new JNIEasyException("Null object");                
        if (mode == Fetch.NONE) return;
        
        checkFetchMode(mode);
        FetchUnFetchContext fetchCtx = newFetchContextIfNeeded(mode);
        fetch((NativeCapableInternal)obj,mode,fetchCtx);
    }    
    
    public void unFetch(Object obj)
    {    
        unFetch(obj,getDefaultUnFetchMode());
    }    
    
    public void unFetch(Object obj,int mode)
    {
        if (obj == null) throw new JNIEasyException("Null object"); 
        if (mode == UnFetch.NONE) return;
        
        checkUnFetchMode(mode);
        FetchUnFetchContext unfetchCtx = newUnFetchContextIfNeeded(mode);
        unFetch((NativeCapableInternal)obj,mode,unfetchCtx,null);        
    }

    public JavaAllocatedObjectRegistry getJavaAllocatedObjectRegistry()
    {
        return allocObjectRegistry;
    }

    public Object findObject(long address)
    {
        return allocObjectRegistry.findObject(address);        
    }
        
    public Object getObject(Class cls,long address)
    {
        try
        {
            RuntimeContext ctx = getDefaultRuntimeContext();
            TypeNativeRuntimeImpl typeDec = TypeNativeRuntimeImpl.newTypeNativeRuntime(cls,ctx); // Si no existe registra uno nuevo, y si no puede da error
            if (typeDec instanceof TypeNativeObjectRuntimeImpl)
            {
                // es posible que el objeto devuelto no sea nuevo sino que existiera ya en en el registro
                return ((TypeNativeObjectRuntimeImpl)typeDec).getObject(address);
            }
            else throw new JNIEasyException("Class " + cls.getName() + " must inherit from Object");            
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }
    }        

    public void fetch(NativeCapableInternal obj,int mode,FetchUnFetchContext fetchCtx)
    {
        synchronized (obj)
        {         
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)obj.jnieasyGetNativeStateManager();        
            if (stateMgr == null) throw new JNIEasyException("Object is not native :" + obj);
            
            if (fetchCtx != null)
            {
                if (fetchCtx.contains(stateMgr))
                    return; // Ya ha sido fetched en esta sesión
                else
                    fetchCtx.add(stateMgr); // para recordar que ha sido fetched en esta sesión, llamamos ANTES de hacer el fetchStatic pues es posible que haya referencias cíclicas así la referencia cíclica ve que ya ha hecho (la realidad es que está en proceso)
            }

            stateMgr.fetch(mode,fetchCtx);

            if (obj instanceof FetchCallback)
                ((FetchCallback)obj).jnieasyPostFetch(mode); // Puede servir por ejemplo para sincronizar atributos no nativos con nativos      

            ArrayList listeners = fetchListeners.findListeners(obj.getClass());
            if (listeners != null)
            {             
                FetchLifecycleEvent event = new FetchLifecycleEvent(obj,mode);
                for(int i = 0; i < listeners.size(); i++)
                {
                    FetchLifecycleListener listener = (FetchLifecycleListener)listeners.get(i);
                    listener.postFetch(event);
                }
            }        
        }
    }   

    
    public void unFetch(NativeCapableInternal obj,int mode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)
    {
        synchronized (obj)
        {         
            NativeStateManagerImpl stateMgr = (NativeStateManagerImpl)obj.jnieasyGetNativeStateManager();        
            if (stateMgr == null) throw new JNIEasyException("Object is not native :" + obj);        
            
            if (unfetchCtx != null)
            {
                if (unfetchCtx.contains(stateMgr))
                    return; // Ya ha sido fetched en esta sesión
                else
                    unfetchCtx.add(stateMgr); // para recordar que ha sido fetched en esta sesión, llamamos ANTES de hacer el fetchStatic pues es posible que haya referencias cíclicas así la referencia cíclica ve que ya ha hecho (la realidad es que está en proceso)
            }

            ArrayList listeners = unFetchListeners.findListeners(obj.getClass());
            if (listeners != null)
            {             
                UnFetchLifecycleEvent event = new UnFetchLifecycleEvent(obj,mode);
                for(int i = 0; i < listeners.size(); i++)
                {
                    UnFetchLifecycleListener listener = (UnFetchLifecycleListener)listeners.get(i);
                    listener.preUnFetch(event);
                }
            }        

            if (obj instanceof UnFetchCallback)
                ((UnFetchCallback)obj).jnieasyPreUnFetch(mode); // Puede servir por ejemplo para preparar los atributos que van a pasar a la parte nativa      

            stateMgr.unFetch(mode,unfetchCtx,attachCopyCtx);
        }
    }        
    
    public static FetchUnFetchContext newFetchContextIfNeeded(int mode)
    {
        if (mode == Fetch.DEEP)
            return new FetchUnFetchContext(); // Para evitar que falle en referencias circulares
        return null;
    }
    
    public static FetchUnFetchContext newUnFetchContextIfNeeded(int mode)
    {
        if (mode == UnFetch.DEEP)
            return new FetchUnFetchContext(); // Para evitar que falle en referencias circulares
        return null;
    }
    
    public static void checkFetchMode(int mode)        
    {
        if ((mode < Fetch.NONE) || (Fetch.DEEP < mode))
             throw new JNIEasyException("Bad fetch mode value");
    }
    
    public static void checkUnFetchMode(int mode)        
    {
        if ((mode < UnFetch.NONE) || (UnFetch.DEEP < mode))
             throw new JNIEasyException("Bad unfetch mode value");
    }
    
    public NativeTransaction currentTransaction()
    {
        Thread thread = Thread.currentThread();
        NativeTransaction txn;
        synchronized (txns)
        {        
            txn = (NativeTransaction)txns.get(thread);
        }
        if (txn == null)        
            txn = new NativeTransactionImpl(this,thread);        
        return txn;        
    }
    
    public NativeTransactionImpl findCurrentWorkingTransaction()
    {
        // El método es muy rápido cuando no hay transacciones
        // De esta manera la gestión de transacciones no afecta
        // al rendimiento de las aplicaciones sin transacciones,
        // pues la búsqueda en una colección o la llamada Thread.currentThread()
        // pueden ser costosas
        synchronized (txns)
        {
            if (txns.isEmpty())
                return null;
            Thread thread = Thread.currentThread();
            return (NativeTransactionImpl)txns.get(thread);        
        }
    }
    
    public void removeTransaction(Thread thread)
    {
        synchronized (txns)
        {        
            txns.remove(thread);
        }
    }
    
    public void addTransaction(Thread thread,NativeTransactionImpl txn)
    {
        synchronized (txns)
        {        
            txns.put(thread,txn);
        }
    }    
}
