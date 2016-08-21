/*
 * TypeNativeLongImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeLongImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeLongRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeLongXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeLongRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;

public class TypeNativeLongImpl extends TypeNativeNumberImpl
{
   
    /**
     * Creates a new instance of TypeNativeLongImpl
     */
    public TypeNativeLongImpl(ClassTypeNativeLongImpl dataType)
    {
        super(dataType);
    }  

    public void setIsAddress(boolean isAddress)
    {
        if (isAddress)
            setMemSizeExpr("address");
    }    
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeLongRender(this);
    }        
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return new TypeNativeLongRuntimeImpl(this,javaClass,ctx.getRuntimeManager());
    }           
        
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeLongXML(this);
    }
}
