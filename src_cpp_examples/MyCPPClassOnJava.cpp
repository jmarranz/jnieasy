
#include "MyCPPClassOnJava.h"

#include <stdio.h>

void* (__stdcall * MyCPPClassOnJava::_MyCPPClassOnJava)(int,int) = 0;
void (__stdcall * MyCPPClassOnJava::_destroy)(void*) = 0;
__int64 (__stdcall * MyCPPClassOnJava::_addStatic)(int,int) = 0;
double (__stdcall * MyCPPClassOnJava::_sub)(void*,int,int) = 0;
double (__stdcall * MyCPPClassOnJava::_value)(void*,int,double) = 0;

double __stdcall MyCPPClassOnJava_example()
{
    MyCPPClassOnJava* proxy = MyCPPClassOnJava::create(2,3);
    // like a Java: new MyCPPClassOnJava(2,3);
    double res = proxy->sub(2,3); // Must be 0
    MyCPPClassOnJava::destroy(proxy); // Unlock the Java object   
    return res;
}

double __stdcall MyCPPClassOnJava_example2()
{
    MyCPPClassOnJava* proxy = new MyCPPClassOnJava(2,3);
    double res = proxy->sub(2,3);  // Must be 0  
    delete proxy;
    return res;
}

double __stdcall MyCPPClassOnJava_field_example()
{
    MyCPPClassOnJava* proxy = MyCPPClassOnJava::create(2,3);
    proxy->valueField(NativeFieldMethod::SET,10);
    double res = proxy->valueField(NativeFieldMethod::GET,0);
    // Must be 10
    return res;
}
