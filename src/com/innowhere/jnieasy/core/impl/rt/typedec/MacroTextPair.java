/*
 * MacroTextPair.java
 *
 * Created on 10 de agosto de 2006, 14:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.JNIEasyException;
import java.util.Set;

/**
 *
 * @author jmarranz
 */
public class MacroTextPair
{
    protected String macro;
    protected String text;
            
    /**
     * Creates a new instance of MacroTextPair
     */
    public MacroTextPair(String macro,String text)
    {
        this.macro = macro;
        this.text = text;
    }
    
    public String getMacro()
    {
        return macro;
    }

    public String getText()
    {
        return text;
    }
    
    public static MacroTextPair[] decode(String macroTextPairsExpr)
    {
        String[] macroTextPairs = macroTextPairsExpr.split(";");
        MacroTextPair[] res = new MacroTextPair[macroTextPairs.length];
        for(int i = 0; i < macroTextPairs.length; i++)
        {
            String macroTextPair = macroTextPairs[i];
            String text;
            String macro;
            int pos = macroTextPair.indexOf(':');
            if (pos != -1)
            {
                macro = macroTextPair.substring(0,pos);
                text = macroTextPair.substring(pos + 1);                        
            }
            else
            {
                macro = null;
                text = macroTextPair;
            }
            res[i] = new MacroTextPair(macro,text);
        }
        
        return res;
    }
    
    public static String parseText(String macroTextPairsExpr,NativeTypeManagerRuntimeImpl typeMgr)
    {
        Set macros = typeMgr.getMacrosInternal().keySet();        
        
        // Devolvemos el primer text que cumpla que la parte del prefijo
        // no está especificado o cumple el patrón del prefijo definido en macros (si existe).
        MacroTextPair[] macroTextPairs = decode(macroTextPairsExpr);    
        
        for(int i = 0; i < macroTextPairs.length; i++)
        {
            MacroTextPair macroTextPair = macroTextPairs[i];
            String macro = macroTextPair.getMacro();
            String text = macroTextPair.getText();           
            if (macro == null)
                return text;       
            else if (macros.contains(macro))
                return text;                
        }
        
        if (macros.isEmpty()) throw new JNIEasyException("No prefix was defined and all declarations contain prefixes: " + macroTextPairsExpr);
        else throw new JNIEasyException("No macro matches any prefix in expression: " + macroTextPairsExpr);
    }

}
