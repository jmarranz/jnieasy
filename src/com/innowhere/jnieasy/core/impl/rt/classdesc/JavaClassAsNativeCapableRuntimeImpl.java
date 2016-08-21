/*
 * JavaClassAsNativeCapableRuntimeImpl.java
 *
 * Created on 25 de mayo de 2005, 14:48
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;
import com.innowhere.jnieasy.core.typedec.TypeNative;
import java.lang.reflect.Field;

/**
 *
 * @author jmarranz
 */

public abstract class JavaClassAsNativeCapableRuntimeImpl implements NativeClassDescriptor
{
    protected TypeNativeCapableRuntimeImpl typeDecRt;
    protected JavaClassAsNativeCapableImpl javaClass;
    protected ClassTypeNativeCapableRuntimeImpl classTypeRt;

    
    /**
     * Creates a new instance of JavaClassAsNativeCapableRuntimeImpl
     */
    public JavaClassAsNativeCapableRuntimeImpl(JavaClassAsNativeCapableImpl javaClass,ClassTypeNativeCapableRuntimeImpl classTypeRt)
    {
        this.javaClass = javaClass;
        this.classTypeRt = classTypeRt;
    }
    
    public JavaClassAsNativeCapableImpl getJavaClassAsNativeCapable()
    {
        return javaClass;
    }
    
    public ClassLoader getClassLoader()
    {
        return getJavaClass().getClassLoader();
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {    
        return classTypeRt.getRuntimeManager();
    }    

    public RuntimeContext getDefaultRuntimeContext()
    {    
        return classTypeRt.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
    }          
    
    public FieldOfClassRuntimeImpl newFieldOfClassRuntime(String fieldName,VarTypeNativeRuntimeImpl varTypeDec)
    {
        Field field;
        try
        {
            field = getJavaClass().getDeclaredField(fieldName);
        }
        catch(NoSuchFieldException ex)
        {
            throw new JNIEasyException(ex);
        }        
        FieldOfClassRuntimeImpl fieldRt = FieldOfClassRuntimeImpl.newFieldOfClassRuntime(field,varTypeDec,this);
        fieldRt.setVarTypeNativeRuntime(varTypeDec);
        return fieldRt;
    }

    public JNIEasyImpl getJNIEasy()
    {
        return getRuntimeManager().getJNIEasy();
    }
    
    public Class getJavaClass()
    {
        return classTypeRt.getClassImpl();
    }
    
    public TypeNative getType()
    {
        return typeDecRt;
    }
    
    public TypeNativeCapableRuntimeImpl getTypeNativeCapableRuntime()
    {
        return typeDecRt;
    }
    
    public static JavaClassAsNativeCapableRuntimeImpl sharedInitRegistrationClassTypeNativeCapable(ClassTypeNativeCapableImpl classType,NativeCapableInternal factoryInst,int licenseUsedByEnhancer)
    {    
        // El nombre de este método debería estar ofuscado para que
        // no se vea que es lo que se hace
        JNIEasyLibraryImpl dll = (JNIEasyLibraryImpl)classType.getJNIEasy().getJNIEasyLib();
        dll.checkLicense(5 /* REGISTERING_ENHANCED_CLASS */,licenseUsedByEnhancer);
        
        ClassTypeNativeCapableRuntimeImpl classTypeRt = (ClassTypeNativeCapableRuntimeImpl)classType.getClassTypeRuntime();
        JavaClassAsNativeCapableRuntimeImpl javaClassRt = classTypeRt.setJavaClassAsNativeCapableRuntime(factoryInst);
        return javaClassRt;        
    }        
    
    public abstract void finalizeRegistration();
}
