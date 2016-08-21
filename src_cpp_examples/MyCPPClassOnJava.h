
#ifndef MyCPPClassOnJava_h
#define MyCPPClassOnJava_h

#include <JNIEasyHelper.h>


class MyCPPClassOnJava
{
protected:
  static void* (__stdcall * _MyCPPClassOnJava)(int,int);
  static void (__stdcall * _destroy)(void*);
  static __int64 (__stdcall * _addStatic)(int,int);
  static double (__stdcall * _sub)(void*,int,int);
  static double (__stdcall * _value)(void*,int,double);

  double m_value;  // the same as in Java class

public:
  MyCPPClassOnJava(int a,int b)  // the same as in Java class
  {
	m_value = a + b;
  }

  static MyCPPClassOnJava* create(int a,int b)
  {
    if (_MyCPPClassOnJava == 0)
      _MyCPPClassOnJava = (void* (__stdcall *)(int,int)) JNIEasyHelper::findExportedMethodAddress("examples.manual.MyCPPClassOnJava.<init>(int,int)");

    return (MyCPPClassOnJava*)_MyCPPClassOnJava(a,b);
  }

  static void destroy(MyCPPClassOnJava* obj)
  {
    if (_destroy == 0)
      _destroy = (void (__stdcall *)(void*)) JNIEasyHelper::findExportedMethodAddress("examples.manual.MyCPPClassOnJava.destroy(examples.manual.MyCPPClassOnJava*)");
    _destroy(obj);
  }

  static __int64 addStatic(int a,int b)
  {
    if (_addStatic == 0)
      _addStatic = (__int64 (__stdcall *)(int,int)) JNIEasyHelper::findExportedMethodAddress("examples.manual.MyCPPClassOnJava.addStatic(int,int)");
    return _addStatic(a, b);
  }

  double sub(int a,int b)
  {
    if (_sub == 0)
      _sub = (double (__stdcall *)(void*,int,int)) JNIEasyHelper::findExportedMethodAddress("examples.manual.MyCPPClassOnJava.sub(int,int)");
    return _sub(this, a, b);
  }

  double valueField(int opcode,double value)
  {
    if (_value == 0)
        _value = (double (__stdcall *)(void*,int,double))JNIEasyHelper::findExportedMethodAddress("examples.manual.MyCPPClassOnJava.value(int,double)");

	return _value(this,opcode,value);
  }

};

extern "C"
{
DLLEXPORT double __stdcall MyCPPClassOnJava_example();
DLLEXPORT double __stdcall MyCPPClassOnJava_example2();
DLLEXPORT double __stdcall MyCPPClassOnJava_field_example();
}

#endif

