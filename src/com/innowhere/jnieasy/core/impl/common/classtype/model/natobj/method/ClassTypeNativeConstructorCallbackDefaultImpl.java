/*
 * ClassTypeNativeConstructorCallbackDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.method.TypeNativeConstructorCallbackDefaultImpl;
import com.innowhere.jnieasy.core.method.NativeConstructorCallback;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeConstructorCallbackDefaultImpl extends ClassTypeNativeCallbackDefaultImpl
{
    public static final Class INTERFACE = NativeConstructorCallback.class;

    
    /** Creates a new instance of ClassTypeNativeConstructorCallbackDefaultImpl */
    public ClassTypeNativeConstructorCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeConstructorCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorCallbackDefaultImpl classType = new ClassTypeNativeConstructorCallbackDefaultImpl(mgr);
        classType.registerClassType();          
    }

    public String getVMClassName()
    {
        return INTERFACE.getName();
    }
    
    public String getVMClassImplName()
    {
        // This type is not instanciable
        return null;
    }

    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeConstructorCallbackDefaultImpl(this);
    }
     
}
