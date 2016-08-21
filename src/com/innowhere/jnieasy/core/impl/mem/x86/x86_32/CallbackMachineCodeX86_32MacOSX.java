/*
 * CallbackMachineCodeMSVCX86.java
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
 * Mac OS X con gcc
 * 
 * El código es el muy parecido al de MSVC
 *
 * http://www.milw0rm.com/papers/52
 * http://developer.apple.com/documentation/DeveloperTools/Conceptual/LowLevelABI/Introduction.html
 * http://developer.apple.com/documentation/DeveloperTools/Conceptual/LowLevelABI/Articles/IA32.html#//apple_ref/doc/uid/TP40002492-SW4
*/

public class CallbackMachineCodeX86_32MacOSX extends CallbackMachineCodeX86_32
{
    
    /** Creates a new instance of CallbackMachineCodeMSVCX86 */
    public CallbackMachineCodeX86_32MacOSX()
    {
    }

    protected void buildIntructions()
    {
        // Prefijo/prólogo de entrada a la función
        addInstruction(new PushReg(Register32.EBP));                      // push	ebp
        addInstruction(new MovToReg32Reg32(Register32.EBP,Register32.ESP));     // mov	ebp, esp     
//        addInstruction(new SubConst(Register32.ESP,0x64));                // sub	esp, __LOCAL_SIZE  ; definido por el compilador en caso de funciones naked (__declspec(naked)), un valor de 64h es adecuado
//        addInstruction(new PushReg(Register32.EBX));                      // push	ebx ; Lo salvamos para poder usarlo, parece que está reservado para otras cosas, de hecho el compilador hace siempre backup
        // Fin prefijo/prólogo
        
        // Salvamos el EBP porque el gcc MacOSX con -Ox (x!=0) usa -fomit-frame-pointer que no preserva el EBP, los métodos JavaCallback::callXXX podrían cambiarlo y luego lo necesitamos para restaurar el stack
        // addInstruction(new PushReg(Register32.EBP));                      // push	ebp        
        
        // Paso de parámetros:
        
        // Para el alineamiento del stack a 16 bytes (se van a pasar después 4+4=8 bytes, faltan otros 8)
        addInstruction(new PushReg(Register32.EAX));        
        addInstruction(new PushReg(Register32.EAX));        
        
        // Posición de la pila donde empiezan los parámetros
        addInstruction(new MovToReg32Reg32(Register32.EAX,Register32.EBP));     // mov eax,ebp        
        addInstruction(new AddReg32Const32(Register32.EAX,8));                   // add eax,8
        addInstruction(new PushReg(Register32.EAX));                      // push	eax 
        
        // El puntero JavaCallback*
        MovToReg32Const32 movThis = new MovToReg32Const32(Register32.EAX,0);          // mov eax,0x00000000 ; para memorizar el puntero del objeto nativo JavaCallback
        addInstruction(movThis);
        m_movThisInstPos = memorySize32() - movThis.memorySize();
        addInstruction(new PushReg(Register32.EAX));                      // push	eax 
        
        
        MovToReg32Const32 movFunc = new MovToReg32Const32(Register32.EAX,0);          // mov eax,JavaCallback::callXXX (son stdcall)
        addInstruction(movFunc);
        m_movFuncInstPos = memorySize32() - movFunc.memorySize();
        addInstruction(new CallReg(Register32.EAX));                      // call eax    ; es near ojo    
        
        // No es necesario restaurar el stack pues las JavaCallback::callXX son stdcall
        // El retorno en eax (hasta int), o en eax:edx si es long
        // o si es double el resultado estará en un stack especial usando fld, 
        // el llamador de la callback ha de ser el que libere este stack con un fstp

        // Recuperamos el EBP
        // addInstruction(new PopReg(Register32.EBP));                          // pop     ebp
        
        // Sufijo/epílogo
//        addInstruction(new PopReg(Register32.EBX));                          // pop     ebx
        addInstruction(new MovToReg32Reg32(Register32.ESP,Register32.EBP));     // mov     esp, ebp
        addInstruction(new PopReg(Register32.EBP));                          // pop     ebp

        RetNearPop ret = new RetNearPop((short)0);                      // ret     stackSizeParams ; si es C_CALL debe ser 0, si es STD_CALL debe ser el tamaño usado en la pila en el paso de parámetros
        addInstruction(ret); 
        m_retInstPos = memorySize32() - ret.memorySize();
        // Fin sufijo               
    }    
}
