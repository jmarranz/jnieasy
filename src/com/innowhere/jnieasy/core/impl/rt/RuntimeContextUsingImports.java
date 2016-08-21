/*
 * RuntimeContextUsingImports.java
 *
 * Created on 6 de julio de 2005, 11:31
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.ClassResolver;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeFinder;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.ImportList;
import com.innowhere.jnieasy.core.impl.codegen.ClassFinder;


/**
 *
 * @author jmarranz
 */
public class RuntimeContextUsingImports extends RuntimeContext
{
    protected ClassResolver classTypeResolver;
    protected ClassResolver classResolver;
    protected ImportList importList;
    
    /**
     * Creates a new instance of RuntimeContextUsingImports 
     */
    public RuntimeContextUsingImports(RuntimeManagerImpl rtMgr,String[] importList)
    {
        super(rtMgr);

        ClassTypeFinder classTypeFinder = rtMgr.getClassTypeManagerRuntime().getClassTypeManager().getClassTypeFinder();
        ClassFinder classFinder = rtMgr.getTypeManagerRuntime().getClassFinder();      
        
        this.importList = new ImportList(importList);
        this.classTypeResolver = new ClassResolver(null,this.importList,classTypeFinder);        
        this.classResolver = new ClassResolver(null,this.importList,classFinder);        
    }

    public ClassTypeNativeImpl findClassType(String className)
    {
        return (ClassTypeNativeImpl)classTypeResolver.findClassInfo(className);
    }
    
    public MetaClassWrapper newMetaClassWrapper(String className)
    {
        Class clasz = (Class)classResolver.findClassInfo(className);
        if (clasz == null) throw new JNIEasyException("Class not found : " + className);
        return new ClassWrapper(clasz);
    }    

    public ImportList getImportList()
    {
        return importList;
    }

}
