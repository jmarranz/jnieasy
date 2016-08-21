/*
 * Point.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.def;

/*
    typedef struct tagPOINT {
       LONG x;
       LONG y;
    } POINT;
*/

public class Point
{
    private int x;
    private int y;
    
    public Point()
    {
        this(0,0);
    }

    public Point(int x,int y)
    {
        setX(x);
        setY(y);        
    }

    public Point(Point p)
    {
        this(p.getX(),p.getY());
    }
   
    public int getX()
    {
        return x;
    }

    public void setX(int x)
    {
        this.x = x;
    }
        
    public int getY()
    {
        return y;
    }    

    public void setY(int y)
    {
        this.y = y;
    }    
}
