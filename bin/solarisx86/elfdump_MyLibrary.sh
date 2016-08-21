#!/bin/sh

elfdump -s libMyLibrary.so >elfdump_MyLibrary.txt

# Use -C or c++filt command to "demangle" symbols
