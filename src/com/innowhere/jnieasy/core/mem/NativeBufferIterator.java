/*
 * NativeBufferIterator.java
 *
 * Created on 17 de febrero de 2006, 14:21
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package com.innowhere.jnieasy.core.mem;

/**
 * The interface <code>NativeBufferIterator</code> is implemented by the framework
 * to provide a native buffer iterator.
 * <p>
 * A native buffer iterator allows to read/write the native memory sequentially;
 * an internal counter working as the relative offset of the buffer address
 * is incremented automatically depending on the data read/written.
 *
 * @author jmarranz
 * @see NativeBuffer#newBufferIterator()
 */
public interface NativeBufferIterator
{
    /**
     * Returns the parent native buffer.
     * 
     * @return the parent buffer.
     */
    public NativeBuffer getBuffer();
   
    /**
     * Returns the current relative position of the iterator in bytes working
     * as an offset.
     * <p>
     * Absolute position address of the iterator must be calculated as:
     * buffer address + iterator position 
     *
     * @return the current position.
     */
    public long currentOffset();

    /**
     * Returns the current absolute address position of the iterator.
     * <p>
     * Absolute address is calculated as:
     * buffer address + current offset 
     *
     * @return the current absolute address position.
     * @see NativeAddress#getValue()
     */    
    public long currentAddress();
    
    /**
     * Increments the current relative position with the specified number of bytes.
     *
     * @param bytes the number of bytes to increment.
     * @return the current relative position after increment.
     */
    public long forward(long bytes);

    /**
     * Decrements the current relative position with the specified number of bytes.
     *
     * @param bytes the number of bytes to decrement.
     * @return the current relative position after increment.
     */    
    public long backward(long bytes);

    /**
     * Returns a boolean read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 1 byte (Java boolean size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getBoolean(long)
     */    
    public boolean nextBoolean();
    
    /**
     * Updates with a boolean data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 1 byte (Java boolean size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setBoolean(long,boolean)
     */    
    public void setBoolean(boolean value);
    
    /**
     * Returns a byte read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 1 byte (Java byte size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getByte(long)
     */    
    public byte nextByte();

    /**
     * Updates with a byte data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 1 byte (Java byte size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setByte(long,byte)
     */     
    public void setByte(byte value);

    /**
     * Returns a char read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 2 bytes (Java char size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getChar(long)
     */     
    public char nextChar();

    /**
     * Updates with a char data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 2 byte (Java char size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setChar(long,char)
     */     
    public void setChar(char value);
    
    /**
     * Returns a short read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 2 bytes (Java short size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getShort(long)
     */ 
    public short nextShort();

    /**
     * Updates with a short data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 2 bytes (Java short size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setShort(long,short)
     */     
    public void setShort(short value);
   
    /**
     * Returns an int read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 4 bytes (Java int size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getInt(long)
     */     
    public int nextInt();

    /**
     * Updates with an int data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 4 bytes (Java int size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setInt(long,int)
     */        
    public void setInt(int value);
        
    /**
     * Returns a long read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 8 bytes (Java long size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getLong(long)
     */     
    public long nextLong();

    /**
     * Updates with a long data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 8 bytes (Java long size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setLong(long,long)
     */        
    public void setLong(long value);
    
    /**
     * Returns a float read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 4 bytes (Java float size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getFloat(long)
     */         
    public float nextFloat();

    /**
     * Updates with a float data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 4 bytes (Java float size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setFloat(long,float)
     */        
    public void setFloat(float value);
    
    /**
     * Returns a double read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 8 bytes (Java double size).  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getDouble(long)
     */    
    public double nextDouble();

    /**
     * Updates with a double data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward 8 bytes (Java double size).
     *
     * @param value the new value to write.
     * @see NativeBuffer#setDouble(long,double)
     */        
    public void setDouble(double value);

    /**
     * Returns a platform address value read from the native memory in
     * the parent buffer address + the current relative position.
     * <p>
     * In a 32 bit platform an int value is read, in a 64 bit will be
     * a long value read. 
     * <p>
     * The iterator is moved forward 4 bytes in 32 bit and 8 bytes if 64 bit.  
     *
     * @return the data read from native memory.
     * @see NativeBuffer#getAddress(long)
     */ 
    public long nextAddress();
  
    /**
     * Updates with a platform address data the native memory in
     * the buffer address + the current relative position.
     * <p>
     * In a 32 bit platform an int value is written, in a 64 bit will be
     * a long value written. 
     * <p>
     * The iterator is moved forward 4 bytes in 32 bit and 8 bytes if 64 bit.  
     *
     * @param value the new value to write.
     * @see NativeBuffer#setAddress(long,long)
     */         
    public void setAddress(long value);
   
