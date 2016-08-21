/*
 * NativeFieldMethodSignatureImpl.java
 *
 * Created on 6 de junio de 2005, 21:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodSignatureImpl extends NativeBehaviorSignatureImpl
{
    
    /**
     * Creates a new instance of NativeFieldMethodSignatureImpl
     */
    public NativeFieldMethodSignatureImpl(JNIEasyImpl jniEasy)
    {
        super(jniEasy);
    }
    
    public abstract boolean isStatic();
    
    public void setFieldDeclaration(ReturnDeclarationImpl fieldType)
    {
        setReturnDeclaration(fieldType);
    }  
    
    public void setReturnDeclaration(ReturnDeclarationImpl returnDec)
    {
        super.setReturnDeclaration(returnDec);

        VarTypeNativeImpl fieldVarType = returnDec.getVarTypeNative();
        
        VarTypeNativeImpl codeType = VarTypeNativeImpl.newVarTypeNative(jniEasy.getClassTypeManager().findClassType("int"));
        super.addParameterDec(new ParameterDecImpl(codeType));
        super.addParameterDec(new ParameterDecImpl(fieldVarType));        
    }        

    public static String formNativeDirectCallbackUniqueClassName(String className,String fieldName)
    {
        return className + "_" + fieldName;
    }       
}
