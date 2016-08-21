/*
 * WinDefUtil.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.def;

public class WinDefUtil
{
    public WinDefUtil()
    {
    }
    
    public static int hiWord(int l)
    {
        // macro HIWORD
        return (l >> 16) & 0xFFFF; 
    }
         
    public static int loWord(int l)
    {
        // macro LOWORD        
        return l & 0xFFFF; 
    }    

    public static int getXLParam(int lp)
    {
        // macro GET_X_LPARAM
        return loWord(lp);
    }
    
    public static int getYLParam(int lp)
    {
        // macro GET_Y_LPARAM
        return hiWord(lp);
    }    
}
