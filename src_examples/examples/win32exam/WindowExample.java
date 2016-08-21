/*
 * WindowExample.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */
package examples.win32exam;

import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.util.NativeCapableUtil;
import examples.win32exam.win32.gdi.*;
import examples.win32exam.win32.user.*;

public class WindowExample
{
    public static final WindowProc wndProc = new WindowProcConcrete();
    public static final String className = "JNIEasy Demo Class";
    
    protected int hWnd;
    
    public WindowExample(int hWnd)
    {
        this.hWnd = hWnd;
    }

    public static int getModuleInstance()
    {
        return (int)JNIEasy.get().getJNIEasyLib().getHandle();
    }
    
    public static short registerWindowClass()
    {     
        int hInst = getModuleInstance();
        
        WndClassEx wndClass = new WndClassEx();
        JNIEasy.get().getNativeManager().makeNative(wndClass);
        wndClass.setCBSize((int)NativeCapableUtil.sizeOf(wndClass));
        wndClass.setStyle( CSConst.CS_HREDRAW | CSConst.CS_VREDRAW );
        wndClass.setWndProc( wndProc );
        wndClass.setCBClsExtra( 0 );
        wndClass.setCBWndExtra ( 0 ); 
        wndClass.setHInstance(hInst);
        wndClass.setHIcon(User32.LoadIcon(0,IDIConst.IDI_APPLICATION));
        wndClass.setHCursor(User32.LoadCursor(0,IDCConst.IDC_ARROW));
        wndClass.setHbrBackground(GDI32.GetStockObject(GDIStockConst.WHITE_BRUSH));
        wndClass.setMenuName(null);  // "MainMenu"
        wndClass.setClassName(className);
        wndClass.setHIconSm(User32.LoadIcon(0,IDIConst.IDI_APPLICATION));
        
        short winClassAtom = User32.RegisterClassEx(wndClass);  
        return winClassAtom;
    }
    
    public static int unregisterWindowClass()
    {    
        int hInst = getModuleInstance();       
        return User32.UnregisterClass(className,hInst);    
    }
    
    public static WindowExample createWindow()
    {
        JNIEasy.get().getTypeManager().defineMacro("UNICODE");
        
        int hInst = getModuleInstance();
        
        int hWnd = User32.CreateWindowEx(0, // extended window style 
                               className,    // window class name
                               "Hello World",        // window caption
                               WSConst.WS_OVERLAPPEDWINDOW,        // window style
                               CWConst.CW_USEDEFAULT,              // initial x position
                               CWConst.CW_USEDEFAULT,              // initial y position
                               CWConst.CW_USEDEFAULT,              // initial x size
                               CWConst.CW_USEDEFAULT,              // initial y size
                               0,                       // parent window handle
                               0,                       // window menu handle
                               hInst,                      // program instance handle
                               0);                     // creation parameters        
        
        return new WindowExample(hWnd);
    }

    public int getHWnd()
    {
        return hWnd;
    }
    
    public void show()
    {
        User32.ShowWindow(hWnd,SWConst.SW_SHOW);
        User32.UpdateWindow(hWnd);        
    }
    
    public static void waitMessages()
    {
        Msg msg = new Msg();
        while (User32.GetMessage(msg,0, 0, 0) != 0)
        {
            User32.TranslateMessage(msg);
            User32.DispatchMessage(msg);
        }    
    }
}
