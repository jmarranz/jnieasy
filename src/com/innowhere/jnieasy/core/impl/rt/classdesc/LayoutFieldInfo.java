/*
 * LayoutFieldInfo.java
 *
 * Created on 17 de octubre de 2005, 22:05
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

/**
 *
 * @author jmarranz
 */
public abstract class LayoutFieldInfo
{
    
    /**
     * Creates a new instance of LayoutFieldInfo 
     */
    public LayoutFieldInfo()
    {
    }
    
    protected static long align(long offset, long boundary) 
    {
        if (offset != 0)
        {
            long r = offset % boundary;
            if (r != 0)
                offset += boundary - r;
            return offset;
        }
        else
            return 0;
    }
    
    public abstract long getAlignSize(); 
    public abstract long getSize();  
    public abstract void setOffset(long offset);    
}