    /**
     * Returns a java.lang.String read from the native memory in
     * the buffer address + the current relative position until
     * a '\0' character is found, converting each byte (C char) read 
     * to a Java char.
     * <p>
     * The '\0' finalizer is not assigned to the String.
     * <p>
     * The iterator is moved forward the string length + 1 (the '\0' character) bytes.
     *
     * @return the ANSI String read from native memory.
     * @see NativeBuffer#getAnsiString(long)
     */    
    public String getAnsiString();
    
    /**
     * Writes on the native memory the specified java.lang.String in
     * the buffer address + the current relative position, each character
     * is converted to one byte (C char), the '\0' character is written in the end.
     * <p>
     * The iterator is moved forward the string length + 1 (the '\0' character) bytes. 
     *
     * @param value the new ANSI string to write.
     * @see NativeBuffer#setAnsiString(long,String)
     */       
    public void setAnsiString(String value);    
    
    /**
     * Returns a java.lang.String read from the native memory in
     * the buffer address + the current relative position until
     * a C L'\0' character is found converting each 2 byte (Win32 wchar_t) or 
     * 4 byte (Linux/Mac/Solaris wchar_t) read to a Java char.
     * <p>
     * The '\0' finalizer is not assigned to the String.
     * <p>
     * The iterator is moved forward the string length * sizeof(wchar_t) + sizeof(wchar_t) (the final L'\0' character) bytes.
     *
     * @return the UNICODE String read from native memory.
     * @see NativeBuffer#getUnicodeString(long)
     */    
    public String getUnicodeString();
    
    /**
     * Writes on the native memory the specified java.lang.String in
     * the buffer address + the current relative position, each character
     * is converted to 2 bytes (Win32 wchar_t) or 4 bytes (Linux/Mac/Solaris wchar_t), the L'\0' character is written in the end.
     * <p>
     * The iterator is moved forward the string length * sizeof(wchar_t) + sizeof(wchar_t) (the C L'\0' character) bytes. 
     *
     * @param value the new UNICODE string to write.
     * @see NativeBuffer#setUnicodeString(long,String)
     */     
    public void setUnicodeString(String value);    
        
    /**
     * Returns a java.lang.StringBuffer read from the native memory in
     * the buffer address + the current relative position until
     * a '\0' character is found, converting each byte (C char) read 
     * to a Java char.
     * <p>
     * Current implementation calls
     * {@link #getAnsiString()}
     * and copies it to a new StringBuffer.
     *
     * @return the ANSI StringBuffer read from native memory.
     * @see NativeBuffer#getAnsiStringBuffer(long)
     */    
    public StringBuffer getAnsiStringBuffer();
    
    /**
     * Writes on the native memory the specified java.lang.StringBuffer in
     * the buffer address + the current relative position, each character
     * is converted to one byte (C char), the '\0' character is written in the end.
     * <p>
     * Current implementation gets a String from the StringBuffer and 
     * writes to native memory with {@link #setAnsiString(String)}.
     *
     * @param value the new ANSI string to write.
     * @see NativeBuffer#setAnsiStringBuffer(long,StringBuffer)
     */    
    public void setAnsiStringBuffer(StringBuffer value);
    
    /**
     * Returns a java.lang.StringBuffer read from the native memory in
     * the buffer address + the current relative position until
     * a '\0' character is found, converting each byte (C char) read 
     * to a Java char.
     * <p>
     * Current implementation reads a String with
     * {@link #getUnicodeString()}
     * and copies it to a new StringBuffer.
     *
     * @return the ANSI StringBuffer read from native memory.
     * @see NativeBuffer#getUnicodeStringBuffer(long)
     */
    public StringBuffer getUnicodeStringBuffer();    

    /**
     * Writes on the native memory the specified java.lang.StringBuffer in
     * the buffer address + the current relative position, each character
     * is converted to two bytes (C wchar_t), the C L'\0' character is written in the end.
     * <p>
     * Current implementation gets a String from the StringBuffer and 
     * writes to native memory with {@link #setUnicodeString(String)}.
     *
     * @param value the new UNICODE string to write.
     * @see NativeBuffer#setUnicodeStringBuffer(long,StringBuffer)
     */    
    public void setUnicodeStringBuffer(StringBuffer value);    
    
    
    /**
     * Returns a boolean array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length</code> bytes (Java boolean size is 1 byte).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getBooleanArray(long,boolean[],int,int)
     */      
    public boolean[] nextBooleanArray(boolean[] buff, int index, int length);

