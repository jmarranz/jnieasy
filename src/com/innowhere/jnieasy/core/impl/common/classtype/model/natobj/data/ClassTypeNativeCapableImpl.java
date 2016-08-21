/*
 * ClassTypeNativeCapableImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.codegen.CodeGenContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeBehaviorDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeDLLBehaviorImpl;

public abstract class ClassTypeNativeCapableImpl extends ClassTypeNativeObjectImpl
{
    public JavaClassAsNativeCapableImpl javaClass;

    /**
     * Creates a new instance of ClassTypeNativeCapableImpl
     */
    public ClassTypeNativeCapableImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeCapable(ClassTypeManagerImpl mgr)
    {
        // no se registrar aquí, se hace en otro sitio (porque debe hacerse antes)
        // ClassTypeNativeCapableDefaultImpl.registerClassTypeNativeCapableDefault(mgr);        
        ClassTypeNativeFieldContainerImpl.registerClassTypeFieldContainer(mgr);        
        ClassTypeDLLBehaviorImpl.registerClassTypeDLLBehavior(mgr);      
        ClassTypeNativeDirectCallbackImpl.registerClassTypeNativeDirectCallback(mgr);
        ClassTypeNativeBehaviorDefaultImpl.registerClassTypeNativeBehaviorDefault(mgr);
        ClassTypeNativeCallbackDefaultImpl.registerClassTypeNativeCallbackDefault(mgr);                         
    }

    public static ClassTypeNativeCapableImpl newCustomClassTypeNativeCapable(MetaClassWrapper valueClass,TaskContext ctx)
    {
        if (ClassTypeNativeFieldContainerImpl.isAssignableFrom(valueClass))
            return ClassTypeNativeFieldContainerImpl.newCustomClassTypeFieldContainer(valueClass,ctx);
        else if (ClassTypeNativeDirectCallbackImpl.isAssignableFrom(valueClass))
            return ClassTypeNativeDirectCallbackImpl.newCustomClassTypeNativeDirectCallback(valueClass,ctx.getJNIEasy());
        else if (ClassTypeCanBeNativeCapableWrapperImpl.isAssignableFrom(valueClass))
            return ClassTypeCanBeNativeCapableWrapperImpl.newCustomClassTypeCanBeNativeCapableWrapper(valueClass,ctx);            
        else if (ctx instanceof CodeGenContext) // Es el caso de tipo desconocido, útil en generación de código de proxies  
            return ClassTypeNativeMultipleFieldContainerUnknownImpl.newClassTypeMultipleFieldContainerUnknown(valueClass.getName(), ctx.getJNIEasy());
            /* Usamos ClassTypeNativeMultipleFieldContainerUnknownImpl en vez de un posible ClassTypeNativeCapableUnknownImpl para que al menos pueda ser usada la clase como clase this
             * de tipos de dato método
             */
        return null;
    }    

    public static boolean isAssignableFrom(MetaClassWrapper valueClass)
    {
        return MetaClassWrapper.isAssignableFrom(NativeCapable.class,valueClass);
    }      

    public Class getDefaultImplClass()    
    {
        // Depende del ClassLoader
        return null;
    }
    
    public Object newValueDefaultClass()
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
    
    public JavaClassAsNativeCapableImpl getJavaClassAsNativeCapable()
    {
        if (javaClass == null)
            this.javaClass = newJavaClassAsNativeCapable(this);
        return javaClass;        
    }    
    
    public abstract JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType);   
}
