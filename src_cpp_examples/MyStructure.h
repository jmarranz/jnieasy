
#ifndef MyStructure_h
#define MyStructure_h

// MyStructure.h
struct MyStructure
{
   int anInt;
   int* intArr1;
   int intArr2[2];
   int* intArr3;
   int intArr4[2];

   	MyStructure()
     {
         anInt = -1;
         intArr1 = new int[2];
         intArr1[0] = 1; intArr1[1] = 2;
         intArr2[0] = 3; intArr2[1] = 4;
         intArr3 = new int[2];
         intArr3[0] = 5; intArr3[1] = 6;
         intArr4[0] = 7; intArr4[1] = 8;
     }
};

#endif

