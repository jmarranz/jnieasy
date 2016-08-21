/*
 * ObjectWrapperImpl.java
 *
 * Created on 17 de noviembre de 2004, 21:03
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNative;
import com.innowhere.jnieasy.core.mem.NativeAddress;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBufferWrapperRuntimeImpl;



public abstract class CanBeNativeCapableImpl extends NativeObjectFieldContainerImpl implements CanBeNativeCapableInternal
{   
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /** Creates a new instance of ObjectWrapperImpl */
    public CanBeNativeCapableImpl()
    {
    }    

    public TypeNative jnieasyGetDefaultType()
    {
        RuntimeContext ctx = jnieasyGetDefaultRuntimeContext();
        TypeCanBeNativeCapableWrapperRuntimeImpl typeDec = (TypeCanBeNativeCapableWrapperRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(getClass(),ctx);
        Object value = jnieasyGetInternalValue();
        TypeCanBeNativeCapableRuntimeImpl typeDecField = (TypeCanBeNativeCapableRuntimeImpl)TypeNativeObjectRuntimeImpl.getDefaultAssociatedType(value,false,ctx);
        typeDec.setTypeCanBeNativeCapableRuntime(typeDecField);
        return typeDec;
    }    
    
    public boolean jnieasyIsFixedSize()
    {
        TypeCanBeNativeCapableWrapperRuntimeImpl typeDecImpl = jnieasyGetTypeCanBeNativeCapableWrapperRuntime();
        TypeCanBeNativeCapableRuntimeImpl wrappedTypeDec = typeDecImpl.getTypeCanBeNativeCapableRuntime();
        return wrappedTypeDec.isObjectKnownSize();        
    }
   
    public TypeCanBeNativeCapableWrapperRuntimeImpl jnieasyGetTypeCanBeNativeCapableWrapperRuntime()
    {
        return (TypeCanBeNativeCapableWrapperRuntimeImpl)jnieasyGetType();
    }
        
    public Object jnieasyNewWrappedValue()
    {
        if (jnieasyIsFixedSize())
        {
            TypeCanBeNativeCapableRuntimeImpl wrappedTypeDec = jnieasyGetTypeCanBeNativeCapableWrapperRuntime().getTypeCanBeNativeCapableRuntime();
            return wrappedTypeDec.newValue(); 
        }
        else
            return null;
    }    
    
    public void jnieasyCheckNewValue(Object newValue)
    {
        TypeCanBeNativeCapableWrapperRuntimeImpl typeDec = jnieasyGetTypeCanBeNativeCapableWrapperRuntime();
        if (typeDec.getNativeManager().isRuntimeChecking())
        {
            TypeCanBeNativeCapableRuntimeImpl wrappedTypeDec = typeDec.getTypeCanBeNativeCapableRuntime();
            wrappedTypeDec.checkValue(newValue); // importante en el caso de arrays para comprobar la longitud
        }
    }
    
    public void jnieasySetValue(Object newValue,NativeStateManager stateMgr)
    {
        // Este método no modifica la memoria nativa (aunque la lee)
        if (newValue == null) throw new JNIEasyException("Value wrapped can not be null");                   
        
        Object oldValue = jnieasyGetInternalValue();
        if (oldValue == newValue) return;
        
        jnieasyCheckNewValue(newValue);

        if (!jnieasyIsFixedSize())
        {
            TypeCanBeNativeCapableWrapperRuntimeImpl typeDec = jnieasyGetTypeCanBeNativeCapableWrapperRuntime();
            if (typeDec.getNativeManager().isRuntimeChecking())
            {            
                // Afecta a la memoria nativa, hay que hacer pruebas antes
                // si jnieasyFixedSize es true el checkValue asegura que las dimensiones son las esperadas
                // por lo que el tamaño es correcto. Pero si es false las dimensiones del tipo son indefinidas y pueden ser distintas
                // aunque el tamaño del objeto no puede sobrepasar la memoria reservada
                long size = stateMgr.getBuffer().size();
                long newSize = jnieasyCalcSize(newValue);                
                if (newSize > size)
                    throw new JNIEasyException("New data is greater than current native memory size");                
            }
        }
        
        jnieasySetInternalValue(newValue);
    }
           
    public long jnieasyGetSize()
    {
        // Se llama antes de ser nativo el objeto
        Object value = jnieasyGetInternalValue();

        jnieasyCheckNewValue(value);  // Pues pudo ser introducido antes de tener state manager y no haber sido chequeado
        
        long size = TypeSizes.getUNKNOWN_SIZE(); // No definido, válido en caso de Proxy para tipos de tamaño desconocido
        if (jnieasyIsFixedSize())
        {
            TypeCanBeNativeCapableWrapperRuntimeImpl typeDecImpl = jnieasyGetTypeCanBeNativeCapableWrapperRuntime();
            TypeCanBeNativeCapableRuntimeImpl wrappedTypeDec = typeDecImpl.getTypeCanBeNativeCapableRuntime();           
            size = wrappedTypeDec.size();        
        }
        else if (value != null)
        {
            size = jnieasyCalcSize(value);
        }
        
        return size; // Puede ser UNKNOWN_SIZE y es válido, caso de proxy
    }
    
    public abstract long jnieasyCalcSize(Object newValue);
   
}
