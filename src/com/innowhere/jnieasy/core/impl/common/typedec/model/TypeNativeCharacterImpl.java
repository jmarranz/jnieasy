/*
 * TypeNativeCharacterImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeCharacterImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeCharacterRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativePrimitiveOtherXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeCharacterRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public class TypeNativeCharacterImpl extends TypeNativePrimitiveImpl
{
   
    /**
     * Creates a new instance of TypeNativeCharacterImpl
     */
    public TypeNativeCharacterImpl(ClassTypeNativeCharacterImpl dataType)
    {
        super(dataType);
    }
        
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeCharacterRender(this);
    }    
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeCharacterRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativePrimitiveOtherXML(this);
    }    
}
