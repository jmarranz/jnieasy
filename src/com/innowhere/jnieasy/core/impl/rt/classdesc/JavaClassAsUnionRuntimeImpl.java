/*
 * JavaClassAsUnionRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 12:58
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsUnionImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeUnionCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeUnionCustomRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.UnionDescriptor;



/**
 *
 * @author jmarranz
 */
public class JavaClassAsUnionRuntimeImpl extends JavaClassAsNativeMultipleFieldContainerRuntimeImpl implements UnionDescriptor
{
    /**
     * Creates a new instance of JavaClassAsUnionRuntimeImpl 
     */
    public JavaClassAsUnionRuntimeImpl(JavaClassAsUnionImpl javaClass,ClassTypeUnionCustomRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }    
    
    public ClassTypeUnionCustomRuntimeImpl getClassTypeUnionCustomRuntime()
    {
        return (ClassTypeUnionCustomRuntimeImpl)classTypeRt;
    }

    public static JavaClassAsUnionRuntimeImpl initRegistrationUnionCustomType(NativeCapableInternal factoryInst,String desiredAlignSize,int licenseUsedByEnhancer,JNIEasyImpl jniEasy)
    {    
        RuntimeContext ctx = jniEasy.getRuntimeManager().getDefaultRuntimeContextNotUsingImports();
        Class clasz = factoryInst.getClass();
        ClassTypeUnionCustomImpl classType = ClassTypeUnionCustomRuntimeImpl.registerUnionCustomType(clasz,ctx);
        return (JavaClassAsUnionRuntimeImpl)initRegistrationMultipleFieldContainerType(classType,factoryInst, null, desiredAlignSize, licenseUsedByEnhancer, ctx);
    }

}
