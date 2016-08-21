/*
 * NativeStaticMethodSignatureParserImpl.java
 *
 * Created on 2 de junio de 2005, 21:46
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.util.ParenthesisBlock;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.parser.VarTypeNativeParserImpl;

/**
 *
 * @author jmarranz
 */
public class NativeStaticMethodSignatureParserImpl extends NativeMethodSignatureParserImpl
{
    
    /**
     * Creates a new instance of NativeStaticMethodSignatureParserImpl
     */
    public NativeStaticMethodSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }

    public NativeBehaviorSignatureImpl newBehaviorSignature()
    {    
        return new NativeStaticMethodSignatureImpl(ctx.getJNIEasy());
    }

}
