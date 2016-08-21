/*
 * NativeStaticMethodReflectionProxyTemplateImpl.java
 *
 * Created on 14 de marzo de 2006, 18:22
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl.method;

import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeBehaviorReflectionProxyTemplate;
import com.innowhere.jnieasy.core.method.NativeBehaviorReflection;

/**
 *
 * @author jmarranz
 */
public class NativeStaticMethodReflectionProxyTemplateImpl implements NativeBehaviorReflectionProxyTemplate
{
    protected static NativeBehaviorReflection jnieasyProxy;

    
    /**
     * Creates a new instance of NativeStaticMethodReflectionProxyTemplateImpl
     */
    public NativeStaticMethodReflectionProxyTemplateImpl()
    {
    }
    
    public void jnieasySetProxy(NativeBehaviorReflection newProxy)
    {
        // Es posible que sustiya uno ya definido pero como el nombre de la
        // clase está formado por el address y la signatura del método da igual
        // que se use un proxy u otro mientras sea proxy del mismo método (con la misma signatura)
        jnieasyProxy = newProxy;
    }
}
