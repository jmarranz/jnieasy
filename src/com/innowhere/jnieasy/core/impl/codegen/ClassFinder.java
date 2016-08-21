/*
 * ClassFinder.java
 *
 * Created on 30 de marzo de 2005, 19:26
 */

package com.innowhere.jnieasy.core.impl.codegen;
import com.innowhere.jnieasy.core.impl.common.ClassInfoFinder;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;

public class ClassFinder extends ClassInfoFinder
{
    protected NativeTypeManagerRuntimeImpl typeDecMgr;
    
    /** Creates a new instance of ClassFinder */
    public ClassFinder(NativeTypeManagerRuntimeImpl typeDecMgr)
    {
        this.typeDecMgr = typeDecMgr;
    }
    
    public Object find(String className)
    {
        return typeDecMgr.getClass(className,false);
    }
    
}
