/*
 * ParameterDecList.java
 *
 * Created on 15 de enero de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.common.signat.model;
import java.util.ArrayList;
import com.innowhere.jnieasy.core.impl.common.typedec.model.*;

/**
 *
 * @author  jmarranz
 */



public class ParameterDecList
{
    protected ArrayList paramList = new ArrayList();
    
    /** Creates a new instance of ParameterDecList */
    public ParameterDecList()
    {    
    }    
    
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        // Son objetos diferentes pero los parámetros pueden ser los mismos
        ParameterDecList plist2 = (ParameterDecList)obj;
       
        if (paramList.size() != plist2.paramList.size())
            return false;
        int size = paramList.size();
        for(int i = 0; i < size; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)paramList.get(i);
            ParameterDecImpl param2 = (ParameterDecImpl)plist2.paramList.get(i);            
            if (!param.equals(param2))
                return false;
        }
        return true;
    }
    
    public int length()
    {
        return paramList.size();
    }
    
    public ParameterDecImpl getParameterDec(int index)
    {
        return (ParameterDecImpl)paramList.get(index);
    }    

    public void addParameterDec(ParameterDecImpl param)
    {
        int count = paramList.size();
        paramList.add(param);
        param.setParamNumber(count + 1); // contamos desde 1
    }
    
    public void addParameterDec(int index,ParameterDecImpl param)
    {
        paramList.add(index,param);
        param.setParamNumber(index + 1); // contamos desde 1
    }    
    
    public ArrayList getParameterDecList()
    {
        return paramList;
    }    
    
    public void check()
    {
        int size = paramList.size();
        for(int i = 0; i < size; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)paramList.get(i);
            param.check();
        }
    }    
}
