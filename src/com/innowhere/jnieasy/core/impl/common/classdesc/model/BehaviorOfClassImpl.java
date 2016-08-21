/*
 * BehaviorOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:35
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.MemberOfClassRender;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.BehaviorOfClassRender;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.BehaviorOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import java.lang.reflect.Member;
import javassist.CtMember;


public abstract class BehaviorOfClassImpl extends MemberOfClassImpl
{
    protected NativeBehaviorSignatureImpl signature;
    protected ClassTypeNativeCapableImpl containerClassType;  // Es la clase contenedora del método Java sea o no estático  
    protected String nativeNameExpr;
    
    /** Creates a new instance of BehaviorOfClassImpl */
    public BehaviorOfClassImpl(NativeBehaviorSignatureImpl signature,ClassTypeNativeCapableImpl containerClassType)
    {
        this.signature = signature;
        this.containerClassType = containerClassType;
    }
  
    public static BehaviorOfClassImpl newBehaviorOfClass(NativeBehaviorSignatureImpl sig,ClassTypeNativeCapableImpl containerClassType)
    {
        return sig.newBehaviorOfClass(containerClassType);
    }
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return signature;
    }
  
    public void setBehaviorSignature(NativeBehaviorSignatureImpl signature)
    {
        this.signature = signature;
    }    
    /**
     * Getter for property containerClassType.
     * @return Value of property containerClassType.
     */
    public ClassTypeNativeCapableImpl getClassTypeNativeCapable()
    {
        return containerClassType;
    }

    public abstract BehaviorOfClassRuntimeImpl newBehaviorOfClassRuntime(JavaClassAsNativeCapableRuntimeImpl javaClass,Member member,NativeBehaviorSignatureRuntimeImpl sig);
    public abstract BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer javaClassEnh);
    
    public String getNativeNameExpr()    
    {
        if (nativeNameExpr != null) 
            return nativeNameExpr;
        else
            return getName();
    }    
    
    public void setNativeNameExpr(String nativeNameExpr)
    {
        this.nativeNameExpr = nativeNameExpr;
    }
        
    public MemberOfClassRender newMemberOfClassRender()
    {
        return new BehaviorOfClassRender(this);
    }        
}
