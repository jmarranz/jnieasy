#!/bin/sh

BUILD_DIR=../../build_cpp/solarisx86
mkdir -p $BUILD_DIR
cd $BUILD_DIR

JAVA_HOME=../../../tools/jdk_1_5_0_solaris

GCC_SOLARIS=/usr/sfw/bin/gcc
GPP_SOLARIS=/usr/sfw/bin/g++

GCC_EXEC_PREFIX=/usr/sfw/bin/gcc
export GCC_EXEC_PREFIX

# Usar -save-temps para obtener el código ensamblador generado para ver la parte de ensamblador
GCC_OPTIONS="-c -fPIC -Wall -I../../../JNIEasy_dist/include -I$JAVA_HOME/include -I$JAVA_HOME/include/solaris -I../../../LicenseMgr/src_cpp/include"
# NO usar optimizaciones (-OX), pues falla (recuerda que hay ASM inline que el gcc no maneja).

# Para compilar un archivo individual
# $GCC_SOLARIS $GCC_OPTIONS  archivo

# Comentar con # cuando se quiera compilar un archivo individual o linkar solo
rm *.o
$GCC_SOLARIS $GCC_OPTIONS ../../src_cpp/source/asm_dispatch_i686_solaris.cpp
$GCC_SOLARIS $GCC_OPTIONS `cat ../../src_cpp/cpp_source_files.txt` 

rm libJNIEasy.so

# Debe estar libLicenseMgr.a antes que libNativepp.a
# $GPP_SOLARIS -shared -mimpure-text -o libJNIEasy.so  -Wall  *.o  -L../../lib/solarisx86 -lLicenseMgr -lNativepp -lstdc++  -ldl
# Sin validacion de licencias NO necesitamos: -lLicenseMgr -lNativepp
$GPP_SOLARIS -shared -mimpure-text -o libJNIEasy.so  -Wall  *.o  -L../../lib/solarisx86 -lstdc++  -ldl

# -Wl,-soname=libJNIEasy.so  
# Sobre -mimpure-text : http://curl.haxx.se/mail/lib-2002-01/0092.html

cp libJNIEasy.so ../../bin/solarisx86 
