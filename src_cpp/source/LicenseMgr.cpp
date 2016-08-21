
// Poner VALIDATE_LICENSE 1 si queremos validación de licencias

#define VALIDATE_LICENSE 0


#include "LicenseMgr.h"

#include "load.h"

#include <LicenseValidator.h>
#include <jni.h>

static jboolean inited = false;
const jint VERSION_LENGTH = 4;
static jint version[VERSION_LENGTH];
static char productName[256];

enum JNIEasyAction
{
	ENABLE_ONLOAD_ENHANCER	= 1,
	ENHANCE_CLASS_FILES	= 2,
	ENHANCE_CLASS_ONLOAD	= 3,
	JAVA_CODE_GENERATION	= 4,
	REGISTERING_ENHANCED_CLASS = 5
};


void initProductData()
{
	if (inited) return;

	// Lo hacemos de esta manera y no en la declaración de los arrays
	// para que en el código máquina no aparezcan los valores contiguos
	// y con un simpe editor binario pueda modificarse. Así que se
	// molesten en depurar el código máquina
	version[0] = 1;
	version[1] = 0;
	version[2] = 0;
	version[3] = 0;

	// LicenseMgr
	productName[0]  = 'J';
	productName[1]  = 'N';
	productName[2]  = 'I';
	productName[3]  = 'E';
	productName[4]  = 'a';
	productName[5]  = 's';
	productName[6]  = 'y';
	productName[7]  =  0;
	
	inited = true;
}

void LicenseMgr::setJavaVM(JavaVM* jvm)
{
    #if VALIDATE_LICENSE
    LicenseValidator::setJavaVM(jvm);
    #endif
}

jint LicenseMgr::getJVMVersion()
{
    #if VALIDATE_LICENSE
    return LicenseValidator::getJVMVersion();
    #else
    return JNI_VERSION_1_4;
    #endif
}

jint LicenseMgr::validate(const char* licenseDir,std::string& licenseId)
{
    initProductData();

    // Excepto en Windows se usará la variable de entorno JNIEASY_LICENSE_DIR
    // licenseDir puede ser NULL
    #if VALIDATE_LICENSE
    return LicenseValidator::validate(licenseDir,productName,version,VERSION_LENGTH,licenseId,true);
    #else
    return 1; // LicenseValidator::DEVELOPMENT
    #endif
}

#ifdef WINDOWS

void LicenseMgr::setDLLHandle(HMODULE handle)
{
    #if VALIDATE_LICENSE
	LicenseValidator::setDLLHandle(handle);
    #endif
}

#endif // WINDOWS

void LicenseMgr::checkLicense(jint action,jint context,jint licType)
{
    #if VALIDATE_LICENSE
	switch(action)
	{
		case ENABLE_ONLOAD_ENHANCER:
			if (licType == LicenseValidator::BUNDLE)
			{
				printf("Onload enhancer feature is not enabled in BUNDLE license version");
				exit(1);
				/* Permite que la licencia BUNDLE se distribuya sin problema
				 pues con ella ni el enhancer on load funciona, 
				 no se puede desarrollar nada con esta licencia.
				 Proyectos open source y comerciales propios derivados
				 que usan JNIEasy podrían suministrar esta licencia
				 (el proyecto estaría desarrollado sin el onload enhancer
				 con una licencia de desarrollo 
				 de pago pues la de evaluación no funcionaría), de esta
				 manera el JNIEasy podría darse "gratis" y cobrarse más
				 bien el producto derivado.
				 Con las de deployment en teoría funcionaría el 
				 on load enhancer por eso dichas licencias no deben ser
				 libremente distribuidas por los clientes.
				*/
			}
			break;
		case ENHANCE_CLASS_FILES:
			if ((licType == LicenseValidator::DEPLOYMENT) ||
				(licType == LicenseValidator::BUNDLE))
			{
				printf("Enhancer feature is not enabled in runtime license versions");
				exit(1);
				/* Nos aseguramos que sólo se pueda desarrollar con
				las licencias de desarrollo comerciales o con la de
				evaluación aunque con la de evaluación no podrá
				ejecutarse con otras licencias
				*/
			}
			break;
		case ENHANCE_CLASS_ONLOAD:
			if (licType == LicenseValidator::BUNDLE)
			{
				printf("Onload enhancer feature is not enabled in BUNDLE license version");
				exit(1);
				/* Ver el caso ENABLE_ONLOAD_ENHANCER 
					Hay que recordar que también un ClassLoader normal
					puede cargar una clase enhanced en memoria por javassist, 
					de este modo se evita.
				*/
			}
			break;
		case JAVA_CODE_GENERATION:
			if ((licType == LicenseValidator::DEPLOYMENT) ||
				(licType == LicenseValidator::BUNDLE))
			{
				printf("Java Code generation feature is not enabled in runtime license versions");
				exit(1);
				/* Ver el caso de ENHANCE_CLASS_FILES */
			}
			break;
		case REGISTERING_ENHANCED_CLASS:
			/* En este caso "context" es la licencia usada cuando se enriqueció
			 la clase, puede ser LicenseValidator::EVALUATION 
			 o LicenseValidator::DEVELOPMENT
			 */
			if ((licType != LicenseValidator::EVALUATION) && 
				 (context == LicenseValidator::EVALUATION))
			{
				printf("A class enhanced using a evaluation licence only can run with this license type");
				exit(1);
				/* Se trata de evitar que se desarrolle con una licencia
				 de evaluación y se ejecute con una licencia runtime
				 fácilmente obtenible a través de productos de clientes.
				 Quizás pudiera permitirse que funcionara con licencias
				 de desarrollo pues en teoría estas no se distribuyen
				*/
			}
			break;
		default:
			printf("Unexpected Error");
			exit(1);
	}
    #endif // VALIDATE_LICENSE
}
