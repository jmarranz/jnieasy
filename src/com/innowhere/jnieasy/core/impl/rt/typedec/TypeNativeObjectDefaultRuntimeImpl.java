/*
 * TypeNativeObjectDefaultRuntimeImpl.java
 *
 * Created on 7 de marzo de 2005, 11:26
 */

package com.innowhere.jnieasy.core.impl.rt.typedec;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectDefaultImpl;

/* Sólo es válido el caso de paso por referencia tanto en métodos
 *como en atributos, se indica en TypeNativeObjectDefaultImpl
 */

public class TypeNativeObjectDefaultRuntimeImpl extends TypeNativeObjectRuntimeImpl
{
    public TypeNativeCapableDefaultRuntimeImpl typeDecDefault;
    
    /**
     * Creates a new instance of TypeNativeObjectDefaultRuntimeImpl
     */
    public TypeNativeObjectDefaultRuntimeImpl(TypeNativeObjectDefaultImpl typeDec,Class javaClass,RuntimeContext ctx)
    {
        super(typeDec,javaClass,ctx.getRuntimeManager());

        this.typeDecDefault = typeDec.getTypeNativeCapableDefault().newTypeNativeCapableDefaultRuntime(ClassTypeNativeCapableDefaultImpl.INTERFACE,ctx);
    }
    
    public Object getObject(NativeAddressImpl addr, long offset)
    {
        // No tenemos más opción que considerar el caso de objeto addressed (por referencia claro)
        // pues no tenemos ni idea de lo que nos envían desde la parte nativa
        // Usamos NativeCapableDefault porque así empleamos su objeto proxy
        // que vale para cualquier tipo para el caso en el que no haya un objeto (NativeCapableInternal derivado)
        // asociado a la dirección
        return typeDecDefault.getObject(addr,offset);
    }

    public Object newValue()
    {
        throw new JNIEasyException("Unknown object type");
    }    

    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }    
    
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }    

    public boolean isValidAsReturnOfCallback()
    {
        // En la práctica sólo se permitirá que el objeto devuelto sea un
        // NativeCapable (no un can be native como String etc)
        return true;
    }    
}
