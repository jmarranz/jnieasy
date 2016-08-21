/*
 * DynamicLibrary.java
 *
 * Created on 26 de febrero de 2004, 13:14
 */

package com.innowhere.jnieasy.core.mem;
import com.innowhere.jnieasy.core.data.NativeSingleFieldContainer;
import com.innowhere.jnieasy.core.method.*;
import java.util.*;
import com.innowhere.jnieasy.core.typedec.*;

/**
 * The <code>DynamicLibrary</code> interface represents 
 * a loaded Dynamic Link Library (DLL) by the framework.
 * <p>
 * Using this interface, DLL's exported native methods and fields are 
 * accessible to the Java world using internal framework classes
 * and public using specific interfaces. 
 *
 * @author Jose M. Arranz Santamaria
 * @see DLLManager
 */
public interface DynamicLibrary
{
    /**
     * Returns the DLL/shared object manager instance.
     *
     * @return the DLLManager object.  
     */
    public DLLManager getDLLManager();
    
    /**
     * Unloads and un-registers this DLL.
     * <p>
     * After calling this method the instance is disposed out of
     * the framework and can not be reused.
     * <p>
     * The dynamic library itself remains on memory.
     *
     * @see DLLManager#get(String)
     */
    public void free();
    
    /**
     * Returns the current default call convention of native methods
     * when declaring native signatures and methods wrapping exported methods and
     * fields of this DLL.
     * <p>
     * By default, the call convention is the general default convention
     * as the return of {@link NativeSignatureManager#getDefaultCallConv()}
     * when loading this DLL.
     * 
     * @return the default call convention of this DLL.
     */
    public int getDefaultCallConv();
    
    /** 
     * Sets the default calling convention of native methods 
     * when declaring native signatures and methods wrapping exported methods and
     * fields of this DLL.
     * <p>
     * 
     * @param callConv the new default calling conventionalism of native methods.
     * @see #getDefaultCallConv()
     */
    public void setDefaultCallConv(int callConv);
    
    /**
     * Returns the platform handle of this DLL.
     *
     * @return the DLL's handle.
     * @see #getName()
     */
    public long getHandle();
    
    /**
     * Returns the name/path used to load this DLL.
     * 
     * @return the DLL's name of path. 
     * @see #getHandle()
     * @see DLLManager#get(String)
     */
    public String getName();
    
    /**
     * Returns the utility object to declare native types.
     * 
     * @return the <code>NativeTypeManager</code> object.
     * @see com.innowhere.jnieasy.core.JNIEasy#getTypeManager()
     */
    public NativeTypeManager getTypeManager();    
    
    
    /**
     * Returns the utility object to declare native signatures of methods.
     * 
     * @return the <code>NativeSignatureManager</code> object.
     * @see com.innowhere.jnieasy.core.JNIEasy#getSignatureManager()
     */     
    public NativeSignatureManager getSignatureManager();
    
    /**
     * Returns the address of the exported method or field 
     * with the specified name.
     * <p>
     * The specified name can be a native name expression as explained in
     * {@link NativeTypeManager#parseNameWithMacros(String)}, this method is internally called to get
     * the native name. 
     *
     * @param nativeName the exported name to find the method or field.
     * @return the address of the exported method or field or 0 if not found.
     */    
    public long getAddress(String nativeName);
    
    
    /**
     * Returns a native proxy of the DLL's exported C or C++ method or field 
     * with the specified name.
     * <p>
     * If not exist a method with this <code>nativeName</code> and signature <code>sig</code>,
     * a new proxy native instance implementing the specified interface <code>proxyInterf</code>
     * is created, registered and returned, else found native instance 
     * is returned.
     * <p>
     * It is possible to register several native proxy instances of the same
     * DLL method (same native name), because a native method can be called
     * using several "formal" signatures (for instance: a const char* formal 
     * parameter can receive an int parameter). 
     * <p>
     * The specified proxy interface <code>proxyInterf</code> must be 
     * compatible with the specified signature <code>sig</code> 
     * (if CPPConstructor, signature must be 
     * NativeConstructorSignature and so on). 
     * <p>
     * Valid interfaces: 
     * {@link com.innowhere.jnieasy.core.method.CPPConstructor}, 
     * {@link com.innowhere.jnieasy.core.method.CMethod},
     * {@link com.innowhere.jnieasy.core.method.CPPMethod}, 
     * {@link com.innowhere.jnieasy.core.method.CFieldMethod}
     * <p>
     * The specified name can be a native name expression as explained in
     * {@link NativeTypeManager#parseNameWithMacros(String)}, this method is internally called to get
     * the native name.
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param proxyInterf interface used as proxy
     * @param sig the native signature of the exported method or field.
     * @return a native proxy instance of the DLL method.
     * @see #findBehaviorByName(String,NativeBehaviorSignature)
     * @see NativeTypeManager#decBehavior(Class,NativeBehaviorSignature)
     */        
    public DLLBehavior addDLLBehavior(String nativeName,Class proxyInterf,NativeBehaviorSignature sig);
    
