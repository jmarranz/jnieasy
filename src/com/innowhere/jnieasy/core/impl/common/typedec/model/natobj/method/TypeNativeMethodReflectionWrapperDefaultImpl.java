/*
 * TypeNativeMethodReflectionWrapperDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeMethodReflectionWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeMethodReflectionWrapperDefaultXML;



public class TypeNativeMethodReflectionWrapperDefaultImpl extends TypeNativeMethodReflectionWrapperImpl
{
    protected boolean isStatic;
    
    /** Creates a new instance of TypeNativeMethodReflectionWrapperDefaultImpl */
    public TypeNativeMethodReflectionWrapperDefaultImpl(ClassTypeNativeMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }        
     
    public TypeNativeMethodReflectionWrapperDefaultImpl(ClassTypeNativeMethodReflectionWrapperImpl dataType,TypeNativeMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }    
    
    public void setStatic(boolean isStatic)
    {
        this.isStatic = isStatic;
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeMethodReflectionWrapperDefaultXML(this);
    }

    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeMethodReflectionWrapperDefaultRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }   

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        if (isStatic)
            return NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
        else
            return NativeInstanceMethodSignatureXML.newInstanceMethodSignatureXML();
    }      
        
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeMethodSignatureImpl)signature;
    }     
}
