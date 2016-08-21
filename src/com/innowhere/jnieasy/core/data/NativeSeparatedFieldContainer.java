/*
 * NativeSeparatedFieldContainer.java
 *
 * Created on 13 de octubre de 2005, 19:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.data;

/**
 * The <code>NativeSeparatedFieldContainer</code> is the interface implemented by 
 * native capable classes containing separated multiple native fields like  
 * structures and C++ classes (not unions). 
 * <p>
 * Native memory of fields is not shared, anyway several consecutive fields may be 
 * declared as (anonymous) unions sharing their memory. 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */
public interface NativeSeparatedFieldContainer extends NativeMultipleFieldContainer
{
    
}
