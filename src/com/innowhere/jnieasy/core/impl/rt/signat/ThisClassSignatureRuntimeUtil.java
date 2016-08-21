/*
 * ThisClassSignatureUtil.java
 *
 * Created on 2 de febrero de 2005, 19:51
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.ThisClassSignatureUtil;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.*;

public class ThisClassSignatureRuntimeUtil
{
    
    /**
     * Creates a new instance of ThisClassSignatureUtil 
     */
    public ThisClassSignatureRuntimeUtil()
    {
    }

    public static VarTypeNativeRuntimeImpl decThisType(Class classObj,RuntimeContext ctx)
    {        
        ClassTypeNativeMultipleFieldContainerImpl classType = ThisClassSignatureUtil.decThisClassType(ctx.getClassType(classObj));
        return decThisType(classObj,classType,ctx);
    }
        
    public static VarTypeNativeRuntimeImpl decThisType(Class clasz,ClassTypeNativeMultipleFieldContainerImpl classType,RuntimeContext ctx)
    {
        VarTypeNativeImpl classVarType = ThisClassSignatureUtil.decThisVarTypeNative(classType);
        return VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(clasz,classVarType,ctx);
    }    
     
    public static Object[] convertArgs(Object obj,Object[] args)
    {    
        int len = args.length;
        Object[] args2 = new Object[len + 1];
        System.arraycopy(args,0, args2, 1, len);
        args2[0] = obj;  
        return args2;
    }    
}
