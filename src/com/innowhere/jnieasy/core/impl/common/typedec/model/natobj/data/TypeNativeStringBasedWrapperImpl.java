/*
 * ClassTypeNativeStringBasedWrapperImpl.java
 *
 * Created on 11 de febrero de 2005, 11:54
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeStringBasedParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeStringInfoRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.natobj.data.TypeNativeStringBasedWrapperXML;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeStringBasedWrapperImpl;

public abstract class TypeNativeStringBasedWrapperImpl extends TypeCanBeNativeCapableWrapperImpl implements TypeNativeStringBasedInterface
{
    protected String encodingExpr;
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedWrapperImpl
     */
    public TypeNativeStringBasedWrapperImpl(ClassTypeNativeStringBasedWrapperImpl dataType)
    {
        super(dataType);
    }
                     
    public TypeNativeStringBasedWrapperImpl(ClassTypeNativeStringBasedWrapperImpl dataType,TypeNativeStringBasedImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }
    
    public TypeNativeStringBasedImpl getTypeNativeStringBased()
    {
        return (TypeNativeStringBasedImpl)getTypeCanBeNativeCapable();
    }
    
    public String getEncodingExpr()
    {
        return encodingExpr;
    }
    
    public void setEncodingExpr(String encodingExpr)
    {
        this.encodingExpr = encodingExpr;       
    }    
    
    public String getDeclarationStringComplement()
    {
        return TypeNativeStringInfoRender.getDeclarationStringComplement(this);
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeStringBasedWrapperImpl(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeStringBasedWrapperXML(this);
    }        
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeStringBasedParserImpl(this);
    }    
}
