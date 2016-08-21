
#ifndef LicenseMgr_h
#define LicenseMgr_h

#include "cross_platform.h"

#include <jni.h>
#include <string>

#ifdef WINDOWS
#include <windows.h>
#endif

inline void initProductData();

class DLLLOCAL LicenseMgr
{
public:
	static jint validate(const char* licenseDir,std::string& licenseId);
	static void setJavaVM(JavaVM* jvm);
	static jint getJVMVersion();

	#ifdef WINDOWS
	static void setDLLHandle(HMODULE hModule);
	#endif

        static void checkLicense(jint action,jint context,jint licType);
};

#endif 
