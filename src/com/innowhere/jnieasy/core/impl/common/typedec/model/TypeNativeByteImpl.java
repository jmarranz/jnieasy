/*
 * TypeNativeByteImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeByteImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeByteRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeByteRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public class TypeNativeByteImpl extends TypeNativeNumberImpl
{
    
    /**
     * Creates a new instance of TypeNativeByteImpl
     */
    public TypeNativeByteImpl(ClassTypeNativeByteImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeByteRender(this);
    }     
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeByteRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }    
}
