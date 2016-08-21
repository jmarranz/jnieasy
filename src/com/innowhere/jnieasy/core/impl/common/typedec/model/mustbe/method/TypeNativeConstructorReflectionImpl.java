/*
 * TypeNativeConstructorReflectionImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeConstructorReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ConstructorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeConstructorReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method.TypeNativeConstructorReflectionXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;




public class TypeNativeConstructorReflectionImpl extends TypeNativeBehaviorReflectionImpl
{
    /** Creates a new instance of TypeNativeConstructorReflectionImpl */
    public TypeNativeConstructorReflectionImpl(ClassTypeNativeConstructorReflectionImpl dataType)
    {
        super(dataType);
    }    
    
    public TypeNativeConstructorReflectionImpl(ClassTypeNativeConstructorReflectionImpl dataType,TypeNativeConstructorReflectionWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }   
    
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)getBehaviorSignature();
    }    
    
    public void setConstructorSignature(NativeConstructorSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }

    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeConstructorReflectionXML(this);
    }
    
    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeConstructorReflectionRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        return ConstructorSignatureXML.newConstructorSignatureXML();
    }        
}
