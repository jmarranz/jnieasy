/*
 * ClassTypeNativeArrayImpl.java
 *
 * Created on 16 de noviembre de 2004, 19:20
 */

package com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data;
import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.impl.TaskContext;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeArrayInterface;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativePrimitiveImpl;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeImpl;
import com.innowhere.jnieasy.core.impl.common.MetaClassWrapper;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeNativeArrayInfo;
import com.innowhere.jnieasy.core.impl.common.classtype.model.ClassTypeManagerImpl;
import com.innowhere.jnieasy.core.impl.common.typedec.model.mustbe.data.TypeNativeArrayImpl;
import com.innowhere.jnieasy.core.impl.common.vartypedec.model.VarTypeNativeImpl;


public abstract class ClassTypeNativeArrayImpl extends ClassTypeCanBeNativeCapableImpl implements ClassTypeNativeArrayInterface
{
    protected ClassTypeNativeImpl compType;
    protected ClassTypeNativeArrayInfo arrayInfo = new ClassTypeNativeArrayInfo(this);
    
    /**
     * Creates a new instance of ClassTypeNativeArrayImpl
     */
    public ClassTypeNativeArrayImpl(ClassTypeNativeImpl compType)
    {
        super(compType.getClassTypeManager());
        this.compType = compType;
    }
    
    public static void registerClassTypeNativeArray(ClassTypeManagerImpl mgr)
    {
        ClassTypeNativePrimitiveArrayImpl.registerClassTypeNativePrimitiveArray(mgr);        
        ClassTypeNativeObjectArrayImpl.registerClassTypeNativeObjectArray(mgr);    
    } 
    
    public static ClassTypeNativeArrayImpl newCustomArrayType(MetaClassWrapper valueClass,TaskContext ctx)
    {
        return ClassTypeNativeObjectArrayImpl.newCustomObjectArrayType(valueClass,ctx);
    }
    
    public static String toJNIArrayClassName(String className)
    {
        if (className.charAt(className.length() - 1) == ']')
        {
            // Es formato array (int[] etc) que no entiende el Class.forName()
            className = ClassTypeNativeArrayImpl.convertClassNameToJNI(className);
        }    
        return className;
    }
    
    public static String normalizeJNIClassName(String className)
    {    
        // className se supone que está en formato JNI ([I etc)
        // el devuelto por int[].class.getName() por ejemplo
        // Lo normalizamos para que tenga forma de declaración normal
        String brackets = "";
        int pos = 0; // El primer '[' está asegurado que existe
        do
        {
            brackets += "[]";
            pos++;
        }
        while (className.charAt(pos) == '[');
        // pos está sobre el caracter que indica el tipo
        // si es una clase será 'L', si es un tipo simple
        String compClassName = "";        
        switch(className.charAt(pos))
        {
            case 'L' : // Formato LNombreClase; (el ; hay que excluirlo)
                compClassName = className.substring(pos + 1, className.length() - 1);
                break;
            case 'Z' :
                compClassName = "boolean";
                break;   
            case 'B' :
                compClassName = "byte";
                break;       
            case 'C' :
                compClassName = "char";
                break;                 
            case 'S' :
                compClassName = "short";
                break;                
            case 'I' :
                compClassName = "int";
                break;
            case 'J' :
                compClassName = "long";
                break; 
            case 'F' :
                compClassName = "float";
                break;                 
            case 'D' :
                compClassName = "double";
                break;                
        }
    
        return compClassName + brackets; 
    }    
    
    public static String convertClassNameToJNI(String className)
    {
        // className se supone dado como int[] etc
        // lo convertimos al formato Java: [I etc
        // con este formato ya se puede hacer Class.forName()
        // pues Class.forName() no funciona para 
        // los tipos simples y arrays (int, int[], Object[] etc)
       
        int bracketPos = className.indexOf('[');
        if (bracketPos == 0)
            return className; // Ya está en el formato requerido
        String componentClass = className.substring(0, bracketPos);
	if (ClassTypeNativePrimitiveImpl.isPrimitive(componentClass))
            componentClass = ClassTypeNativePrimitiveImpl.toJNITypeName(componentClass);
        else
            componentClass = "L" + componentClass + ";";
        String convertedName = "[";
        bracketPos += 2; // Pues ya conocemos 1, lo del +2 es porque seguido de [ está el ]
        int len = className.length();
        while(bracketPos < len)
        {
            int pos = className.indexOf('[',bracketPos);
            if (pos != -1)
            {
                bracketPos = pos + 2;
                convertedName += "[";
            }
            else break;
        }
        convertedName = convertedName + componentClass;
        return convertedName;
    }    

    public ClassTypeNativeImpl getComponentType()
    {
        return compType;
    }

    public ClassTypeNativeArrayInfo getArrayInfo()
    {
        return arrayInfo;
    }

    public abstract Object newValueDefaultClass(int length);
    public abstract int getLength(Object value);
    
    public Object newValueDefaultClass()
    {
        throw new JNIEasyException("Cannot make an array instance, unknown dimensions");
    }
    
    public abstract TypeNativeArrayImpl newTypeNativeArray(VarTypeNativeImpl varTypeComp);
}
