/*
 * RuntimeManagerImpl.java
 *
 * Created on 5 de julio de 2005, 20:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeSignatureManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.dll.DLLManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.util.NativeCapableFactoryImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeTypeNativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeSignatureManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.NativeVarTypeManagerRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class RuntimeManagerImpl
{
    protected JNIEasyImpl jniEasy;
    protected NativeTypeManagerRuntimeImpl typeDecMgrRt;
    protected NativeSignatureManagerRuntimeImpl sigDecMgrRt; 
    protected NativeVarTypeManagerRuntimeImpl varTypeMgr = new NativeVarTypeManagerRuntimeImpl(this);    
    protected NativeManagerImpl nativeManager = new NativeManagerImpl(this);    
    protected DLLManagerImpl dllManager = new DLLManagerImpl(this);    
    protected NativeCapableFactoryImpl natFactory; 
    protected ClassTypeManagerRuntimeImpl classTypeMgrRt;
    protected RuntimeContextUsingImports defaultContextUsingImports;
    protected RuntimeContextNotUsingImports defaultContextNotUsingImports;    
    
    /** Creates a new instance of RuntimeManagerImpl */
    public RuntimeManagerImpl(JNIEasyImpl jniEasy,ClassTypeManagerImpl dataTypeMgr,NativeTypeNativeManagerImpl typeDecMgr,NativeSignatureManagerImpl sigDecMgr)
    {
        this.jniEasy = jniEasy;
        this.classTypeMgrRt = new ClassTypeManagerRuntimeImpl(this,dataTypeMgr);
        this.typeDecMgrRt = new NativeTypeManagerRuntimeImpl(this,typeDecMgr);
        this.sigDecMgrRt = new NativeSignatureManagerRuntimeImpl(this,sigDecMgr); 
        this.natFactory = new NativeCapableFactoryImpl(typeDecMgrRt);                        
        this.defaultContextUsingImports = new RuntimeContextUsingImports(this,new String[0]); 
        this.defaultContextNotUsingImports = new RuntimeContextNotUsingImports(this);         
    }
    
    public JNIEasyImpl getJNIEasy()
    {
        return jniEasy;
    }
    
    public NativeTypeManagerRuntimeImpl getTypeManagerRuntime()
    {
        return typeDecMgrRt;
    }
    
    public NativeVarTypeManagerRuntimeImpl getVarTypeManagerRuntime()
    {
        return varTypeMgr;
    }
    
    public NativeSignatureManagerRuntimeImpl getSignatureManagerRuntime()
    {
        return sigDecMgrRt;
    }
    
    public ClassTypeManagerRuntimeImpl getClassTypeManagerRuntime()
    {
        return classTypeMgrRt;
    }    
    
    public RuntimeContextUsingImports getDefaultRuntimeContextUsingImports()
    {
        return defaultContextUsingImports;
    }
    
    public void setDefaultRuntimeContextUsingImports(String[] importList)
    {
        this.defaultContextUsingImports = new RuntimeContextUsingImports(this, importList);
    }    
    
    public RuntimeContextNotUsingImports getDefaultRuntimeContextNotUsingImports()
    {
        return defaultContextNotUsingImports;
    }    
    
    public RuntimeContextUsingImports getRuntimeContext(String[] importList)
    {    
        if (importList == null)
            return getDefaultRuntimeContextUsingImports();
        else
            return new RuntimeContextUsingImports(this, importList);
    }
    
    public NativeManagerImpl getNativeManager()
    {
        return nativeManager;
    }
    
    public DLLManagerImpl getDLLManager()
    {
        return dllManager;
    }
    
    public NativeCapableFactoryImpl getNativeCapableFactory()
    {
        return natFactory;
    }

}
