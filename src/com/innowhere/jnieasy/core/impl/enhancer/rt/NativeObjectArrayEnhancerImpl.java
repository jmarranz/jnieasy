/*
 * NativeObjectArrayEnhancerImpl.java
 *
 * Created on 22 de marzo de 2005, 21:09
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj.TypeNativeArrayWrapperParserImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.NativeObjectArrayDescriptor;



public class NativeObjectArrayEnhancerImpl extends NativeObjectFieldContainerEnhancerImpl
{
    
    /**
     * Creates a new instance of NativeObjectArrayEnhancerImpl
     */
    public NativeObjectArrayEnhancerImpl()
    {
    }

    public static NativeObjectArrayDescriptor initRegistrationObjectArrayType(NativeCapableInternal factoryInst,String arrayClassName,int licenseUsedByEnhancer,JNIEasy jnieasy)
    {
        return JavaClassAsNativeObjectArrayWrapperRuntimeImpl.initRegistrationObjectArrayWrapperType(factoryInst, arrayClassName,licenseUsedByEnhancer,(JNIEasyImpl)jnieasy);
    }
    
    public static int[] parseDims(String strDims)
    {
        return TypeNativeArrayWrapperParserImpl.parseDims(strDims);
    }

}
