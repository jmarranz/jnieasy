/*
 * TypeNativeStringWrapperDefaultImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeStringWrapperDefaultRuntimeImpl;

public class TypeNativeStringWrapperDefaultImpl extends TypeNativeStringWrapperImpl
{
    /** Creates a new instance of TypeNativeStringWrapperDefaultImpl */
    public TypeNativeStringWrapperDefaultImpl(ClassTypeNativeStringWrapperDefaultImpl dataType)
    {
        super(dataType);       
    }   
                         
    public TypeNativeStringWrapperDefaultImpl(ClassTypeNativeStringWrapperDefaultImpl dataType,TypeNativeStringImpl typeDecWrapped)
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
        return new TypeNativeStringWrapperDefaultRuntimeImpl(this,javaClass,isPrimary,ctx);        
    }      
}
