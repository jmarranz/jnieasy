/*
 * TypeNativeInstanceFieldCallbackDefaultImpl.java
 *
 * Created on 12 de enero de 2005, 19:11
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeInstanceFieldCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeInstanceFieldMethodSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeInstanceFieldCallbackDefaultRuntimeImpl;




public class TypeNativeInstanceFieldCallbackDefaultImpl extends TypeNativeFieldCallbackDefaultImpl
{
    /**
     * Creates a new instance of TypeNativeInstanceFieldCallbackDefaultImpl
     */
    public TypeNativeInstanceFieldCallbackDefaultImpl(ClassTypeNativeInstanceFieldCallbackDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeInstanceFieldCallbackDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }
    
    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return NativeInstanceFieldMethodSignatureXML.newInstanceFieldMethodSignatureXML();
    }    
}
