/*
 * SourceCode.java
 *
 * Created on 3 de junio de 2005, 21:06
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.util;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jmarranz
 */
public class SourceCode
{
    protected List tokens;
    
    /** Creates a new instance of SourceCode */
    public SourceCode(String source)
    {
        this.tokens = Token.parse(source);
    }
 
    public SourceCode(List tokens)
    {
        this.tokens = tokens;
    }
     
    public SourceCode()
    {
        this.tokens = new LinkedList();
    }    
    
    public static SourceCode parse(String source)
    {
        return new SourceCode(source);
    }
    
    public String getContent()
    {
        return Token.toString(tokens,false);
    }
    
    public String getContent(boolean addSpaces)
    {    
        return Token.toString(tokens,addSpaces);        
    }
    
    public void addToken(Token token)
    {
        tokens.add(token);
    }
    
    public int getNumTokens()
    {
        return tokens.size();
    }
    
    public Token getToken(int index)
    {
        return (Token)tokens.get(index);
    }
    
    public Token getFirstToken()
    {
        return (Token)tokens.get(0);
    }
    
    public Token getLastToken()
    {
        return (Token)tokens.get(tokens.size() - 1);
    }
    
    public SourceCode getRange(int fromIndex,int toIndex)
    {
        return new SourceCode(tokens.subList(fromIndex, toIndex));
    }
    
    public Token removeToken(int index)
    {
        return (Token)tokens.remove(index);
    }
    
    public Token removeLast()
    {
        return (Token)tokens.remove(tokens.size() - 1);
    }    
    
    public Token removeFirst()
    {
        return (Token)tokens.remove(0);
    }        
    
    public String toString()   
    {
        return getContent();
    }

    public void trimLeft()
    {
        if (!tokens.isEmpty())
        {        
            Token first = getFirstToken();
            if (first instanceof Space)
            {
                tokens.remove(0);  
                // repetimos pues es posible que existan otros espacios posteriores
                trimLeft();            
            }
        }
    }        
    
    public void trimRight()
    {
        if (!tokens.isEmpty())
        {
            Token last = getLastToken();
            if (last instanceof Space)
            {
                tokens.remove(tokens.size() - 1);  
                // repetimos pues es posible que existan otros espacios previos
                trimRight();            
            }
        }
    }    
    
    public void trim()
    {
        trimLeft();
        trimRight();                
    }   
    
    public LinkedList split(Separator sep)
    {
        // Partimos a partir del patrón,
        // NO partimos dentro de los bloques
        LinkedList resList = new LinkedList();
        for(Iterator it = tokens.iterator(); it.hasNext(); )
        {
            Token token = (Token)it.next();
            if (token.getClass().equals(sep.getClass()))
            {
                // es un separador del tipo dado por argumento
                if (resList.size() == 0)
                {
                    // aunque a la izquierda no haya nada hay que hacer constancia del separador
                    resList.add(new SourceCode());                    
                }

                resList.add(new SourceCode()); // para la parte derecha
            }
            else
            {
                SourceCode srcCode;
                if (resList.size() > 0)
                    srcCode = (SourceCode)resList.getLast();
                else
                {
                    srcCode = new SourceCode();
                    resList.add(srcCode);
                }
                srcCode.addToken(token);
            }
        }
        
        return resList;
    }
    
    public void removeTokensOfType(Class tokenType)
    {
        // elimina los tokens del tipo dado por el argumento
        for(Iterator it = tokens.iterator(); it.hasNext(); )
        {
            Token token = (Token)it.next();
            if (token.getClass().equals(tokenType))
                it.remove();
        }        
    }
    
    public static void removeEmpty(List sourceList)
    {
        for(Iterator it = sourceList.iterator(); it.hasNext(); )
        {
            SourceCode srcCode = (SourceCode)it.next();
            if (srcCode.getNumTokens() == 0)
                it.remove();
        }
    }
   
}
