/*
 * AddTwoNumbersCallbackConcrete.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

public class AddTwoNumbersCallbackConcrete extends AddTwoNumbersCallbackToOverride
{
    public AddTwoNumbersCallbackConcrete() 
    {
    }
    
    public long add(int a,int b)
    {    
        return (long)a + (long)b;
    }      
}
