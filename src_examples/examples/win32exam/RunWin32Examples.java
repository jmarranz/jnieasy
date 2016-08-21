/*
 * RunWin32Examples.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam;

import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.util.NativeCapableUtil;
import examples.win32exam.win32.user.User32;
import examples.win32exam.win32.user.WndClassEx;

public class RunWin32Examples
{
    public RunWin32Examples()
    {
    }
    
    public static void createWin32Window()
    {      
        short winClassAtom = WindowExample.registerWindowClass();       
      
        testWindowClassRegistration(); // optional
        
        WindowExample window = WindowExample.createWindow();    
        window.show();
        
        WindowExample.waitMessages();

        WindowExample.unregisterWindowClass();
    }    
    
    public static void testWindowClassRegistration()
    {
        WndClassEx wndClass2 = new WndClassEx();
        int hInst = WindowExample.getModuleInstance();        
        int res = User32.GetClassInfoEx(hInst,WindowExample.className,wndClass2);
        System.out.println("Must be true: " + (res != 0));
        System.out.println("Must be true: " + WindowExample.className.equals(wndClass2.getClassName()));
        System.out.println("Must be true: " + (WindowExample.wndProc == wndClass2.getWndProc()));    
        System.out.println("Must be true: " + (NativeCapableUtil.sizeOf(wndClass2) == 48));        
    }
}
