/*
 * RuntimeContextNotUsingImports.java
 *
 * Created on 6 de julio de 2005, 11:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;


/**
 * Como no se usan imports los nombres usados han de ser absolutos.
 * De esta manera ganamos velocidad. 
 *
 * @author jmarranz
 */
public class RuntimeContextNotUsingImports extends RuntimeContext
{

    /**
     * Creates a new instance of RuntimeContextNotUsingImports
     */
    public RuntimeContextNotUsingImports(RuntimeManagerImpl rtMgr)
    {
        super(rtMgr);
    }

    public ClassTypeNativeImpl findClassType(String className)
    {
        return classTypeMgr.findClassType(className);
    }          
    
    public MetaClassWrapper newMetaClassWrapper(String className)
    {
        Class clasz = rtMgr.getTypeManagerRuntime().getClass(className);
        return new ClassWrapper(clasz);
    } 
}
