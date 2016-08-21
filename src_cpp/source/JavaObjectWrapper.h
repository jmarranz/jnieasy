// JavaObjectWrapper.h: interface for the JavaObjectWrapper class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_JAVAOBJECTWRAPPER_H__0422B99C_E0C5_4FCA_B8A7_582C6B09EB91__INCLUDED_)
#define AFX_JAVAOBJECTWRAPPER_H__0422B99C_E0C5_4FCA_B8A7_582C6B09EB91__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include <jni.h>
#include "cross_platform.h"


class DLLLOCAL JavaObjectWrapper  
{
public:
	JavaObjectWrapper(JNIEnv* env,jobject obj);
	virtual ~JavaObjectWrapper();
	virtual void free(JNIEnv* env);

protected:
	jobject m_obj;
};

#endif // !defined(AFX_JAVAOBJECTWRAPPER_H__0422B99C_E0C5_4FCA_B8A7_582C6B09EB91__INCLUDED_)
