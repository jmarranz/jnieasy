/*
 * ClassTypeNativeDirectCallbackRuntimeImpl.java
 *
 * Created on 20 de junio de 2005, 12:42
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeDirectCallbackRuntimeImpl extends ClassTypeNativeCapableRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeDirectCallbackRuntimeImpl
     */
    public ClassTypeNativeDirectCallbackRuntimeImpl(ClassTypeNativeDirectCallbackImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getPreferredAlignSize()
    {
        throw new JNIEasyException("Unknown alignment size");
    }    
        
    public static ClassTypeNativeDirectCallbackImpl registerCustomNativeDirectCallbackType(Class valueClass,RuntimeContext ctx)
    {
        ClassTypeNativeDirectCallbackImpl type = (ClassTypeNativeDirectCallbackImpl)ctx.getClassType(valueClass);
        return type;
    }        
}
