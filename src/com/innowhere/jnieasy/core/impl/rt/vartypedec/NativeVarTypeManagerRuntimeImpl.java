/*
 * DeclareType.java
 *
 * Created on 10 de enero de 2005, 21:34
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContextUsingImports;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class NativeVarTypeManagerRuntimeImpl implements NativeVarTypeManager
{
    protected RuntimeManagerImpl rtMgr;
    
    /** Creates a new instance of DeclareType */
    public NativeVarTypeManagerRuntimeImpl(RuntimeManagerImpl rtMgr)
    {
        this.rtMgr = rtMgr;
    }

    public RuntimeContextUsingImports getRuntimeContext(String[] importList)
    {
        return rtMgr.getRuntimeContext(importList);
    }  
    
    public NativeTypeManagerRuntimeImpl getTypeManagerRuntime()    
    {
        return rtMgr.getTypeManagerRuntime();        
    }    
    
    public NativeTypeManager getTypeManager()    
    {
        return rtMgr.getTypeManagerRuntime();        
    }
    
    public VarTypeNative dec(String decExpr)
    {
        return dec(decExpr,null);
    }
    
    public VarTypeNative dec(String decExpr,String[] importList)
    {
        return VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(decExpr, getRuntimeContext(importList));
    }    
    
    public VarTypeNative dec(Class clasz,int varConv)
    {
        TypeNative typeDec = getTypeManager().dec(clasz);
        return typeDec.decVarType(varConv);
    }    
    
    public VarTypeNative dec(Class clasz)
    {
        TypeNative typeDec = getTypeManager().dec(clasz);
        return typeDec.decVarType();
    }    
    
    public VarTypeNative dec(TypeNative typeDec,int varConv)
    {
        return typeDec.decVarType(varConv);
    }
    
    public VarTypeNative dec(TypeNative typeDec)
    {
        return typeDec.decVarType();
    }    
}
