/*
 * MemberOfClassImpl.java
 *
 * Created on 28 de febrero de 2005, 20:33
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.impl.common.classdesc.render.MemberOfClassRender;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;

/**
 *
 * @author  jmarranz
 */

public abstract class MemberOfClassImpl
{
    protected String name;
    
    /** Creates a new instance of MemberOfClassImpl */
    public MemberOfClassImpl()
    {
    }  
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }   
        
    public abstract boolean mustHaveName();
    
    public abstract MemberOfClassRender newMemberOfClassRender();
    public abstract MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen);
}
