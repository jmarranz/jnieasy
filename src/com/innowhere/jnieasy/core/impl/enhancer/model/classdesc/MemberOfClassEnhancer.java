/*
 * MemberOfClassEnhancer.java
 *
 * Created on 28 de febrero de 2005, 20:33
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import javassist.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MemberOfClassImpl;


public abstract class MemberOfClassEnhancer
{
    protected JavaClassAsNativeCapableEnhancer classEnhancer;
    protected CtMember ctMember;
    protected MemberOfClassImpl memberOfClass;
    
    /** Creates a new instance of MemberOfClassEnhancer */
    public MemberOfClassEnhancer(CtMember ctMember,MemberOfClassImpl memberOfClass,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        this.ctMember = ctMember;
        this.memberOfClass = memberOfClass;
        this.classEnhancer = classEnhancer;
        
        init();
    }
        
    public abstract void init();
    
    public MemberOfClassImpl getMemberOfClass()
    {
        return memberOfClass;
    }
    
    
    public JavaClassAsNativeCapableEnhancer getJavaClassAsNativeCapableEnhancer()
    {
        return classEnhancer;
    }

    /**
     * Getter for property ctMember.
     * @return Value of property ctMember.
     */
    public CtMember getCtMember()
    {
        return ctMember;
    }    
}
