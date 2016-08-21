/*
 * UnFetch.java
 *
 * Created on 7 de febrero de 2006, 19:58
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.mem;

/**
 * The <code>UnFetch</code> interface defines the constants used
 * to define what parts of the native memory layout of a native object
 * tree must be modified.
 *
 * @author jmarranz
 * @see NativeManager#unFetch(Object,int)
 */
public interface UnFetch
{
    /**
     * Constant used to specify that native memory is not modified. 
     * <p>
     *
     * @see Fetch#NONE
     */
    public final int NONE = 0;    
    
    /**
     * Constant used to specify that a fast "unfetch" must be performed.
     * <p>
     * Only field members with primitive types, “can be native” class types 
     * and the address of fields with native capable class types “by pointer”, 
     * are "unfetched". The referenced native object of a field with a native 
     * capable class type declared “by pointer”, is not "unfetched" itself, 
     * only the object’s address with the related pointer in the container’s 
     * native memory is "unfetched".  
     *
     * @see Fetch#FAST
     */    
    public final int FAST = 1;  
    
    /**
     * Constant used to specify that embedded member objects must 
     * be "unfetched" too. 
     * <p>
     * The native objects referenced by fields with native capable class 
     * types declared “by value” (native embedded objects) are "unfetched", 
     * themselves, with the related native memory too.
     *
     * @see Fetch#EMBEDDED
     */     
    public final int EMBEDDED = 2;    
    
    /**
     * Constant used to specify that a deep "unfetch" must be performed. 
     * <p>
     * All members of the native object, including linked native objects, must be "unfetched"
     * recursively.
     *
     * @see Fetch#DEEP
     */           
    public final int DEEP = 3;    
}
