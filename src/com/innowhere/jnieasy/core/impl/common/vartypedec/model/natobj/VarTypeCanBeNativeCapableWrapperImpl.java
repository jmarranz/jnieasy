/*
 * VarTypeCanBeNativeCapableWrapperImpl.java
 *
 * Created on 6 de enero de 2005, 16:09
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;



public abstract class VarTypeCanBeNativeCapableWrapperImpl extends VarTypeNativeObjectFieldContainerImpl
{
    protected VarTypeCanBeNativeCapableImpl wrappedVarType;
    
    /**
     * Creates a new instance of VarTypeCanBeNativeCapableWrapperImpl
     */
    public VarTypeCanBeNativeCapableWrapperImpl(TypeCanBeNativeCapableWrapperImpl typeDec)
    {
        super(typeDec);
    }
    
    public VarTypeCanBeNativeCapableWrapperImpl(TypeCanBeNativeCapableWrapperImpl typeDec,VarTypeCanBeNativeCapableImpl wrappedVarType)
    {
        super(typeDec);
        
        this.wrappedVarType = wrappedVarType;
    }    
    
    public VarTypeCanBeNativeCapableImpl getVarTypeCanBeNativeCapable()
    {
        if (wrappedVarType == null)
            this.wrappedVarType = newVarTypeCanBeNativeCapable();
        
        return wrappedVarType;        
    }

    public void setVarTypeCanBeNativeCapable(VarTypeCanBeNativeCapableImpl wrappedVarType)
    {
        this.wrappedVarType = wrappedVarType;
    }
 
    public int getDefaultVarConv()
    {
        return getVarTypeCanBeNativeCapable().getDefaultVarConv();
    }    

    public int getVarConv()
    {
        return getVarTypeCanBeNativeCapable().getVarConv();
    }
    
    public void setVarConv(int varConv)
    {
        getVarTypeCanBeNativeCapable().setVarConv(varConv);
    }
    
    public boolean isFixedVarConv()
    {
        return getVarTypeCanBeNativeCapable().isFixedVarConv();
    }
    
    public void check()
    {    
        super.check();
        getVarTypeCanBeNativeCapable().checkShared();
    }
    
    public abstract VarTypeCanBeNativeCapableImpl newVarTypeCanBeNativeCapable();
}
