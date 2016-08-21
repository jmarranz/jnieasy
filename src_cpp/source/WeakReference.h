// WeakReference.h: interface for the WeakReference class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_WEAKREFERENCE_H__0DE718A9_7A8B_46C1_804B_CBE6B0491612__INCLUDED_)
#define AFX_WEAKREFERENCE_H__0DE718A9_7A8B_46C1_804B_CBE6B0491612__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include <jni.h>
#include "JavaObjectWrapper.h"

class DLLLOCAL WeakReference : public JavaObjectWrapper
{
public:
	WeakReference(JNIEnv* env,jobject callback);
	virtual ~WeakReference();

	jobject get(JNIEnv* env); //public Object get(); en la clase Java

protected:
	static jmethodID m_methodId; // Puede ser estático pues no depende del JNIEnv, es decir del hilo
};

#endif // !defined(AFX_WEAKREFERENCE_H__0DE718A9_7A8B_46C1_804B_CBE6B0491612__INCLUDED_)
