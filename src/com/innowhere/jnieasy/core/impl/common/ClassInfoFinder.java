/*
 * ClassInfoFinder.java
 *
 * Created on 30 de marzo de 2005, 19:24
 */

package com.innowhere.jnieasy.core.impl.common;

/**
 *
 * @author  jmarranz
 */
public abstract class ClassInfoFinder
{
    
    /** Creates a new instance of ClassInfoFinder */
    public ClassInfoFinder()
    {
    }
    
    public abstract Object find(String className);
}
