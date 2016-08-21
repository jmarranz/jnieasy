/*
 * NativeMemberReflectionImpl.java
 *
 * Created on 1 de diciembre de 2004, 17:47
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.*;
import com.innowhere.jnieasy.core.data.NativeMemberReflection;
import java.lang.reflect.Member;




public abstract class NativeMemberReflectionImpl extends CanBeNativeCapableImpl implements NativeMemberReflection
{
    private static final long serialVersionUID = 1L; // Para asegurar que la serialización/deserialización no cambia aunque se recompile la clase y se añadan nuevos métodos
    
    /**
     * Creates a new instance of NativeMemberReflectionImpl
     */
    public NativeMemberReflectionImpl()
    {
    }

    public Object jnieasyNewWrappedValue()
    {
        // No es posible instanciar un objeto Member por sí mismo
        // pues Field, Method, Constructor están vinculados a alguna clase
        return null; 
    }    
    
    public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr)
    {
        // no hay fields detachables
    }
    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)
    {
        // no hay fields clonables
    }    

    public boolean jnieasyNeedAuxObjects()
    {
        return false;
    }
    
    public Member getMember()
    {
        return (Member)getValue();
    }
    
    public void setMember(Member newValue)    
    {
        setValue(newValue);
    }    

    public Object jnieasyCloneValue(Object valueToClone, Object cloneCtx, NativeStateManager stateMgr)
    {
        // No son clonables los Member no podemos hacer otra cosa
        return valueToClone;
    }
    
}
