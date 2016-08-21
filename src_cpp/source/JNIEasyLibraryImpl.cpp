// JNIEasyLibraryImpl.cpp: implementation of the JNIEasyLibraryImpl class.
//
//////////////////////////////////////////////////////////////////////

#include "JNIEasyLibraryImpl.h"

#include "LicenseMgr.h"

#include "UtilJNI.h"


JNIEXPORT void* __stdcall findExportedMethodAddress(const char* signature)
{
	return (void*)JNIEasyLibraryImpl::SINGLETON->findExportedMethodAddress(signature);
}



//////////////////////////////////////////////////////////////////////
// Construction/Destruction
//////////////////////////////////////////////////////////////////////

JNIEasyLibraryImpl* JNIEasyLibraryImpl::SINGLETON = NULL;


void JNIEasyLibraryImpl::registerSelf(JNIEnv* env,jobject dllJNIEasy,jstring licenseDir)
{
	SINGLETON = new JNIEasyLibraryImpl(env,dllJNIEasy,licenseDir);
}

void JNIEasyLibraryImpl::unregisterSelf(JNIEnv* env)
{
	if (SINGLETON != NULL)
	{
		SINGLETON->free(env);
		delete SINGLETON;
		SINGLETON = NULL;
	}
}

void JNIEasyLibraryImpl::checkLicense(jint action,jint context)
{
    jint licType = SINGLETON->getLicenseType();
    LicenseMgr::checkLicense(action,context,licType);
}


JNIEasyLibraryImpl::JNIEasyLibraryImpl(JNIEnv* env,jobject obj,jstring licenseDir)
: JavaObjectWrapper(env,obj)
{
	// clase JNIEasyLibraryNative
	jclass cls = env->GetObjectClass(obj); 

	// public long findExportedMethodAddress(String signature)
	const char* methodName = "findExportedMethodAddress";
	const char* signature = "(Ljava/lang/String;)J";
	m_methodId = env->GetMethodID(cls,methodName,signature);

        const char* licenseDirPtr = NULL;
        if (licenseDir != NULL) 
            licenseDirPtr = env->GetStringUTFChars(licenseDir, NULL);

	// Este constructor se llama una sola vez en la vida del programa
	// lugar oportuno para validar la licencia
	// lo hacemos después de hacer cosas para dar más trabajo a los hackers
	this->licenseType = LicenseMgr::validate(licenseDirPtr,this->licenseId);

        if (licenseDir != NULL)        
            env->ReleaseStringUTFChars(licenseDir,licenseDirPtr);
}

JNIEasyLibraryImpl::~JNIEasyLibraryImpl()
{

}

jstring JNIEasyLibraryImpl::getLicenseId(JNIEnv* env)
{
	return env->NewStringUTF(this->licenseId.data());
}

jlong JNIEasyLibraryImpl::findExportedMethodAddress(const char* signature)
{
	JNIEnv* env = getJNIEnv();

	jstring objSig = env->NewStringUTF(signature); 

	jlong res = env->CallLongMethod(m_obj,m_methodId,objSig);

	env->DeleteLocalRef(objSig);
	return res;
}

