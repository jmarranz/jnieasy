/*
 * ClassTypeNativeMultipleFieldContainerImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeMultipleFieldContainerImpl;

public abstract class ClassTypeNativeMultipleFieldContainerImpl extends ClassTypeNativeFieldContainerImpl
{
   
    /**
     * Creates a new instance of ClassTypeNativeMultipleFieldContainerImpl
     */
    public ClassTypeNativeMultipleFieldContainerImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeMultipleFieldContainer(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeSeparatedFieldContainerImpl.registerClassTypeSeparatedFieldContainer(mgr);   
        ClassTypeUnionImpl.registerClassTypeUnion(mgr);         
    }   

    public static ClassTypeNativeMultipleFieldContainerImpl newCustomClassTypeMultipleFieldContainer(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (ClassTypeNativeSeparatedFieldContainerImpl.isAssignableFrom(valueClass))
            return ClassTypeNativeSeparatedFieldContainerImpl.newCustomClassTypeSeparatedFieldContainer(valueClass,ctx);
        else if (ClassTypeUnionImpl.isAssignableFrom(valueClass))
            return ClassTypeUnionImpl.newClassTypeUnion(valueClass,ctx.getJNIEasy());
        
        return null;
    }    
    
    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeMultipleFieldContainer.class,valueClass);
    }    
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeMultipleFieldContainerImpl(this);
    }    
}
