/*
 * MemberOfClassRuntimeImpl.java
 *
 * Created on 24 de junio de 2005, 13:33
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.MemberOfClassImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.typedec.NativeMemberDescriptor;
import java.lang.reflect.Member;


/**
 *
 * @author jmarranz
 */
public abstract class MemberOfClassRuntimeImpl implements NativeMemberDescriptor
{
    protected MemberOfClassImpl memberOfClass;
    protected Member member;
    
    /**
     * Creates a new instance of MemberOfClassRuntimeImpl
     */
    public MemberOfClassRuntimeImpl(MemberOfClassImpl memberOfClass,Member member)
    {
        this.memberOfClass = memberOfClass;
        this.member = member;        
        
        init();
    }

    public abstract void init();
    
    public Member getMember()
    {
        return member;
    }
    
    public String getName()
    {
        return memberOfClass.getName();
    }    

}
