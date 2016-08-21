/*
 * RuntimeUtil.java
 *
 * Created on 8 de septiembre de 2005, 11:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

/**
 *
 * @author jmarranz
 */
public class RuntimeUtil
{
    
    /** Creates a new instance of RuntimeUtil */
    public RuntimeUtil()
    {
    }
    
    public static String[] extractClassNames(Class[] classArray)
    {
        String[] array = new String[classArray.length];
        for(int i = 0; i < classArray.length; i++)
        {
            array[i] = classArray[i].getName();
        }
        return array;
    }    
}
