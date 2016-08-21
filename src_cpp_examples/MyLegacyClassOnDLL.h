
#ifndef MyLegacyClassOnDLL_h
#define MyLegacyClassOnDLL_h

#include "JNIEasy.h"

// MyLegacyClassOnDLL.h
class MyLegacyClassOnDLL
{
protected:
    double m_value;

public:
    MyLegacyClassOnDLL(int a,int b);
    virtual ~MyLegacyClassOnDLL();

    static __int64 addStatic(int a,int b);

    double getValue();

    virtual double sub(int a,int b);
};

extern "C"
{
DLLEXPORT MyLegacyClassOnDLL* __stdcall MyLegacyClassOnDLL_create(int a,int b);
DLLEXPORT void __stdcall MyLegacyClassOnDLL_destroy(MyLegacyClassOnDLL* obj);
DLLEXPORT __int64 __stdcall MyLegacyClassOnDLL_addStatic(int a,int b);
DLLEXPORT double __stdcall MyLegacyClassOnDLL_getValue(MyLegacyClassOnDLL* obj);
DLLEXPORT double __stdcall MyLegacyClassOnDLL_sub(MyLegacyClassOnDLL* obj,int a,int b);
}

#endif
