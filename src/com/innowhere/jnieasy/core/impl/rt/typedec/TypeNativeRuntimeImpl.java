/*
 * TypeNativeRuntimeImpl.java
 *
 * Created on 10 de diciembre de 2004, 11:53
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextNotUsingImports;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextUsingImports;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;



public abstract class TypeNativeRuntimeImpl implements TypeNativeRuntime
{
    protected RuntimeManagerImpl rtMgr;
    protected TypeNativeImpl typeDec;
    protected Class javaClass;
    protected long size = TypeSizes.getUNKNOWN_SIZE();
    protected long preferredAlignSize = TypeSizes.getUNKNOWN_SIZE();
    
    /**
     * Creates a new instance of TypeNativeRuntimeImpl
     */
    public TypeNativeRuntimeImpl(TypeNativeImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        this.typeDec = typeDec;
        this.rtMgr = rtMgr;
        this.javaClass = javaClass;
    }

    public static Class getClassImpl(TypeNativeImpl typeDec)
    {
        ClassTypeNativeImpl classType = typeDec.getClassType();        
        return classType.getClassTypeRuntime().getClassImpl();        
    }
    
    public static Class getClass(TypeNativeImpl typeDec,RuntimeManagerImpl rtMgr)
    {
        ClassTypeNativeImpl classType = typeDec.getClassType();        
        return rtMgr.getTypeManagerRuntime().getClass(classType.getClassName());
    }
    
    public ClassTypeNativeRuntimeImpl getClassTypeRuntime()
    {
        return typeDec.getClassType().getClassTypeRuntime();
    }

    public Class getDeclaredClass()
    {       
        return javaClass;
    }
    
    public ClassLoader getClassLoader()
    {
        return javaClass.getClassLoader();
    }
    
    public TypeNativeImpl getTypeNative()
    {
        return typeDec;
    }
    
    public String getDeclarationString()
    {    
        return typeDec.getDeclarationString();
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {
        return rtMgr;
    }

    public RuntimeContextNotUsingImports getDefaultRuntimeContext()
    {
        return rtMgr.getDefaultRuntimeContextNotUsingImports();
    }
    
    public NativeManagerImpl getNativeManager()
    {
        return (NativeManagerImpl)rtMgr.getNativeManager();    
    }
        
    public NativeTypeManagerRuntimeImpl getTypeManagerRuntime()
    {
        return (NativeTypeManagerRuntimeImpl)rtMgr.getTypeManagerRuntime();
    }
            
    public boolean equals(Object obj)
    {    
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        TypeNativeRuntimeImpl obj2 = (TypeNativeRuntimeImpl)obj;
        
        if (getDeclaredClass() != obj2.getDeclaredClass())
            return false;
        if (!getTypeNative().equals(obj2.getTypeNative()))
            return false;
        return true;
    }        

    public static TypeNativeRuntimeImpl newTypeNativeRuntime(Object value,boolean primitiveByValue,RuntimeContext ctx)
    {    
        TypeNativeRuntimeImpl typeDec = TypeNativeObjectRuntimeImpl.newTypeNativeObjectRuntime(value,ctx);
        if (primitiveByValue && (typeDec instanceof TypeNativePrimitiveObjectRuntimeImpl))
        {
            // Si por ejemplo value es un objeto Character se devolverá un el tipo TypeNativeCharacterRuntimeImpl que representa a char
            typeDec = ((TypeNativePrimitiveObjectRuntimeImpl)typeDec).getTypeNativePrimitiveRuntime();
        }
        return typeDec;
    }
    
    public static TypeNativeRuntimeImpl newTypeNativeRuntime(String declaredClass,RuntimeContextUsingImports ctx)    
    {    
        TypeNativeImpl typeDec = TypeNativeParserImpl.newTypeNative(declaredClass, ctx);
        Class clasz = TypeNativeRuntimeImpl.getClassImpl(typeDec);
        return newTypeNativeRuntime(clasz,typeDec,ctx);
    }   
    
    public static TypeNativeRuntimeImpl newTypeNativeRuntime(Class declaredClass,RuntimeContext ctx)    
    {    
        return newTypeNativeRuntime(declaredClass,ctx.getClassTypeRuntime(declaredClass),ctx);
    }
    
    public static TypeNativeRuntimeImpl newTypeNativeRuntime(Class clasz,ClassTypeNativeImpl classType,RuntimeContext ctx)    
    {    
        TypeNativeImpl typeDec = TypeNativeImpl.newTypeNative(classType);
        return newTypeNativeRuntime(clasz,typeDec,ctx);
    }
    
    public static TypeNativeRuntimeImpl newTypeNativeRuntime(Class clasz,ClassTypeNativeRuntimeImpl classTypeRt,RuntimeContext ctx)    
    {    
        TypeNativeImpl typeDec = TypeNativeImpl.newTypeNative(classTypeRt.getClassType());
        return newTypeNativeRuntime(clasz,typeDec,ctx);
    }    
    
    public static TypeNativeRuntimeImpl newTypeNativeRuntime(Class clasz,TypeNativeImpl typeDec,RuntimeContext ctx)
    {
        return typeDec.newTypeNativeRuntime(clasz,ctx);
    }    

    public static TypeNativeRuntimeImpl newTypeNativeRuntime(TypeNativeImpl typeDec,RuntimeContext ctx)
    {
        Class clasz = TypeNativeRuntimeImpl.getClassImpl(typeDec);            
        return newTypeNativeRuntime(clasz,typeDec,ctx);
    }    
    
    public VarTypeNative decVarType(int varConv)
    {
        VarTypeNativeRuntimeImpl varTypeDec = VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(this,getDefaultRuntimeContext());
        varTypeDec.setVarConv(varConv);
        return varTypeDec;
    }
    
    public VarTypeNative decVarType()
    {
        return VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(this,getDefaultRuntimeContext());
    }
    
    public void checkValue(Object value)
    {
        if (value != null)
            checkValueNotNull(value);
        else
            checkValueNull();        
    }     
    
    public void checkValueNotNull(Object value)
    { 
        // value no debe ser null obviamente
        Class valClass = value.getClass();
        // Esperamos que sea la clase implementación
//        String classNameDec = getTypeNative().getClassName();
//        Class declaredClass = ClassTypeNativeRuntimeImpl.getClassImpl(classNameDec, ClassTypeNativeRuntimeImpl.getClassLoader(valClass), false);
//        if (declaredClass == null) throw new JNIEasyException("Cannot load declared class " + classNameDec + " with ClassLoader of value");
      
        Class declaredClass = getDeclaredClass();
     
        if (!declaredClass.isAssignableFrom(valClass)) 
        {
            throw new JNIEasyException("Value with class: " + valClass.getName() + " and ClassLoader: " + valClass.getClassLoader() + ", must be equal or implement or inherit from class: " + declaredClass.getName() + ", and ClassLoader: " + declaredClass.getClassLoader());
        }
    }
      
    public void checkValueNull()
    {    
    }

    public void check()
    {        
        Class expectedClass = getClass(typeDec,rtMgr);
        if (!expectedClass.isAssignableFrom(javaClass))
            throw new JNIEasyException("Wrong class: " + javaClass.getName() + ", expected : " + expectedClass.getName() + " or derivative");
        typeDec.check();
    }
    
    public int returnTypeCode()
    {
        return getClassTypeRuntime().returnTypeCode();
    }
   
    public long size()
    {
        if (size == TypeSizes.getUNKNOWN_SIZE())
            this.size = calcSize(); // Cacheamos el valor obtenido para acelerar
        return this.size;
    }
    
    public long stackSizeByValue()
    {
        return roundToStackSizeByValue( size() );
    }    
    
    public static long roundToStackSizeByValue(long size)
    {
        // Al pasar por valor se ha de pasar un tamaño 
        // múltiplo entero del tamaño de registro del procesador
        // por tanto calculamos el entero más próximo por arriba
        // que cumpla esto.
        long mod = (size % TypeSizes.getADDRESS());
        if (mod != 0)
            size += TypeSizes.getADDRESS() - mod;    
        return size;
    }    
    
    public long preferredAlignSize()
    {
        if (preferredAlignSize == TypeSizes.getUNKNOWN_SIZE())
            this.preferredAlignSize = calcPreferredAlignSize();  // Cacheamos el valor obtenido para acelerar
        return this.preferredAlignSize;        
    }   
           
    public static TypeNativeRuntimeImpl getDefaultAssociatedType(Object value,boolean primitiveByValue,RuntimeContext ctx)
    {
        TypeNativeRuntimeImpl typeDec = (TypeNativeRuntimeImpl)newTypeNativeRuntime(value,primitiveByValue,ctx);
        if (ctx.getRuntimeManager().getNativeManager().isRuntimeChecking())
            typeDec.check();
        return typeDec;
    }    
    
    public abstract boolean isValidAsReturnOfCallback();
    public abstract long calcSize();
    public abstract long calcPreferredAlignSize();
}
