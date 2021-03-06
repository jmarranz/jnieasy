/*
 * TypeNativeInstanceMethodCallbackDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeInstanceMethodCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeInstanceMethodCallbackDefaultRuntimeImpl;




public class TypeNativeInstanceMethodCallbackDefaultImpl extends TypeNativeMethodCallbackDefaultImpl
{
    /**
     * Creates a new instance of TypeNativeInstanceMethodCallbackDefaultImpl
     */
    public TypeNativeInstanceMethodCallbackDefaultImpl(ClassTypeNativeInstanceMethodCallbackDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeInstanceMethodCallbackDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }    

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeInstanceMethodSignatureXML.newInstanceMethodSignatureXML();
    }    
}
