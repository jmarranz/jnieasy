/*
 * MemberOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:39
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import java.io.PrintWriter;


public abstract class MemberOfClassGenRender
{
    protected MemberOfClassGen accessObject;

    
    /**
     * Creates a new instance of MemberOfClassGenRender
     */
    public MemberOfClassGenRender(MemberOfClassGen accessObject)
    {
        this.accessObject = accessObject;
    }
    
    public static MemberOfClassGenRender newMemberOfClassGenRender(MemberOfClassGen accessObject)    
    {
        return accessObject.newMemberOfClassGenRender();
    }
    
    public abstract StringBuffer generate();
}
