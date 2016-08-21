/*
 * JavaClassAsStructureRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 13:10
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsStructureImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeStructureCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeStructureCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.StructureDescriptor;

/**
 *
 * @author jmarranz
 */
public class JavaClassAsStructureRuntimeImpl extends JavaClassAsNativeSeparatedFieldContainerRuntimeImpl implements StructureDescriptor
{
    
    /**
     * Creates a new instance of JavaClassAsStructureRuntimeImpl 
     */
    public JavaClassAsStructureRuntimeImpl(JavaClassAsStructureImpl javaClass,ClassTypeStructureCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }
    
    public static JavaClassAsStructureRuntimeImpl initRegistrationStructureCustomType(NativeCapableInternal factoryInst,String superClassName,String desiredAlignSize,int licenseUsedByEnhancer,JNIEasyImpl jniEasy)
    {    
        RuntimeContext ctx = jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
        Class clasz = factoryInst.getClass();
        ClassTypeStructureCustomImpl classType = ClassTypeStructureCustomRuntimeImpl.registerStructureCustomType(clasz,ctx);
        return (JavaClassAsStructureRuntimeImpl)initRegistrationMultipleFieldContainerType(classType,factoryInst, superClassName, desiredAlignSize, licenseUsedByEnhancer, ctx);
    }    
}
