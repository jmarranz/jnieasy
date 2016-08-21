/*
 * FetchUnFetchContext.java
 *
 * Created on 22 de julio de 2005, 13:48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author jmarranz
 */
public class FetchUnFetchContext
{
    protected Set objects = new HashSet();
    
    /** Creates a new instance of FetchUnFetchContext */
    public FetchUnFetchContext()
    {
    }
    
    public int size()
    {
        return objects.size();
    }
    
    public void add(NativeStateManager stateMgr)
    {
        // Insertamos el NativeStateManager y no el propio objeto porque todos los objetos
        // son nativos en este caso y porque así evitamos interferencias de posibles equals()
        // y hashCode() definidos por el usuario        
        objects.add(stateMgr);
    }
    
    public boolean contains(NativeStateManager stateMgr)
    {      
        return objects.contains(stateMgr);
    }    
}
