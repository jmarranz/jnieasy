/*
 * TypeNativeMethodReflectionImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeMethodReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method.TypeNativeMethodReflectionXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;




public class TypeNativeMethodReflectionImpl extends TypeNativeBehaviorReflectionImpl
{
    protected boolean isStatic;
    
    /** Creates a new instance of TypeNativeMethodReflectionImpl */
    public TypeNativeMethodReflectionImpl(ClassTypeNativeMethodReflectionImpl dataType)
    {
        super(dataType);
    }    
    
    public TypeNativeMethodReflectionImpl(ClassTypeNativeMethodReflectionImpl dataType,TypeNativeMethodReflectionWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }   
    
    public void setStatic(boolean isStatic)
    {
        this.isStatic = isStatic;
    }
    
    public TypeNativeMethodReflectionWrapperImpl getTypeNativeMethodReflectionWrapper()
    {
        return (TypeNativeMethodReflectionWrapperImpl)getTypeCanBeNativeCapableWrapper();
    }
    
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeMethodReflectionXML(this);
    }    

    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeMethodReflectionRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }
        
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()    
    {
        if (isStatic)
            return NativeStaticMethodSignatureXML.newStaticMethodSignatureXML();
        else
            return NativeInstanceMethodSignatureXML.newInstanceMethodSignatureXML();
    }        
}
