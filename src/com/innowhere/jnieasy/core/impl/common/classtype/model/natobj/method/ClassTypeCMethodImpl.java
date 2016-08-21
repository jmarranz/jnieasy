/*
 * MethodType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.CMethodImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeCMethodImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeCMethodImpl extends ClassTypeDLLMethodImpl
{
    public static final Class INTERFACE = CMethod.class;
    public static final Class CLASS = CMethodImpl.class;
    
    /** Creates a new instance of MethodType */
    public ClassTypeCMethodImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);         
    }
  
    public static void registerClassTypeCMethod(ClassTypeManagerImpl mgr)
    {
        ClassTypeCMethodImpl classType = new ClassTypeCMethodImpl(mgr);
        classType.registerClassType(); 
    }

    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 
    
    public String getVMClassImplName()
    {
        return CLASS.getName();
    }
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeCMethodImpl(this);
    }
}
