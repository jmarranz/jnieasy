/*
 * TypeNativePrimitiveRuntimeImpl.java
 *
 * Created on 2 de febrero de 2005, 11:38
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferImpl;
import com.innowhere.jnieasy.core.impl.mem.NativeBufferIteratorImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativePrimitiveObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveObjectWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.TypeNativeObject;
import com.innowhere.jnieasy.core.typedec.TypeNativePrimitive;

public abstract class TypeNativePrimitiveRuntimeImpl extends TypeNativeRuntimeImpl implements TypeNativePrimitive
{
    /**
     * Creates a new instance of TypeNativePrimitiveRuntimeImpl
     */
    public TypeNativePrimitiveRuntimeImpl(TypeNativePrimitiveImpl typeDec,Class javaClass,RuntimeManagerImpl rtMgr)
    {
        super(typeDec,javaClass,rtMgr);
    }
    
    public TypeNativePrimitiveImpl getTypeNativePrimitive()
    {
	return (TypeNativePrimitiveImpl)typeDec;
    }           
        
    public ClassTypeNativePrimitiveRuntimeImpl getClassTypePrimitiveRuntime()    
    {
        return (ClassTypeNativePrimitiveRuntimeImpl)getClassTypeRuntime();
    }
    
    public void check()
    {        
        size(); // parsea y asegura que el valor sea correcto
        preferredAlignSize(); // idem
        
        super.check();
    }    
    
    public void checkSize(long size)
    {
        // El 0 siempre se admite 
        // El 0 es una forma alternativa de conseguir que un field sea no nativo o para forzar una especie de "union"
        // o en los casos en donde para un sistema operativo es una cosa  y para otro otra pudiéndose usar dos fields
        // activando uno u otro (y el otro con memoria y alineamiento 0)
        if (size == 0)
            return;
       
        getClassTypePrimitiveRuntime().checkSize(size);
    }
    
    public void checkAlignSize(long size)
    {
        // Rollo idem checkSize(long)
        if (size == 0)
            return;
       
        getClassTypePrimitiveRuntime().checkAlignSize(size);
    }
        
    public void setSizeAndPreferredAlignSize(long size,long preferredAlignSize)
    {
        // Lo hacemos de la forma más lenta pero menos ambigua,
        // cuando se necesiten los tamaños se parsearán.
        // Este método se usará poco pues no se usa en el enhancer ni en la generación de código
        // Así aseguramos que métodos como TypeNative.getDeclarationString() den un resultado con sentido
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();
        typeDec.setMemSizeExpr(Long.toString(size));
        typeDec.setPreferredAlignSizeExpr(Long.toString(preferredAlignSize));         
    }
    
    public void setSizeAndPreferredAlignSize(String memSizeExpr,String prefAlignSizeExpr)
    {
        // Cuando se necesiten los tamaños se parsearán
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();
        typeDec.setMemSizeExpr(memSizeExpr);
        typeDec.setPreferredAlignSizeExpr(prefAlignSizeExpr);                
    }     
    
    public long calcSize()
    {      
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();
        String memSizeExpr = typeDec.getMemSizeExpr();
        if (memSizeExpr != null)
        {
            long size = rtMgr.getTypeManagerRuntime().parseMemorySizeWithMacros(memSizeExpr);
            if (size == TypeSizes.getUNKNOWN_SIZE())
                return defaultSize();            
            checkSize(size);            
            return size;
        }
        else
            return defaultSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        TypeNativePrimitiveImpl typeDec = getTypeNativePrimitive();
        String prefAlignSizeExpr = typeDec.getPreferredAlignSizeExpr();
        if (prefAlignSizeExpr != null)
        {
            long prefAlignSize = rtMgr.getTypeManagerRuntime().parseMemorySizeWithMacros(prefAlignSizeExpr);
            if (prefAlignSize == TypeSizes.getUNKNOWN_SIZE())
                return defaultPreferredAlignSize();             
            checkAlignSize(prefAlignSize);            
            return prefAlignSize;            
        }
        else
        {
            long size = size();
            long defaultSize = defaultSize();
            if (size != defaultSize) 
            {
                /* El usuario ha puesto un valor diferente del valor por defecto (el del tipo Java)
                 * y no ha especificado un valor para el alineamiento, lo normal
                 * es que el alineamiento coincida con el tamaño en primitivos
                 */
                return size;
            }
            else
            {
                // No ha cambiado el tamaño del tipo de datos respecto a Java y no ha especificado
                // alineamiento, por tanto ponemos el alineamiento natural de Java.
                return defaultPreferredAlignSize();
            }                
        }
    }
    
    public long defaultSize()
    {
        return getClassTypeRuntime().getObjectSize(); // El valor natural Java        
    }
    
    public long defaultPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();  // El valor natural Java        
    }
            
    public void checkValueNotNull(Object value)
    {    
        // Redefinimos porque esperamos un tipo wrapper pues no hay objetos de primitivos
        String wrapperClassName = getTypeNativePrimitive().getClassTypeNativePrimitive().getWrapperClassName();
        if (!wrapperClassName.equals(value.getClass().getName()))
            throw new JNIEasyException("Expected value with class: " + wrapperClassName + " not " + value.getClass().getName());
    }       

    public TypeNativePrimitiveWrapperRuntimeImpl newRelatedTypeNativePrimitiveWrapperRuntime()
    {
        TypeNativePrimitiveWrapperImpl typeDec = getTypeNativePrimitive().newRelatedTypeNativePrimitiveWrapper();
        RuntimeContext ctx = rtMgr.getDefaultRuntimeContextNotUsingImports();
        return (TypeNativePrimitiveWrapperRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(typeDec, ctx);
    }        
    
    public boolean isValidAsReturnOfCallback()
    {
        return true;
    }
    
    public void checkTypeNativeCompatible(TypeNativePrimitiveRuntimeImpl typeValue)
    {        
        long size = typeValue.size();
        if (size != size())
            throw new JNIEasyException("Unexpected memory size: " + size + ", must be: " + size());
    }
    
    public TypeNativePrimitiveWrapperRuntimeImpl newTypeNativePrimitiveWrapperRuntime(Class javaClass,RuntimeContext ctx)
    {
        return TypeNativePrimitiveWrapperRuntimeImpl.newTypeNativePrimitiveWrapperRuntime(javaClass,this,ctx);
    }    
    
    public TypeNativePrimitiveObjectRuntimeImpl newTypeNativePrimitiveObjectRuntime(Class javaClass,RuntimeContext ctx)
    {
        return newTypeNativePrimitiveObjectRuntime(javaClass,true,ctx);
    }         
    
    public TypeNativePrimitiveObjectRuntimeImpl newTypeNativePrimitiveObjectRuntime(Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        return TypeNativePrimitiveObjectRuntimeImpl.newTypeNativePrimitiveObjectRuntime(javaClass,isPrimary,this,ctx);
    }     
    
    public TypeNativePrimitiveObjectWrapperRuntimeImpl newTypeNativePrimitiveObjectWrapperRuntime(Class javaClass,RuntimeContext ctx)
    {
        Class javaClassComp = ((ClassTypeNativePrimitiveRuntimeImpl)getClassTypeRuntime()).getClassTypeNativePrimitiveObjectRuntime().getClassImpl();
        TypeNativePrimitiveObjectRuntimeImpl typeComp = newTypeNativePrimitiveObjectRuntime(javaClassComp,false,ctx);
        return TypeNativePrimitiveObjectWrapperRuntimeImpl.newTypeNativePrimitiveObjectWrapperRuntime(javaClass,typeComp,ctx);
    }    
    
    public TypeNativeObject decObjectWrapper(Class clasz)
    {
        RuntimeContext ctx = getRuntimeManager().getTypeManagerRuntime().getDefaultRuntimeContextNotUsingImports();        
        ClassTypeNativeRuntimeImpl classType = ctx.getClassTypeRuntime(clasz);

        TypeNativeObjectRuntimeImpl typeDec;
        if (classType instanceof ClassTypeNativePrimitiveWrapperRuntimeImpl)
            typeDec = newTypeNativePrimitiveWrapperRuntime(clasz,ctx);
        else if (classType instanceof ClassTypeNativePrimitiveObjectRuntimeImpl)
            typeDec = newTypeNativePrimitiveObjectRuntime(clasz,ctx);        
        else if (classType instanceof ClassTypeNativePrimitiveObjectWrapperRuntimeImpl)
            typeDec = newTypeNativePrimitiveObjectWrapperRuntime(clasz,ctx);
        else
            throw new JNIEasyException("Not valid class: " + clasz.getName());
        
        if (rtMgr.getNativeManager().isRuntimeChecking())
            typeDec.check(); // Verifica si el clasz es correspondiente con el tipo primitivo esperado

        return typeDec;
    }
    
    public void pushArrayVarArgsIncBufferSize(int length,NativeBufferIteratorImpl memIt)
    {
        long incSize = length * stackSizeByValue();
        NativeBufferImpl buffer = (NativeBufferImpl)memIt.getBuffer();
        buffer.realloc(buffer.size() + incSize);
    }    
    
    public abstract Object push(Object value,NativeBufferIteratorImpl memIt);
    public abstract Object pop(NativeBufferIteratorImpl memIt); 
    public abstract void pushArrayVarArgs(Object value, NativeBufferIteratorImpl memIt);
}
