/*
 * BehaviorOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:41
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

import java.io.*;

import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.BehaviorOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.render.signat.NativeBehaviorSignatureGenRender;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;

public abstract class BehaviorOfClassGenRender extends MemberOfClassGenRender
{
    protected NativeBehaviorSignatureGenRender signatureGenRender;
            
    /**
     * Creates a new instance of BehaviorOfClassGenRender 
     */
    public BehaviorOfClassGenRender(BehaviorOfClassGen accessObject)
    {
        super(accessObject);

        NativeBehaviorSignatureImpl sig = accessObject.getBehaviorOfClass().getBehaviorSignature();
        NativeBehaviorSignatureRender sigRender = NativeBehaviorSignatureRender.newBehaviorSignatureRender(sig);
        
        this.signatureGenRender = new NativeBehaviorSignatureGenRender(sigRender);
    }
    
    public static BehaviorOfClassGenRender newBehaviorOfClassGenRender(BehaviorOfClassGen accessObject)
    {
        return (BehaviorOfClassGenRender)newMemberOfClassGenRender(accessObject);
    }
    
    public BehaviorOfClassGen getBehaviorOfClassGen()
    {
        return (BehaviorOfClassGen)accessObject;
    }
    
    public abstract String getFinderMethodName();

  
    public abstract String getAddMethodClassName();
    
    public StringBuffer generate()
    {
        BehaviorOfClassGen methodGen = getBehaviorOfClassGen();

        StringBuffer code = new StringBuffer();
        code.append( "    public " + getModifier() + " " + getHeaderReturnClassName() + " " + getMethodName() + "(" + generateParamDeclarations() + ") \n" );
        code.append( "    { \n" );
        code.append( "        " + NativeBehavior.class.getName() + " jnieasyMethod = jnieasyMethodList[" + methodGen.getIndex() + "]; \n" );
        code.append( "        if (jnieasyMethod == null)  \n" );
        code.append( "        { \n" );
        code.append( "            String jnieasyFuncName = \"" + methodGen.getBehaviorOfClass().getNativeNameExpr() + "\"; \n" );
        code.append( "            jnieasyMethod = jnieasyMethodList[" + methodGen.getIndex() + "] = jnieasyDLL." + getAddMethodClassName() + "(jnieasyFuncName, \n" );
        if (this instanceof InstanceMethodOfClassGenRender)
        {
        String thisClassDec = ((InstanceMethodOfClassGenRender)this).getThisClassDec();
        code.append( "                " + thisClassDec + " \n" ); 
        }
        String retClass = getReturnTypeClassExp();
        if (!retClass.equals(""))
        {        
        code.append( "                " + retClass + " \n" );        
        }
        code.append( "                " + getParameterDecArgList() );
        code.append( "                " + getCallConvExpr() + " \n" );   
        code.append( "                ); \n" );
        code.append( "        } \n" ); 
        code.append( "        " + getCallAndReturnSentence("jnieasyMethod") + " \n" );
        code.append( "    } \n" ); 
        
        return code;
    }
    
    public abstract String getMethodName();
    
    public String getCallConvExpr()
    {
        return signatureGenRender.getCallConvExpr();
    }
    
    public String getHeaderReturnClassName()
    {
        // ojo se redefine
        return signatureGenRender.getHeaderReturnClassName();
    }
    
    public StringBuffer generateParamDeclarations()
    {
        return signatureGenRender.generateParamDeclarations();
    }
    
    public StringBuffer getParameterDecArgList()
    {
        return signatureGenRender.getParameterDecArgList();
    }
        
    public abstract String getReturnTypeClassExp();

    public String getCallAndReturnSentence(String methodRef)
    {
        return signatureGenRender.getCallAndReturnSentence(methodRef);
    }
    
    public abstract String getModifier();    
}
