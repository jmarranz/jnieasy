
#include "cross_platform.h"
#include "DynamicLibraryNative.h"
#include <string>


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative
 * Method:    load
 * Signature: (Ljava/lang/String;Ljava/lang/String;)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative_load
  (JNIEnv *env, jclass cls, jstring dll,jstring platformDLL)
{
	const char* platformDLLName = env->GetStringUTFChars(platformDLL, NULL);

	// platformDLLName ya viene preparado para cargarse con .dll en caso 
	// de Windows y libNombre.so en Linux y Solaris
	// En el caso de Windows LoadLibrary funciona sin añadir .dll, en Linux no.
	void* libHandle;

	libHandle = LOAD_LIBRARY(platformDLLName); 

	if (libHandle == NULL)
	{
	#ifndef WINDOWS
		std::string errorMsg = dlerror(); // mostraremos luego si falla la segunda oportunidad
	#endif

		const char* dllName = env->GetStringUTFChars(dll, NULL);

		// Segunda oportunidad con dllName, el nombre original

		libHandle = LOAD_LIBRARY(dllName);

	#ifndef WINDOWS
		if (libHandle == NULL)
		{		
			// Mostramos que los dos intentos han sido fallidos (el mensaje de error del sistema puede ser útil, de otra manera lo perdemos)
			const char* errorMsg2 = dlerror();
			printf(errorMsg.data()); printf("\n");
			printf(errorMsg2); printf("\n");
		}
	#endif

		env->ReleaseStringUTFChars(dll,dllName); 
	}

	env->ReleaseStringUTFChars(platformDLL,platformDLLName); 

    return (jlong)libHandle;
}

/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative
 * Method:    free
 * Signature: (J)Z
 */
JNIEXPORT jboolean JNICALL Java_com_innowhere_jnieasy_core_impl_jni_DynamicLibraryNative_free
  (JNIEnv *, jclass, jlong handle)
{
	jint res = FREE_LIBRARY(handle);
	return (jboolean)res;
}

