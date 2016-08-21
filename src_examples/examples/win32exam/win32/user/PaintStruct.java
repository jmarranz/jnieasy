/*
 * PaintStruct.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.win32exam.win32.user;

import examples.win32exam.win32.def.Rect;

/*
typedef struct tagPAINTSTRUCT { 
  HDC  hdc; 
  BOOL fErase; 
  RECT rcPaint; 
  BOOL fRestore; 
  BOOL fIncUpdate; 
  BYTE rgbReserved[32]; 
} PAINTSTRUCT, *PPAINTSTRUCT; 
*/

public class PaintStruct
{
    protected int hdc; // HDC
    protected int fErase; // BOOL in Win32 is an int
    protected Rect rcPaint = new Rect(); // is embedded (by value) 
    protected int fRestore;  // BOOL
    protected int fIncUpdate; // BOOL
    protected byte[] rgbReserved = new byte[32]; // is embedded (by value)
    
    public PaintStruct()
    {
    }
    
    /* Gets and sets methods */
    
    public int getHdc()
    {
        return hdc;
    }
    
    public void setHdc(int hdc)
    {
        this.hdc = hdc;
    }
    
    public boolean getFErase()
    {
        return (fErase != 0);
    }
    
    public void setFErase(boolean fErase)
    {
        this.fErase = fErase ? 1 : 0;
    }    
    
    public Rect getRcPaint()
    {
        return rcPaint;
    }

    public void setRcPaint(Rect rcPaint)
    {
        this.rcPaint = rcPaint;
    }
    
    public boolean getFRestore()
    {
        return (fRestore != 0);
    }
    
    public void setFRestore(boolean fRestore)
    {
        this.fRestore = fRestore ? 1 : 0;
    }    
    
    public boolean getFIncUpdate()
    {
        return (fIncUpdate != 0);
    }
    
    public void setfIncUpdate(boolean fIncUpdate)
    {
        this.fIncUpdate = fIncUpdate ? 1 : 0;
    }     

    public byte[] getRgbReserved()
    {
        return rgbReserved;
    }

    public void setRgbReserved(byte[] rgbReserved)
    {
        this.rgbReserved = rgbReserved;
    }    
}
