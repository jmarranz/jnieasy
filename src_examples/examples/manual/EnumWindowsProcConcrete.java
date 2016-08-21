/*
 * EnumWindowsProcConcrete.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class EnumWindowsProcConcrete extends EnumWindowsProc
{
    private int windowCount;
    
    public EnumWindowsProcConcrete()
    {
    }
    
    public int onCall(int hwnd, int lParam)
    {
        windowCount++; 
        return 1; // TRUE
    }    
    
    public int getWindowCount()
    {
        return windowCount;
    }
}
