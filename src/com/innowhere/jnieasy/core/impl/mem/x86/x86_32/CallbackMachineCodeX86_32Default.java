/*
 * CallbackMachineCodeX86_32Default.java
 *
 * Created on 31 de diciembre de 2007, 14:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_32;

import com.innowhere.jnieasy.core.impl.mem.x86.RetNearPop;
import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.MovToReg32Const32;
import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.AddReg32Const32;
import com.innowhere.jnieasy.core.impl.mem.x86.CallReg;
import com.innowhere.jnieasy.core.impl.mem.x86.PopReg;
import com.innowhere.jnieasy.core.impl.mem.x86.PushReg;

/*
	Imagen del código que el compilador MSVC genera al entrar en cualquier función

	00402220 55                   push        ebp
	00402221 8B EC                mov         ebp,esp
	00402223 83 EC 40             sub         esp,40h
	00402226 53                   push        ebx
	00402227 56                   push        esi
	00402228 57                   push        edi
	00402229 8D 7D C0             lea         edi,[ebp-40h]
	0040222C B9 10 00 00 00       mov         ecx,10h
	00402231 B8 CC CC CC CC       mov         eax,0CCCCCCCCh
	00402236 F3 AB                rep stos    dword ptr [edi]
	
	De acuerdo con esto y sabiendo que push primero pone el dato y luego
	resta, el registro ebp tiene la posición de la pila tras el 
	paso de parámetros y el propio backup de ebp, a través de 
	[ebp + 8] se accede al primer parámetro y en direcciones superiores
	están los demás

	Dentro de la función es posible llamar a otras funciones y el ebp no 
	se pierde pues como se vio antes y en el ejemplo de retorno siguiente, 
	el ebp al llamarse a la función se copia en la pila y se restaura al salir
	de la misma.


	Ejemplo de retorno de un entero (f. tipo __cdecl): return 0; 
	para dejar constancia de que el retorno se hace con eax y que se recupera
	el backup de ebp

	00402238 33 C0                xor         eax,eax

	0040223A 5F                   pop         edi
	0040223B 5E                   pop         esi
	0040223C 5B                   pop         ebx
	0040223D 8B E5                mov         esp,ebp
	0040223F 5D                   pop         ebp
	00402240 C3                   ret

 Más información en MSDN (del Visual C++ 6): Argument Passing and Naming Conventions
 y en funciones __declspec(naked) (buscar por naked)
 
 http://msdn2.microsoft.com/en-us/library/aa273416(VS.60).aspx  Sobre __LOCAL_SIZE
 http://msdn2.microsoft.com/en-us/library/y8b57x4b(VS.80).aspx
 http://msdn2.microsoft.com/en-us/library/5f7adz6y(VS.71).aspx  Ejemplo función naked
*/

public class CallbackMachineCodeX86_32Default extends CallbackMachineCodeX86_32
{
    
    /**
     * Creates a new instance of CallbackMachineCodeX86_32Default
     */
    public CallbackMachineCodeX86_32Default()
    {
    }
    
    protected void buildIntructions()
    {
        // Prefijo/prólogo de entrada a la función       
        addInstruction(new PushReg(Register32.EBP));                        // push	ebp
        addInstruction(new MovToReg32Reg32(Register32.EBP,Register32.ESP)); // mov	ebp, esp     
//        addInstruction(new SubConst(Register32.ESP,0x64));                // sub	esp, __LOCAL_SIZE  ; definido por el compilador en caso de funciones naked (__declspec(naked)), un valor de 64h es adecuado
//        addInstruction(new PushReg(Register32.EBX));                      // push	ebx ; Lo salvamos para poder usarlo, parece que está reservado para otras cosas, de hecho el compilador hace siempre backup
        // Fin prefijo/prólogo
        
        // Paso de parámetros:
        addInstruction(new MovToReg32Reg32(Register32.EAX,Register32.EBP));     // mov eax,ebp        
        addInstruction(new AddReg32Const32(Register32.EAX,8));                   // add eax,8
        addInstruction(new PushReg(Register32.EAX));                      // push	eax  ; posición de la pila donde empiezan los parámetros
        
        MovToReg32Const32 movThis = new MovToReg32Const32(Register32.EAX,0);          // mov eax,0x00000000 ; para memorizar el puntero del objeto nativo JavaCallback
        addInstruction(movThis);
        m_movThisInstPos = memorySize32() - movThis.memorySize();
        addInstruction(new PushReg(Register32.EAX));                      // push	eax 

        MovToReg32Const32 movFunc = new MovToReg32Const32(Register32.EAX,0);          // mov eax,JavaCallback::callXXX
        addInstruction(movFunc);
        m_movFuncInstPos = memorySize32() - movFunc.memorySize();
        addInstruction(new CallReg(Register32.EAX));                      // call eax    ; es near ojo    
        // el retorno en eax (hasta int), o en eax:edx si es long
        // o si es double el resultado estará en un stack especial usando fld, 
        // el llamador de la callback ha de ser el que libere este stack con un fstp
        
        // Sufijo/epílogo
//        addInstruction(new PopReg(Register32.EBX));                        // pop     ebx
        addInstruction(new MovToReg32Reg32(Register32.ESP,Register32.EBP));  // mov     esp, ebp
        addInstruction(new PopReg(Register32.EBP));                          // pop     ebp
        RetNearPop ret = new RetNearPop((short)0);                           // ret     stackSizeParams ; si es C_CALL debe ser 0, si es STD_CALL debe ser el tamaño usado en la pila en el paso de parámetros
        addInstruction(ret); 
        m_retInstPos = memorySize32() - ret.memorySize();
        // Fin sufijo               
    }
}
