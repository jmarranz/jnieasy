/*
 * NativeAddress.java
 *
 * Created on 16 de enero de 2004, 13:42
 */

package com.innowhere.jnieasy.core.impl.mem;

/**
 *
 * @author  jmarranz
 */
import com.innowhere.jnieasy.core.*;
import com.innowhere.jnieasy.core.mem.*;

public class NativeAddressImpl implements NativeAddress, Comparable
{
    private long address = 0; 
    private NativeAddressImpl refAddress; // Caso de direcciones relativas
    private long offset = -1; // posición relativa respecto a la dirección referencia
    
    /**
     * Creates a new instance of NativeAddress
     */
    public NativeAddressImpl()
    {
    }
    
    public NativeAddressImpl(long addr)
    {
        setValue(addr);
    }

    public NativeAddressImpl(NativeAddress addr,long offset)
    {
        setValue(addr,offset);
    }    
    
    public long getValue()
    {
        if (refAddress != null)
            return refAddress.getValue() + offset;
        else
            return address;
    }        
    
    protected void setValue(long addr)
    {
        if (addr == 0) throw new JNIEasyException("0 memory address is not valid");
        this.address = addr;
        this.refAddress = null;
        this.offset = -1;
    }

    protected void setValue(NativeAddress refAddress,long offset)
    {
        if (refAddress.getValue() == 0) throw new JNIEasyException("0 memory address is not valid");
        if (offset < 0) throw new JNIEasyException("Negative offset value is not valid");
        
        this.refAddress = (NativeAddressImpl)refAddress;
        this.offset = offset;    
        this.address = 0; // no vale esta
    }    

    protected void setInvalid()
    {
        this.refAddress = null;
	this.address = 0;
    }
    
    public NativeAddress getParentAddress()
    {
        return refAddress;
    }
    
    public long getOffset()
    {
        return offset;
    }
    
    public boolean equals(Object obj)
    {
        if (obj == null) return false;
        boolean res = super.equals(obj);
        if (res) return true; // es el mismo objeto
        
        return (getValue() == ((NativeAddressImpl)obj).getValue());
    }

    public int hashCode()
    {
        long value = getValue();
        return (int)(value ^ (value >>> 32)); // Copiado de Long.hashCode();
    }        

    public int compareTo(Object obj)
    {
        NativeAddressImpl addr = (NativeAddressImpl)obj;
        if (getValue() < addr.getValue()) return -1;
        else if (getValue() > addr.getValue()) return 1;
        else return 0;
    }    

}
