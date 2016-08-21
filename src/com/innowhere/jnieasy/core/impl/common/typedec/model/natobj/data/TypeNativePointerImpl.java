/*
 * TypeNativePointerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj.TypeNativePointerParserImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

public abstract class TypeNativePointerImpl extends TypeNativeObjectFieldContainerImpl
{
    protected VarTypeNativeObjectImpl fieldVarType;
            
    /**
     * Creates a new instance of TypeNativePointerImpl
     */
    public TypeNativePointerImpl(ClassTypeNativePointerImpl dataType)
    {
        super(dataType);

        ClassTypeNativeImpl fieldClassType = dataType.getFieldClassType();
        this.fieldVarType = (VarTypeNativeObjectImpl)VarTypeNativeImpl.newVarTypeNative(fieldClassType);
        
        this.fieldVarType.setVarConv(VarTypeNative.BY_PTR);
    }

    public ClassTypeNativePointerImpl getClassTypeNativePointer()
    {
        return (ClassTypeNativePointerImpl)dataType;
    }
    
    public VarTypeNativeObjectImpl getAddressedVarTypeNativeObject()
    {
        return fieldVarType;
    }
    
    public void setAddressedVarTypeNativeObject(VarTypeNativeObjectImpl varTypeDec)
    {
        this.fieldVarType = varTypeDec;
        if (!fieldVarType.byPointer())
            throw new JNIEasyException("Internal pointer must be ever specified by pointer");
        
        // No cambiamos el del ClassTypeNativePointerImpl pues este si es el de por defecto
        // no debe cambiar pues el tipo está registrado junto a su ClassType puntero por defecto
    }    
    
    public String getDeclarationStringComplement()
    {    
        return "{" + fieldVarType.getDeclarationString() + "}";
    }
    
    public void check()
    {
        super.check();
        fieldVarType.check();
    }    
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativePointerImpl(this);
    }
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativePointerParserImpl(this);
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativePointerRuntimeImpl(this,javaClass,ctx);
    }     
}
