/*
 * Util.java
 *
 * Created on 29 de marzo de 2004, 13:54
 */

package com.innowhere.jnieasy.core.impl.util;

/**
 *
 * @author  jmarranz
 */
import java.io.*;
import java.net.*;

import com.innowhere.jnieasy.core.JNIEasyException;


public class Util
{
    
    /** Creates a new instance of Util */
    public Util()
    {
    }
    
    public static URL changeExtension(URL url,String newExt)
    {
        try
        {
            String protocol = url.getProtocol();
            String host = url.getHost();
            int port = url.getPort();
            String file = url.getFile();
            int pos = file.lastIndexOf('.');
            String newFile = file.substring(0, pos) + "." + newExt;
            return new URL(protocol,host,port,newFile);
        }
        catch(MalformedURLException ex)
        {
            throw new JNIEasyException(ex);
        }
    }
    
    public static String capitalizeFirst(String name)
    {
        char first = name.charAt(0);
        first = Character.toUpperCase(first);
        StringBuffer newName = new StringBuffer(name);
        newName.setCharAt(0, first);
        return newName.toString();
    }   
    
    public static String formAbsoluteFilePath(String baseDirPath,String relFilePath)
    {
        try
        {
            String absPath;
            if (relFilePath == null) 
                absPath = baseDirPath;
            else
            {
            	File relFile = new File(relFilePath);
	        if (relFile.isAbsolute()) 
                    return relFile.getCanonicalPath();
                absPath = baseDirPath + "/" + relFilePath;
            }

            return new File(absPath).getCanonicalPath();
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }
    }    
    
    public static URL formAbsoluteURLPath(URL baseURL,String relFilePath)
    {
        try
        {
            // Suponemos que baseURL apunta a un archivo, quitamos el archivo
            String baseDirPath = baseURL.getPath();
            baseDirPath = new File(baseDirPath).getParent();
            String absPath;
            if (relFilePath == null) 
                absPath = baseDirPath;
            else
            {
            	URI relFile = new URI(relFilePath);
	        if (relFile.isAbsolute()) 
                    return relFile.toURL();
                absPath = baseDirPath + "/" + relFilePath;
            }

            return new URL(baseURL.getProtocol(),baseURL.getHost(),baseURL.getPort(),absPath);
        }
        catch(URISyntaxException ex)
        {
            throw new JNIEasyException(ex);
        }   
        catch(MalformedURLException ex)
        {
            throw new JNIEasyException(ex);
        }        
    }       
    
    public static String getClassNamePart(String absClassName)
    {
        int pos = absClassName.lastIndexOf('.');
        if (pos == -1) return absClassName; // No tiene package
        return absClassName.substring(pos + 1,absClassName.length());        
    }

    public static String getPackagePart(String absClassName)
    {    
        int pos = absClassName.lastIndexOf('.');
        if (pos == -1) return null; // No tiene package
        return absClassName.substring(0,pos); // Sin el punto
    }
        
    public static byte[] load(InputStream input)
    {
        // Está pensada para cargar clases (.class)
        // por eso se toma un buffer de 50Kb
        byte[] buffer = new byte[50*1024];

        ByteArrayOutputStream content = new ByteArrayOutputStream();
        try
        {
            int count = input.read(buffer);
            while(count != -1)
            {
                content.write(buffer,0, count);
                count = input.read(buffer);                
            }
        }
        catch(IOException ex)
        {
            throw new JNIEasyException(ex);
        }
        return content.toByteArray();
    }
}
