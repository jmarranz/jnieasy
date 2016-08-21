/*
 * ClassTypeNativeObjectDefaultImpl.java
 *
 * Created on 7 de marzo de 2005, 11:21
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeObjectDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;


public class ClassTypeNativeObjectDefaultImpl extends ClassTypeNativeObjectImpl
{
    public static final Class CLASS = Object.class;
    
    protected ClassTypeNativeCapableDefaultImpl defaultClassType;    
   
    /**
     * Creates a new instance of ClassTypeNativeObjectDefaultImpl
     */
    public ClassTypeNativeObjectDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static ClassTypeNativeObjectDefaultImpl getClassTypeNativeObjectDefault(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeObjectDefaultImpl)mgr.findClassType(CLASS.getName());   
    }    
    
    public static void registerClassTypeNativeObjectDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeObjectDefaultImpl classType = new ClassTypeNativeObjectDefaultImpl(mgr);
        classType.registerClassType();
    }    
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }
    
    public String getVMClassImplName()
    {
        return CLASS.getName();
    }
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    } 
    
    public Object newValueDefaultClass()
    {
        throw new JNIEasyException("Unknown native type");
    }
    
    public ClassTypeNativeCapableDefaultImpl getClassTypeNativeCapableDefault()
    {
        if (defaultClassType == null)
            this.defaultClassType = ClassTypeNativeCapableDefaultImpl.getClassTypeNativeCapableDefault(classTypeMgr);
        return defaultClassType;
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeObjectDefaultRuntimeImpl(this,rtMgr);
    }    
    
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeObjectDefaultImpl(this);
    }
    
}
