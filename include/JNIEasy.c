
#include "JNIEasy.h"

#include "JNIEasy_shared.h"

#include <stdio.h>


void* dllHandle = 0;

void* (__stdcall * findExportedMethodAddressPtr)(const char*) = NULL;


void* __stdcall findExportedMethodAddress(const char* signature)
{
	if (dllHandle == 0)
	{
	#if defined(_MSC_VER) || defined(__CYGWIN__) || defined(__MINGW32__) 
		// MSC and MingGW/cygwin
		const char* JNIEasyLibName = "JNIEasy";
	
        #elif defined(__APPLE__) // gcc Mac OS X
		const char* JNIEasyLibName = "libJNIEasy.jnilib";

        #else // gcc Linux
		const char* JNIEasyLibName = "libJNIEasy.so";

	#endif

		dllHandle = (void*)LOAD_LIBRARY(JNIEasyLibName);
		if (dllHandle == NULL)
		{
			printf("findExportedMethodAddress: Unable to load the JNIEasy library: %s\n",JNIEasyLibName);
			return NULL;
		}

		findExportedMethodAddressPtr = (void* (__stdcall *)(const char*))FIND_ENTRY(dllHandle,"findExportedMethodAddress");
	}
	return findExportedMethodAddressPtr(signature);
}


