/*
 * ClassTypeNativeMultipleFieldContainerUnknownImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerUnknownImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl;




public class ClassTypeNativeMultipleFieldContainerUnknownImpl extends ClassTypeNativeMultipleFieldContainerImpl implements ClassTypeCustomEnhanced
{

    /**
     * Creates a new instance of ClassTypeNativeMultipleFieldContainerUnknownImpl
     */
    public ClassTypeNativeMultipleFieldContainerUnknownImpl(String className,ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
        
        this.className = className;
    }
    
    public static ClassTypeNativeMultipleFieldContainerUnknownImpl newClassTypeMultipleFieldContainerUnknown(String className,JNIEasyImpl jniEasy)
    {
        return new ClassTypeNativeMultipleFieldContainerUnknownImpl(className, jniEasy.getClassTypeManager());
    }
    
    public String getVMClassName()
    {
        return className;
    } 
    
    public String getVMClassImplName()
    {
        return className;
    }
   
    public void registerClassType()
    {
        // Redefinimos para evitar que se registre pues impediría que 
        // posteriormente se registrara el Type correcto una vez enhanced etc.
    }

    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        return new JavaClassAsNativeMultipleFieldContainerUnknownImpl(this);  
    }   
    
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeMultipleFieldContainerUnknownRuntimeImpl(this,rtMgr);
   }
}
