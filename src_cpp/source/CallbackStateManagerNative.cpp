
#include "CallbackStateManagerNative.h" // Generado por javah

#include "JavaCallback.h"

/*
extern "C" __declspec(dllexport) void __stdcall PRUEBA(char c);
//{
  //printf("%d",c);
//}

extern "C" __declspec(dllexport) void __stdcall PRUEBA2()
{
  PRUEBA('a');
}

extern "C" void asm_dispatch_PRUEBA(  void *func,
                    jint stackParamSize,		  
                    void* args,
                    jint res_type,
                    void* resP,
                    jint conv)
{
    printf("%d",conv);
    func = NULL;
    stackParamSize = 1;
    args = NULL;
    res_type = 2;
    resP = NULL;
    conv = 3;
}
*/


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_CallbackStateManagerNative
 * Method:    registerInDLL
 * Signature: (Ljava/lang/ref/WeakReference;II)J
 */
JNIEXPORT jlong JNICALL Java_com_innowhere_jnieasy_core_impl_jni_CallbackStateManagerNative_registerInDLL
  (JNIEnv* env, jobject callback,jobject weakRef,jint returnType,jint callConv)
{
	return (jlong)JavaCallback::callbackRegister(env,callback,weakRef,returnType,callConv);
}


/*
 * Class:     com_innowhere_jnieasy_core_impl_jni_CallbackStateManagerNative
 * Method:    unregisterInDLL
 * Signature: (J)V
 */
JNIEXPORT void JNICALL Java_com_innowhere_jnieasy_core_impl_jni_CallbackStateManagerNative_unregisterInDLL
  (JNIEnv* env, jclass, jlong address)
{
	JavaCallback::callbackUnregister(env,address);
}

