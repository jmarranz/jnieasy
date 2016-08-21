/*
 * NativeCapableInternal.java
 *
 * Created on 18 de marzo de 2005, 13:51
 */

package com.innowhere.jnieasy.core.impl.rt.natobjint;
import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.mem.NativeStateManager;
import com.innowhere.jnieasy.core.data.NativeCapable;
import com.innowhere.jnieasy.core.typedec.TypeNative;

public interface NativeCapableInternal extends NativeCapable
{
    public void jnieasyInitClass(JNIEasy jnieasy);
    public void jnieasySetNativeStateManager(NativeStateManager stateMgr);  
    public Object jnieasyClone() throws CloneNotSupportedException;    
    public void jnieasyReplaceFieldsWithCloned(Object cloneCtx,NativeStateManager stateMgr);    
    public NativeStateManager jnieasyNewNativeStateManager();
    public long jnieasyGetSize();     
    public Object jnieasyNewInstance();
    public Object[] jnieasyNewArrayInstance(int len);
    public void jnieasySetType(TypeNative typeDec);
    public TypeNative jnieasyGetDefaultType();     
}
