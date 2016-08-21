/*
 * MethodSignature.java
 *
 * Created on 4 de febrero de 2004, 20:19
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.signat.render.NativeBehaviorSignatureRender;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.NativeEnhancerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import com.innowhere.jnieasy.core.typedec.*;
import java.util.ArrayList;
import java.util.List;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;


public abstract class NativeBehaviorSignatureImpl
{
    protected JNIEasyImpl jniEasy;
    protected ReturnDeclarationImpl returnType;
    protected ParameterDecList paramDecList = new ParameterDecList();
    protected int callConv = CallConv.STD_CALL; /* calling convention */
    protected NativeBehaviorSignatureRender signatureRender;    
    
    /** Creates a new instance of MethodSignature */
    public NativeBehaviorSignatureImpl(JNIEasyImpl jniEasy)
    {
        this.jniEasy = jniEasy;
    }    
    
    public int getCallConv()
    {
        return callConv;
    }
    
    public void setCallConv(int callConv)
    {
        CallConvImpl.checkCallConvention(callConv); 
        this.callConv = callConv;
    }
    
    public ParameterDecList getParameterDecList()
    {
        return paramDecList;
    }        
    
    public int getParameterCount()
    {
        return paramDecList.getParameterDecList().size();        
    }
    
    public ParameterDecImpl getParameterDec(int index)
    {
        return paramDecList.getParameterDec(index);
    }    
    
    public void addParameterDec(ParameterDecImpl param)
    {
        paramDecList.addParameterDec(param);
    }
    
    public void addParameterDecList(ArrayList params)
    {
        int size = params.size();
        for(int i = 0; i < size; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)params.get(i);
            addParameterDec(param);
        }
    }    
    
    public List getParameters()    
    {
        return paramDecList.getParameterDecList();
    }    
    
    public ReturnDeclarationImpl getReturnDeclaration()
    {
        return returnType;
    }          
    
    public void setReturnDeclaration(ReturnDeclarationImpl returnType)
    {
        // Se redefine
        this.returnType = returnType;
    }    
    
    public void setReturnVarType(VarTypeNativeImpl varType)
    {
        setReturnDeclaration(new ReturnDeclarationImpl(varType));
    }        
    
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        if (!getClass().equals(obj.getClass()))        
            return false;
        
        // Son distintos objetos pero la signatura puede ser la misma
        // Comparamos sólo el nombre y los parámetros no el retorno, pues para un 
        // nombre dado de método no se permite que dos métodos
        // tengan los mismos parámetros
        // Tampoco comparamos el convencionalismo, pues en C y en C++ no 
        // vale para distinguir dos métodos
        NativeBehaviorSignatureImpl sig2 = (NativeBehaviorSignatureImpl)obj;
        if (!paramDecList.equals(sig2.paramDecList))
            return false;
        return true;
    }    
    
    public void check()
    {
        returnType.check();
        paramDecList.check();        
    }

    
    public NativeBehaviorSignatureRender getBehaviorSignatureRender()
    {
        if (signatureRender == null)
            this.signatureRender = newBehaviorSignatureRender();
        return this.signatureRender;
    }

    public String getSignatureString(String methodName)
    {
        return getBehaviorSignatureRender().getSignatureString(methodName);        
    }         
    
    
    public static String asJavaIdentifier(String className)
    {
        StringBuffer classNameAsId = new StringBuffer();
        for(int pos = 0; pos < className.length(); pos++)
        {
            char c = className.charAt(pos);
            if (!Character.isJavaIdentifierPart(c))
                c = '_';
            classNameAsId.append( c );               
        }
        return classNameAsId.toString();
    }    
    
    public static String formUniqueClassNameParams(String[] params)
    {    
        StringBuffer res = new StringBuffer();
        res.append( "_" ); // equivale al (
        for(int i = 0; i < params.length; i++)
        {
            res.append( asJavaIdentifier(params[i]) );
            if ((i + 1) != params.length)
                res.append( "_" ); // equivale a la ,
        }
        res.append( "_" ); // equivale al )
        return res.toString();
    }        
    
    public abstract int getFirstParamIndex();
    public abstract NativeBehaviorSignatureEnhancerImpl newBehaviorSignatureEnhancer(NativeEnhancerImpl enhancer);
    public abstract NativeBehaviorSignatureRender newBehaviorSignatureRender();
    public abstract NativeBehaviorSignatureRuntimeImpl newBehaviorSignatureRuntime(Class classRet,Class[] classParams,RuntimeContext ctx);    
    public abstract BehaviorOfClassImpl newBehaviorOfClass(ClassTypeNativeCapableImpl containerClassType);
}
