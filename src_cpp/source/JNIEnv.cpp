// JNIEnv.cpp: implementation of the JNIEnv class.
//
//////////////////////////////////////////////////////////////////////

#include "JNIEnv.h"

/* NO SE USAN ES EXPERIMENTAL con la finalidad de conseguir usar JNI
lo menos posible */

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEnv
 * Method:    getAddressCallIntMethod
 * Signature: ()I
 */
/*
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEnv_getAddressCallIntMethod
  (JNIEnv *, jclass)
{
	jint (__cdecl JNIEnv:: *pf)(class _jobject *,struct _jmethodID *,...);
	pf = JNIEnv::CallIntMethod;
	jint res;
	__asm
	{
		mov eax,pf
		mov res,eax
	}
	
	return res;
}
*/

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEnv
 * Method:    NewGlobalRef
 * Signature: (Ljava/lang/Object;)I
 */

JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEnv_NewGlobalRef
  (JNIEnv *env, jclass, jobject lobj)
{
	//jobject gobj = env->NewGlobalRef(lobj);
	return 0; //(jint)gobj;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_JNIEnv
 * Method:    DeleteGlobalRef
 * Signature: (I)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_JNIEnv_DeleteGlobalRef
  (JNIEnv *env, jclass, jint gref)
{
	//env->DeleteGlobalRef((jobject)gref);
}

