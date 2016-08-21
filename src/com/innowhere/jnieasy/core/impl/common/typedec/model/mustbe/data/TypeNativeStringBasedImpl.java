/*
 * ClassTypeNativeStringBasedImpl.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeStringBasedImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeStringBasedParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data.TypeNativeStringBasedXML;

public abstract class TypeNativeStringBasedImpl extends TypeCanBeNativeCapableImpl implements TypeNativeStringBasedInterface
{
    
    /**
     * Creates a new instance of ClassTypeNativeStringBasedImpl
     */
    public TypeNativeStringBasedImpl(ClassTypeNativeStringBasedImpl dataType)
    {
        super(dataType);
    }
    
    public TypeNativeStringBasedImpl(ClassTypeNativeStringBasedImpl dataType,TypeNativeStringBasedWrapperImpl wrapperType)
    {
        super(dataType,wrapperType);
    } 
    
    public TypeNativeStringBasedWrapperImpl getTypeNativeStringBasedWrapper()
    {
        return (TypeNativeStringBasedWrapperImpl)getTypeCanBeNativeCapableWrapper();
    }
    
    public boolean isFixedEncoding()    
    {
        return getTypeNativeStringBasedWrapper().isFixedEncoding();
    }
    
    public int getDefaultEncoding()
    {
        return getTypeNativeStringBasedWrapper().getDefaultEncoding(); // Por defecto
    }
    
    public boolean isValidEncoding(int encoding)
    {
        return getTypeNativeStringBasedWrapper().isValidEncoding(encoding);
    }        

    public String getEncodingExpr()
    {
        return getTypeNativeStringBasedWrapper().getEncodingExpr();
    }    
    
    public void setEncodingExpr(String encodingExpr)
    {
        getTypeNativeStringBasedWrapper().setEncodingExpr(encodingExpr);
    }
    
    public String getDeclarationStringComplement()
    {
        return getTypeNativeStringBasedWrapper().getDeclarationStringComplement();
    }    
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeStringBasedImpl(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeStringBasedXML(this);
    }    
    
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeStringBasedParserImpl(this);
    }
}
