
call "%MSCInitEnv%"

rem Not needed if included JNIEasyHelper.cpp 
set LIBFILES=../../lib/win32x86/JNIEasy.lib 

cl  /nologo /G6 /MT /GR /GX /O2 /DWIN32  /I../../include /LD /FeMyLibrary.dll  @../../src_cpp_examples/cpp_source_files.txt /link %LIBFILES% 

