/*
 * FieldOfClassAsNativeObjectFieldContainerEnhancerRender.java
 *
 * Created on 29 de junio de 2005, 14:21
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.data.NativeObjectFieldContainer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassAsNativeObjectFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.NativeObjectFieldContainerEnhancerImpl;




/**
 *
 * @author jmarranz
 */
public class FieldOfClassAsNativeObjectFieldContainerEnhancerRender extends FieldOfClassEnhancerRender
{
    
    /**
     * Creates a new instance of FieldOfClassAsNativeObjectFieldContainerEnhancerRender
     */
    public FieldOfClassAsNativeObjectFieldContainerEnhancerRender(FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnh)
    {
        super(fieldEnh);
    }

    public FieldOfClassAsNativeObjectFieldContainerEnhancer getFieldOfClassAsObjectFieldContainerEnhancer()
    {
        return (FieldOfClassAsNativeObjectFieldContainerEnhancer)accessObjectEnh;
    }
    
    public String getStaticCodeInitializer()
    {
        FieldOfClassAsNativeObjectFieldContainerEnhancer fieldEnh = getFieldOfClassAsObjectFieldContainerEnhancer();
        String name = fieldEnh.getFieldOfClassAsObjectFieldContainer().getName();
        
        StringBuffer code = new StringBuffer();
        
        code.append( NativeObjectFieldContainerEnhancerImpl.class.getName() );
        code.append( ".setFieldDescriptor(" );
        code.append( "jnieasyClassInfo," );
        code.append( "\"" + name + "\"," ); 
        code.append( varTypeEnhRender.getDeclareTypeCallString() );
        code.append( ");\n" );

        return code.toString();
    }        
    
    public String getInternalGetCode()
    {
        /*  Ej. 
            public final int[][] jnieasy_ClassName_getX()
            {
                return (int[][])getValue();
            }
         */        
        FieldOfClassEnhancer fieldEnh = getFieldOfClassEnhancer(); 
        String fieldClass = fieldEnh.getFieldCtClass().getName();

        // Lo del cast del this es porque debe haber un fallo en el javassist y la JVM da un error al cargar la clase
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return (" + fieldClass + ") ((" + NativeObjectFieldContainer.class.getName() + ")this).getValue(); \n" );
        body.append( "}" );

        return body.toString();
    }    
    
    public String getInternalSetCode()
    {    
        /*  Ej. 
            public final void jnieasy_ClassName_setX(int[][] x)
            {
                setValue(x);
            }
         */ 
        // Lo del cast del this es porque debe haber un fallo en el javassist y la JVM da un error al cargar la clase
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  ((" + NativeObjectFieldContainer.class.getName() + ")this).setValue($1); \n" );
        body.append( "}" );

        return body.toString();
    }    
}
