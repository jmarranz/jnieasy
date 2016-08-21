
#ifndef JNIEasyHelper_h
#define JNIEasyHelper_h

#include "JNIEasy.h"

#ifdef __cplusplus

class JNIEasyHelper
{
private:
	static void* handle; // void* size is platform dependent
	static void* (__stdcall *findExportedMethodAddressPtr)(const char*);

public:
	static void* findExportedMethodAddress(const char* name);
	static void load(); 
	static void unload();
	static bool isLoaded();
	static void* getHandle();
};


#endif /* __cplusplus */


#endif /* JNIEasyHelper_h */



