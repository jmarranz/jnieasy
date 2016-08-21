/*
 * NativeMultipleFieldContainerEnhancerImpl.java
 *
 * Created on 26 de mayo de 2005, 17:23
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.FieldAccessExceptionUtil;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.NativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeMultipleFieldContainerCustomStateManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeShortRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.mem.Fetch;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.mem.UnFetch;
import com.innowhere.jnieasy.core.method.NativeBehavior;
import com.innowhere.jnieasy.core.typedec.NativeMultipleFieldContainerDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeConstructorSignature;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;
import com.innowhere.jnieasy.core.typedec.TypeNative;



/**
 *
 * @author jmarranz
 */
public class NativeMultipleFieldContainerEnhancerImpl extends NativeFieldContainerEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeMultipleFieldContainerEnhancerImpl
     */
    public NativeMultipleFieldContainerEnhancerImpl()
    {
    }
       
    public static int getDefaultFetchMode(NativeCapableInternal container)
    {
        return NativeManagerImpl.getDefaultFetchMode(container); // admite el caso null
    }
    
    public static int getDefaultUnFetchMode(NativeCapableInternal container)
    {
        return NativeManagerImpl.getDefaultUnFetchMode(container); // admite el caso null
    }    
    
    public static long getClassSize(NativeClassDescriptor classInfo)
    {
        return ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).size();
    }
       
    public static TypeNative getTypeNative(NativeCapableInternal container,TypeNative typeDec)
    {
        // Para unificar comportamientos
        return NativeCapableImpl.jnieasyGetType(container, typeDec);        
    }
    
    public static void addField(NativeMultipleFieldContainerDescriptor classInfo,int index,String fieldName,String fieldAlignSize,boolean beginUnion,boolean endUnion,VarTypeNative varTypeDec)
    {
        ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).addField(index, fieldName,fieldAlignSize,beginUnion,endUnion,varTypeDec);
    }
    
    public static void addConstructor(NativeMultipleFieldContainerDescriptor classInfo,String javaClassName,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeName,NativeConstructorSignature sig)
    {
        ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).addConstructor(javaClassName,exportMethod,onLibrary,useReflection,nativeName,(NativeConstructorSignatureRuntimeImpl)sig);
    }  
    
    public static void addMethod(NativeMultipleFieldContainerDescriptor classInfo,String javaClassName,String methodName,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeName,NativeMethodSignature sig)
    {
        ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).addMethod(javaClassName,methodName,exportMethod,onLibrary,useReflection,nativeName,(NativeMethodSignatureRuntimeImpl)sig);
    }   
    
    public static void addFieldMethod(NativeMultipleFieldContainerDescriptor classInfo,String javaClassName,String fieldName,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeFieldName,NativeFieldMethodSignature sig)
    {
        ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).addFieldMethod(javaClassName,fieldName,exportMethod,onLibrary,useReflection,nativeFieldName,(NativeFieldMethodSignatureRuntimeImpl)sig);
    }
    
    public static NativeStateManager newNativeStateManager(NativeMultipleFieldContainerDescriptor classInfo)
    {
        return new NativeMultipleFieldContainerCustomStateManagerImpl((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo);
    }
  
    public static int getAbsFieldCount(NativeMultipleFieldContainerDescriptor classInfo)    
    {
        return ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getAbsoluteFieldCount();
    }
    
    public static void registerDynamicLibrary(NativeMultipleFieldContainerDescriptor classInfo,String libraryPath)
    {
        ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).setDynamicLibrary(libraryPath);
    }
    
    public static NativeBehavior getNativeBehavior(NativeMultipleFieldContainerDescriptor classInfo,int index)
    {
        return ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getNativeBehavior(index);        
    }
    
    public static void detachField(NativeMultipleFieldContainerDescriptor classInfo,int index,Object currValue,int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        int fieldIndex = attInfo.getAbsIndex();  
        try
        {
            VarTypeNativeObjectRuntimeImpl varTypeDec = (VarTypeNativeObjectRuntimeImpl)attInfo.getVarTypeNativeRuntime();           
            varTypeDec.detachField(fieldIndex,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr,currValue,freeMemMode,deep);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),currValue,stateMgr.getNativeCapable()), ex);
        }
    }  
    
    public static Object cloneField(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,Object currValue,Object cloneCtx,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            VarTypeNativeObjectRuntimeImpl varTypeDec = (VarTypeNativeObjectRuntimeImpl)attInfo.getVarTypeNativeRuntime();
            return varTypeDec.clone(fieldIndex,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr,currValue,(CloneContext)cloneCtx);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),currValue,stateMgr.getNativeCapable()), ex);
        }            
    }       
    
    public static Object getObject(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,Object currValue,int fetchMode)
    {
        synchronized (obj)
        {
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;
            
            NativeManagerImpl.checkFetchMode(fetchMode);
            FetchUnFetchContext fetchCtx = NativeManagerImpl.newFetchContextIfNeeded(fetchMode);
            return getObject(obj,classInfo,index,currValue,fetchMode,fetchCtx,stateMgr);
        }
    }    
    
    public static Object getObject(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index, Object currValue,int fetchMode,Object fetchCtx,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            VarTypeNativeObjectRuntimeImpl varTypeDec = (VarTypeNativeObjectRuntimeImpl)attInfo.getVarTypeNativeRuntime();
            return varTypeDec.getObject(fieldIndex,offset,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr,currValue,fetchMode,(FetchUnFetchContext)fetchCtx);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),currValue,stateMgr.getNativeCapable()), ex);
        }        
    }
    
    public static Object setObject(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index, Object newValue, int unFetchMode)
    {
        synchronized (obj)
        {        
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;
            
            NativeManagerImpl.checkUnFetchMode(unFetchMode);
            FetchUnFetchContext unfetchCtx = NativeManagerImpl.newUnFetchContextIfNeeded(unFetchMode);            
            return setObject(obj,classInfo,index,newValue,unFetchMode,unfetchCtx,null,stateMgr);
        }
    }
    
    public static Object setObject(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index, Object newValue, int unFetchMode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            VarTypeNativeObjectRuntimeImpl varTypeDec = (VarTypeNativeObjectRuntimeImpl)attInfo.getVarTypeNativeRuntime();
            varTypeDec.setObject(fieldIndex,offset,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr,newValue, unFetchMode,(FetchUnFetchContext)unfetchCtx,(AttachCopyContext)attachCopyCtx);
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),newValue,stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static boolean getBoolean(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,boolean currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getBoolean(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static boolean getBoolean(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,boolean currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeBooleanRuntimeImpl typeDec = (TypeNativeBooleanRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldBoolean(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),Boolean.valueOf(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }

    public static byte getByte(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,byte currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getByte(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static byte getByte(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,byte currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeByteRuntimeImpl typeDec = (TypeNativeByteRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldByte(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Byte(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static char getChar(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,char currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getChar(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static char getChar(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,char currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeCharacterRuntimeImpl typeDec = (TypeNativeCharacterRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldChar(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Character(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static short getShort(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,short currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getShort(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static short getShort(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,short currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeShortRuntimeImpl typeDec = (TypeNativeShortRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldShort(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Short(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static int getInt(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,int currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getInt(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static int getInt(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,int currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeIntegerRuntimeImpl typeDec = (TypeNativeIntegerRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldInt(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Integer(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static long getLong(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,long currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getLong(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static long getLong(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,long currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeLongRuntimeImpl typeDec = (TypeNativeLongRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldLong(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Long(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static float getFloat(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,float currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getFloat(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static float getFloat(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,float currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeFloatRuntimeImpl typeDec = (TypeNativeFloatRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldFloat(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Float(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static double getDouble(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,double currValue,int fetchMode)
    {
        synchronized (obj)
        {         
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(fetchMode == Fetch.NONE)) 
                return currValue;

            NativeManagerImpl.checkFetchMode(fetchMode); 
            return getDouble(obj,classInfo,index,currValue,fetchMode,stateMgr);
        }
    }
    
    public static double getDouble(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,double currValue,int fetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeDoubleRuntimeImpl typeDec = (TypeNativeDoubleRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            return typeDec.getFieldDouble(fieldIndex,offset,currValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Double(currValue),stateMgr.getNativeCapable()), ex);
        }            
    }

    public static boolean setBoolean(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,boolean newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setBoolean(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static boolean setBoolean(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,boolean newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();            
        try
        {
            TypeNativeBooleanRuntimeImpl typeDec = (TypeNativeBooleanRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldBoolean(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);        
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),Boolean.valueOf(newValue),stateMgr.getNativeCapable()), ex);
        }        
    }
    
    public static byte setByte(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,byte newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setByte(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static byte setByte(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,byte newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeByteRuntimeImpl typeDec = (TypeNativeByteRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldByte(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Byte(newValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static char setChar(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,char newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setChar(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static char setChar(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,char newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();            
        try
        {
            TypeNativeCharacterRuntimeImpl typeDec = (TypeNativeCharacterRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldChar(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);               
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Character(newValue),stateMgr.getNativeCapable()), ex);
        }        
    }
    
    public static short setShort(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,short newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setShort(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static short setShort(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,short newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();            
        try
        {
            TypeNativeShortRuntimeImpl typeDec = (TypeNativeShortRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldShort(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);        
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Short(newValue),stateMgr.getNativeCapable()), ex);
        }        
    }
    
    public static int setInt(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,int newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setInt(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static int setInt(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,int newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex();
        try
        {
            TypeNativeIntegerRuntimeImpl typeDec = (TypeNativeIntegerRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldInt(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);        
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Integer(newValue),stateMgr.getNativeCapable()), ex);
        }            
    }

    public static long setLong(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,long newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setLong(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static long setLong(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,long newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex(); 
        try
        {
            TypeNativeLongRuntimeImpl typeDec = (TypeNativeLongRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldLong(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Long(newValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
    public static float setFloat(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,float newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setFloat(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static float setFloat(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,float newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex(); 
        try
        {
            TypeNativeFloatRuntimeImpl typeDec = (TypeNativeFloatRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldFloat(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);        
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Float(newValue),stateMgr.getNativeCapable()), ex);
        }              
    }
    
    public static double setDouble(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,double newValue,int unFetchMode)
    {
        synchronized (obj)
        { 
            NativeStateManager stateMgr = obj.jnieasyGetNativeStateManager();        
            if ((stateMgr == null)||(unFetchMode == UnFetch.NONE)) 
                return newValue;

            NativeManagerImpl.checkUnFetchMode(unFetchMode);      
            return setDouble(obj,classInfo,index,newValue,unFetchMode,stateMgr);
        }
    }
    
    public static double setDouble(NativeCapable obj,NativeMultipleFieldContainerDescriptor classInfo,int index,double newValue,int unFetchMode,NativeStateManager stateMgr)
    {
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl attInfo = ((JavaClassAsNativeMultipleFieldContainerRuntimeImpl)classInfo).getFieldDescriptor(index);
        long offset = attInfo.getOffset();
        int fieldIndex = attInfo.getAbsIndex(); 
        try
        {
            TypeNativeDoubleRuntimeImpl typeDec = (TypeNativeDoubleRuntimeImpl)attInfo.getVarTypeNativeRuntime().getTypeNativeRuntime();
            typeDec.setFieldDouble(fieldIndex,offset,newValue,(NativeMultipleFieldContainerCustomStateManagerImpl)stateMgr);        
            return newValue;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex,attInfo.getName(),new Double(newValue),stateMgr.getNativeCapable()), ex);
        }            
    }
    
}
