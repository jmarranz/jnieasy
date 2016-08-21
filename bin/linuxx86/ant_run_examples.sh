#!/bin/sh

export JAVA_HOME=/usr/lib/jvm/java-6-sun
export ANT_HOME=../../../tools/ant
export PATH=$ANT_HOME/bin:$PATH

ant -buildfile ../../build.xml run_examples
