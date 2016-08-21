/*
 * TypeNativeFieldMethodReflectionImpl.java
 *
 * Created on 12 de enero de 2005, 16:59
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.method.ClassTypeNativeFieldMethodReflectionImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeStaticFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeFieldMethodReflectionWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.method.TypeNativeFieldMethodReflectionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.method.TypeNativeFieldMethodReflectionXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;



public class TypeNativeFieldMethodReflectionImpl extends TypeNativeBehaviorReflectionImpl
{
    protected boolean isStatic;
    
    /**
     * Creates a new instance of TypeNativeFieldMethodReflectionImpl
     */
    public TypeNativeFieldMethodReflectionImpl(ClassTypeNativeFieldMethodReflectionImpl dataType)
    {
        super(dataType);
    }    
    
    public TypeNativeFieldMethodReflectionImpl(ClassTypeNativeFieldMethodReflectionImpl dataType,TypeNativeFieldMethodReflectionWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    }   
    
    public void setStatic(boolean isStatic)
    {
        this.isStatic = isStatic;
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeFieldMethodReflectionXML(this);
    }    
    
    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeFieldMethodReflectionRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        if (isStatic)
            return NativeStaticFieldMethodSignatureXML.newStaticFieldMethodSignatureXML();
        else
            return NativeInstanceFieldMethodSignatureXML.newInstanceFieldMethodSignatureXML();
    }  
}
