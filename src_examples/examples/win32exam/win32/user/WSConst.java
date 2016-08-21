/*
 * WSConst.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

public interface WSConst
{
/*
 * Window Styles
 */
    public static final int  WS_OVERLAPPED       = 0x00000000;
    public static final int  WS_POPUP            = 0x80000000;
    public static final int  WS_CHILD            = 0x40000000;
    public static final int  WS_MINIMIZE         = 0x20000000;
    public static final int  WS_VISIBLE          = 0x10000000;
    public static final int  WS_DISABLED         = 0x08000000;
    public static final int  WS_CLIPSIBLINGS     = 0x04000000;
    public static final int  WS_CLIPCHILDREN     = 0x02000000;
    public static final int  WS_MAXIMIZE         = 0x01000000;
    public static final int  WS_CAPTION          = 0x00C00000;   /* WS_BORDER | WS_DLGFRAME  */
    public static final int  WS_BORDER           = 0x00800000;
    public static final int  WS_DLGFRAME         = 0x00400000;
    public static final int  WS_VSCROLL          = 0x00200000;
    public static final int  WS_HSCROLL          = 0x00100000;
    public static final int  WS_SYSMENU          = 0x00080000;
    public static final int  WS_THICKFRAME       = 0x00040000;
    public static final int  WS_GROUP            = 0x00020000;
    public static final int  WS_TABSTOP          = 0x00010000;

    public static final int  WS_MINIMIZEBOX      = 0x00020000;
    public static final int  WS_MAXIMIZEBOX      = 0x00010000;

    public static final int  WS_TILED            = WS_OVERLAPPED;
    public static final int  WS_ICONIC           = WS_MINIMIZE;
    public static final int  WS_SIZEBOX          = WS_THICKFRAME;
    //public static final int  WS_TILEDWINDOW      = WS_OVERLAPPEDWINDOW;
    
/*
 * Common Window Styles
 */
    public static final int WS_OVERLAPPEDWINDOW = (WS_OVERLAPPED | WS_CAPTION | WS_SYSMENU | WS_THICKFRAME | WS_MINIMIZEBOX | WS_MAXIMIZEBOX);
    public static final int WS_POPUPWINDOW      = (WS_POPUP | WS_BORDER | WS_SYSMENU);
    public static final int WS_CHILDWINDOW      = (WS_CHILD);

/*
 * Extended Window Styles
 */
    public static final int WS_EX_DLGMODALFRAME     = 0x00000001;
    public static final int WS_EX_NOPARENTNOTIFY    = 0x00000004;
    public static final int WS_EX_TOPMOST           = 0x00000008;
    public static final int WS_EX_ACCEPTFILES       = 0x00000010;
    public static final int WS_EX_TRANSPARENT       = 0x00000020;

    public static final int WS_EX_MDICHILD          = 0x00000040;
    public static final int WS_EX_TOOLWINDOW        = 0x00000080;
    public static final int WS_EX_WINDOWEDGE        = 0x00000100;
    public static final int WS_EX_CLIENTEDGE        = 0x00000200;
    public static final int WS_EX_CONTEXTHELP       = 0x00000400;

    public static final int WS_EX_RIGHT             = 0x00001000;
    public static final int WS_EX_LEFT              = 0x00000000;
    public static final int WS_EX_RTLREADING        = 0x00002000;
    public static final int WS_EX_LTRREADING        = 0x00000000;
    public static final int WS_EX_LEFTSCROLLBAR     = 0x00004000;
    public static final int WS_EX_RIGHTSCROLLBAR    = 0x00000000;

    public static final int WS_EX_CONTROLPARENT     = 0x00010000;
    public static final int WS_EX_STATICEDGE        = 0x00020000;
    public static final int WS_EX_APPWINDOW         = 0x00040000;

    public static final int WS_EX_OVERLAPPEDWINDOW  = (WS_EX_WINDOWEDGE | WS_EX_CLIENTEDGE);
    public static final int WS_EX_PALETTEWINDOW     = (WS_EX_WINDOWEDGE | WS_EX_TOOLWINDOW | WS_EX_TOPMOST);

}
