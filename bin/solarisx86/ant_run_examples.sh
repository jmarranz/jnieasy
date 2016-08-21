#!/bin/sh

JAVA_HOME=/usr/java
export JAVA_HOME
ANT_HOME=../../../tools/ant
export ANT_HOME
PATH=$ANT_HOME/bin:$PATH
export PATH

ant -buildfile ../../build.xml run_examples
