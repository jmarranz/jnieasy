/*
 * NativeInstanceMethodSignatureParserImpl.java
 *
 * Created on 2 de junio de 2005, 21:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ThisClassSignatureUtil;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceMethodSignatureImpl;


/**
 *
 * @author jmarranz
 */
public class NativeInstanceMethodSignatureParserImpl extends NativeMethodSignatureParserImpl
{
    /**
     * Creates a new instance of NativeInstanceMethodSignatureParserImpl
     */
    public NativeInstanceMethodSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }
    
    public NativeInstanceMethodSignatureImpl getInstanceMethodSignature()
    {
        return (NativeInstanceMethodSignatureImpl)signature;
    }
    
    public void setClassType(String className)
    {
        try
        {
            NativeInstanceMethodSignatureImpl sig = getInstanceMethodSignature();
            sig.setThisClassType(ThisClassSignatureUtil.decThisClassType(ctx.getClassType(className)));
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method signature declaration:" + className, ex);
        }            
    }    
    
    public NativeBehaviorSignatureImpl newBehaviorSignature()
    {
        return new NativeInstanceMethodSignatureImpl(ctx.getJNIEasy());        
    }
}
