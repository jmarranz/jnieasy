/*
 * PointerToString.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class PointerToString
{   
    protected String ptrToStr;

    public PointerToString() // mandatory
    {
    }
    
    public PointerToString(String pointer)
    {
        this.ptrToStr = pointer;
    }  
    
    public String getString()
    {
        return ptrToStr;
    }

    public void setString(String pointer)
    {
        this.ptrToStr = pointer;
    }   
}
