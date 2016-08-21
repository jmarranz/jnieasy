#!/bin/sh

cd $BUILD_DIR_TEST

GCC_OPTIONS="-c -O2 -malign-double -fPIC -Wall -I../../include" 

rm *.o
gcc $GCC_OPTIONS `cat ../../src_cpp_examples/cpp_source_files.txt` 

rm libMyLibrary.dylib
g++ -dynamiclib -o libMyLibrary.dylib  -Wall *.o  -lstdc++ -ldl 

