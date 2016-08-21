/*
 * TypeNativeStringBufferUnicodeWrapperImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferUnicodeWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBufferUnicodeWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

public class TypeNativeStringBufferUnicodeWrapperImpl extends TypeNativeStringBufferWrapperImpl
{
    
    /**
     * Creates a new instance of TypeNativeStringBufferUnicodeWrapperImpl
     */
    public TypeNativeStringBufferUnicodeWrapperImpl(ClassTypeNativeStringBufferUnicodeWrapperImpl dataType)
    {
        super(dataType);
    }
                     
    public TypeNativeStringBufferUnicodeWrapperImpl(ClassTypeNativeStringBufferUnicodeWrapperImpl dataType,TypeNativeStringBufferImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }
    
    public int getDefaultEncoding()
    {
        return StringEncoding.UNICODE; // Por defecto
    }
    
    public boolean isValidEncoding(int encoding)
    {
        return encoding == StringEncoding.UNICODE;
    }
    
    public boolean isFixedEncoding()
    {
        return true;
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStringBufferUnicodeWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }     
}
