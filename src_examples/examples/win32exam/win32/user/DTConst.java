/*
 * DTConst.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

public interface DTConst
{
/*
 * DrawText() Format Flags
 */
    public static final int  DT_TOP                      = 0x00000000;
    public static final int  DT_LEFT                     = 0x00000000;
    public static final int  DT_CENTER                   = 0x00000001;
    public static final int  DT_RIGHT                    = 0x00000002;
    public static final int  DT_VCENTER                  = 0x00000004;
    public static final int  DT_BOTTOM                   = 0x00000008;
    public static final int  DT_WORDBREAK                = 0x00000010;
    public static final int  DT_SINGLELINE               = 0x00000020;
    public static final int  DT_EXPANDTABS               = 0x00000040;
    public static final int  DT_TABSTOP                  = 0x00000080;
    public static final int  DT_NOCLIP                   = 0x00000100;
    public static final int  DT_EXTERNALLEADING          = 0x00000200;
    public static final int  DT_CALCRECT                 = 0x00000400;
    public static final int  DT_NOPREFIX                 = 0x00000800;
    public static final int  DT_INTERNAL                 = 0x00001000;

    public static final int  DT_EDITCONTROL              = 0x00002000;
    public static final int  DT_PATH_ELLIPSIS            = 0x00004000;
    public static final int  DT_END_ELLIPSIS             = 0x00008000;
    public static final int  DT_MODIFYSTRING             = 0x00010000;
    public static final int  DT_RTLREADING               = 0x00020000;
    public static final int  DT_WORD_ELLIPSIS            = 0x00040000;

    public static final int  DT_NOFULLWIDTHCHARBREAK     = 0x00080000;

    public static final int  DT_HIDEPREFIX               = 0x00100000;
    public static final int  DT_PREFIXONLY               = 0x00200000;
}
