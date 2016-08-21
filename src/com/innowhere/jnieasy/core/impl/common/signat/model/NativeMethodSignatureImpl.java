/*
 * NativeMethodSignatureImpl.java
 *
 * Created on 28 de febrero de 2005, 14:56
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;

import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import java.util.ArrayList;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;



/**
 *
 * @author  jmarranz
 */
public abstract class NativeMethodSignatureImpl extends NativeBehaviorSignatureImpl
{
    
    /**
     * Creates a new instance of NativeMethodSignatureImpl
     */
    public NativeMethodSignatureImpl(JNIEasyImpl jniEasy)
    {
        super(jniEasy);
    }              
        
    public static String formNativeDirectCallbackUniqueClassName(String className,String methodName,String[] params)
    {
        return className + "_" + methodName + formUniqueClassNameParams(params);
    }      
    
    public abstract boolean isStatic();
}
