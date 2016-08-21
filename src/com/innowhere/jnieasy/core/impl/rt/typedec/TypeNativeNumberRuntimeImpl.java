/*
 * TypeNativeNumberRuntimeImpl.java
 *
 * Created on 6 de octubre de 2005, 9:03
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeNumberImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class TypeNativeNumberRuntimeImpl extends TypeNativePrimitiveRuntimeImpl
{
    
    /**
     * Creates a new instance of TypeNativeNumberRuntimeImpl
     */
    public TypeNativeNumberRuntimeImpl(TypeNativeNumberImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
}
