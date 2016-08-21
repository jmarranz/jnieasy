/*
 * CSConst.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

public interface CSConst
{
/*
 * Class styles
 */
    public static final int CS_VREDRAW          = 0x0001;
    public static final int CS_HREDRAW          = 0x0002;
    public static final int CS_DBLCLKS          = 0x0008;
    public static final int CS_OWNDC            = 0x0020;
    public static final int CS_CLASSDC          = 0x0040;
    public static final int CS_PARENTDC         = 0x0080;
    public static final int CS_NOCLOSE          = 0x0200;
    public static final int CS_SAVEBITS         = 0x0800;
    public static final int CS_BYTEALIGNCLIENT  = 0x1000;
    public static final int CS_BYTEALIGNWINDOW  = 0x2000;
    public static final int CS_GLOBALCLASS      = 0x4000;

    public static final int CS_IME          = 0x00010000;
}
