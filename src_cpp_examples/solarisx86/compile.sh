#!/bin/sh

cd $BUILD_DIR_TEST

GCC_SOLARIS=/usr/sfw/bin/gcc
GPP_SOLARIS=/usr/sfw/bin/g++

GCC_EXEC_PREFIX=/usr/sfw/bin/gcc
export GCC_EXEC_PREFIX

GCC_OPTIONS="-c -O2 -malign-double -fPIC -Wall -I../../include" 

rm *.o
$GCC_SOLARIS $GCC_OPTIONS `cat ../../src_cpp_examples/cpp_source_files.txt` 

rm libMyLibrary.so
$GPP_SOLARIS -shared -o libMyLibrary.so  -Wall *.o -L../../bin/solarisx86 -lJNIEasy -lstdc++ -ldl

# Note: libJNIEasy.so is linked too (param -lJNIEasy) as a workaround of a Solaris x86 or Java on Solaris bug, 
# Java crash when unloads if libJNIEasy.so was loaded dynamically from libMyLibrary.so using dlopen (JNIEasyHelper::load() or JNIEasyHelper::findMethodAddress(const char*)),
# Java of course loads libJNIEasy.so too.
# Preloading libJNIEasy.so from libMyLibrary.so avoids this minor but annoying bug.
# This dependency is necessary only if native code calls findMethodAddress to bind and call Java methods from native.
