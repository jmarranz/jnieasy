#!/bin/sh

cd $BUILD_DIR_TEST

GCC_OPTIONS="-c -O2 -malign-double -fPIC -Wall -I../../include" 

rm *.o
gcc $GCC_OPTIONS `cat ../../src_cpp_examples/cpp_source_files.txt` 

rm libMyLibrary.so
gcc -shared -o libMyLibrary.so  -Wall -Wl,-soname,libMyLibrary.so *.o  -lstdc++ -ldl
