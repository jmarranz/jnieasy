/*
 * NativeBuffer.java
 *
 * Created on 26 de febrero de 2004, 11:55
 */

package com.innowhere.jnieasy.core.mem;

/**
 * The interface <code>NativeBuffer</code> is implemented by the framework
 * to encapsulate a native memory block.
 * <p>
 * When an instance is garbage collected, the native memory is freed automatically
 * if the buffer owns the native memory.
 * <p>
 * Use with care if this object is got from a native instance, it may interfere
 * with the normal life cycle of the related native instance.
 * <p>
 * The sizes used to read and write the native memory are the Java 
 * sizes of the primitive types ever: boolean=1,
 * byte=1, char=2, short=2, int=4, long=8, float=4, double=8. They are not
 * affected by methods like {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#setDefaultBooleanSize(long)}
 * with two exceptions: 
 * <ol>
 *   <li>Ansi Strings are defined with 1 byte native chars
 *   <li>Unicode Strings are defined with 2 bytes per native char in Win32 and 4 bytes 
 *      in Linux/Mac/Solaris (the size of wchar_t in these platforms). If 4 bytes used the upper 2 bytes
 *      of the wchar_t are lost because the Java char size is 2 bytes
 *      (this is not a problem because most of Unicode fits into 2 bytes)
 *      The wchar_t size is not fixed and can be changed with the method 
 *      {@link com.innowhere.jnieasy.core.typedec.NativeTypeManager#setWCharTSize(long)}
 * </ol>
 * <p>NativeBuffer's methods are not multithread safe.
 *
 * @author  Jose M. Arranz Santamaria
 * @see NativeManager#allocateBuffer(long)
 * @see NativeManager#attachBuffer(long)  
 * @see NativeManager#attachBuffer(long,long)
 * @see NativeStateManager#getBuffer()
 */
public interface NativeBuffer extends NativeAddress
{
    /**
     * Frees the associated native memory if buffer owns it, else does nothing.
     * <p>
     * Current implementation calls {@link #free(boolean)} with <code>force</code>
     * set to false.
     */
    public void free();
    
    /**
     * Frees the associated native memory.
     * <p>
     * If <code>force</code> is true native memory is freed ever, else is 
     * freed if buffer owns it, else does nothing.
     * <p>
     * If native memory is freed this buffer can not be used anymore.
     *
     * @param force if true native memory is freed ever, if false is freed if buffer owns the memory.
     */
    public void free(boolean force);
    
    /**
     * Disconnects this buffer of the owned native memory, if buffer does not
     * own the native memory does nothing.
     * <p>
     * When this buffer is garbage collected native memory is not freed.
     * <p>
     * The buffer remains attached and may be used after to invoke this method.
     */
    public void disconnect();   
    
    /**
     * Returns true if buffer does not own the associated native memory.
     * <p>
     * When this buffer is garbage collected native memory is not freed.
     *
     * @return true if attached not owning the native memory.
     */
    public boolean isAttached();
    
    /**
     * Returns true if buffer is attached to the specified parent address and
     * offset.
     * <p>
     * Parent address <b>and</b> offset must be coincident.
     * <p> 
     * If buffer owns the native memory returns false.
     *
     * @param address the parent address.
     * @param offset the relative offset to parent address.
     * @return true if buffer is attached to parent address and offset.
     */    
    public boolean isAttachedTo(NativeAddress address,long offset);
    
    /**
     * Returns the native memory size of the buffer or -1 if unknown.
     * <p>
     * If the size is unknown the buffer does not impose a superior limit.
     *
     * @return the native memory size or -1.
     */
    public long size();
    
    /**
     * Returns a boolean read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public boolean getBoolean(long offset);
    
    /**
     * Updates with a boolean data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setBoolean(long offset, boolean value);
    
    /**
     * Returns a byte read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public byte getByte(long offset);
    
    /**
     * Updates with a byte data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setByte(long offset, byte value);
    
    /**
     * Returns a char read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public char getChar(long offset);
    
    /**
     * Updates with a char data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */
    public void setChar(long offset, char value);
    
    /**
     * Returns a short read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public short getShort(long offset);
    
    /**
     * Updates with a short data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setShort(long offset, short value);
    
    /**
     * Returns an int read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public int getInt(long offset);
    
    /**
     * Updates with an int data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setInt(long offset, int value);
    
    /**
     * Returns a long read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public long getLong(long offset);
    
    /**
     * Updates with a long data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setLong(long offset, long value);
    
    /**
     * Returns a float read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public float getFloat(long offset);
    
    /**
     * Updates with a float data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setFloat(long offset, float value);    
    
    /**
     * Returns a double read from the native memory in
     * the buffer address + the specified offset. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */    
    public double getDouble(long offset); 
    
    /**
     * Updates with a double data the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */    
    public void setDouble(long offset, double value);
    
    /**
     * Returns a platform address value read from the native memory in
     * the buffer address + the specified offset.
     * <p>
     * In a 32 bit platform an int value is read, in a 64 bit will be
     * a long value read. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the data read from native memory.
     */      
    public long getAddress(long offset);   
        
