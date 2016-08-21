/*
 * NativeTypeNativeManagerImpl.java
 *
 * Created on 5 de julio de 2005, 19:45
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.typedec.model;

import com.innowhere.jnieasy.core.JNIEasyException;
import com.innowhere.jnieasy.core.typedec.StringEncoding;

/**
 *
 * @author jmarranz
 */
public class NativeTypeNativeManagerImpl
{
    protected int defaultStringEncoding = StringEncoding.ANSI;    
    
    /**
     * Creates a new instance of NativeTypeNativeManagerImpl
     */
    public NativeTypeNativeManagerImpl()
    {
    }
  
    public int getDefaultStringEncoding()
    {
        return defaultStringEncoding; 
    }
    
    public void setDefaultStringEncoding(int encoding)
    {
        StringEncodingImpl.checkEncoding(encoding);

        defaultStringEncoding = encoding;
    }    
      
}
