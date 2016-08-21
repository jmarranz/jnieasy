/*
 * ParameterDecImpl.java
 *
 * Created on 16 de febrero de 2004, 9:46
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.NativeVarTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeParameterDec;
import java.util.ArrayList;

public class ParameterDecRuntimeImpl extends MethodHeaderDeclarationRuntimeImpl implements NativeParameterDec
{
    
    /**
     * Creates a new instance of ParameterDecImpl
     */
    public ParameterDecRuntimeImpl(VarTypeNativeRuntimeImpl varTypeDecRt)
    {
        super(varTypeDecRt,new ParameterDecImpl(varTypeDecRt.getVarTypeNative()));
    }
    
    public ParameterDecRuntimeImpl(VarTypeNativeRuntimeImpl varTypeDecRt,ParameterDecImpl param)
    {
        super(varTypeDecRt,param);
    }
    
    public ParameterDecRuntimeImpl(Class clasz,ParameterDecImpl paramDec,RuntimeContext ctx)
    {
        super(clasz,paramDec, ctx);
    }    
    
    public ParameterDecImpl getParameterDec()
    {
        return (ParameterDecImpl)methodHeaderType;
    }
    
    public Object push(Object arg,NativeBufferIteratorImpl memIt)
    {
        checkValue(arg); // chequea la validez del tipo y de si es válido el nulo            
      
        if (isVarArgs())
        {
            if (arg != null)
                return varTypeRt.pushVarArgs(arg,memIt);
            else
                return null; // En el caso de nulo se considera que no se ha pasado ningún parámetro (igual que si el array tiene 0 elementos).
        }
        else
            return varTypeRt.push(arg,memIt);  // El push puede hacer wrapp y crear un objeto direccionado que tenemos que recoger para que no se pierda por el GC antes de la llamada
    }
    
    public Object pop(NativeBufferIteratorImpl memIt)
    {
        return varTypeRt.pop(memIt);
    }   
    
    public boolean isVarArgs()
    {
        return getParameterDec().isVarArgs();
    }
    
    public void setVarArgs(boolean varArgs)
    {
        getParameterDec().setVarArgs(varArgs);
    }    
    
    public static ParameterDecRuntimeImpl convert(Object param,NativeVarTypeManagerRuntimeImpl varTypeMgr)
    {    
        if (param instanceof NativeParameterDec)
        {
            return (ParameterDecRuntimeImpl)param;
        }
        else
        {
            VarTypeNativeRuntimeImpl varTypeDec = VarTypeNativeRuntimeImpl.convert(param,varTypeMgr);
            return new ParameterDecRuntimeImpl(varTypeDec);
        }            
    }
    
    public static ArrayList convert(Object[] params,NativeVarTypeManagerRuntimeImpl varTypeMgr)
    {
        ArrayList paramsDec = new ArrayList();
        int size = params.length;
        for(int i=0; i < size; i++)
        {
            Object param = params[i];
            paramsDec.add( convert(param, varTypeMgr));
        }
        return paramsDec;
    }    
    
    public static ArrayList getParameterDec(ArrayList paramListRuntime)
    {
        ArrayList params = new ArrayList();
        int size = paramListRuntime.size();
        for(int i=0; i < size; i++)
        {
            ParameterDecRuntimeImpl param = (ParameterDecRuntimeImpl)paramListRuntime.get(i);
            params.add( param.getParameterDec() );
        }
        return params;
    }    
    
}
