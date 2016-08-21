set JAVA_HOME=C:\j2sdk1.4.2_16
set ANT_HOME=../../../tools/ant
set PATH=%ANT_HOME%/bin;%PATH%

call ant -buildfile ../../build.xml run_examples

pause
