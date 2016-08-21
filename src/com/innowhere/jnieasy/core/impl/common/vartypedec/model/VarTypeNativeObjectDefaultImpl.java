/*
 * VarTypeNativeObjectDefaultImpl.java
 *
 * Created on 7 de marzo de 2005, 11:23
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.natobj.VarTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeObjectDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.*;


public class VarTypeNativeObjectDefaultImpl extends VarTypeNativeObjectImpl
{
    protected VarTypeNativeCapableDefaultImpl defaultVarType;

    
    /**
     * Creates a new instance of VarTypeNativeObjectDefaultImpl
     */
    public VarTypeNativeObjectDefaultImpl(TypeNativeObjectDefaultImpl typeDec)
    {
        super(typeDec);
        
        this.defaultVarType = (VarTypeNativeCapableDefaultImpl)VarTypeNativeImpl.newVarTypeNative(typeDec.getTypeNativeCapableDefault());
    }

    public boolean isFixedVarConv()
    {
        // S�lo se admite por referencia porque no conocemos
        // el tama�o del tipo hasta que es pasado el valor
        // Esto supone que si es por valor el m�todo no puede calcular el tama�o
        // del stack al declararse (antes de llamarse) o el tama�o
        // del atributo en una clase o estructura
        // Dar�a error al intentar obtener el tama�o, pero nos
        // anticipamos as� y damos un error m�s claro.        
        
        return true;
    }        
        
    public int getDefaultVarConv()
    {
        return VarTypeNative.BY_PTR;
    }    
    
    public void setVarConv(int varConv)
    {
        VarTypeNativeVarConvInfo.checkIsVarConvValid(varConv, this);
        // es por referencia siempre, no guardamos
    }
    
    public int getVarConv()
    {
        return getDefaultVarConv();
    }    
    
    public String getDeclarationString()
    {
        // Ponemos el * para indicar que es SIEMPRE por referencia
        return typeDec.getDeclarationString() + "*";
    }    

    
    public boolean needAuxNativeCapable()
    {
        // Si porque puede ser el atributo un objeto no nativo 
        return true;
    }    
    
    public VarTypeNativeCapableDefaultImpl getVarTypeNativeCapableDefault()
    {
        return defaultVarType;
    }

    public VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx)
    {
        return new VarTypeNativeObjectDefaultRuntimeImpl(this,(TypeNativeObjectDefaultRuntimeImpl)typeDecRt,ctx);
    }

}
