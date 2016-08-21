
#include "load.h"

#include "LicenseMgr.h"

JavaVM* globalJVM = NULL;

JavaVM* getJavaVM()
{
	return globalJVM;
}

void setJavaVM(JavaVM* jvm)
{
	globalJVM = jvm;
}


#ifdef WINDOWS

HINSTANCE dllInstance = 0;

HINSTANCE getDLLInstance()
{
	return dllInstance;
}

void setDLLInstance(HINSTANCE handle)
{
	dllInstance = handle;
}


BOOL WINAPI DllMain(
	HINSTANCE hinstDLL,  // handle to DLL module
	DWORD fdwReason,     // reason for calling function
	LPVOID lpvReserved   // reserved
	)
{
	switch(fdwReason)
	{
	case DLL_PROCESS_ATTACH:
		if (getDLLInstance() == NULL)
		{
			// La primera vez que se llama será el proceso Java
			setDLLInstance( hinstDLL );
			LicenseMgr::setDLLHandle(hinstDLL);
		}
		break;

	case DLL_PROCESS_DETACH:
		break;
	}

	return TRUE;
}

#endif // WINDOWS

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved)
{
    setJavaVM(vm);
    LicenseMgr::setJavaVM(vm);
    return LicenseMgr::getJVMVersion();
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved)
{
	// Por alguna extraña razón nunca se llama, pero ahí queda para quede simétrico

}

