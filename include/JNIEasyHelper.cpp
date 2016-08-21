
#include "JNIEasyHelper.h"

#include "JNIEasy_shared.h"

#include <stdlib.h> // Defines NULL in Linux
#include <stdio.h>

#ifdef __cplusplus

void* JNIEasyHelper::handle = 0;

void* (__stdcall * JNIEasyHelper::findExportedMethodAddressPtr)(const char*) = NULL;


void* JNIEasyHelper::findExportedMethodAddress(const char* signature)
{
        load();

	return findExportedMethodAddressPtr(signature);
}

void JNIEasyHelper::load()
{
	if (handle == 0)
	{
	#if defined(_MSC_VER) || defined(__CYGWIN__) || defined(__MINGW32__) 
		// MSC and MingGW
		const char* JNIEasyLibName = "JNIEasy";
        #elif defined(__APPLE__) // Mac OS X
		const char* JNIEasyLibName = "libJNIEasy.jnilib";

        #else // Linux y Solaris
		const char* JNIEasyLibName = "libJNIEasy.so";

	#endif

		handle = (void*)LOAD_LIBRARY(JNIEasyLibName);
		if (handle == NULL)
		{
			printf("findExportedMethodAddress: Unable to load the JNIEasy library: %s\n",JNIEasyLibName);
			return;
		}
		
		findExportedMethodAddressPtr = (void* (__stdcall *)(const char*))FIND_ENTRY(handle,"findExportedMethodAddress");
	}
}

void JNIEasyHelper::unload()
{
	if (handle != 0)
	{
		FREE_LIBRARY(handle);
		handle = 0;
	}
}

bool JNIEasyHelper::isLoaded()
{
	return (handle != 0);
}

void* JNIEasyHelper::getHandle()
{
	return handle;
}

#endif /* __cplusplus */
