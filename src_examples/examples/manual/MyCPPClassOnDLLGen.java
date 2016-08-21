// MyCPPClassOnDLLGen
package examples.manual; 

import java.io.*; 

public class MyCPPClassOnDLLGen extends Object  implements java.io.Serializable,Cloneable  
{ 
    public static com.innowhere.jnieasy.core.JNIEasy jnieasyRoot = com.innowhere.jnieasy.core.JNIEasy.get(); 
    public static com.innowhere.jnieasy.core.mem.DynamicLibrary jnieasyDLL = jnieasyRoot.getDLLManager().get("MyLibrary"); 
    public static com.innowhere.jnieasy.core.method.NativeBehavior[] jnieasyMethodList = new com.innowhere.jnieasy.core.method.NativeBehavior[ 5 ]; 


    protected int virtualTable;
    protected double value;

    /* Empty constructor */
    MyCPPClassOnDLLGen()
    {
    }
                

    public  MyCPPClassOnDLLGen (int a,int b) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[0]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "MSC:?create@MyCPPClassOnDLL@@SGPAV1@HH@Z;gcc:_ZN15MyCPPClassOnDLL6createEii"; 
            jnieasyMethod = jnieasyMethodList[0] = jnieasyDLL.addCPPConstructor(jnieasyFuncName, 
                examples.manual.MyCPPClassOnDLLGen.class, 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        ((com.innowhere.jnieasy.core.method.NativeConstructor)jnieasyMethod).call(this,new java.lang.Object[] {new java.lang.Integer(a),new java.lang.Integer(b)}); 
    } 

    public static void destroy(examples.manual.MyCPPClassOnDLL obj) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[1]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "MSC:?destroy@MyCPPClassOnDLL@@SGXPAV1@@Z;gcc:_ZN15MyCPPClassOnDLL7destroyEPS_"; 
            jnieasyMethod = jnieasyMethodList[1] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(void.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(examples.manual.MyCPPClassOnDLL.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callVoid(new java.lang.Object[] {obj}); 
    } 

    public static long addStatic(int a,int b) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[2]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "MSC:?addStatic@MyCPPClassOnDLL@@SG_JHH@Z;gcc:_ZN15MyCPPClassOnDLL9addStaticEii"; 
            jnieasyMethod = jnieasyMethodList[2] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(long.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callLong(new java.lang.Object[] {new java.lang.Integer(a),new java.lang.Integer(b)}); 
    } 

    public  double sub(int a,int b) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[3]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "MSC:?sub@MyCPPClassOnDLL@@UAGNHH@Z;gcc:_ZN15MyCPPClassOnDLL3subEii"; 
            jnieasyMethod = jnieasyMethodList[3] = jnieasyDLL.addCPPMethod(jnieasyFuncName, 
                examples.manual.MyCPPClassOnDLLGen.class, 
                jnieasyRoot.getTypeManager().dec(double.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeInstanceMethod)jnieasyMethod).callDouble(this,new java.lang.Object[] {new java.lang.Integer(a),new java.lang.Integer(b)}); 
    } 

    public static void varargsEx(byte[] buffer,java.lang.Object[] args) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[4]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "MSC:?varargsEx@MyCPPClassOnDLL@@SAXPADZZ;gcc:_ZN15MyCPPClassOnDLL9varargsExEPcz"; 
            jnieasyMethod = jnieasyMethodList[4] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(void.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().decArray(byte[].class,new int[] {-1},jnieasyRoot.getTypeManager().dec(byte.class).decVarType()).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter(),jnieasyRoot.getTypeManager().decArray(java.lang.Object[].class,new int[] {-1},jnieasyRoot.getTypeManager().dec(java.lang.Object.class).decVarType()).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter(true)}, 
                com.innowhere.jnieasy.core.typedec.CallConv.C_CALL 
                ); 
        } 
        ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callVoid(new java.lang.Object[] {buffer,args}); 
    } 

}