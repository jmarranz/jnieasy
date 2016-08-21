/*
 * Token.java
 *
 * Created on 3 de junio de 2005, 20:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.util;

import com.innowhere.jnieasy.core.JNIEasyException;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author jmarranz
 */
public abstract class Token
{
   
    /**
     * Creates a new instance of Token 
     */
    public Token()
    {
    }
    
    public static List parse(String source)
    {
        LinkedList tokens = new LinkedList();    
        parse(source,tokens);
        return tokens;
    }
        
    public static void parse(String source,LinkedList tokens)
    {
        int len = source.length();
        for(int i = 0; i < len; i++)
        {
            char c = source.charAt(i);
            if ((c == '(') || (c == '{') || (c == '['))
            {
                int posOpenerBlock = -1;
                int posCloserBlock = -1;
                Block block = null;
            
                if (c == '(')
                {
                    posOpenerBlock = i;
                    posCloserBlock = findRightMatch(source, posOpenerBlock, '(',')');                
                    block = new ParenthesisBlock(source.substring(posOpenerBlock + 1, posCloserBlock));
                }
                else if (c == '{')
                {
                    posOpenerBlock = i;
                    posCloserBlock = findRightMatch(source, posOpenerBlock, '{','}');                
                    block = new CurlyBracketBlock(source.substring(posOpenerBlock + 1, posCloserBlock));
                }
                else if (c == '[')
                {
                    posOpenerBlock = i;
                    posCloserBlock = findRightMatch(source, posOpenerBlock, '[',']');                
                    block = new SquareBracketBlock(source.substring(posOpenerBlock + 1, posCloserBlock));
                }
            
                tokens.add(block);
                i = posCloserBlock; // el i++ hará posicionarse al siguiente
            }            
            else if (Separator.isSeparator(c))
            {
                tokens.add(Separator.newSeparator(c));
            }
            else
            {
                Token last;
                if (tokens.isEmpty())
                {
                    last = new Word();
                    tokens.add(last);                    
                }
                else
                {
                    last = (Token)tokens.getLast();
                    if (!(last instanceof Word))
                    {
                        last = new Word();
                        tokens.add(last);
                    }                    
                }
                ((Word)last).append(c);
            }
        }
    }
    
    public abstract String getContent();
    
    public static String toString(List parts,boolean addSpaces)
    {
        StringBuffer res = new StringBuffer();
        for(Iterator it = parts.iterator(); it.hasNext(); )
        {
            Token part = (Token)it.next();
            res.append( part.toString() );
            if (addSpaces) res.append( " " );
        }
        return res.toString();
    }
    
    public static int findLeftMatch(String source, int posLast, char opener, char closer)
    {
        // Ejemplo: opener = '(' y closer = ')'
        // dada la posición del paréntesis que cierra ')' buscar el correspondiente que abre '(' a la izquierda
        int pos;
        int brCount = 1;
        for(pos = posLast - 1; pos >= 0; pos-- )
        {
            char c = source.charAt(pos);
            if (c == opener) brCount--; 
            else if (c == closer) brCount++;
            if (brCount == 0)
                return pos;
        }
        throw new JNIEasyException("Syntax error, missing '" + opener + "' :" + source);
    }    
    
    public static int findRightMatch(String source, int posFirst, char opener, char closer)
    {
        // Ejemplo: opener = '(' y closer = ')'
        // dada la posición del paréntesis que abre '(' buscar el correspondiente que cierra ')' a la derecha
        int pos;
        int brCount = 1;
        for(pos = posFirst + 1; pos < source.length(); pos++ )
        {
            char c = source.charAt(pos);
            if (c == opener) brCount++; 
            else if (c == closer) brCount--;
            if (brCount == 0)
                return pos;
        }
        throw new JNIEasyException("Syntax error, missing '" + closer + "' :" + source);
    }    
    
    public abstract String toString();
}
