/*
 * ClassTypeStructureDefaultImpl.java
 *
 * Created on 3 de diciembre de 2004, 13:07
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeStructureDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.StructureDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;


public class ClassTypeStructureDefaultImpl extends ClassTypeStructureImpl
{
    public static final Class INTERFACE = Structure.class;
    public static final Class CLASS = StructureDefaultImpl.class;     
    
    /** Creates a new instance of ClassTypeStructureDefaultImpl */
    public ClassTypeStructureDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeStructureDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeStructureDefaultImpl classType = new ClassTypeStructureDefaultImpl(mgr);
        classType.registerClassType();         
    }    
    
    public String getVMClassName()
    {
        return INTERFACE.getName();
    } 
    
    public String getVMClassImplName()
    {
        return CLASS.getName();
    }

    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeStructureDefaultRuntimeImpl(this,rtMgr); 
    }

}
