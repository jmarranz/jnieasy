
#include "JNIEasyLibraryNative.h"

//#include <windows.h>

#include "JNIEasyLibraryImpl.h"

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative
 * Method:    registerSelf
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative_registerSelf
  (JNIEnv *env, jobject dllJNIEasy,jstring licenseDir)
{
    JNIEasyLibraryImpl::registerSelf(env,dllJNIEasy,licenseDir);
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative
 * Method:    unregisterSelf
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative_unregisterSelf
  (JNIEnv *env, jobject)
{
	JNIEasyLibraryImpl::unregisterSelf(env);
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative
 * Method:    prepare
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative_prepare
  (JNIEnv *, jclass,jint action,jint context)
{
	// El método prepare() es un falso nombre, chequea si la licencia
	// es la adecuada para realizar una operación dada
	JNIEasyLibraryImpl::checkLicense(action,context);
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative
 * Method:    getCode
 * Signature: ()I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative_getCode
  (JNIEnv *, jclass)
{
	// El método prepare() es un falso nombre, devuelve 
	// la licencia que se está usando
	return JNIEasyLibraryImpl::SINGLETON->getLicenseType();
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative
 * Method:    getLicenseId
 * Signature: ()Ljava/lang/String;
 */
JNIEXPORT jstring JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEasyLibraryNative_getLicenseId
  (JNIEnv* env, jclass)
{
	return JNIEasyLibraryImpl::SINGLETON->getLicenseId(env);
}
