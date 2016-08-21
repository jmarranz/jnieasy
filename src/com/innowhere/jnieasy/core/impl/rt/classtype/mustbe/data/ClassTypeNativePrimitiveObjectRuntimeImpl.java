/*
 * ClassTypeNativePrimitiveObjectRuntimeImpl.java
 *
 * Created on 9 de diciembre de 2004, 13:49
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativePrimitiveRuntimeImpl;

public class ClassTypeNativePrimitiveObjectRuntimeImpl extends ClassTypeCanBeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativePrimitiveObjectRuntimeImpl
     */
    public ClassTypeNativePrimitiveObjectRuntimeImpl(ClassTypeNativePrimitiveObjectImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }

    public ClassTypeNativePrimitiveObjectImpl getClassTypeNativePrimitiveObject()
    {
        return (ClassTypeNativePrimitiveObjectImpl)classType;
    }
    
    public ClassTypeNativePrimitiveRuntimeImpl getClassTypeNativePrimitiveRuntime()
    {
        return (ClassTypeNativePrimitiveRuntimeImpl)getClassTypeNativePrimitiveObject().getClassTypeNativePrimitive().getClassTypeRuntime();
    }

    public long getObjectSize()
    {
        return getClassTypeNativePrimitiveRuntime().getObjectSize();
    }       
    
    public long getPreferredAlignSize()
    {
        return getClassTypeNativePrimitiveRuntime().getPreferredAlignSize();
    }
        
}

 