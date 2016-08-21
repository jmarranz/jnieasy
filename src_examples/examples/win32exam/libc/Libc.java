// Libc
package examples.win32exam.libc; 


public class Libc 
{ 
    public static com.innowhere.jnieasy.core.JNIEasy jnieasyRoot = com.innowhere.jnieasy.core.JNIEasy.get(); 
    public static com.innowhere.jnieasy.core.mem.DynamicLibrary jnieasyDLL = jnieasyRoot.getDLLManager().get("WINDOWS:MSVCRT;Linux:/lib/libc.so.6;MacOSX:/usr/lib/libc.dylib;SunOS:/lib/libc.so.1"); 
    public static com.innowhere.jnieasy.core.method.NativeBehavior[] jnieasyMethodList = new com.innowhere.jnieasy.core.method.NativeBehavior[ 1 ]; 

    public static int printf(java.lang.String pattern,java.lang.Object[] args) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[0]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "printf"; 
            jnieasyMethod = jnieasyMethodList[0] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(java.lang.String.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().decArray(java.lang.Object[].class,new int[] {-1},jnieasyRoot.getTypeManager().dec(java.lang.Object.class).decVarType()).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter(true)}, 
                com.innowhere.jnieasy.core.typedec.CallConv.C_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {pattern,args}); 
    } 

}