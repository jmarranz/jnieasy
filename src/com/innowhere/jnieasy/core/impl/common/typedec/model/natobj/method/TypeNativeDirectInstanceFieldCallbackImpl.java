/*
 * TypeNativeDirectInstanceFieldCallbackImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectInstanceFieldCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeInstanceFieldMethodSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeDirectInstanceFieldCallbackRuntimeImpl;



public class TypeNativeDirectInstanceFieldCallbackImpl extends TypeNativeDirectFieldCallbackImpl
{
    /**
     * Creates a new instance of TypeNativeDirectInstanceFieldCallbackImpl
     */
    public TypeNativeDirectInstanceFieldCallbackImpl(ClassTypeNativeDirectInstanceFieldCallbackImpl dataType)
    {
        super(dataType);
    }
 
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeDirectInstanceFieldCallbackRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }        
        
    public NativeBehaviorSignatureImpl checkSignature(NativeBehaviorSignatureImpl signature)
    {
        return (NativeInstanceFieldMethodSignatureImpl)signature;
    }
       
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()      
    {
        return NativeInstanceFieldMethodSignatureXML.newInstanceFieldMethodSignatureXML();
    }     
}
