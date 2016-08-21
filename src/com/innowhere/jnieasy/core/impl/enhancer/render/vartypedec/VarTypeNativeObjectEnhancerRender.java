/*
 * VarTypeNativeObjectEnhancerRender.java
 *
 * Created on 18 de marzo de 2004, 17:23
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.vartypedec;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;

public class VarTypeNativeObjectEnhancerRender extends VarTypeNativeEnhancerRender
{
    /** Creates a new instance of VarTypeNativeObjectEnhancerRender */
    public VarTypeNativeObjectEnhancerRender(VarTypeNativeObjectImpl varTypeDec)
    {
        super(varTypeDec);
    }

    public String getFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String fetchMode)
    {       
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
        String fieldName = fieldOfClass.getName();
        String fieldClass = fieldOfClass.getVarTypeNative().getTypeNative().getClassName();            
        int index = fieldEnhRender.getIndex();        
        
        return "this." + fieldName + " = (" + fieldClass + ")" + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getObject(this,jnieasyClassInfo," + index + ",this." + fieldName + "," + fetchMode + "); \n"; 
    }    
    
    public String getFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String fetchMode,String fetchCtx,String stateMgr)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
        String fieldName = fieldOfClass.getName();
        String fieldClass = fieldOfClass.getVarTypeNative().getTypeNative().getClassName();            
        int index = fieldEnhRender.getIndex();        
        
        return "this." + fieldName + " = (" + fieldClass + ")" + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getObject(this,jnieasyClassInfo," + index + ",this." + fieldName + "," + fetchMode + "," + fetchCtx + "," + stateMgr + "); \n"; 
    }        
    
    public String getUnFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String newValue,String unFetchMode)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
        String fieldName = fieldOfClass.getName();
        String fieldClass = fieldOfClass.getVarTypeNative().getTypeNative().getClassName();            
        int index = fieldEnhRender.getIndex();        
        
        return "this." + fieldName + " = (" + fieldClass + ")" + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".setObject(this,jnieasyClassInfo," + index + "," + newValue + "," + unFetchMode + "); \n"; 
    }       
    
    public String getUnFetchFieldCode(FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender,String newValue,String unFetchMode,String unfetchCtx,String attachCopyCtx,String stateMgr)
    {
        FieldOfClassEnhancer fieldEnh = fieldEnhRender.getFieldOfClassEnhancer(); 
        FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
        String fieldName = fieldOfClass.getName();
        String fieldClass = fieldOfClass.getVarTypeNative().getTypeNative().getClassName();            
        int index = fieldEnhRender.getIndex();        
        
        return "this." + fieldName + " = (" + fieldClass + ")" + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".setObject(this,jnieasyClassInfo," + index + "," + newValue + "," + unFetchMode + "," + unfetchCtx + "," + attachCopyCtx + "," + stateMgr + "); \n"; 
    }                
}
