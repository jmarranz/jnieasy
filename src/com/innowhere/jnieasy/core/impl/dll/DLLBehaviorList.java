/*
 * DLLBehaviorList.java
 *
 * Created on 1 de octubre de 2004, 12:38
 */

package com.innowhere.jnieasy.core.impl.dll;
import java.util.*;

import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;


public class DLLBehaviorList
{
    protected Map methodsByName = new HashMap();
    protected Map methodsBySig = new HashMap();
    
    /**
     * Creates a new instance of DLLBehaviorList 
     */
    public DLLBehaviorList()
    {
    }
    
    public synchronized boolean addBehavior(String name,NativeBehavior method)
    {
        // name puede ser el nombre del método exportado por la DLL
        // Si ya existe con la misma signatura no lo añade
        // Tenemos la garantía de que en una DLL dado un nombre dado nos genera una dirección única, hay equivalencia nombre-dirección (para una DLL dada)
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)method.getBehaviorSignature();
        String sigStr = sig.getSignatureString(name); 

        Map methodsSameName = (Map)methodsByName.get(name);
        if (methodsSameName == null)
        {
            methodsSameName = new HashMap();
            methodsByName.put(name, methodsSameName);
        }
        else
        {
            if (methodsSameName.containsKey(sigStr))
                return false; // ya está insertado
        }

        methodsSameName.put(sigStr,method);
        NativeBehavior methodOld = (NativeBehavior)methodsBySig.put(sigStr, method); 
//        if (methodOld != null)
//            throw new JNIEasyException("INTERNAL ERROR");
        
        return true;
    }    
    
    public synchronized Collection findBehaviorsByName(String name)
    {
        Map methodsSameName = (Map)methodsByName.get(name); 
        if (methodsSameName == null) return null;
        return methodsSameName.values();
    }   
    
    public synchronized NativeBehavior findBehavior(String name,NativeBehaviorSignature sig)
    {        
        Map methodsSameName = (Map)methodsByName.get(name);
        if (methodsSameName == null)
            return null;
        
        String sigStr = ((NativeBehaviorSignatureRuntimeImpl)sig).getSignatureString(name);            
        return (NativeBehavior)methodsSameName.get(sigStr);
    }    
    
    public synchronized NativeBehavior findBehaviorBySignature(String signature) 
    {
        return (NativeBehavior)methodsBySig.get(signature);
    }
    
    public synchronized Collection removeBehaviorsByName(String name)
    {        
        Map methodsSameName = (Map)methodsByName.remove(name);
        if (methodsSameName == null)
            return null;
        for(Iterator it = methodsSameName.keySet().iterator(); it.hasNext(); )
        {
            String sigStr = (String)it.next();
            methodsBySig.remove(sigStr);
        }
        return methodsSameName.values();
    }
    
    public synchronized NativeBehavior removeBehavior(String name,NativeBehaviorSignature sig)
    {        
        Map methodsSameName = (Map)methodsByName.get(name);
        if (methodsSameName == null)
            return null; 
        
        String sigStr = ((NativeBehaviorSignatureRuntimeImpl)sig).getSignatureString(name);            
        NativeBehavior method = (NativeBehavior)methodsSameName.remove(sigStr);
        if (methodsSameName.isEmpty())
            methodsByName.remove(name);
        methodsBySig.remove(sigStr);
        return method;
    }   
    
    public synchronized void removeAllBehaviors()
    {    
        this.methodsByName.clear();
        this.methodsBySig.clear();
    }
    
    public synchronized Map getMethodsByNameReadOnly()
    {
        return Collections.unmodifiableMap(methodsByName);
    }
    
    public synchronized Map getMethodsBySignatureReadOnly()
    {
        return Collections.unmodifiableMap(methodsBySig);
    }
    
    
}
