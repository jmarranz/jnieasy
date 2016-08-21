/*
 * Separator.java
 *
 * Created on 9 de junio de 2005, 18:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.util;

import com.innowhere.jnieasy.core.JNIEasyException;

/**
 *
 * @author jmarranz
 */
public abstract class Separator extends Token
{
    protected char value;
    
    /** Creates a new instance of Separator */
    public Separator(char value)
    {
        this.value = value;
    }

    public static Separator newSeparator(char c)
    {
        if (c == ' ')
            return Space.getSpace();
        else if (c == ',')
            return Comma.getComma();
        else
            throw new JNIEasyException("INTERNAL ERROR");
    }
    
    public static boolean isSeparator(char c)
    {
        if (c == ' ')
            return true;
        else if (c == ',')
            return true;
        else
            return false;
    }
    
    public char getValue()
    {
        return value;
    }
    
    public String getContent()
    {
        return Character.toString(value);
    }
    
    public String toString()
    {
        return Character.toString(value);
    }
}
