/*
 * RunExamples.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */
package examples;


import com.innowhere.jnieasy.core.JNIEasy;
import examples.manual.ManualExamples;
import examples.win32exam.RunWin32Examples;

public class RunExamples
{
    public static final boolean isWindows = System.getProperty("os.name").startsWith("Windows");
   
    public static void main(String[] args) throws Exception
    {
        JNIEasy jniEasy = JNIEasy.get();
        //Optional: jniEasy.setFeature("jnieasy.license.dir","a path");
        //Optional: jniEasy.setFeature("java.library.path","pathlist");        
        jniEasy.load();
        
        ManualExamples.runAll();
        if (isWindows)
            RunWin32Examples.createWin32Window();    
    }
}
