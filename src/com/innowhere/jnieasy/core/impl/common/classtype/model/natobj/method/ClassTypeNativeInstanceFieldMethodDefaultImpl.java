/*
 * ClassTypeNativeInstanceFieldMethodDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeInstanceFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeInstanceFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.method.NativeInstanceFieldMethod;



/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeInstanceFieldMethodDefaultImpl extends ClassTypeNativeFieldMethodDefaultImpl
{
    public static final Class INTERFACE = NativeInstanceFieldMethod.class;
    public static final Class CLASS = NativeInstanceFieldMethodDefaultImpl.class;    
    
    /**
     * Creates a new instance of ClassTypeNativeInstanceFieldMethodDefaultImpl
     */
    public ClassTypeNativeInstanceFieldMethodDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
  
    public static void registerClassTypeNativeInstanceFieldMethodDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeInstanceFieldMethodDefaultImpl classType = new ClassTypeNativeInstanceFieldMethodDefaultImpl(mgr);
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
        return new TypeNativeInstanceFieldMethodDefaultImpl(this);
    }         
}
