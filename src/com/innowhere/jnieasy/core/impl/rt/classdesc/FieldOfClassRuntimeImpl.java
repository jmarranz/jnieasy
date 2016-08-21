/*
 * FieldOfClassRuntimeImpl.java
 *
 * Created on 28 de diciembre de 2004, 13:55
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.typedec.NativeFieldDescriptor;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import java.lang.reflect.Field;

/* Nota: no asociamos callback de acceso al field, en m�todos tiene sentido para que se vea
 * por una v�a nativa pero en los fields su acceso nativo es v�a el buffer y los m�todos internos del enhancement
 * si adem�s asoci�ramos una callback existir�a el problema de los fields privados que son accesibles via m�todos
 * pero que no ser�an accessibles via callback y el hecho de construir la callback (direct) dar�a error
*/

public abstract class FieldOfClassRuntimeImpl extends MemberOfClassRuntimeImpl implements NativeFieldDescriptor
{
    protected long offset;
    protected VarTypeNativeRuntimeImpl varTypeRt;
    protected JavaClassAsNativeCapableRuntimeImpl javaClass;
            
    /**
     * Creates a new instance of FieldOfClassRuntimeImpl 
     */
    public FieldOfClassRuntimeImpl(FieldOfClassImpl memberOfClass,Field field,JavaClassAsNativeCapableRuntimeImpl javaClass)
    {
        super(memberOfClass,field);
        this.javaClass = javaClass;
    }
    
    public RuntimeManagerImpl getRuntimeManager()
    {
        return javaClass.getRuntimeManager();
    }
    
    public void init()
    {
        getFieldOfClass().setName(getField().getName());
    }
    
    public static FieldOfClassRuntimeImpl newFieldOfClassRuntime(Field field,VarTypeNativeRuntimeImpl varTypeDecRt,JavaClassAsNativeCapableRuntimeImpl javaClass)
    {
        FieldOfClassImpl fieldOfClass = FieldOfClassImpl.newFieldOfClass(javaClass.getJavaClassAsNativeCapable(),varTypeDecRt.getVarTypeNative());
        FieldOfClassRuntimeImpl fieldRt = fieldOfClass.newFieldOfClassRuntime(field,javaClass);
        fieldRt.setVarTypeNativeRuntime(varTypeDecRt);
        return fieldRt;
    }

    
    public FieldOfClassImpl getFieldOfClass()
    {
        return (FieldOfClassImpl)memberOfClass;
    }
    
    public long getOffset()
    {
        return offset;
    }
    
    public void setOffset(long offset)
    {
        this.offset = offset;
    }
    
    public VarTypeNative getVarType()    
    {
        return varTypeRt;
    }
    
    public VarTypeNativeRuntimeImpl getVarTypeNativeRuntime()
    {
        return varTypeRt;
    }
    
    public void setVarTypeNativeRuntime(VarTypeNativeRuntimeImpl varTypeDec)
    {
        this.varTypeRt = varTypeDec;
    }    
    
    public Field getField()
    {
        return (Field)member;
    }

}
