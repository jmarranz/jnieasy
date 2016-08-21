/*
 * MyStructureArray.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

import com.innowhere.jnieasy.core.data.NativeObjectArray;

public class MyStructureArray
{
    private MyStructure[] value;

    public MyStructureArray()
    {
    }

    public MyStructureArray(MyStructure[] value)
    {
        this.value = value;
    }

    public MyStructure[] getStructArray()
    {
        return value; 
    }

    public void setStructArray(MyStructure[] value)
    {
        this.value = value; 
    }

    public MyStructure getStruct(int index)
    {
        return value[index]; 
    }
    
    public void setStruct(int index,MyStructure value)
    {
        MyStructure[] aux = this.value;
        aux[index] = value;
        this.value = aux;
    }     
    
    public MyStructure getStructQuick(int index)
    {
        NativeObjectArray thisArr = (NativeObjectArray)this;
        return (MyStructure)thisArr.getElement(index);
    }
    
    public void setStructQuick(int index,MyStructure value)
    {
        NativeObjectArray thisArr = (NativeObjectArray)this;
        thisArr.setElement(index,value);
    }      
}
