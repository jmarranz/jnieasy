/*
 * PointerType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

public class TypeNativeMultipleFieldContainerRuntimeImpl extends TypeNativeFieldContainerRuntimeImpl
{
    /** Creates a new instance of PointerType */
    public TypeNativeMultipleFieldContainerRuntimeImpl(TypeNativeMultipleFieldContainerImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
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
