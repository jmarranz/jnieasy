/*
 * NativeFieldMethodSignatureParserImpl.java
 *
 * Created on 6 de junio de 2005, 21:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.util.SourceCode;




/**
 *
 * @author jmarranz
 */
public abstract class NativeFieldMethodSignatureParserImpl extends NativeBehaviorSignatureParserImpl
{
    
    /**
     * Creates a new instance of NativeFieldMethodSignatureParserImpl
     */
    public NativeFieldMethodSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }

}
