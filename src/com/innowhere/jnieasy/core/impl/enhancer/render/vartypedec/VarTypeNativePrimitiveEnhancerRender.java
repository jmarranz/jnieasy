/*
 * VarTypeNativePrimitiveEnhancerRender.java
 *
 * Created on 29 de octubre de 2004, 12:10
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancerRender;
import com.innowhere.jnieasy.core.impl.util.*;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativePrimitiveImpl;

public class VarTypeNativePrimitiveEnhancerRender extends VarTypeNativeEnhancerRender
{
    
    /** Creates a new instance of VarTypeNativePrimitiveEnhancerRender */
    public VarTypeNativePrimitiveEnhancerRender(VarTypeNativePrimitiveImpl varTypeDec)
    {
        super(varTypeDec);
    }

    public String getFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String fetchMode)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        String fieldName = fieldEnh.getFieldOfClass().getName();
        int index = fieldEnhRender.getIndex();
        
        String methodNamePart = Util.capitalizeFirst(varType.getTypeNative().getClassName());        
        
        return "this." + fieldName + " = " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".get" + methodNamePart + "(this,jnieasyClassInfo," + index + ",this." + fieldName + "," + fetchMode + "); \n"; 
    }     
    
    public String getFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String fetchMode,String fetchCtx,String stateMgr)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        String fieldName = fieldEnh.getFieldOfClass().getName();
        int index = fieldEnhRender.getIndex();
        
        String methodNamePart = Util.capitalizeFirst(varType.getTypeNative().getClassName());        
        
        return "this." + fieldName + " = " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".get" + methodNamePart + "(this,jnieasyClassInfo," + index + ",this." + fieldName + "," + fetchMode + "," + stateMgr + "); \n"; 
    }   
    
    public String getUnFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String newValue,String unFetchMode)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        String fieldName = fieldEnh.getFieldOfClass().getName();
        int index = fieldEnhRender.getIndex();        
        
        String methodNamePart = Util.capitalizeFirst(varType.getTypeNative().getClassName());  
        
        return "this." + fieldName + " = " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".set" + methodNamePart + "(this,jnieasyClassInfo," + index + "," + newValue + "," + unFetchMode + "); \n";
    }       
    
    public String getUnFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String newValue,String unFetchMode,String unfetchCtx,String attachCopyCtx,String stateMgr)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        String fieldName = fieldEnh.getFieldOfClass().getName();
        int index = fieldEnhRender.getIndex();        
        
        String methodNamePart = Util.capitalizeFirst(varType.getTypeNative().getClassName());  
        
        return "this." + fieldName + " = " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".set" + methodNamePart + "(this,jnieasyClassInfo," + index + "," + newValue + "," + unFetchMode + "," + stateMgr + "); \n";
    }   

}
