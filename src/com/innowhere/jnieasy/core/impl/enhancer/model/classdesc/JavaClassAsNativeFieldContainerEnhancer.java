/*
 * JavaClassAsNativeFieldContainerEnhancer.java
 *
 * Created on 14 de septiembre de 2005, 12:04
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

import com.innowhere.jnieasy.core.impl.common.classdesc.model.JavaClassAsNativeFieldContainerImpl;
import com.innowhere.jnieasy.core.impl.enhancer.EnhancerSharedContext;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import javassist.CtBehavior;
import javassist.CtField;

/**
 *
 * @author jmarranz
 */
public abstract class JavaClassAsNativeFieldContainerEnhancer extends JavaClassAsNativeCapableEnhancer
{
    
    /**
     * Creates a new instance of JavaClassAsNativeFieldContainerEnhancer
     */
    public JavaClassAsNativeFieldContainerEnhancer(JavaClassAsNativeFieldContainerImpl javaClass,EnhancerSharedContext ctx)
    {
        super(javaClass,ctx);
    }
    
    public LinkedHashMap getEnhanceableFields()
    {
        // El orden de los fields es fundamental para la imagen en memoria de estructuras y clases

        LinkedHashMap toEnhFields = new LinkedHashMap();
        CtField[] decFields = ctClass.getDeclaredFields();
        for(int i=0; i < decFields.length; i++)
        {
            CtField decField = decFields[i];
            if (FieldOfClassEnhancer.canBeEnhanced(decField))
                toEnhFields.put(decField.getName(),decField);
        }
        return toEnhFields;
    }       

    public ArrayList getEnhanceableBehaviors()
    {
        ArrayList behaviorsList = new ArrayList();
        CtBehavior[] decBehaviors = ctClass.getDeclaredBehaviors();
        for(int i=0; i < decBehaviors.length; i++)
        {
            CtBehavior decBehavior = decBehaviors[i];
            if (BehaviorOfClassEnhancer.canBeEnhanced(decBehavior))
                behaviorsList.add(decBehavior);
        }
        return behaviorsList;
    }        
}
