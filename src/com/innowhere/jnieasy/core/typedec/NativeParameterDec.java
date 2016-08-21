/*
 * NativeParameterDec.java
 *
 * Created on 28 de agosto de 2006, 14:24
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>NativeParameterDec</code> interface represents 
 * a parameter declaration of a native method signature.
 * <p>
 * This object can be used to declare method signatures.
 *
 * @author Jose M. Arranz Santamaria
 * @see VarTypeNative#decParameter()
 * @see NativeSignatureManager#decParameter(VarTypeNative)
 * @see NativeSignatureManager#decConstructor(Class,Object[],int) 
 */
public interface NativeParameterDec
{
    /** 
     * Returns true if the parameter was declared as a variable argument number holder.
     *
     * @return true if the parameter is a variable argument number holder.
     * @see VarTypeNative#decParameter(boolean)
     * @see NativeSignatureManager#decParameter(VarTypeNative,boolean)     
     */
    public boolean isVarArgs();    
}
