/*
 * MemberOfClassRender.java
 *
 * Created on 19 de septiembre de 2005, 12:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.render;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.MemberOfClassImpl;

/**
 *
 * @author jmarranz
 */
public abstract class MemberOfClassRender
{
    protected MemberOfClassImpl memberOfClass;
    
    /**
     * Creates a new instance of MemberOfClassRender
     */
    public MemberOfClassRender(MemberOfClassImpl memberOfClass)
    {
        this.memberOfClass = memberOfClass;
    }

}
