/*
 * TypeNativeArrayInfoRuntime.java
 *
 * Created on 16 de mayo de 2005, 19:41
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInfo;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeArrayRuntime;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class TypeNativeArrayInfoRuntime
{
    protected TypeNativeArrayRuntimeImpl typeDecRt;
    protected VarTypeNativeRuntimeImpl varTypeCompRt;
            
    /**
     * Creates a new instance of TypeNativeArrayInfoRuntime
     */
    public TypeNativeArrayInfoRuntime(TypeNativeArrayRuntimeImpl typeDecRt,VarTypeNativeRuntimeImpl varTypeDecCompRt)
    {
        this.typeDecRt = typeDecRt;
        this.varTypeCompRt = varTypeDecCompRt;
    }
    
    public TypeNativeArrayInfo getTypeNativeArrayInfo()
    {
        return typeDecRt.getTypeNativeArray().getTypeNativeArrayInfo();
    }
    
    public VarTypeNativeRuntimeImpl getComponentVarType()
    {
        return varTypeCompRt;
    }
    
    public void setComponentVarType(VarTypeNativeRuntimeImpl varTypeDecCompRt)
    {
        this.varTypeCompRt = varTypeDecCompRt;
    }    
    
    public VarTypeNativeRuntimeImpl getLastComponentVarType()
    {
        // Devuelve el componente último de una matriz multidimensional (si es simple vale igual)
        // que no es array
        if (varTypeCompRt instanceof VarTypeNativeArrayRuntime)
        {
            TypeNativeArrayRuntime compArrayTypeDec = ((VarTypeNativeArrayRuntime)varTypeCompRt).getTypeNativeArrayRuntime();
            return compArrayTypeDec.getTypeNativeArrayInfoRuntime().getLastComponentVarType();
        }
        else
            return varTypeCompRt;
    }    
    
    public void setLastComponentVarType(VarTypeNativeRuntimeImpl newVarTypeCompRt)
    {    
        // Obtenemos el último array que lo contiene
        if (varTypeCompRt instanceof VarTypeNativeArrayRuntime)
        {
            TypeNativeArrayRuntime compArrayTypeDec = ((VarTypeNativeArrayRuntime)varTypeCompRt).getTypeNativeArrayRuntime();
            compArrayTypeDec.getTypeNativeArrayInfoRuntime().setLastComponentVarType(newVarTypeCompRt);
        }
        else
        {
            // Es aquí donde hay que sustituir typeDecComp
            // por el nuevo
            typeDecRt.getTypeNativeArray().getTypeNativeArrayInfo().setLastComponentVarType(newVarTypeCompRt.getVarTypeNative());    
            this.varTypeCompRt = newVarTypeCompRt;            
        }
    }

    public long getSize(Object arrayValue)
    {
        // value es un array (int[], String[][] etc)
        // Conocemos la cadena de tipos (dimensiones), lo que no conocemos son
        // los valores de las dimensiones en el caso de que el componente sea a su vez
        // un array
        int len = typeDecRt.getLength(arrayValue);
        long sizeComp = getComponentSize(arrayValue);
        return len * sizeComp;
    }
    
    public long getComponentSize(Object arrayValue)
    {
        if (varTypeCompRt instanceof VarTypeNativeArrayRuntime)
        {
            // Ejemplo de arrayValue: int[2][3] o String[2][3]
            // Obtenemos el elemento [0], esto supone que no son válidas
            // arrays tal y como: new int[0][3]; que Java admite pero que no tiene sentido
            // compValue es un array a su vez
            Object itemFirst = ((Object[])arrayValue)[0]; // itemFirst es un array a su vez
            TypeNativeArrayRuntime compArrayTypeDec = ((VarTypeNativeArrayRuntime)varTypeCompRt).getTypeNativeArrayRuntime();
            return compArrayTypeDec.getTypeNativeArrayInfoRuntime().getSize(itemFirst);
        }
        else
        {
            // Ej. de arrayValue: int[2] o String[2]
            return varTypeCompRt.size();
        }        
    }    
        
    public long getArraySize()
    {
        int length = getLength();
        if (length == -1) throw new JNIEasyException("Unknown array length");            
        return length * varTypeCompRt.size();
    }        

    public long getComponentSize()
    {
        // El tamaño que ocupa el componente en el array, puede ser un puntero
        return varTypeCompRt.size();
    }
    
    public int[] getDimensions()
    {
        TypeNativeArrayInfo arrayInfo = getTypeNativeArrayInfo();
        return arrayInfo.getDimensions();
    }
    
    public void setDimensions(int[] dims)
    {
        TypeNativeArrayInfo arrayInfo = getTypeNativeArrayInfo();
        arrayInfo.setDimensions(dims);
    }    
    
    public int getLength()    
    {
        TypeNativeArrayInfo arrayInfo = getTypeNativeArrayInfo();
        return arrayInfo.getLength();
    }
    
    public void setLength(int len)    
    {
        TypeNativeArrayInfo arrayInfo = getTypeNativeArrayInfo();
        arrayInfo.setLength(len);
    }    
    
    public int[] getDimensions(Object array)
    {
        int numOfDims = typeDecRt.getTypeNativeArray().getClassTypeArray().getArrayInfo().getDimensions();
        
        int[] dims = new int[numOfDims];

        int length = typeDecRt.getLength(array);
        dims[0] = length;
        VarTypeNativeRuntimeImpl varTypeDecCompTmp = getComponentVarType();
        int dimIndex = 1;
        while(varTypeDecCompTmp instanceof VarTypeNativeArrayRuntime)
        {
            // Ejemplo de arrayValue: int[2][3] o String[2][3]
            // Obtenemos el elemento [0], esto supone que no son válidas
            // arrays tal y como: new int[0][3]; que Java admite pero que no tiene sentido
            if (length == 0)  
                throw new JNIEasyException("Array with internal dimension with cero length not supported (ex. new int[2][0][3])");
            if (dimIndex >= dims.length) 
                throw new JNIEasyException("Array object has different number of dimensions than expected");
            array = ((Object[])array)[0]; // array es un array a su vez

            TypeNativeArrayRuntime arrayTypeDecRt = ((VarTypeNativeArrayRuntime)varTypeDecCompTmp).getTypeNativeArrayRuntime();
            length = arrayTypeDecRt.getLength(array);
            dims[dimIndex] = length;

            TypeNativeArrayInfoRuntime arrayInfo = arrayTypeDecRt.getTypeNativeArrayInfoRuntime();         
            varTypeDecCompTmp = arrayInfo.getComponentVarType();
            dimIndex++;
        }
        
        return dims;
    }    
    
    public void setDimensionsFrom(Object arrayValue)
    {
        typeDecRt.getTypeNativeArray().getTypeNativeArrayInfo().setDimensions(getDimensions(arrayValue));
    }
    
    public void checkArrayValue(Object value)
    {
        // Este chequeo es para el caso de arrays con longitud fija
        // sólo se puede asignar arrays igual longitud porque
        // sino, si es mayor, se asigna parte de los datos a otra zona de la memoria que no le pertence
        // y si es menor no pasa esto pero al acceder al array obtenemos un array menor
        // que el esperado en el mapa del tipo de dato lo cual se aleja de la idea de simetría
        // con el mundo C y C++
        
        if (value == null) return; // Si ha llegado aquí un valor de value == null es porque seguramente estamos en un field por puntero, hubiera fallado antes en algún sitio.
        
        TypeNativeArrayInfo typeDecArrayInfo = typeDecRt.getTypeNativeArray().getTypeNativeArrayInfo();
        if (!typeDecArrayInfo.lengthKnown()) return; // No hay chequeo de longitud, la longitud no es fija
    
        int length = typeDecRt.getLength(value);
        if (typeDecArrayInfo.getLength() != length) 
            throw new JNIEasyException("Array object has different number of elements (" + length + ") than expected (" + typeDecArrayInfo.getLength() + ")");

        // No comprobamos las demás dimensiones pues el propio
        // algoritmo de copia de una matriz multimensional
        // a la memoria nativa recorrerá todos los elementos
        // internamente y este método será llamado para cada
        // uno de ellos (dentro de la correspondiente instancia
        // TypeDecXXX )
    }              
}
