/*
 * ClassTypeNativeObjectImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:18
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableDefaultImpl;


/**
 *
 * @author  jmarranz
 */


public abstract class ClassTypeNativeObjectImpl extends ClassTypeNativeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeObjectImpl
     */
    public ClassTypeNativeObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCapableDefaultImpl.registerClassTypeNativeCapableDefault(mgr);        

        ClassTypeNativeObjectDefaultImpl.registerClassTypeNativeObjectDefault(mgr);        
        ClassTypeCanBeNativeCapableImpl.registerClassTypeCanBeNativeCapable(mgr);                    
        ClassTypeNativeCapableImpl.registerClassTypeNativeCapable(mgr);        
    }

    public static ClassTypeNativeObjectImpl newCustomObjectType(MetaClassWrapper valueClass,TaskContext ctx)
    {    
        if (valueClass.isArray()) // sólo este caso es el que puede tener Customs 
            return ClassTypeCanBeNativeCapableImpl.newCustomClassTypeCanBeNativeCapable(valueClass,ctx);        
        else
            return ClassTypeNativeCapableImpl.newCustomClassTypeNativeCapable(valueClass,ctx);
    }  
    
    public abstract Object newValueDefaultClass();
}
