/*
 * TypeNativeConstructor.java
 *
 * Created on 12 de enero de 2005, 17:10
 */

package com.innowhere.jnieasy.core.typedec;

import com.innowhere.jnieasy.core.method.*;

/**
 * The <code>TypeNativeConstructor</code> is the interface that represents a native
 * constructor type declaration.
 * <p>
 * 
 * 
 * 
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decConstructor(Class,NativeConstructorSignature)
 * @see com.innowhere.jnieasy.core.method.NativeConstructor
 */

public interface TypeNativeConstructor extends TypeNativeBehavior
{
    /**
     * Returns the native signature of the declared constructor.
     *
     * @return the native signature object.
     */        
    public NativeConstructorSignature getConstructorSignature();    
}
