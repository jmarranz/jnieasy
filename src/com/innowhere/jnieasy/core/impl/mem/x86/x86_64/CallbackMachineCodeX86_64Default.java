/*
 * CallbackMachineCodeMSVCX86.java
 *
 * Created on 31 de diciembre de 2007, 14:59
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_64;

import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.*;
import com.innowhere.jnieasy.core.impl.mem.x86.RetNearPop;
import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.MovToReg32Const32;
import com.innowhere.jnieasy.core.impl.mem.x86.x86_32.AddReg32Const32;
import com.innowhere.jnieasy.core.impl.mem.x86.CallReg;
import com.innowhere.jnieasy.core.impl.mem.x86.PopReg;
import com.innowhere.jnieasy.core.impl.mem.x86.PushReg;

/**
 * La pila está alineada en 16 bytes.
 * 
 * http://msdn.microsoft.com/en-us/library/aa290049.aspx     
 * 
 * @author jmarranz
 */

public class CallbackMachineCodeX86_64Default extends CallbackMachineCodeX86_64
{
    
    /** Creates a new instance of CallbackMachineCodeMSVCX86 */
    public CallbackMachineCodeX86_64Default()
    {
    }

    protected void buildIntructions()
    {
        // Prefijo/prólogo de entrada a la función
        addInstruction(new PushReg(Register64.RBP));                         // push rbp
        addInstruction(new MovToReg64Reg64(Register64.RBP,Register64.RSP));  // mov  rbp, rsp     
        // Fin prefijo/prólogo
        
        // Paso de parámetros:
        // El stack debe alinearse en 16 bytes pero como pasamos 8+8=16 bytes 
        // ya está alineado.

        // Posición de la pila donde empiezan los parámetros
        addInstruction(new MovToReg64Reg64(Register64.RAX,Register64.RBP));   // mov rax,rbp        
        addInstruction(new AddReg64Const32(Register64.RAX,8));                // add rax,8
        addInstruction(new PushReg(Register64.RAX));                          // push rax 
        
        // El puntero JavaCallback*
        MovToReg64Const64 movThis = new MovToReg64Const64(Register64.RAX,0);  // mov rax,0x0000000000000000 ; para memorizar el puntero del objeto nativo JavaCallback
        addInstruction(movThis);
        m_movThisInstPos = memorySize32() - movThis.memorySize();
        addInstruction(new PushReg(Register64.RAX));                         // push rax 
        
        
        MovToReg64Const64 movFunc = new MovToReg64Const64(Register64.RAX,0);    // mov rax,JavaCallback::callXXX (son stdcall)
        addInstruction(movFunc);
        m_movFuncInstPos = memorySize32() - movFunc.memorySize();
        addInstruction(new CallReg(Register64.RAX));                      // call rax    ; es near ojo    
        
        // No es necesario restaurar el stack pues las JavaCallback::callXX son stdcall
        // El retorno en eax (hasta int), o en eax:edx si es long
        // o si es double el resultado estará en un stack especial usando fld, 
        // el llamador de la callback ha de ser el que libere este stack con un fstp

        // Sufijo/epílogo
        addInstruction(new MovToReg64Reg64(Register64.RSP,Register64.RBP));  // mov     rsp, rbp
        addInstruction(new PopReg(Register64.RBP));                          // pop     rbp

        RetNearPop ret = new RetNearPop((short)0);                      // ret     stackSizeParams ; si es C_CALL debe ser 0, si es STD_CALL debe ser el tamaño usado en la pila en el paso de parámetros
        addInstruction(ret); 
        m_retInstPos = memorySize32() - ret.memorySize();
        // Fin sufijo               
    }    
}
