/*
 * WndClassEx.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

/*
typedef struct _WNDCLASSEX { 
    UINT    cbSize;
    UINT    style; 
    WNDPROC lpfnWndProc; 
    int     cbClsExtra; 
    int     cbWndExtra; 
    HANDLE  hInstance; 
    HICON   hIcon; 
    HCURSOR hCursor; 
    HBRUSH  hbrBackground; 
    LPCTSTR lpszMenuName; 
    LPCTSTR lpszClassName; 
    HICON   hIconSm;
} WNDCLASSEX; 
 */

public class WndClassEx
{
    protected int cbSize;                   // UINT    cbSize  
    protected int style;                    // UINT    style
    protected WindowProc lpfnWndProc;       // WNDPROC lpfnWndProc
    protected int cbClsExtra;               // int     cbClsExtra
    protected int cbWndExtra;               // int     cbWndExtra
    protected int hInstance;                // HANDLE  hInstance
    protected int hIcon;                    // HICON   hIcon
    protected int hCursor;                  // HCURSOR hCursor
    protected int hbrBackground;            // HBRUSH  hbrBackground
    protected String lpszMenuName;          // LPCTSTR lpszMenuName
    protected String lpszClassName;         // LPCTSTR lpszClassName
    protected int hIconSm;                  // HICON   hIconSm
    
    public WndClassEx()
    {
    }

    public int getCBSize()
    {
        return cbSize;
    }

    public void setCBSize(int cbSize)
    {
        this.cbSize = cbSize;
    }    
    
    public int getStyle()
    {
        return style;
    }
    
    public void setStyle(int style)
    {
        this.style = style;
    }
    
    public WindowProc getWndProc()
    {
        return lpfnWndProc;
    }

    public void setWndProc(WindowProc wndProc)
    {
        lpfnWndProc = wndProc;
    }    
    
    public int getCBClsExtra()
    {
        return cbClsExtra;
    }
    
    public void setCBClsExtra(int cbClsExtra)
    {
        this.cbClsExtra = cbClsExtra;
    }
    
    public int getCBWndExtra()
    {
        return cbWndExtra;
    }
    
    public void setCBWndExtra(int cbWndExtra)
    {
        this.cbWndExtra = cbWndExtra;
    }    

    public int getHInstance()
    {
        return hInstance;
    }
    
    public void setHInstance(int hInstance)
    {
        this.hInstance = hInstance;
     }    

    public int getHIcon()
    {
        return hIcon;
    }
    
    public void setHIcon(int hIcon)
    {
        this.hIcon = hIcon;
    }

    public int getHCursor()
    {
        return hCursor;
    }
    
    public void setHCursor(int hCursor)
    {
        this.hCursor = hCursor;
    }       
    
    public int getHbrBackground()
    {
        return hbrBackground;
    }
    
    public void setHbrBackground(int hbrBackground)
    {
        this.hbrBackground = hbrBackground;
    }     

    public String getMenuName()
    {
        return lpszMenuName;
    }
    
    public void setMenuName(String name)
    {
        lpszMenuName = name;
    }

    public String getClassName()
    {
        return lpszClassName;
    }
    
    public void setClassName(String name)
    {
        lpszClassName = name;
    }    
        
    public int getHIconSm()
    {
        return hIconSm;
    }
    
    public void setHIconSm(int hIconSm)
    {
        this.hIconSm = hIconSm;
    }
}
