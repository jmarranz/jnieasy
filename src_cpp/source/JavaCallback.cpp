
#include "JavaCallback.h"

#include "load.h"
#include "UtilJNI.h"

void __stdcall onCallVoid(JavaCallback* pcb,void* stackAddress)
{
    pcb->onCallVoid(stackAddress);
}

jboolean __stdcall onCallBoolean(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallBoolean(stackAddress);
}

jbyte __stdcall onCallByte(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallByte(stackAddress);
}

jchar __stdcall onCallChar(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallChar(stackAddress);
}

jshort __stdcall onCallShort(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallShort(stackAddress);
}

jint __stdcall onCallInt(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallInt(stackAddress);
}

jlong __stdcall onCallLong(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallLong(stackAddress);
}

jfloat __stdcall onCallFloat(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallFloat(stackAddress);
}

jdouble __stdcall onCallDouble(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallDouble(stackAddress);
}

void* __stdcall onCallPointer(JavaCallback* pcb,void* stackAddress)
{
    return pcb->onCallPointer(stackAddress);
}


const char* JavaCallback::m_javaMethod[] = 
	{ 
		NULL,			// 0
		"onCallVoid",		// 1
		"onCallBoolean",
		"onCallByte",
		"onCallChar",
		"onCallShort",
		"onCallInt",
		"onCallLong",
		"onCallFloat",
		"onCallDouble",	// 9
		"onCallPointer" // 10
	};

const char* JavaCallback::m_javaSignature[] = 
	{ 
		NULL,		// 0
		"(J)V",		// 1
		"(J)Z",
		"(J)B",
		"(J)C",
		"(J)S",
		"(J)I",
		"(J)J",
		"(J)F",
		"(J)D",		// 9
		"(J)J",		// 10
	};

jmethodID JavaCallback::m_javaMethodId[] = 
	{ 
		NULL,		// 0
		NULL,		// 1
		NULL,
		NULL,
		NULL,
		NULL,
		NULL,
		NULL,
		NULL,
		NULL,		// 9
		NULL,		// 10
	};


JavaCallback* JavaCallback::callbackRegister(JNIEnv* env,jobject callback,jobject weakRef,jint resultType,jint callConv)
{
	JavaCallback* cbData = new JavaCallback(env,callback,weakRef,resultType,callConv);
	return cbData;
}


jboolean JavaCallback::callbackUnregister(JNIEnv* env,jlong address)
{
	JavaCallback* jcallback = (JavaCallback*)address;
	if (jcallback != NULL) 
	{
		jcallback->free(env);
		delete jcallback;
		return true;
	}
	return false;
}

jmethodID JavaCallback::getMethodId(JNIEnv* env,jobject callback,jint returnType)
{
	jmethodID mId = m_javaMethodId[returnType];
	if (mId == NULL)
	{
		// La clase es siempre la misma:
		// com.innowhere.jnieasy.core.impl.jni.CallbackStateManagerJNI
		// ReturnType callReturnTypeCallConv(int stackAddress)

		const char* methodName = m_javaMethod[returnType];
		const char* signature = m_javaSignature[returnType];

		jclass clazz = env->GetObjectClass(callback);

		mId = env->GetMethodID(clazz,methodName,signature);
		m_javaMethodId[returnType] = mId; // Podemos recordar el jmethodID pues no depende del JNIEnv (es decir, del hilo)
	}
	return mId;
}

JavaCallback::JavaCallback(JNIEnv* env,jobject callback,jobject weakRef,jint returnType,jint callConv)
{
	m_weakRef = new WeakReference(env,weakRef); 

	m_returnType = returnType;
	m_callConv = callConv;

	m_methodId = getMethodId(env,callback,returnType);
}

JavaCallback::~JavaCallback()
{
	delete m_weakRef;
}

void JavaCallback::free(JNIEnv* env)
{
	m_weakRef->free(env);
}

void JavaCallback::onCallVoid(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	env->CallVoidMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
}

jboolean JavaCallback::onCallBoolean(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jboolean res = env->CallBooleanMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jbyte JavaCallback::onCallByte(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jbyte res = env->CallByteMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jchar JavaCallback::onCallChar(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jchar res = env->CallCharMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jshort JavaCallback::onCallShort(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jshort res = env->CallShortMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jint JavaCallback::onCallInt(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jint res = env->CallIntMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jlong JavaCallback::onCallLong(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();

	jobject callback = m_weakRef->get(env);

	jlong res = env->CallLongMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jfloat JavaCallback::onCallFloat(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jfloat res = env->CallFloatMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

jdouble JavaCallback::onCallDouble(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jdouble res = env->CallDoubleMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return res;
}

void* JavaCallback::onCallPointer(void* stackAddress)
{
	JNIEnv* env = getJNIEnv();
	jobject callback = m_weakRef->get(env);

	jlong res = env->CallLongMethod(callback,m_methodId,stackAddress);

	if (callback != NULL) env->DeleteLocalRef(callback);
	return (void*)res;
}

