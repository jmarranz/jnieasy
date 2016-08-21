# Microsoft Developer Studio Project File - Name="JNIEasy" - Package Owner=<4>
# Microsoft Developer Studio Generated Build File, Format Version 6.00
# ** DO NOT EDIT **

# TARGTYPE "Win32 (x86) Generic Project" 0x010a

CFG=JNIEasy - Win32 Debug
!MESSAGE This is not a valid makefile. To build this project using NMAKE,
!MESSAGE use the Export Makefile command and run
!MESSAGE 
!MESSAGE NMAKE /f "JNIEasy.mak".
!MESSAGE 
!MESSAGE You can specify a configuration when running NMAKE
!MESSAGE by defining the macro CFG on the command line. For example:
!MESSAGE 
!MESSAGE NMAKE /f "JNIEasy.mak" CFG="JNIEasy - Win32 Debug"
!MESSAGE 
!MESSAGE Possible choices for configuration are:
!MESSAGE 
!MESSAGE "JNIEasy - Win32 Release" (based on "Win32 (x86) Generic Project")
!MESSAGE "JNIEasy - Win32 Debug" (based on "Win32 (x86) Generic Project")
!MESSAGE 

# Begin Project
# PROP AllowPerConfigDependencies 0
# PROP Scc_ProjName ""
# PROP Scc_LocalPath ""
MTL=midl.exe

!IF  "$(CFG)" == "JNIEasy - Win32 Release"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 0
# PROP BASE Output_Dir "Release"
# PROP BASE Intermediate_Dir "Release"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 0
# PROP Output_Dir "Release"
# PROP Intermediate_Dir "Release"
# PROP Target_Dir ""

!ELSEIF  "$(CFG)" == "JNIEasy - Win32 Debug"

# PROP BASE Use_MFC 0
# PROP BASE Use_Debug_Libraries 1
# PROP BASE Output_Dir "Debug"
# PROP BASE Intermediate_Dir "Debug"
# PROP BASE Target_Dir ""
# PROP Use_MFC 0
# PROP Use_Debug_Libraries 1
# PROP Output_Dir "Debug"
# PROP Intermediate_Dir "Debug"
# PROP Target_Dir ""

!ENDIF 

# Begin Target

# Name "JNIEasy - Win32 Release"
# Name "JNIEasy - Win32 Debug"
# Begin Group "src_cpp"

# PROP Default_Filter ""
# Begin Source File

SOURCE=..\source\asm_dispatch.h
# End Source File
# Begin Source File

SOURCE=..\source\asm_dispatch_i686_gcc.cpp
# End Source File
# Begin Source File

SOURCE=..\source\asm_dispatch_i686_msvc.cpp
# End Source File
# Begin Source File

SOURCE=..\source\BufferNative.cpp
# End Source File
# Begin Source File

SOURCE=..\source\BufferNative.h
# End Source File
# Begin Source File

SOURCE=..\source\CallbackStateManagerNative.cpp
# End Source File
# Begin Source File

SOURCE=..\source\CallbackStateManagerNative.h
# End Source File
# Begin Source File

SOURCE=..\source\consts.h
# End Source File
# Begin Source File

SOURCE=..\source\cross_platform.h
# End Source File
# Begin Source File

SOURCE=..\source\DynamicLibraryNative.cpp
# End Source File
# Begin Source File

SOURCE=..\source\DynamicLibraryNative.h
# End Source File
# Begin Source File

SOURCE=..\source\JavaCallback.cpp
# End Source File
# Begin Source File

SOURCE=..\source\JavaCallback.h
# End Source File
# Begin Source File

SOURCE=..\source\JavaObjectWrapper.cpp
# End Source File
# Begin Source File

SOURCE=..\source\JavaObjectWrapper.h
# End Source File
# Begin Source File

SOURCE=..\source\JNIEasyLibraryImpl.cpp
# End Source File
# Begin Source File

SOURCE=..\source\JNIEasyLibraryImpl.h
# End Source File
# Begin Source File

SOURCE=..\source\JNIEasyLibraryNative.cpp
# End Source File
# Begin Source File

SOURCE=..\source\JNIEasyLibraryNative.h
# End Source File
# Begin Source File

SOURCE=..\source\JNIEasyNative.cpp
# End Source File
# Begin Source File

SOURCE=..\source\JNIEasyNative.h
# End Source File
# Begin Source File

SOURCE=..\source\JNIEnv.cpp
# End Source File
# Begin Source File

SOURCE=..\source\JNIEnv.h
# End Source File
# Begin Source File

SOURCE=..\source\LicenseMgr.cpp
# End Source File
# Begin Source File

SOURCE=..\source\LicenseMgr.h
# End Source File
# Begin Source File

SOURCE=..\source\load.cpp
# End Source File
# Begin Source File

SOURCE=..\source\load.h
# End Source File
# Begin Source File

SOURCE=..\source\MethodNative.cpp
# End Source File
# Begin Source File

SOURCE=..\source\MethodNative.h
# End Source File
# Begin Source File

SOURCE=..\source\Util.cpp
# End Source File
# Begin Source File

SOURCE=..\source\Util.h
# End Source File
# Begin Source File

SOURCE=..\source\UtilJNI.cpp
# End Source File
# Begin Source File

SOURCE=..\source\UtilJNI.h
# End Source File
# Begin Source File

SOURCE=..\source\WeakReference.cpp
# End Source File
# Begin Source File

SOURCE=..\source\WeakReference.h
# End Source File
# End Group
# Begin Group "include"

# PROP Default_Filter ""
# Begin Source File

SOURCE=..\..\..\JNIEasy_dist\include\JNIEasy.c
# End Source File
# Begin Source File

SOURCE=..\..\..\JNIEasy_dist\include\JNIEasy.h
# End Source File
# Begin Source File

SOURCE=..\..\..\JNIEasy_dist\include\JNIEasy_shared.h
# End Source File
# Begin Source File

SOURCE=..\..\..\JNIEasy_dist\include\JNIEasyHelper.cpp
# End Source File
# Begin Source File

SOURCE=..\..\..\JNIEasy_dist\include\JNIEasyHelper.h
# End Source File
# End Group
# End Target
# End Project
