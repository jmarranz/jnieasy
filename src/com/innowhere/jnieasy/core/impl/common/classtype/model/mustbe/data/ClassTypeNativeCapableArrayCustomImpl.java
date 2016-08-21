/*
 * ClassTypeNativeCapableArrayCustomImpl.java
 *
 * Created on 3 de diciembre de 2004, 9:54
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeCapableArrayCustomRuntimeImpl;



public class ClassTypeNativeCapableArrayCustomImpl extends ClassTypeNativeCapableArrayImpl
{
    protected String vmClassName;
    
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayCustomImpl
     */
    public ClassTypeNativeCapableArrayCustomImpl(String className,ClassTypeNativeCapableImpl compType)
    {
        super(compType);
        this.vmClassName = toJNIArrayClassName(className);        
    }
    
    public static void registerClassTypeNativeCapableArrayCustom(ClassTypeManagerImpl mgr)
    {
        // Nada que registrar
    }
    
    public static ClassTypeNativeCapableArrayCustomImpl newNativeCapableArrayCustomType(String className,ClassTypeNativeCapableImpl compType,TaskContext ctx)
    {
        ClassTypeNativeCapableArrayCustomImpl classType = new ClassTypeNativeCapableArrayCustomImpl(className,compType);
        ClassTypeNativeCapableArrayWrapperDefaultImpl wrapperClassType = new ClassTypeNativeCapableArrayWrapperDefaultImpl(classType, ctx.getJNIEasy().getClassTypeManager(),true);
        return classType;
    }   

    public String getVMClassName()
    {
        return vmClassName;
    }   
        
    public Class getDefaultImplClass()    
    {
        // No hay, hay que especificar el ClassLoader
        return null;
    }
    
    public Object newValueDefaultClass(int length)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeCapableArrayCustomRuntimeImpl(this,rtMgr);
    }    

}
