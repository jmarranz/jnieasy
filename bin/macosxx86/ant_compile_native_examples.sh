#!/bin/sh

export ANT_HOME=../../../tools/ant
export PATH=$ANT_HOME/bin:$PATH

ant -buildfile ../../build.xml compile_native_examples_macosxx86
