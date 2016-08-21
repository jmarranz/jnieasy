/*
 * TypeNativeStringRuntimeImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;

import com.innowhere.jnieasy.core.data.NativeString;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringRuntime;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;

public class TypeNativeStringRuntimeImpl extends TypeNativeStringBasedRuntimeImpl implements TypeNativeStringRuntime
{
   
    /**
     * Creates a new instance of TypeNativeStringRuntimeImpl
     */
    public TypeNativeStringRuntimeImpl(TypeNativeStringImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public NativeString newString(String value)
    {
        return (NativeString)wrapValue(value);
    }
           
}
