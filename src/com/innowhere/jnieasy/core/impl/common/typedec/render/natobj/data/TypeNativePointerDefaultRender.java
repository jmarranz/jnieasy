/*
 * TypeNativePointerDefaultRender.java
 *
 * Created on 30 de septiembre de 2005, 12:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeObjectRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;

/**
 *
 * @author jmarranz
 */
public class TypeNativePointerDefaultRender extends TypeNativePointerRender
{
    protected VarTypeNativeObjectRender ptrRender;
            
    /**
     * Creates a new instance of TypeNativePointerDefaultRender
     */
    public TypeNativePointerDefaultRender(TypeNativePointerDefaultImpl typeDec)
    {
        super(typeDec);
        
        this.ptrRender = (VarTypeNativeObjectRender)VarTypeNativeRender.newVarTypeNativeRender(typeDec.getAddressedVarTypeNativeObject());
    }
  
    public String getDeclaredClassName(boolean enhancer)
    {
        // Se redefine porque no se necesita
        return "";
    }    
    
    public String getDecOtherParams(boolean enhancer)
    {        
        return ptrRender.getDeclareVarTypeCallString(enhancer);
    }
  
    public String getDeclareTypeMethodName()
    {
        return "decPointer";
    }        
        
    public String getDeclareComponentTypeCall(boolean enhancer)
    {
        return "";
    }       
}
