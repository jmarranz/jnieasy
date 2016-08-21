/*
 * TypeNativeCapableRuntimeImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;

import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

public class TypeNativeCapableDefaultRuntimeImpl extends TypeNativeCapableRuntimeImpl
{
    /**
     * Creates a new instance of TypeNativeCapableRuntimeImpl
     */
    public TypeNativeCapableDefaultRuntimeImpl(TypeNativeCapableDefaultImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }    
}
