/*
 * JavaClassAsNativeMultipleFieldContainerRuntimeImpl.java
 *
 * Created on 26 de mayo de 2005, 17:16
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.dll.DLLManagerImpl;
import com.innowhere.jnieasy.core.impl.dll.DynamicLibraryImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeMultipleFieldContainerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeBehaviorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeConstructorSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.NativeTypeManagerRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.method.NativeBehavior;
import com.innowhere.jnieasy.core.typedec.NativeMultipleFieldContainerDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeFieldDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeSeparatedFieldContainerDescriptor;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 *
 * @author jmarranz
 */
/* 
 *Consideramos a clases y estructuras casi como idénticos tipos (pueden tener constructores, métodos etc)
http://msdn.microsoft.com/library/default.asp?url=/library/en-us/vclang/html/_pluslang_Classes.asp
 */
/*
    Cálculo del offset y el tamaño teniendo en cuenta el 
    alineamiento:
    http://msdn.microsoft.com/library/default.asp?url=/library/en-us/dv_vstechart/html/vcconwindowsdataalignmentonipfx86x86-64.asp 
    http://msdn.microsoft.com/library/default.asp?url=/library/en-us/kmarch/hh/kmarch/64bitAMD_c0540e82-a6bd-4f48-a9bc-b21aa4496697.xml.asp*
    http://uk.builder.com/architecture/web/0,39026570,20277904,00.htm  (Structure alignment)     
    http://blogs.msdn.com/grantri/archive/2004/07/14/183524.aspx        
    http://blogs.msdn.com/larryosterman/archive/2005/04/07/406252.aspx        
    http://blogs.msdn.com/larryosterman/archive/2005/04/08/406572.aspx
    http://msdn.microsoft.com/library/default.asp?url=/library/en-us/vccore/html/_core_structure_alignment.asp
    http://msdn.microsoft.com/library/default.asp?url=/library/en-us/dv_vstechart/html/vcconwindowsdataalignmentonipfx86x86-64.asp        
    Opción del compilador /Zp   (Struct Member Alignment)
    Inspección del código fuente de xFunction (decompilado)
*/


public abstract class JavaClassAsNativeMultipleFieldContainerRuntimeImpl extends JavaClassAsNativeFieldContainerRuntimeImpl implements NativeMultipleFieldContainerDescriptor
{
    protected ArrayList fields = new ArrayList();    
    protected ArrayList behaviors = new ArrayList();
    protected JavaClassAsNativeSeparatedFieldContainerRuntimeImpl javaClassSuperRt; // no hay uniones base
    
    protected long desiredAlignSize; // el valor de alineamiento de los atributos de la estructura aplicado a esta estructura
    protected long alignSize = 1;  // el finalmente aplicado a la estructura
    protected long size = 0;
    protected boolean endLayout = false;
    protected int auxNativeObjectCount = 0;
    protected DynamicLibraryImpl dynamicLibrary;
    
    /**
     * Creates a new instance of JavaClassAsNativeMultipleFieldContainerRuntimeImpl
     */
    public JavaClassAsNativeMultipleFieldContainerRuntimeImpl(JavaClassAsNativeMultipleFieldContainerImpl javaClass,ClassTypeNativeMultipleFieldContainerRuntimeImpl classTypeRt)
    {
        super(javaClass,classTypeRt);
    }        
    
    public static JavaClassAsNativeMultipleFieldContainerRuntimeImpl initRegistrationMultipleFieldContainerType(ClassTypeNativeMultipleFieldContainerImpl classType,NativeCapableInternal factoryInst,String superClassName,String desiredAlignSize,int licenseUsedByEnhancer,RuntimeContext ctx)
    {
        // Estructuras y clases
        // Registra la clase pero sin tener información todavía del tamaño en memoria (size)
        // por lo que este es cero.
        // Si antes de definir el tamaño se necesita este tipo, por ejemplo en el enhancement
        // de un atributo con este mismo tipo, no pasa nada, pues dicho atributo ha de 
        // ser por referencia no por variable (tamaño infinito sería), por lo que
        // el tamaño no se necesita.
      
        JavaClassAsNativeMultipleFieldContainerRuntimeImpl javaClassRt = (JavaClassAsNativeMultipleFieldContainerRuntimeImpl)sharedInitRegistrationClassTypeNativeCapable(classType,factoryInst,licenseUsedByEnhancer);
        
        if (superClassName != null)
        {
            Class claszSuper = ClassTypeNativeRuntimeImpl.getClassFromVMClassName(superClassName, javaClassRt.getClassLoader(), true);
            // El Class asegura que se carga e inicializa     
            ClassTypeNativeCapableRuntimeImpl superClassTypeRt = (ClassTypeNativeCapableRuntimeImpl)ctx.getClassTypeRuntime(claszSuper);
            JavaClassAsNativeSeparatedFieldContainerRuntimeImpl superJavaClassRt = (JavaClassAsNativeSeparatedFieldContainerRuntimeImpl)superClassTypeRt.getJavaClassAsNativeCapableRuntime();
            javaClassRt.setClassSuperRuntime(superJavaClassRt);
        }
        
        javaClassRt.setDesiredAlignSize(desiredAlignSize);
        
        return javaClassRt;
    }

