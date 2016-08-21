#!/bin/sh

objdump --dynamic-syms libMyLibrary.so >objdump_MyLibrary.txt

# Use --demangle or c++filt command to "demangle" symbols
