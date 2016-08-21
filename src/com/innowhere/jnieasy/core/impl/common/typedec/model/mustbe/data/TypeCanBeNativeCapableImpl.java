/*
 * TypeCanBeNativeCapableImpl.java
 *
 * Created on 6 de enero de 2005, 15:58
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeCanBeNativeCapableInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;

public abstract class TypeCanBeNativeCapableImpl extends TypeNativeObjectImpl implements TypeCanBeNativeCapableInterface
{
    protected TypeCanBeNativeCapableWrapperImpl wrapperType;
    
    /**
     * Creates a new instance of TypeCanBeNativeCapableImpl
     */
    public TypeCanBeNativeCapableImpl(ClassTypeCanBeNativeCapableImpl dataType)
    {
        super(dataType);
       
        this.wrapperType = (TypeCanBeNativeCapableWrapperImpl)dataType.getDefaultClassTypeCanBeNativeCapableWrapper().newTypeCanBeNativeCapableWrapper(this);                    
    }    
    
    public TypeCanBeNativeCapableImpl(ClassTypeCanBeNativeCapableImpl dataType,TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        super(dataType);
        
        this.wrapperType = wrapperType;
        this.wrapperType.setTypeCanBeNativeCapable(this);        
    }        
    
    public TypeCanBeNativeCapableWrapperImpl getTypeCanBeNativeCapableWrapper()
    {
        if (wrapperType == null)
        {
            throw new JNIEasyException("Incomplete type");
            // ClassTypeCanBeNativeCapableImpl dataType = getClassTypeCanBeNativeCapable();
            // this.wrapperType = (TypeCanBeNativeCapableWrapperImpl)dataType.getDefaultClassTypeCanBeNativeCapableWrapper().newTypeCanBeNativeCapableWrapper(this);            
        }
        
        return wrapperType;
    }
  
    public void setTypeCanBeNativeCapableWrapper(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        this.wrapperType = wrapperType;
    }
    
    public ClassTypeCanBeNativeCapableImpl getClassTypeCanBeNativeCapable()
    {
        return (ClassTypeCanBeNativeCapableImpl)dataType;
    }
   
    public void check()
    {
        super.check();
        checkShared();
    }    
    
    public void checkShared()
    {
        // Se deriva en el caso Array
    }
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return newTypeCanBeNativeCapableRuntime(javaClass,true,ctx);
    }
    
    public abstract TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary,RuntimeContext ctx);    
}
