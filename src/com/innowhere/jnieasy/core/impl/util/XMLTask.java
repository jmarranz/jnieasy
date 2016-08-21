/*
 * XMLTask.java
 *
 * Created on 9 de marzo de 2005, 13:12
 */

package com.innowhere.jnieasy.core.impl.util;

/**
 *
 * @author  jmarranz
 */
import org.w3c.dom.*;
import org.w3c.dom.traversal.*;

public abstract class XMLTask
{
    
    /** Creates a new instance of XMLTask */
    public XMLTask()
    {
    }
    
    public abstract void doTask(Element node,TreeWalker walker,int counter);
}
