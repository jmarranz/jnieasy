
#include "UtilJNI.h"

#include "load.h"

const char* JNIEasyWindowsExceptionClassName = "com/innowhere/jnieasy/core/JNIEasyWin32Exception";
const char* JNIEasyNativeExceptionClassName = "com/innowhere/jnieasy/core/JNIEasyNativeException";


jboolean checkException(JNIEnv* env)
{
	// Después de toda llamada JNI es conveniente detectar si se ha producido
	// una excepción para lanzarla desde código nativo (el mecanismo de C++
	// es diferente al de Java).
	jthrowable ex = env->ExceptionOccurred();
	if (ex != NULL)
	{
		//env->ExceptionDescribe(); // Sale por la consola Java
		//env->ExceptionClear();
		//ThrowNativeWindowsException(env,"Thrown from native code");
		return true;
	}
	return false;
}


/* Throw an exception by name */
void ThrowByName(JNIEnv *env, const char *name, const char *msg)
{
    jclass cls = env->FindClass(name);

    env->ThrowNew(cls, msg);

    /* It's a good practice to clean up the local references. */
    env->DeleteLocalRef(cls);
}

void ThrowNativeWindowsException(JNIEnv *env, const char *msg,jint code)
{
    jclass cls = env->FindClass(JNIEasyWindowsExceptionClassName);

	jmethodID methodID = env->GetMethodID(cls,"<init>","(Ljava/lang/String;I)V");

	jstring message = env->NewStringUTF(msg); 

	jthrowable ex = (jthrowable)env->NewObject(cls,methodID,message,code); 
    env->Throw(ex);

    /* It's a good practice to clean up the local references. */
    env->DeleteLocalRef(cls);
}


void ThrowNativeException(JNIEnv *env, const char *msg)
{
    jclass cls = env->FindClass(JNIEasyNativeExceptionClassName);

	jmethodID methodID = env->GetMethodID(cls,"<init>","(Ljava/lang/String;)V");

	jstring message = env->NewStringUTF(msg); 

	jthrowable ex = (jthrowable)env->NewObject(cls,methodID,message); 
    env->Throw(ex);

    // It's a good practice to clean up the local references.
    env->DeleteLocalRef(cls);
}


JNIEnv* getJNIEnv()
{
	static jint jvmVersion = JNI_VERSION_1_4; // Por defecto

	JNIEnv* env = NULL;
	JavaVM* jvm = getJavaVM();
	jvm->GetEnv((void**)&env,jvmVersion);
	if (env == NULL)
	{
		jint res = jvm->AttachCurrentThread((void**)&env,NULL);
		if (res != 0) return NULL;
	}

	return env;
}

