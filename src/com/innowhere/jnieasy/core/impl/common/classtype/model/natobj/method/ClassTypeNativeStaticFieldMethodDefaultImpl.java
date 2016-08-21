/*
 * ClassTypeNativeStaticFieldMethodDefaultImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeStaticFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeStaticFieldMethodDefaultImpl;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethod;



/**
 *
 * @author  jmarranz
 */

public class ClassTypeNativeStaticFieldMethodDefaultImpl extends ClassTypeNativeFieldMethodDefaultImpl
{
    public static final Class INTERFACE = NativeStaticFieldMethod.class;
    public static final Class CLASS = NativeStaticFieldMethodDefaultImpl.class;
            
    /**
     * Creates a new instance of ClassTypeNativeStaticFieldMethodDefaultImpl
     */
    public ClassTypeNativeStaticFieldMethodDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);         
    }
  
    public static void registerClassTypeNativeStaticFieldMethodDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeStaticFieldMethodDefaultImpl classType = new ClassTypeNativeStaticFieldMethodDefaultImpl(mgr);
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
        return new TypeNativeStaticFieldMethodDefaultImpl(this);
    }
}
