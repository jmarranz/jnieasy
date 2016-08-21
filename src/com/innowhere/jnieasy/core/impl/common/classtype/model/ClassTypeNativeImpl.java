/*
 * ClassTypeNativeImpl.java
 *
 * Created on 15 de enero de 2004, 19:09
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.xml.ClassTypeDefaultXML;
import com.innowhere.jnieasy.core.impl.common.classtype.xml.ClassTypeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;


public abstract class ClassTypeNativeImpl
{
    protected String className;
    protected ClassTypeNativeRuntimeImpl classTypeRt;
    protected ClassTypeManagerImpl classTypeMgr;
    protected ClassTypeNativeArrayImpl classTypeArray;
    
    /**
     * Creates a new instance of ClassTypeNativeImpl
     */
    public ClassTypeNativeImpl(ClassTypeManagerImpl classTypeMgr)
    {
        this.classTypeMgr = classTypeMgr;
    }

    public static ClassTypeNativeImpl newCustomClassType(MetaClassWrapper valueClass,TaskContext ctx)
    {
        return ClassTypeNativeObjectImpl.newCustomObjectType(valueClass,ctx);
    }    
    
    public static void registerAllClassTypes(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveImpl.registerClassTypeNativePrimitive(mgr);
        ClassTypeNativeObjectImpl.registerClassTypeNativeObject(mgr);       
    }

    public void registerClassType()
    {    
        registerClassType(false);
    }
    
    public void registerClassType(boolean overwrite)
    {
        String className = getVMClassName();
        classTypeMgr.registerType(className, this,overwrite);
        String classNameImpl = getVMClassImplName();      
        if ((classNameImpl != null)&& (!className.equals(classNameImpl)))
            classTypeMgr.registerType(classNameImpl, this,overwrite); 
    }    
    
    public ClassTypeManagerImpl getClassTypeManager()
    {
        return classTypeMgr;
    }
    
    public JNIEasyImpl getJNIEasy()
    {
        return classTypeMgr.getJNIEasy();
    }
    
    public boolean equals(Object obj)
    {    
        if (obj == null) return false;        
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        // Aunque sean objetos diferentes los consideramos iguales
        // si coincide la clase

        ClassTypeNativeImpl classType2 = (ClassTypeNativeImpl)obj;
        if (!getClassName().equals(classType2.getClassName()))
            return false;
        return true;
    }    
    
    public int hashCode()
    {
        return getClassName().hashCode();
    }
    
    public String getClassName()
    {
        if (className == null) // No cambia el nombre de la clase, no hay problema
            className = normalizeClassName(getVMClassName());
        return className;
    }
    
    public static String normalizeClassName(String className)
    {
        // Es el caso de nombre de clase tipo array que puede estar en formato 
	// JNI y queremos que esté en formato normal Java
        if (className.charAt(0) == '[') // Formato array JNI
            return ClassTypeNativeArrayImpl.normalizeJNIClassName(className);
        else
            return className;
    }    
   
   
    public ClassTypeNativeRuntimeImpl getClassTypeRuntime()
    {
        if (classTypeRt == null)
        {
            // De esta manera es un poquito más lento pero disminuimos el footprint de aquellos tipos
            // no usados nunca             
            classTypeRt = newClassTypeRuntime(getJNIEasy().getRuntimeManager());
        }
        return (ClassTypeNativeRuntimeImpl)classTypeRt;
    }    
    
    public ClassTypeNativeArrayImpl getClassTypeArray(TaskContext ctx)
    {
        if (classTypeArray == null)        
            this.classTypeArray = (ClassTypeNativeArrayImpl)ctx.getClassType(getClassName() + "[]");        
        return classTypeArray;
    }
    
    public abstract String getVMClassName(); // La interface o la clase normal 
    public abstract String getVMClassImplName();  // La clase implementación o la clase normal (instanciable)
    public abstract Class getDefaultImplClass();
    
    public abstract ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr);
    
    public abstract TypeNativeImpl newTypeNative();    
    
    public ClassTypeXML newClassTypeXML()
    {
        return new ClassTypeDefaultXML(this);
    }
            
}
