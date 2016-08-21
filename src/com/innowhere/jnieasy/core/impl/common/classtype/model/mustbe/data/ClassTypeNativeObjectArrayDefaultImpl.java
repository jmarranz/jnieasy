/*
 * ClassTypeNativeObjectArrayDefaultImpl.java
 *
 * Created on 7 de marzo de 2005, 13:43
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeObjectDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeObjectArrayDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeObjectArrayWrapperDefaultImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data.ClassTypeNativeObjectArrayDefaultRuntimeImpl;


public class ClassTypeNativeObjectArrayDefaultImpl extends ClassTypeNativeObjectArrayImpl
{
    public static final Class CLASS = Object[].class;
    
    /**
     * Creates a new instance of ClassTypeNativeObjectArrayDefaultImpl
     */
    public ClassTypeNativeObjectArrayDefaultImpl(ClassTypeManagerImpl mgr)
    {
        super(ClassTypeNativeObjectDefaultImpl.getClassTypeNativeObjectDefault(mgr));
    }

    public static void registerClassTypeNativeObjectArrayDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeObjectArrayDefaultImpl classType = new ClassTypeNativeObjectArrayDefaultImpl(mgr);
        classType.registerClassType();
    }
    
    public static ClassTypeNativeObjectArrayDefaultImpl getClassTypeNativeObjectArrayDefault(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeObjectArrayDefaultImpl)mgr.findClassType(CLASS.getName());   
    }
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
  
    public Object newValueDefaultClass(int length)
    {
        return new Object[length];
    }
    
    public ClassTypeNativeObjectArrayWrapperDefaultImpl getClassTypeNativeObjectArrayWrapperDefault()
    {
        return (ClassTypeNativeObjectArrayWrapperDefaultImpl)wrapperClassType;
    }
            
    public TypeNativeImpl newTypeNative()
    {
        return new TypeNativeObjectArrayDefaultImpl(this);
    }
    
    public TypeCanBeNativeCapableImpl newTypeCanBeNativeCapable(TypeCanBeNativeCapableWrapperImpl wrapperType)
    {
        return new TypeNativeObjectArrayDefaultImpl(this,(TypeNativeObjectArrayWrapperDefaultImpl)wrapperType);        
    }
    
    public TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp)
    {
        return new TypeNativeObjectArrayDefaultImpl(this,varTypeComp);
    }
                
    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeObjectArrayDefaultRuntimeImpl(this,rtMgr);
    } 
}