    /**
     * Updates with a boolean data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length</code> bytes (Java boolean size is 1 byte).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setBooleanArray(long,boolean[],int,int)
     */    
    public void setBooleanArray(boolean[] value,int index,int length);
    
    /**
     * Returns a byte array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length</code> bytes (Java byte size is 1).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getByteArray(long,byte[],int,int)
     */    
    public byte[] nextByteArray(byte[] buff, int index, int length);
    
    /**
     * Updates with a byte data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length</code> bytes (Java byte size is 1 byte).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setByteArray(long,byte[],int,int)
     */    
    public void setByteArray(byte[] value,int index,int length);
    
    /**
     * Returns a char array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 2</code> bytes (Java char size is 2 bytes).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getCharArray(long,char[],int,int)
     */    
    public char[] nextCharArray(char[] buff, int index, int length);
    
    /**
     * Updates with a char data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 2</code> bytes (Java char size is 2 bytes).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setCharArray(long,char[],int,int)
     */    
    public void setCharArray(char[] value,int index,int length);
    
    /**
     * Returns a short array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 2</code> bytes (Java short size is 2 bytes).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getShortArray(long,short[],int,int)
     */     
    public short[] nextShortArray(short[] buff, int index, int length);
    
    /**
     * Updates with a short data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 2</code> bytes (Java short size is 2 bytes).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setShortArray(long,short[],int,int)
     */    
    public void setShortArray(short[] value,int index,int length);
    
    /**
     * Returns an int array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 4</code> bytes (Java int size is 4 bytes).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getIntArray(long,int[],int,int)
     */     
    public int[] nextIntArray(int[] buff, int index, int length);
    
    /**
     * Updates with an int data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 4</code> bytes (Java int size is 4 bytes).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setIntArray(long,int[],int,int)
     */    
    public void setIntArray(int[] value,int index,int length);
    
    /**
     * Returns a long array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 8</code> bytes (Java long size is 8 bytes).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getLongArray(long,long[],int,int)
     */     
    public long[] nextLongArray(long[] buff, int index, int length);
    
    /**
     * Updates with a long data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 8</code> bytes (Java long size is 8 bytes).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setLongArray(long,long[],int,int)
     */    
    public void setLongArray(long[] value,int index,int length);

    /**
     * Returns a float array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 4</code> bytes (Java float size is 4 bytes).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getFloatArray(long,float[],int,int)
     */    
    public float[] nextFloatArray(float[] buff, int index, int length);
    
    /**
     * Updates with a float data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 4</code> bytes (Java float size is 4 bytes).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setFloatArray(long,float[],int,int)
     */    
    public void setFloatArray(float[] value,int index,int length);
    
    /**
     * Returns a double array read from the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 8</code> bytes (Java double size is 8 bytes).
     *
     * @param buff the array to copy read data. Can not be null.
     * @param index the starting index of <code>buf</code> to copy.
     * @param length the number of elements to be copied.
     * @return the data array read from native memory, the <code>buf</code> parameter.
     * @see NativeBuffer#getDoubleArray(long,double[],int,int)
     */    
    public double[] nextDoubleArray(double[] buff, int index, int length);
    
    /**
     * Updates with a double data array the native memory in
     * the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward <code>length * 8</code> bytes (Java double size is 8 bytes).
     *
     * @param value the source array to write data in native memory. Can not be null.
     * @param index the starting index of <code>value</code> to write.
     * @param length the number of elements to be written.
     * @see NativeBuffer#setDoubleArray(long,double[],int,int)
     */    
    public void setDoubleArray(double[] value,int index,int length);
    
    /**
     * Returns a new native buffer mapping a native memory part of 
     * the buffer. 
     * <p>
     * The returned buffer is ever attached to the native memory (does not own the memory)
     * and is independent of parent buffer (native memory shared is the only one
     * dependency).
     * <p>
     * The iterator is moved forward <code>size</code> bytes.
     *
     * @param size the size of the native memory.
     * @return a new buffer mapping a memory part.
     * @see NativeBuffer#getBuffer(long,long)
     */    
    public NativeBuffer nextBuffer(long size);
    
    /**
     * Copies the native memory data mapped by the specified buffer
     * to this buffer starting in the buffer address + the current relative position.
     * <p>
     * The iterator is moved forward the size of the buffer argument.
     *
     * @param value the native buffer to be copied.
     * @see NativeBuffer#setBuffer(long,NativeBuffer)
     */     
    public void setBuffer(NativeBuffer value);

}
