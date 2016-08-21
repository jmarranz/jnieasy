/*
 * ClassTypeNativePrimitiveImpl.java
 *
 * Created on 22 de enero de 2004, 21:12
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativePrimitiveObjectImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativePrimitiveWrapperImpl;
import java.util.*;


/* Algunos métodos de esta clase son debidos a que no es posible
 *instanciar un Class que represente a un "int" por ejemplo, debe
 *hacerse con el wrapper. Tampoco funciona un Class.forName("int")
 *aunque existe el objeto Class que representa al tipo int etc.
 */


public abstract class ClassTypeNativePrimitiveImpl extends ClassTypeNativeImpl
{
    protected static final Map primitiveJNINames = Collections.synchronizedMap(new HashMap());

    static
    {
        primitiveJNINames.put("void","V");
        primitiveJNINames.put("boolean","Z");
        primitiveJNINames.put("byte","B");
        primitiveJNINames.put("char","C");
        primitiveJNINames.put("short","S");
        primitiveJNINames.put("int","I");
        primitiveJNINames.put("long","J");        
        primitiveJNINames.put("float","F");
        primitiveJNINames.put("double","D");        
    }
    
    protected ClassTypeNativePrimitiveWrapperImpl relatedNativePrimitiveWrapper;
    protected ClassTypeNativePrimitiveObjectImpl relatedNativePrimitiveObject;
    
            
    /**
     * Creates a new instance of ClassTypeNativePrimitiveImpl
     */
    public ClassTypeNativePrimitiveImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }

    public static void registerClassTypeNativePrimitive(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeVoidImpl.registerClassTypeNativeVoid(mgr);
        ClassTypeNativeBooleanImpl.registerClassTypeNativeBoolean(mgr);
        ClassTypeNativeCharacterImpl.registerClassTypeNativeCharacter(mgr);
        ClassTypeNativeNumberImpl.registerClassTypeNativeNumber(mgr);
    }
   
    public static boolean isPrimitive(String className)
    {
        // si es primitivo
        String res = (String)primitiveJNINames.get(className);
        return (res != null);
    }

    public static String toJNITypeName(String className)
    {
        return (String)primitiveJNINames.get(className);
    }

    public String getVMClassImplName()
    {
        // No hay distinción entre ambos tipos de clases, sólo hay una
        return getVMClassName();
    }
      
    public abstract String getWrapperClassName();    
    
    public ClassTypeNativePrimitiveWrapperImpl getClassTypeNativePrimitiveWrapper()
    {
        return relatedNativePrimitiveWrapper;
    }
    
    public void setClassTypeNativePrimitiveWrapper(ClassTypeNativePrimitiveWrapperImpl relatedNativePrimitive)
    {
        this.relatedNativePrimitiveWrapper = relatedNativePrimitive;
    }   
    
    public ClassTypeNativePrimitiveObjectImpl getClassTypeNativePrimitiveObject()
    {
        return relatedNativePrimitiveObject;
    }
    
    public void setClassTypeNativePrimitiveObject(ClassTypeNativePrimitiveObjectImpl relatedNativePrimitive)
    {
        this.relatedNativePrimitiveObject = relatedNativePrimitive;
    }    
}
