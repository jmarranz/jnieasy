/*
 * ClassTypeCFieldMethodImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.method.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeCFieldMethodImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.CFieldMethodImpl;


/**
 *
 * @author  jmarranz
 */

public class ClassTypeCFieldMethodImpl extends ClassTypeDLLFieldImpl
{
    public static final Class INTERFACE = CFieldMethod.class;
    public static final Class CLASS = CFieldMethodImpl.class;
    
    /**
     * Creates a new instance of ClassTypeCFieldMethodImpl
     */
    public ClassTypeCFieldMethodImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);         
    }
  
    public static void registerClassTypeCFieldMethod(ClassTypeManagerImpl mgr)
    {
        ClassTypeCFieldMethodImpl classType = new ClassTypeCFieldMethodImpl(mgr);
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
        return new TypeCFieldMethodImpl(this);
    }
}
