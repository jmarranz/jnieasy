/*
 * InstanceLifecycleListener.java
 *
 * Created on 22 de septiembre de 2005, 16:59
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.listener;

import java.util.EventListener;

/**
 * All lifecycle listeners extend from this base interface. 
 * In order to minimize the impact on native capable classes, 
 * instance callbacks can be defined to use a life-cycle listener 
 * pattern instead of having the native capable classes implement the 
 * callback interface(s).
 *
 * @author Jose M. Arranz Santamaria
 */
public interface InstanceLifecycleListener extends EventListener
{
    
}
