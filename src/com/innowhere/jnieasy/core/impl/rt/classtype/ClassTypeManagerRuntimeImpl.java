/*
 * ClassTypeManagerRuntimeImpl.java
 *
 * Created on 16 de febrero de 2005, 15:00
 */

package com.innowhere.jnieasy.core.impl.rt.classtype;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;

public class ClassTypeManagerRuntimeImpl
{
    protected RuntimeManagerImpl rtMgr;
    protected ClassTypeManagerImpl classTypeMgr;
    
    /** Creates a new instance of ClassTypeManagerRuntimeImpl */
    public ClassTypeManagerRuntimeImpl(RuntimeManagerImpl rtMgr,ClassTypeManagerImpl classTypeMgr)
    {
        this.rtMgr = rtMgr;
        this.classTypeMgr = classTypeMgr;
    }

    public ClassTypeManagerImpl getClassTypeManager()
    {
        return classTypeMgr;
    }

    public ClassTypeNativeRuntimeImpl findClassType(Class clasz)
    {
        ClassTypeNativeImpl classType = getClassTypeManager().findClassType(clasz.getName());
        if (classType == null) return null;        
        return classType.getClassTypeRuntime();  
    }
}
