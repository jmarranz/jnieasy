#!/bin/sh

export ANT_HOME=../../../tools/ant
export PATH=$ANT_HOME/bin:$PATH

ant -buildfile ../../build.xml run_examples
