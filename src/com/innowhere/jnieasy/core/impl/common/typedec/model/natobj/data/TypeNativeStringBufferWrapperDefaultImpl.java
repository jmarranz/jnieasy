/*
 * TypeNativeStringBufferWrapperDefaultImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringBufferWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringBufferImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringBufferWrapperDefaultRuntimeImpl;


public class TypeNativeStringBufferWrapperDefaultImpl extends TypeNativeStringBufferWrapperImpl
{
    /** Creates a new instance of TypeNativeStringBufferWrapperDefaultImpl */
    public TypeNativeStringBufferWrapperDefaultImpl(ClassTypeNativeStringBufferWrapperImpl dataType)
    {
        super(dataType);      
    }
                         
    public TypeNativeStringBufferWrapperDefaultImpl(ClassTypeNativeStringBufferWrapperImpl dataType,TypeNativeStringBufferImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);       
    }    
    
    public int getDefaultEncoding()
    {
        return getJNIEasy().getTypeManagerImpl().getDefaultStringEncoding();
    }
    
    public boolean isValidEncoding(int encoding)
    {
        return true;
    }
    
    public boolean isFixedEncoding()
    {
        return false;
    }
    
    public TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        return new TypeNativeStringBufferWrapperDefaultRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }     

}
