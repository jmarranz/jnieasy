/*
 * ClassFinder.java
 *
 * Created on 30 de marzo de 2005, 19:26
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;

import com.innowhere.jnieasy.core.impl.common.ClassInfoFinder;

/**
 *
 * @author  jmarranz
 */
public class ClassTypeFinder extends ClassInfoFinder
{
    protected ClassTypeManagerImpl classTypeMgr;    
    
    /** Creates a new instance of ClassFinder */
    public ClassTypeFinder(ClassTypeManagerImpl classTypeMgr)
    {
        this.classTypeMgr = classTypeMgr;
    }
    
    public Object find(String className)
    {
        return classTypeMgr.findClassType(className);
    }
    
}
