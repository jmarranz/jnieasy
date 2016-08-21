
#ifndef UtilJNI_h
#define UtilJNI_h

#include <jni.h>

jboolean checkException(JNIEnv* env);

void ThrowByName(JNIEnv *env, const char *name, const char *msg);

void ThrowNativeWindowsException(JNIEnv *env, const char *msg,jint code);

void ThrowNativeException(JNIEnv *env, const char *msg);

JNIEnv* getJNIEnv();

#endif
