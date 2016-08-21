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
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldMethodOfClassImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.method.DLLBehavior;
import com.innowhere.jnieasy.core.method.NativeFieldMethod;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodDescriptor;
import java.lang.reflect.Field;

/**
 *
 * @author jmarranz
 */
public class FieldMethodOfClassRuntimeImpl extends BehaviorOfClassRuntimeImpl implements NativeFieldMethodDescriptor
{
    
    /** Creates a new instance of MethodOfClassRuntimeImpl */
    public FieldMethodOfClassRuntimeImpl(JavaClassAsNativeCapableRuntimeImpl javaClass,FieldMethodOfClassImpl accessObjectOfClass,Field field,NativeFieldMethodSignatureRuntimeImpl sig)
    {
        super(javaClass,accessObjectOfClass,field,sig);
    }
    
    public void init()
    {
        getFieldMethodOfClass().setName(getField().getName());
    }
    
    public NativeFieldMethodSignatureRuntimeImpl getFieldMethodSignatureRuntime()
    {
        return (NativeFieldMethodSignatureRuntimeImpl)signature;
    }
    
    public FieldMethodOfClassImpl getFieldMethodOfClass()
    {
        return (FieldMethodOfClassImpl)memberOfClass;
    }
    
    public Field getField()
    {
        return (Field)member;
    }
    
    public NativeFieldMethod getNativeFieldMethod()
    {
        return (NativeFieldMethod)getNativeBehavior();
    }
    
    public DLLBehavior newDLLBehavior()    
    {
        // Sólo existe el caso estático        
        String nativeName = getNativeName();
        return getDynamicLibrary().addCFieldMethod(nativeName,(NativeStaticFieldMethodSignatureRuntimeImpl)getFieldMethodSignatureRuntime());
    }    
}

    