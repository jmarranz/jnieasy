/*
 * TypeNativeDoubleImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeDoubleImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeDoubleRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeDoubleRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public class TypeNativeDoubleImpl extends TypeNativeNumberImpl
{
    /**
     * Creates a new instance of TypeNativeDoubleImpl
     */
    public TypeNativeDoubleImpl(ClassTypeNativeDoubleImpl dataType)
    {
        super(dataType);
    }
        
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeDoubleRender(this);
    }    
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeDoubleRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }        
}
