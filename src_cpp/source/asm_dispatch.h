
#ifndef asm_dispatch_h
#define asm_dispatch_h


/* Definidos en ClassTypeNative.java para el tipo de resultado

    public static final int VOID_RETURN        = 1;    
    public static final int BOOLEAN_RETURN     = 2;
    public static final int BYTE_RETURN        = 3;
    public static final int CHAR_RETURN        = 4;
    public static final int SHORT_RETURN       = 5;
    public static final int INT_RETURN         = 6;
    public static final int LONG_RETURN        = 7;
    public static final int FLOAT_RETURN       = 8;
    public static final int DOUBLE_RETURN      = 9;  
    
    public static final int POINTER_RETURN     = 10;

    En el caso de POINTER_RETURN (=10) se decide si el tamaño
	de las direcciones es 4 bytes (INT_RETURN) o 8 bytes (LONG_RETURN)	 
	y se llama al caso específico
	por lo que no se usa en asm_dispatch.
*/


#include <jni.h>

extern "C" void asm_dispatch(  void *func,
                    jint stackParamSize,		  
                    void* args,
                    jint res_type,
                    void* resP,
                    jint conv);

#endif
