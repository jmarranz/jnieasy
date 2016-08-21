/*
 * TypeNativeStringBufferAnsiWrapperImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBufferAnsiWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

public class TypeNativeStringBufferAnsiWrapperImpl extends TypeNativeStringBufferWrapperImpl
{
    
    /**
     * Creates a new instance of TypeNativeStringBufferAnsiWrapperImpl
     */
    public TypeNativeStringBufferAnsiWrapperImpl(ClassTypeNativeStringBufferAnsiWrapperImpl dataType)
    {
        super(dataType);
    }
                             
    public TypeNativeStringBufferAnsiWrapperImpl(ClassTypeNativeStringBufferAnsiWrapperImpl dataType,TypeNativeStringBufferImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);                         
    }    
    
    public int getDefaultEncoding()
    {
        return StringEncoding.ANSI; // Por defecto
    }
    
    public boolean isValidEncoding(int encoding)
    {
        return encoding == StringEncoding.ANSI;
    }    
    
    public boolean isFixedEncoding()
    {
        return true;
    }    
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStringBufferAnsiWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }     
}
