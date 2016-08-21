/*
 * TypeNativeFieldMethodReflectionWrapperDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method.TypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeFieldMethodReflectionWrapperDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.method.TypeNativeFieldMethodReflectionWrapperDefaultXML;




public class TypeNativeFieldMethodReflectionWrapperDefaultImpl extends TypeNativeFieldMethodReflectionWrapperImpl
{
    protected boolean isStatic;
    
    /** Creates a new instance of TypeNativeFieldMethodReflectionWrapperDefaultImpl */
    public TypeNativeFieldMethodReflectionWrapperDefaultImpl(ClassTypeNativeFieldMethodReflectionWrapperImpl dataType)
    {
        super(dataType);
    }        
                     
    public TypeNativeFieldMethodReflectionWrapperDefaultImpl(ClassTypeNativeFieldMethodReflectionWrapperImpl dataType,TypeNativeFieldMethodReflectionImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }  
    
    public void setStatic(boolean isStatic)
    {
        this.isStatic = isStatic;
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeFieldMethodReflectionWrapperDefaultXML(this);
    }

    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeFieldMethodReflectionWrapperDefaultRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }
       
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        if (isStatic)
            return NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
        else
            return NativeInstanceFieldMethodSignatureXML.newInstanceFieldMethodSignatureXML();
    }        
    
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeFieldMethodSignatureImpl)signature;
    }    
}
