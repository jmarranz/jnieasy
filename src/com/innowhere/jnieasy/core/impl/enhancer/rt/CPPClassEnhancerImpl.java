/*
 * CPPClassEnhancerImpl.java
 *
 * Created on 16 de septiembre de 2005, 8:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.rt;

import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsCPPClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.CPPClassDescriptor;

/**
 *
 * @author jmarranz
 */
public class CPPClassEnhancerImpl extends NativeSeparatedFieldContainerEnhancerImpl
{
    
    /** Creates a new instance of CPPClassEnhancerImpl */
    public CPPClassEnhancerImpl()
    {
    }
    
    public static CPPClassDescriptor initRegistrationCPPClassType(NativeCapableInternal factoryInst,String superClassName,String desiredAlignSize,int licenseUsedByEnhancer,JNIEasy jnieasy)
    {
        // Sólo structuras y clases
        return JavaClassAsCPPClassRuntimeImpl.initRegistrationCPPClassCustomType(factoryInst,superClassName,desiredAlignSize,licenseUsedByEnhancer,(JNIEasyImpl)jnieasy);
    }   
}
