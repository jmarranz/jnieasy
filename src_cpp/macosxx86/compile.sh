#!/bin/sh

# Info: http://developer.apple.com/documentation/Java/Conceptual/Java14Development/05-CoreJavaAPIs/CoreJavaAPIs.html
# Seleccionar el gcc 4.0 con: sudo gcc_select 4.0 

BUILD_DIR=../../build_cpp/macosxx86
mkdir -p $BUILD_DIR
cd $BUILD_DIR

JAVA_HOME=../../../tools/jdk_1_4_2_macosx

# NO se si es necesario:
# export MACOSX_DEPLOYMENT_TARGET=10.4

# Usar -save-temps para obtener el código ensamblador generado para ver la parte de ensamblador
GCC_OPTIONS="-c -arch i386 -fPIC -Wall -I../../../JNIEasy_dist/include -I$JAVA_HOME/Headers -I../../../LicenseMgr/src_cpp/include"
# NO usar optimizaciones (-OX), pues falla (recuerda que hay ASM inline que el gcc no maneja).


# Para compilar un archivo individual
# g++ $GCC_OPTIONS  archivo

# Compilar todos: (comentar con # cuando se quiera compilar un archivo individual o linkar solo)
rm *.o
g++ $GCC_OPTIONS ../../src_cpp/source/asm_dispatch_i686_macosx.cpp
g++ $GCC_OPTIONS `cat ../../src_cpp/cpp_source_files.txt`

# Debe estar libLicenseMgr.a antes que libNativepp.a
# g++ -dynamiclib  -arch i386 -o libJNIEasy.jnilib -Wall *.o  ../../lib/macosxx86/libLicenseMgr.a ../../lib/macosxx86/libNativepp.a  -lstdc++ -framework JavaVM
# Sin validacion de licencias NO necesitamos: ../../lib/macosxx86/libLicenseMgr.a ../../lib/macosxx86/libNativepp.a
g++ -dynamiclib  -arch i386 -o libJNIEasy.jnilib -Wall *.o    -lstdc++ -framework JavaVM
# -ldl (no necesaria) 
# -framework JavaVM   (Introduce una dependencia INNECESARIA)


cp libJNIEasy.jnilib ../../bin/macosxx86 


