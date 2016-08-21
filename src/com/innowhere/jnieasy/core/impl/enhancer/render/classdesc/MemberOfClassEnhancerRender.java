/*
 * MemberOfClassEnhancerRender.java
 *
 * Created on 13 de octubre de 2004, 17:56
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.MemberOfClassEnhancer;

public abstract class MemberOfClassEnhancerRender
{
    protected MemberOfClassEnhancer accessObjectEnh;
    
    /** Creates a new instance of MemberOfClassEnhancerRender */
    public MemberOfClassEnhancerRender(MemberOfClassEnhancer accessObjectEnh)
    {
        this.accessObjectEnh = accessObjectEnh;
    }
    
}
