/*
 * ClassTypeNativeRuntimeImpl.java
 *
 * Created on 6 de abril de 2005, 20:19
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;



public abstract class ClassTypeNativeRuntimeImpl
{
    public static final int VOID_RETURN        = 1;    
    public static final int BOOLEAN_RETURN     = 2;
    public static final int BYTE_RETURN        = 3;
    public static final int CHAR_RETURN        = 4;
    public static final int SHORT_RETURN       = 5;
    public static final int INT_RETURN         = 6;
    public static final int LONG_RETURN        = 7;
    public static final int FLOAT_RETURN       = 8;
    public static final int DOUBLE_RETURN      = 9;  
    
    public static final int POINTER_RETURN     = 10; 
    
    
    protected ClassTypeNativeImpl classType;
    protected RuntimeManagerImpl rtMgr;
    protected Class classImpl;
    
    /**
     * Creates a new instance of ClassTypeNativeRuntimeImpl
     */
    public ClassTypeNativeRuntimeImpl(ClassTypeNativeImpl classType,RuntimeManagerImpl rtMgr)
    {
        this.classType = classType;
        this.rtMgr = rtMgr;
    }
    
    public ClassTypeNativeImpl getClassType()
    {
        return classType;
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {
        return rtMgr;
    }
    
    public static String getClassName(Class cls)
    {
        if (cls.isArray())
            return ClassTypeNativeArrayRuntimeImpl.getClassName(cls);
        else
            return cls.getName();
    }        

    public static Class getClassFromVMClassName(String className,ClassLoader loader,boolean onErrorThrow)
    {
        // No tiene otra finalidad que tener un sólo punto donde se hace
        // el loading de clases
        try
        {
            // Aunque loader sea nulo (el ClassLoader root) 
            // funciona siempre que la clase sea cargable por el loader root, es decir
            // funciona si por ejemplo se usa el ClassLoader de String para cargar String[] 

            return Class.forName(className,true,loader);    
        }
        catch(ClassNotFoundException ex)
        {
            if (onErrorThrow) throw new JNIEasyException(ex);
            else return null;
        }        
    }
    
    public static Class getClass(String className,ClassLoader loader,boolean onErrorThrow)
    {
        // Class.forName() no funciona para 
        // los tipos simples y arrays (int, int[], Object[] etc)
        // En el caso de arrays Class.forName() funciona si 
        // si se usa la nomenclatura JNI: ej Class.forName("[I") es int[].class
        // pero para el usuario no es nada práctica
        
        Class clasz = null;
        clasz = ClassTypeNativePrimitiveRuntimeImpl.getClass(className); // resuelve los primitivos (int etc) pues no vale el Class.forName() y los wrappers (Integer etc)
        if (clasz != null) return clasz;
        className = ClassTypeNativeArrayImpl.toJNIArrayClassName(className);
        return getClassFromVMClassName(className,loader,onErrorThrow);
    }
        
    public Class getClassImpl()
    {
        if (classImpl != null)
            return classImpl;
        else
        {
            Class clasz;
            this.classImpl = classType.getDefaultImplClass();
            if (this.classImpl != null)
                return this.classImpl;
            
            String classNameImpl = classType.getVMClassImplName();
            if (classNameImpl == null) throw new JNIEasyException("Type not instanciable : " + classType.getClassName());
            this.classImpl = rtMgr.getTypeManagerRuntime().getClass(classNameImpl);
            return this.classImpl;
        }
    }
    
    public abstract int returnTypeCode();
    public abstract long getObjectSize();
    public abstract long getPreferredAlignSize();    
   
}