    /**
     * Returns a native proxy of the DLL's exported C or C++ method or field 
     * with the specified name.
     * <p>
     * The appropriate native proxy interface is selected according the specified
     * signature.
     * <p>
     * Current implementation is:
     * <blockquote><code><pre>
     *        Class nativeInterf;
     *        if (sig instanceof NativeConstructorSignature)
     *            nativeInterf = CPPConstructor.class;        
     *        else if (sig instanceof NativeMethodSignature)
     *        {
     *            if (sig instanceof NativeStaticMethodSignature)
     *                nativeInterf = CMethod.class;
     *            else // (sig instanceof NativeInstanceMethodSignature)
     *                nativeInterf = CPPMethod.class;            
     *        }
     *        else // (sig instanceof FieldMethodSignature)
     *        {
     *            if (sig instanceof NativeStaticFieldMethodSignature)
     *                nativeInterf = CFieldMethod.class;
     *            else
     *                throw new JNIEasyException("Invalid signature, not exist C++ exported fields");
     *        }            
     *        return addDLLBehavior(nativeName,nativeInterf,sig);
     * </pre></code></blockquote>
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param sig the native signature of the exported method or field.
     * @return a native proxy instance of the DLL method.
     * @see #addDLLBehavior(String,Class,NativeBehaviorSignature)
     */        
    public DLLBehavior addDLLBehavior(String nativeName,NativeBehaviorSignature sig);    
    
    /**
     * Returns a native proxy of the DLL's exported C or C++ method 
     * with the specified name.
     * <p>
     * The appropriate native proxy interface is selected according the specified
     * signature.
     * <p>
     * Current implementation is:
     * <blockquote><code><pre>
     *        Class nativeInterf;
     *        if (sig instanceof NativeStaticMethodSignature)
     *            nativeInterf = CMethod.class;
     *        else // (sig instanceof NativeInstanceMethodSignature)
     *            nativeInterf = CPPMethod.class;                 
     *        return addDLLBehavior(nativeName,nativeInterf,sig);
     * </pre></code></blockquote>
     * 
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param sig the native signature of the exported method.
     * @return a native proxy instance of the DLL method.
     * @see #addDLLBehavior(String,Class,NativeBehaviorSignature)
     */     
    public DLLMethod addDLLMethod(String nativeName,NativeMethodSignature sig);

    /**
     * Returns a native proxy of the DLL's exported C method  
     * with the specified name working as a C++ constructor.
     * <p>
     * The native C method must return a pointer to a new C++ object
     * created in the method.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (CPPConstructor)addDLLBehavior(name,CPPConstructor.class,sig);
     * </code></blockquote>
     * 
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param sig the native signature of the exported method.
     * @return a native proxy instance of the DLL method.
     * @see #addDLLBehavior(String,Class,NativeBehaviorSignature)
     */    
    public CPPConstructor addCPPConstructor(String nativeName,NativeConstructorSignature sig);
    
    /**
     * Returns a native proxy of the DLL's exported C method  
     * with the specified name working as a C++ constructor.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCPPConstructor(name,getSignatureManager().decConstructor(classObj,params,callConv));
     * </code></blockquote>
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param clasz defines the container class of the constructor (and return type).
     * @param params parameter list declaration.
     * @param callConv call convention of the method.
     * @return a native proxy instance of the DLL method.
     * @see #addCPPConstructor(String,NativeConstructorSignature)
     * @see NativeSignatureManager#decConstructor(Class,Object[],int)
     */
    public CPPConstructor addCPPConstructor(String nativeName,Class clasz,Object[] params,int callConv);
    
