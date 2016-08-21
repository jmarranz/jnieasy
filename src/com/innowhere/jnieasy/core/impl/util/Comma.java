/*
 * Comma.java
 *
 * Created on 9 de junio de 2005, 19:01
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
public class Comma extends Separator
{
    protected final static Comma SINGLETON = new Comma();
    
    /** Creates a new instance of Comma */
    private Comma()
    {
        super(',');
    }
    
    public static Comma getComma()
    {
        return SINGLETON;
    }
}
