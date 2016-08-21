/*
 * NativeDirectStaticFieldCallbackToCFieldMethodImpl.java
 *
 * Created on 8 de marzo de 2006, 21:01
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.CFieldMethod;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorSignature;
import com.innowhere.jnieasy.core.typedec.TypeNative;

/**
 *
 * @author jmarranz
 */
public class NativeDirectStaticFieldCallbackToCFieldMethodImpl extends NativeDirectStaticFieldCallbackImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    // Este objeto sólo es usado dentro de un StateManager
    // no preocuparse por la serizalización y nombres de los fields
    // pero por si acaso.
    protected transient CFieldMethod jnieasyCFieldMethod;
    
    /**
     * Creates a new instance of NativeDirectStaticFieldCallbackToCFieldMethodImpl
     */
    public NativeDirectStaticFieldCallbackToCFieldMethodImpl(CFieldMethod cFieldMethod)
    {
        this.jnieasyCFieldMethod = cFieldMethod;
    }

    public Object jnieasyOnCall(int opcode, Object value)
    {       
        NativeStaticFieldMethodSignatureRuntimeImpl sig = (NativeStaticFieldMethodSignatureRuntimeImpl)getBehaviorSignature();
        int retTypeCode = sig.getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime().returnTypeCode();   
        switch(retTypeCode)
        {
            case ClassTypeNativeRuntimeImpl.BOOLEAN_RETURN : return Boolean.valueOf(jnieasyCFieldMethod.callBoolean(opcode,((Boolean)value).booleanValue()));
            case ClassTypeNativeRuntimeImpl.CHAR_RETURN :   return new Character(jnieasyCFieldMethod.callChar(opcode,((Character)value).charValue()));            
            case ClassTypeNativeRuntimeImpl.SHORT_RETURN :  return new Short(jnieasyCFieldMethod.callShort(opcode,((Short)value).shortValue()));            
            case ClassTypeNativeRuntimeImpl.INT_RETURN :    return new Integer(jnieasyCFieldMethod.callInt(opcode,((Integer)value).intValue()));            
            case ClassTypeNativeRuntimeImpl.LONG_RETURN :   return new Long(jnieasyCFieldMethod.callLong(opcode,((Long)value).longValue())); 
            case ClassTypeNativeRuntimeImpl.FLOAT_RETURN :  return new Float(jnieasyCFieldMethod.callFloat(opcode,((Float)value).floatValue()));
            case ClassTypeNativeRuntimeImpl.DOUBLE_RETURN : return new Double(jnieasyCFieldMethod.callDouble(opcode,((Double)value).doubleValue()));
            case ClassTypeNativeRuntimeImpl.POINTER_RETURN :  return jnieasyCFieldMethod.callObject(opcode,value);
        }
        
        return null;
    }

    public Object[] jnieasyNewArrayInstance(int len)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public Object jnieasyNewInstance()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public TypeNative jnieasyGetDefaultType()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }

    public NativeBehaviorSignature getBehaviorSignature()
    {
        return jnieasyCFieldMethod.getBehaviorSignature();
    }
}
