/*
 * Space.java
 *
 * Created on 9 de junio de 2005, 19:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.util;

/**
 *
 * @author jmarranz
 */
public class Space extends Separator
{
    protected final static Space SINGLETON = new Space();
    
    /** Creates a new instance of Space */
    private Space()
    {
        super(' ');
    }
    
    public static Space getSpace()
    {
        return SINGLETON;
    }    
}
