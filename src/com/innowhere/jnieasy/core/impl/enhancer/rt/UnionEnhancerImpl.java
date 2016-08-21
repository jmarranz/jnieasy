/*
 * UnionEnhancerImpl.java
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
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsUnionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.UnionDescriptor;


/**
 *
 * @author jmarranz
 */
public class UnionEnhancerImpl extends NativeMultipleFieldContainerEnhancerImpl
{
    
    /** Creates a new instance of UnionEnhancerImpl */
    public UnionEnhancerImpl()
    {
    }
    
    public static UnionDescriptor initRegistrationUnionType(NativeCapableInternal factoryInst,String desiredAlignSize,int licenseUsedByEnhancer,JNIEasy jnieasy)
    {
        // Sólo structuras y clases
        return JavaClassAsUnionRuntimeImpl.initRegistrationUnionCustomType(factoryInst,desiredAlignSize,licenseUsedByEnhancer,(JNIEasyImpl)jnieasy);
    }
}
