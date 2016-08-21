/*
 * NativeCapableFactoryImpl.java
 *
 * Created on 23 de mayo de 2005, 17:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.util;

import com.innowhere.jnieasy.core.data.CanBeNativeCapable;
import com.innowhere.jnieasy.core.data.NativeBoolean;
import com.innowhere.jnieasy.core.data.NativeByte;
import com.innowhere.jnieasy.core.data.NativeCharacter;
import com.innowhere.jnieasy.core.data.NativeDouble;
import com.innowhere.jnieasy.core.data.NativeFloat;
import com.innowhere.jnieasy.core.data.NativeInteger;
import com.innowhere.jnieasy.core.data.NativeLong;
import com.innowhere.jnieasy.core.data.NativeString;
import com.innowhere.jnieasy.core.data.NativeStringBuffer;
import com.innowhere.jnieasy.core.data.NativePointer;
import com.innowhere.jnieasy.core.data.NativeShort;
import com.innowhere.jnieasy.core.data.NativeStringAnsi;
import com.innowhere.jnieasy.core.data.NativeStringBufferAnsi;
import com.innowhere.jnieasy.core.data.NativeStringBufferUnicode;
import com.innowhere.jnieasy.core.data.NativeStringUnicode;
import com.innowhere.jnieasy.core.util.NativeCapableFactory;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeBooleanWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeByteWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCharacterWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeDoubleWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeFloatWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeIntegerWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeLongWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeShortWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeCanBeNativeCapable;
import com.innowhere.jnieasy.core.typedec.NativeTypeManager;
import com.innowhere.jnieasy.core.typedec.TypeNativePointer;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

/**
 *
 * @author jmarranz
 */
public class NativeCapableFactoryImpl implements NativeCapableFactory
{
    protected NativeTypeManagerRuntimeImpl typeDecMgr;

    // Como una vez creado el objeto el tipo no cambia los podemos usar como singleton para acelerar
    protected ClassTypeNativeBooleanWrapperImpl classTypeNativeBooleanSingleton;    
    protected ClassTypeNativeByteWrapperImpl classTypeNativeByteSingleton;    
    protected ClassTypeNativeCharacterWrapperImpl classTypeNativeCharacterSingleton;    
    protected ClassTypeNativeShortWrapperImpl classTypeNativeShortSingleton;    
    protected ClassTypeNativeIntegerWrapperImpl classTypeNativeIntegerSingleton;    
    protected ClassTypeNativeLongWrapperImpl classTypeNativeLongSingleton;    
    protected ClassTypeNativeFloatWrapperImpl classTypeNativeFloatSingleton;    
    protected ClassTypeNativeDoubleWrapperImpl classTypeNativeDoubleSingleton;    
    
    /**
     * Creates a new instance of NativeCapableFactoryImpl
     */
    public NativeCapableFactoryImpl(NativeTypeManagerRuntimeImpl typeDecMgr)
    {
        this.typeDecMgr = typeDecMgr;
    }    
    
    public NativeTypeManager getTypeManager()
    {
        return typeDecMgr;
    }

    public CanBeNativeCapable wrapValue(Object value)
    {
        if (value == null) return null;        
        TypeCanBeNativeCapable typeDec = (TypeCanBeNativeCapable)getTypeManager().getDefaultType(value);
        return (CanBeNativeCapable)typeDec.wrapValue(value);        
    }        
    
    public NativePointer newPointer(Object addressed)
    {
        NativeTypeManager typeDecMgr = getTypeManager();
        VarTypeNative varTypeDec = typeDecMgr.getDefaultType(addressed).decVarType();
        TypeNativePointer typeDecPtr = varTypeDec.decPointer();
        NativePointer ptrToPtr = (NativePointer)typeDecPtr.newValue();
        ptrToPtr.setValue(addressed);
        return ptrToPtr;
    }
    
    public NativeString newString(String value)
    {
        if (value == null) return null;
        return getTypeManager().decString().newString(value);
    }

    public NativeStringAnsi newStringAnsi(String value)
    {
        if (value == null) return null;        
        return getTypeManager().decStringAnsi().newStringAnsi(value);
    }

    public NativeStringUnicode newStringUnicode(String value)
    {
        if (value == null) return null;        
        return getTypeManager().decStringUnicode().newStringUnicode(value);
    }
    
