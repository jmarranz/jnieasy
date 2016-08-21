/*
 * MyCPPClassOnDLL.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class MyLegacyClassOnDLL
{
    protected int virtualTable; // the C++ class has a virtual method
    protected double value;
        
    public MyLegacyClassOnDLL() // mandatory (is not native)    
    {
    }
    
    public MyLegacyClassOnDLL(int a, int b)
    {
        throw new RuntimeException("Not enhanced");        
    }  
    
    public static native void destroy(MyLegacyClassOnDLL obj);
    
    public static native long addStatic(int a,int b);
    
    public double getValue()
    {
        return value;
    }
    
    public native double sub(int a,int b);
}
