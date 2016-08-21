
#ifndef JavaCallback_h
#define JavaCallback_h

#include <jni.h>

#include "cross_platform.h"
#include "WeakReference.h"

class JavaCallback;

extern "C"
{
JNIEXPORT void __stdcall onCallVoid(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jboolean __stdcall onCallBoolean(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jbyte __stdcall onCallByte(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jchar __stdcall onCallChar(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jshort __stdcall onCallShort(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jint __stdcall onCallInt(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jlong __stdcall onCallLong(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jfloat __stdcall onCallFloat(JavaCallback* pcb,void* stackAddress);
JNIEXPORT jdouble __stdcall onCallDouble(JavaCallback* pcb,void* stackAddress);
JNIEXPORT void* __stdcall onCallPointer(JavaCallback* pcb,void* stackAddress);
}


class JavaCallback
{
protected:	
	DLLLOCAL static const char* m_javaMethod[];
	DLLLOCAL static const char* m_javaSignature[];
	DLLLOCAL static jmethodID m_javaMethodId[];

	WeakReference* m_weakRef;
	jmethodID m_methodId;
	jint m_returnType;
	jint m_callConv;

public:
	DLLLOCAL JavaCallback(JNIEnv* env,jobject callback,jobject weakRef,jint returnType,jint callConv);
	DLLLOCAL ~JavaCallback();

	DLLLOCAL void free(JNIEnv* env);

	DLLLOCAL static jmethodID getMethodId(JNIEnv* env,jobject callback,jint returnType);

	DLLLOCAL jmethodID getMethodId()
	{
		return m_methodId;
	}

	// Usamos void* en el caso de las direcciones para que el tamaño
	// coincida con el de la plataforma (el tamaño de int no cambia en x86-64)

	void onCallVoid(void* stackAddress);
	jboolean onCallBoolean(void* stackAddress);
	jbyte onCallByte(void* stackAddress);
	jchar onCallChar(void* stackAddress);
	jshort onCallShort(void* stackAddress);
	jint onCallInt(void* stackAddress);
	jlong onCallLong(void* stackAddress);
	jfloat onCallFloat(void* stackAddress);
	jdouble onCallDouble(void* stackAddress);
	void* onCallPointer(void* stackAddress);

	DLLLOCAL static JavaCallback* callbackRegister(JNIEnv* env,jobject callback,jobject weakRef,jint resultType, jint callConv);

	DLLLOCAL static jboolean callbackUnregister(JNIEnv* env,jlong address);

	DLLLOCAL static void* codePattern();
};


#endif
