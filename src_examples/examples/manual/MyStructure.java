/*
 * MyStructure.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.data.*;
import com.innowhere.jnieasy.core.listener.MakeNativeCallback;
import com.innowhere.jnieasy.core.mem.*;
import com.innowhere.jnieasy.core.typedec.NativeTypeManager;
import com.innowhere.jnieasy.core.typedec.TypeNativeObject;
import com.innowhere.jnieasy.core.util.NativeCapableFactory;
import com.innowhere.jnieasy.core.util.NativeCapableUtil;
import java.io.Serializable;

public class MyStructure implements MakeNativeCallback,Serializable,Cloneable
{
    protected int anInt = -1;
    protected NativeIntegerArray intArr1; // Declared "by pointer" length 2
    protected NativeIntegerArray intArr2; // Declared "by value" length 2
    protected int[] intArr3 = new int[]{5,6}; // Declared "by pointer" length 2
    protected int[] intArr4 = new int[]{7,8}; // Declared "by value" length 2
    
    protected long crossPlatLong;
    protected long[] crossPlatLongArray = new long[]{1,2};
    protected Long crossPlatLongObject = new Long(0);     
    protected NativeLong crossPlatNativeLong;
    protected NativeLongObject crossPlatNativeLongObject;    
    protected char cChar;
    
    public MyStructure()
    {       
        NativeCapableFactory factory = JNIEasy.get().getNativeCapableFactory();
        this.intArr1 = (NativeIntegerArray)factory.wrapValue(new int[]{1,2});
        this.intArr2 = (NativeIntegerArray)factory.wrapValue(new int[]{3,4});
        
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();
        this.crossPlatNativeLong = (NativeLong)typeMgr.decAddress().decObjectWrapper(NativeLong.class).newValue();
        this.crossPlatNativeLongObject = (NativeLongObject)typeMgr.decAddress().decObjectWrapper(NativeLongObject.class).newValue();
    }
    
    public NativeIntegerArray getIntArray1()
    {
        return intArr1;
    }
    
    public void setIntArray1(NativeIntegerArray intArr1)
    {
        this.intArr1 = intArr1;
    }
    
    public NativeIntegerArray getIntArray2()
    {
        return intArr2;
    }
    
    public void setIntArray2(NativeIntegerArray intArr2)
    {
        this.intArr2 = intArr2;
    }
    
    public int[] getIntArray3()
    {
        return this.intArr3;
    }
    
    public void setIntArray3(int[] intArr3)
    {
        this.intArr3 = intArr3;
    }
    
    public int[] getIntArray4()
    {
        return this.intArr4;
    }
    
    public void setIntArray4(int[] intArr4)
    {
        this.intArr4 = intArr4;
    }    
    
    public void setIntArray3(int index,int value)
    {
        int[] aux = this.intArr3;
        aux[index] = value;
        this.intArr3 = aux;
    }
    
    public void addToAnInt(int value)
    {
        this.anInt = this.anInt + value;
    }
    
    public void addToAnInt2(int value)
    {
        this.anInt += value;
    }

    public Long getCrossPlatLongObject()
    {
        return crossPlatLongObject;
    }

    public void setCrossPlatLongObject(Long crossPlatLongObject)
    {
        this.crossPlatLongObject = crossPlatLongObject;
    }
    
    public NativeLong getCrossPlatNativeLong()
    {
        return crossPlatNativeLong;
    }

    public void setCrossPlatNativeLong(NativeLong crossPlatNativeLong)
    {
        this.crossPlatNativeLong = crossPlatNativeLong;
    }

    public NativeLongObject getCrossPlatNativeLongObject()
    {
        return crossPlatNativeLongObject;
    }

    public void setCrossPlatNativeLongObject(NativeLongObject crossPlatNativeLongObject)
    {
        this.crossPlatNativeLongObject = crossPlatNativeLongObject;
    }
    
    public void jnieasyPreMakeNative(NativeAddress nativeAddress, long offset)
    {
        System.out.println("PreMakeNative (attached)");
        System.out.println("Must be false: " + NativeCapableUtil.isNative(this));
    }

    public void jnieasyPreMakeNative()
    {
        System.out.println("PreMakeNative (memory owner)");
        System.out.println("Must be false: " + NativeCapableUtil.isNative(this));        
    }

    public void jnieasyPostMakeNative()
    {
        System.out.println("PostMakeNative");
        System.out.println("Must be true: " + NativeCapableUtil.isNative(this));        
    }



}