    /**
     * Returns a native proxy of the DLL's exported C method  
     * with the specified name working as a C++ constructor.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCPPConstructor(name,classObj,params,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param nativeName the exported name of the method in the DLL.
     * @param clasz defines the container class of the constructor (and return type).
     * @param params parameter list declaration. 
     * @return a native proxy instance of the DLL method.
     * @see #addCPPConstructor(String,Class,Object[],int)
     */    
    public CPPConstructor addCPPConstructor(String nativeName,Class clasz,Object[] params);
    
    
    /**
     * Returns a native proxy of the DLL's exported C method  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (CMethod)addDLLBehavior(name,CMethod.class,sig);
     * </code></blockquote>
     * 
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param sig the native signature of the exported method.
     * @return a native proxy instance of the DLL method.
     * @see #addDLLBehavior(String,Class,NativeBehaviorSignature)
     */    
    public CMethod addCMethod(String nativeName,NativeStaticMethodSignature sig);
    
    /**
     * Returns a native proxy of the DLL's exported C method  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCMethod(name,getSignatureManager().decStaticMethod(returnType,params,callConv));
     * </code></blockquote>
     * 
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param returnType the return type declaration.
     * @param params parameter list declaration.
     * @param callConv call convention of the method.
     * @return a native proxy instance of the DLL method.
     * @see #addCMethod(String,NativeStaticMethodSignature)
     * @see NativeSignatureManager#decStaticMethod(Object,Object[],int)
     */    
    public CMethod addCMethod(String nativeName,Object returnType,Object[] params,int callConv);    
    
    /**
     * Returns a native proxy of the DLL's exported C method  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCMethod(name,returnType,params,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param nativeName the exported name of the method in the DLL.
     * @param returnType the return type declaration.
     * @param params parameter list declaration. 
     * @return a native proxy instance of the DLL method.
     * @see #addCMethod(String,Object,Object[],int)
     */     
    public CMethod addCMethod(String nativeName,Object returnType,Object[] params);

    /**
     * Returns a native proxy of the DLL's exported C++ instance method  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (CPPMethod)addDLLBehavior(name,CPPMethod.class,sig);
     * </code></blockquote>
     * 
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param sig the native signature of the exported method.
     * @return a native proxy instance of the DLL method.
     * @see #addDLLBehavior(String,Class,NativeBehaviorSignature)
     */        
    public CPPMethod addCPPMethod(String nativeName,NativeInstanceMethodSignature sig);
    
    /**
     * Returns a native proxy of the DLL's exported C++ instance method  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCPPMethod(name,getSignatureManager().decInstanceMethod(clasz,returnType,params,callConv));
     * </code></blockquote>
     * 
     * @param nativeName the exported name of the method in the DLL.
     * @param clasz defines the container class of the method.
     * @param returnType the return type declaration.
     * @param params parameter list declaration.
     * @param callConv call convention of the method.
     * @return a native proxy instance of the DLL method.
     * @see #addCMethod(String,NativeStaticMethodSignature)
     * @see NativeSignatureManager#decInstanceMethod(Class,Object,Object[],int)
     */    
    public CPPMethod addCPPMethod(String nativeName,Class clasz,Object returnType,Object[] params,int callConv);
    
    /**
     * Returns a native proxy of the DLL's exported C++ instance method  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCPPMethod(name,classObj,returnType,params,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param nativeName the exported name of the method in the DLL.
     * @param clasz defines the container class of the method.
     * @param returnType the return type declaration.
     * @param params parameter list declaration. 
     * @return a native proxy instance of the DLL method.
     * @see #addCPPMethod(String,Class,Object,Object[],int)
     */    
    public CPPMethod addCPPMethod(String nativeName,Class clasz,Object returnType,Object[] params);

