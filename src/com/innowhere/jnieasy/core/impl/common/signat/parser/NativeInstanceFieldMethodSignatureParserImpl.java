/*
 * NativeInstanceFieldMethodSignatureParserImpl.java
 *
 * Created on 18 de julio de 2005, 19:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ThisClassSignatureUtil;

/**
 *
 * @author jmarranz
 */
public class NativeInstanceFieldMethodSignatureParserImpl extends NativeFieldMethodSignatureParserImpl
{
    
    /**
     * Creates a new instance of NativeInstanceFieldMethodSignatureParserImpl
     */
    public NativeInstanceFieldMethodSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }
    
    public NativeInstanceFieldMethodSignatureImpl getInstanceFieldMethodSignature()
    {
        return (NativeInstanceFieldMethodSignatureImpl)signature;
    }
    
    public void setClassType(String className)
    {
        try
        {
            NativeInstanceFieldMethodSignatureImpl sig = getInstanceFieldMethodSignature();
            sig.setThisClassType(ThisClassSignatureUtil.decThisClassType(ctx.getClassType(className)));
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method signature declaration:" + className, ex);
        }            
    }    
    
    public NativeBehaviorSignatureImpl newBehaviorSignature()
    {
        return new NativeInstanceFieldMethodSignatureImpl(ctx.getJNIEasy());        
    }    
}
