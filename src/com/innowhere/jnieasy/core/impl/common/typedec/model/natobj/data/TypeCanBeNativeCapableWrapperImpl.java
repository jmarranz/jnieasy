/*
 * TypeCanBeNativeCapableWrapperImpl.java
 *
 * Created on 6 de enero de 2005, 16:09
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeCanBeNativeCapableWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeCanBeNativeCapableInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeCanBeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeCanBeNativeCapableWrapperRuntimeImpl;


public abstract class TypeCanBeNativeCapableWrapperImpl extends TypeNativeObjectFieldContainerImpl implements TypeCanBeNativeCapableInterface
{
    protected TypeCanBeNativeCapableImpl fieldType; // No usamos "VarType" porque el "Var" lo gestiona el contenedor
    
    /**
     * Creates a new instance of TypeCanBeNativeCapableWrapperImpl
     */
    public TypeCanBeNativeCapableWrapperImpl(ClassTypeCanBeNativeCapableWrapperImpl dataType)
    {
        super(dataType);   

        ClassTypeCanBeNativeCapableImpl wrappedClassType = getClassTypeCanBeNativeCapableWrapper().getClassTypeCanBeNativeCapable();
        if (wrappedClassType != null) // Si es null es que la declaración es incompleta (ArrayOfArray) y no puede completarse todavía
            setTypeCanBeNativeCapableDefault();
    }
    
    public TypeCanBeNativeCapableWrapperImpl(ClassTypeCanBeNativeCapableWrapperImpl dataType,TypeCanBeNativeCapableImpl fieldType)
    {
        super(dataType); 
        
        this.fieldType = fieldType;
        this.fieldType.setTypeCanBeNativeCapableWrapper(this);
    }    
    
    public TypeCanBeNativeCapableImpl getTypeCanBeNativeCapable()
    {
        if (fieldType == null)
        {
            throw new JNIEasyException("Incomplete declaration");
            
/*           
            ClassTypeCanBeNativeCapableImpl wrappedClassType = getClassTypeCanBeNativeCapableWrapper().getClassTypeCanBeNativeCapable();
            if (wrappedClassType == null)
                throw new JNIEasyException("Incomplete declaration"); // Es el caso seguramente de NativeArrayOfArray en donde no se ha suministrado info. del array interno, en ese caso wrappedTypeDec debería ser != null antes de llamar a este método
            
            setTypeCanBeNativeCapableDefault();
 */
        }
        
        return fieldType;
    }
    
    public void setTypeCanBeNativeCapable(TypeCanBeNativeCapableImpl wrappedType)
    {
        this.fieldType = wrappedType;
    }    
    
    public void setTypeCanBeNativeCapableDefault()
    {    
        ClassTypeCanBeNativeCapableImpl wrappedClassType = getClassTypeCanBeNativeCapableWrapper().getClassTypeCanBeNativeCapable();

        this.fieldType = (TypeCanBeNativeCapableImpl)wrappedClassType.newTypeCanBeNativeCapable(this);
        this.fieldType.setTypeCanBeNativeCapableWrapper(this);    
    }
    
    public ClassTypeCanBeNativeCapableWrapperImpl getClassTypeCanBeNativeCapableWrapper()
    {
        return (ClassTypeCanBeNativeCapableWrapperImpl)dataType;
    }

    public ClassTypeCanBeNativeCapableImpl getClassTypeCanBeNativeCapable()
    {
        return ((ClassTypeCanBeNativeCapableWrapperImpl)dataType).getClassTypeCanBeNativeCapable();
    }

    public void check()
    {
        super.check();
        getTypeCanBeNativeCapable().checkShared();
    }      
    
    public TypeNativeRuntimeImpl newTypeNativeRuntime(Class javaClass,RuntimeContext ctx)
    {
        return newTypeCanBeNativeCapableWrapperRuntime(javaClass,true,ctx);
    }
    
    public abstract TypeCanBeNativeCapableWrapperRuntimeImpl newTypeCanBeNativeCapableWrapperRuntime(Class javaClass,boolean isPrimary,RuntimeContext ctx);         
}
