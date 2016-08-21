/*
 * TypeNativeArrayImpl.java
 *
 * Created on 1 de enero de 2005, 19:19
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInfo;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.typedec.model.natobj.data.TypeNativeArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.TypeNativeParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.parser.mustbe.TypeNativeArrayParserImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.common.typedec.render.mustbe.data.TypeNativeArrayRender;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.TypeNativeXML;
import com.innowhere.jnieasy.core.impl.common.typedec.xml.mustbe.data.TypeNativeArrayXML;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeNativeArrayRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.mustbe.data.TypeCanBeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;


public abstract class TypeNativeArrayImpl extends TypeCanBeNativeCapableImpl implements TypeNativeArrayInterface
{
    protected TypeNativeArrayInfo arrayInfo;

    /**
     * Creates a new instance of TypeNativeArrayImpl
     */
    public TypeNativeArrayImpl(ClassTypeNativeArrayImpl dataType)
    {
        this(dataType,newVarTypeNativeComponent(dataType));
    }
        
    public TypeNativeArrayImpl(ClassTypeNativeArrayImpl dataType,TypeNativeArrayWrapperImpl wrapperType)
    {
        this(dataType,wrapperType,newVarTypeNativeComponent(dataType));      
    }   
    
    public TypeNativeArrayImpl(ClassTypeNativeArrayImpl dataType,TypeNativeArrayWrapperImpl wrapperType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType,wrapperType);
        
        this.arrayInfo = new TypeNativeArrayInfo(this,varTypeComp);        
    }        
    
    public TypeNativeArrayImpl(ClassTypeNativeArrayImpl dataType,VarTypeNativeImpl varTypeComp)
    {
        super(dataType);
        
        this.arrayInfo = new TypeNativeArrayInfo(this,varTypeComp);        
    }    
    
    public static VarTypeNativeImpl newVarTypeNativeComponent(ClassTypeNativeArrayImpl dataType)
    {
        return VarTypeNativeImpl.newVarTypeNative(dataType.getArrayInfo().getComponentType());    
    }
    
    public TypeNativeArrayWrapperImpl getTypeNativeArrayWrapper()
    {
        return (TypeNativeArrayWrapperImpl)getTypeCanBeNativeCapableWrapper();
    }
    
    public ClassTypeNativeArrayImpl getClassTypeArray()
    {
        return (ClassTypeNativeArrayImpl)dataType;
    }    
    
    public TypeNativeArrayInfo getTypeNativeArrayInfo()
    {
        return arrayInfo;
    }

    public static TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp,TaskContext ctx)
    {
        ClassTypeNativeArrayImpl classTypeArray = varTypeComp.getTypeNative().getClassType().getClassTypeArray(ctx);
        return classTypeArray.newTypeNativeArray(varTypeComp);
    }    
    
    public static VarTypeNativeImpl toFirstComponent(int[] dims,VarTypeNativeImpl lastCompVarType,TaskContext ctx)
    {
        // Se usan todas las dimensiones (longitudes) menos la primera
        // si es de 1 dimension no se hace nada
        VarTypeNativeImpl varTypeComp = lastCompVarType;
        for(int i = dims.length - 1; i >= 1; i--) // No pasamos por i = 0 (por dims[0])
        {
            TypeNativeArrayImpl typeDecArray = newTypeNativeArray(varTypeComp,ctx);
            typeDecArray.getTypeNativeArrayInfo().setLength(dims[i]);
            varTypeComp = VarTypeNativeImpl.newVarTypeNative(typeDecArray);
        }
        return varTypeComp;
    }    
    
    public static TypeNativeArrayImpl newTypeNativeArray(ClassTypeNativeArrayImpl classTypeArray,int[] dims,VarTypeNativeImpl lastCompVarType,TaskContext ctx)
    {
        VarTypeNativeImpl varTypeComp = toFirstComponent(dims,lastCompVarType,ctx);
        TypeNativeArrayImpl typeDec = classTypeArray.newTypeNativeArray(varTypeComp);
        typeDec.getTypeNativeArrayInfo().setLength(dims[0]);
        return typeDec;
    }
    
    public static TypeNativeArrayImpl newTypeNativeArray(int[] dims,VarTypeNativeImpl lastCompVarType,TaskContext ctx)
    {
        VarTypeNativeImpl varTypeComp = toFirstComponent(dims,lastCompVarType,ctx);
        TypeNativeArrayImpl typeDecArray = newTypeNativeArray(varTypeComp,ctx);        
        typeDecArray.getTypeNativeArrayInfo().setLength(dims[0]);        
        return typeDecArray;
    }
    
    public void checkShared()
    {
        super.checkShared();
        getTypeNativeArrayInfo().check();
    }
    
    public String getDeclarationString()
    {
        // Redefinimos porque si hay dimensiones el nombre de la clase normal no las pone
        if (arrayInfo.lengthKnown())
        {
            String compDec = arrayInfo.getLastComponentVarType().getDeclarationString();
            return compDec + arrayInfo.dimsToStringWithBrackets();
        }
        else return super.getDeclarationString(); // incluye las dimensiones vacías: como [][]
    }    
    
    public String getDeclarationStringComplement()
    {   
        // No se necesita al redefinir getDeclarationString()
        return "";
    }
    
    public TypeNativeRender newTypeNativeRender()
    {
        return new TypeNativeArrayRender(this);
    }
    
    public TypeNativeXML newTypeNativeXML()
    {
        return new TypeNativeArrayXML(this);
    }
    
    public VarTypeNativeImpl newVarTypeNative()
    {
        return new VarTypeNativeArrayImpl(this);
    }
    
    public TypeCanBeNativeCapableRuntimeImpl newTypeCanBeNativeCapableRuntime(Class javaClass,boolean isPrimary, RuntimeContext ctx)
    {
        VarTypeNativeImpl varTypeDecComp = getTypeNativeArrayInfo().getComponentVarType();        
        Class classComp = TypeNativeRuntimeImpl.getClassImpl(varTypeDecComp.getTypeNative());
        VarTypeNativeRuntimeImpl varTypeCompRt = VarTypeNativeRuntimeImpl.newVarTypeNativeRuntime(classComp,varTypeDecComp,ctx);      
        return newTypeNativeArrayRuntime(javaClass,isPrimary,varTypeCompRt,ctx);       
    }    
        
    public TypeNativeParserImpl newTypeNativeParser()
    {
        return new TypeNativeArrayParserImpl(this);
    }
    
    public abstract TypeNativeArrayRuntimeImpl newTypeNativeArrayRuntime(Class javaClass,boolean isPrimary,VarTypeNativeRuntimeImpl varTypeCompRt,RuntimeContext ctx);

}
