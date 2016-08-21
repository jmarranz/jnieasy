/*
 * ClassTypeNativeObjectArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;


public abstract class ClassTypeNativeObjectArrayImpl extends ClassTypeNativeArrayImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayImpl
     */
    public ClassTypeNativeObjectArrayImpl(ClassTypeNativeObjectImpl compType)
    {
        super(compType);
    }
    
    public static void registerClassTypeNativeObjectArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeCanBeNativeCapableArrayImpl.registerClassTypeCanBeNativeCapableArray(mgr);        
        ClassTypeNativeCapableArrayImpl.registerClassTypeNativeCapableArray(mgr);    
        ClassTypeNativeObjectArrayDefaultImpl.registerClassTypeNativeObjectArrayDefault(mgr);        
    }
    
    public static ClassTypeNativeObjectArrayImpl newCustomObjectArrayType(MetaClassWrapper valueClass,TaskContext ctx)
    {
        MetaClassWrapper compType = valueClass.getComponentType();
        ClassTypeNativeObjectImpl classTypeComp = (ClassTypeNativeObjectImpl)ctx.getClassType(compType,true);            
        if (compType.isArray()) // el único caso que admite custom (NativeArrayOfArray)
            return ClassTypeCanBeNativeCapableArrayImpl.newCustomCanBeNativeCapableArrayType(valueClass,(ClassTypeCanBeNativeCapableImpl)classTypeComp,ctx);
        else
            return ClassTypeNativeCapableArrayImpl.newCustomNativeCapableArrayType(valueClass,(ClassTypeNativeCapableImpl)classTypeComp,ctx);            
    }  
    
    public int getLength(Object value)
    {
        return ((Object[])value).length;
    }       
}
