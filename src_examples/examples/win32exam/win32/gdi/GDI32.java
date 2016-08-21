// GDI32
package examples.win32exam.win32.gdi; 


public class GDI32 
{ 
    public static com.innowhere.jnieasy.core.JNIEasy jnieasyRoot = com.innowhere.jnieasy.core.JNIEasy.get(); 
    public static com.innowhere.jnieasy.core.mem.DynamicLibrary jnieasyDLL = jnieasyRoot.getDLLManager().get("GDI32"); 
    public static com.innowhere.jnieasy.core.method.NativeBehavior[] jnieasyMethodList = new com.innowhere.jnieasy.core.method.NativeBehavior[ 1 ]; 

    public static int GetStockObject(int fnObject) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[0]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "GetStockObject"; 
            jnieasyMethod = jnieasyMethodList[0] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(fnObject)}); 
    } 

}