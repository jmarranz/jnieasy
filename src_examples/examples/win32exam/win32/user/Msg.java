/*
 * Msg.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

import examples.win32exam.win32.def.Point;

/*
typedef struct tagMSG {     // msg 
    HWND   hwnd;     
    UINT   message; 
    WPARAM wParam; 
    LPARAM lParam; 
    DWORD  time; 
    POINT  pt; 
} MSG; 
*/

public class Msg
{
    protected int   hwnd;     
    protected int   message; 
    protected int   wParam; 
    protected int   lParam; 
    protected int   time; 
    protected Point pt = new Point(); // is embedded (by value)
    
    public Msg()
    {
    }

    public int getHwnd()
    {
        return hwnd;
    }

    public void setHwnd(int hwnd)
    {
        this.hwnd = hwnd;
    }

    public int getMessage()
    {
        return message;
    }

    public void setMessage(int message)
    {
        this.message = message;
    }    
    
    public int getWParam()
    {
        return wParam;
    }

    public void setWParam(int wParam)
    {
        this.wParam = wParam;
    }

    public int getLParam()
    {
        return lParam;
    }

    public void setLParam(int lParam)
    {
        this.lParam = lParam;
    }

    public int getTime()
    {
        return time;
    }

    public void setTime(int time)
    {
        this.time = time;
    }
    
    public Point getPoint()
    {
        return pt;
    }

    public void setPoint(Point pt)
    {
        this.pt = pt;
    }    

}
