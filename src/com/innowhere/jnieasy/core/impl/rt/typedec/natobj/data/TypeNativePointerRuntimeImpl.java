/*
 * PointerType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePointerRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;


public class TypeNativePointerRuntimeImpl extends TypeNativeObjectFieldContainerRuntimeImpl implements TypeNativePointerRuntime
{
    protected VarTypeNativeObjectRuntimeImpl addressedVarType;
            
    /** Creates a new instance of PointerType */
    public TypeNativePointerRuntimeImpl(TypeNativePointerImpl typeDec,Class javaClass,RuntimeContext ctx)
    {
        super(typeDec,javaClass,ctx.getRuntimeManager());
        
        this.addressedVarType = (VarTypeNativeObjectRuntimeImpl)VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(getAddressedClass(), typeDec.getAddressedVarTypeNativeObject(), ctx);       
    }   
    
    public TypeNativePointerImpl getTypeNativePointer()
    {
        return (TypeNativePointerImpl)typeDec;
    }

    public VarTypeNativeObjectRuntimeImpl getAddressedVarTypeNativeObjectRuntime()
    {
        return addressedVarType;
    }

    public void setAddressedVarTypeNativeObjectRuntime(VarTypeNativeObjectRuntimeImpl addressedVarType)
    {
        this.addressedVarType = addressedVarType;
        getTypeNativePointer().setAddressedVarTypeNativeObject((VarTypeNativeObjectImpl)addressedVarType.getVarTypeNative());
    }
    
    public VarTypeNative getPointerDec()
    {
        return addressedVarType;
    }
    
    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }
    
    public Class getAddressedClass()
    {
        TypeNativePointerImpl typeDec = getTypeNativePointer();
        TypeNativeImpl typeDecAddressed = typeDec.getAddressedVarTypeNativeObject().getTypeNative();
        return TypeNativeRuntimeImpl.getClassImpl(typeDecAddressed);
    }    

}