    public DynamicLibraryImpl getDynamicLibrary()
    {
        if (dynamicLibrary != null)
            return dynamicLibrary;
        else if (javaClassSuperRt != null)
            return javaClassSuperRt.getDynamicLibrary();
        else
            return null;
    }
    
    public void setDynamicLibrary(String libraryPath)
    {
        DLLManagerImpl dllMgr = getRuntimeManager().getDLLManager();
        this.dynamicLibrary = (DynamicLibraryImpl)dllMgr.get(libraryPath);
    }
    
    public ClassTypeNativeMultipleFieldContainerRuntimeImpl getClassTypeMultipleFieldContainerRuntime()
    {
        return (ClassTypeNativeMultipleFieldContainerRuntimeImpl)classTypeRt;
    }
    
    public JavaClassAsNativeMultipleFieldContainerImpl getJavaClassAsMultipleFieldContainer()
    {
        return (JavaClassAsNativeMultipleFieldContainerImpl)javaClass;
    }

    public JavaClassAsNativeMultipleFieldContainerRuntimeImpl getClassSuperRuntime()
    {
        return javaClassSuperRt;
    }

    public void setClassSuperRuntime(JavaClassAsNativeSeparatedFieldContainerRuntimeImpl javaClassSuperRt)
    {
        this.javaClassSuperRt = javaClassSuperRt;
        if (javaClassSuperRt != null)
        {
            JavaClassAsNativeMultipleFieldContainerImpl javaClass = getJavaClassAsMultipleFieldContainer();
            javaClass.setClassSuper(javaClassSuperRt.getJavaClassAsSeparatedFieldContainer());
        }
    }   
    
    public long getDesiredAlignSize()
    {
        return desiredAlignSize;
    }

    public void setDesiredAlignSize(String desiredAlignSizeExpr)
    {
        long desiredAlignSize = getRuntimeManager().getTypeManagerRuntime().parseMemorySizeWithMacros(desiredAlignSizeExpr); 
                
        if (desiredAlignSize == TypeSizes.getUNKNOWN_SIZE())
            desiredAlignSize = getRuntimeManager().getTypeManagerRuntime().getStructureAlignSize();        
        else
            NativeTypeManagerRuntimeImpl.checkAlignSize(desiredAlignSize);        
        
        this.desiredAlignSize = desiredAlignSize;        
    }    
    
    public int getAbsAuxNativeObjectCount()
    {
        int count = auxNativeObjectCount;
        if (javaClassSuperRt != null) 
            count += javaClassSuperRt.getAbsAuxNativeObjectCount();        
        return count;
    }

    
    public void addField(int index,String fieldName,String fieldAlignSize,boolean beginUnion,boolean endUnion,VarTypeNative varTypeDec)
    {
        VarTypeNativeRuntimeImpl varTypeDecRt = (VarTypeNativeRuntimeImpl)varTypeDec;
        FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt = (FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl)newFieldOfClassRuntime(fieldName, varTypeDecRt);
        fieldRt.setIndex(index);
        int absIndex = index;
        if (javaClassSuperRt != null)
            absIndex += javaClassSuperRt.getAbsoluteFieldCount();         
        fieldRt.setAbsIndex(absIndex);   
        
        if (varTypeDecRt.getVarTypeNative().needAuxNativeCapable())
        {
            fieldRt.setAbsAuxNativeObjectIndex(getAbsAuxNativeObjectCount());
            auxNativeObjectCount++;
        }
        
        fieldRt.setDesiredAlignSize(fieldAlignSize);
        fieldRt.getFieldOfClassAsMultipleFieldContainer().setBeginUnion(beginUnion);
        fieldRt.getFieldOfClassAsMultipleFieldContainer().setEndUnion(endUnion);        

        fields.add(fieldRt);
    }   
    
