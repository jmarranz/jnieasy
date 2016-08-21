/*
 * FieldOfClassAsNativeMultipleFieldContainerEnhancerRender.java
 *
 * Created on 29 de junio de 2005, 14:20
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeMultipleFieldContainerEnhancerImpl;
import com.innowhere.jnieasy.core.mem.UnFetch;

/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeMultipleFieldContainerEnhancerRender extends FieldOfClassEnhancerRender
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeMultipleFieldContainerEnhancerRender
     */
    public FieldOfClassAsNativeMultipleFieldContainerEnhancerRender(FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnh)
    {
        super(fieldEnh);
    }
    
    public FieldOfClassAsNativeMultipleFieldContainerEnhancer getFieldOfClassAsMultipleFieldContainerEnhancer()
    {
        return (FieldOfClassAsNativeMultipleFieldContainerEnhancer)accessObjectEnh;
    }

    public int getIndex()
    {
        return getFieldOfClassAsMultipleFieldContainerEnhancer().getFieldOfClassAsMultipleFieldContainer().getIndex();
    }
    
    public int getAbsIndex()
    {
        return getFieldOfClassAsMultipleFieldContainerEnhancer().getFieldOfClassAsMultipleFieldContainer().getAbsIndex();
    }    
    
    public String getStaticCodeInitializer()
    {
        FieldOfClassAsNativeMultipleFieldContainerEnhancer fieldEnh = getFieldOfClassAsMultipleFieldContainerEnhancer();
        FieldOfClassAsNativeMultipleFieldContainerImpl fieldOfClass = fieldEnh.getFieldOfClassAsMultipleFieldContainer();
        
        int index = fieldOfClass.getIndex();       
        String name = fieldEnh.getFieldOfClass().getName();
                
        StringBuffer code = new StringBuffer();

        code.append( NativeMultipleFieldContainerEnhancerImpl.class.getName() );            
        code.append( ".addField(" );
        code.append( "jnieasyClassInfo," + index + "," );
        code.append( "\"" + name + "\"," ); 
        code.append( "\"" + fieldEnh.getDesiredAlignSizeExpr() + "\"," );
        code.append( fieldOfClass.isBeginUnion() + "," );
        code.append( fieldOfClass.isEndUnion() + "," );        
        code.append( varTypeEnhRender.getDeclareTypeCallString() );
        code.append( ");\n" );

        return code.toString();
    }    
    
    public String getInternalGetCode()
    {
        /*  Ej. (hay más casos)
            public final int jnieasy_ClassName_getX()
            {
                x = NativeCapableEnhancerImpl.getInt(this,0,jnieasyClassInfo,x);
                return x;        
            }
         */        
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer(); 
        String fieldName = fieldEnh.getFieldOfClass().getName();
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  " + getFetchFieldCode(NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getDefaultFetchMode(this)") );
        body.append( "  return this." + fieldName + "; \n" );
        body.append( "}" );

        return body.toString();
    }    
    
    public String getInternalSetCode()
    {    
        /*  Ej. (hay más tipos)
            public final void jnieasy_ClassName_setX(int x)
            {
                this.x = NativeCapableEnhancerImpl.setInt(this,jnieasyMemMap[0],this.x);
            }
         */        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( getUnFetchFieldCode("$1",NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getDefaultUnFetchMode(this)") );
        body.append( "}" );

        return body.toString();
    }
    
    public String getFetchFieldCode(String fetchMode)
    {
        return varTypeEnhRender.getFetchFieldCode(this,fetchMode);
    }
    
    public String getFetchFieldCode(String fetchMode,String fetchCtx,String stateMgr)
    {
        return varTypeEnhRender.getFetchFieldCode(this,fetchMode,fetchCtx,stateMgr);
    }
    
    public String getUnFetchFieldCode(String newValue,String unFetchMode)
    {
        return varTypeEnhRender.getUnFetchFieldCode(this,newValue,unFetchMode);        
    }    
    
    public String getUnFetchFieldCode(String newValue,String unFetchMode,String unfetchCtx,String attachCopyCtx,String stateMgr)
    {
        return varTypeEnhRender.getUnFetchFieldCode(this,newValue,unFetchMode,unfetchCtx,attachCopyCtx,stateMgr);       
    }

        
}
