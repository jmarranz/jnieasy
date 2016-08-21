/*
 * NativeObjectArrayStateManagerImpl.java
 *
 * Created on 13 de septiembre de 2005, 18:32
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;



/**
 *
 * @author jmarranz
 */
public class NativeObjectArrayStateManagerImpl extends NativeArrayStateManagerImpl
{
  
    /**
     * Creates a new instance of NativeObjectArrayStateManagerImpl
     */
    public NativeObjectArrayStateManagerImpl()
    {
    }    

    protected void setNewAuxObjectsArray()
    {
        if (needAuxObjects())  
        {
            CanBeNativeCapableInternal nativeObj = getCanBeNativeCapableInternal();

            Object[] arrayValue = (Object[])nativeObj.jnieasyGetInternalValue(); 
            if (arrayValue != null)
            {
                setNewAuxObjectsArray(arrayValue.length);
            }
            else
                setNewAuxObjectsArray(0);
        }
    }        

    public void updateAuxObjectArray(Object newValue)
    {       
        if (needAuxObjects())      
        {
            if (newValue == null) // raro pero por si acaso
                this.auxObjects.clear(); 
            else
            {
                Object[] valueNewArray = (Object[])newValue;            
                if (auxObjects == null)
                    setNewAuxObjectsArray(valueNewArray.length); 
                else
                {
                    // newValue y auxObjects son no nulos, es posible que necesite actualizarse
                    if (auxObjects.size() != valueNewArray.length)
                        setNewAuxObjectsArray(valueNewArray.length);
                }
            }
        }
    }        
    
    
    public int getAbsAuxNativeObjectIndex(int absFieldIndex)
    {
        if (needAuxObjects())            
            return absFieldIndex;
        else
            return -1; // No se necesita auxiliar
    }    
}
