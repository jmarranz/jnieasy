
#ifndef cross_platform_h
#define cross_platform_h

#include <JNIEasy_shared.h>

#if defined(WIN32) | defined(WIN64)
    #ifndef WINDOWS
        #define WINDOWS
    #endif 
#endif

#if defined(_MSC_VER)

    #define DLLLOCAL

#else // defined(__GNUC__) 

    #if (__GNUC__ >= 4)           
        #define DLLLOCAL  __attribute__ ((visibility("hidden"))) 
    #else
        #define DLLLOCAL 
        // No solo es para evitar warnings tambien es para evitar este error con gcc < 4:
        // http://gcc.gnu.org/bugzilla/show_bug.cgi?id=32462
    #endif

    #define __cdecl   __attribute__((cdecl))
    #define __stdcall __attribute__((stdcall))

#endif


#endif // cross_platform_h
