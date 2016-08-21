/*
 * CloneContext.java
 *
 * Created on 22 de julio de 2005, 13:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author jmarranz
 */
public class CloneContext
{
    protected Map objects = new HashMap();
            
    /** Creates a new instance of CloneContext */
    public CloneContext()
    {
    }
    
    public Object add(NativeStateManager stateMgrOrig,NativeCapableInternal cloned)
    {
        // Insertamos el NativeStateManager y no el propio objeto porque todos los objetos
        // son nativos en este caso y porque así evitamos interferencias de posibles equals()
        // y hashCode() definidos por el usuario       
        return objects.put(stateMgrOrig, cloned);
    }
    
    public NativeCapableInternal findCloned(NativeStateManager stateMgrOrig)
    {
        return (NativeCapableInternal)objects.get(stateMgrOrig);
    }
}
