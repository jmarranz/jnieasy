// JavaObjectWrapper.cpp: implementation of the JavaObjectWrapper class.
//
//////////////////////////////////////////////////////////////////////

#include "JavaObjectWrapper.h"

#include "load.h"

#include "UtilJNI.h"

//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

JavaObjectWrapper::JavaObjectWrapper(JNIEnv* env,jobject obj)
{
	m_obj = env->NewGlobalRef(obj); 
}

JavaObjectWrapper::~JavaObjectWrapper()
{
	if (m_obj != NULL)
		free(getJNIEnv());
}

void JavaObjectWrapper::free(JNIEnv* env)
{
	env->DeleteGlobalRef(m_obj);
	m_obj = NULL;
}