    /**
     * Updates with a platform address data the native memory in
     * the buffer address + the specified offset.
     * <p>
     * In a 32 bit platform an int value is written, in a 64 bit will be
     * a long value written. 
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new value to write.
     */      
    public void setAddress(long offset, long value);
    
    /**
     * Returns a java.lang.String read from the native memory in
     * the buffer address + the specified offset until
     * a '\0' character is found, converting each byte (C char) read 
     * to a Java char.
     * <p>
     * The '\0' finalizer is not assigned to the String.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the ANSI String read from native memory.
     */    
    public String getAnsiString(long offset);
    
    /**
     * Writes on the native memory the specified java.lang.String in
     * the buffer address + the specified offset, each character
     * is converted to one byte (C char), the '\0' character is written in the end.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new ANSI string to write.
     */    
    public void setAnsiString(long offset, String value);
      
    /**
     * Returns a java.lang.String read from the native memory in
     * the buffer address + the specified offset until
     * a C L'\0' character is found converting each 2 byte (Win32 wchar_t) or
     * 4 byte (Linux/Mac/Solaris wchar_t) read to a Java char.
     * <p>
     * The '\0' finalizer is not assigned to the String.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the UNICODE String read from native memory.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#setWCharTSize(long)
     */    
    public String getUnicodeString(long offset);
    
    /**
     * Writes on the native memory the specified java.lang.String in
     * the buffer address + the specified offset, each character
     * is converted to two bytes (C wchar_t), the C L'\0' character is written in the end.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new UNICODE string to write.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#setWCharTSize(long)
     */    
    public void setUnicodeString(long offset, String value);
    
    /**
     * Returns a java.lang.StringBuffer read from the native memory in
     * the buffer address + the specified offset until
     * a '\0' character is found, converting each byte (C char) read 
     * to a Java char.
     * <p>
     * Current implementation reads a String with
     * {@link #getAnsiString(long)}
     * and copies it to a new StringBuffer.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the ANSI StringBuffer read from native memory.
     */    
    public StringBuffer getAnsiStringBuffer(long offset);    
    
    /**
     * Writes on the native memory the specified java.lang.StringBuffer in
     * the buffer address + the specified offset, each character
     * is converted to one byte (C char), the '\0' character is written in the end.
     * <p>
     * Current implementation gets a String from the StringBuffer and 
     * writes to native memory with {@link #setAnsiString(long,String)}.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new ANSI string to write.
     */       
    public void setAnsiStringBuffer(long offset, StringBuffer value);
    
    /**
     * Returns a java.lang.StringBuffer read from the native memory in
     * the buffer address + the specified offset until
     * a '\0' character is found, converting each byte (C char) read 
     * to a Java char.
     * <p>
     * Current implementation reads a String with
     * {@link #getUnicodeString(long)}
     * and copies it to a new StringBuffer.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the ANSI StringBuffer read from native memory.
     */    
    public StringBuffer getUnicodeStringBuffer(long offset);    
    
    /**
     * Writes on the native memory the specified java.lang.StringBuffer in
     * the buffer address + the specified offset, each character
     * is converted to two bytes (C wchar_t), the C L'\0' character is written in the end.
     * <p>
     * Current implementation gets a String from the StringBuffer and 
     * writes to native memory with {@link #setUnicodeString(long,String)}.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @param value the new UNICODE string to write.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#setWCharTSize(long)
     */    
    public void setUnicodeStringBuffer(long offset, StringBuffer value);    
    
    /**
     * Returns the length of the '\0' ended string from the native memory in
     * the buffer address + the specified offset. Each byte
     * is counted as a character.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the ANSI string length.
     */
    public int getAnsiStringLength(long offset);    
    
    /**
     * Returns the length of the L'\0' (wide char) ended string from the native memory in
     * the buffer address + the specified offset. Each 2 bytes (Win32 wchar_t)
     * or 4 bytes (Linux/Mac/Solaris wchar_t) are counted as a character.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the relative address offset.
     * @return the UNICODE string length.
     * @see com.innowhere.jnieasy.core.typedec.NativeTypeManager#setWCharTSize(long)
     */    
    public int getUnicodeStringLength(long offset);
 
   
    /**
     * Returns a boolean array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */      
    public boolean[] getBooleanArray(long offset, boolean[] buf, int index, int length);    
    
    /**
     * Updates with a boolean data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */       
    public void setBooleanArray(long offset, boolean[] buf, int index, int length);
    
    /**
     * Returns a byte array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public byte[] getByteArray(long offset, byte[] buf, int index, int length);
    
    /**
     * Updates with a byte data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */  
    public void setByteArray(long offset, byte[] buf, int index, int length);
    
    /**
     * Returns a char array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public char[] getCharArray(long offset, char[] buf, int index, int length);
    
    /**
     * Updates with a char data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */    
    public void setCharArray(long offset, char[] buf, int index, int length);
    
    /**
     * Returns a short array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public short[] getShortArray(long offset, short[] buf, int index, int length);    
    
    /**
     * Updates with a short data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */    
    public void setShortArray(long offset, short[] buf, int index, int length);
    
