/*
 * TypeNativeImpl.java
 *
 * Created on 10 de diciembre de 2004, 11:53
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;


public abstract class TypeNativeImpl implements TypeNativeInterface
{
    protected ClassTypeNativeImpl dataType;
    
    /**
     * Creates a new instance of TypeNativeImpl
     */
    
    public TypeNativeImpl(ClassTypeNativeImpl dataType)
    {
        this.dataType = dataType;
    }   
    
    public JNIEasyImpl getJNIEasy()
    {
        return dataType.getJNIEasy();
    }
    
    public String getClassName()
    {
        return dataType.getClassName();
    }
    
    public boolean equals(Object obj)
    {    
        if (obj == null) return false;        
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        // Aunque sean objetos diferentes los consideramos iguales
        // si coincide clase y convencionalismo
        TypeNativeImpl typeDec2 = (TypeNativeImpl)obj;
        if (!dataType.equals(typeDec2.getClassType()))
            return false;
        return true;
    }        

    public int hashCode()
    {
        return dataType.hashCode();
    }
    
    public void check()
    {
        // Derivar cuando haya que hacer algo
    }
    
    public static TypeNativeImpl newTypeNative(ClassTypeNativeImpl dataType)    
    {    
        return dataType.newTypeNative();
    }   
    
    /**
     * Getter for property dataType.
     * @return Value of property dataType.
     */
    public ClassTypeNativeImpl getClassType()
    {
        return dataType;
    }

    public ClassTypeNativeRuntimeImpl getClassTypeRuntime()
    {
        return dataType.getClassTypeRuntime();
    }    
    
    public abstract String getDeclarationStringComplement();
    
    public String getDeclarationString()
    {
        return getClassType().getClassName() + getDeclarationStringComplement();
    }    
    
    public abstract TypeNativeRender newTypeNativeRender();    
    public abstract TypeNativeParserImpl newTypeNativeParser();
    public abstract TypeNativeXML newTypeNativeXML();
    public abstract TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx);
    public abstract VarTypeNativeImpl newVarTypeNative();
}
