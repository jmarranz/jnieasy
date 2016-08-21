/*
 * TypeNativeInstanceFieldMethodReflectionWrapperImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeInstanceFieldMethodReflectionWrapperXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeInstanceFieldMethodReflectionWrapperRuntimeImpl;




public class TypeNativeInstanceFieldMethodReflectionWrapperImpl extends TypeNativeFieldMethodReflectionWrapperImpl
{
    /**
     * Creates a new instance of TypeNativeInstanceFieldMethodReflectionWrapperImpl
     */
    public TypeNativeInstanceFieldMethodReflectionWrapperImpl(ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }    
 
    public TypeNativeInstanceFieldMethodReflectionWrapperImpl(ClassTypeNativeInstanceFieldMethodReflectionWrapperImpl dataType,TypeNativeFieldMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    } 
    
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeInstanceFieldMethodSignatureImpl)signature;
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeInstanceFieldMethodReflectionWrapperXML(this);
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeInstanceFieldMethodReflectionWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }     
        
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()      
    {
        return NativeInstanceFieldMethodSignatureXML.newInstanceFieldMethodSignatureXML();
    }     
}
