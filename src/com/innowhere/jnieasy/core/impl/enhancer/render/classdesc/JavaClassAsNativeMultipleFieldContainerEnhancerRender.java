/*
 * JavaClassAsNativeMultipleFieldContainerEnhancerRender.java
 *
 * Created on 11 de diciembre de 2004, 21:02
 */

package com.innowhere.jnieasy.core.impl.enhancer.render.classdesc;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.FieldOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.render.TypeNativeRender;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSourceFileContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.BehaviorOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.FieldOfClassEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeMultipleFieldContainerEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.rt.*;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeObjectImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeMultipleFieldContainerInternal;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.typedec.TypeNative;
import java.util.ArrayList;
import java.util.List;
import javassist.CodeConverter;
import javassist.CtClass;
import javassist.CtMethod;
import javassist.Modifier;


public abstract class JavaClassAsNativeMultipleFieldContainerEnhancerRender extends JavaClassAsNativeFieldContainerEnhancerRender
{
    protected FieldOfClassAsNativeMultipleFieldContainerEnhancerRender[] fieldList;
    protected BehaviorOfClassEnhancerRender[] behaviorList;    
    
    /** Creates a new instance of ClassAsMultipleFieldContainerRender */
    public JavaClassAsNativeMultipleFieldContainerEnhancerRender(JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer)
    {
        super(classEnhancer);        
        
        List fields = classEnhancer.getFields();
        int numFields = fields.size();

        this.fieldList = new FieldOfClassAsNativeMultipleFieldContainerEnhancerRender[numFields];
        for(int i = 0; i < numFields; i++)
        {
            FieldOfClassEnhancer enhField = (FieldOfClassEnhancer)fields.get(i);
            
            FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldEnhRender = (FieldOfClassAsNativeMultipleFieldContainerEnhancerRender)FieldOfClassEnhancerRender.newFieldOfClassEnhancerRender(enhField);
            fieldList[i] = fieldEnhRender;
        }           
        
        List behaviors = classEnhancer.getBehaviors();
        int numBehaviors = behaviors.size();

        this.behaviorList = new BehaviorOfClassEnhancerRender[numBehaviors];
        for(int i = 0; i < behaviors.size(); i++)
        {
            BehaviorOfClassEnhancer behaviorEnh = (BehaviorOfClassEnhancer)behaviors.get(i);
            BehaviorOfClassEnhancerRender behaviorEnhRender = BehaviorOfClassEnhancerRender.newBehaviorOfClassEnhancerRender(behaviorEnh);
            behaviorList[i] = behaviorEnhRender;            
        }              
    }
    
