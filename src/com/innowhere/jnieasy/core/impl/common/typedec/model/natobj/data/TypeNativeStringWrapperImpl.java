/*
 * TypeNativeStringWrapperImpl.java
 *
 * Created on 5 de enero de 2005, 19:39
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeStringWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeStringInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeStringImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.natobj.data.TypeNativeStringWrapperRender;


public abstract class TypeNativeStringWrapperImpl extends TypeNativeStringBasedWrapperImpl implements TypeNativeStringInterface
{

    /** Creates a new instance of TypeNativeStringWrapperImpl */
    public TypeNativeStringWrapperImpl(ClassTypeNativeStringWrapperImpl dataType)
    {
        super(dataType);
    }    
                     
    public TypeNativeStringWrapperImpl(ClassTypeNativeStringWrapperImpl dataType,TypeNativeStringImpl typeDecWrapped)
    {
        super(dataType,typeDecWrapped);
    }
    
    public ClassTypeNativeStringWrapperImpl getStringWrapperType()
    {
        return (ClassTypeNativeStringWrapperImpl)dataType;
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeStringWrapperRender(this);
    }

}
