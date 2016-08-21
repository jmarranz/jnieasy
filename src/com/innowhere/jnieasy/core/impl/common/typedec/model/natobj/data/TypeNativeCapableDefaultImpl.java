/*
 * TypeNativeCapableImpl.java
 *
 * Created on 13 de enero de 2005, 14:38
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeCapableDefaultRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativeCapableDefaultXML;

public class TypeNativeCapableDefaultImpl extends TypeNativeCapableImpl
{
    /**
     * Creates a new instance of TypeNativeCapableImpl
     */
    public TypeNativeCapableDefaultImpl(ClassTypeNativeCapableDefaultImpl dataType)
    {
        super(dataType);
    }
    
    public String getDeclarationStringComplement()
    {
        return "";
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeCapableDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }    
 
    public TypeNativeCapableDefaultRuntimeImpl newTypeNativeCapableDefaultRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeCapableDefaultRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeCapableDefaultRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeCapableDefaultXML(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        throw new JNIEasyException("Bad syntax");
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeCapableDefaultImpl(this);
    }
}
