/*
* ClassTypeNativeStaticFieldCallbackDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticFieldCallbackDefaultImpl;



/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStaticFieldCallbackDefaultImpl extends ClassTypeNativeFieldCallbackDefaultImpl
{
    public static final Class INTERFACE = NativeStaticFieldCallback.class;
    
    /**
     * Creates a new instance of ClassTypeNativeStaticFieldCallbackDefaultImpl
     */
    public ClassTypeNativeStaticFieldCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);         
    }
  
    public static void registerClassTypeNativeStaticFieldCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticFieldCallbackDefaultImpl classType = new ClassTypeNativeStaticFieldCallbackDefaultImpl(mgr);
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
        return new TypeNativeStaticFieldCallbackDefaultImpl(this);
    }
}
