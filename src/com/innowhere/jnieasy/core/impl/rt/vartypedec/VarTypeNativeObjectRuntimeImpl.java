/*
 * VarTypeNativeObjectRuntimeImpl.java
 *
 * Created on 2 de febrero de 2005, 14:01
 */

package com.innowhere.jnieasy.core.impl.rt.vartypedec;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.AttachCopyContext;
import com.innowhere.jnieasy.core.impl.rt.CloneContext;
import com.innowhere.jnieasy.core.impl.rt.FetchUnFetchContext;
import com.innowhere.jnieasy.core.impl.rt.FieldAccessExceptionUtil;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.statemgr.NativeFieldContainerStateManagerImpl;



public abstract class VarTypeNativeObjectRuntimeImpl extends VarTypeNativeRuntimeImpl
{
    
    /**
     * Creates a new instance of VarTypeNativeObjectRuntimeImpl
     */
    public VarTypeNativeObjectRuntimeImpl(VarTypeNativeObjectImpl varTypeDec,TypeNativeObjectRuntimeImpl typeDecRt)
    {
        super(varTypeDec, typeDecRt);
    }

    public Object getObject(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx)
    {
        try
        {
            return getObject2(fieldIndex,offset,stateMgr,currValue, fetchMode, fetchCtx);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex, currValue,stateMgr.getNativeCapable()), ex);
        }
    }    
    
    public void setObject(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object newValue, int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx)    
    {
        try
        {
            if (stateMgr.getNativeManager().isRuntimeChecking())
                checkValue(newValue);       

            setObject2(fieldIndex,offset,stateMgr,newValue,unFetchMode,unfetchCtx,attachCopyCtx);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex, newValue,stateMgr.getNativeCapable()), ex);
        }        
    }   
    
    public Object clone(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,CloneContext cloneCtx)
    {
        try
        {
            return clone2(fieldIndex,stateMgr, currValue,cloneCtx);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex, currValue,stateMgr.getNativeCapable()), ex);
        }         
    }    
    
    public void detachField(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object fieldValue,int freeMemMode,boolean deep)
    {
        try
        {
            detachField2(fieldIndex,stateMgr,fieldValue, freeMemMode, deep);
        }
        catch(Exception ex)
        {
            throw new JNIEasyException(FieldAccessExceptionUtil.createMessage(fieldIndex, fieldValue,stateMgr.getNativeCapable()), ex);
        }         
    }   
    
    public abstract Object getObject2(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx);
    public abstract void setObject2(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object newValue,int unFetchMode,FetchUnFetchContext unfetchCtx,AttachCopyContext attachCopyCtx);
    public abstract Object clone2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,CloneContext cloneCtx);
    public abstract void detachField2(int fieldIndex,NativeFieldContainerStateManagerImpl stateMgr,Object fieldValue,int freeMemMode,boolean deep);
    public abstract NativeCapableInternal getNativeCapable(int fieldIndex,long offset,NativeFieldContainerStateManagerImpl stateMgr,Object currValue,int fetchMode,FetchUnFetchContext fetchCtx);
}