    /**
     * Returns a native proxy of the DLL's exported static C field  
     * with the specified name.
     * <p>
     * Using this proxy the native field may be accessed using method calls.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return (CFieldMethod)addDLLBehavior(name,CFieldMethod.class,sig);
     * </code></blockquote>
     * 
     * 
     * @param nativeName the exported name of the field in the DLL.
     * @param sig the native signature of the exported field-method.
     * @return a native proxy instance of the DLL field.
     * @see #addDLLBehavior(String,Class,NativeBehaviorSignature)
     */     
    public CFieldMethod addCFieldMethod(String nativeName,NativeStaticFieldMethodSignature sig);    
    
    /**
     * Returns a native proxy of the DLL's exported static C field  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCFieldMethod(name,getSignatureManager().decStaticFieldMethod(fieldType,callConv));
     * </code></blockquote>
     * 
     * 
     * 
     * 
     * @param nativeName the exported name of the field in the DLL.
     * @param fieldType the field type declaration.
     * @param callConv call convention of the field-method.
     * @return a native proxy instance of the DLL field.
     * @see #addCFieldMethod(String,NativeStaticFieldMethodSignature)
     * @see NativeSignatureManager#decStaticFieldMethod(Object,int)
     */    
    public CFieldMethod addCFieldMethod(String nativeName,Object fieldType,int callConv);
    
    /**
     * Returns a native proxy of the DLL's exported static C field  
     * with the specified name.
     * <p>
     * Current implementation is:
     * <blockquote><code>
     * return addCFieldMethod(name,fieldType,getDefaultCallConv());
     * </code></blockquote>
     *
     * @param nativeName the exported name of the field in the DLL.
     * @param fieldType the field type declaration.
     * @return a native proxy instance of the DLL field.
     * @see #addCFieldMethod(String,Object,int)
     */     
    public CFieldMethod addCFieldMethod(String nativeName,Object fieldType);
    
  
    /**                
     * Returns an unmodifiable Map with the registered native method instances 
     * indexed by signature string.
     *
     * @return a signature string indexed unmodifiable Map of the registered native method instances.
     * @see #findBehaviorBySignature(String)
     */       
    public Map getBehaviorsBySignature();    
    // public Map getBehaviorsByName();
    
    /**                
     * Returns an unmodifiable Collection with the registered native method instances 
     * with the specified native name.
     * <p>
     * If this DLL is the {@link JNIEasyLibrary}, this collection may contain
     * Java callbacks (exported with 
     * {@link JNIEasyLibrary#exportBehavior(String,NativeBehavior)},
     * this instances does not implement the {@link DLLBehavior} interface. 
     * Use the {@link NativeBehavior} interface to a secure iteration
     * of elements.
     *
     * @return a name indexed unmodifiable Map of native method instances.
     */    
    public Collection findBehaviorsByName(String nativeName);
    
    /**                
     * Returns the registered native method instance 
     * with the specified native name and signature.
     *
     * @return the registered native method instance or null if not found.
     */ 
    public NativeBehavior findBehaviorByName(String nativeName,NativeBehaviorSignature sig); 
    
    /**
     * Returns the registered native method instance with the
     * specified signature as string.
     * <p>
     * The signature format is described in 
     * {@link NativeBehaviorSignature#getSignatureString(String)}. 
     * The <code>nativeName</code> used to create/register the native method
     * to search must be used to form the signature string.
     * 
     * 
     * @param signature the signature string of the native method to search.
     * @return the registered native method instance or null if not found.
     */
    public NativeBehavior findBehaviorBySignature(String signature); 
    
    /**                
     * Removes the registered native method instances 
     * with the specified native name.
     * <p>
     * Returns the collection with the removed native method instances. 
     * Iterate this collection with the rules explained in 
     * {@link #findBehaviorsByName(String)}
     *
     * @return the collection with the removed native method instances.
     */    
    public Collection removeBehaviorsByName(String nativeName);
    
    /**                
     * Removes the registered native method instance 
     * with the specified native name and signature.
     *
     * @return the removed native method instance or null if not found.
     */     
    public NativeBehavior removeBehaviorByName(String nativeName,NativeBehaviorSignature sig);
    
    /**                
     * Removes all registered native method instances in this DLL.
     */        
    public void removeAllMethods();
    
    
}
