/*
 * FieldAccessExceptionUtil.java
 *
 * Created on 13 de octubre de 2005, 17:00
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt;

/**
 *
 * @author jmarranz
 */
public class FieldAccessExceptionUtil
{
    
    /**
     * Creates a new instance of FieldAccessExceptionUtil
     */    
    public static String createMessage(int fieldIndex,Object fieldValue,Object container)
    {
        return createMessage(null,fieldIndex,null,fieldValue,container);
    }   
    
    public static String createMessage(int fieldIndex,String fieldName,Object fieldValue,Object container)
    {
        return createMessage(null,fieldIndex,fieldName,fieldValue,container);
    }     
    
    public static String createMessage(String message,int fieldIndex,Object fieldValue,Object container)
    {
        return createMessage(message,fieldIndex,null,fieldValue,container);
    }    
    
    public static String createMessage(String message,int fieldIndex,String fieldName,Object fieldValue,Object container)
    {
        if (message != null) message += ". ";
        else message = "";
        message += "Field: " + fieldIndex;
        if (fieldName != null)
            message += ", field name: " + fieldName;            
        message += ", field value: " + fieldValue;
        message += ", container: " + container;
        return message;
    }

}
