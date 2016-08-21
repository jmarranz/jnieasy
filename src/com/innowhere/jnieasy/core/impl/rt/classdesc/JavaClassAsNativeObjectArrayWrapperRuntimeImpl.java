/*
 * JavaClassAsNativeObjectArrayWrapperRuntimeImpl.java
 *
 * Created on 26 de mayo de 2005, 17:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeObjectArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeObjectArrayDescriptor;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativeObjectArrayWrapperRuntimeImpl extends JavaClassAsNativeObjectFieldContainerRuntimeImpl implements NativeObjectArrayDescriptor
{
    /**
     * Creates a new instance of JavaClassAsNativeObjectArrayWrapperRuntimeImpl
     */
    public JavaClassAsNativeObjectArrayWrapperRuntimeImpl(JavaClassAsNativeObjectArrayWrapperImpl javaClass,ClassTypeNativeObjectArrayWrapperRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }

    public static JavaClassAsNativeObjectArrayWrapperRuntimeImpl initRegistrationObjectArrayWrapperType(NativeCapableInternal factoryInst,String arrayClassName,int licenseUsedByEnhancer,JNIEasyImpl jniEasy)
    {    
        RuntimeContext ctx = jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
        Class clasz = factoryInst.getClass();
        Class arrayClass = ClassTypeNativeRuntimeImpl.getClass(arrayClassName, clasz.getClassLoader(), true);
        ClassTypeNativeObjectArrayWrapperImpl classType = ClassTypeNativeObjectArrayWrapperRuntimeImpl.registerCustomObjectArrayWrapperType(clasz, arrayClass,ctx);
        
        JavaClassAsNativeObjectArrayWrapperRuntimeImpl javaClassRt = (JavaClassAsNativeObjectArrayWrapperRuntimeImpl)sharedInitRegistrationClassTypeNativeCapable(classType,factoryInst,licenseUsedByEnhancer);
        
        return javaClassRt;        
    }    
    
    public ClassTypeNativeObjectArrayWrapperRuntimeImpl getClassTypeNativeObjectArrayWrapperRuntime()
    {
        return (ClassTypeNativeObjectArrayWrapperRuntimeImpl)classTypeRt;
    }
    
    public long size()
    {
        return typeDecRt.size();
    }
    
    public long alignSize()
    {
        return typeDecRt.preferredAlignSize();
    }
    
    public void finalizeRegistration()
    {
//        ClassTypeNativeObjectArrayWrapperRuntimeImpl classTypeRt = getClassTypeNativeObjectArrayWrapperRuntime();
//        ClassTypeNativeObjectArrayWrapperImpl classType = (ClassTypeNativeObjectArrayWrapperImpl)classTypeRt.getClassTypeNativeCapable();
        
        TypeNativeArrayImpl fieldType = (TypeNativeArrayImpl)this.fieldRt.getVarTypeNativeRuntime().getTypeNativeRuntime().getTypeNative();
        
        TypeNativeObjectArrayWrapperImpl typeDec = (TypeNativeObjectArrayWrapperImpl)fieldType.getTypeCanBeNativeCapableWrapper();
/*                
        TypeNativeObjectArrayWrapperImpl typeDec = (TypeNativeObjectArrayWrapperImpl)classType.newTypeNative();
        fieldType.setTypeCanBeNativeCapableWrapper(typeDec);
        typeDec.setTypeCanBeNativeCapable(fieldType);
*/
        
        // Nada que hacer respecto a registrar el tamaño, ya se sabe por el field
        this.typeDecRt = (TypeNativeArrayWrapperRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(getJavaClass(),typeDec,getDefaultRuntimeContext()); 
    }  
    
    public TypeNativeArrayWrapperRuntimeImpl getTypeNativeArrayWrapperRuntime()
    {
        return (TypeNativeArrayWrapperRuntimeImpl)typeDecRt;
    }            
            
    public static void copyDimensionsTo(ClassTypeNativeObjectArrayWrapperImpl classType,TypeNativeObjectArrayWrapperImpl typeDecTarget)
    {
        ClassTypeNativeObjectArrayWrapperRuntimeImpl classTypeRt = (ClassTypeNativeObjectArrayWrapperRuntimeImpl)classType.getClassTypeRuntime();
        JavaClassAsNativeObjectArrayWrapperRuntimeImpl javaClass = (JavaClassAsNativeObjectArrayWrapperRuntimeImpl)classTypeRt.getJavaClassAsNativeCapableRuntime();
        if (javaClass != null)
            javaClass.copyDimensionsTo(typeDecTarget);    
    }
        
    public void copyDimensionsTo(TypeNativeObjectArrayWrapperImpl typeDecTarget)
    {
        TypeNativeArrayWrapperRuntimeImpl typeDecRt = getTypeNativeArrayWrapperRuntime();
        if (typeDecRt == null) return; // Es el propio TypeDec por defecto que todavía no ha sido definido, no tiene sentido copiarse "a si mismo", debe ser patrón de los demás
        
        typeDecRt.getTypeNativeArrayInfoRuntime().getTypeNativeArrayInfo().copyDimensionsTo(typeDecTarget.getTypeNativeArrayInfo());
    }
}
