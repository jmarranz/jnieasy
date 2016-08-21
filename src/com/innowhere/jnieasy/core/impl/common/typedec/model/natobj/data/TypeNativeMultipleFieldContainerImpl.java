/*
 * TypeNativeMultipleFieldContainerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeMultipleFieldContainerRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativeMultipleFieldContainerXML;

public class TypeNativeMultipleFieldContainerImpl extends TypeNativeFieldContainerImpl
{
    /**
     * Creates a new instance of TypeNativeMultipleFieldContainerImpl
     */
    public TypeNativeMultipleFieldContainerImpl(ClassTypeNativeMultipleFieldContainerImpl dataType)
    {
        super(dataType);
    }

    public ClassTypeNativeMultipleFieldContainerImpl getClassTypeMultipleFieldContainer()
    {
        return (ClassTypeNativeMultipleFieldContainerImpl)dataType;
    }
    
    public String getDeclarationStringComplement()
    {    
        return "";
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeMultipleFieldContainerRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeMultipleFieldContainerXML(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        throw new JNIEasyException("Bad syntax");
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeMultipleFieldContainerImpl(this);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeMultipleFieldContainerRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }     
    
}
