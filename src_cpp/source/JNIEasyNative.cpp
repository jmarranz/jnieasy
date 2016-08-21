
#include "JNIEasyNative.h"

//#include "load.h"

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getPlatformAddressSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getPlatformAddressSize
  (JNIEnv *, jclass)
{
	return sizeof(void*);
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getWideCharTSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getWideCharTSize
  (JNIEnv *, jclass)
{
	return sizeof(wchar_t);
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    compiledWithMSVC
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_compiledWithMSVC
  (JNIEnv *, jclass)
{
// Podría usarse también la macro __GNUC__
#ifdef _MSC_VER
	return true;
#else
	return false;
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    isMacOSX
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_isMacOSX
  (JNIEnv *, jclass)
{
#ifdef __APPLE__
	return true;
#else
	return false;
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    isWindows
 * Signature: ()Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_isWindows
  (JNIEnv *, jclass)
{
    #ifdef _MSC_VER
        // Por ahora sólo se compila la versión Windows de JNIEasy.dll con Visual C++
        return true;
    #else
        return false;
    #endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJBooleanAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJBooleanAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jboolean);
#else
	return __alignof__(jboolean);
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJByteAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJByteAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jbyte);
#else
	return __alignof__(jbyte);
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJCharAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJCharAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jchar);
#else
	return __alignof__(jchar);
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJShortAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJShortAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jshort);
#else
	return __alignof__(jshort);
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJIntAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJIntAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jint);
#else
	return __alignof__(jint);
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJLongAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJLongAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jlong);
#else
	return __alignof__(jlong);
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJFloatAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJFloatAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jfloat);
#else
	return __alignof__(jfloat);
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    getJDoubleAlignSize
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_getJDoubleAlignSize
  (JNIEnv *, jclass)
{
#ifdef _MSC_VER
	return  __alignof (jdouble);
#else
	return __alignof__(jdouble);
#endif
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyNative
 * Method:    testFunc
 * Signature: (I)I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyNative_testFunc
  (JNIEnv *, jclass, jint param)
{
    return param;
}
