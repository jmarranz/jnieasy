/*
 * IntArray2Dim.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

import com.innowhere.jnieasy.core.data.NativeObjectArray;

public class IntArray2Dim 
{
    private int[][] value; 

    public IntArray2Dim() // mandatory
    {
    }

    public IntArray2Dim(int[][] value)
    {
        this.value = value;
    }

    public int[][] getIntArray()
    {
        return value; 
    }

    public void setIntArray(int[][] value)
    {
        this.value = value; 
    }
    
    public int getInt(int[] dims)
    {
        return this.value[dims[0]][dims[1]];
    }    
    
    public void setInt(int[] dims,int newValue)
    {
        int[][] aux = this.value;
        aux[dims[0]][dims[1]] = newValue;
        this.value = aux;
    }        
        
    public int getIntQuick(int[] dims)
    {
        NativeObjectArray thisArr = (NativeObjectArray)this;
        return ((Integer)thisArr.getElement(dims)).intValue();
    }
    
    public void setIntQuick(int[] dims,int value)
    {
        NativeObjectArray thisArr = (NativeObjectArray)this;
        thisArr.setElement(dims,new Integer(value));
    }    
}
