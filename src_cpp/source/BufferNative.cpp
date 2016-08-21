
#include "cross_platform.h"
#include "BufferNative.h"

#include "UtilJNI.h"

#include <stdlib.h> // incluye malloc.h que no esta definido en el gcc Mac OS X
#include <memory.h>
#include <string.h>
#include <wchar.h>

#if defined(__APPLE__)
#include <stdio.h>
#include <unistd.h>
#include <sys/mman.h>
#include <sys/user.h>
#include <sys/types.h>
#include <sys/fcntl.h>
#include <signal.h>
#endif


#ifdef WINDOWS
#include <windows.h>
#else
#include <sys/mman.h>
#endif


/********************************************************************/
/*		     Native methods of class Buffer		    */
/********************************************************************/

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    malloc
 * Signature: (JZ)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_malloc
  (JNIEnv *env, jclass cls, jlong size, jboolean executable)
{
	void* address = NULL;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
            // De ambas formas se inicializa la memoria a cero, así evitamos comportamientos impredecibles (punteros con valores aleatorios por ejemplo)
            if (executable)
            {
                #ifdef WINDOWS

                    address = ::VirtualAlloc(NULL,size,MEM_COMMIT,PAGE_EXECUTE_READWRITE); 

                #else

                    address = ::calloc(size,1);

                #endif

            }
            else address = ::calloc(size,1); // malloc(size);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error freeing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error freeing native memory");
	}
#endif

	return (jlong)address;

	/* El caso ejectable permite que el buffer reservado pueda ejecutarse
	   en procesadores de 64 bits con bit de protección x86_64 (AMD64, Intel EMT64) 
	   y tal bit activado por ejemplo en WindowsXP Service Pack 2 :
	   Panel de Control/Sistema/Opciones Avanzadas/Rendimiento(Configuración)
	   /Prev. de ejecución de datos

	  http://starship.python.net/crew/theller/ctypes/ (ver Older News)
	  http://dotnetjunkies.com/WebLog/sriram/archive/2004/12/29/39680.aspx
	  http://www.devx.com/amd/Article/27809  
	  http://www.microsoft.com/technet/prodtechnol/winxppro/maintain/sp2mempr.mspx

	  En el artículo de Microsoft se habla de VirtualAlloc como alternativa a malloc() 
	*/
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    free
 * Signature: (JZ)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_free
  (JNIEnv *env, jclass cls,jlong address,jboolean executable)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
            if (executable)
            {
                #ifdef WINDOWS
                    BOOL res = ::VirtualFree((void*)address,0,MEM_RELEASE);
                    if (res == 0)
                            ThrowNativeException(env,"VirtualFree error");

                #else 

                    free((void*)address);   // Provisional hasta que se pruebe el NX bit

                #endif
            }
            else free((void*)address);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error freeing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error freeing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    realloc
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_realloc
  (JNIEnv* env, jclass, jlong address, jlong size)
{
	void* newAddress;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		// NO llamar en el caso de memoria creada por VirtualAlloc
		// pues sólo vale si fue creada por malloc o calloc
		newAddress = ::realloc((void*)address,size);
		
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error freeing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error freeing native memory");
	}
#endif

	return (jlong)newAddress;
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getByte
 * Signature: (JJ)B
 */
