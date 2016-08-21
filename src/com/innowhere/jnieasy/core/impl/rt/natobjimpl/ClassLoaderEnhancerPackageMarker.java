/*
 * ClassLoaderEnhancerPackageMarker.java
 *
 * Created on 20 de mayo de 2005, 14:29
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.natobjimpl;

/**
 *
 * @author jmarranz
 */
    
    /* Esta clase sirve únicamente para que las clases enhanced en su iniciador
     *estático instancien un objeto de esta clase, dicho objeto tendrá
     *como ClassLoader el ClassLoader de la clase que se carga en el caso
     *de usar EnhancerClassLoader, pues está en el paquete de clases
     *cargables con dicho enhancer.
     * Es decir, se usará como: new ClassLoaderEnhancerPackageMarker.getClass().getClassLoader()
     * o via ClassLoaderEnhancerPackageMarker.class (aunque no funciona con javassist)
     */

   /* No deben ponerse clases dentro de este paquete e hijos, clases que no sean clases 
    implementación de NativeCapable. Considera que una clase custom tiene un atributo a una clase predefinida
    es deseable que la clase predefinida se cargue con el mismo loader que la clase contenedora pues a su vez
    puede albergar objetos de clases custom.
    **/
  

public class ClassLoaderEnhancerPackageMarker
{
    /**
     * Creates a new instance of ClassLoaderEnhancerPackageMarker
     */
    public ClassLoaderEnhancerPackageMarker()
    {
    }
}
