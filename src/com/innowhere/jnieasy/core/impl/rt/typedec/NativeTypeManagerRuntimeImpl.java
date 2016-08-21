/*
 * DeclareType.java
 *
 * Created on 10 de enero de 2005, 21:34
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.NativePointer;
import com.innowhere.jnieasy.core.data.NativeStringAnsi;
import com.innowhere.jnieasy.core.data.NativeStringAnsiArray;
import com.innowhere.jnieasy.core.data.NativeStringBufferAnsi;
import com.innowhere.jnieasy.core.data.NativeStringBufferAnsiArray;
import com.innowhere.jnieasy.core.data.NativeStringBufferUnicode;
import com.innowhere.jnieasy.core.data.NativeStringBufferUnicodeArray;
import com.innowhere.jnieasy.core.data.NativeStringUnicode;
import com.innowhere.jnieasy.core.data.NativeStringUnicodeArray;
import com.innowhere.jnieasy.core.typedec.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.codegen.ClassFinder;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportDec;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferUnicodeWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringUnicodeWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeTypeNativeManagerImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextNotUsingImports;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextUsingImports;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeShortRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NativeTypeManagerRuntimeImpl implements NativeTypeManager
{
    protected RuntimeManagerImpl rtMgr;
    protected ClassLoader classLoader;    
    protected NativeTypeNativeManagerImpl typeDecMgr;
    protected ClassFinder classFinder;
    protected long structAlign = 8; // el valor por defecto usado por el Visual C++ y por Win32 adecuado para arquitecturas x86    
    protected Map macros = Collections.synchronizedMap(new TreeMap()); // para que se ordene en orden alfabético y la búsqueda sea muy rápida
   
    
    // Singletons (para acelerar), pues estos ClassType están una sola vez en memoria
    protected ClassTypeNativeStringAnsiWrapperImpl classTypeStringAnsiSingleton;
    protected ClassTypeNativeStringUnicodeWrapperImpl classTypeStringUnicodeSingleton;
    protected ClassTypeNativeStringBufferAnsiWrapperImpl classTypeStringBufferAnsiSingleton;
    protected ClassTypeNativeStringBufferUnicodeWrapperImpl classTypeStringBufferUnicodeSingleton;
    
    protected ClassTypeNativeBooleanRuntimeImpl classTypeNativeBooleanSingleton;    
    protected ClassTypeNativeByteRuntimeImpl classTypeNativeByteSingleton;    
    protected ClassTypeNativeCharacterRuntimeImpl classTypeNativeCharacterSingleton;    
    protected ClassTypeNativeShortRuntimeImpl classTypeNativeShortSingleton;    
    protected ClassTypeNativeIntegerRuntimeImpl classTypeNativeIntegerSingleton;    
    protected ClassTypeNativeLongRuntimeImpl classTypeNativeLongSingleton;    
    protected ClassTypeNativeFloatRuntimeImpl classTypeNativeFloatSingleton;    
    protected ClassTypeNativeDoubleRuntimeImpl classTypeNativeDoubleSingleton;    
    
    
    /** Creates a new instance of DeclareType */
    public NativeTypeManagerRuntimeImpl(RuntimeManagerImpl rtMgr,NativeTypeNativeManagerImpl typeDecMgr)
    {
        this.rtMgr = rtMgr;
        this.typeDecMgr = typeDecMgr;
        this.classFinder = new ClassFinder(this);
    }
    
    public RuntimeManagerImpl getRuntimeManager()    
    {
        return rtMgr;
    }
    
    public boolean isRuntimeChecking()
    {
        return rtMgr.getNativeManager().isRuntimeChecking();
    }
    
    public NativeVarTypeManager getVarTypeManager()
    {
        return rtMgr.getVarTypeManagerRuntime();
    }
   
    public ClassFinder getClassFinder()
    {
        return classFinder;
    }
    
    public RuntimeContextNotUsingImports getDefaultRuntimeContextNotUsingImports()
    {
        return rtMgr.getDefaultRuntimeContextNotUsingImports();
    }
    
    public RuntimeContextUsingImports getRuntimeContext(String[] importList)
    {    
        return rtMgr.getRuntimeContext(importList);
    }
    
    public String[] getDefaultImports()
    {
        RuntimeContextUsingImports ctx = rtMgr.getDefaultRuntimeContextUsingImports();
        List importList = ctx.getImportList().getImports();
        // Quitamos el primer elemento que es el java.lang.* siempre presente
        int size = importList.size() - 1; // Es 0 o mayor
        if (size == 0)
            return null;
        String[] res = new String[size]; 
        Iterator it = importList.iterator();
        it.next(); // quitamos el primero        
        for(int i = 0; it.hasNext(); i++ )
            res[i] = ((ImportDec)it.next()).getClassImport();
        return res;
    }
    
    public void setDefaultImports(String[] importList)
    {
        rtMgr.setDefaultRuntimeContextUsingImports(importList);
    }
    
    public Class getClass(String className)
    {    
        return getClass(className,true);
    }
    
    public Class getClass(String className,boolean onErrorThrow)
    {
        return ClassTypeNativeRuntimeImpl.getClass(className,getClassLoader(), onErrorThrow);
    }    
    
    public ClassLoader getClassLoader()
    {
        if (classLoader != null)
            return classLoader;
        else
            return getDefaultClassLoader();
    }
    
    public ClassLoader getDefaultClassLoader()
    {
        return getClass().getClassLoader();
    }
    
    public void setClassLoader(ClassLoader loader)
    {    
        this.classLoader = loader;
    }
        
    public int getDefaultStringEncoding()
    {
        return typeDecMgr.getDefaultStringEncoding(); 
    }
    
    public void setDefaultStringEncoding(int encoding)
    {
        typeDecMgr.setDefaultStringEncoding(encoding);
    }    
    
    public long getStructureAlignSize()
    {
        return structAlign;
    }
    
    public void setStructureAlignSize(long size)
    {
        this.structAlign = size;
    }
            
    public static void checkAlignSize(long alignSize)
    {
        switch((int)alignSize)
        {
            case 1:
            case 2:                
            case 4:                
            case 8:                
            case 16: break;
            default: throw new JNIEasyException("Align size not valid only valid 1,2,4,8,16: " + alignSize);
        }            
    }      
    
    public Object getMacro(String name)
    {
        return macros.get(name);
    }
    
    public boolean isDefinedMacro(String name)    
    {
        return macros.containsKey(name);        
    }
    
    public Object defineMacro(String name)
    {
        return macros.put(name,null);
    }

    public Object defineMacro(String name, Object value)
    {
        return macros.put(name,value);        
    }
    
    public Object undefMacro(String name)
    {
        return macros.remove(name);
    }

    public Map getMacros()
    {
        return Collections.unmodifiableMap(macros);
    }          
    
    public Map getMacrosInternal()
    {
        return macros;
    }    
    
    public String parseTextWithMacros(String textExpr)
    {
        return MacroTextPair.parseText(textExpr,this);
    }
    
    public String parseNameWithMacros(String nameExpr)
    {
        String name = parseTextWithMacros(nameExpr);
        name = name.trim();
        return name;
    }  
    
    public long parseMemorySizeWithMacros(String sizesStrExpr)
    {
        return MemorySizeRuntime.parseSize(sizesStrExpr,this);
    }
    
    public TypeNative getDefaultType(Object value)
    {
        if (value == null) throw new JNIEasyException("Value argument cannot be null");
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();        
        TypeNativeRuntimeImpl typeDec = TypeNativeRuntimeImpl.getDefaultAssociatedType(value,false,ctx); //.newTypeNativeRuntime(value, ctx); 
        if (isRuntimeChecking())        
            typeDec.check(); 
        return typeDec;
    }
    
    public NativeClassDescriptor getClassDescriptor(Class clasz)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        ClassTypeNativeImpl classType = ctx.getClassType(clasz);
        if (classType instanceof ClassTypeNativeCapableImpl)
        {
            ClassTypeNativeCapableRuntimeImpl classTypeRt = (ClassTypeNativeCapableRuntimeImpl)classType.getClassTypeRuntime();
            return classTypeRt.getJavaClassAsNativeCapableRuntime(); // Puede ser null
        }
        else
            return null;
    }
    
    public long sizeOf(Class clasz)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        ClassTypeNativeRuntimeImpl classTypeRt = ctx.getClassTypeRuntime(clasz);
        return classTypeRt.getObjectSize(); 
    }
    
    public long alignSizeOf(Class clasz)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        ClassTypeNativeRuntimeImpl classTypeRt = ctx.getClassTypeRuntime(clasz);
        return classTypeRt.getPreferredAlignSize(); 
    }
    
    public ClassTypeNativeImpl getClassType(Class clasz)
    {
        // Uso interno
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();        
        return ctx.getClassType(clasz);
    }    
    
    public ClassTypeNativeRuntimeImpl getClassTypeRuntime(Class clasz)
    {
        // Uso interno
        ClassTypeNativeImpl classType = getClassType(clasz);
        if (classType == null)
            return null;
        return classType.getClassTypeRuntime();
    }        
    
    public TypeNativeRuntimeImpl dec(Class clasz,ClassTypeNativeImpl classType)
    {
        // Uso interno.
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();        
        TypeNativeRuntimeImpl typeDec = TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,classType,ctx);
        if (isRuntimeChecking())        
            typeDec.check();
        return typeDec;
    }
    
    public TypeNative dec(Class clasz)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        TypeNativeRuntime typeDec = TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,ctx);
        if (isRuntimeChecking())       
            typeDec.check();
        return typeDec;        
    }    
    
    public TypeNativePrimitive decPrimitive(Class clasz,long size)
    {
        return decPrimitive(clasz,size,size); // Lo normal es que el alineamiento coincida con el tamaño (a falta de más datos)
    }    
    

    public TypeNativePrimitive decPrimitive(Class clasz,long size,long alignment)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        TypeNativePrimitiveRuntimeImpl typeDec = (TypeNativePrimitiveRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,ctx);
        typeDec.setSizeAndPreferredAlignSize(size,alignment);
        return typeDec;
    }   
    
    public TypeNativePrimitive decPrimitive(Class clasz,String sizeExpr)
    {
        return decPrimitive(clasz,sizeExpr,sizeExpr);
    }
    
    public TypeNativePrimitive decPrimitive(Class clasz,String sizeExpr,String alignSizeExpr)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        TypeNativePrimitiveRuntimeImpl typeDec = (TypeNativePrimitiveRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,ctx);
        typeDec.setSizeAndPreferredAlignSize(sizeExpr,alignSizeExpr);
        return typeDec;    
    }
    
    public TypeNativeLong decAddress()    
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();
        TypeNativeLongRuntimeImpl typeDec = (TypeNativeLongRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(long.class,getClassTypeNativeLongRuntime(),ctx);
        typeDec.setIsAddress();
        return typeDec;          
    } 
    
    public TypeNative dec(String decExpression)
    {
        return dec(decExpression,null);
    }

    public TypeNative dec(String decExpression,String[] importList)    
    {
        // No debe tener * al final, no estamos declarando tipos de variables. 
        RuntimeContextUsingImports ctx = getRuntimeContext(importList);
        TypeNativeRuntime typeDec = TypeNativeRuntimeImpl.newTypeNativeRuntime(decExpression,ctx);
        if (isRuntimeChecking())        
            typeDec.check();
        return typeDec;
    }
    
    public TypeNativeString decString()
    {
        return decString(getDefaultStringEncoding());
    }    
    
    public TypeNativeString decString(int encoding)
    {
        return decString(String.class,encoding);
    }

    public TypeNativeString decString(Class clasz,int encoding)
    {
        // Admite String, NativeString, NativeStringAnsi (el encoding debe ser correcto) etc
        TypeNativeStringRuntime typeDec = (TypeNativeStringRuntime)dec(clasz);
        typeDec.setEncoding(encoding);
        return typeDec;
    }    
    
    public TypeNativeString decString(Class clasz,String encodingExpr)
    {
        int encoding = TypeNativeStringInfoRuntime.toEncoding(encodingExpr,this);
        return decString(clasz,encoding);
    }        
    
    public TypeNativeStringAnsi decStringAnsi()    
    {
        Class clasz = NativeStringAnsi.class;
        if (classTypeStringAnsiSingleton == null)
            this.classTypeStringAnsiSingleton = (ClassTypeNativeStringAnsiWrapperImpl)getClassType(clasz);
        return (TypeNativeStringAnsi)dec(clasz,classTypeStringAnsiSingleton);
    }
    
    public TypeNativeStringUnicode decStringUnicode()
    {
        Class clasz = NativeStringUnicode.class;
        if (classTypeStringUnicodeSingleton == null)
            this.classTypeStringUnicodeSingleton = (ClassTypeNativeStringUnicodeWrapperImpl)getClassType(clasz);
        return (TypeNativeStringUnicode)dec(clasz,classTypeStringUnicodeSingleton);         
    }    
    
    public TypeNativeStringBuffer decStringBuffer()
    {
        return decStringBuffer(getDefaultStringEncoding());
    }
    
    public TypeNativeStringBuffer decStringBuffer(int encoding)    
    {
        return decStringBuffer(StringBuffer.class,encoding);
    } 
    
    public TypeNativeStringBuffer decStringBuffer(Class clasz,int encoding)
    {
        // Admite StringBuffer, NativeStringBuffer, NativeStringBufferAnsi etc        
        TypeNativeStringBufferRuntime typeDec = (TypeNativeStringBufferRuntime)dec(clasz);        
        typeDec.setEncoding(encoding);
        return typeDec;
    }        
    
    public TypeNativeStringBuffer decStringBuffer(Class clasz,String encodingExpr)
    {
        int encoding = TypeNativeStringInfoRuntime.toEncoding(encodingExpr,this);
        return decStringBuffer(clasz,encoding);
    }            
    
    public TypeNativeStringBufferAnsi decStringBufferAnsi()    
    {
        Class clasz = NativeStringBufferAnsi.class;
        if (classTypeStringBufferAnsiSingleton == null)
            this.classTypeStringBufferAnsiSingleton = (ClassTypeNativeStringBufferAnsiWrapperImpl)getClassType(clasz);
        return (TypeNativeStringBufferAnsi)dec(clasz,classTypeStringBufferAnsiSingleton);
    }
    
    public TypeNativeStringBufferUnicode decStringBufferUnicode()
    {
        Class clasz = NativeStringBufferUnicode.class;
        if (classTypeStringBufferUnicodeSingleton == null)
            this.classTypeStringBufferUnicodeSingleton = (ClassTypeNativeStringBufferUnicodeWrapperImpl)getClassType(clasz);
        return (TypeNativeStringBufferUnicode)dec(clasz,classTypeStringBufferUnicodeSingleton);   
    }    
    
    private TypeNativeArray decArrayInternal(Class clasz,int[] dims,VarTypeNativeRuntimeImpl lastCompVarType)
    {
        // dims y lastCompVarType pueden ser null
        
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();   
        
        if (lastCompVarType == null)
        {
            TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,ctx);           
            if (dims != null) typeDec.getTypeNativeArrayInfoRuntime().setDimensions(dims);
            return typeDec;
        }
        else
        {
            if (clasz.isArray())
            {
                if (dims != null)
                {
                    return TypeNativeArrayRuntimeImpl.newTypeNativeArrayRuntime(clasz,dims,lastCompVarType,ctx);
                }
                else
                {
                    return TypeNativeArrayRuntimeImpl.newTypeNativeArrayRuntime(clasz,lastCompVarType,ctx);
                }
            }
            else
            {
                if (dims != null)
                {              
                    return TypeNativeArrayWrapperRuntimeImpl.newTypeNativeArrayWrapperRuntime(clasz,dims,lastCompVarType,ctx);
                }
                else
                {
                    TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,ctx);
                    typeDec.getTypeNativeArrayInfoRuntime().setLastComponentVarType(lastCompVarType);               
                    return typeDec;
                }
            }
                
        }
    }    
    
    public TypeNativeArray decArray(Class clasz)    
    {
        return decArray(clasz,null,null);      
    }    
    
    public TypeNativeArray decArray(Class clasz,int length)    
    {
        return decArray(clasz,new int[]{length});     
    }      
    
    public TypeNativeArray decArray(Class clasz,int[] dims)
    {
        TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)decArrayInternal(clasz, dims,null);
        if (isRuntimeChecking())        
            typeDec.check();
        return typeDec;        
    }    
    
    public TypeNativeArray decArray(Class clasz,int[] dims,int lastCompVarConv)
    {
        TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)decArrayInternal(clasz, dims,null);
        typeDec.getTypeNativeArrayInfoRuntime().getLastComponentVarType().setVarConv(lastCompVarConv);
        if (isRuntimeChecking())        
            typeDec.check();        
        return typeDec;
    }
    
    public TypeNativeArray decArray(Class clasz,int[] dims,VarTypeNative lastCompVarType)
    {
        TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)decArrayInternal(clasz, dims,(VarTypeNativeRuntimeImpl)lastCompVarType);
        if (isRuntimeChecking())        
            typeDec.check();        
        return typeDec;
    }
    
    public TypeNativeArray decArray(int[] dims,VarTypeNative lastCompVarType)
    {
        // Da lugar a una declaración de array tipo: CompClass[][] (con dimensiones, * etc)
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();         
        TypeNativeArrayRuntime typeDec = TypeNativeArrayRuntimeImpl.newTypeNativeArrayRuntime(dims,(VarTypeNativeRuntimeImpl)lastCompVarType,ctx);
        if (isRuntimeChecking())        
            typeDec.check();        
        return typeDec;
    }
    
    public TypeNativeArray decArray(int length,VarTypeNative lastCompVarType)
    {
        return decArray(new int[]{length},lastCompVarType);
    }    
    
    public TypeNativeArray decArray(int[] dims,Class compClass)
    {
        return decArray(dims,getVarTypeManager().dec(compClass));
    }
    
    public TypeNativeArray decArray(int length,Class compClass)
    {
        return decArray(new int[length],compClass);
    } 
    
    public TypeNativeArray decStringArray(Class clasz,int[] dims,int encoding)
    {
        TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)decArray(clasz,dims);
        // Fallará si no es un array de String, o un NativeStringArray etc puede ser multidimensional
        TypeNativeStringRuntime compTypeDec = (TypeNativeStringRuntime)typeDec.getLastComponentDec().getType();
        compTypeDec.setEncoding(encoding);
        return typeDec;
    }

    public TypeNativeArray decStringArray(Class clasz,int encoding)
    {
        return decStringArray(clasz,null,encoding);
    }    
    
    public TypeNativeArray decStringBufferArray(Class clasz,int[] dims,int encoding)
    {
        TypeNativeArrayRuntime typeDec = (TypeNativeArrayRuntime)decArray(clasz,dims);        
        // Fallará si no es un array de String, puede ser multidimensional
        TypeNativeStringBufferRuntime compTypeDec = (TypeNativeStringBufferRuntime)typeDec.getLastComponentDec().getType();
        compTypeDec.setEncoding(encoding);       
        return typeDec;
    }    

    public TypeNativeArray decStringBufferArray(Class clasz,int encoding)
    {
        return decStringBufferArray(clasz,null,encoding);
    }     
    
    public TypeNativeArray decStringArray(int encoding)
    {
        return decStringArray(String[].class,encoding);
    }
    
    public TypeNativeArray decStringBufferArray(int encoding)
    {
        return decStringBufferArray(StringBuffer[].class,encoding);        
    }    
    
    public TypeNativeArray decStringAnsiArray()
    {
        return decArray(NativeStringAnsiArray.class);        
    }
    
    public TypeNativeArray decStringUnicodeArray()
    {
        return decArray(NativeStringUnicodeArray.class);        
    }
    
    public TypeNativeArray decStringBufferAnsiArray()
    {
        return decArray(NativeStringBufferAnsiArray.class);        
    }
    
    public TypeNativeArray decStringBufferUnicodeArray()
    {
        return decArray(NativeStringBufferUnicodeArray.class);        
    }
    
    public TypeNativeBehavior decBehavior(Class methodClass,NativeBehaviorSignature signature)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();        
        TypeNativeBehaviorRuntime typeDec = (TypeNativeBehaviorRuntime)TypeNativeRuntimeImpl.newTypeNativeRuntime(methodClass,ctx);
        typeDec.setBehaviorSignature(signature);
        if (isRuntimeChecking())        
            typeDec.check();     
        return typeDec;
    }
    
    public TypeNativeMethod decMethod(Class methodClass,NativeMethodSignature signature)
    {
        return (TypeNativeMethod)decBehavior(methodClass,signature);
    }
    
    public TypeNativeStaticMethod decStaticMethod(Class methodClass,NativeStaticMethodSignature signature)
    {
        return (TypeNativeStaticMethod)decBehavior(methodClass,signature);        
    }
  
    public TypeNativeInstanceMethod decInstanceMethod(Class methodClass,NativeInstanceMethodSignature signature)
    {
        return (TypeNativeInstanceMethod)decBehavior(methodClass,signature);        
    }
    
    public TypeNativeConstructor decConstructor(Class methodClass,NativeConstructorSignature signature)
    {
        return (TypeNativeConstructor)decBehavior(methodClass,signature);
    }
    
    public TypeNativeFieldMethod decFieldMethod(Class fieldClass,NativeFieldMethodSignature signature)
    {
        return (TypeNativeFieldMethod)decBehavior(fieldClass,signature);
    }
    
    public TypeNativeStaticFieldMethod decStaticFieldMethod(Class fieldClass,NativeStaticFieldMethodSignature signature)
    {
        return (TypeNativeStaticFieldMethod)decBehavior(fieldClass,signature);
    }
  
    public TypeNativeInstanceFieldMethod decInstanceFieldMethod(Class fieldClass,NativeInstanceFieldMethodSignature signature)
    {
        return (TypeNativeInstanceFieldMethod)decBehavior(fieldClass,signature);
    }    
    
    public TypeNativePointer decPointer(Class clasz,VarTypeNative pointerDec)
    {
        RuntimeContext ctx = getDefaultRuntimeContextNotUsingImports();        
        TypeNativePointerRuntimeImpl typeDec = (TypeNativePointerRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(clasz,ctx);
        typeDec.setAddressedVarTypeNativeObjectRuntime((VarTypeNativeObjectRuntimeImpl)pointerDec);
        if (isRuntimeChecking())        
            typeDec.check();
        return typeDec;          
    }
    
    public TypeNativePointer decPointer(VarTypeNative pointerDec)
    {
        return decPointer(NativePointer.class,pointerDec);
    }

    public ClassTypeNativeBooleanRuntimeImpl getClassTypeNativeBooleanRuntime()
    {
        // Uso interno
        if (classTypeNativeBooleanSingleton == null)
            this.classTypeNativeBooleanSingleton = (ClassTypeNativeBooleanRuntimeImpl)getClassTypeRuntime(boolean.class);
        return classTypeNativeBooleanSingleton;
    }
    
    public ClassTypeNativeByteRuntimeImpl getClassTypeNativeByteRuntime()
    {
        // Uso interno        
        if (classTypeNativeByteSingleton == null)
            this.classTypeNativeByteSingleton = (ClassTypeNativeByteRuntimeImpl)getClassTypeRuntime(byte.class);
        return classTypeNativeByteSingleton;
    }    
    
    public ClassTypeNativeCharacterRuntimeImpl getClassTypeNativeCharacterRuntime()
    {
        // Uso interno
        if (classTypeNativeCharacterSingleton == null)
            this.classTypeNativeCharacterSingleton = (ClassTypeNativeCharacterRuntimeImpl)getClassTypeRuntime(char.class);
        return classTypeNativeCharacterSingleton;
    }    
    
    public ClassTypeNativeShortRuntimeImpl getClassTypeNativeShortRuntime()
    {
        // Uso interno
        if (classTypeNativeShortSingleton == null)
            this.classTypeNativeShortSingleton = (ClassTypeNativeShortRuntimeImpl)getClassTypeRuntime(short.class);
        return classTypeNativeShortSingleton;
    }    
    
    public ClassTypeNativeIntegerRuntimeImpl getClassTypeNativeIntegerRuntime()
    {
        // Uso interno
        if (classTypeNativeIntegerSingleton == null)
            this.classTypeNativeIntegerSingleton = (ClassTypeNativeIntegerRuntimeImpl)getClassTypeRuntime(int.class);
        return classTypeNativeIntegerSingleton;
    }    
    
    public ClassTypeNativeLongRuntimeImpl getClassTypeNativeLongRuntime()
    {
        // Uso interno
        if (classTypeNativeLongSingleton == null)
            this.classTypeNativeLongSingleton = (ClassTypeNativeLongRuntimeImpl)getClassTypeRuntime(long.class);
        return classTypeNativeLongSingleton;
    }    
    
    public ClassTypeNativeFloatRuntimeImpl getClassTypeNativeFloatRuntime()
    {
        // Uso interno
        if (classTypeNativeFloatSingleton == null)
            this.classTypeNativeFloatSingleton = (ClassTypeNativeFloatRuntimeImpl)getClassTypeRuntime(float.class);
        return classTypeNativeFloatSingleton;
    }    
    
    public ClassTypeNativeDoubleRuntimeImpl getClassTypeNativeDoubleRuntime()
    {
        // Uso interno
        if (classTypeNativeDoubleSingleton == null)
            this.classTypeNativeDoubleSingleton = (ClassTypeNativeDoubleRuntimeImpl)getClassTypeRuntime(double.class);
        return classTypeNativeDoubleSingleton;
    }    
    
    public long getDefaultBooleanSize()
    {
        return getClassTypeNativeBooleanRuntime().getObjectSize();        
    }
    
    public void setDefaultBooleanSize(long size)
    {
        setDefaultBooleanSize(size,size);
    }    

    public long getDefaultByteSize()
    {
        return getClassTypeNativeByteRuntime().getObjectSize();         
    }
    
    public void setDefaultByteSize(long size)
    {
        setDefaultByteSize(size,size);        
    }

    public long getDefaultCharSize()
    {
        return getClassTypeNativeCharacterRuntime().getObjectSize();         
    }
    
    public void setDefaultCharSize(long size)
    {
        setDefaultCharSize(size,size);       
    }

    public long getDefaultShortSize()
    {
        return getClassTypeNativeShortRuntime().getObjectSize();         
    }
    
    public void setDefaultShortSize(long size)
    {
        setDefaultShortSize(size,size);
    }

    public long getDefaultIntSize()
    {
        return getClassTypeNativeIntegerRuntime().getObjectSize();         
    }

    public void setDefaultIntSize(long size)
    {
        setDefaultIntSize(size,size);         
    }

    public long getDefaultLongSize()
    {
        return getClassTypeNativeLongRuntime().getObjectSize();         
    }
    
    public void setDefaultLongSize(long size)
    {
        setDefaultLongSize(size,size);         
    }

    public long getDefaultFloatSize()
    {
        return getClassTypeNativeFloatRuntime().getObjectSize();        
    }
    
    public void setDefaultFloatSize(long size)
    {
        setDefaultFloatSize(size,size);         
    }

    public long getDefaultDoubleSize()
    {
        return getClassTypeNativeDoubleRuntime().getObjectSize();        
    }
    
    public void setDefaultDoubleSize(long size)
    {
        setDefaultDoubleSize(size,size);        
    }

    public long getDefaultBooleanAlignSize()
    {
        return getClassTypeNativeBooleanRuntime().getPreferredAlignSize();        
    }

    public void setDefaultBooleanSize(long size, long align)
    {
        ClassTypeNativeBooleanRuntimeImpl classType = getClassTypeNativeBooleanRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);
    }

    public long getDefaultByteAlignSize()
    {
        return getClassTypeNativeByteRuntime().getPreferredAlignSize();         
    }
    
    public void setDefaultByteSize(long size, long align)
    {
        ClassTypeNativeByteRuntimeImpl classType = getClassTypeNativeByteRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }
    
    public long getDefaultCharAlignSize()
    {
        return getClassTypeNativeCharacterRuntime().getPreferredAlignSize();         
    }

    public void setDefaultCharSize(long size, long align)
    {
        ClassTypeNativeCharacterRuntimeImpl classType = getClassTypeNativeCharacterRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }
    
    public long getDefaultShortAlignSize()
    {
        return getClassTypeNativeShortRuntime().getPreferredAlignSize();         
    }

    public void setDefaultShortSize(long size, long align)
    {
        ClassTypeNativeShortRuntimeImpl classType = getClassTypeNativeShortRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }
    
    public long getDefaultIntAlignSize()
    {
        return getClassTypeNativeIntegerRuntime().getPreferredAlignSize();         
    }

    public void setDefaultIntSize(long size, long align)
    {
        ClassTypeNativeIntegerRuntimeImpl classType = getClassTypeNativeIntegerRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }
    
    public long getDefaultLongAlignSize()
    {
        return getClassTypeNativeLongRuntime().getPreferredAlignSize();         
    }

    public void setDefaultLongSize(long size, long align)
    {
        ClassTypeNativeLongRuntimeImpl classType = getClassTypeNativeLongRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }

    public long getDefaultFloatAlignSize()
    {
        return getClassTypeNativeFloatRuntime().getPreferredAlignSize();         
    }

    public void setDefaultFloatSize(long size, long align)
    {
        ClassTypeNativeFloatRuntimeImpl classType = getClassTypeNativeFloatRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }    
    
    public long getDefaultDoubleAlignSize()
    {
        return getClassTypeNativeDoubleRuntime().getPreferredAlignSize();         
    }

    public void setDefaultDoubleSize(long size, long align)
    {
        ClassTypeNativeDoubleRuntimeImpl classType = getClassTypeNativeDoubleRuntime();
        classType.setObjectSize(size);
        classType.setPreferredAlignSize(align);        
    }
    
    public long getWCharTSize()
    {
        return TypeSizes.getWCharTSize();
    }

    public void setWCharTSize(long value)    
    {
        TypeSizes.setWCharTSize(value);
    }
}
