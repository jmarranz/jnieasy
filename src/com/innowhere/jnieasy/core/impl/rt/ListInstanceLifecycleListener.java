/*
 * ListInstanceLifecycleListener.java
 *
 * Created on 22 de septiembre de 2005, 18:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.listener.InstanceLifecycleListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 *
 * @author jmarranz
 */
public class ListInstanceLifecycleListener
{
    protected Map listeners = new HashMap();
            
    /** Creates a new instance of ListInstanceLifecycleListener */
    public ListInstanceLifecycleListener()
    {        
    }
    
    public synchronized void addListener(InstanceLifecycleListener listener,Class[] classes)
    {
        listeners.put(listener,classes);
    }
    
    public synchronized void removeListener(InstanceLifecycleListener listener)
    {
        listeners.remove(listener);
    }    
    
    public synchronized boolean isEmpty()
    {
        return listeners.isEmpty();
    }
    
    public synchronized ArrayList findListeners(Class clasz)
    {
        int size = listeners.size();
        if (size == 0) return null;
        ArrayList matched = new ArrayList();
        for(Iterator it = listeners.entrySet().iterator(); it.hasNext(); )
        {
            Map.Entry entry = (Map.Entry)it.next();
            InstanceLifecycleListener listener = (InstanceLifecycleListener)entry.getKey();
            Class[] classes = (Class[])entry.getValue();
            if (classes == null)
                matched.add(listener);
            else
            {
                for(int i = 0; i < classes.length; i++)
                {
                    if (classes[i].isAssignableFrom(clasz))
                        matched.add(listener);
                }
            }
        }
        if (matched.size() == 0) return null;
        return matched;
    }
   
}
