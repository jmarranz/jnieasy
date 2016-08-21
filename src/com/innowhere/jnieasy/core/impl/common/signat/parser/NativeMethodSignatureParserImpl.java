/*
 * NativeMethodSignatureParserImpl.java
 *
 * Created on 2 de junio de 2005, 21:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;
import com.innowhere.jnieasy.core.impl.TaskContext;

/**
 *
 * @author jmarranz
 */
public abstract class NativeMethodSignatureParserImpl extends NativeBehaviorSignatureParserImpl
{
    
    /**
     * Creates a new instance of NativeMethodSignatureParserImpl
     */
    public NativeMethodSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }
    
}
