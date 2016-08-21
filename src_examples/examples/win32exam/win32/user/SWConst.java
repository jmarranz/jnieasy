/*
 * SWConst.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

public interface SWConst
{
    /*
     * ShowWindow() Commands
     */
    public static final int SW_HIDE             = 0;
    public static final int SW_SHOWNORMAL       = 1;
    public static final int SW_NORMAL           = 1;
    public static final int SW_SHOWMINIMIZED    = 2;
    public static final int SW_SHOWMAXIMIZED    = 3;
    public static final int SW_MAXIMIZE         = 3;
    public static final int SW_SHOWNOACTIVATE   = 4;
    public static final int SW_SHOW             = 5;
    public static final int SW_MINIMIZE         = 6;
    public static final int SW_SHOWMINNOACTIVE  = 7;
    public static final int SW_SHOWNA           = 8;
    public static final int SW_RESTORE          = 9;
    public static final int SW_SHOWDEFAULT      = 10;
    public static final int SW_FORCEMINIMIZE    = 11;
    public static final int SW_MAX              = 11;

    /*
     * Identifiers for the WM_SHOWWINDOW message
     */
    public static final int SW_PARENTCLOSING    = 1;
    public static final int SW_OTHERZOOM        = 2;
    public static final int SW_PARENTOPENING    = 3;
    public static final int SW_OTHERUNZOOM      = 4 ;   
   
}
