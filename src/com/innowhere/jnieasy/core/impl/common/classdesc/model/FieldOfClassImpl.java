/*
 * FieldDec.java
 *
 * Created on 28 de febrero de 2005, 20:27
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.MemberOfClassRender;
import com.innowhere.jnieasy.core.impl.common.classdesc.render.FieldOfClassRender;
import com.innowhere.jnieasy.core.impl.rt.classdesc.FieldOfClassRuntimeImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.MemberOfClassGen;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.FieldOfClassGen;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.codegen.model.classdesc.JavaClassAsNativeMultipleFieldContainerGen;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import java.lang.reflect.Field;
import javassist.CtField;


public abstract class FieldOfClassImpl extends MemberOfClassImpl
{
    protected VarTypeNativeImpl fieldVarType;    
    protected JavaClassAsNativeCapableImpl javaClass;
            
    /** Creates a new instance of FieldDec */
    public FieldOfClassImpl(JavaClassAsNativeCapableImpl javaClass,VarTypeNativeImpl fieldVarType)
    {
        this.javaClass = javaClass;
        this.fieldVarType = fieldVarType;
    }    

    public static FieldOfClassImpl newFieldOfClass(JavaClassAsNativeCapableImpl javaClass,VarTypeNativeImpl varType)
    {
        return javaClass.newFieldOfClass(varType);
    }
        
    public boolean mustHaveName()
    {
        return true;
    }
    
    /**
     * Getter for property fieldVarType.
     * 
     * @return Value of property fieldVarType.
     */
    public VarTypeNativeImpl getVarTypeNative()
    {
        return fieldVarType;
    } 

    /**
     * Setter for property fieldVarType.
     * 
     * @param fieldVarType New value of property fieldVarType.
     */
    public void setVarTypeNative(VarTypeNativeImpl fieldVarType)
    {
        this.fieldVarType = fieldVarType;
    }
   
    public abstract FieldOfClassRuntimeImpl newFieldOfClassRuntime(Field field,JavaClassAsNativeCapableRuntimeImpl javaClass);
    public abstract FieldOfClassEnhancer newFieldOfClassEnhancer(CtField field,JavaClassAsNativeCapableEnhancer classEnhancer);
    
    
    public MemberOfClassRender newMemberOfClassRender()
    {
        return new FieldOfClassRender(this);
    }  
    
    public MemberOfClassGen newMemberOfClassGen(JavaClassAsNativeMultipleFieldContainerGen classGen)
    {
        return new FieldOfClassGen(this,classGen);
    }    
}
