/* DO NOT EDIT THIS FILE - it is machine generated */
#include <jni.h>
/* Header for class com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative */

#ifndef _Included_com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative
#define _Included_com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative
#ifdef __cplusplus
extern "C" {
#endif
/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative
 * Method:    load
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative_load
  (JNIEnv *, jclass, jstring, jstring);

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative
 * Method:    free
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative_free
  (JNIEnv *, jclass, jlong);

#ifdef __cplusplus
}
#endif
#endif
