/*
 * WindowProcConcrete.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam;

import com.innowhere.jnieasy.core.JNIEasy;
import examples.win32exam.libc.Libc;
import examples.win32exam.win32.def.*;
import examples.win32exam.win32.user.*;

public class WindowProcConcrete extends WindowProc
{
    public WindowProcConcrete()
    {        
        JNIEasy.get().getTypeManager().defineMacro("WINDOWS");
    } 
    
    public int onCall(int hWnd, int msg, int wParam, int lParam)
    {
        switch (msg)
	{
            case WMConst.WM_CREATE:
                System.out.println("Window created: " + hWnd);
                return 0;	  
            case WMConst.WM_PAINT: 
            {
                PaintStruct ps = new PaintStruct();
                int hDC = User32.BeginPaint(hWnd,ps);

                Rect rect = new Rect();
                User32.GetClientRect(hWnd, rect);
                User32.DrawText(hDC, "Hello World", -1, rect, DTConst.DT_SINGLELINE | DTConst.DT_CENTER | DTConst.DT_VCENTER);

                User32.EndPaint(hWnd, ps);
                return 0;
            }

            case WMConst.WM_CLOSE:
            {
                User32.DestroyWindow(hWnd);
                return 0;
            }
            case WMConst.WM_DESTROY:
            {
                User32.PostQuitMessage(0); // Ends the thread because GetMessage() returns 0
                return 0;
            }
            case WMConst.WM_MOUSEMOVE:
            {
                int xPos = WinDefUtil.getXLParam(lParam); 
                int yPos = WinDefUtil.getYLParam(lParam);
                Libc.printf("(x,y)=(%d,%d)\n",new Object[]{new Integer(xPos),new Integer(yPos)});
                return 0;
            }
	}        
        return User32.DefWindowProc(hWnd, msg, wParam, lParam);
    }
}
