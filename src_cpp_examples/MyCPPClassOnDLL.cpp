
#include "MyCPPClassOnDLL.h"
#include <stdio.h>
#include <stdarg.h>

MyCPPClassOnDLL::MyCPPClassOnDLL(int a,int b)
{
    m_value = a + b;
}

MyCPPClassOnDLL::~MyCPPClassOnDLL()
{
}

MyCPPClassOnDLL* __stdcall MyCPPClassOnDLL::create(int a,int b)
{
    return new MyCPPClassOnDLL(a , b); // may be an inherited class
}

void __stdcall MyCPPClassOnDLL::destroy(MyCPPClassOnDLL* obj)
{
    delete obj;
}

__int64 __stdcall MyCPPClassOnDLL::addStatic(int a,int b)
{
    return (__int64)a + (__int64)b;
}

double __stdcall MyCPPClassOnDLL::getValue()
{
    return m_value;
}

double __stdcall MyCPPClassOnDLL::sub(int a,int b)
{
    m_value = m_value - (a + b);
    return m_value;
}

void __cdecl MyCPPClassOnDLL::varargsEx(char* buffer,...)
{
    va_list marker;
    va_start( marker, buffer );
    const char* name = va_arg( marker, const char*);
    int age = va_arg( marker, int);
    int brothers = va_arg( marker, int);
    va_end( marker );

    sprintf(buffer,"%s is %d years old and has %d brothers",name,age,brothers);
}

