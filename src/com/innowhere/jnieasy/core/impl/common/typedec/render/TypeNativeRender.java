/*
 * TypeNativeRender.java
 *
 * Created on 18 de marzo de 2004, 17:23
 */

package com.innowhere.jnieasy.core.impl.common.typedec.render;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;



public abstract class TypeNativeRender
{
    protected TypeNativeImpl typeDec;
    
    /** Creates a new instance of TypeNativeRender */
    public TypeNativeRender(TypeNativeImpl typeDec)
    {
        this.typeDec = typeDec;
    }

    public static TypeNativeRender newTypeNativeRender(TypeNativeImpl typeDec)
    {
        return typeDec.newTypeNativeRender();
    }
    
    public TypeNativeImpl getType()
    {
        return typeDec;
    }

    public static String getClassCode(String className,boolean enhancer)
    {
        if (enhancer) // Esto es debido a que javassist se hace un lio con la expresión .class o una llamada a un método estático dentro de una llamada a un método y necesita además incluir una pequeña librería no deseada
            return NativeCapableEnhancerImpl.class.getName() + ".getClass(\"" + className + "\",jnieasyClassLoader)";
        else
            return className + ".class";        
    }
    
    public String getDeclaredClassName(boolean enhancer)
    {
        String className = getType().getClassName();
        return getClassCode(className,enhancer);
    }
    
    public StringBuffer getDeclareTypeCallString(boolean enhancer) 
    {
        StringBuffer code = new StringBuffer();
        String compDecCall = getDeclareComponentTypeCall(enhancer);
        if (compDecCall.length() != 0)
            code.append( compDecCall + "." );
        code.append( getDeclareTypeMethodName() );
        code.append( "(" );
        code.append( getDeclaredClassName(enhancer) );
        code.append( getDecOtherParams(enhancer) );    
        code.append( ")" );
        
        return code;
    }    

    public abstract String getDeclareComponentTypeCall(boolean enhancer);    
    public abstract String getDecOtherParams(boolean enhancer);
    public abstract String getDeclareTypeMethodName();
    public abstract String convertFromObject(String paramName);
    public abstract String returnCastToObject(String code);
    public abstract String castToObject(String code);        
}
