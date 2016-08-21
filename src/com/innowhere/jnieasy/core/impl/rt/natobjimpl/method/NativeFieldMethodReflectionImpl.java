/*
 * NativeFieldMethodReflectionImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:48
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeFieldMethodReflection;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;
import java.lang.reflect.*;
import javassist.CtClass;



/**
 *
 * @author  jmarranz
 */

public abstract class NativeFieldMethodReflectionImpl extends NativeBehaviorReflectionImpl implements NativeFieldMethodReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Field value;
    
    /**
     * Creates a new instance of NativeFieldMethodReflectionImpl
     */
    public NativeFieldMethodReflectionImpl()
    {
    }
    
    public NativeFieldMethodSignature getFieldMethodSignature()
    {
        return (NativeFieldMethodSignature)getBehaviorSignature();
    }    

    public void jnieasySetValue(Object newValue, int unFetchMode, Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        // No hay que hacer nada por el lado nativo salvo el cast       
        super.jnieasySetValue((Field)newValue,stateMgr);
    }
    
    public Object jnieasyGetValue(int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        if (this.value == null)
            throw new JNIEasyException("Reflection object is not defined and only can be generated with static methods");
        return value;
    }
    
    public Field getField()
    {
        return (Field)getValue();
    }    
    
    public void setField(Field newValue)
    {
        setValue(newValue);
    }
    
    public Object jnieasyOnCall(Object obj,int opcode,Object value)
    {
        /* Permite acceder a fields de objetos estáticos o no desde la parte nativa
         * En el caso de no estáticos es necesario que el objeto sea nativo (enhanced)
         * pero por esta vía podemos modificar el atributo Java directamente 
         * sin modificar la memoria nativa asociada al atributo y sin esperar a que
         * se haga un get normal del atributo que sincronice la memoria con el atributo Java
         */
        
        try
        {
            Field field = getField();            
          
            switch(opcode)
            {
                case GET : 
                    return field.get(obj);
                case SET : 
                    field.set(obj,value); 
                    return value;
                case GET_SET : 
                    Object oldValue = field.get(obj);
                    field.set(obj,value); 
                    return oldValue; 
                default: throw new JNIEasyException("Invalid field access code");
            }
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
    
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Field)newValue;            
    }
    
    public Object jnieasyGetDefaultReturnValue()
    {
        NativeBehaviorSignatureRuntimeImpl sig = (NativeBehaviorSignatureRuntimeImpl)getBehaviorSignature();
        return sig.getDefaultReturnValue();
    }    
    
    public Member getReflectionValueProxy(Class proxyUtilClass, Class[] params)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public String formReflectionProxyUniqueClassName(String templateName, String addressPositiveStr, Class[] params)
    {
        throw new JNIEasyException("INTERNAL ERROR");        
    }

    public void addNewMethodReflectionProxy(EnhancerSharedContext esctx, CtClass proxyUtilCtClass, CtClass ctClassRet, CtClass[] ctClassParams, String body)
    {
        throw new JNIEasyException("INTERNAL ERROR");           
    }

    public Class getReflectionProxyTemplateClass()
    {
        throw new JNIEasyException("INTERNAL ERROR");           
    }    
}
