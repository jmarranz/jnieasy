/*
 * MyCPPClassOnDLL.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class MyCPPClassOnDLL
{
    protected int virtualTable; // the C++ class has a virtual method
    protected double value;
        
    public MyCPPClassOnDLL() // mandatory (is not native)
    {
    }
    
    public MyCPPClassOnDLL(int a, int b)
    {
        throw new RuntimeException("Not enhanced");        
    }  

    public native static void destroy(MyCPPClassOnDLL obj);
/*    
    {
        throw new RuntimeException("Not enhanced");        
    }    
*/    
    public static native long addStatic(int a,int b);
    
    public double getValue()
    {
        return value;
    }
    
    public native double sub(int a,int b);
/*    
    {    
        throw new RuntimeException("Not enhanced");
    }
*/    
    public native static void varargsEx(byte[] buffer,Object[] args);
/*    
    {
        throw new RuntimeException("Not enhanced");        
    }
*/    
}
