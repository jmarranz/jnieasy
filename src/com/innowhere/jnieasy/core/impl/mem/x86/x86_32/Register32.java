/*
 * Register32.java
 *
 * Created on 28 de enero de 2004, 20:35
 */

package com.innowhere.jnieasy.core.impl.mem.x86.x86_32;

/**
 *
 * @author  jmarranz
 */
public interface Register32
{
    int NOREG = -1;
    /* La asignaci�n de n�meros no es caprichosa, as� es como calcula el Pentium
     los opcode: sumando este �ndice a un valor base
     Notar que el ebx est� despu�s de eax,ecx,edx 
     */
    int EAX = 0;
    int ECX = 1;
    int EDX = 2;  
    int EBX = 3; 
    int ESP = 4;
    int EBP = 5;
    int ESI = 6;
    int EDI = 7;
}
