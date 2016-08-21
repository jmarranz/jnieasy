/*
 * MemorySizeRuntime.java
 *
 * Created on 17 de agosto de 2006, 12:23
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author jmarranz
 */
public class MemorySizeRuntime
{
    protected static final String addressMacro = "address";
    protected static final Long addressValue = new Long(TypeSizes.getADDRESS());

    
    public static long parseSize(String sizesStrExpr,NativeTypeManagerRuntimeImpl typeMgr)
    {
        if (sizesStrExpr == null) return TypeSizes.getUNKNOWN_SIZE();
        
        String macro = typeMgr.parseTextWithMacros(sizesStrExpr);
        
        try
        {
            return Long.parseLong(macro);        
        }
        catch(NumberFormatException ex)
        {        
            // Es una macro (o debe serlo)
        }                
        
        if (addressMacro.equals(macro))
        {
            return addressValue.longValue();            
        }        
        
        Map macros = typeMgr.getMacrosInternal();
        
        Object value = macros.get(macro);
        if (value == null) throw new JNIEasyException("Expected an integer as value of macro: " + macro + ", current value is null");
        if (value instanceof Number)
            return ((Number)value).longValue();
        else
            throw new JNIEasyException("Expected an integer as value of macro: " + macro + ", declared value is: " + value);                    
    }

}
