/*
 * TypeNativeStringAnsiWrapperImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringAnsiWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringAnsiWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

public class TypeNativeStringAnsiWrapperImpl extends TypeNativeStringWrapperImpl
{
    
    /**
     * Creates a new instance of TypeNativeStringAnsiWrapperImpl
     */
    public TypeNativeStringAnsiWrapperImpl(ClassTypeNativeStringAnsiWrapperImpl dataType)
    {
        super(dataType);
    }
                             
    public TypeNativeStringAnsiWrapperImpl(ClassTypeNativeStringAnsiWrapperImpl dataType,TypeNativeStringImpl typeDecWrapped)
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
        return new TypeNativeStringAnsiWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }      
}
