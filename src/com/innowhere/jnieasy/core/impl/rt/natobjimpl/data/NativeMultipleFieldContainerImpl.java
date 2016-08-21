/*
 * NativeMultipleFieldContainerImpl.java
 *
 * Created on 11 de diciembre de 2004, 12:33
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNative;



/* De esta clase sólo derivan clases que actúan como proxy */

public abstract class NativeMultipleFieldContainerImpl extends FieldContainerImpl implements NativeMultipleFieldContainer
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeMultipleFieldContainerImpl
     */
    public NativeMultipleFieldContainerImpl()
    {
    }
    
    public TypeNative jnieasyGetDefaultType()
    {
        RuntimeContext ctx = jnieasyGetDefaultRuntimeContext();
        return TypeNativeRuntimeImpl.newTypeNativeRuntime(getClass(),ctx);         
    }
    
    
    public long jnieasyGetSize()
    {
        // No conocemos el tamaño 
        return TypeSizes.getUNKNOWN_SIZE();
    }
    
    public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr)
    {
        // desconocemos los fields
    }
    
    public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        // idem
    }    
   
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        // idem
    }
        
    public void jnieasyAttachCopy(Object detachedCopy,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        // idem
    }    
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // idem
    }
    
    public NativeStateManager jnieasyNewNativeStateManager()
    {
        return new NativeFieldContainerStateManagerDefaultImpl();        
    }    

    public Object jnieasyGetField(int index)
    {
        throw new JNIEasyException("Unknown fields");
    }
    
    public void jnieasySetField(int index,Object value)    
    {
        throw new JNIEasyException("Unknown fields");
    }
        
    public Object jnieasyGetField(int index,int mode)
    {
        throw new JNIEasyException("Unknown fields");
    }
        
    public void jnieasySetField(int index,Object value,int mode)  
    {
        throw new JNIEasyException("Unknown fields");
    }
    
    public int jnieasyGetAbsoluteFieldCount()
    {
        throw new JNIEasyException("Unknown fields");        
    }
        
}
