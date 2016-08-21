/*
 * StringBasedWrapperType.java
 *
 * Created on 11 de febrero de 2005, 11:54
 */

package com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringBasedInterface;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringBasedRuntime;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeStringBasedRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeStringBasedWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeStringInfoRuntime;

public abstract class TypeNativeStringBasedWrapperRuntimeImpl extends TypeCanBeNativeCapableWrapperRuntimeImpl implements TypeNativeStringBasedRuntime
{
    protected TypeNativeStringInfoRuntime stringInfo = new TypeNativeStringInfoRuntime(this);
            
    /** Creates a new instance of StringBasedWrapperType */
    public TypeNativeStringBasedWrapperRuntimeImpl(TypeNativeStringBasedWrapperImpl typeDec,Class javaClass,boolean isPrimary,RuntimeContext ctx)
    {
        super(typeDec,javaClass,isPrimary,ctx);
    }
    
    public TypeNativeStringBasedWrapperImpl getTypeNativeStringBasedWrapper()
    {
        return (TypeNativeStringBasedWrapperImpl)typeDec;
    }
    
    public TypeNativeStringBasedRuntimeImpl getTypeNativeStringBasedRuntime()
    {
        return (TypeNativeStringBasedRuntimeImpl)getTypeCanBeNativeCapableRuntime();
    }
    
    public TypeNativeStringBasedInterface getTypeNativeStringBasedInterface()
    {
        return (TypeNativeStringBasedInterface)typeDec;        
    }
    
    public int getDefaultEncoding()
    {
        return getTypeNativeStringBasedWrapper().getDefaultEncoding();      
    }    
    
    public boolean isValidEncoding(int encoding)
    {
        return getTypeNativeStringBasedWrapper().isValidEncoding(encoding); 
    }    
    
    public boolean isFixedEncoding()
    {
        return getTypeNativeStringBasedWrapper().isFixedEncoding();             
    }
    
    public int getEncoding()
    {
        return stringInfo.getEncoding();
    }
    
    public void setEncoding(int encoding)
    {
        stringInfo.setEncoding(encoding);
    }
}
