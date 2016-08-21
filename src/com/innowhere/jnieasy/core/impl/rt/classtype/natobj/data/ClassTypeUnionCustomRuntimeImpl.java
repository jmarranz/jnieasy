/*
 * ClassTypeUnionCustomRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 20:05
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsUnionImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeUnionCustomImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeMultipleFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsUnionRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;


/**
 *
 * @author jmarranz
 */
public class ClassTypeUnionCustomRuntimeImpl extends ClassTypeUnionRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
    /**
     * Creates a new instance of ClassTypeUnionCustomRuntimeImpl 
     */
    public ClassTypeUnionCustomRuntimeImpl(ClassTypeUnionCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeUnionCustomImpl getClassTypeUnionCustom()
    {
        return (ClassTypeUnionCustomImpl)classType;
    }

    public JavaClassAsUnionRuntimeImpl getJavaClassAsUnionRuntime()
    {
        return (JavaClassAsUnionRuntimeImpl)javaClassRt;
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        return new JavaClassAsUnionRuntimeImpl((JavaClassAsUnionImpl)getClassTypeUnionCustom().getJavaClassAsNativeCapable(),this);  
    } 
    
    public long getObjectSize()
    {
        return javaClassRt.size();
    }

    public long getPreferredAlignSize()
    {
        return javaClassRt.alignSize();        
    }

    public static ClassTypeUnionCustomImpl registerUnionCustomType(Class valueClass,RuntimeContext ctx)
    {
        // Por ahora sólo structuras y clases
        
        // Registra la clase pero sin tener información todavía del tamaño en memoria (size)
        // por lo que este es cero.
        // Si antes de definir el tamaño se necesita este tipo, por ejemplo en el enhancement
        // de un atributo con este mismo tipo, no pasa nada, pues dicho atributo ha de 
        // ser por referencia no por variable (tamaño infinito sería), por lo que
        // el tamaño no se necesita.

        return ClassTypeUnionCustomImpl.registerClassTypeUnionCustom(valueClass.getName(), ctx.getJNIEasy());
    }    
}