    public void finalizeRegistration()
    {
        this.typeDecRt = (TypeNativeCapableRuntimeImpl)TypeNativeRuntimeImpl.newTypeNativeRuntime(getJavaClass(),classTypeRt, getDefaultRuntimeContext());
    }  
    
    public long size()
    {    
        // La primera vez que se necesita hace el layout si no ha sido hecho
        // así evitamos problemas de referencias cíclicas en tiempo de carga de las clases
        // hacemos el layout cuando quiera usarse por primera vez
        if (!endLayout)
            endLayout();
        return size;
    }
    
    public long alignSize()
    {
        // Ver getSize()
        if (!endLayout)
            endLayout();        
        return alignSize;
    }
    
    public boolean isEndLayout()
    {
        return endLayout;
    }    
  
    public ArrayList getFieldList()
    {
        // Tenemos que terminar el layout antes de que el usuario u otra tarea quiera acceder a los datos de los fields
        if (!endLayout) endLayout();  
        return fields;
    }    
    
    public NativeFieldDescriptor getField(int index)
    {
        ArrayList fields = getFieldList();
        return (NativeFieldDescriptor)fields.get(index);
    }         
    
    public NativeFieldDescriptor getAbsoluteField(int index)
    {
        int superAbsCount = 0;
        if (javaClassSuperRt != null)
            superAbsCount = javaClassSuperRt.getAbsoluteFieldCount();        
	if (index < superAbsCount)
	    return javaClassSuperRt.getAbsoluteField(index);
        else
            return getField(index - superAbsCount);
    }              
    
    public int getFieldCount()
    {
        ArrayList fields = getFieldList();
        return fields.size();
    }          

    
    public int getAbsoluteFieldCount()
    {
        int count = 0;
        if (javaClassSuperRt != null)
            count += javaClassSuperRt.getAbsoluteFieldCount();        
        count += fields.size();
        return count;
    }          

    
    public NativeFieldDescriptor[] getFields()
    {
        ArrayList fields = getFieldList();
        return (NativeFieldDescriptor[])fields.toArray(new NativeFieldDescriptor[fields.size()]);
    }
    
    public NativeFieldDescriptor getField(String fieldName)
    {
        ArrayList fields = getFieldList();
        for(int i = 0; i < fields.size(); i++)
        {
            NativeFieldDescriptor fieldDesc = (NativeFieldDescriptor)fields.get(i);
            if (fieldDesc.getName().equals(fieldName))
                return fieldDesc;
        }
        return null;
    }
    
    public FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl getFieldDescriptor(int index)
    {
        return (FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl)getFieldList().get(index);
    }
    
    public NativeSeparatedFieldContainerDescriptor getSuper()
    {
        return javaClassSuperRt;
    }     
    
    public void addConstructor(String javaClassName,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeName,NativeConstructorSignatureRuntimeImpl sig)
    {      
        Class clasz = getJavaClass();
        Constructor constructor = sig.getConstructor(clasz);       
        addBehavior(constructor,exportMethod,onLibrary,useReflection,nativeName,sig);        
    }   
    
    public void addMethod(String javaClassName,String methodName,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeName,NativeMethodSignatureRuntimeImpl sig)
    {
        Class clasz = getJavaClass();
        Method method = sig.getMethod(clasz,methodName);
        addBehavior(method,exportMethod,onLibrary,useReflection,nativeName,sig);
    }    

    public void addFieldMethod(String javaClassName,String fieldName,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeFieldName,NativeFieldMethodSignatureRuntimeImpl sig)
    {
        Class clasz = getJavaClass();
        Field field = sig.getField(clasz, fieldName);
        addBehavior(field,exportMethod,onLibrary,useReflection,nativeFieldName,sig);
    }       
    
    private void addBehavior(Member behavior,boolean exportMethod,boolean onLibrary,boolean useReflection,String nativeName,NativeBehaviorSignatureRuntimeImpl sig)
    {
        ClassTypeNativeMultipleFieldContainerRuntimeImpl classTypeContainerRt = getClassTypeMultipleFieldContainerRuntime();
        BehaviorOfClassRuntimeImpl behaviorOfClass = BehaviorOfClassRuntimeImpl.newBehaviorOfClassRuntime(this,behavior,sig,classTypeContainerRt);
        behaviors.add(behaviorOfClass);
        
        behaviorOfClass.setUseReflection(useReflection);
        if (exportMethod)
            behaviorOfClass.exportMethod();
        if (onLibrary)
            behaviorOfClass.setOnLibrary(getDynamicLibrary(),nativeName);        
    }

