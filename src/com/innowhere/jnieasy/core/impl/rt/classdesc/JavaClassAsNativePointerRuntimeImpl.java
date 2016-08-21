/*
 * JavaClassAsNativePointerRuntimeImpl.java
 *
 * Created on 26 de mayo de 2005, 17:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePointerCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativePointerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePointerCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePointerRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativePointerDescriptor;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsNativePointerRuntimeImpl extends JavaClassAsNativeObjectFieldContainerRuntimeImpl implements NativePointerDescriptor
{
   
    /**
     * Creates a new instance of JavaClassAsNativePointerRuntimeImpl
     */
    public JavaClassAsNativePointerRuntimeImpl(JavaClassAsNativePointerImpl javaClass,ClassTypeNativePointerRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }

    public static JavaClassAsNativePointerRuntimeImpl initRegistrationPointerType(NativeCapableInternal factoryInst,String pointerClassName,int licenseUsedByEnhancer,JNIEasyImpl jniEasy)
    {    
        RuntimeContext ctx = jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
        Class clasz = factoryInst.getClass();
        Class pointerClass = ClassTypeNativeRuntimeImpl.getClass(pointerClassName, clasz.getClassLoader(), true);
        ClassTypeNativePointerCustomImpl classType = ClassTypeNativePointerCustomRuntimeImpl.registerPointerCustomType(clasz, pointerClass,ctx);
        
        JavaClassAsNativePointerRuntimeImpl javaClassRt = (JavaClassAsNativePointerRuntimeImpl)sharedInitRegistrationClassTypeNativeCapable(classType,factoryInst,licenseUsedByEnhancer);
        
        return javaClassRt;        
    }    
    
    public ClassTypeNativePointerCustomRuntimeImpl getClassTypeNativePointerCustomRuntime()
    {
        return (ClassTypeNativePointerCustomRuntimeImpl)classTypeRt;
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
        ClassTypeNativePointerCustomRuntimeImpl classTypeRt = getClassTypeNativePointerCustomRuntime();
        ClassTypeNativePointerCustomImpl classType = (ClassTypeNativePointerCustomImpl)classTypeRt.getClassTypeNativeCapable();
        
        VarTypeNativeObjectImpl fieldVarType = (VarTypeNativeObjectImpl)fieldRt.getVarTypeNativeRuntime().getVarTypeNative();
                
        TypeNativePointerImpl typeDec = (TypeNativePointerImpl)classType.newTypeNative();
        typeDec.setAddressedVarTypeNativeObject(fieldVarType);
        
        // Nada que hacer respecto a registrar el tamaño, ya se sabe por el field
        this.typeDecRt = (TypeNativePointerRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(getJavaClass(),typeDec,getDefaultRuntimeContext()); 
    }  

}
