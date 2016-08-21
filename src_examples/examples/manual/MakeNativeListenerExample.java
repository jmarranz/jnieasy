/*
 * MakeNativeListenerExample.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;


import com.innowhere.jnieasy.core.listener.MakeNativeLifecycleEvent;
import com.innowhere.jnieasy.core.listener.MakeNativeLifecycleListener;
import com.innowhere.jnieasy.core.util.NativeCapableUtil;

public class MakeNativeListenerExample implements MakeNativeLifecycleListener
{
    public MakeNativeListenerExample()
    {
    }

    public void preMakeNative(MakeNativeLifecycleEvent event)
    {
        if (event.isAttaching())
            System.out.println("PreMakeNative (attached)");
        else
            System.out.println("PreMakeNative (memory owner)");       
        System.out.println("Must be false: " + NativeCapableUtil.isNative(event.getSource()));                
    }

    public void postMakeNative(MakeNativeLifecycleEvent event)
    {
        System.out.println("PostMakeNative");
        System.out.println("Must be true: " + NativeCapableUtil.isNative(event.getSource()));                
    } 
}
