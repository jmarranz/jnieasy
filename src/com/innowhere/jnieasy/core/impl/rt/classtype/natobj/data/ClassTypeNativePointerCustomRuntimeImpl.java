/*
 * ClassTypeNativePointerCustomRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 20:09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;



/**
 *
 * @author jmarranz
 */
public class ClassTypeNativePointerCustomRuntimeImpl extends ClassTypeNativePointerRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
   
    /**
     * Creates a new instance of ClassTypeNativePointerCustomRuntimeImpl
     */
    public ClassTypeNativePointerCustomRuntimeImpl(ClassTypeNativePointerCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeNativePointerCustomImpl getClassTypeNativePointerCustom()
    {
        return (ClassTypeNativePointerCustomImpl)classType;
    }

    public static ClassTypeNativePointerCustomImpl registerPointerCustomType(Class containerClass,Class pointerClass,RuntimeContext ctx)
    {
        ClassTypeNativeObjectImpl pointerType = (ClassTypeNativeObjectImpl)ctx.getClassType(pointerClass);
        return ClassTypeNativePointerCustomImpl.registerClassTypeNativePointerCustom(containerClass.getName(),(ClassTypeNativeObjectImpl)pointerType,ctx.getJNIEasy());
    }     
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        return new JavaClassAsNativePointerRuntimeImpl((JavaClassAsNativePointerImpl)getClassTypeNativePointerCustom().getJavaClassAsNativeCapable(),this);       
    }     
   
}
