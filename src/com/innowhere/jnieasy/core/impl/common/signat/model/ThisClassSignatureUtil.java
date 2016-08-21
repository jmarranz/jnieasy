/*
 * ThisClassSignatureUtil.java
 *
 * Created on 2 de febrero de 2005, 19:51
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

public class ThisClassSignatureUtil
{
    
    /**
     * Creates a new instance of ThisClassSignatureUtil 
     */
    public ThisClassSignatureUtil()
    {
    }
    
    public static ClassTypeNativeMultipleFieldContainerImpl decThisClassType(ClassTypeNativeImpl dataType)
    {
        if (!(dataType instanceof ClassTypeNativeMultipleFieldContainerImpl))
            throw new JNIEasyException("\"this\" class: " + dataType.getClassName() + " must implement: " + NativeMultipleFieldContainer.class);
        return (ClassTypeNativeMultipleFieldContainerImpl)dataType;
    }

    public static VarTypeNativeImpl decThisVarTypeNative(ClassTypeNativeMultipleFieldContainerImpl dataType)
    {
        VarTypeNativeImpl varType = VarTypeNativeImpl.newVarTypeNative(dataType);
        varType.setVarConv(VarTypeNative.BY_PTR);
        return varType;
    }     
}
