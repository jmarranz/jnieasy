/*
 * NativeFieldCallback.java
 *
 * Created on 20 de julio de 2005, 19:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.method;

/**
 * The <code>NativeFieldCallback</code> is the interface implemented by
 * native capable classes that make accessible Java fields
 * from native seen as methods. Java fields 
 * are accessed using Java reflection or normal access.
 *
 * @author  Jose M. Arranz Santamaria
 */
public interface NativeFieldCallback extends NativeCallback,NativeFieldMethod
{
   
}
