/*
 * NativeStaticFieldMethodSignatureParserImpl.java
 *
 * Created on 18 de julio de 2005, 19:11
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;

/**
 *
 * @author jmarranz
 */
public class NativeStaticFieldMethodSignatureParserImpl extends NativeFieldMethodSignatureParserImpl
{
    
    /**
     * Creates a new instance of NativeStaticFieldMethodSignatureParserImpl
     */
    public NativeStaticFieldMethodSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }

    public NativeBehaviorSignatureImpl newBehaviorSignature()
    {    
        return new NativeStaticFieldMethodSignatureImpl(ctx.getJNIEasy());
    }
}
