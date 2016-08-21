/*
 * TypeCanBeNativeCapableRuntimeImpl.java
 *
 * Created on 6 de enero de 2005, 15:58
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeCanBeNativeCapableRuntime;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeMemberReflectionRuntimeImpl;
import java.lang.reflect.Member;

public abstract class TypeCanBeNativeCapableRuntimeImpl extends TypeNativeObjectRuntimeImpl implements TypeCanBeNativeCapableRuntime
{
    protected TypeCanBeNativeCapableWrapperRuntimeImpl wrapperType;
    
    /**
     * Creates a new instance of TypeCanBeNativeCapableRuntimeImpl
     */
    public TypeCanBeNativeCapableRuntimeImpl(TypeCanBeNativeCapableImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,ctx.getRuntimeManager());
        
        if (isPrimary)
        {
            this.wrapperType = typeDec.getTypeCanBeNativeCapableWrapper().newTypeCanBeNativeCapableWrapperRuntime(getWrapperClass(), false, ctx);
            this.wrapperType.setTypeCanBeNativeCapableRuntime(this);
        }
    }
    
    public static TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Object value,RuntimeContext ctx)    
    {
        Class cls = value.getClass();
        if (cls.isArray())
            return TypeNativeArrayRuntimeImpl.newTypeNativeArrayRuntime(value,ctx);        
        else if (value instanceof Member)
            return TypeNativeMemberReflectionRuntimeImpl.newTypeNativeMemberReflectionRuntime((Member)value,ctx);
        else // Quedan String, StringBuffer y Primitive objects, pero en todos ellos la instancia no aporta nada, con la clase es suficiente
            return (TypeCanBeNativeCapableRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(cls,ctx);
    }
    
    public abstract boolean isObjectKnownSize();  // el tamaño del objeto en memoria (no influye el varConv)
    
    public TypeCanBeNativeCapableImpl getTypeCanBeNativeCapable()
    {
        return (TypeCanBeNativeCapableImpl)typeDec;
    }    

    public CanBeNativeCapable wrapValue(Object value)
    {
        return getTypeCanBeNativeCapableWrapperRuntime().wrapValue(value);        
    }   

    public TypeCanBeNativeCapableWrapperRuntimeImpl getTypeCanBeNativeCapableWrapperRuntime()
    {
        return wrapperType;
    }

    public void setTypeCanBeNativeCapableWrapperRuntime(TypeCanBeNativeCapableWrapperRuntimeImpl wrapperTypeDec)
    {
        this.wrapperType = wrapperTypeDec;
        getTypeCanBeNativeCapable().setTypeCanBeNativeCapableWrapper(wrapperTypeDec.getTypeCanBeNativeCapableWrapper());        
    }
   
    public Object getObject(NativeAddressImpl addr, long offset)
    {
        CanBeNativeCapable wrapValue = (CanBeNativeCapable)getTypeCanBeNativeCapableWrapperRuntime().getObject(addr,offset);
        if (wrapValue == null) return null;
        return wrapValue.getValue();
    }

    public Object newValue()
    {
        // El ClassLoader no lo usamos, porque o bien son clases
        // básicas de Java que han de ser cargadas por el loader del sistema
        // (por delegación acabará ahí) o son arrays Java que por sí mismos 
        // no pueden cargar a objetos hijo.
        return newValueInternal();
    }
    
    public Class getWrapperClass()
    {
        TypeCanBeNativeCapableImpl typeDec = getTypeCanBeNativeCapable();
        TypeCanBeNativeCapableWrapperImpl typeDecWrapper = typeDec.getTypeCanBeNativeCapableWrapper();        
        return TypeNativeRuntimeImpl.getClassImpl(typeDecWrapper);
    }    
    
    public boolean isValidAsReturnOfCallback()
    {
        // No puede ser el retorno un String etc (un can be native object) pues tendríamos que
        // convertirlo a un NativeCapable y hacerlo nativo, pero sin embargo
        // devolvemos la dirección por lo que el objeto nativo será procesado
        // por el garbagge collector en cualquier momento creando fallos
        // impredecibles. No vale hacer un lock porque no se conoce la instancia 
        // usada de forma auxiliar y además ¿quien hace el unlock? ¿en la DLL?.        
        return false;
    }    
    
    public abstract Object newValueInternal();  

    public void check()
    {
        super.check();
        checkShared();
    }         
    
    public void checkShared()
    {
        
    }
}
