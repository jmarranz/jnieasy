/*
 * ClassTypeNativeInstanceFieldCallbackDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceFieldCallbackDefaultImpl;




/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeInstanceFieldCallbackDefaultImpl extends ClassTypeNativeFieldCallbackDefaultImpl
{
    public static final Class INTERFACE = NativeInstanceFieldCallback.class;
    
    /**
     * Creates a new instance of ClassTypeNativeInstanceFieldCallbackDefaultImpl
     */
    public ClassTypeNativeInstanceFieldCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
  
    public static void registerClassTypeNativeInstanceFieldCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeInstanceFieldCallbackDefaultImpl classType = new ClassTypeNativeInstanceFieldCallbackDefaultImpl(mgr);
        classType.registerClassType(); 
    }

    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 
    
    public String getVMClassImplName()
    {
        return null;
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeInstanceFieldCallbackDefaultImpl(this);
    }         
}