    public JavaClassAsNativeMultipleFieldContainerEnhancer getJavaClassAsMultipleFieldContainerEnhancer()
    {
        return (JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer;
    }
        
    public String getRegisterDLLCode()
    {
        JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer = getJavaClassAsMultipleFieldContainerEnhancer();
        String libPath = classEnhancer.getJavaClassAsMultipleFieldContainer().getLibraryPath();
        if (libPath != null)
            return NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".registerDynamicLibrary(jnieasyClassInfo,\"" + libPath + "\"); \n";
        else
            return "";
    }    
    
    public void enhanceDynamic(EnhancerSourceFileContext ctx,JavaClassAsNativeCapableEnhancer classEnhSuper)
    {
        JavaClassAsNativeMultipleFieldContainerEnhancer classEnhancer = getJavaClassAsMultipleFieldContainerEnhancer();       
        ArrayList methods = classEnhancer.getEnhanceableBehaviors();  // Los obtenemos antes de añadir los nuevos

        super.enhanceDynamic(ctx, classEnhSuper);        
        
        if (classEnhSuper == null) // Basta que estén una sola vez, si hay clase base enhanced se habrán definido arriba
        {
            addInternalGetSizeMethod(ctx);
            
            // Ej. protected transient TypeNative jnieasyType = null;  (pero con packages absolutos)
            // lo de transient es para evitar que se considere "enhanceable"
            addNewField(Modifier.PROTECTED | Modifier.TRANSIENT,ctx.getCtClassNotUsingImports(TypeNative.class.getName()),"jnieasyType", "null");        
            addInternalGetDefaultTypeMethod(ctx);
            addInternalSetTypeMethod(ctx);   
            addInternalGetTypeMethod(ctx);            

            // Ej. protected transient NativeStateManager jnieasyNativeStateManager = new NativeStateManagerImpl(this,jnieasyGetSize()); 
            // lo de transient es para evitar que se considere "enhanceable"
            addNewField(Modifier.PROTECTED | Modifier.TRANSIENT,ctx.getCtClassNotUsingImports(NativeStateManager.class.getName()),"jnieasyNativeStateManager","null");

            addInternalNewNativeStateManagerMethod(ctx);            
            addInternalGetNativeStateManagerMethod(ctx);
            addInternalSetNativeStateManagerMethod(ctx);
            addInternalCloneMethod(ctx);
        }
      
        enhanceAccessOfFields(methods,ctx);
        
        addInternalFetchFieldsClassMethod(ctx);        
        addInternalUnFetchFieldsClassMethod(ctx);
        addInternalFetchMethod(classEnhSuper,ctx);
        addInternalUnFetchMethod(classEnhSuper,ctx);
        addInternalAttachCopyMethod(classEnhSuper,ctx); 
        addInternalDetachFieldsMethod(classEnhSuper,ctx);        
        addInternalReplaceFieldsWithClonedMethod(classEnhSuper,ctx);
        
        addGetAbsoluteFieldCount(ctx);        
        addGetFieldMethod(classEnhSuper,ctx);   
        addSetFieldMethod(classEnhSuper,ctx);       
        if (classEnhSuper == null)  
        {
            addGetFieldMethod2(ctx);              
            addSetFieldMethod2(ctx);        
        }
        enhanceDLLBasedBehaviors(ctx);
    }   
    
    public String getFieldsAndMethodsStaticCodeInitializer()
    {       
        StringBuffer staticCode = new StringBuffer();
        int numFields = fieldList.length;        
        for(int i = 0; i < numFields; i++) // Del último al primero porque se añade siempre el código al ppio del constructor estático 
        {
            FieldOfClassEnhancerRender fieldEnhRender = fieldList[i];
            staticCode.append( fieldEnhRender.getStaticCodeInitializer() );
        }   
        
        // Sólo hacemos enhanced a los métodos declarados en el XML
        // no a todos los métodos de la clase
       
        for(int i = 0; i < behaviorList.length; i++) // Del último al primero porque se añade siempre el código al ppio del constructor estático 
        {
            BehaviorOfClassEnhancerRender behaviorEnhRender = behaviorList[i];
            staticCode.append( NativeMultipleFieldContainerEnhancerImpl.class.getName() + "." + behaviorEnhRender.getAddMethodCall(false) );
        }           
        
        return staticCode.toString();
    }
    
    public void enhanceFields(CodeConverter converter,EnhancerSourceFileContext ctx)
    {
        int size = fieldList.length;

        for(int i = 0; i < size; i++)
        {
            FieldOfClassEnhancerRender enhFieldRender = fieldList[i];
            enhFieldRender.enhance(converter,ctx);
        }    
    }
    
    public void addInternalSetTypeMethod(EnhancerSourceFileContext ctx)
    {
        /* 
        public void jnieasySetType(TypeNative typeDec) 
        */
        // No se hace nada, el TypeNative se obtiene del objeto descriptor
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  this.jnieasyType = $1; \n" );        
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,CtClass.voidType, "jnieasySetType", 
            new CtClass[]{ctx.getCtClassNotUsingImports(TypeNative.class.getName())}, null, body.toString());        
    }
    
  
    public void addInternalGetTypeMethod(EnhancerSourceFileContext ctx)
    {
        /* 
        public TypeNative jnieasyGetType() 
        */
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getTypeNative(this,this.jnieasyType); \n" );
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports(TypeNative.class.getName()), "jnieasyGetType", 
            null, null, body.toString());        
    }
    
    public void addInternalGetSizeMethod(EnhancerSourceFileContext ctx)
    {
        /*
        public long jnieasyGetSize() 
        */

        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getClassSize(jnieasyGetNativeClassDescriptor());\n" );
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.longType, "jnieasyGetSize", 
            null, null, body.toString());
    }    
    
    public void addInternalNewNativeStateManagerMethod(EnhancerSourceFileContext ctx)
    {
        // public (pkg).NativeStateManager jnieasyNewNativeStateManager() 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".newNativeStateManager(jnieasyClassInfo); \n" );
        body.append( "}" );

        // Es necesario llamar a jnieasyGetSize() y no usar el atributo jnieasySize pues en caso de herencia hay que coger el valor más derivado y acumular con los superiores        
        
        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports(NativeStateManager.class.getName()),
            "jnieasyNewNativeStateManager",null,null,body.toString());
    }            

    
    public void addInternalGetNativeStateManagerMethod(EnhancerSourceFileContext ctx)
    {
        // public (pkg).NativeStateManager jnieasyGetNativeStateManager() 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return jnieasyNativeStateManager; \n" );
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports(NativeStateManager.class.getName()),
            "jnieasyGetNativeStateManager",null,null,body.toString());
    }    
    
    public void addInternalSetNativeStateManagerMethod(EnhancerSourceFileContext ctx)
    {
        // public void jnieasySetNativeStateManager(NativeStateManager ptr) 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  this.jnieasyNativeStateManager = $1; \n" );
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType,"jnieasySetNativeStateManager",
            new CtClass[]{ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},
            null,body.toString());
    }       

    public void addInternalFetchFieldsClassMethod(EnhancerSourceFileContext ctx)
    {
        // public void jnieasy_ClassName_fetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr) 
        String methodName = "jnieasy_" + classEnhancer.getSimpleName() + "_fetchFields";
 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        for(int i = 0; i < fieldList.length; i++)
        {
            FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldRender = fieldList[i];
            body.append( fieldRender.getFetchFieldCode("$1", "$2","$3") );
        }
      
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            methodName,new CtClass[]{CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},null,body.toString());
    }        
    
    public void addInternalUnFetchFieldsClassMethod(EnhancerSourceFileContext ctx)
    {
        // public void jnieasy_ClassName_unFetchFields(ClassName fromObj,int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr) 

        String methodName = "jnieasy_" + classEnhancer.getSimpleName() + "_unFetchFields";
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        for(int i = 0; i < fieldList.length; i++)
        {
            FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldRender = fieldList[i];
            FieldOfClassEnhancer fieldEnh = fieldRender.getFieldOfClassEnhancer(); 
            String fieldName = fieldEnh.getFieldOfClass().getName();

            body.append( fieldRender.getUnFetchFieldCode("$1." + fieldName,"$2","$3","$4","$5") );
        }
        
        body.append( "}" );
        
        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            methodName,
            new CtClass[]{ctx.getCtClass(classEnhancer.getName()),CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},
            null,body.toString());
    }          
    
    
    public void addInternalFetchMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public void jnieasyFetchFields(int mode,Object fetchCtx,NativeStateManager stateMgr) 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        if (classEnhSuper != null)
            body.append( "  super.jnieasyFetchFields($1,$2,$3); \n" );
           
        body.append( "  jnieasy_" + classEnhancer.getSimpleName() + "_fetchFields($1,$2,$3); \n" );
      
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            "jnieasyFetchFields",new CtClass[]{CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},null,body.toString());
    }    
    
    public void addInternalUnFetchMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public void jnieasyUnFetchFields(int mode,Object unfetchCtx,Object attachCopyCtx,NativeStateManager stateMgr) 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        if (classEnhSuper != null)
            body.append( "  super.jnieasyUnFetchFields($1,$2,$3,$4); \n" );

        body.append( "  jnieasy_" + classEnhancer.getSimpleName() + "_unFetchFields(this,$1,$2,$3,$4); \n" );
        
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            "jnieasyUnFetchFields",
            new CtClass[]{CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},
            null,body.toString());
    }      
 
    public void addInternalAttachCopyMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public void jnieasyAttachCopy(Object detached,Object attachCopyCtx,NativeStateManager stateMgr) 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        if (classEnhSuper != null)
            body.append( "  super.jnieasyAttachCopy($1,$2,$3); \n" );
        
        body.append( "  jnieasy_" + classEnhancer.getSimpleName() + "_unFetchFields((" + classEnhancer.getName() + ")$1," + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getDefaultUnFetchMode(this),null,$2,$3); \n" );
        
        body.append( "}" );
      
        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            "jnieasyAttachCopy",
            new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},
            null,body.toString());
    }       
    
    public void addInternalDetachFieldsMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public void jnieasyDetachFields(int freeMemMode,boolean deep,NativeStateManager stateMgr) 
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        if (classEnhSuper != null)
            body.append( "  super.jnieasyDetachFields($1,$2,$3); \n" );
        
        for(int i = 0; i < fieldList.length; i++)
        {
            FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldRender = (FieldOfClassAsNativeMultipleFieldContainerEnhancerRender)fieldList[i];
            FieldOfClassEnhancer fieldEnh = fieldRender.getFieldOfClassEnhancer();
            FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
            VarTypeNativeImpl varTypeDec = fieldOfClass.getVarTypeNative();
            if (varTypeDec instanceof VarTypeNativeObjectImpl)
            {
                int index = fieldRender.getIndex();
                String fieldName = fieldOfClass.getName(); 
                body.append( "  " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".detachField(jnieasyClassInfo," + index + ", this." + fieldName + ",$1,$2,$3); \n" );
            } 
        }        
        
        body.append( "}" );
      
        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            "jnieasyDetachFields",
                new CtClass[]{CtClass.intType,CtClass.booleanType,ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},
                null,body.toString());
    }          
    
    public void addInternalCloneMethod(EnhancerSourceFileContext ctx)
    {
        // public Object jnieasyClone() throws CloneNotSupportedException
        // Hace público el método clone()
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return clone(); \n" );        
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"),
            "jnieasyClone",null,new CtClass[] {ctx.getCtClassNotUsingImports(CloneNotSupportedException.class.getName())},body.toString());
    }     
    
    public void addGetFieldMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public synchronized Object jnieasyGetField(int absIndex,int mode)
        // Ha de estar definida en todas las clases
                
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        if (classEnhSuper != null)
        {
            body.append( "  int absCount  = super.jnieasyGetAbsoluteFieldCount(); \n" );           
            body.append( "  if ($1 < absCount) \n" );
            body.append( "    return super.jnieasyGetField($1,$2); \n" );
            body.append( "  int relIndex = $1 - absCount; \n" );
        }
        else
        {
            body.append( "  int relIndex = $1; \n" );
        }
        
        if (fieldList.length > 0)
        {
            body.append( "  switch(relIndex) \n" );          
            body.append( "  { \n" );
            for(int i = 0; i < fieldList.length; i++)
            {
                FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldRender = fieldList[i];
                FieldOfClassEnhancer fieldEnh = fieldRender.getFieldOfClassEnhancer();
                TypeNativeRender typeDecRender = fieldRender.getVarTypeNativeEnhancerRender().getVarTypeNativeRender().getTypeNativeRender();
                String fieldName = fieldEnh.getFieldOfClass().getName(); 
                body.append( "    case " + i + " : \n" );
                body.append( "      " + fieldRender.getFetchFieldCode("$2") );
                body.append( "      return " + typeDecRender.castToObject("this." + fieldName) + "; \n" );
            }                  
            body.append( "  } \n" );            
        }

         body.append( "  throw new " + JNIEasyException.class.getName() + "(\"Not valid index: \" + $1 ); \n" );
        
        body.append( "}" );        

        addNewMethod(Modifier.PUBLIC | Modifier.SYNCHRONIZED,ctx.getCtClassNotUsingImports("java.lang.Object"),
            "jnieasyGetField",new CtClass[]{CtClass.intType,CtClass.intType},null,body.toString());
    }        
    
    public void addGetFieldMethod2(EnhancerSourceFileContext ctx)
    {
        // public Object jnieasyGetField(int absIndex)

        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return jnieasyGetField($1," + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getDefaultFetchMode(this)); \n" );        
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,ctx.getCtClassNotUsingImports("java.lang.Object"),
            "jnieasyGetField",new CtClass[]{CtClass.intType},null,body.toString());
    }    
    
    public void addSetFieldMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public synchronized void jnieasySetField(int absIndex,Object newValue,int mode)
        // Ha de estar definida en todas las clases
        
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        if (classEnhSuper != null)
        {
            body.append( "  int absCount  = super.jnieasyGetAbsoluteFieldCount(); \n" );           
            body.append( "  if ($1 < absCount) \n" );
            body.append( "    return super.jnieasySetField($1,$2,$3); \n" );
            body.append( "  int relIndex = $1 - absCount; \n" );
        }
        else
        {
            body.append( "  int relIndex = $1; \n" );
        }
        
        if (fieldList.length > 0)
        {
            body.append( "  switch(relIndex) \n" );          
            body.append( "  { \n" );
            for(int i = 0; i < fieldList.length; i++)
            {
                FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldRender = fieldList[i];
                FieldOfClassEnhancer fieldEnh = fieldRender.getFieldOfClassEnhancer();
                TypeNativeRender typeDecRender = fieldRender.getVarTypeNativeEnhancerRender().getVarTypeNativeRender().getTypeNativeRender();
                String fieldName = fieldEnh.getFieldOfClass().getName(); 
                body.append( "    case " + i + " : \n" );
                body.append( "      " + fieldRender.getUnFetchFieldCode(typeDecRender.convertFromObject("$2"),"$3") );
                body.append( "      return; \n" );
            }                  
            body.append( "  } \n" );            
        }

        body.append( "  throw new " + JNIEasyException.class.getName() + "(\"Not valid index: \" + $1 ); \n" );        
        body.append( "}" );

        CtMethod method = addNewMethod(Modifier.PUBLIC | Modifier.SYNCHRONIZED,CtClass.voidType,
            "jnieasySetField",new CtClass[]{CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object"),CtClass.intType},null,body.toString());
    }            
    
    public void addSetFieldMethod2(EnhancerSourceFileContext ctx)
    {
        // public void jnieasySetField(int absIndex,Object newValue)

        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return jnieasySetField($1,$2," + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getDefaultUnFetchMode(this)); \n" );        
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            "jnieasySetField",new CtClass[]{CtClass.intType,ctx.getCtClassNotUsingImports("java.lang.Object")},null,body.toString());
    }        
    
    public void addGetAbsoluteFieldCount(EnhancerSourceFileContext ctx)
    {
        // public int jnieasyGetAbsoluteFieldCount()
        // Ha de estar en todas las clases, así devuelve el número de fields del NativeClassDescriptor dado hasta arriba
        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        body.append( "  return " + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".getAbsFieldCount(jnieasyClassInfo); \n" );        
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.intType,
            "jnieasyGetAbsoluteFieldCount",null,null,body.toString());
    }   
            
    public void addInternalReplaceFieldsWithClonedMethod(JavaClassAsNativeCapableEnhancer classEnhSuper,EnhancerSourceFileContext ctx)
    {
        // public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr)  throws CloneNotSupportedException

        StringBuffer body = new StringBuffer();
        body.append( "{ \n" );
        
        if (classEnhSuper != null)
            body.append( "  super.jnieasyReplaceFieldsWithCloned($1,$2); \n" );        
        
        for(int i = 0; i < fieldList.length; i++)
        {
            FieldOfClassAsNativeMultipleFieldContainerEnhancerRender fieldRender = (FieldOfClassAsNativeMultipleFieldContainerEnhancerRender)fieldList[i];
            FieldOfClassEnhancer fieldEnh = fieldRender.getFieldOfClassEnhancer();            
            FieldOfClassImpl fieldOfClass = fieldEnh.getFieldOfClass();
            VarTypeNativeImpl varType = fieldOfClass.getVarTypeNative();
            if (varType instanceof VarTypeNativeObjectImpl)
            {
                int index = fieldRender.getIndex();                
                String fieldName = fieldOfClass.getName();
                body.append( "  this." + fieldName + " = (" + varType.getTypeNative().getClassName() + ")" + NativeMultipleFieldContainerEnhancerImpl.class.getName() + ".cloneField(this,jnieasyClassInfo," + index + ",this." + fieldName + ",$1,$2); \n" );
            }
        }
        
        body.append( "}" );

        addNewMethod(Modifier.PUBLIC,CtClass.voidType,
            "jnieasyReplaceFieldsWithCloned",
            new CtClass[]{ctx.getCtClassNotUsingImports("java.lang.Object"),ctx.getCtClassNotUsingImports(NativeStateManager.class.getName())},
            null, body.toString());
    }        
    
    public void enhanceDLLBasedBehaviors(EnhancerSourceFileContext ctx)
    {
        for(int i = 0; i < behaviorList.length; i++)
        {
            BehaviorOfClassEnhancerRender behaviorEnhRender = behaviorList[i];
            BehaviorOfClassEnhancer behaviorEnh = behaviorEnhRender.getBehaviorOfClassEnhancer();
            if (behaviorEnh.isOnLibrary())
                behaviorEnhRender.enhanceDLLBasedBehavior(ctx);
        }   
    }
    
    public String getInternalNativeInterfaceName()    
    {
        return NativeMultipleFieldContainerInternal.class.getName();
    }
}