    /**
     * Returns an int array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public int[] getIntArray(long offset, int[] buf, int index, int length);
    
    /**
     * Updates with an int data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */    
    public void setIntArray(long offset, int[] buf, int index, int length);
    
    /**
     * Returns a long array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public long[] getLongArray(long offset, long[] buf, int index, int length);
    
    /**
     * Updates with a long data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */    
    public void setLongArray(long offset, long[] buf, int index, int length);
    
    /**
     * Returns a float array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public float[] getFloatArray(long offset, float[] buf, int index, int length);
    
    /**
     * Updates with a float data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */    
    public void setFloatArray(long offset, float[] buf, int index, int length);
    
    /**
     * Returns a double array read from the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     */    
    public double[] getDoubleArray(long offset, double[] buf, int index, int length);
    
    /**
     * Updates with a double data array the native memory in
     * the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param buf the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>buf</code> to write.
     * @param length the number of elements to be written.
     */    
    public void setDoubleArray(long offset, double[] buf, int index, int length); 
    
    /**
     * Returns a boolean array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java boolean size is 1 byte):
     * <blockquote>
     * buffer address + offset + index * 1
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */
    public boolean getBooleanArray(long offset, int index); 
    
    /**
     * Updates a boolean array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java boolean size is 1 byte):
     * <blockquote>
     * buffer address + offset + index * 1
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setBooleanArray(long offset, int index, boolean value);
    
    /**
     * Returns a byte array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java byte size is 1):
     * <blockquote>
     * buffer address + offset + index * 1
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public byte getByteArray(long offset, int index);
    
    /**
     * Updates a byte array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java byte size is 1 byte):
     * <blockquote>
     * buffer address + offset + index * 1
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setByteArray(long offset, int index, byte value);

    /**
     * Returns a char array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java char size is 2 bytes):
     * <blockquote>
     * buffer address + offset + index * 2
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public char getCharArray(long offset, int index);
    
    /**
     * Updates a char array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java char size is 2 bytes):
     * <blockquote>
     * buffer address + offset + index * 2
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setCharArray(long offset, int index, char value);
    
    /**
     * Returns a short array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java short size is 2 bytes):
     * <blockquote>
     * buffer address + offset + index * 2
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public short getShortArray(long offset, int index);
    
    /**
     * Updates a short array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java short size is 2 bytes):
     * <blockquote>
     * buffer address + offset + index * 2
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setShortArray(long offset, int index, short value);
    
    /**
     * Returns an int array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java int size is 4 bytes):
     * <blockquote>
     * buffer address + offset + index * 4
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public int getIntArray(long offset, int index);
    
    /**
     * Updates an int array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java int size is 4 bytes):
     * <blockquote>
     * buffer address + offset + index * 4
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setIntArray(long offset, int index, int value);
    
    /**
     * Returns a long array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java long size is 8 bytes):
     * <blockquote>
     * buffer address + offset + index * 8
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public long getLongArray(long offset, int index);
    
    /**
     * Updates a long array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java long size is 8 bytes):
     * <blockquote>
     * buffer address + offset + index * 8
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setLongArray(long offset, int index, long value);
    
    /**
     * Returns a float array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java float size is 4 bytes):
     * <blockquote>
     * buffer address + offset + index * 4
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public float getFloatArray(long offset, int index);
    
    /**
     * Updates a float array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java float size is 4 bytes):
     * <blockquote>
     * buffer address + offset + index * 4
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setFloatArray(long offset, int index, float value);
    
    /**
     * Returns a double array element read from the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java double size is 8 bytes):
     * <blockquote>
     * buffer address + offset + index * 8
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @return the data read from native memory.
     */    
    public double getDoubleArray(long offset, int index); 
    
    /**
     * Updates a double array element on the native memory in
     * the buffer address + the specified offset with the specified index.
     * <p>
     * Final address is calculated as (Java double size is 8 bytes):
     * <blockquote>
     * buffer address + offset + index * 8
     * </blockquote>
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset, where the array starts.
     * @param index the element array index.
     * @param value the new value.
     */    
    public void setDoubleArray(long offset, int index, double value);

    /**
     * Returns a new native buffer mapping a native memory part of 
     * the buffer. 
     * <p>
     * The returned buffer is ever attached to the native memory (does not own the memory)
     * and is independent of parent buffer (native memory shared is the only one
     * dependency).
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param size the size of the native memory.
     * @return a new buffer mapping a memory part.
     */
    public NativeBuffer getBuffer(long offset,long size);
    
    /*
     * Copies the native memory data mapped by the specified buffer
     * to this buffer starting in the buffer address + the specified offset.
     * <p> 
     * If accessed memory is out of bounds, an exception is thrown.
     *
     * @param offset the specified offset.
     * @param value the native buffer to be copied.
     */
    public void setBuffer(long offset, NativeBuffer value);    
    
    
    /**
     * Creates a new native buffer iterator of this buffer.
     *
     * @return the new iterator.
     */    
    public NativeBufferIterator newBufferIterator();    
}