JNIEXPORT jbyte JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getByte
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
	jbyte res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res, (void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
	return res;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getBoolean
 * Signature: (JJ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getBoolean
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jboolean res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res,(void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getChar
 * Signature: (JJ)C
 */
JNIEXPORT jchar JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getChar
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jchar res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res,(void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getShort
 * Signature: (JJ)S
 */
JNIEXPORT jshort JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getShort
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jshort res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res, (void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getInt
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getInt
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jint res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res, (void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getLong
 * Signature: (JJ)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getLong
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jlong res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res, (void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getFloat
 * Signature: (JJ)F
 */
JNIEXPORT jfloat JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getFloat
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jfloat res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res, (void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}
/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getDouble
 * Signature: (JJ)D
 */
JNIEXPORT jdouble JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getDouble
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
    jdouble res;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy(&res, (void*)(address + offset), sizeof(res));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
    return res;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getStringLength
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getStringLength
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
	jint len;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jbyte* peer = (jbyte*)address;
		len = strlen((const char*)(peer + offset));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
	return len;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getStringUnicodeLength
 * Signature: (JJ)I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getStringUnicodeLength
  (JNIEnv *env, jclass,jlong address, jlong offset)
{
	jint len;

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jbyte* peer = (jbyte*)address;
		len = wcslen((const wchar_t*)(peer + offset));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
	return len;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getBooleanArray
 * Signature: (JJ[ZII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getBooleanArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jbooleanArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jboolean *peer = (jboolean *)address;
		env->SetBooleanArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getByteArray
 * Signature: (JJ[BII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getByteArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jbyteArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jbyte *peer = (jbyte *)address;
		env->SetByteArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getCharArray
 * Signature: (JJ[CII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getCharArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jcharArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jchar *peer = (jchar *)address;
		env->SetCharArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getShortArray
 * Signature: (JJ[SII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getShortArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jshortArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jshort *peer = (jshort *)address;
		env->SetShortArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}



/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getIntArray
 * Signature: (JJ[III)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getIntArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jintArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jint *peer = (jint *)address;
		env->SetIntArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getLongArray
 * Signature: (JJ[JII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getLongArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jlongArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jlong *peer = (jlong *)address;
		env->SetLongArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getFloatArray
 * Signature: (JJ[FII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getFloatArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jfloatArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jfloat *peer = (jfloat *)address;
		env->SetFloatArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    getDoubleArray
 * Signature: (JJ[DII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_getDoubleArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jdoubleArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jdouble *peer = (jdouble *)address;
		env->SetDoubleArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setByte
 * Signature: (IIB)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setByte
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jbyte value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setBoolean
 * Signature: (IIZ)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setBoolean
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jboolean value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setChar
 * Signature: (IIC)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setChar
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jchar value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setShort
 * Signature: (IIS)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setShort
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jshort value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setInt
 * Signature: (III)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setInt
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jint value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setLong
 * Signature: (IIJ)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setLong
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jlong value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setFloat
 * Signature: (IIF)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setFloat
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jfloat value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setDouble
 * Signature: (IID)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setDouble
  (JNIEnv *env, jclass cls,jlong address, jlong offset, jdouble value)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		memcpy((void*)(address + offset), &value, sizeof(value));
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setBooleanArray
 * Signature: (JJ[ZII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setBooleanArray
  (JNIEnv *env, jclass cls, jlong address,jlong boff, jbooleanArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jboolean *peer = (jboolean *)address;
		env->GetBooleanArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setByteArray
 * Signature: (JJ[BII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setByteArray
  (JNIEnv *env, jclass cls, jlong address,jlong boff, jbyteArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jbyte *peer = (jbyte *)address;
		env->GetByteArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setCharArray
 * Signature: (JJ[CII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setCharArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jcharArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jchar *peer = (jchar *)address;
		env->GetCharArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setShortArray
 * Signature: (JJ[SII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setShortArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jshortArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jshort *peer = (jshort *)address;
		env->GetShortArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setIntArray
 * Signature: (JJ[III)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setIntArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jintArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jint *peer = (jint *)address;
		env->GetIntArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setLongArray
 * Signature: (JJ[JII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setLongArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jlongArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jlong *peer = (jlong *)address;
		env->GetLongArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setFloatArray
 * Signature: (JJ[FII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setFloatArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jfloatArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jfloat *peer = (jfloat *)address;
		env->GetFloatArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    setDoubleArray
 * Signature: (JJ[DII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_setDoubleArray
  (JNIEnv *env, jclass cls,jlong address, jlong boff, jdoubleArray arr, jint index, jint n)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jdouble *peer = (jdouble *)address;
		env->GetDoubleArrayRegion(arr, index, n, peer + boff);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_BufferNative
 * Method:    copyFrom
 * Signature: (IIII)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_BufferNative_copyFrom
  (JNIEnv *env,jclass cls,jlong address,jlong offset,jlong sourceAddr,jlong length)
{

#ifdef WINDOWS
	__try
#else
	try
#endif
	{
		jbyte *peer = (jbyte *)address;
		memcpy(peer + offset, (void*)sourceAddr, length);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		ThrowNativeWindowsException(env,"Error accessing native memory",::GetExceptionCode());
	}
#else
	catch(...)
	{
		ThrowNativeException(env,"Error accessing native memory");
	}
#endif
}



#if defined(__APPLE__)

    void* mallocExecutableMemoryMac(jlong size)
    {
        // NO SE USA 
        // y no se si es del todo correcto, pero es un punto de partida
        // para cuando calloc/free den problemas en Mac.

        // http://www.maccompanion.com/macc/archives/November2007/Columns/AccordingtoHoyle27.htm
        // http://developer.apple.com/documentation/Darwin/Reference/ManPages/man2/mmap.2.html
        // http://linux.die.net/man/3/mmap
        // http://developer.apple.com/DOCUMENTATION/Darwin/Reference/ManPages/man2/mprotect.2.html
        // http://fscked.org/writings/SHM/shm-4.html
        // http://safari.oreilly.com/0735710430/ch08lev1sec9

        // Como necesitamos almacenar el tamaño para el posterior free
        // incrementamos size para albergar al ppio dicho valor

        size += sizeof(jlong);

        jlong PAGE_SIZE = sysconf(_SC_PAGE_SIZE);
        jlong mod = (size % PAGE_SIZE);
        if (mod != 0)
            size += PAGE_SIZE - mod; 

        void* address = mmap(NULL, size, PROT_READ | PROT_WRITE | PROT_EXEC, 
                    MAP_PRIVATE | MAP_ANON, -1, 0); // MAP_PRIVATE MAP_SHARED

        if (address == MAP_FAILED)
        {
            address = 0;
            printf("mmap FAILED %d %s \n",errno,strerror(errno));
        }
        else
        {
            // Necesitamos guardar la memoria usada para el free al ppio
            *((jlong*)address) = size;

            // Para proteger el size devolvemos el address tras el valor
            address = (void*) (((jlong)address) + sizeof(jlong));
        }
        return address;
    }

    void freeExecutableMemoryMac(jlong address)
    {
        // NO SE USA 
        // y no se si es del todo correcto, pero es un punto de partida
        // para cuando calloc/free den problemas en Mac.

        // Sabemos que address está desplazada para albergar el size
        address = ((jlong)address) - sizeof(jlong);
        jlong size = *((jlong*)address);

        if(munmap((void*)address, size) == -1)
        {
            printf("munmap FAILED \n");
            raise(SIGSEGV);
        }

        if(mmap((void*)address, size, PROT_NONE,MAP_ANON | MAP_FIXED | MAP_PRIVATE, 0, 0) == MAP_FAILED)
        {
            printf("mmap anon FAILED");
        }                   
    }

#endif // defined(__APPLE__)
