/*
 * TypeNativeArrayInfo.java
 *
 * Created on 16 de mayo de 2005, 19:19
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeArrayInfoRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;

/**
 *
 * @author jmarranz
 */
public class TypeNativeArrayInfo
{
    protected TypeNativeArrayImpl typeDec;
    protected int length = -1; // Indefinido por defecto
    protected VarTypeNativeImpl varTypeComp; // A fin de cuentas los componentes de un array son variables
    
    /**
     * Creates a new instance of TypeNativeArrayInfo
     */
    public TypeNativeArrayInfo(TypeNativeArrayImpl typeDec,VarTypeNativeImpl varTypeDecComp)
    {
        this.typeDec = typeDec;
        this.varTypeComp = varTypeDecComp;
        if (varTypeDecComp instanceof VarTypeNativeArrayInterface)
        {
            // Suponemos que en el caso de arrays de arrays el array
            // componente es por valor siempre, no admitimos otra opción
            varTypeDecComp.setVarConv(VarTypeNative.BY_VALUE);
        }      
    }
    
    public VarTypeNativeImpl getComponentVarType()
    {
        return varTypeComp;
    }
    
    public VarTypeNativeImpl getLastComponentVarType()
    {
        // Devuelve el componente último de una matriz multidimensional (si es simple vale igual)
        // que no es array
        if (varTypeComp instanceof VarTypeNativeArrayInterface)
        {
            TypeNativeArrayInterface arrayTypeDec = ((VarTypeNativeArrayInterface)varTypeComp).getTypeNativeArrayInterface();
            return arrayTypeDec.getTypeNativeArrayInfo().getLastComponentVarType();
        }
        else
            return varTypeComp;
    }    
    
    public void setLastComponentVarType(VarTypeNativeImpl newVarTypeComp)
    {    
        // Obtenemos el último array que lo contiene
        if (this.varTypeComp instanceof VarTypeNativeArrayInterface)
        {
            TypeNativeArrayInterface arrayTypeDec = ((VarTypeNativeArrayInterface)varTypeComp).getTypeNativeArrayInterface();            
            arrayTypeDec.getTypeNativeArrayInfo().setLastComponentVarType(newVarTypeComp);
        }
        else
        {
            // Es aquí donde hay que sustituir varTypeComp
            // por el nuevo
            if (varTypeComp != newVarTypeComp)
            {
                if (!varTypeComp.getClass().equals(newVarTypeComp.getClass()))
                    throw new JNIEasyException("Different data type of array component");
            }
                
            this.varTypeComp = newVarTypeComp;
        }
    }    
    
    public void setVarConvLastComp(int varConv)
    {
        VarTypeNativeImpl typeDecCompTmp = getLastComponentVarType();
        typeDecCompTmp.setVarConv(varConv);
    }    

    public boolean lengthKnown()
    {
        return (length != -1);
    }
    
    public int getLength()
    {
        return length;
    }
    
    public void setLength(int length)
    {
        if ((length == 0) && (varTypeComp instanceof VarTypeNativeArrayInterface))
            throw new JNIEasyException("Array with internal dimension with cero length not supported (example: new int[2][0][3])");
        if (length < -1) throw new JNIEasyException("Only valid -1 as negative array dimension");
        this.length = length;
    }
    
    public void setDimensions(int[] dims)
    {
        // Si el número de dimensiones es diferente del esperado fallará en algún momento
        setLength(dims[0]);
        VarTypeNativeImpl varTypeDecCompTmp = getComponentVarType();
        int dimIndex = 1;
        while(varTypeDecCompTmp instanceof VarTypeNativeArrayInterface)
        {
            TypeNativeArrayInterface typeDecCompArray = ((VarTypeNativeArrayInterface)varTypeDecCompTmp).getTypeNativeArrayInterface();
            TypeNativeArrayInfo arrayInfo = typeDecCompArray.getTypeNativeArrayInfo();
            arrayInfo.setLength(dims[dimIndex]);
            varTypeDecCompTmp = arrayInfo.getComponentVarType();            
            dimIndex++;
        }
        if (dims.length != dimIndex)
            throw new JNIEasyException("Number of dimensions " + dimIndex + " different to expected " + dims.length);
    }
    
    public int[] getDimensions()
    {
        // Si el número de dimensiones es diferente del esperado fallará en algún momento
        int numDims = typeDec.getClassTypeArray().getArrayInfo().getDimensions();
        int[] dims = new int[numDims];

        dims[0] = this.length;
        
        VarTypeNativeImpl varTypeDecCompTmp = getComponentVarType();
        int dimIndex = 1;
        while(varTypeDecCompTmp instanceof VarTypeNativeArrayInterface)
        {
            TypeNativeArrayInterface typeDecCompArray = ((VarTypeNativeArrayInterface)varTypeDecCompTmp).getTypeNativeArrayInterface();
            TypeNativeArrayInfo arrayInfo = typeDecCompArray.getTypeNativeArrayInfo();
            dims[dimIndex] = arrayInfo.getLength();
            varTypeDecCompTmp = arrayInfo.getComponentVarType();            
            dimIndex++;
        }
        return dims;
    }        
    
    public void check()
    {        
        varTypeComp.getTypeNative().check();
    }
    
    public String dimsToStringWithBrackets()
    {
        return TypeNativeArrayInfoRender.dimsToStringWithBrackets(getDimensions());
    }
    
    public String dimsToStringWithComas()
    {    
        return TypeNativeArrayInfoRender.dimsToStringWithComas(getDimensions());
    }
    
    public void copyDimensionsTo(TypeNativeArrayInfo arrayIntoTarget)
    {
        arrayIntoTarget.setLength(getLength());
        VarTypeNativeImpl varTypeDecCompTmp = getComponentVarType();
        if (varTypeDecCompTmp instanceof VarTypeNativeArrayInterface)
        {
            TypeNativeArrayInterface typeDecCompArray = ((VarTypeNativeArrayInterface)varTypeDecCompTmp).getTypeNativeArrayInterface();
            TypeNativeArrayInfo arrayInfo = typeDecCompArray.getTypeNativeArrayInfo();
            
            VarTypeNativeImpl varTypeDecCompTarget = arrayIntoTarget.getComponentVarType();
            TypeNativeArrayInterface typeDecCompArrayTarget = ((VarTypeNativeArrayInterface)varTypeDecCompTarget).getTypeNativeArrayInterface();
            TypeNativeArrayInfo arrayInfoTarget = typeDecCompArrayTarget.getTypeNativeArrayInfo();
            
            arrayInfo.copyDimensionsTo(arrayInfoTarget); // recursiva
        }        
    }
    
}
