/*
 * AddTwoNumbersCallbackToOverride.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class AddTwoNumbersCallbackToOverride
{
    public AddTwoNumbersCallbackToOverride()
    {
    }
    
    public long add(int a,int b)    
    {
       throw new RuntimeException("Override this method"); 
    }  
}
