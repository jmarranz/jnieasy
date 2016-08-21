
#ifndef load_h
#define load_h


#include <jni.h>

JavaVM* getJavaVM();

#ifdef WINDOWS

#include <windows.h>

HINSTANCE getDLLInstance();
void setDLLInstance(HINSTANCE handle);

#endif // WINDOWS


#endif
