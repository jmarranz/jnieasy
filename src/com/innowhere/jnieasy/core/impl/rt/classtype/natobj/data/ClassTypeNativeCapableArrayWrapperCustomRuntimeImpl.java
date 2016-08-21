/*
 * ClassTypeNativeCapableArrayWrapperCustomRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 20:09
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableArrayWrapperCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeObjectArrayWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;


/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeCapableArrayWrapperCustomRuntimeImpl extends ClassTypeNativeCapableArrayWrapperRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
   
    /**
     * Creates a new instance of ClassTypeNativeCapableArrayWrapperCustomRuntimeImpl
     */
    public ClassTypeNativeCapableArrayWrapperCustomRuntimeImpl(ClassTypeNativeCapableArrayWrapperCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeNativeCapableArrayWrapperCustomImpl getClassTypeNativeCapableArrayWrapperCustom()
    {
        return (ClassTypeNativeCapableArrayWrapperCustomImpl)classType;
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
        return new JavaClassAsNativeObjectArrayWrapperRuntimeImpl((JavaClassAsNativeObjectArrayWrapperImpl)getClassTypeNativeCapableArrayWrapperCustom().getJavaClassAsNativeCapable(),this);       
    }     
   
    
}
