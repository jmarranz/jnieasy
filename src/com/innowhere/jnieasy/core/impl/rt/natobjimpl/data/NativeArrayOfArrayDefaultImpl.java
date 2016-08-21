/*
 * NativeArrayOfArrayDefaultImpl.java
 *
 * Created on 27 de junio de 2005, 19:44
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.data;



/**
 *
 * @author jmarranz
 */
public class NativeArrayOfArrayDefaultImpl extends NativeArrayOfArrayImpl
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    protected Object[] value;
    
    /**
     * Creates a new instance of NativeArrayOfArrayDefaultImpl
     */
    public NativeArrayOfArrayDefaultImpl()
    {
    }
   
    public Object jnieasyNewInstance()
    {
        return new NativeArrayOfArrayDefaultImpl();
    }    
        
    public Object[] jnieasyNewArrayInstance(int len)
    {
        return new NativeArrayOfArrayDefaultImpl[len];
    }     
        
    public Object jnieasyGetInternalValue()
    {
        return this.value;            
    }        
    
    public void jnieasySetInternalValue(Object newValue)
    {
        this.value = (Object[])newValue;            
    }

}
