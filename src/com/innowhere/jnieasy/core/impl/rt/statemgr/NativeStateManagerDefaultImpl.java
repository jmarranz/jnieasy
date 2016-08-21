/*
 * NativeStateManagerDefaultImpl.java
 *
 * Created on 12 de septiembre de 2005, 17:52
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;



/**
 *
 * @author jmarranz
 */
public class NativeStateManagerDefaultImpl extends NativeStateManagerImpl
{
    
    /** Creates a new instance of NativeStateManagerDefaultImpl */
    public NativeStateManagerDefaultImpl()
    {
    }    
    
    public boolean isMemoryExecutable()
    {
        return false;
    }    
}
