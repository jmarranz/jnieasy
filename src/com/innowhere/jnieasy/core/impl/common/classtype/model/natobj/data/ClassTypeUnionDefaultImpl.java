/*
 * ClassTypeUnionDefaultImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeUnionDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.UnionDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public class ClassTypeUnionDefaultImpl extends ClassTypeUnionImpl
{
    public static final Class INTERFACE = Union.class;
    public static final Class CLASS = UnionDefaultImpl.class;    
    
    /** Creates a new instance of ClassTypeUnionDefaultImpl */
    public ClassTypeUnionDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }    
    
    public static void registerClassTypeUnionDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeUnionDefaultImpl classType = new ClassTypeUnionDefaultImpl(mgr);
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
         
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeUnionDefaultRuntimeImpl(this,rtMgr);
    }
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }     
}
