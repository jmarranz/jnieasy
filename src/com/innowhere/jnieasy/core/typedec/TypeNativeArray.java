/*
 * TypeNativeArray.java
 *
 * Created on 11 de enero de 2005, 18:22
 */

package com.innowhere.jnieasy.core.typedec;

/**
 * The <code>TypeNativeArray</code> is the interface that represents a native
 * array type declaration using a Java array or a predefined array wrapper 
 * or a user defined array class.
 * <p>
 * Expression syntax if declared the type using a string with
 * {@link NativeTypeManager#dec(String,String[])}
 * and the class used is a:
 * <ul>
 *  <li>Java array: 
 *      <blockquote><code>
 *      <i>ElemClassName</i> [<i>dim1</i>]...[<i>dimN</i>]
 *      </code></blockquote> 
 *      Dimension values are optional (is equivalent to -1, undefined).
 *      <p>
 *      Examples: 
 *      <p>
 *      <code>"int[][]"</code>
 *      <blockquote>Declares a two-dimensional int array with undefined
 *      dimension values.</blockquote>
 *      <p>
 *      <code>"mypkg.MyClass[3][2]"</code>
 *      <blockquote>Declares a two-dimensional mypkg.MyClass array with undefined
 *      dimension values. MyClass elements are "by value".</blockquote>
 *      <p>
 *      <code>"String[-1]"</code>
 *      <blockquote>Declares a String array with undefined length.</blockquote>
 *  </li>
 *  <li>Predefined array wrappers and user defined arrays:
 *      <p>
 *      <ol>
 *        <li>Format:
 *            <blockquote><code>
 *            <i>ClassName</i> [{[<i>dim1</i>[,<i>dim2</i>]...]}]
 *            </code></blockquote>
 *            <p>
 *            The number of dimensions, if declared, must be coincident with the expected 
 *            number of the used class. If declared dimensions, values are
 *            mandatory and may be -1 (undefined).
 *            <p>
 *            Examples: 
 *            <p>
 *            <code>"com.innowhere.jnieasy.core.data.NativeStringArray"</code>
 *            <blockquote>Declares a String array with undefined length.</blockquote>
 * 
 *            <code>"com.innowhere.jnieasy.core.data.NativeStringArray{3}"</code>
 *            <blockquote>Declares a String array with length 3.</blockquote>
 * 
 *            <code>"mypkg.MyMultidimArray"</code>
 *            <blockquote>Declares an array using MyMultidimArray
 *            (must be a user defined array wrapper) using the default
 *            dimensions declared in MyMultidimArray.</blockquote>
 * 
 *            <code>"mypkg.MyMultidimArray{3,2}"</code>
 *            <blockquote>Declares a two-dimensional array using MyMultidimArray
 *            (must be a two-dimensional user defined array wrapper)
 *            and lengths 3 and 2. Default dimensions are not used.</blockquote>
 *        </li>
 *        <li>Format:
 *            <blockquote><code>
 *            <i>ClassName</i> [{<i>VarTypeOfArray</i>}]
 *            </code></blockquote> 
 *            <p>
 *            Examples: 
 *            <p>
 *            <code>"com.innowhere.jnieasy.core.data.ArrayOfArray{int[3][2]}"</code>
 *            <blockquote>Declares a two-dimensional array of int with
 *            lengths 3 and 2.</blockquote>
 *        </li>
 *      </ol>
 *  </li>
 * </ul>
 * Spaces may be used as separators when appropriated.
 * 
 * @author Jose M. Arranz Santamaria
 * @see NativeTypeManager#decArray(Class,int[],VarTypeNative)
 * @see com.innowhere.jnieasy.core.data.NativeArray
 */
public interface TypeNativeArray extends TypeCanBeNativeCapable
{
    /**
     * Returns the native variable type of the "final" elements of the array.
     * <p>
     * For instance: if this native type was created using int[][] class, the 
     * returned native variable type represents the int type.
     *
     * @return the native variable type of final elements.
     */
    public VarTypeNative getLastComponentDec(); 
    
    /**
     * Returns the native variable type of the "immediate" elements of the array
     * as it was a one-dimension array.
     * <p>
     * For instance: if this native type was created using int[][] class, the 
     * returned native variable type represents the int[] type.
     *
     * @return the native variable type of immediate elements.
     */    
    public VarTypeNative getComponentDec();
    
    /**
     * Returns an array with the dimensions of the array.
     * <p>
     * A dimension value of -1 means undefined.
     * <p>
     * Modifications int this array have no effect.
     *
     * @return the dimension array.
     */
    public int[] getDimensions();
    
    /**
     * Returns the length of the array seen as one-dimensional.
     *
     * @return the array length.
     */
    public int getLength();
}
