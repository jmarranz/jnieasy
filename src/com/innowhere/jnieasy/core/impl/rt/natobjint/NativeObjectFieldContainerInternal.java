/*
 * NativeObjectFieldContainerInternal.java
 *
 * Created on 29 de septiembre de 2005, 13:22
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjint;

import com.innowhere.jnieasy.core.data.NativeObjectFieldContainer;

/**
 *
 * @author jmarranz
 */
public interface NativeObjectFieldContainerInternal extends NativeObjectFieldContainer,NativeSingleFieldContainerInternal
{
    public boolean jnieasyNeedAuxObjects();           
}
