/*
 * CurlyBracketBlock.java
 *
 * Created on 6 de junio de 2005, 16:52
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
/* Se puede llamar también "BraceBlock" */

public class CurlyBracketBlock extends Block
{
    
    /**
     * Creates a new instance of CurlyBracketBlock 
     */
    public CurlyBracketBlock(String content)
    {
        super(content);
    }
    
    public String getContent()
    {
        return "{" + srcCode.getContent() + "}";
    }       
    
}
