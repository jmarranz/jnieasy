/*
 * VarTypeNativeImpl.java
 *
 * Created on 7 de mayo de 2005, 16:56
 */

package com.innowhere.jnieasy.core.impl.common.vartypedec.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec.VarTypeNativeEnhancerRender;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.vartypedec.render.VarTypeNativeRender;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.xml.VarTypeNativeXML;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public abstract class VarTypeNativeImpl
{
    protected TypeNativeImpl typeDec;
    
    /**
     * Creates a new instance of VarTypeNativeImpl
     */
    public VarTypeNativeImpl(TypeNativeImpl typeDec)
    {
        this.typeDec = typeDec;
    }
    
    public TypeNativeImpl getTypeNative()
    {
        return typeDec;
    }
    
    public abstract int getVarConv();
    public abstract void setVarConv(int varConv);
    public abstract int getDefaultVarConv();   
    public abstract boolean isFixedVarConv();
    
    public boolean isVarConvValid(int varConv)
    {
        if (isFixedVarConv())
            return varConv == getDefaultVarConv(); 
        else
            return true;
    }        
    
    public boolean byValue()
    {
        return (getVarConv() == VarTypeNative.BY_VALUE);
    }
    
    public boolean byPointer()
    {
        return (getVarConv() == VarTypeNative.BY_PTR);
    }
   
    public int getVarConvIfNotAsterisk()
    {
        // Redefinir en el caso de clases y estructuras y arrays
        return getDefaultVarConv();
    }   
    
    public void checkReturnDecByValue()
    {
        // Chequea si es válido retornar por valor en un tipo de datos
        // que admite paso de parámetros por valor.
        // Se supone que es válido el paso por valor
        // de parámetros 
        // se trata de ver si es válido el retorno
        // Derivar cuando sea necesario (estructuras y
        // clases y arrays)
    }
    
    public boolean equals(Object obj)
    {    
        if (obj == null) return false;        
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        // Aunque sean objetos diferentes los consideramos iguales
        // si coincide clase y convencionalismo
        VarTypeNativeImpl varType2 = (VarTypeNativeImpl)obj;
        if (getVarConv() != varType2.getVarConv())
            return false;        
        if (!typeDec.equals(varType2.typeDec))
            return false;
        return true;
    }    
    
    public void check()
    {
        // Derivar cuando sea apropiado (caso de ArrayWrapper)
        typeDec.check();
    }    
    
    public boolean isVarArgs()
    {
        // Redefinir
        return false;
    }

    public void setVarArgs(boolean varArgs)
    {
        // Redefinir        
        if (varArgs)
        {    
            throw new JNIEasyException("Only Java array types can be declared as varargs");                     
        }
    }    
    
    public abstract String getDeclarationString();
    
   
    public static VarTypeNativeImpl newVarTypeNative(ClassTypeNativeImpl dataType)    
    {    
        return newVarTypeNative(TypeNativeImpl.newTypeNative(dataType));
    }    
    
    public static VarTypeNativeImpl newVarTypeNative(TypeNativeImpl typeDec)
    {
        return typeDec.newVarTypeNative();
    }
    
   
    public VarTypeNativeXML newVarTypeNativeXML(TypeNativeXML typeDecXML)
    {
        return new VarTypeNativeXML(this,typeDecXML);
    }  
        
    public abstract boolean needAuxNativeCapable();    
    public abstract VarTypeNativeRender newVarTypeNativeRender();
    public abstract VarTypeNativeRuntimeImpl newVarTypeNativeRuntime(TypeNativeRuntimeImpl typeDecRt,RuntimeContext ctx);    
    public abstract VarTypeNativeEnhancerRender newVarTypeNativeEnhancerRender();
}
