/*
 * NativeFieldStructureDescriptor.java
 *
 * Created on 29 de junio de 2005, 13:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeFieldStructureDescriptor</code> is the descriptor interface 
 * of native fields of user defined native structure and C++ classes.
 *
 * @author Jose M. Arranz Santamaria
 */
public interface NativeFieldStructureDescriptor extends NativeFieldDescriptor
{
    /**
     * Returns the effective native alignment size of the native field.
     *
     * @return the alignment size of the native memory of the native field.
     * @see TypeNative#preferredAlignSize()
     */    
    public long alignSize();   
    
    /**
     * Returns the size of the native field in the field structure. 
     * <p>
     * The "oversize" of alignment or as part of a union or anonymous union is not counted.
     *
     * @return the size of the native memory of the native field.
     * @see TypeNative#size()
     */        
    public long size();
}
