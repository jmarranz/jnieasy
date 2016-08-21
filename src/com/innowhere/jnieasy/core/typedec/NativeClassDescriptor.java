/*
 * NativeClassDescriptor.java
 *
 * Created on 24 de junio de 2005, 14:56
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeClassDescriptor</code> interface is the base interface
 * of descriptor interfaces of all user defined native classes.
 *
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#getClassDescriptor(Class)
 */

public interface NativeClassDescriptor
{
    /**
     * Returns the size of the native memory of an instance of this native type.
     * 
     * 
     * 
     * @return the size of the native memory of the type.
     * @see TypeNative#size()
     */
    public long size();
    
    /**
     * Returns the efective native alignment size of the type.
     * <p>
     * 
     * 
     * 
     * @return the alignment size of the native memory of the type.
     * @see TypeNative#preferredAlignSize()
     * @see NativeFieldStructureDescriptor#alignSize()
     */        
    public long alignSize();
    
    /**
     * Returns the default native type declaration of this class.
     * <p>
     * @return the default native type.
     */
    public TypeNative getType();
}
