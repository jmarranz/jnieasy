/*
 * TaskContext.java
 *
 * Created on 26 de febrero de 2005, 16:30
 */

package com.innowhere.jnieasy.core.impl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.typedec.model.NativeTypeNativeManagerImpl;


public abstract class TaskContext
{
    protected JNIEasyImpl jniEasy;
    protected ClassTypeManagerImpl classTypeMgr;
    protected NativeTypeNativeManagerImpl typeDecMgr;
    
    /** Creates a new instance of TaskContext */
    public TaskContext(JNIEasyImpl jniEasy)
    {
        this.jniEasy = jniEasy;
        this.classTypeMgr = jniEasy.getClassTypeManager();
        this.typeDecMgr = jniEasy.getTypeManagerImpl();
    }
    
    public JNIEasyImpl getJNIEasy()
    {
        return jniEasy;
    }
    
    public ClassTypeManagerImpl getClassTypeManager()
    {
        return classTypeMgr;
    }
    
    public NativeTypeNativeManagerImpl getTypeManagerImpl()
    {
        return typeDecMgr;
    }
      
    public abstract ClassTypeNativeImpl findClassType(String className);
    
    public ClassTypeNativeImpl getClassType(String className)
    {
        return getClassType(className,true);
    }    
    
    public ClassTypeNativeImpl getClassType(String className,boolean throwError)
    {
        ClassTypeNativeImpl dataType = findClassType(className);
        if (dataType != null) return dataType; // A la primera, es un tipo conocido

        // Se vuelve a hacer findClassType pero así evitamos crear el MetaClassWrapper cuando ya esté registrado
        
        MetaClassWrapper clasz = newMetaClassWrapper(className);
        return getClassTypeNotFindInternal(clasz,throwError);
    }    
    
    public ClassTypeNativeImpl getClassType(MetaClassWrapper clasz)
    {
        return getClassType(clasz,true);
    }
    
    public ClassTypeNativeImpl getClassType(MetaClassWrapper clasz,boolean throwError)
    {
        ClassTypeNativeImpl dataType = findClassType(clasz.getName());
        if (dataType != null) return dataType; // A la primera, es un tipo conocido

        return getClassTypeNotFindInternal(clasz,throwError);
    }    
    
    protected abstract ClassTypeNativeImpl getClassTypeNotFindInternal(MetaClassWrapper clasz,boolean throwError);
    public abstract MetaClassWrapper newMetaClassWrapper(String className);
}
