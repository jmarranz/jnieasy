/*
 * Enhancer.java
 *
 * Created on 12 de marzo de 2004, 14:11
 */

package com.innowhere.jnieasy.core.enh;

import com.innowhere.jnieasy.core.*;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * <code>NativeEnhancerCmd</code> enhances specified classes using the command line.
 * 
 * 
 * @author Jose M. Arranz Santamaria
 */

public class NativeEnhancerCmd
{

    /**
     * Enhances specified classes using the command line.
     * <p>
     * Usage: 
     * <blockqoute><pre>
     * java com.innowhere.jnieasy.core.NativeEnhancerCmd <i>urlClassDescXML</i> <i>outputDir</i>
     * </pre></blockquote>
     * 
     * Where <code>urlClassDescXML</code> is the URL formatted location of the XML native
     * descriptor, that lists the classes to be enhanced, and <code>outputDir</code> is
     * the directory base to write enhanced classes. The current implementation calls 
     * the method {@link NativeEnhancer#enhance(java.net.URL,String)}.
     * 
     * 
     * @param args the command line arguments
     * @see NativeEnhancer#enhance(java.net.URL,String)
     */
    public static void main(String[] args)
    {    
        if (args.length < 2)
        {
            String usage = "";
            usage += "Usage: java " + NativeEnhancerCmd.class.getName() + " classDescriptorPath outputDir";
            System.out.println(usage);
            return;
        }

        String filePath = args[0];
        String outputDir = args[1];        
        try
        {
            JNIEasy jnieasy = JNIEasy.get();
            jnieasy.load(); // Se necesita saber el tamaño de los registros de la plataforma
            jnieasy.getEnhancer().enhance(new URL(filePath),outputDir);
        }
        catch(MalformedURLException ex)
        {
            throw new JNIEasyException(ex);
        }
    }

}
