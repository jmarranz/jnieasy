/*
 * TypeNativeConstructorCallbackDefaultImpl.java
 *
 * Created on 21 de septiembre de 2005, 13:14
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeConstructorCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeConstructorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.xml.NativeBehaviorSignatureXML;
import com.innowhere.jnieasy.core.impl.common.signat.xml.ConstructorSignatureXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.method.TypeNativeConstructorCallbackDefaultRuntimeImpl;


/**
 *
 * @author jmarranz
 */
public class TypeNativeConstructorCallbackDefaultImpl extends TypeNativeCallbackDefaultImpl
{
    
    /**
     * Creates a new instance of TypeNativeConstructorCallbackDefaultImpl
     */
    public TypeNativeConstructorCallbackDefaultImpl(ClassTypeNativeConstructorCallbackDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public NativeConstructorSignatureImpl getConstructorSignature()
    {
        return (NativeConstructorSignatureImpl)signature;
    }
    
    public void setConstructorSignature(NativeConstructorSignatureImpl signature)
    {
        setBehaviorSignature(signature);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeConstructorCallbackDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }

    public NativeBehaviorSignatureXML newBehaviorSignatureXML()
    {
        return ConstructorSignatureXML.newConstructorSignatureXML();
    }     
}
