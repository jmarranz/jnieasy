
// Sintaxis tipo Intel conocida a partir de: http://www.reversing.be/article.php?story=20051203194931893
// Debe compilarse con gcc usando -masm=intel
// Notas y ejemplos: 
// http://sources.redhat.com/ml/binutils/2000-10/msg00268.html
// http://sources.redhat.com/ml/binutils/2000-10/msg00286.html
// http://www.cs.virginia.edu/~jm6dg/lightfield/spatial%20algorithms/alg4/main_f_2.c
// http://www-128.ibm.com/developerworks/library/l-ia.html

#if !defined(linux)
#error ERROR THIS FILE MUST BE COMPILED ON LINUX
#endif


#include "asm_dispatch.h"

#include "cross_platform.h"

DLLLOCAL void asm_dispatch(
		  void *func,
		  jint stackParamSize,		  
		  void *args,
		  jint res_type,
		  void *resP,
		  jint conv)
{



asm("	.intel_syntax noprefix");

// Salvado previo de los registros usados
asm("   push eax");
asm("   push ecx");
asm("   push edx");
asm("   push esi");



asm("   mov edx, %0": : "m"(stackParamSize) : "%edx");
asm("	cmp edx, 0");
asm("	jz  args_done");
asm("	mov esi, %0": : "m"(args) : "%esi");
	// Push the last argument first. 
asm("	sub edx, 4");
asm("args_loop:");
asm("	mov eax, dword ptr [esi+edx]");
asm("	push eax");
asm("	sub edx, 4");
asm("	cmp edx,0");
asm("	jge SHORT args_loop");

asm("args_done:");

asm("	call %0": : "m"(func));

	// no tocamos eax pues recoge los resultados enteros de 32 bits o menor
	// ni edx para el caso de devolver entero de 64 bits en eax:edx
	// conv = 0 C CALL, conv = 1 STD CALL
asm("	mov ecx, %0": : "m"(conv) : "%ecx");
asm("	cmp ecx, 0");
asm("	jnz is_stdcall");

	// C call, pop argumentos
asm("	mov ecx, %0": : "m"(stackParamSize) : "%ecx");
asm("	add esp, ecx");

asm("is_stdcall:");
	// Recogemos el resultado
asm("	mov esi,%0": : "m"(resP) : "%esi");
asm("	mov ecx,%0": : "m"(res_type) : "%ecx");
asm("	cmp ecx,1");  // void
asm("	je done");
asm("	cmp ecx,6"); 
asm("	jle is_int32"); // jboolean,jbyte,jchar,jshort,jint
asm("	cmp ecx,7");  // jlong
asm("	je is_long64");
asm("	cmp ecx,8");  // jfloat
asm("	je is_float");
asm("	cmp ecx,9");  // jdouble
asm("	je is_double");

asm("is_int32:");
asm("	mov [esi],eax");
asm("	jmp done");	

asm("is_long64:");
asm("	mov [esi],eax");
asm("	mov [esi+4],edx");
asm("	jmp done");

asm("is_float:");
asm("	fstp dword ptr [esi]");
asm("	jmp done");

asm("is_double:");
asm("	fstp qword ptr [esi]");
asm("	jmp done");

asm("done:");


// Restauración de los registros usados
asm("   pop esi");
asm("   pop edx");
asm("   pop ecx");
asm("   pop eax");

asm(".att_syntax"); // Restaura el modo normal por defecto

}


