/*
 * CFieldMethodStateManagerImpl.java
 *
 * Created on 10 de octubre de 2005, 18:24
 *
 * To change this template, choose Tools | Options and locate the template under
 * the Source Creation and Management node. Right-click the template and choose
 * Open. You can then make changes to the template in the Source Editor.
 */

package com.innowhere.jnieasy.core.impl.rt.statemgr;
import com.innowhere.jnieasy.core.data.NativeBoolean;
import com.innowhere.jnieasy.core.data.NativeByte;
import com.innowhere.jnieasy.core.data.NativeCharacter;
import com.innowhere.jnieasy.core.data.NativeDouble;
import com.innowhere.jnieasy.core.data.NativeFloat;
import com.innowhere.jnieasy.core.data.NativeInteger;
import com.innowhere.jnieasy.core.data.NativeLong;
import com.innowhere.jnieasy.core.data.NativePrimitive;
import com.innowhere.jnieasy.core.data.NativeShort;
import com.innowhere.jnieasy.core.impl.rt.NativeManagerImpl;
import com.innowhere.jnieasy.core.impl.rt.natobjint.CFieldMethodInternal;
import com.innowhere.jnieasy.core.impl.rt.natobjint.NativeCapableInternal;
import com.innowhere.jnieasy.core.impl.rt.signat.NativeStaticFieldMethodSignatureRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeObjectRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativePrimitiveRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.TypeNativeRuntimeImpl;
import com.innowhere.jnieasy.core.impl.rt.typedec.natobj.data.TypeNativePrimitiveWrapperRuntimeImpl;
import com.innowhere.jnieasy.core.mem.NativeAddress;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;

/**
 *
 * @author jmarranz
 */
public class CFieldMethodStateManagerImpl extends DLLBehaviorStateManagerImpl
{
    protected NativePrimitive auxObject; // en transacciones recordar� el valor del atributo en la DLL
    protected TypeNativeRuntimeImpl typeDecField; // sirve a modo de cach�
    protected NativeDirectStaticFieldCallback auxMethod;
    
    
    /**
     * Creates a new instance of CFieldMethodStateManagerImpl
     */
    public CFieldMethodStateManagerImpl()
    {
    }
    
    public TypeNativeRuntimeImpl getTypeNativeField()
    {
        return typeDecField;
    }
    
    public void attachBuffer(NativeAddress address, long offset,NativeManagerImpl nativeMgr, NativeCapableInternal value,boolean isAuxiliar)
    {
        // Es siempre attached 
        
        // Sirve para acelerar para que no tengamos que hacer tantas llamadas
        CFieldMethodInternal cfieldValue = (CFieldMethodInternal)value;
        NativeStaticFieldMethodSignatureRuntimeImpl sig = (NativeStaticFieldMethodSignatureRuntimeImpl)cfieldValue.getStaticFieldMethodSignature();
        this.typeDecField = sig.getReturnTypeNativeRuntime().getVarTypeNativeRuntime().getTypeNativeRuntime();
        
        TypeNativePrimitiveWrapperRuntimeImpl typeDecAuxObj;
        if (typeDecField instanceof TypeNativePrimitiveRuntimeImpl)
        {
            typeDecAuxObj = ((TypeNativePrimitiveRuntimeImpl)typeDecField).newRelatedTypeNativePrimitiveWrapperRuntime();            
        }
        else
        {
            // Caso Object, que debe ser por referencia: caso puntero           
            typeDecAuxObj = (TypeNativePrimitiveWrapperRuntimeImpl)nativeMgr.getJNIEasy().getTypeManager().decAddress().decObjectWrapper(NativeLong.class);
        }
        this.auxObject = (NativePrimitive)typeDecAuxObj.newValue();
        nativeMgr.attach(auxObject, address,offset);                
       
        // CFieldMethod debe mostrarse como un m�todo nativo hacia
        // el exterior, sin embargo address-offset es la direcci�n
        // del field exportado por la DLL. Usamos un objeto auxiliar
        // no es creado de forma ortodoxa pero funciona.
        // Su �nica misi�n es ser llamado con una invocaci�n nativa 
        // desde c�digo nativo si se usara la direcci�n del objeto nativo
        // que se supone que es un puntero a m�todo. Es raro pero puede ocurrir
        this.auxMethod = cfieldValue.jnieasyNewNativeDirectStaticFieldCallbackAuxiliar();
        nativeMgr.makeNative(auxMethod);
        
        // Para que cuando se pida la direcci�n se devuelva la del m�todo no la del field
        address = auxMethod.jnieasyGetNativeStateManager().getBuffer();
        
        super.attachBuffer(address, 0, nativeMgr, value,isAuxiliar);
    }

    public byte getByte()
    {
        return ((NativeByte)auxObject).getByteValue();
    }
    
    public boolean getBoolean()
    {
        return ((NativeBoolean)auxObject).getBooleanValue();
    }
    
    public char getChar()
    {
        return ((NativeCharacter)auxObject).getCharValue();
    }
    
    public short getShort()
    {
        return ((NativeShort)auxObject).getShortValue();
    }
    
    public int getInt()
    {
        return ((NativeInteger)auxObject).getIntValue();
    }
    
    public long getLong()
    {
        return ((NativeLong)auxObject).getLongValue();
    }
    
    public float getFloat()
    {
        return ((NativeFloat)auxObject).getFloatValue();
    }
    
    public double getDouble()
    {
        return ((NativeDouble)auxObject).getDoubleValue();
    }    
    
    public void setByte(byte value)
    {
        ((NativeByte)auxObject).setByteValue(value);
    }
    
    public void setBoolean(boolean value)
    {
        ((NativeBoolean)auxObject).setBooleanValue(value);
    }    
    
    public void setChar(char value)
    {
        ((NativeCharacter)auxObject).setCharValue(value);
    }     
    
    public void setShort(short value)
    {
        ((NativeShort)auxObject).setShortValue(value);
    }     
    
    public void setInt(int value)
    {
        ((NativeInteger)auxObject).setIntValue(value);
    }     
    
    public void setLong(long value)
    {
        ((NativeLong)auxObject).setLongValue(value);
    }     
    
    public void setFloat(float value)
    {
        ((NativeFloat)auxObject).setFloatValue(value);
    }     
    
    public void setDouble(double value)
    {
        ((NativeDouble)auxObject).setDoubleValue(value);
    }     
    
    public Object getObject()
    {     
        // Recordar que este es el caso puntero C
        long address = ((NativeLong)auxObject).getLongValue();
        return ((TypeNativeObjectRuntimeImpl)getTypeNativeField()).getObject(address); // puede devolver un objeto String, un NativeCapable etc
    }  
    
    public void setObject(Object value)
    {
        // Recordar que este es el caso puntero C        
        // Necesariamente ha de ser un NativeCapable el value porque 
        // si fuera un String por ejemplo al hacer wrap crear�amos una instancia en memoria
        // cuya direcci�n es la que definir�amos en el atributo est�tico de la DLL,
        // pero al salir del m�todo se perder�a el objeto 
        // y se liberar�a la memoria quedando en la DLL un "dangling pointer"
        // De esta manera el usuario es consciente de lo que hace.
        
        NativeCapableInternal natObjValue = (NativeCapableInternal)value;
        synchronized (natObjValue)
        {           
            nativeMgr.makeNative(natObjValue);                    
            ((NativeLong)auxObject).setLongValue(natObjValue.jnieasyGetNativeStateManager().getBuffer().getValue());
        }
    }
}
