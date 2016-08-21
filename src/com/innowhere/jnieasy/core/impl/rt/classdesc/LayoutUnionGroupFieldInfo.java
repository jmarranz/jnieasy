/*
 * LayoutUnionGroupFieldInfo.java
 *
 * Created on 17 de octubre de 2005, 22:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import java.util.ArrayList;

/**
 *
 * @author jmarranz
 */
public class LayoutUnionGroupFieldInfo extends LayoutFieldInfo
{
    protected ArrayList fields = new ArrayList();
    protected boolean layout = false;
    protected long size;
    protected long alignSize;
    
    /** Creates a new instance of LayoutUnionGroupFieldInfo */
    public LayoutUnionGroupFieldInfo()
    {
    }
    
    public void addField(FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt)
    {
        fields.add(fieldRt);
    }

    private void layout()
    {
        if (layout) return;
        
        int numFields = fields.size();
        long maxSize = 0;
        long maxAlignSize = 1;
        
        for(int i = 0; i < numFields; i++)
        {
            FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt = (FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl)fields.get(i);          
            VarTypeNativeRuntimeImpl varTypeDecField = fieldRt.getVarTypeNativeRuntime();
            long fieldSize = varTypeDecField.size();            
            long fieldAlignSize = fieldRt.alignSize();            
            if (fieldSize > maxSize)
                maxSize = fieldSize;
            if (fieldAlignSize > maxAlignSize)
                maxAlignSize = fieldAlignSize;
        }
        // El tama�o es el m�ximo tama�o, pero tambi�n con el padding
        // adecuado para que quede alineado el tama�o de acuerdo
        // con el m�ximo tama�o de alineaci�n
        // Se puede comprobar en C con: union Prueba { char a[5]; int b; }; el tama�o (sizeof) es 8
        
        if (maxSize != 0)
            maxSize = align(maxSize, maxAlignSize);
        else
            maxSize = 1; // Uni�n sin atributos, se impone el alineamiento m�nimo (comprobado en el Visual C++)
        
        this.size = maxSize;
        this.alignSize = maxAlignSize;
        
        this.layout = true;
    }
    
    public long getAlignSize()
    {
        layout();

        return alignSize;
    }  
    
    public long getSize()
    {
        layout();

        return size;
    }        
    
    public void setOffset(long offset)
    {
        int numFields = fields.size();
        
        for(int i = 0; i < numFields; i++)
        {
            // Se pone el mismo offset a todos pues est�n superpuestos
            FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt = (FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl)fields.get(i);
            fieldRt.setOffset(offset);            
        }
    }    
 
}
