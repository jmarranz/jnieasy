/*
 * ClassTypeNativeConstructorDefaultImpl.java
 *
 * Created on 21 de septiembre de 2005, 13:01
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.NativeConstructorDefaultImpl;
import com.innowhere.jnieasy.core.method.NativeConstructor;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeConstructorDefaultImpl extends ClassTypeNativeBehaviorDefaultImpl
{
    public static final Class INTERFACE = NativeConstructor.class;
    public static final Class CLASS = NativeConstructorDefaultImpl.class;
    
    /** Creates a new instance of ClassTypeNativeConstructorDefaultImpl */
    public ClassTypeNativeConstructorDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeConstructorDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorDefaultImpl classType = new ClassTypeNativeConstructorDefaultImpl(mgr);
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
        return new TypeNativeConstructorDefaultImpl(this);
    }
     
}
