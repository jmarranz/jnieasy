/*
 * NativeStaticFieldMethodSignatureXML.java
 *
 * Created on 18 de julio de 2005, 15:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.common.signat.xml;
import com.innowhere.jnieasy.core.impl.JNIEasyImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeBehaviorSignatureImpl;
import com.innowhere.jnieasy.core.impl.common.signat.model.NativeStaticFieldMethodSignatureImpl;


/**
 *
 * @author jmarranz
 */
public class NativeStaticFieldMethodSignatureXML extends NativeFieldMethodSignatureXML
{
    
    /**
     * Creates a new instance of NativeStaticFieldMethodSignatureXML
     */
    public NativeStaticFieldMethodSignatureXML()
    {
    }
    
    public static NativeStaticFieldMethodSignatureXML newStaticFieldMethodSignatureXML()
    {
        return new NativeStaticFieldMethodSignatureXML();
    }
    
    public NativeStaticFieldMethodSignatureImpl getStaticFieldMethodSignature()
    {
        return (NativeStaticFieldMethodSignatureImpl)signature;
    } 

    public NativeBehaviorSignatureImpl newBehaviorSignature(JNIEasyImpl jniEasy)
    {
        return new NativeStaticFieldMethodSignatureImpl(jniEasy);
    }    
}
