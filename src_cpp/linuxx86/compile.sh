#!/bin/sh

cd $BUILD_DIR

JAVA_HOME=../../../tools/jdk_1_4_2_linux

# Usar -save-temps para obtener el código ensamblador generado para ver la parte de ensamblador
GCC_OPTIONS="-c -fPIC -Wall -masm=intel -I../../../JNIEasy_dist/include -I$JAVA_HOME/include -I$JAVA_HOME/include/linux -I../../../LicenseMgr/src_cpp/include"
# No optimizamos (-Ox). El caso es que al menos con -O2 funciona bien pero así evitamos problemas pues hay ASM inline que el gcc no controla.

# Para compilar un archivo individual
# $GCC_LINUX_X86 $GCC_OPTIONS  archivo

# Comentar con # cuando se quiera compilar un archivo individual o linkar solo
rm *.o
$GCC_LINUX_X86 -masm=intel $GCC_OPTIONS ../../src_cpp/source/asm_dispatch_i686_linux.cpp
$GCC_LINUX_X86 $GCC_OPTIONS `cat ../../src_cpp/cpp_source_files.txt` 

rm libJNIEasy.so

# Debe estar libLicenseMgr.a antes que libNativepp.a
# $GCC_LINUX_X86 -shared -o libJNIEasy.so -Wl,-soname,libJNIEasy.so -Wall *.o  -L../../lib/linuxx86 -lLicenseMgr -lNativepp  -lstdc++ -ldl
# Sin "-lLicenseMgr -lNativepp"  para el caso de no validacion de licencias
$GCC_LINUX_X86 -shared -o libJNIEasy.so -Wl,-soname,libJNIEasy.so -Wall *.o  -L../../lib/linuxx86  -lstdc++ -ldl
