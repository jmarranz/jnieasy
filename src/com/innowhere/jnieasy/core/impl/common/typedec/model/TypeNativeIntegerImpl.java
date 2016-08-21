/*
 * TypeNativeIntegerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeIntegerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeIntegerRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeIntegerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;


public class TypeNativeIntegerImpl extends TypeNativeNumberImpl
{
   
    /**
     * Creates a new instance of TypeNativeIntegerImpl
     */
    public TypeNativeIntegerImpl(ClassTypeNativeIntegerImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeIntegerRender(this);
    }        
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeIntegerRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }    
}
