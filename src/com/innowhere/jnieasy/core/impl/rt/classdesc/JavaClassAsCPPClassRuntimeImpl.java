/*
 * JavaClassAsCPPClassRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 12:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsCPPClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCPPClassCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeCPPClassCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.CPPClassDescriptor;


/**
 *
 * @author jmarranz
 */
public class JavaClassAsCPPClassRuntimeImpl extends JavaClassAsNativeSeparatedFieldContainerRuntimeImpl implements CPPClassDescriptor
{
    /**
     * Creates a new instance of JavaClassAsCPPClassRuntimeImpl 
     */
    public JavaClassAsCPPClassRuntimeImpl(JavaClassAsCPPClassImpl javaClass,ClassTypeCPPClassCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }    
    
    public ClassTypeCPPClassCustomRuntimeImpl getClassTypeCPPClassCustomRuntime()
    {
        return (ClassTypeCPPClassCustomRuntimeImpl)classTypeRt;
    }

    public static JavaClassAsCPPClassRuntimeImpl initRegistrationCPPClassCustomType(NativeCapableInternal factoryInst,String superClassName,String desiredAlignSize,int licenseUsedByEnhancer,JNIEasyImpl jniEasy)
    {    
        RuntimeContext ctx = jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
        Class clasz = factoryInst.getClass();
        ClassTypeCPPClassCustomImpl classType = ClassTypeCPPClassCustomRuntimeImpl.registerCPPClassCustomType(clasz,ctx);
        return (JavaClassAsCPPClassRuntimeImpl)initRegistrationMultipleFieldContainerType(classType,factoryInst, superClassName, desiredAlignSize,licenseUsedByEnhancer,ctx);
    }
}