    public NativeBehavior getNativeBehavior(int index)
    {
        BehaviorOfClassRuntimeImpl behaviorOfClass = (BehaviorOfClassRuntimeImpl)behaviors.get(index);
        return behaviorOfClass.getNativeBehavior();
    }       
    
    public NativeBehaviorDescriptor[] getBehaviors()
    {
        return (NativeBehaviorDescriptor[])behaviors.toArray(new NativeBehaviorDescriptor[behaviors.size()]);
    }        
    
    public NativeBehaviorDescriptor getBehavior(Member member)
    {
        for(int i = 0; i < behaviors.size(); i++)
        {
            NativeBehaviorDescriptor behaviorDesc = (NativeBehaviorDescriptor)behaviors.get(i);
            if (behaviorDesc.getMember().equals(member))
                return behaviorDesc;
        }
        return null;        
    }
   
    public ArrayList prepareFieldsLayout()
    {
        ArrayList fieldsLayout = new ArrayList();
        LayoutUnionGroupFieldInfo lastUnionFieldGroupLayout = null;
        for(int i = 0; i < fields.size(); i++)
        {        
            FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl fieldRt = (FieldOfClassAsNativeMultipleFieldContainerRuntimeImpl)fields.get(i);
            FieldOfClassAsNativeMultipleFieldContainerImpl field = fieldRt.getFieldOfClassAsMultipleFieldContainer();
            boolean isBeginUnion = field.isBeginUnion();
            boolean isEndUnion = field.isEndUnion();            
            if (isBeginUnion)
            {
                lastUnionFieldGroupLayout = new LayoutUnionGroupFieldInfo();
                fieldsLayout.add(lastUnionFieldGroupLayout);
                ((LayoutUnionGroupFieldInfo)lastUnionFieldGroupLayout).addField(fieldRt);           
            }            
            else if (isEndUnion)
            {
                if (lastUnionFieldGroupLayout == null) throw new JNIEasyException("Unexpected end of field union");
                ((LayoutUnionGroupFieldInfo)lastUnionFieldGroupLayout).addField(fieldRt);
                lastUnionFieldGroupLayout = null;
            }
            else if (lastUnionFieldGroupLayout != null)
            {
                ((LayoutUnionGroupFieldInfo)lastUnionFieldGroupLayout).addField(fieldRt);
            }
            else
            {
                // field normal fuera de union
                fieldsLayout.add(new LayoutSingleFieldInfo(fieldRt));
            }   
        }
        return fieldsLayout;
    }
    
    public boolean isEmpty()
    {
        return fields.isEmpty();
    }
    
    public void endLayout()
    {
        if (endLayout) return;
       
        long size = 0;
        if (javaClassSuperRt != null)
        {
            size = javaClassSuperRt.size();
            if ((size == 1) && javaClassSuperRt.isEmpty())
                size = 0; // El valor 1 es cuando la clase base se instancia por si misma, pero el 1 no cuenta en herencia, comprobado en Visual C++
        }
        
        long maxFieldAlignSize = 1;  // el alineamiento finalmente aplicado a la estructura
        
        ArrayList fieldsLayout = prepareFieldsLayout();
        
        for(int i = 0; i < fieldsLayout.size(); i++)
        {
            LayoutFieldInfo fieldInfo = (LayoutFieldInfo)fieldsLayout.get(i);

            long fieldAlignSize = fieldInfo.getAlignSize(); // el definitivo aplicado
            long fieldSize = fieldInfo.getSize();
             
            long offset = LayoutFieldInfo.align(size, fieldAlignSize);                        
            fieldInfo.setOffset(offset);   

            size = offset + fieldSize;

            if (fieldAlignSize > maxFieldAlignSize)
                maxFieldAlignSize = fieldAlignSize;        
        }
        
        if (size != 0)
            size = LayoutFieldInfo.align(size, maxFieldAlignSize);  
        else
            size = 1; // Estructura o clase sin atributos, se impone el alineamiento mínimo (comprobado en el Visual C++) 
        
        this.size = size;
        this.alignSize = maxFieldAlignSize;
        
        this.endLayout = true;
    }        
}
