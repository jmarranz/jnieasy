
call "%DevStudio%/VC/BIN/x86_amd64/vcvarsx86_amd64.bat"

set JAVA_HOME=../../../tools/jdk_1_4_2_win32
set LIBFILES=../../lib/winx86_64/LicenseMgr.lib 

REM cl  /Fa /nologo /EHsc /GR /MT /O2 /Wp64 /DWIN64 /I../../../JNIEasy_dist/include /I%JAVA_HOME%/include /I%JAVA_HOME%/include/win32  /I../../../LicenseMgr/src_cpp/include /I../../../LicenseMgr/src_cpp/include_no_gen /I../../../Nativepp/src_cpp/include /LD /FeJNIEasy.dll  @../../src_cpp/cpp_source_files.txt ../../src_cpp/source/asm_dispatch_i686_64_msvc.cpp /link %LIBFILES% /def:../../src_cpp/winx86_64/JNIEasy.def /INCREMENTAL:NO

ml64 /c ../../src_cpp/source/asm_dispatch_i686_64_msvc.asm

cl /Fa /nologo /EHsc /GR /MT /O2 /Wp64 /DWIN64 /I../../../JNIEasy_dist/include /I%JAVA_HOME%/include /I%JAVA_HOME%/include/win32  /I../../../LicenseMgr/src_cpp/include /I../../../LicenseMgr/src_cpp/include_no_gen /I../../../Nativepp/src_cpp/include /LD /FeJNIEasy.dll  @../../src_cpp/cpp_source_files.txt /link %LIBFILES% asm_dispatch_i686_64_msvc.obj /def:../../src_cpp/winx86_64/JNIEasy.def /INCREMENTAL:NO

rem /Fa 

rem No es necesario JNIEasy.def, los métodos C con stdcall no tienen @ añadido 
rem añadir tras /link si se quiere: /INCREMENTAL:NO

