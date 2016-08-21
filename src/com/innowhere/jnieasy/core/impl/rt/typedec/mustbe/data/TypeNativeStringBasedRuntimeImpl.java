/*
 * StringBasedType.java
 *
 * Created on 3 de febrero de 2005, 19:55
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringBasedRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBasedWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBasedImpl;


public abstract class TypeNativeStringBasedRuntimeImpl extends TypeCanBeNativeCapableRuntimeImpl implements TypeNativeStringBasedRuntime
{
    
    /** Creates a new instance of StringBasedType */
    public TypeNativeStringBasedRuntimeImpl(TypeNativeStringBasedImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }

    public TypeNativeStringBasedWrapperRuntimeImpl getTypeNativeStringBasedWrapperRuntime()
    {
        return (TypeNativeStringBasedWrapperRuntimeImpl)getTypeCanBeNativeCapableWrapperRuntime();
    }
    
    public TypeNativeStringBasedInterface getTypeNativeStringBasedInterface()
    {
        return (TypeNativeStringBasedInterface)typeDec;
    }
    
    public TypeNativeStringBasedImpl getTypeNativeStringBased()
    {
        return (TypeNativeStringBasedImpl)typeDec;
    }
    
    public int getDefaultEncoding()
    {
        return getTypeNativeStringBased().getDefaultEncoding(); // Por defecto
    }
    
    public boolean isValidEncoding(int encoding)
    {
        return getTypeNativeStringBased().isValidEncoding(encoding);
    }        

    public int getEncoding()
    {
        return getTypeNativeStringBasedWrapperRuntime().getEncoding();
    }
    
    public void setEncoding(int encoding)
    {
        getTypeNativeStringBasedWrapperRuntime().setEncoding(encoding);
    }
    
    public boolean isFixedEncoding()
    {
        return getTypeNativeStringBasedWrapperRuntime().isFixedEncoding();             
    }
    
    public boolean isObjectKnownSize()
    {
        // Las cadenas no se declaran con un tamaño fijo, para ello mejor usar un array de char
        return false;
    }
    
    public long calcSize()
    {
        return getClassTypeRuntime().getObjectSize();
    }
    
    public long calcPreferredAlignSize()
    {
        return getClassTypeRuntime().getPreferredAlignSize();
    }
    
    public Object newValueInternal()
    {
        return getClassTypeNativeObjectRuntime().newValue();
    }   
}
