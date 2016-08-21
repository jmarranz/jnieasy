/*
 * Rect.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.def;

import examples.win32exam.win32.def.Point;


/*
typedef struct _RECT { 
    LONG left; 
    LONG top; 
    LONG right; 
    LONG bottom; 
} RECT; 
*/

public class Rect
{
    private int left; 
    private int top; 
    private int right; 
    private int bottom;
    
    public Rect(int left,int top,int right,int bottom)
    {
        setLeft(left);
        setTop(top); 
        setRight(right); 
        setBottom(bottom);
    }
    
    public Rect(Rect rarg)
    {
        this(rarg.getLeft(),rarg.getTop(),rarg.getRight(),rarg.getBottom());
    }
    
    public Rect()
    {
        this(0,0,0,0);
    }
    
    public Point centerPoint()
    {
        return new Point((left + right) / 2, (top + bottom) / 2);
    }
    
    public int getLeft()
    {
        return left;
    }

    public void setLeft(int left)
    {
        this.left = left; 
    }    
    
    public int getTop()
    {
        return top; 
    }

    public void setTop(int top)
    {
        this.top = top; 
    }

    public int getRight()
    {
        return right; 
    }    

    public void setRight(int right)
    {
        this.right = right; 
    } 
    
    public int getBottom()
    {
        return bottom; 
    }    

    public void setBottom(int bottom)
    {
        this.bottom = bottom; 
    } 
}
