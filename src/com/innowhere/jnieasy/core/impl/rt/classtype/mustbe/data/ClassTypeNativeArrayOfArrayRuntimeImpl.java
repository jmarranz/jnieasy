/*
 * ClassTypeNativeArrayOfArrayRuntimeImpl.java
 *
 * Created on 19 de enero de 2004, 20:47
 */

package com.innowhere.jnieasy.core.impl.rt.classtype.mustbe.data;
import com.innowhere.jnieasy.core.impl.common.classtype.model.mustbe.data.ClassTypeNativeArrayOfArrayImpl;
import com.innowhere.jnieasy.core.impl.rt.RuntimeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.classtype.ClassTypeNativeRuntimeImpl;
import java.lang.reflect.Array;


public class ClassTypeNativeArrayOfArrayRuntimeImpl extends ClassTypeCanBeNativeCapableArrayRuntimeImpl
{
    
    /**
     * Creates a new instance of ClassTypeNativeArrayOfArrayRuntimeImpl
     */
    public ClassTypeNativeArrayOfArrayRuntimeImpl(ClassTypeNativeArrayOfArrayImpl classType,RuntimeManagerImpl rtMgr)
    {
        super(classType,rtMgr);
    }
  
    public ClassTypeNativeArrayOfArrayImpl getClassTypeNativeArrayOfArray()
    {
        return (ClassTypeNativeArrayOfArrayImpl)classType;
    }    
    
    public Object newArrayValue(int length)
    {
        // Es válido pues es posible por ejemplo hacer: int[][] array = new int[3][];
        Class componentType = getClassImpl().getComponentType();
        return Array.newInstance(componentType,length);        
    }
    
    public long getPreferredAlignSize()
    {
        ClassTypeNativeRuntimeImpl classTypeComp = getClassTypeComponent();
        return classTypeComp.getPreferredAlignSize();
    }
}

