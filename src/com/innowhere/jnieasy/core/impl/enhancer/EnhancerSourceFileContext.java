/*
 * EnhancerSourceFileContext.java
 *
 * Created on 31 de marzo de 2005, 12:06
 */

package com.innowhere.jnieasy.core.impl.enhancer;

/**
 *
 * @author  jmarranz
 */
import javassist.*;
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.impl.common.ClassResolver;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.JavaClassAsNativeCapableEnhancer;
import com.innowhere.jnieasy.core.impl.enhancer.model.classdesc.PackageEnhancer;

public class EnhancerSourceFileContext extends TaskContext
{
    protected EnhancerSharedContext ctx;
    protected ClassResolver classTypeResolver;
    protected ClassResolver ctClassResolver;    
    
    /** Creates a new instance of EnhancerSourceFileContext */
    public EnhancerSourceFileContext(EnhancerSharedContext ctx,PackageEnhancer pkgEnh)
    {
        super(ctx.getJNIEasy());
        this.ctx = ctx;
        this.ctClassResolver = new ClassResolver(pkgEnh.getPackageDec(),pkgEnh.getImportList(),ctx.getCtClassFinder()); 
        this.classTypeResolver = new ClassResolver(pkgEnh.getPackageDec(),pkgEnh.getImportList(),classTypeMgr.getClassTypeFinder()); 
    }
    
    public EnhancerSharedContext getParentContext()
    {
        return ctx;
    }
    
    public ClassTypeNativeImpl findClassType(String className)
    {
        return (ClassTypeNativeImpl)classTypeResolver.findClassInfo(className);
    }
    
    protected ClassTypeNativeImpl getClassTypeNotFindInternal(MetaClassWrapper clasz,boolean throwError)
    {
        return getClassTypeNotFindInternal(clasz, throwError, true);
    }    
    
    protected ClassTypeNativeImpl getClassTypeNotFindInternal(MetaClassWrapper clasz,boolean throwError,boolean tryEnhance)
    {
        // Hay que tener en cuenta que el CtClass de dentro del
        // CtClassWrapper puede ser custom y no haber sido enhanced, eso significa
        // que no encontrará ni podrá crear el ClassTypeNativeImpl y dará error
        // por eso llamamos a getTypeEnhancer() para que al crear
        // la clase JavaClassAsNativeCapableEnhancer registre el ClassTypeNativeImpl
        // adecuado via XML, aunque no esté enhanced el CtClass

        CtClassWrapper classWrapper = (CtClassWrapper)clasz;

        JavaClassAsNativeCapableEnhancer classTypeEnh;
        
        if (tryEnhance)
            classTypeEnh = getParentContext().getTypeEnhancer(classWrapper.getCtClass());
        else
            classTypeEnh = getParentContext().findTypeEnhancer(classWrapper.getName());
        
        if (classTypeEnh != null)
            return classTypeEnh.getClassTypeNativeCapable();        
        
        return classTypeMgr.getClassType(classWrapper,this,true,throwError);
    }   

    public CtClass getCtClassNotUsingImports(String className)
    {    
        return ctx.getCtClass(className);        
    }
    
    public CtClass getCtClass(String className)
    {
        CtClass ctClass = (CtClass)ctClassResolver.findClassInfo(className);
        if (ctClass == null)
            throw new JNIEasyException("Not found class: " + className);
        return ctClass;
    }        
    
    public ClassTypeNativeImpl getClassType(CtClass ctClass)
    {
        CtClassWrapper classWrapper = new CtClassWrapper(ctClass);
        return getClassType(classWrapper);            
    }    
/*    
    public ClassTypeNativeImpl getClassTypeNotTryEnhance(CtClass ctClass)
    {
        ClassTypeNativeImpl dataType = classTypeMgr.findClassType(ctClass.getName());
        if (dataType != null) return dataType; // A la primera, es un tipo conocido

        CtClassWrapper classWrapper = new CtClassWrapper(ctClass);
        return getClassTypeNotFindInternal(classWrapper,true,false);    
    }    
*/    
    public MetaClassWrapper newMetaClassWrapper(String className)
    {
        CtClass ctClass = (CtClass)ctClassResolver.findClassInfo(className);
        if (ctClass == null) throw new JNIEasyException("Class not found : " + className);
        return new CtClassWrapper(ctClass);
    }
}
