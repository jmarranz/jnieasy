/*
 * TypeNativeVoidImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeVoidImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeVoidRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeVoidRuntimeImpl;

public class TypeNativeVoidImpl extends TypeNativePrimitiveImpl
{
   
    /**
     * Creates a new instance of TypeNativeVoidImpl
     */
    public TypeNativeVoidImpl(ClassTypeNativeVoidImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeVoidRender(this);
    }     
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeVoidRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }    
}
