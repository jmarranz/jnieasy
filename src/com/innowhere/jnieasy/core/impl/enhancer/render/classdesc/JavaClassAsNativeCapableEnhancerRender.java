/*
 * EnhancedClass.java
 *
 * Created on 18 de marzo de 2004, 17:22
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import javassist.*;
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.NativeUserDefinedClass;
import com.innowhere.jnieasy.core.impl.dll.JNIEasyLibraryImpl;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.render.EnhancerRenderUtil;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.typedec.TypeNative;
import com.innowhere.jnieasy.core.typedec.NativeClassDescriptor;

public abstract class JavaClassAsNativeCapableEnhancerRender
{
    protected JavaClassAsNativeCapableEnhancer classEnhancer;

    
    /** Creates a new instance of EnhancedClass */
    public JavaClassAsNativeCapableEnhancerRender(JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        this.classEnhancer = classEnhancer;
    }
    
    public JavaClassAsNativeCapableEnhancer getJavaClassAsNativeCapableEnhancer()
    {
        return classEnhancer;
    }
    
    public static JavaClassAsNativeCapableEnhancerRender newJavaClassAsNativeCapableEnhancerRender(JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return classEnhancer.newJavaClassAsNativeCapableEnhancerRender();
    }
    
    public static void enhance(JavaClassAsNativeCapableEnhancer classEnh,EnhancerSourceFileContext ctx)
    {
        if (!classEnh.isEnhanced()) // es posible que hay sido enhanced a través del ClassLoader
        {                
            JavaClassAsNativeCapableEnhancerRender classEnhRender = newJavaClassAsNativeCapableEnhancerRender(classEnh);
            classEnhRender.enhance(ctx);
        }          
    }
    
    public CtField addNewField(int modifiers,CtClass ctFieldType,
        String name,String exprInit)
    {
        CtClass declaring = classEnhancer.getCtClass();
        return EnhancerRenderUtil.addNewField(modifiers,ctFieldType,name,exprInit,declaring);
    }    
    
    
    public CtMethod addNewMethod(int modifiers,
        CtClass ctReturnType,String mname,CtClass[] ctParameters,
        CtClass[] ctExceptions,String body)
    {    
        CtClass declaring = classEnhancer.getCtClass();
        return EnhancerRenderUtil.addNewMethod(modifiers,ctReturnType, mname, 
            ctParameters, ctExceptions, body, declaring);
    }
    
    public CtConstructor addNewConstructor(int modifiers,CtClass[] ctParameters,
        CtClass[] ctExceptions,String body)
    {           
        CtClass declaring = classEnhancer.getCtClass(); 
        return EnhancerRenderUtil.addNewConstructor(modifiers, 
            ctParameters, ctExceptions, body, declaring);
    }    
    
    public abstract JavaClassAsNativeCapableEnhancer enhanceSuperClass(EnhancerSourceFileContext ctx);

    
    public void enhance(EnhancerSourceFileContext ctx)
    {
        // Primero hacemos enhancer a la clase base si existe y si es enhanceable
        // y si no está ya enhanced, pues el enhancement de la derivada basa algunas
        // cosas en la base si existe.
      
        JavaClassAsNativeCapableEnhancer classEnhSuper = enhanceSuperClass(ctx);        

        // Aunque podrían definirse una sola vez en la clase base lo hacemos en todas las clases del árbol de derivación
        // pues así ganamos independencia respecto a si la clase base está enhanced o no, pues para determinar el tipo de la clase
        // se consultan las interfaces que implementa.
        // De otra manera se da el caso de que el CtClass de una clase derivada esté enhanced pero al ver que interfaz cumple
        // para averiguar el tipo dicho tipo tendría que conseguirlo de la clase base que podría no estar enhanced.
        CtClass valueClass = classEnhancer.getCtClass();            
        valueClass.addInterface(ctx.getCtClassNotUsingImports(getNativeInterfaceName()));
        valueClass.addInterface(ctx.getCtClassNotUsingImports(getInternalNativeInterfaceName()));       
        valueClass.addInterface(ctx.getCtClassNotUsingImports(NativeUserDefinedClass.class.getName()));        

        enhanceStatic(ctx,classEnhSuper);
        enhanceDynamic(ctx,classEnhSuper);
       
        classEnhancer.setEnhanced(true);
    }    
    
    public void enhanceStatic(EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnhSuper)
    {
        try
        {
            CtClass valueClass = classEnhancer.getCtClass();
            CtConstructor ctConstStatic = valueClass.makeClassInitializer(); // Si ya existe no hace nada salvo devolverlo, es necesario pues la iniciación de los atributos estáticos se hace en este constructor

            /* Guardamos el id de la licencia de desarrollo (es la que nos interesa, en el caso de evaluación nos da igual)
             * para que cuando se publiquen clases hechas con JNIEasy ver cual es 
             * la licencia de desarrollo usada y ver si es "pirata" o no.
             */
            JNIEasyLibraryImpl jnieasyLib = (JNIEasyLibraryImpl)this.classEnhancer.getEnhancerSharedContext().getJNIEasy().getJNIEasyLib();
            valueClass.setAttribute("product_license_id",jnieasyLib.getLicenseId().getBytes());       
            
            valueClass.setAttribute("jnieasyFormatVersion",JavaClassAsNativeCapableEnhancer.jnieasyFormatVersion_value.getBytes());
            // Aunque exista clase base toda clase debe tener este atributo pues es una forma de conocer que está enhanced al decompilar (y la versión)
            // public static String jnieasyFormatVersion = "1.0";
            addNewField(Modifier.PUBLIC | Modifier.STATIC,ctx.getCtClassNotUsingImports("java.lang.String"),JavaClassAsNativeCapableEnhancer.jnieasyFormatVersion_name,"\"" + JavaClassAsNativeCapableEnhancer.jnieasyFormatVersion_value + "\"");

            // Ej. public static NativeXXXDescriptor jnieasyClassInfo;
            addNewField(Modifier.PUBLIC | Modifier.STATIC,ctx.getCtClassNotUsingImports(getDescriptorClassName()),"jnieasyClassInfo","null");
            
            addInternalVoidConstructor(ctx,classEnhSuper);
            addInternalInitClassMethod(ctx);
            
            String staticCode = getStaticCodeInitializer();

            ctConstStatic.insertBefore(staticCode); // Genera un código muchísimo más claro que insertAfter
        }
        catch(CannotCompileException ex)
        {
            throw new JNIEasyException(ex);
        }                      
    }    
    
    public void enhanceDynamic(EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnhSuper)
    {
        // se redefine
        addInternalNewInstanceMethod(ctx);
        addInternalNewArrayInstanceMethod(ctx);
        addGetNativeClassDescriptor(ctx);        
    }
   
    public abstract String getDescriptorClassName();
    
    public abstract String getFieldsAndMethodsStaticCodeInitializer();
    
    public String getStaticCodeInitializer()
    {
        StringBuffer code = new StringBuffer();

        code.append( NativeCapableInternal.class.getName() + " factoryInst = new " + classEnhancer.getName() + "(" + VoidConstructorDiscriminator.class.getName() + ".SINGLETON); \n" );            
        code.append( "factoryInst.jnieasyInitClass(" + JNIEasy.class.getName() + ".get()); \n" );     
        
        return code.toString();
    }

    public abstract String getRegisterDLLCode();
    
    public String getFinalizeRegistrationTypeCode()
    {
        return NativeCapableEnhancerImpl.class.getName() + ".finalizeRegistration(jnieasyClassInfo); \n";
    }      

    public abstract String getInitRegistrationTypeCode();
    
   
    public void addInternalInitClassMethod(EnhancerSourceFileContext ctx)
    {
        /* Ha de repetirse en cada clase, se llamará la más derivada
        public void jnieasyInitClass(JNIEasy jnieasy)
         Ha de existir un constructor sin parámetros, no son válidas clases inner  
         no estáticas porque no es posible hacer un new de la clase fuera de la clase
         padre y fuera de un ámbito no estático (necesita una instancia de la clase padre), 
         esta no es una limitación "trascendental" respecto al mundo nativo por otra parte.
        */
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "if (jnieasyClassInfo != null) return; \n" );
        body.append( JNIEasy.class.getName() + " jnieasyRoot = $1; \n" );
        body.append( "java.lang.ClassLoader jnieasyClassLoader = this.getClass().getClassLoader(); \n" );     
        body.append( "jnieasyClassInfo = " + getInitRegistrationTypeCode() );       
        body.append( getRegisterDLLCode() );
        body.append( getFieldsAndMethodsStaticCodeInitializer() );
        body.append( getFinalizeRegistrationTypeCode() );           
        body.append( "}" );
       
        try
        {
            addNewMethod(Modifier.PUBLIC,CtClass.voidType, "jnieasyInitClass", 
                new CtClass[]{ctx.getCtClassNotUsingImports(JNIEasy.class.getName())}, null, body.toString()); 
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Class must have a constructor without params : " + classEnhancer.getName(), ex);
        }
      
    }    
    
    public void addInternalVoidConstructor(EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnhSuper)
    {
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        if (classEnhSuper != null)
            body.append( "super($1); \n" ); // La única finalidad de este método es evitar que se llame al constructor por defecto de la clase base native capable, así no ejecutamos código "normal" en este proceso
        body.append( "}" ); 
        
        addNewConstructor(Modifier.PUBLIC,new CtClass[]{ctx.getCtClassNotUsingImports(VoidConstructorDiscriminator.class.getName())},
            null, body.toString()); 
    }
    
    public void addInternalNewInstanceMethod(EnhancerSourceFileContext ctx)
    {
        /* Ha de repetirse en cada clase, se llamará la más derivada
        public Object jnieasyNewInstance()
         Ha de existir un constructor sin parámetros, no son válidas clases inner  
         no estáticas porque no es posible hacer un new de la clase fuera de la clase
         padre y fuera de un ámbito no estático (necesita una instancia de la clase padre), 
         esta no es una limitación "trascendental" respecto al mundo nativo por otra parte.
        */
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return new " + classEnhancer.getName() + "(); \n" );
        body.append( "}" );
       
        try
        {
            addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"), "jnieasyNewInstance", 
                null, null, body.toString()); 
        }
        catch(Exception ex)
        {
            throw new JNIEasyException("Class must have a constructor without params : " + classEnhancer.getName(), ex);
        }
      
    }

    public void addInternalNewArrayInstanceMethod(EnhancerSourceFileContext ctx)
    {
        /* Ha de repetirse en cada clase, se llamará la más derivada
        public Object jnieasyNewArrayInstance(int len)
        */
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return new " + classEnhancer.getName() + "[$1]; \n" );
        body.append( "}" );
       
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object[]"), "jnieasyNewArrayInstance", 
            new CtClass[]{CtClass.intType}, null, body.toString()); 
      
    }    
    
    public void addGetNativeClassDescriptor(EnhancerSourceFileContext ctx)
    {
        /* Ha de repetirse en cada clase, se llamará la más derivada
        public NativeClassDescriptor jnieasyGetNativeClassDescriptor()
        */
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return jnieasyClassInfo; \n" );
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports(NativeClassDescriptor.class.getName()), "jnieasyGetNativeClassDescriptor", 
            null, null, body.toString());        
    }
   
    public void addInternalGetDefaultTypeMethod(EnhancerSourceFileContext ctx)
    {
        /* 
        public TypeNative jnieasyGetDefaultType() 
        */
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return " + NativeCapableEnhancerImpl.class.getName() + ".getDefaultType(jnieasyGetNativeClassDescriptor()); \n" );
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports(TypeNative.class.getName()), "jnieasyGetDefaultType", 
            null, null, body.toString());        
    }    

    public abstract String getNativeInterfaceName();  
    public abstract String getInternalNativeInterfaceName();    
 
}
