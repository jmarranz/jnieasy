/*
 * ClassTypeNativeBehaviorDefaultImpl.java
 *
 * Created on 21 de septiembre de 2005, 12:55
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
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeBehaviorDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;


/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeBehaviorDefaultImpl extends ClassTypeNativeCapableImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeBehaviorDefaultImpl 
     */
    public ClassTypeNativeBehaviorDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeBehaviorDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorDefaultImpl.registerClassTypeNativeConstructorDefault(mgr);
        ClassTypeNativeMethodDefaultImpl.registerClassTypeNativeMethodDefault(mgr);
        ClassTypeNativeFieldMethodDefaultImpl.registerClassTypeNativeFieldMethodDefault(mgr);         
    }
            
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeBehaviorDefaultRuntimeImpl(this,rtMgr);        
    }    
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
