/*
 * NativeSingleFieldContainer.java
 *
 * Created on 7 de octubre de 2005, 10:36
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeSingleFieldContainer</code> is the interface implemented by 
 * native capable classes containing only one Object native field.
 * <p>
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeSingleFieldContainer extends NativeFieldContainer
{
    /**
     * Returns the internal native field value synchronized 
     * with the native memory using the specified fetch mode 
     * if instance is native.
     * <p>
     * Concrete behavior is described in methods of inherited interfaces 
     * calling this method.
     * <p>
     * If field type is primitive the returned object is a primitive wrapper.
     *
     * @param fetchMode the fetch mode.
     * @return the internal field value.
     * @see com.innowhere.jnieasy.core.mem.Fetch
     */    
    public Object getValue(int fetchMode);  
    
    /**
     * Sets the internal native field value synchronizing
     * the native memory with the new value using the specified "unfetch" mode
     * if instance is native.
     * <p>
     * Concrete behavior is described on methods of inherited interfaces 
     * calling this method.
     * <p>
     * If field type is primitive the new value must be a primitive wrapper.
     *
     * @param value the new value.
     * @param unFetchMode the "unfetch" mode.
     * @see com.innowhere.jnieasy.core.mem.UnFetch
     */     
    public void setValue(Object value,int unFetchMode);     
        
    /**
     * Returns the internal native field value synchronized 
     * with the native memory using the default specified fetch mode 
     * if instance is native.
     * <p>
     * Current implementation calls {@link #getValue(int)} with the
     * default fetch mode.
     *
     * @return the internal field value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultFetchMode()
     */    
    public Object getValue();
    
    /**
     * Sets the internal native field value synchronizing
     * the native memory with the new value using the default "unfetch" mode
     * if instance is native.
     * <p>
     * Current implementation calls {@link #setValue(Object,int)} with the
     * default fetch mode.
     *
     * @param value the new value.
     * @see com.innowhere.jnieasy.core.mem.NativeManager#getDefaultUnFetchMode()
     */     
    public void setValue(Object value);    
}
