/*
 * ClassTypeNativeArrayOfArrayWrapperCustomRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 19:51
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeArrayOfArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeArrayOfArrayWrapperCustomRuntimeImpl extends ClassTypeNativeArrayOfArrayWrapperRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
   
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayWrapperCustomRuntimeImpl
     */
    public ClassTypeNativeArrayOfArrayWrapperCustomRuntimeImpl(ClassTypeNativeArrayOfArrayWrapperCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeNativeArrayOfArrayWrapperCustomImpl getClassTypeNativeArrayOfArrayWrapperCustom()
    {
        return (ClassTypeNativeArrayOfArrayWrapperCustomImpl)classType;
    }
    
    public long getObjectSize()
    {
        return javaClassRt.size();
    }   
        
    public long getPreferredAlignSize()
    {
        return javaClassRt.alignSize();
    }        
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        return new JavaClassAsNativeObjectArrayWrapperRuntimeImpl((JavaClassAsNativeObjectArrayWrapperImpl)getClassTypeNativeArrayOfArrayWrapperCustom().getJavaClassAsNativeCapable(),this); 
    }

}
