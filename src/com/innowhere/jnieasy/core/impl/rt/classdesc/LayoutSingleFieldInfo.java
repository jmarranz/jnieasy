/*
 * LayoutSingleFieldInfo.java
 *
 * Created on 17 de octubre de 2005, 22:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;

import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class LayoutSingleFieldInfo extends LayoutFieldInfo
{
    protected FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt;
    
    /** Creates a new instance of LayoutSingleFieldInfo */
    public LayoutSingleFieldInfo(FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt)
    {
        this.fieldRt = fieldRt;
    }
    
    public long getAlignSize()
    {
        return fieldRt.alignSize();
    }

    public long getSize()
    {
        return fieldRt.size();            
    }
    
    public void setOffset(long offset)
    {
        fieldRt.setOffset(offset);
    }
    
}
