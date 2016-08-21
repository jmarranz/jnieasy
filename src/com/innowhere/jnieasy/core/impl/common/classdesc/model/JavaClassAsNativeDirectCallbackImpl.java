/*
 * JavaClassAsNativeDirectCallbackImpl.java
 *
 * Created on 7 de julio de 2005, 12:13
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeDirectCallbackImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeDirectCallbackImpl extends JavaClassAsNativeCapableImpl
{
    protected BehaviorOfClassImpl behaviorOfClass;    
    
    /**
     * Creates a new instance of JavaClassAsNativeDirectCallbackImpl
     */
    public JavaClassAsNativeDirectCallbackImpl(ClassTypeNativeDirectCallbackImpl classType)
    {
        super(classType);
        
        classType.setJavaClassAsNativeDirectCallback(this);
    }

    public BehaviorOfClassImpl getBehaviorOfClass()
    {
        return behaviorOfClass;
    }
    
    public void setBehaviorOfClass(BehaviorOfClassImpl behaviorOfClass)
    {
        this.behaviorOfClass = behaviorOfClass;
    }    
    
    public NativeBehaviorSignatureImpl getBehaviorSignature()
    {
        return behaviorOfClass.getBehaviorSignature();
    }
    
    public FieldOfClassImpl newFieldOfClass(VarTypeNativeImpl varType)
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }
   
    public String getLibraryPathToUpper()    
    {
        // No se usa
        return null;
    }
    
    public JavaClassAsNativeCapableXML newJavaClassAsNativeCapableXML()    
    {
        throw new JNIEasyException("INTERNAL ERROR");
    }    
}
