// JNIEasyLibraryImpl.h: interface for the JNIEasyLibraryImpl class.
//
//////////////////////////////////////////////////////////////////////

#if !defined(AFX_JNIEASYLIBRARYIMPL_H__3D70F1D7_D1A3_481C_9DB6_BA167DFC0194__INCLUDED_)
#define AFX_JNIEASYLIBRARYIMPL_H__3D70F1D7_D1A3_481C_9DB6_BA167DFC0194__INCLUDED_

#if _MSC_VER > 1000
#pragma once
#endif // _MSC_VER > 1000

#include <jni.h>
#include <string>

#include "cross_platform.h"

#include "JavaObjectWrapper.h"


extern "C" JNIEXPORT void* __stdcall findExportedMethodAddress(const char* name);



class DLLLOCAL JNIEasyLibraryImpl : public JavaObjectWrapper
{
public:
	static JNIEasyLibraryImpl* SINGLETON;
protected:
	jmethodID m_methodId;
	jint licenseType;
	std::string licenseId;

public:
	static void registerSelf(JNIEnv* env,jobject dllJNIEasy,jstring licenseDir);
	static void unregisterSelf(JNIEnv* env);
	static void checkLicense(jint action,jint context);

	JNIEasyLibraryImpl(JNIEnv* env,jobject obj,jstring licenseDir);
	virtual ~JNIEasyLibraryImpl();
	jlong findExportedMethodAddress(const char* signature);

	jint getLicenseType()
	{
		return licenseType;
	}

	jstring getLicenseId(JNIEnv* env);

};

#endif // !defined(AFX_JNIEASYLIBRARYIMPL_H__3D70F1D7_D1A3_481C_9DB6_BA167DFC0194__INCLUDED_)
