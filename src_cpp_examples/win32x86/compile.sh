#!/bin/sh

cd $BUILD_DIR_TEST

# -malign-double and -fPIC are not needed in MinGW
GCC_OPTIONS="-c -O3 -Wall -I../../include" 

$GCC_WIN32_X86 $GCC_OPTIONS `cat ../../src_cpp_examples/cpp_source_files.txt` 
# -ldl is not needed in MinGW
$GCC_WIN32_X86 -shared -o MyLibrary.dll  -Wall -Wl,--kill-at *.o  -lstdc++

