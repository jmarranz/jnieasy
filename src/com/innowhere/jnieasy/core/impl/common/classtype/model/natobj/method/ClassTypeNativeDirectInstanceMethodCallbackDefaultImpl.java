/*
 * ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeDirectInstanceMethodCallbackDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceMethodCallback;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl extends ClassTypeNativeDirectInstanceMethodCallbackImpl
{
    public static final Class INTERFACE = NativeDirectInstanceMethodCallback.class;
    
    /**
     * Creates a new instance of ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl
     */
    public ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }

    public static void registerClassTypeNativeDirectInstanceMethodCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl classType = new ClassTypeNativeDirectInstanceMethodCallbackDefaultImpl(mgr);
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
        return new ClassTypeNativeDirectInstanceMethodCallbackDefaultRuntimeImpl(this,rtMgr);        
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
