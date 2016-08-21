/*
 * ConstructorSignatureParserImpl.java
 *
 * Created on 2 de junio de 2005, 21:53
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.parser;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ThisClassSignatureUtil;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;




/**
 *
 * @author jmarranz
 */
public class ConstructorSignatureParserImpl extends NativeBehaviorSignatureParserImpl
{
    protected ClassTypeNativeMultipleFieldContainerImpl classType;
     
    /** Creates a new instance of ConstructorSignatureParserImpl */
    public ConstructorSignatureParserImpl(TaskContext ctx)
    {
        super(ctx);
    }
    
    public void setClassType(String className)
    {
        try
        {
            NativeConstructorSignatureImpl sig = getConstructorSignature();
            sig.setThisClassType(ThisClassSignatureUtil.decThisClassType(ctx.getClassType(className)));
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Syntax error on method signature declaration:" + className, ex);
        }            
    }

    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)signature;
    }
    
    public NativeBehaviorSignatureImpl newBehaviorSignature()
    {
        return new NativeConstructorSignatureImpl(ctx.getJNIEasy());        
    }

}
