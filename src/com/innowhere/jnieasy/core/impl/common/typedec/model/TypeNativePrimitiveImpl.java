/*
 * TypeNativePrimitiveImpl.java
 *
 * Created on 2 de febrero de 2005, 11:38
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePrimitiveWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativePrimitiveParserImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativePrimitiveImpl;

public abstract class TypeNativePrimitiveImpl extends TypeNativeImpl
{
    protected String memSizeExpr;
    protected String preferredAlignSizeExpr;
    
    /**
     * Creates a new instance of TypeNativePrimitiveImpl
     */
    public TypeNativePrimitiveImpl(ClassTypeNativePrimitiveImpl dataType)
    {
        super(dataType);
    }
    
    public ClassTypeNativePrimitiveImpl getClassTypeNativePrimitive()
    {
        return (ClassTypeNativePrimitiveImpl)dataType;
    }
    
    public String getDeclarationStringComplement()
    {
        StringBuffer res = new StringBuffer();        
        if ((memSizeExpr != null) || (preferredAlignSizeExpr != null))
        {
            res.append( "{" );
            if (memSizeExpr != null)
                res.append( memSizeExpr );
            if (preferredAlignSizeExpr != null)
                res.append( "," + preferredAlignSizeExpr );
            res.append( "}" );            
        }
        return res.toString();
    }     
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativePrimitiveImpl(this);
    }
    
    public TypeNativePrimitiveWrapperImpl newRelatedTypeNativePrimitiveWrapper()
    {
        ClassTypeNativePrimitiveWrapperImpl classType = getClassTypeNativePrimitive().getClassTypeNativePrimitiveWrapper();
        return classType.newTypeNativePrimitiveWrapper(this);
    }    

    public String getMemSizeExpr()
    {
        return memSizeExpr;
    }

    public void setMemSizeExpr(String memSizeExpr)
    {
        this.memSizeExpr = memSizeExpr;
    }
    
    public String getPreferredAlignSizeExpr()
    {
        return preferredAlignSizeExpr;
    }
    
    public void setPreferredAlignSizeExpr(String preferredAlignSizeExpr)
    {
        this.preferredAlignSizeExpr = preferredAlignSizeExpr;
    }
    
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativePrimitiveParserImpl(this);
    }
}
