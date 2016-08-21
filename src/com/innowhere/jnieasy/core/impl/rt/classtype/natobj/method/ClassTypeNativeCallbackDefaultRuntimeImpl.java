/*
 * ClassTypeNativeCallbackDefaultRuntimeImpl.java
 *
 * Created on 21 de septiembre de 2005, 13:07
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.method;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.method.ClassTypeNativeCallbackDefaultImpl;
import com.innowhere.jnieasy.core.impl.mem.TypeSizes;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data.ClassTypeNativeCapableRuntimeImpl;

/**
 *
 * @author jmarranz
 */
public class ClassTypeNativeCallbackDefaultRuntimeImpl extends ClassTypeNativeCapableRuntimeImpl
{
    
    /** Creates a new instance of ClassTypeNativeCallbackDefaultRuntimeImpl */
    public ClassTypeNativeCallbackDefaultRuntimeImpl(ClassTypeNativeCallbackDefaultImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public long getObjectSize()
    {
        throw new JNIEasyException("Unknown size");
    }

    public long getPreferredAlignSize()
    {
        // Es un tipo intrínsecamente puntero, no puede ser atributo "por valor" en una estructura
        return TypeSizes.getADDRESS();        
    }

    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        throw new JNIEasyException("INTERNAL ERROR");    
    }    
}
