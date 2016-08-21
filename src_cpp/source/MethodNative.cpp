#include "cross_platform.h"

#include "MethodNative.h"

#ifdef WINDOWS
#include <windows.h>
#endif

#include "UtilJNI.h"


#include "Util.h"

#include "consts.h"

#include "asm_dispatch.h"

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    find
 * Signature: (JLjava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_find
  (JNIEnv *env, jclass self, jlong libHandle, jstring fun)
{
	const char* funname = env->GetStringUTFChars(fun, NULL);

	void* funcHandle = FIND_ENTRY(libHandle,funname);

	env->ReleaseStringUTFChars(fun,funname); 

    return (jlong)funcHandle;
}

// stackParamSize es el número "words" de la plataforma (32 bits en x86) contenidos en args
// En el futuro podría obtenerse info de
// LPEXCEPTION_POINTERS GetExceptionInformation(void);


void callGeneric(JNIEnv *env,jlong faddress,jint typeRes,jvalue* res,jlong argsAddr,jint conv,jlong stackParamSize)
{
#ifdef WINDOWS
	__try
#else
	try
#endif
	{

            // El cast de stackParamSize a jint nunca dará problemas
            asm_dispatch((void*)faddress,(jint)stackParamSize,(void*)argsAddr,typeRes,(void*)res,conv);
	}
#ifdef WINDOWS
	__except (EXCEPTION_EXECUTE_HANDLER)
	{
		if (!checkException(env))
		{
			// Es un error seguramente de código máquina en una DLL
			ThrowNativeWindowsException(env,"Error executing native function",::GetExceptionCode());
		}
	}
#else
	catch(...)
	{
		// RESTAURAR: ThrowNativeException(env,"Error executing native function");
	}
#endif
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callVoid
 * Signature: (JIJJ)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callVoid
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaVOID,&res,argsAddr,conv,stackParamSize);
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callBoolean
 * Signature: (JIJJ)Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callBoolean
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaBOOLEAN,&res,argsAddr,conv,stackParamSize);

	return res.z;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callByte
 * Signature: (JIJJ)B
 */
JNIEXPORT jbyte JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callByte
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaBYTE,&res,argsAddr,conv,stackParamSize);

	return res.b;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callChar
 * Signature: (JIJJ)C
 */
JNIEXPORT jchar JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callChar
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaCHAR,&res,argsAddr,conv,stackParamSize);

	return res.c;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callShort
 * Signature: (JIJJ)S
 */
JNIEXPORT jshort JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callShort
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaSHORT,&res,argsAddr,conv,stackParamSize);

	return res.s;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callInt
 * Signature: (JIJJ)I
 */
JNIEXPORT jint JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callInt
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaINT,&res,argsAddr,conv,stackParamSize);

	return res.i;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callLong
 * Signature: (JIJJ)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callLong
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaLONG,&res,argsAddr,conv,stackParamSize);

	return res.j;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callFloat
 * Signature: (JIJJ)F
 */
JNIEXPORT jfloat JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callFloat
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaFLOAT,&res,argsAddr,conv,stackParamSize);

	return res.f;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_MethodNative
 * Method:    callDouble
 * Signature: (JIJJ)D
 */
JNIEXPORT jdouble JNICALL Java_com_innowhere_jnieasy_core_impl_jni_MethodNative_callDouble
  (JNIEnv *env,jclass,jlong faddress,jint conv,jlong argsAddr,jlong stackParamSize)
{
	jvalue res;

	callGeneric(env,faddress,JavaDOUBLE,&res,argsAddr,conv,stackParamSize);

	return res.d;
}

