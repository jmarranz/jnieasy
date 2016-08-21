
#ifndef MyCPPClassOnDLL_h
#define MyCPPClassOnDLL_h

#include "JNIEasy.h"

// MyCPPClassOnDLL.h
class DLLEXPORT MyCPPClassOnDLL
{
protected:
    double m_value;

public:
	MyCPPClassOnDLL(int a,int b);
        virtual ~MyCPPClassOnDLL();

	static MyCPPClassOnDLL* __stdcall create(int a,int b);

    static void __stdcall destroy(MyCPPClassOnDLL* obj);

    static __int64 __stdcall addStatic(int a,int b);

	double __stdcall getValue();

    virtual double __stdcall sub(int a,int b);

    static void __cdecl varargsEx(char* buffer,...);

};

#endif
