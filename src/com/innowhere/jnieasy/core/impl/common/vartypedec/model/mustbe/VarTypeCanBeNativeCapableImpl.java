/*
 * VarTypeCanBeNativeCapableImpl.java
 *
 * Created on 6 de enero de 2005, 15:58
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe;

import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeCanBeNativeCapableWrapperImpl;


public abstract class VarTypeCanBeNativeCapableImpl extends VarTypeNativeObjectImpl
{
    protected VarTypeCanBeNativeCapableWrapperImpl wrapperVarType;
    
    /**
     * Creates a new instance of VarTypeCanBeNativeCapableImpl
     */
    public VarTypeCanBeNativeCapableImpl(TypeCanBeNativeCapableImpl typeDec,VarTypeCanBeNativeCapableWrapperImpl wrapperVarType)
    {
        super(typeDec);
        
        this.wrapperVarType = wrapperVarType; // Puede ser null
    }    
    
    public VarTypeCanBeNativeCapableWrapperImpl getVarTypeCanBeNativeCapableWrapper()
    {
        if (wrapperVarType == null)
            this.wrapperVarType = newVarTypeCanBeNativeCapableWrapper();
        
        return wrapperVarType;
    }
    
    /**
     * Setter for property wrapperVarType.
     * 
     * @param wrapperVarType New value of property wrapperVarType.
     */
    public void setVarTypeCanBeNativeCapableWrapper(VarTypeCanBeNativeCapableWrapperImpl wrapperVarType)
    {
        this.wrapperVarType = wrapperVarType;
    }
 
   
    public void check()
    {
        super.check();
        checkShared();
    }    
        
    public void checkShared()
    {
        // Se deriva en el caso Array
    }
    
    public boolean needAuxNativeCapable()
    {
        return true;
    }            

    public abstract VarTypeCanBeNativeCapableWrapperImpl newVarTypeCanBeNativeCapableWrapper();    
}
