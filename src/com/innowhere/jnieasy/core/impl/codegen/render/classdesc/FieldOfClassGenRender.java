/*
 * FieldOfClassGenRender.java
 *
 * Created on 4 de marzo de 2005, 10:40
 */

package com.innowhere.jnieasy.core.impl.codegen.render.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import java.io.*;

import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldOfClassGen;

public class FieldOfClassGenRender extends MemberOfClassGenRender
{
    
    /** Creates a new instance of FieldOfClassGenRender */
    public FieldOfClassGenRender(FieldOfClassGen accessObject)
    {
        super(accessObject);
    }
    
    public static FieldOfClassGenRender newFieldOfClassGenRender(FieldOfClassGen accessObject)
    {
        return (FieldOfClassGenRender)newMemberOfClassGenRender(accessObject);
    }
    
    public FieldOfClassGen getFieldOfClassGen()
    {
        return (FieldOfClassGen)accessObject;
    }
    
    public StringBuffer generate()
    {
        FieldOfClassGen fieldGen = getFieldOfClassGen();
        FieldOfClassImpl fieldOfClass = fieldGen.getFieldOfClass();
        
        String fieldName = fieldOfClass.getName();
        String fieldClassName = fieldOfClass.getVarTypeNative().getTypeNative().getClassName();
       
        StringBuffer code = new StringBuffer();
        code.append( "    protected " + fieldClassName + " " + fieldName + "; \n" );
        code.append( " \n" );
        code.append( "    public " + fieldClassName + " get" + Util.capitalizeFirst(fieldName) + "() \n" );
        code.append( "    { \n" );
        code.append( "        return this." + fieldName + "; \n" );        
        code.append( "    } \n" );        
        code.append( " \n" );
        code.append( "    public void set" + Util.capitalizeFirst(fieldName) + "(" + fieldClassName + " " + fieldName + ") \n" );
        code.append( "    { \n" );
        code.append( "        this." + fieldName + " = " + fieldName + "; \n" );        
        code.append( "    } \n" );
        
        return code;
    }    
}
