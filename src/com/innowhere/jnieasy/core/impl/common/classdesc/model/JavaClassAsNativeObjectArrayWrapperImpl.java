/*
 * JavaClassAsNativeObjectArrayWrapperImpl.java
 *
 * Created on 17 de junio de 2005, 9:15
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.classdesc.model;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.common.classdesc.xml.JavaClassAsNativeCapableXML;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeObjectArrayWrapperImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.mustbe.VarTypeNativeArrayImpl;


/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeObjectArrayWrapperImpl extends JavaClassAsNativeObjectFieldContainerImpl
{
    
    /**
     * Creates a new instance of JavaClassAsNativeObjectArrayWrapperImpl
     */
    public JavaClassAsNativeObjectArrayWrapperImpl(ClassTypeNativeObjectArrayWrapperImpl classType)
    {
        super(classType);
    }
    
}
