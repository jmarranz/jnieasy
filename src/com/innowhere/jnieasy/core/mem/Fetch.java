/*
 * Fetch.java
 *
 * Created on 7 de febrero de 2006, 19:29
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.mem;

/**
 * The <code>Fetch</code> interface defines the constants used
 * to define what parts of the native memory layout of a native object
 * tree must be read.
 *
 * @author jmarranz
 * @see NativeManager#fetch(Object,int)
 */
public interface Fetch
{
    /**
     * Constant used to specify that native memory is not read. 
     * <p>
     *
     * @see UnFetch#NONE
     */
    public final int NONE = 0;
    
    /**
     * Constant used to specify that a fast fetch must be performed. 
     * <p>
     * Only field members with primitive types, “can be native” class types 
     * and the address of fields with native capable class types “by pointer”, 
     * are fetched. The referenced native object of a field with a native 
     * capable class type declared “by pointer”, is not fetched itself, 
     * only the object’s address with the related pointer in the container’s 
     * native memory is fetched.    
     *
     * @see UnFetch#FAST
     */
    public final int FAST = 1;   
    
    
    /**
     * Constant used to specify that embedded native member objects must 
     * be fetched too. 
     * <p>
     * The native objects referenced by fields with native capable class 
     * types declared “by value” (native embedded objects) are fetched, 
     * themselves, with the related native memory too.
     *
     * @see UnFetch#EMBEDDED
     */    
    public final int EMBEDDED = 2;   
    
    /**
     * Constant used to specify that a deep fetch must be performed. 
     * <p>
     * All members of the native object, including linked native objects, must be fetched
     * recursively. 
     *
     * @see UnFetch#DEEP
     */        
    public final int DEEP = 3;     
}
