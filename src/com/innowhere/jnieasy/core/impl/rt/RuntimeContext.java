/*
 * RuntimeContext.java
 *
 * Created on 28 de febrero de 2005, 11:51
 */

package com.innowhere.jnieasy.core.impl.rt;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;

public abstract class RuntimeContext extends TaskContext 
{
    protected RuntimeManagerImpl rtMgr;
    
    /** Creates a new instance of RuntimeContext */
    public RuntimeContext(RuntimeManagerImpl rtMgr)
    {
        super(rtMgr.getJNIEasy());  
        
        this.rtMgr = rtMgr;
    }

    public RuntimeManagerImpl getRuntimeManager()
    {
        return rtMgr;
    }
    
    public ClassTypeNativeRuntimeImpl getClassTypeRuntime(Class clasz)
    {    
        ClassTypeNativeImpl classType = getClassType(clasz);
        // Nunca será nulo pues antes da error
        return classType.getClassTypeRuntime();
    }
    
    public ClassTypeNativeImpl getClassType(Class clasz)
    {
        return getClassType(new ClassWrapper(clasz));    
    }
    
    public ClassTypeNativeImpl getClassType(Class clasz, boolean throwError)
    {    
        return getClassType(new ClassWrapper(clasz),throwError);        
    }
    
    protected ClassTypeNativeImpl getClassTypeNotFindInternal(MetaClassWrapper clasz, boolean throwError)
    {
        return classTypeMgr.getClassType(clasz,this,true,throwError);
    }
}
