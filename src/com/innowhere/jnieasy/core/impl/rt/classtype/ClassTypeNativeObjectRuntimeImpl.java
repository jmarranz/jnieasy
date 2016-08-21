/*
 * ClassTypeNativeObjectRuntimeImpl.java
 *
 * Created on 18 de mayo de 2005, 13:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeObjectRuntimeImpl extends ClassTypeNativeRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectRuntimeImpl
     */
    public ClassTypeNativeObjectRuntimeImpl(ClassTypeNativeObjectImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public int returnTypeCode()
    {
        // Salvo los tipos simples Java no podemos retornar 
        // en los demás casos más que referencias, porque el
        // la técnica en código máquina de retorno de funciones
        // en, por ejemplo, estructuras "por valor", es muy compleja
        return POINTER_RETURN;
    }        
    
    public abstract Object newValue();
}
