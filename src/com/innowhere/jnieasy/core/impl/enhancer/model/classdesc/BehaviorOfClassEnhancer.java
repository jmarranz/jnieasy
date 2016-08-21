/*
 * BehaviorReflectionDec.java
 *
 * Created on 28 de febrero de 2005, 20:35
 */

package com.innowhere.jnieasy.core.impl.enhancer.model.classdesc;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.JNIEasyException;
import javassist.*;
import com.innowhere.jnieasy.core.impl.enhancer.*;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.classdesc.model.BehaviorOfClassImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.natobj.data.ClassTypeNativeCapableImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.enhancer.render.classdesc.BehaviorOfClassEnhancerRender;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.enhancer.model.signat.NativeBehaviorSignatureEnhancerImpl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class BehaviorOfClassEnhancer extends MemberOfClassEnhancer
{
    protected static final Set notEnhanceMethods = Collections.synchronizedSet(new HashSet());
    
    static
    {
        // Métodos de callbacks que no debemos enhancear (modificar de ninguna manera)
        // puesto que el acceso a los atributos nativos supondría un fetch o unfetch lo cual
        // no tiene sentido dentro de dichos métodos o es inútil porque no es nativo
        notEnhanceMethods.add("jnieasyPostFetch");
        notEnhanceMethods.add("jnieasyPreUnFetch");
        notEnhanceMethods.add("jnieasyPreMakeNative");
        notEnhanceMethods.add("jnieasyPreAttach");
        notEnhanceMethods.add("jnieasyPostDetach");
    }
    
    protected JavaClassAsNativeDirectCallbackEnhancer callbackClassDesc;
    protected NativeBehaviorSignatureEnhancerImpl signatureEnh;
    protected boolean useReflection = false;
    protected boolean onLibrary = false;
    protected boolean exportMethod = false;
    protected int index;
    
    /** Creates a new instance of BehaviorReflectionDec */
    public BehaviorOfClassEnhancer(CtMember ctBehavior,BehaviorOfClassImpl behaviorOfClass,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        super(ctBehavior,behaviorOfClass, classEnhancer);
        
        EnhancerSharedContext ctx = classEnhancer.getEnhancerSharedContext();        
        NativeBehaviorSignatureImpl sig = behaviorOfClass.getBehaviorSignature();
        this.signatureEnh = NativeBehaviorSignatureEnhancerImpl.newBehaviorSignatureEnhancer(sig, ctx.getEnhancer());
    }  
      
    public static BehaviorOfClassEnhancer newBehaviorOfClassEnhancer(CtMember ctBehavior,BehaviorOfClassImpl accessObject,JavaClassAsNativeCapableEnhancer classEnhancer)
    {
        return accessObject.newBehaviorOfClassEnhancer(ctBehavior,classEnhancer);
    }
    
    public static BehaviorOfClassEnhancer newDefaultBehaviorOfClassEnhancer(CtMember ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
    	if (ctBehavior instanceof CtConstructor)
            return ConstructorOfClassEnhancer.newDefaultConstructorOfClassEnhancer((CtConstructor)ctBehavior,(JavaClassAsNativeMultipleFieldContainerEnhancer)classEnhancer,ctx);
        else if (ctBehavior instanceof CtMethod)
            return MethodOfClassEnhancer.newDefaultMethodOfClassEnhancer((CtMethod)ctBehavior,classEnhancer,ctx); 
        else if (ctBehavior instanceof CtField)
            return FieldMethodOfClassEnhancer.newDefaultFieldMethodOfClassEnhancer((CtField)ctBehavior,classEnhancer,ctx);         
        return null;
    }

    public static BehaviorOfClassEnhancer newDefaultBehaviorOfClassEnhancer(NativeBehaviorSignatureImpl sig,CtMember ctBehavior,JavaClassAsNativeCapableEnhancer classEnhancer,EnhancerSourceFileContext ctx)
    {
        ClassTypeNativeCapableImpl thisClassType = classEnhancer.getClassTypeNativeCapable();
        BehaviorOfClassImpl behaviorOfClass = BehaviorOfClassImpl.newBehaviorOfClass(sig, thisClassType);
        return BehaviorOfClassEnhancer.newBehaviorOfClassEnhancer(ctBehavior,behaviorOfClass,classEnhancer);
    }    

    public int getIndex()
    {
        return index;
    }

    public void setIndex(int index)
    {
        this.index = index;
    }    
    
    public NativeBehaviorSignatureEnhancerImpl getBehaviorSignatureEnhancer()
    {
        return signatureEnh;
    }
    
    public JavaClassAsNativeDirectCallbackEnhancer getJavaClassAsNativeDirectCallbackEnhancer()
    {
        if (callbackClassDesc == null)
        {
            EnhancerSharedContext ctx = classEnhancer.getEnhancerSharedContext();
            this.callbackClassDesc = signatureEnh.getJavaClassAsNativeDirectCallbackEnhancer(ctMember,ctx);       
        }
        return callbackClassDesc;
    }
           
    public boolean isExportMethod()
    {
        return exportMethod;
    }
    
    public void setExportMethod(boolean export)
    {
        this.exportMethod = export;
    }

    public boolean isUseReflection()
    {
        return useReflection;
    }

    public void setUseReflection(boolean useReflection)
    {
        this.useReflection = useReflection;
    }
    
    public boolean isOnLibrary()
    {
        return onLibrary;
    }
    
    public void setOnLibrary(boolean onLibrary)
    {
        if (onLibrary)
        {
            String libraryPath = classEnhancer.getJavaClassAsNativeCapable().getLibraryPathToUpper();
            if (libraryPath == null)
                throw new JNIEasyException("Dynamic Library not specified or method cannot be linked to a DLL in this context");      
        }
        this.onLibrary = onLibrary;
    }    
    
    public BehaviorOfClassImpl getBehaviorOfClass()
    {
        return (BehaviorOfClassImpl)memberOfClass;
    }
    
    public static CtClass[] convertParams(List params,EnhancerSourceFileContext ctx)
    {
        int paramCount = params.size();
	CtClass[] ctClassParams = new CtClass[paramCount];
        for(int i=0; i < paramCount; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)params.get(i);
            String className = param.getVarTypeNative().getTypeNative().getClassName();
            ctClassParams[i] = ctx.getCtClassNotUsingImports(className);
        }      
        return ctClassParams;
    }

    public static boolean canBeEnhanced(CtBehavior behavior)
    {
        String name = behavior.getName();
        // El compilador (1.4 al menos) genera un método especial con la signatura
        // static Class class$(String className)
        // que es llamado en sustitución de las expresiones NombreClase.class   
        // obviamente no es enhanceable y no podemos evitar su existencia si usamos expresiones como la anterior 
        if (name.equals("class$"))
            return false;
           
        if (notEnhanceMethods.contains(name))
            return false;  
        
        if (behavior instanceof CtConstructor)
        {
            // El constructor estático de la clase no tiene sentido "enhancearlo"
            if (((CtConstructor)behavior).isClassInitializer())
                return false;
        }
        return true;
    }  
    
    public static ArrayList toParameterDec(CtClass[] ctClassParams,EnhancerSourceFileContext ctx)
    {
        ArrayList params = new ArrayList();
        for(int i = 0; i < ctClassParams.length; i++ )
        {
            ClassTypeNativeImpl paramType = ctx.getClassType(ctClassParams[i]);
            
            VarTypeNativeImpl varType = VarTypeNativeImpl.newVarTypeNative(paramType);
            params.add( new ParameterDecImpl(varType) );
        }    
        return params;
    }
   
    public abstract JavaClassAsNativeDirectCallbackEnhancer newJavaClassAsNativeDirectCallbackEnhancer(CtClass ctClass, EnhancerSharedContext ctx); 
    public abstract BehaviorOfClassEnhancerRender newBehaviorOfClassEnhancerRender();


}
