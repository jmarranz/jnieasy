/*
 * TypeNativeStringUnicodeWrapperImpl.java
 *
 * Created on 10 de enero de 2005, 8:40
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringUnicodeWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringUnicodeWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

public class TypeNativeStringUnicodeWrapperImpl extends TypeNativeStringWrapperImpl
{
    
    /** Creates a new instance of TypeNativeStringUnicodeWrapperImpl */
    public TypeNativeStringUnicodeWrapperImpl(ClassTypeNativeStringUnicodeWrapperImpl dataType)
    {
        super(dataType);
    }
                             
    public TypeNativeStringUnicodeWrapperImpl(ClassTypeNativeStringUnicodeWrapperImpl dataType,TypeNativeStringImpl typeDecWrapped)
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
        return new TypeNativeStringUnicodeWrapperRuntimeImpl(this,javaClass,isPrimary,ctx);       
    }      
}
