/*
 * TypeNativeBooleanImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeBooleanImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeBooleanRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeBooleanRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public class TypeNativeBooleanImpl extends TypeNativePrimitiveImpl
{
    /**
     * Creates a new instance of TypeNativeBooleanImpl
     */
    public TypeNativeBooleanImpl(ClassTypeNativeBooleanImpl dataType)
    {
        super(dataType);
    }

    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeBooleanRender(this);
    }        
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeBooleanRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }    
}
