/*
 * ClassTypeNativeDirectConstructorCallbackDefaultImpl.java
 *
 * Created on 12 de julio de 2005, 20:30
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectConstructorCallbackDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectConstructorCallback;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectConstructorCallbackDefaultImpl extends ClassTypeNativeDirectConstructorCallbackImpl
{
    public static final Class INTERFACE = NativeDirectConstructorCallback.class;
    
    /**
     * Creates a new instance of ClassTypeNativeDirectConstructorCallbackDefaultImpl
     */
    public ClassTypeNativeDirectConstructorCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }    
    
    public static void registerClassTypeNativeDirectConstructorCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectConstructorCallbackDefaultImpl classType = new ClassTypeNativeDirectConstructorCallbackDefaultImpl(mgr);
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
    
    public boolean isCustom()
    {
        return false;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeDirectConstructorCallbackDefaultRuntimeImpl(this,rtMgr);        
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
