/*
 * WindowProc.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

public class WindowProc
{
    public WindowProc()
    {
    }

    /*    
    LRESULT CALLBACK WindowProc(
      HWND hwnd,      // handle to window
      UINT uMsg,      // message identifier
      WPARAM wParam,  // first message parameter
      LPARAM lParam   // second message parameter
    );
    */    

    public int onCall(int hwnd, int uMsg, int wParam, int lParam)
    {
        throw new RuntimeException("Overload this method");
    }
}

