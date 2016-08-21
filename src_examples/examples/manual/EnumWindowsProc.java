/*
 * EnumWindowsProc.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class EnumWindowsProc
{
    public EnumWindowsProc()
    {
    }

    public int onCall(int hwnd,int lParam)
    {
        throw new RuntimeException("Override this method"); 
    }
}
