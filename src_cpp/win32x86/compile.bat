
call "%DevStudio%/VC/BIN/vcvars32.bat"

set JAVA_HOME=../../../tools/jdk_1_4_2_win32

rem set LIBFILES=../../lib/win32x86/LicenseMgr.lib
set LIBFILES=

cl  /nologo /EHsc /GR /MT /O2 /Wp64 /DWIN32 /I../../../JNIEasy_dist/include /I%JAVA_HOME%/include /I%JAVA_HOME%/include/win32  /I../../../LicenseMgr/src_cpp/include /I../../../LicenseMgr/src_cpp/include_no_gen /I../../../Nativepp/src_cpp/include /LD /FeJNIEasy.dll  @../../src_cpp/cpp_source_files.txt ../../src_cpp/source/asm_dispatch_i686_32_msvc.cpp /link %LIBFILES% /def:../../src_cpp/win32x86/JNIEasy.def /INCREMENTAL:NO

rem añadir tras /link si se quiere: /INCREMENTAL:NO


