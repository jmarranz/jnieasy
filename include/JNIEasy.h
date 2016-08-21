
#ifndef JNIEasy_h
#define JNIEasy_h

#if defined(_MSC_VER) || defined(__CYGWIN__) || defined(__MINGW32__) 
	/* MSC, MinGW and cygwin compilers */

    #define DLLEXPORT __declspec(dllexport)
    #define DLLLOCAL

    #if defined(__CYGWIN__) || defined(__MINGW32__) 
    typedef long long __int64;
    #endif
#else

    #define DLLEXPORT
    #define DLLLOCAL  __attribute__ ((visibility("hidden")))
    #define __cdecl   __attribute__((cdecl))
    #define __stdcall __attribute__((stdcall))
    typedef long long __int64;

#endif



#ifdef __cplusplus
extern "C" {
#endif

void* __stdcall findExportedMethodAddress(const char* name);

#ifdef __cplusplus
} /* extern "C" */
#endif /* __cplusplus */


#define NativeFieldMethod_GET 0
#define NativeFieldMethod_SET 1
#define NativeFieldMethod_GET_SET 2

#ifdef __cplusplus

class NativeFieldMethod
{
public:
	enum /* OPCODES */
	{
	   GET = 0, SET = 1, GET_SET = 2
	};
};

#endif /* __cplusplus */


#endif /* JNIEasy_h */


