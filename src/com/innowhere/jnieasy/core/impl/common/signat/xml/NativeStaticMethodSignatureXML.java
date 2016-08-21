/*
 * NativeStaticMethodSignatureXML.java
 *
 * Created on 1 de abril de 2004, 11:29
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticMethodSignatureImpl;

public class NativeStaticMethodSignatureXML extends NativeMethodSignatureXML
{
    
    /**
     * Creates a new instance of NativeStaticMethodSignatureXML
     */
    public NativeStaticMethodSignatureXML()
    {
    }
    
    public static NativeStaticMethodSignatureXML newStaticMethodSignatureXML()
    {
        return new NativeStaticMethodSignatureXML();
    }
   
    public NativeStaticMethodSignatureImpl getStaticMethodSignature()
    {
        return (NativeStaticMethodSignatureImpl)signature;
    }    
    
    public void setStaticMethodSignature(NativeStaticMethodSignatureImpl signature)
    {
        this.signature = signature;
    }

    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeStaticMethodSignatureImpl(jniEasy);
    }
}
