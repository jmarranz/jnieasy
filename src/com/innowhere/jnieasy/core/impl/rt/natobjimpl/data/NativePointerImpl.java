/*
 * NativePointerImpl.java
 *
 * Created on 11 de diciembre de 2004, 12:33
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativePointerInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativePointerStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.TypeNative;



/* De esta clase sólo derivan clases que actúan como proxy */

public abstract class NativePointerImpl extends NativeObjectFieldContainerImpl implements NativePointerInternal
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativePointerImpl
     */
    public NativePointerImpl()
    {
    }
    
    public TypeNative jnieasyGetDefaultType()
    {
        RuntimeContext ctx = jnieasyGetDefaultRuntimeContext();
        TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(getClass(),ctx);
        Object value = jnieasyGetInternalValue();
        VarTypeNativeObjectRuntimeImpl varTypeDecField = (VarTypeNativeObjectRuntimeImpl)VarTypeNativeRuntimeImpl.getDefaultAssociatedType(value,false,ctx);
        typeDec.setAddressedVarTypeNativeObjectRuntime(varTypeDecField);
        return typeDec;
    }    
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)jnieasyGetType();
        VarTypeNativeObjectRuntimeImpl addressedTypeDec = typeDec.getAddressedVarTypeNativeObjectRuntime();
        Object value = addressedTypeDec.getObject(0,0,(NativeFieldContainerStateManagerImpl)stateMgr,jnieasyGetInternalValue(),fetchMode,(FetchUnFetchContext)fetchCtx);
        jnieasySetInternalValue(value);
        return value;
    }
    
    public void jnieasySetValue(Object newValue,int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)jnieasyGetType();
        VarTypeNativeObjectRuntimeImpl addressedTypeDec = typeDec.getAddressedVarTypeNativeObjectRuntime();
        addressedTypeDec.setObject(0,0,(NativeFieldContainerStateManagerImpl)stateMgr,newValue,unFetchMode,(FetchUnFetchContext)unfetchCtx,(AttachCopyContext)attachCopyCtx);
        jnieasySetInternalValue(newValue);
    }        
    
    public long jnieasyGetSize()
    {
        return ClassTypeNativePointerRuntimeImpl.getObjectSizeStatic();
    }
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        Object value = jnieasyGetInternalValue();
        if (value != null)
        {
            TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)jnieasyGetType();
            VarTypeNativeObjectRuntimeImpl addressedTypeDec = typeDec.getAddressedVarTypeNativeObjectRuntime();            
            value = addressedTypeDec.clone(0,(NativeFieldContainerStateManagerImpl)stateMgr, value, (CloneContext)cloneCtx);
            jnieasySetInternalValue(value);
        }
    }
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        Object value = jnieasyGetInternalValue();
        if (value != null)
        {
            TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)jnieasyGetType();
            VarTypeNativeObjectRuntimeImpl addressedTypeDec = typeDec.getAddressedVarTypeNativeObjectRuntime();            
            addressedTypeDec.detachField(0,(NativeFieldContainerStateManagerImpl)stateMgr,value,freeMemMode, deep);
        }
    }
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativePointerStateManagerImpl();        
    }
}
