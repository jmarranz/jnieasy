/*
 * TypeNativeObjectDefaultImpl.java
 *
 * Created on 7 de marzo de 2005, 11:23
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeObjectDefaultRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeObjectDefaultXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;


public class TypeNativeObjectDefaultImpl extends TypeNativeObjectImpl
{
    protected TypeNativeCapableDefaultImpl defaultType;
    
    /**
     * Creates a new instance of TypeNativeObjectDefaultImpl
     */
    public TypeNativeObjectDefaultImpl(ClassTypeNativeObjectDefaultImpl dataType)
    {
        super(dataType);
        
        this.defaultType = (TypeNativeCapableDefaultImpl)dataType.getClassTypeNativeCapableDefault().newTypeNativeCapableDefault();     
    }
    
    public TypeNativeCapableDefaultImpl getTypeNativeCapableDefault()
    {
        return defaultType;
    }
    
    public String getDeclarationStringComplement()
    {
        return "";
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeObjectDefaultRuntimeImpl(this,javaClass,ctx);        
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeObjectDefaultRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeObjectDefaultXML(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        throw new JNIEasyException("Bad syntax");
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeObjectDefaultImpl(this);
    }

}
