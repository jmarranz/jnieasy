/*
 * ObjectArrayInitializer.java
 *
 * Created on 28 de marzo de 2005, 22:18
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

/**
 *
 * @author  jmarranz
 */
public class ObjectArrayInitializer
{
    protected Object[] array;
    
    /** Creates a new instance of ObjectArrayInitializer */
    public ObjectArrayInitializer(Object[] array)
    {
        this.array = array;
    }
    
    public ObjectArrayInitializer set(int i,Object value)
    {
        this.array[i] = value;
        return this;
    }
    
    public Object[] getArray()
    {
        return array;
    }
}