    public NativeStringBuffer newStringBuffer(StringBuffer value)
    {
        if (value == null) return null;        
        return getTypeManager().decStringBuffer().newStringBuffer(value);
    }

    public NativeStringBufferAnsi newStringBufferAnsi(StringBuffer value)
    {
        if (value == null) return null;        
        return getTypeManager().decStringBufferAnsi().newStringBufferAnsi(value);
    }

    public NativeStringBufferUnicode newStringBufferUnicode(StringBuffer value)
    {
        if (value == null) return null;        
        return getTypeManager().decStringBufferUnicode().newStringBufferUnicode(value);
    }    
    
    public NativeBoolean newNativeBoolean(boolean value)
    {
        Class clasz = NativeBoolean.class;
        if (classTypeNativeBooleanSingleton == null)
            this.classTypeNativeBooleanSingleton = (ClassTypeNativeBooleanWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeBooleanSingleton);
        NativeBoolean valueWrap = (NativeBoolean)typeDec.newValue();
        valueWrap.setBooleanValue(value);
        return valueWrap;
    }

    public NativeByte newNativeByte(byte value)
    {
        Class clasz = NativeByte.class;
        if (classTypeNativeByteSingleton == null)
            this.classTypeNativeByteSingleton = (ClassTypeNativeByteWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeByteSingleton);
        NativeByte valueWrap = (NativeByte)typeDec.newValue();
        valueWrap.setByteValue(value);
        return valueWrap;
    }    
    
    public NativeCharacter newNativeCharacter(char value)
    {
        Class clasz = NativeCharacter.class;
        if (classTypeNativeCharacterSingleton == null)
            this.classTypeNativeCharacterSingleton = (ClassTypeNativeCharacterWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeCharacterSingleton);
        NativeCharacter valueWrap = (NativeCharacter)typeDec.newValue();
        valueWrap.setCharValue(value);
        return valueWrap;
    }
    
    public NativeDouble newNativeDouble(double value)
    {
        Class clasz = NativeDouble.class;
        if (classTypeNativeDoubleSingleton == null)
            this.classTypeNativeDoubleSingleton = (ClassTypeNativeDoubleWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeDoubleSingleton);
        NativeDouble valueWrap = (NativeDouble)typeDec.newValue();
        valueWrap.setDoubleValue(value);
        return valueWrap;
    }    
    
    public NativeFloat newNativeFloat(float value)
    {
        Class clasz = NativeFloat.class;
        if (classTypeNativeFloatSingleton == null)
            this.classTypeNativeFloatSingleton = (ClassTypeNativeFloatWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeFloatSingleton);
        NativeFloat valueWrap = (NativeFloat)typeDec.newValue();
        valueWrap.setFloatValue(value);
        return valueWrap;
    }   
    
    public NativeInteger newNativeInteger(int value)
    {
        Class clasz = NativeInteger.class;
        if (classTypeNativeIntegerSingleton == null)
            this.classTypeNativeIntegerSingleton = (ClassTypeNativeIntegerWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeIntegerSingleton);
        NativeInteger valueWrap = (NativeInteger)typeDec.newValue();
        valueWrap.setIntValue(value);
        return valueWrap;
    }  
    
    public NativeLong newNativeLong(long value)
    {
        Class clasz = NativeLong.class;
        if (classTypeNativeLongSingleton == null)
            this.classTypeNativeLongSingleton = (ClassTypeNativeLongWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeLongSingleton);
        NativeLong valueWrap = (NativeLong)typeDec.newValue();
        valueWrap.setLongValue(value);
        return valueWrap;
    }    
    
    public NativeShort newNativeShort(short value)
    {
        Class clasz = NativeShort.class;
        if (classTypeNativeShortSingleton == null)
            this.classTypeNativeShortSingleton = (ClassTypeNativeShortWrapperImpl)typeDecMgr.getClassType(clasz);
        TypeNativePrimitiveWrapperRuntimeImpl typeDec = (TypeNativePrimitiveWrapperRuntimeImpl)typeDecMgr.dec(clasz,classTypeNativeShortSingleton);
        NativeShort valueWrap = (NativeShort)typeDec.newValue();
        valueWrap.setShortValue(value);
        return valueWrap;
    }        
}
