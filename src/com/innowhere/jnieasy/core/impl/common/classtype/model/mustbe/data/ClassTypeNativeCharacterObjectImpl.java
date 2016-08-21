/*
 * CharacterType.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeCharacterImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.TypeNativeImpl;

public class ClassTypeNativeCharacterObjectImpl extends ClassTypeNativePrimitiveObjectImpl
{
    public static final Class CLASS = Character.class;
    
    /** Creates a new instance of CharacterType */
    public ClassTypeNativeCharacterObjectImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(ClassTypeNativeCharacterImpl.getClassTypeNativeCharacter(classTypeMgr),classTypeMgr);
    }
    
    public static void registerClassTypeNativeCharacterObject(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeCharacterObjectImpl classType = new ClassTypeNativeCharacterObjectImpl(mgr);
        classType.registerClassType();       
    }
    
    public static ClassTypeNativeCharacterObjectImpl getClassTypeNativeCharacterObject(ClassTypeManagerImpl mgr)
    {
        return (ClassTypeNativeCharacterObjectImpl)mgr.findClassType(CLASS.getName());   
    }
    
    public String getVMClassName()
    {
        return CLASS.getName();
    }     
    
    public Class getDefaultImplClass()    
    {
        return CLASS;
    }
    
    public Object newValueDefaultClass()
    {
        return new Character('\0');
    }

}
