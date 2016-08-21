/*
 * BehaviorOfClassRender.java
 *
 * Created on 8 de junio de 2005, 19:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.render;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;

/**
 *
 * @author jmarranz
 */
public class BehaviorOfClassRender extends MemberOfClassRender
{
    public BehaviorOfClassRender(BehaviorOfClassImpl accessObject)
    {
        super(accessObject);        
    }
    
    public static String getAsJavaBehaviorSignatureString(String classFullName,String methodName,String[] params)
    {
        StringBuffer signature = new StringBuffer();
        for(int i=0; i < params.length; i++)
        {
            String className = params[i];
            if (i != 0) signature.append( "," );
            signature.append( className );
        }
        return classFullName + "." + methodName + "(" + signature + ")";
    }     

}
