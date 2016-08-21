/*
 * Word.java
 *
 * Created on 9 de junio de 2005, 18:45
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
public class Word extends Token
{
    protected StringBuffer buffer = new StringBuffer();
    
    /** Creates a new instance of Word */
    public Word()
    {
    }
    
    public void append(char c)
    {
        buffer.append(c);
    }
    
    public String getContent()
    {
        return buffer.toString();
    }
    
    public void setContent(String content)
    {
        buffer = new StringBuffer(content);
    }   
    
    public String toString()
    {
        return buffer.toString();
    }
    
    public boolean canBeJavaIdentifier()
    {
        if (buffer.length() == 0) return false;
        if (!Character.isJavaIdentifierStart(buffer.charAt(0)))
            return false;
        for (int i = 1; i < buffer.length(); i++)
        {
            char c = buffer.charAt(i);
            if (!Character.isJavaIdentifierPart(c)) 
                return false;
        }        
        return true;
    }    
    
    public boolean canBeClassName()
    {
        for (int i = 0; i < buffer.length(); i++)
        {
            char c = buffer.charAt(i);
            if ((c != '.') && !Character.isJavaIdentifierPart(c)) 
                return false;
        }
        return true;
    }
}
