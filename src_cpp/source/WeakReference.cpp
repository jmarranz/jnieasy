// WeakReference.cpp: implementation of the WeakReference class.
//
//////////////////////////////////////////////////////////////////////

#include "WeakReference.h"


//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

jmethodID WeakReference::m_methodId = NULL;

WeakReference::WeakReference(JNIEnv* env,jobject obj)
: JavaObjectWrapper(env,obj)
{
	// Ojo, m_obj es una WeakReference pero desde los demás puntos de vista es un objeto normal

	jclass weakRefClass = env->GetObjectClass(obj); // clase WeakReference
	jclass refClass = env->GetSuperclass(weakRefClass); // clase Reference (la que tiene el método get)

	if (m_methodId == NULL)
	{
		const char* methodName = "get";
		const char* signature = "()Ljava/lang/Object;";
		m_methodId = env->GetMethodID(refClass,methodName,signature);
	}
}


WeakReference::~WeakReference()
{
}

jobject WeakReference::get(JNIEnv* env)
{
	return env->CallObjectMethod(m_obj,m_methodId);
}

