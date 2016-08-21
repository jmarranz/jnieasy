/*
 * MyCPPClassOnJava.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

import com.innowhere.jnieasy.core.JNIEasy;

public class MyCPPClassOnJava
{
    protected double value;
    
    public MyCPPClassOnJava() // mandatory
    {
    }
    
    public MyCPPClassOnJava(int a,int b)
    {
        this.value = a + b;        
        
        JNIEasy.get().getLockedRegistry().lock(this); // To avoid GC if called from native             
    }

    public static void destroy(MyCPPClassOnJava obj)
    {    
        JNIEasy.get().getLockedRegistry().unlock(obj); // To enable GC again
        JNIEasy.get().getNativeManager().free(obj);
    }  
    
    public static long addStatic(int a,int b)
    {
        return (long)a + (long)b;
    }

    public double sub(int a,int b)
    {           
        this.value = this.value - (a + b);
        return this.value;
    }  
}
