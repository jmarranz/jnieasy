/*
 * ClassTypeNativeCapableRuntimeImpl.java
 *
 * Created on 18 de mayo de 2005, 13:49
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;



/**
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeCapableRuntimeImpl extends ClassTypeNativeObjectRuntimeImpl
{
    protected JavaClassAsNativeCapableRuntimeImpl javaClassRt;
    protected NativeCapableInternal factoryInst;    
    
    /**
     * Creates a new instance of ClassTypeNativeCapableRuntimeImpl
     */
    public ClassTypeNativeCapableRuntimeImpl(ClassTypeNativeCapableImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeNativeCapableImpl getClassTypeNativeCapable()
    {
        return (ClassTypeNativeCapableImpl)classType;
    }
    
    public NativeCapableInternal getFactoryInstance()
    {
        // Para disminuir el footprint en el caso de que no se use        
        if (factoryInst == null)
        {
            try
            {
                this.factoryInst = (NativeCapableInternal)getClassImpl().newInstance();
            }
            catch(Exception ex)
            {
                throw new JNIEasyException(ex);
            }
        }    
        return factoryInst;
    }
    
    public Object newValue()
    {
        // De esta manera evitamos el Java Reflection de las clases del usuario, sólo se hará una vez por ClassLoader y no siempre, 
        // en todos los demás se usará el factoryInst
        return getFactoryInstance().jnieasyNewInstance();        
    }               
    
    public Object[] newArrayValue(int len)
    {
        // De esta manera evitamos el Java Reflection de las clases del usuario, sólo se hará una vez por ClassLoader y no siempre, 
        // en todos los demás se usará el factoryInst
        return getFactoryInstance().jnieasyNewArrayInstance(len);        
    }
    
    public JavaClassAsNativeCapableRuntimeImpl getJavaClassAsNativeCapableRuntime()
    {
        return javaClassRt;
    }
    
    public JavaClassAsNativeCapableRuntimeImpl setJavaClassAsNativeCapableRuntime(NativeCapableInternal factoryInst)
    {
        // Notar que sólo memorizamos un objeto por lo que recordamos sólo un Class
        // esto significa que si cambiamos el EnhancerLoader y cargamos la clase de nuevo
        // se perderá el anterior, en definitiva hay que trabajar sólo con un ClassLoader
        // (o varios pero delegados del principal) 
        this.factoryInst = factoryInst;
        this.classImpl = factoryInst.getClass();
        this.javaClassRt = newJavaClassAsNativeCapableRuntime();
        return javaClassRt;
    }
    
    public abstract JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime();
    
}

