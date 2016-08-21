/*
 * MethodOfClassRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 13:42
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ConstructorOfClassImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeConstructor;
import com.innowhere.jnieasy.core.method.DLLBehavior;
import com.innowhere.jnieasy.core.typedec.NativeConstructorDescriptor;
import java.lang.reflect.Constructor;

/**
 *
 * @author jmarranz
 */
public class ConstructorOfClassRuntimeImpl extends BehaviorOfClassRuntimeImpl implements NativeConstructorDescriptor
{
    
    /** Creates a new instance of MethodOfClassRuntimeImpl */
    public ConstructorOfClassRuntimeImpl(JavaClassAsNativeCapableRuntimeImpl javaClass,ConstructorOfClassImpl accessObjectOfClass,Constructor construc,NativeConstructorSignatureRuntimeImpl sig)
    {
        super(javaClass,accessObjectOfClass,construc,sig);
    }
     
    public void init()
    {
        // Nada que hacer
    }
    
    public ConstructorOfClassImpl getConstructorOfClass()
    {
        return (ConstructorOfClassImpl)memberOfClass;
    }
    
    public Constructor getConstructor()
    {
        return (Constructor)member;
    }
    
    public NativeConstructor getNativeConstructor()
    {
        return (NativeConstructor)getNativeBehavior();
    }
    
    public NativeConstructorSignatureRuntimeImpl getConstructorSignatureRuntime()
    {
        return (NativeConstructorSignatureRuntimeImpl)signature;
    }

    public DLLBehavior newDLLBehavior()    
    {
        String nativeName = getNativeName();
        return getDynamicLibrary().addCPPConstructor(nativeName,getConstructorSignatureRuntime());
    }    
}
