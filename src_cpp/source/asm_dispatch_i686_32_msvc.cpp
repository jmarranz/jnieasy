
#if !defined(_MSC_VER) | !defined(WIN32)
#error ERROR THIS FILE MUST BE COMPILED WITH MSVC 32 BITS ON WINDOWS 
#endif


// http://msdn2.microsoft.com/en-us/library/y8b57x4b(VS.80).aspx

#include "asm_dispatch.h"

void asm_dispatch(
		  void *func,
		  jint stackParamSize,		  
		  void *args,
		  jint res_type,
		  void *resP,
		  jint conv)
{
    // Registros usados: eax,ecx,edx,esi
    // Los salvamos en la pila y los recuperamos después (el esp no claro)
    // eax y edx pueden guardar resultados pero se ponen en la memoria apuntada por resP

    __asm 
    {
        push eax
        push ecx
        push edx
        push esi
    }

    __asm 
    {
	mov edx, stackParamSize
	cmp edx,0
	jz  args_done
	mov esi, args

	// Push the last argument first.
        sub edx, 4
args_loop:
	mov eax, dword ptr [esi+edx]
	push eax
	sub edx, 4
	cmp edx,0
	jge SHORT args_loop

args_done:
	call func
	// no tocamos eax pues recoge los resultados enteros de 32 bits o menor
	// ni edx para el caso de devolver entero de 64 bits en eax:edx
	mov ecx, conv // conv = 0 C CALL, conv = 1 STD CALL
	cmp ecx, 0
	jnz is_stdcall

	// C call, pop argumentos
	mov ecx, stackParamSize
        add esp, ecx

is_stdcall:
	// Recogemos el resultado
        mov esi, resP
	mov ecx, res_type
	cmp ecx,1  // void
	je done
	cmp ecx,6  
	jle is_int32 // jboolean,jbyte,jchar,jshort,jint
	cmp ecx,7  // jlong
	je is_long64
	cmp ecx,8  // jfloat
	je is_float
	cmp ecx,9  // jdouble
	je is_double

is_int32:
	mov [esi],eax
	jmp done	

is_long64:
	mov [esi],eax
	mov [esi+4],edx
	jmp done

is_float:
	fstp dword ptr [esi]
	jmp done

is_double:
	fstp qword ptr [esi]
	jmp done

done:
    }

// Restauración de los registros usados
    __asm 
    {
        pop esi
        pop edx
        pop ecx
        pop eax
    }
}


