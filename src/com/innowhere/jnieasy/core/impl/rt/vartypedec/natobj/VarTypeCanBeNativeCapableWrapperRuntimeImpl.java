/*
 * VarTypeCanBeNativeCapableWrapperRuntimeImpl.java
 *
 * Created on 6 de enero de 2005, 16:09
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.mustbe.VarTypeCanBeNativeCapableRuntimeImpl;

public abstract class VarTypeCanBeNativeCapableWrapperRuntimeImpl extends VarTypeNativeFieldContainerRuntimeImpl
{
    protected VarTypeCanBeNativeCapableRuntimeImpl wrappedVarType;
    
    /**
     * Creates a new instance of VarTypeCanBeNativeCapableWrapperRuntimeImpl
     */
    public VarTypeCanBeNativeCapableWrapperRuntimeImpl(VarTypeCanBeNativeCapableWrapperImpl varTypeDec,TypeCanBeNativeCapableWrapperRuntimeImpl typeDecRt,
                VarTypeCanBeNativeCapableRuntimeImpl wrappedVarType)
    {
        super(varTypeDec,typeDecRt);
        
        if (wrappedVarType != null)
        {
            this.wrappedVarType = wrappedVarType;
            this.wrappedVarType.setWrapperVarType(this);
        }
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl getTypeCanBeNativeCapableWrapperRuntime()
    {
        return (TypeCanBeNativeCapableWrapperRuntimeImpl)typeRt;
    }
    
    /**
     * Getter for property wrappedVarType.
     * 
     * @return Value of property wrappedVarType.
     */
    public VarTypeCanBeNativeCapableRuntimeImpl getWrappedVarType()
    {
        return wrappedVarType;
    }

    /**
     * Setter for property wrappedVarType.
     * 
     * @param wrappedVarType New value of property wrappedVarType.
     */
    public void setWrappedVarType(VarTypeCanBeNativeCapableRuntimeImpl wrappedVarType)
    {
        this.wrappedVarType = wrappedVarType;
    }

}
