
#if !defined(__APPLE__)
#error ERROR THIS FILE MUST BE COMPILED ON MAC
#endif

#include "asm_dispatch.h"

#include "cross_platform.h"

// La función destino DEBE salvar el registro EBP, es decir no debe
// usarse en gcc -fomit-frame-pointer (o bien usar -fno-omit-frame-pointer)
// No debe compilarse este archivo con -fomit-frame-pointer explícitamente (aunque -Ox x!=0 implica -fomit-frame-pointer no lo usa aquí 
// porque detecta código ensamblador en línea) porque al intentar usar ESP para acceder a los parámetros
// no se entera que se están haciendo push por lo que los cáculos serán erróneos.

// http://developer.apple.com/documentation/DeveloperTools/Conceptual/LowLevelABI/Articles/IA32.html#//apple_ref/doc/uid/TP40002492-SW4

// Links de gran ayuda, para pasar la version MASM a formato GAS (ATT): 
// http://www.ibm.com/developerworks/library/l-gas-nasm.html
// http://www.ibiblio.org/gferg/ldp/GCC-Inline-Assembly-HOWTO.html
// https://www.cs.binghamton.edu/pipermail/cs220/2007-November/000030.html
// http://www.x86-64.org/documentation/assembly.html
// http://lists.apple.com/archives/Xcode-users/2006/Aug/msg00184.html
// http://www.gamedev.net/community/forums/topic.asp?topic_id=287960 (ejemplos de fstp MASM y GAS)
// http://coding.derkeiler.com/Archive/Assembler/alt.lang.asm/2005-04/msg00328.html (sobre fstp en MASM y GAS) 

DLLLOCAL void asm_dispatch(
		  void *func,
		  jint stackParamSize,		  
		  void *args,
		  jint res_type,
		  void *resP,
		  jint conv)
{

// Salvado previo de los registros usados

asm("   pushl %eax");
asm("   pushl %ecx");
asm("   pushl %edx");
asm("   pushl %esi");


// Proceso de la llamada

asm("   movl %0, %%edx" : : "m"(stackParamSize) : );
asm("	cmpl $0, %edx");
asm("	jz  args_done");
asm("	movl %0, %%esi" : : "m"(args) : );
asm("	subl $4, %edx"); // Push the last argument first.
asm("args_loop:");
asm("	movl (%esi,%edx,1), %eax");
asm("	pushl %eax");
asm("	subl $4, %edx");
asm("	cmpl $0, %edx");
asm("	jge args_loop");
asm("args_done:");
        // http://www.experts-exchange.com/Programming/Languages/Assembly/Q_20792947.html
asm("	call *%0": : "m"(func));

        // no tocamos eax pues recoge los resultados enteros de 32 bits o menor
        // ni edx para el caso de devolver entero de 64 bits en eax:edx
        // conv = 0 C CALL, conv = 1 STD CALL
asm("	movl %0, %%ecx" : : "m"(conv) : );
asm("	cmpl $0, %ecx");
asm("	jnz is_stdcall");

        // C call, pop argumentos
asm("	movl %0, %%ecx" : : "m"(stackParamSize) : );
asm("	addl %ecx, %esp");

asm("is_stdcall:");
        // Recogemos el resultado
asm("	movl %0, %%esi": : "m"(resP) : );
asm("	movl %0, %%ecx": : "m"(res_type) : );
asm("	cmpl $1, %ecx");  // void
asm("	je done");
asm("	cmpl $6, %ecx");
asm("	jle is_int32");   // jboolean,jbyte,jchar,jshort,jint
asm("	cmpl $7, %ecx");  // jlong
asm("	je is_long64");
asm("	cmpl $8, %ecx");  // jfloat
asm("	je is_float");
asm("	cmpl $9, %ecx");  // jdouble
asm("	je is_double");

asm("is_int32:");
asm("	movl %eax, (%esi)");
asm("	jmp done");

asm("is_long64:");
asm("	movl %eax, (%esi)");
asm("	movl %edx, 4(%esi)");
asm("	jmp done");

asm("is_float:");
asm("	fstps (%esi)");
asm("	jmp done");

asm("is_double:");
asm("	fstpl (%esi)");
asm("	jmp done");

asm("done:");

// Restauración de los registros usados

asm("   popl %esi");
asm("   popl %edx");
asm("   popl %ecx");
asm("   popl %eax");

}



