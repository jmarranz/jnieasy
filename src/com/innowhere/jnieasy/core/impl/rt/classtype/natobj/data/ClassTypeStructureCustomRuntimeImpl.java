/*
 * ClassTypeStructureCustomRuntimeImpl.java
 *
 * Created on 17 de junio de 2005, 20:12
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.natobj.data;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsStructureImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeStructureCustomImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsStructureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classdesc.JavaClassAsNativeCapableRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.natobj.ClassTypeCustomEnhancedRuntime;


/**
 *
 * @author jmarranz
 */
public class ClassTypeStructureCustomRuntimeImpl extends ClassTypeStructureRuntimeImpl implements ClassTypeCustomEnhancedRuntime
{
   
    /**
     * Creates a new instance of ClassTypeStructureCustomRuntimeImpl 
     */
    public ClassTypeStructureCustomRuntimeImpl(ClassTypeStructureCustomImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
    
    public ClassTypeStructureCustomImpl getClassTypeStructureCustom()
    {
        return (ClassTypeStructureCustomImpl)classType;
    }
    
    public JavaClassAsStructureRuntimeImpl getJavaClassAsStructureRuntime()
    {
        return (JavaClassAsStructureRuntimeImpl)javaClassRt;
    }
    
    public JavaClassAsNativeCapableRuntimeImpl newJavaClassAsNativeCapableRuntime()
    {
        return new JavaClassAsStructureRuntimeImpl((JavaClassAsStructureImpl)getClassTypeStructureCustom().getJavaClassAsNativeCapable(),this);
    }
    
    public long getObjectSize()
    {
        return javaClassRt.size();
    }

    public long getPreferredAlignSize()
    {
        return javaClassRt.alignSize();        
    }        

    public static ClassTypeStructureCustomImpl registerStructureCustomType(Class valueClass,RuntimeContext ctx)
    {
        // Por ahora sólo structuras y clases
        
        // Registra la clase pero sin tener información todavía del tamaño en memoria (size)
        // por lo que este es cero.
        // Si antes de definir el tamaño se necesita este tipo, por ejemplo en el enhancement
        // de un atributo con este mismo tipo, no pasa nada, pues dicho atributo ha de 
        // ser por referencia no por variable (tamaño infinito sería), por lo que
        // el tamaño no se necesita.

        return ClassTypeStructureCustomImpl.registerClassTypeStructureCustom(valueClass.getName(), ctx.getJNIEasy());
    }    
}
