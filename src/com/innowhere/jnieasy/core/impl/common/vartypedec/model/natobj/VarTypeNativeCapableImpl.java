/*
 * VarTypeNativeCapableImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;



public abstract class VarTypeNativeCapableImpl extends VarTypeNativeObjectImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeCapableImpl
     */
    public VarTypeNativeCapableImpl(TypeNativeCapableImpl typeDec)
    {
        super(typeDec);
    }
       
    public boolean needAuxNativeCapable()
    {
        return false;
    }            

}
