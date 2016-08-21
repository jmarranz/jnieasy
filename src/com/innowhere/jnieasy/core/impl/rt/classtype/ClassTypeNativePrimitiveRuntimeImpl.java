/*
 * ClassTypeNativePrimitiveRuntimeImpl.java
 *
 * Created on 16 de febrero de 2005, 15:01
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveWrapperRuntimeImpl;
import java.util.*;

public abstract class ClassTypeNativePrimitiveRuntimeImpl extends ClassTypeNativeRuntimeImpl
{
    protected static final Map primitiveTypesByName = Collections.synchronizedMap(new HashMap());    

    static
    {
        primitiveTypesByName.put("void",void.class);
        primitiveTypesByName.put("boolean",boolean.class);
        primitiveTypesByName.put("byte",byte.class);
        primitiveTypesByName.put("char",char.class);        
        primitiveTypesByName.put("short",short.class);
        primitiveTypesByName.put("int",int.class);
        primitiveTypesByName.put("long",long.class);        
        primitiveTypesByName.put("float",float.class);
        primitiveTypesByName.put("double",double.class);
    }
    
    protected long size = defaultJavaPrimSize();
    protected long prefAlignSize = defaultJavaPrimAlignSize();    
    
    /**
     * Creates a new instance of ClassTypeNativePrimitiveRuntimeImpl
     */
    public ClassTypeNativePrimitiveRuntimeImpl(ClassTypeNativePrimitiveImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }    
    
    public static Class getClass(String className)
    {
        return (Class)primitiveTypesByName.get(className);
    }    

    public ClassTypeNativePrimitiveImpl getClassTypeNativePrimitive()
    {
        return (ClassTypeNativePrimitiveImpl)classType;
    }
        
    public long getObjectSize()
    {
        return size;
    }       
        
    public void setObjectSize(long size)
    {
        // Usar con extremo cuidado, supone cambiar el tamaño del primitivo globalmente
        checkSize(size);
        this.size = size;
    }   
    
    public long getPreferredAlignSize()
    {
        return prefAlignSize;
    }   
   
    public void setPreferredAlignSize(long prefAlignSize)
    {
        // Usar con extremo cuidado, supone cambiar el tamaño del primitivo globalmente      
        checkAlignSize(prefAlignSize);        
        this.prefAlignSize = prefAlignSize;
    }   
    
    public void checkSize(long size)
    {
        if (size <= 0)
            throw new JNIEasyException("Zero or negative size is not valid");
            
        if (!checkPositiveSize(size))
            throw new JNIEasyException("Primitive " + classType.getClassName() + " memory size is not supported: " + size);      
    }    
    
    public void checkAlignSize(long size)
    {
        if (size <= 0)
            throw new JNIEasyException("Zero or negative align size is not valid");
            
        if (!checkPositiveAlignSize(size))
            throw new JNIEasyException("Primitive " + classType.getClassName() + " align size is not supported: " + size);      
    }        
    
    public ClassTypeNativePrimitiveWrapperRuntimeImpl getClassTypeNativePrimitiveWrapperRuntime()
    {
        ClassTypeNativePrimitiveWrapperImpl classTypeWrapper = getClassTypeNativePrimitive().getClassTypeNativePrimitiveWrapper();
        return (ClassTypeNativePrimitiveWrapperRuntimeImpl)classTypeWrapper.getClassTypeRuntime();
    }
    
    public ClassTypeNativePrimitiveObjectRuntimeImpl getClassTypeNativePrimitiveObjectRuntime()
    {
        ClassTypeNativePrimitiveObjectImpl classTypeWrapper = getClassTypeNativePrimitive().getClassTypeNativePrimitiveObject();
        return (ClassTypeNativePrimitiveObjectRuntimeImpl)classTypeWrapper.getClassTypeRuntime();
    }    
    
    public abstract long defaultJavaPrimSize();
    public abstract long defaultJavaPrimAlignSize();
    public abstract int returnTypeCode();
    public abstract boolean checkPositiveSize(long size);
    public abstract boolean checkPositiveAlignSize(long size);    
}
