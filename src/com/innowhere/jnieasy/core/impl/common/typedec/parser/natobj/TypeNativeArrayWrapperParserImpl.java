/*
 * TypeNativeArrayWrapperParserImpl.java
 *
 * Created on 14 de septiembre de 2005, 18:27
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.parser.natobj;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.util.Comma;
import com.innowhere.jnieasy.core.impl.util.SourceCode;
import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author jmarranz
 */
public class TypeNativeArrayWrapperParserImpl extends TypeNativeCapableParserImpl
{
    
    /**
     * Creates a new instance of TypeNativeArrayWrapperParserImpl
     */
    public TypeNativeArrayWrapperParserImpl(TypeNativeArrayWrapperImpl typeDec)
    {
        super(typeDec);
    }
   
    public TypeNativeArrayWrapperImpl getTypeNativeArrayWrapper()
    {
        return (TypeNativeArrayWrapperImpl)typeDec;
    }
    
    public void parse(SourceCode block,TaskContext ctx)
    {
        // Esperamos { dim, dim,...,dim } o { TypeNativeArray }
        
        TypeNativeArrayWrapperImpl typeDec = getTypeNativeArrayWrapper();
        
        Comma comma = Comma.getComma();
        LinkedList list = block.split(comma);
        if (list.size() > 1) // El caso de = 1 es el de no hay comas
        {
            processDims(list,typeDec);
        }
        else
        {
            // No hay comas (en el nivel alto), es posible que haya una dimensi�n al menos: { 3 }
            String blockContent = block.getContent();
            try
            {
                // Vemos si es una dimensi�n
                blockContent = blockContent.trim();
                int len = Integer.parseInt(blockContent);
                typeDec.getTypeNativeArrayInfo().setDimensions(new int[]{len});
                // podr�amos hacer setLength() pero imponemos la norma que dice que el 
                // n�mero de dimensiones ha de coincidir con el array, y
                // setDimensions() es el que utilizamos cuando hay m�s de una dim.
            }
            catch(Exception ex)
            {
                // No es una dimensi�n, debe ser la declaraci�n del array,
                // �til en el caso de arrays incompletas
                TypeNativeImpl typeDecArrayComp = TypeNativeParserImpl.newTypeNative(blockContent,ctx);
                if (!(typeDecArrayComp instanceof TypeNativeArrayInterface))
                    throw new JNIEasyException("Expected an array declaration: " + blockContent);
                    
                typeDec.setTypeCanBeNativeCapable((TypeCanBeNativeCapableImpl)typeDecArrayComp);
            }
        }
    }
    
    public static void processDims(LinkedList listDims,TypeNativeArrayWrapperImpl typeDec)
    {
        int len = listDims.size();
        int[] dims = new int[len];        
        int i = 0;
        for(Iterator it = listDims.iterator(); it.hasNext(); )
        {
            String dimStr = ((SourceCode)it.next()).getContent();
            dimStr = dimStr.trim();
            int dim;
            try
            {
                dim = Integer.parseInt(dimStr);
            }
            catch(Exception ex)
            {
                throw new JNIEasyException("Array dimension format invalid: " + dimStr,ex);
            }   
            if (dim < -1) throw new JNIEasyException("Dimensi�n value not valid: " + dim);
            dims[i] = dim; 
            i++;
        }   
        typeDec.getTypeNativeArrayInfo().setDimensions(dims);
    }            

    public static int[] parseDims(String strDims)
    {
        // Esperamos: dim, dim,...,dim
        try
        {
            String[] tokens = strDims.split(",");
            int[] dims = new int[tokens.length];
            for(int i = 0; i < tokens.length; i++)
            {
                String dimStr = tokens[i].trim();
                int dim = Integer.parseInt(dimStr);
                if (dim < -1) throw new JNIEasyException("Dimensi�n value not valid: " + dim);
                dims[i] = dim;                
            }
   
            return dims;
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Array dimensions format invalid: " + strDims,ex);
        }
    }     
}
