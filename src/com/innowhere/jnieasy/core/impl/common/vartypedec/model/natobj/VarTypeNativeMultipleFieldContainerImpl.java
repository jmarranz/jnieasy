/*
 * VarTypeNativeMultipleFieldContainerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeVarConvInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.natobj.VarTypeNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativeMultipleFieldContainerImpl extends VarTypeNativeFieldContainerImpl
{
    protected VarTypeNativeVarConvInfo varConvInfo = new VarTypeNativeVarConvInfo(this);
    
    /**
     * Creates a new instance of VarTypeNativeMultipleFieldContainerImpl
     */
    public VarTypeNativeMultipleFieldContainerImpl(TypeNativeMultipleFieldContainerImpl typeDec)
    {
        super(typeDec);
    }
    
    public void checkReturnDecByValue()
    {
        // El retorno por valor de estructuras es complejo
        // a nivel de ensamblador, depende del tamaño hace
        // uso de la pila a veces sí a veces no 
        // Por ejemplo: si la estructura tiene el tamaño 1,2 y 4
        // no usa la pila, en el caso 3 sí, un infierno
        // De todas formas es enormemente raro que una DLL
        // exporte un método que retorne una estructura por valor 
        throw new JNIEasyException("Structures and classes cannot be returned by value");
    }        
   
    public int getVarConvIfNotAsterisk()
    {
        // Redefinimos en el caso de clases y estructuras
        // Tenemos claro que es por valor
        return VarTypeNative.BY_VALUE; 
    }     
        
    public int getDefaultVarConv()
    {
        return VarTypeNative.BY_PTR;
    }        
    
    public boolean isFixedVarConv()
    {
        // Se admiten los dos modos
        
        return false;
    }    
    
    public int getVarConv()
    {
        return varConvInfo.getVarConv();
    }
    
    public void setVarConv(int varConv)
    {
        varConvInfo.setVarConv(varConv);
    }

    public String getDeclarationString()
    {
        String dec = typeDec.getDeclarationString();
        if (getVarConv() == VarTypeNative.BY_PTR) 
            dec += "*";
        return dec;
    }

    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeMultipleFieldContainerRuntimeImpl(this,(TypeNativeMultipleFieldContainerRuntimeImpl)typeDecRt);
    }
}
