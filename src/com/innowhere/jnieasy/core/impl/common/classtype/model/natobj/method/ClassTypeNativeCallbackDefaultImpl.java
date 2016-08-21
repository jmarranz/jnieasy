/*
 * ClassTypeNativeCallbackDefaultImpl.java
 *
 * Created on 21 de septiembre de 2005, 12:55
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method.ClassTypeNativeCallbackDefaultRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;


/**
 *  PLANTEARSE SERIAMENTE LA UTILIDAD DE ESTAS CLASES POR DEFECTO
 *  ¿QUIEN VA A DECLARAR UN FIELD O SIMILAR DE TIPO INTERFACE CALLBACK,
 *  PUEDE USAR LOS INTERFACES NativeBehavior QUE SI TIENEN UNA IMPLEMENTACION
 *  POR DEFECTO Y PUEDEN SER USADOS PARA LLAMAR A LOS MÉTODOS DESDE JAVA
 *
 *  DE TODAS FORMAS NO MOLESTAN PORQUE NO ESTAN DOCUMENTADAS (EL QUE
 *  SE PUEDAN USAR ESTAS INTERFASES PARA DECLARAR FIELDS).
 *
 * @author jmarranz
 */
public abstract class ClassTypeNativeCallbackDefaultImpl extends ClassTypeNativeCapableImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeCallbackDefaultImpl 
     */
    public ClassTypeNativeCallbackDefaultImpl(ClassTypeManagerImpl classTypeMgr)
    {
        super(classTypeMgr);
    }
    
    public static void registerClassTypeNativeCallbackDefault(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativeConstructorCallbackDefaultImpl.registerClassTypeNativeConstructorCallbackDefault(mgr);
        ClassTypeNativeMethodCallbackDefaultImpl.registerClassTypeNativeMethodCallbackDefault(mgr);
        ClassTypeNativeFieldCallbackDefaultImpl.registerClassTypeNativeFieldCallbackDefault(mgr);         
    }

    public ClassTypeNativeRuntimeImpl newClassTypeRuntime(RuntimeManagerImpl rtMgr)
    {
        return new ClassTypeNativeCallbackDefaultRuntimeImpl(this,rtMgr);        
    }   
    
    public JavaClassAsNativeCapableImpl newJavaClassAsNativeCapable(ClassTypeNativeCapableImpl classType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
