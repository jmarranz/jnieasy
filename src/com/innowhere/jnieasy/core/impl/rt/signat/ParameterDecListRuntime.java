/*
 * ParameterDecList.java
 *
 * Created on 15 de enero de 2004, 19:26
 */

package com.innowhere.jnieasy.core.impl.rt.signat;
import com.innowhere.jnieasy.core.impl.mem.*;
import com.innowhere.jnieasy.core.impl.rt.RuntimeContext;
import com.innowhere.jnieasy.core.impl.rt.vartypedec.VarTypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecList;
import com.innowhere.jnieasy.core.impl.common.signat.model.ParameterDecImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CanBeNativeCapableInternal;
import java.util.ArrayList;


public class ParameterDecListRuntime
{
    protected ParameterDecList paramDecList;
    protected ArrayList paramDecListRuntime = new ArrayList();
    protected long stackSize = 0;

    /** Creates a new instance of ParameterDecList */
    public ParameterDecListRuntime(ParameterDecList paramDecList,ArrayList paramListRuntime)
    {
        this.paramDecList = paramDecList;
        this.paramDecListRuntime = paramListRuntime;

        for (int i = 0; i < paramListRuntime.size(); i++)
        {
            ParameterDecRuntimeImpl param = (ParameterDecRuntimeImpl)paramListRuntime.get(i);
            incrementStackSize(param);
        }
    }

    public ParameterDecListRuntime(Class[] classParams,ParameterDecList paramDecList,RuntimeContext ctx)
    {
        this(paramDecList,toParameterDecRuntime(classParams,paramDecList.getParameterDecList(),ctx));
    }

    public ParameterDecListRuntime(ParameterDecList paramDecList)
    {
        this.paramDecList = paramDecList;
    }

    public void addParameterDecRuntime(ParameterDecRuntimeImpl param)
    {
        this.paramDecListRuntime.add(param);
        incrementStackSize(param);
    }

    private void incrementStackSize(ParameterDecRuntimeImpl param)
    {
        if (!param.isVarArgs())
        {
            long stack = param.getVarTypeNativeRuntime().stackSize();
            this.stackSize += stack;
        }
    }

    public static ArrayList toParameterDecRuntime(Class[] classParams,ArrayList params,RuntimeContext ctx)
    {
        ArrayList paramsRt = new ArrayList();
        int size = params.size();
        for(int i = 0; i < size; i++)
        {
            ParameterDecImpl param = (ParameterDecImpl)params.get(i);
            paramsRt.add( new ParameterDecRuntimeImpl(classParams[i],param, ctx) );
        }
        return paramsRt;
    }

    public ParameterDecList getParameterDecList()
    {
        return paramDecList;
    }

    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto

        ParameterDecListRuntime obj2 = (ParameterDecListRuntime)obj;
        if (!paramDecList.equals(obj2.paramDecList))
            return false;

        return true;
    }

    public int length()
    {
        return paramDecListRuntime.size();
    }

    public long stackSize()
    {
        // Caso MacOS X:  http://developer.apple.com/documentation/DeveloperTools/Conceptual/LowLevelABI/Articles/IA32.html#//apple_ref/doc/uid/TP40002492-SW4
        // Caso Win x64:  http://msdn.microsoft.com/en-us/library/aa290049.aspx

        if (TypeSizes.getStackAlign() == 16)  // Mac OS X / Win x64
            return roundToStackSizeByValue(stackSize, 16);
        else
            return stackSize; // Como el alineamiento de cada parámetro es 4 bytes coincide ya con el alineamiento global del stack que es también de 4 bytes
    }

    public long getAlignmentExtraSize()
    {
        return stackSize() - this.stackSize;
    }

    public static long roundToStackSizeByValue(long size,long align)
    {
        long mod = (size % align);
        if (mod != 0)
            size += align - mod;
        return size;
    }

    public ParameterDecRuntimeImpl getParameterDec(int index)
    {
        return (ParameterDecRuntimeImpl)paramDecListRuntime.get(index);
    }

    public Object[] pop(NativeBufferImpl buffer)
    {
        int num = paramDecListRuntime.size();
        Object[] valueList = new Object[num];
        if (num > 0)
        {
            NativeBufferIteratorImpl memIt = (NativeBufferIteratorImpl)buffer.newBufferIterator();
            for (int i = 0; i < num; i++)
            {
                ParameterDecRuntimeImpl paramDec = (ParameterDecRuntimeImpl)paramDecListRuntime.get(i);
                valueList[i] = paramDec.pop(memIt);
            }
        }
        return valueList;
    }

    public void push(Object[] args,Object[] argsUsed,NativeBufferImpl buff)
    {
        // argsUsed sirve para que los objetos realmente usados (pues el push también puede hacer wrapp) no se pierdan por el GC pues pueden ser accedidos durante la llamada por el código nativo, (luego se perderán al salir de la llamada si no coinciden con los de args)
        int num = paramDecListRuntime.size();
        if (num > 0)
        {
            NativeBufferIteratorImpl memIt = (NativeBufferIteratorImpl)buff.newBufferIterator();
            for(int i = 0; i < num; i++)
            {
                ParameterDecRuntimeImpl pdec = (ParameterDecRuntimeImpl)paramDecListRuntime.get(i);
                Object arg = args[i];
                argsUsed[i] = pdec.push(arg,memIt);
            }
            // Como el tamaño extra de alineamiento (Mac OS X) está al final (tras el último) no hay que hacer nada
        }
    }

    public void unwrap(Object[] args,Object[] argsUsed)
    {
        // Puede haber objetos wrapped no solo explícitamente sino también como resultado del push
        // Los objetos argsUsed o son los mismos que args o son Wrapper
        // Los objetos auxiliares se destruiran solos cuando se pierda el array argsUsed
        int num = paramDecListRuntime.size();
        if (num > 0)
        {
            for(int i = 0; i < num; i++)
            {
                ParameterDecRuntimeImpl pdec = (ParameterDecRuntimeImpl)paramDecListRuntime.get(i);
                if (!pdec.isVarArgs())
                {
                    Object arg = args[i];
                    Object argUsed = argsUsed[i];
                    if ((argUsed != null) && (arg != argUsed))
                    {
                        VarTypeNativeRuntimeImpl varType = pdec.getVarTypeNativeRuntime();
                        args[i] = varType.unwrap(argUsed);
                    }
                }
                else
                {
                    VarTypeNativeRuntimeImpl varType = pdec.getVarTypeNativeRuntime();
                    varType.unwrapVarArgs(args[i],argsUsed[i]);
                }
            }
        }
    }

    public VarTypeNativeRuntimeImpl[] getParameterVarTypeList()
    {
        // Devolvemos una copia para que no se pueda modificar el array
        // Los propios objetos VarTypeNativeRuntimeImpl son de sólo lectura (sólo gets)
        int num = paramDecListRuntime.size();
        VarTypeNativeRuntimeImpl[] params = new VarTypeNativeRuntimeImpl[num];
        for(int i = 0; i < num; i++)
        {
            ParameterDecRuntimeImpl pdec = (ParameterDecRuntimeImpl)paramDecListRuntime.get(i);
            params[i] = pdec.getVarTypeNativeRuntime();
        }
        return params;
    }

}
