
#include "MyLegacyClassOnDLL.h"
#include <stdio.h>
#include <stdarg.h>

MyLegacyClassOnDLL::MyLegacyClassOnDLL(int a,int b)
{
    m_value = a + b;
}

MyLegacyClassOnDLL::~MyLegacyClassOnDLL()
{
}

__int64 MyLegacyClassOnDLL::addStatic(int a,int b)
{
    return (__int64)a + (__int64)b;
}

double MyLegacyClassOnDLL::getValue()
{
    return m_value;
}

double MyLegacyClassOnDLL::sub(int a,int b)
{
    m_value = m_value - (a + b);
    return m_value;
}

// Wrapper Methods 

MyLegacyClassOnDLL* __stdcall MyLegacyClassOnDLL_create(int a,int b)
{
    return new MyLegacyClassOnDLL(a , b); // may be an inherited class
}

void __stdcall MyLegacyClassOnDLL_destroy(MyLegacyClassOnDLL* obj)
{
    delete obj;
}

__int64 __stdcall MyLegacyClassOnDLL_addStatic(int a,int b)
{
    return MyLegacyClassOnDLL::addStatic(a,b);
}

double __stdcall MyLegacyClassOnDLL_getValue(MyLegacyClassOnDLL* obj)
{
    return obj->getValue();
}

double __stdcall MyLegacyClassOnDLL_sub(MyLegacyClassOnDLL* obj,int a,int b)
{
    return obj->sub(a,b);
}

