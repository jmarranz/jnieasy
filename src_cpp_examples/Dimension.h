
#ifndef Dimension_h
#define Dimension_h


struct Dimension
{
    int type;
    union
    {
      int x;
      double y;
    };
    const char* desc;

};

#endif
