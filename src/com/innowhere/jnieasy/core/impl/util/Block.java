/*
 * Block.java
 *
 * Created on 6 de junio de 2005, 16:44
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
/* Representa los bloques susceptibles de ser anidados, tal y como () y {}
 * No es el caso de [] pero también los procesamos como bloques para simplificar el parser
 */

public abstract class Block extends Token
{
    protected SourceCode srcCode;
    
    /** Creates a new instance of Block */
    public Block(String content)
    {
        this.srcCode = new SourceCode(content);
    }
    
    public SourceCode getSourceCode()
    {
        return srcCode;
    }        
    
    public String toString()    
    {
        return getContent();
    }    
}
