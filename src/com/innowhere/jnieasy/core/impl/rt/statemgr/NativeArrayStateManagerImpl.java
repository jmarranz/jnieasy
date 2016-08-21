/*
 * NativeArrayStateManagerImpl.java
 *
 * Created on 4 de octubre de 2005, 9:08
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.data.NativeArray;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeSingleFieldContainerInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;


/**
 *
 * @author jmarranz
 */
public abstract class NativeArrayStateManagerImpl extends CanBeNativeCapableStateManagerImpl
{
    protected long componentSize = TypeSizes.getUNKNOWN_SIZE();
    
    /** Creates a new instance of ObjectArrayStateManagerImpl */
    public NativeArrayStateManagerImpl()
    {
    }    

    public NativeArray getNativeArray()
    {
        return (NativeArray)value;
    }
    
    public long getComponentSize()
    {    
        // Nos interesa recordar componentSize pues en matrices multidimensionales puede ser un cálculo pesado
        // y lo necesitamos para calcular el offset de los elementos de la matriz
        // Guardamos el componentSize en el StateManager para que 
        // tengamos los menos atributos posibles no serializables en la clase
        
        if (componentSize != TypeSizes.getUNKNOWN_SIZE())
            return componentSize;
        
        CanBeNativeCapableInternal value = getCanBeNativeCapableInternal();
        TypeNativeArrayWrapperRuntimeImpl typeDec = (TypeNativeArrayWrapperRuntimeImpl)value.jnieasyGetType();
        TypeNativeArrayRuntimeImpl typeDecWrapped = typeDec.getTypeNativeArrayRuntime();        
        
        if (value.jnieasyIsFixedSize())
        {
            this.componentSize = typeDecWrapped.getTypeNativeArrayInfoRuntime().getComponentSize();
        }         
        else
        {
            Object arrayValue = value.jnieasyGetInternalValue();
            this.componentSize = typeDecWrapped.getTypeNativeArrayInfoRuntime().getComponentSize(arrayValue);          
        }
  
        return componentSize;
    }
    
    
    public void setComponentSize(long componentSize)
    {
        this.componentSize = componentSize;
    }    
    
    public Object getFieldValueTxn(int fieldIndex)
    {
        // fieldIndex siempre será cero        
        //NativeSingleFieldContainerInternal value = getSingleFieldContainerInternal();
        //return value.getValue();  
        
        NativeArray value = getNativeArray();
        return value.getElement(fieldIndex);               
    }    
    
    public void setFieldValueTxn(int fieldIndex,Object fieldValue)
    {
        // fieldIndex siempre será cero         
        //NativeSingleFieldContainerInternal value = getSingleFieldContainerInternal();          
        //value.setValue(fieldValue);
        
        NativeArray value = getNativeArray();
        value.setElement(fieldIndex,fieldValue);   
    }    
    
    public int getAbsoluteTxnFieldCount()
    {     
        NativeArray value = getNativeArray();
        return value.length(); // No hay acceso a memoria nativa, se usa el value interno
        
        // return 1;
    }          
}
