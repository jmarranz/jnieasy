
#ifndef JNIEasy_shared_h
#define JNIEasy_shared_h

#if defined(_MSC_VER) || defined(__CYGWIN__) || defined(__MINGW32__) 
	/* MSC and MinGW compilers */

	#include <windows.h>

	#define LOAD_LIBRARY(name) LoadLibrary(name)
	#define FIND_ENTRY(lib, name) GetProcAddress((HINSTANCE)lib, name)
	#define FREE_LIBRARY(lib) FreeLibrary((HINSTANCE)lib)

#else

	#include <dlfcn.h>
	#define LOAD_LIBRARY(name) dlopen(name, RTLD_LAZY)
	#define FIND_ENTRY(lib, name) dlsym((void*)lib, name)
	#define FREE_LIBRARY(lib) dlclose((void*)lib)

#endif



#endif /* JNIEasy_shared_h */
