/*
 * TypeNativeFloatImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeFloatImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeFloatRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeFloatRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public class TypeNativeFloatImpl extends TypeNativeNumberImpl
{
   
    /**
     * Creates a new instance of TypeNativeFloatImpl
     */
    public TypeNativeFloatImpl(ClassTypeNativeFloatImpl dataType)
    {
        super(dataType);
    }
        
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeFloatRender(this);
    }    
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeFloatRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }    
}
