// User32
package examples.win32exam.win32.user; 

import examples.win32exam.win32.def.*; 
import com.innowhere.jnieasy.core.data.*; 

public class User32 
{ 
    public static com.innowhere.jnieasy.core.JNIEasy jnieasyRoot = com.innowhere.jnieasy.core.JNIEasy.get(); 
    public static com.innowhere.jnieasy.core.mem.DynamicLibrary jnieasyDLL = jnieasyRoot.getDLLManager().get("User32"); 
    public static com.innowhere.jnieasy.core.method.NativeBehavior[] jnieasyMethodList = new com.innowhere.jnieasy.core.method.NativeBehavior[ 19 ]; 

    public static int BeginPaint(int hwnd,examples.win32exam.win32.user.PaintStruct lpPaint) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[0]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "BeginPaint"; 
            jnieasyMethod = jnieasyMethodList[0] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.PaintStruct.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hwnd),lpPaint}); 
    } 

    public static int CreateWindowEx(int dwExStyle,java.lang.String lpClassName,java.lang.String lpWindowName,int dwStyle,int x,int y,int nWidth,int nHeigth,int hwndParent,int hMenu,int hInstance,int lParam) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[1]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "ANSI:CreateWindowExA;UNICODE:CreateWindowExW;CreateWindowExA"; 
            jnieasyMethod = jnieasyMethodList[1] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().decString(java.lang.String.class,"ANSI:ansi;UNICODE:unicode;ansi").decVarType().decParameter(),jnieasyRoot.getTypeManager().decString(java.lang.String.class,"ANSI:ansi;UNICODE:unicode;ansi").decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(dwExStyle),lpClassName,lpWindowName,new java.lang.Integer(dwStyle),new java.lang.Integer(x),new java.lang.Integer(y),new java.lang.Integer(nWidth),new java.lang.Integer(nHeigth),new java.lang.Integer(hwndParent),new java.lang.Integer(hMenu),new java.lang.Integer(hInstance),new java.lang.Integer(lParam)}); 
    } 

    public static int DefWindowProc(int hWnd,int msg,int wParam,int lParam) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[2]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "DefWindowProcA"; 
            jnieasyMethod = jnieasyMethodList[2] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hWnd),new java.lang.Integer(msg),new java.lang.Integer(wParam),new java.lang.Integer(lParam)}); 
    } 

    public static int DestroyWindow(int hWnd) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[3]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "DestroyWindow"; 
            jnieasyMethod = jnieasyMethodList[3] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hWnd)}); 
    } 

    public static int DispatchMessage(examples.win32exam.win32.user.Msg pMsg) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[4]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "DispatchMessageA"; 
            jnieasyMethod = jnieasyMethodList[4] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.Msg.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {pMsg}); 
    } 

    public static int DrawText(int hDC,java.lang.String lpString,int nCount,examples.win32exam.win32.def.Rect lpRect,int uFormat) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[5]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "DrawTextA"; 
            jnieasyMethod = jnieasyMethodList[5] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(java.lang.String.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.def.Rect.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hDC),lpString,new java.lang.Integer(nCount),lpRect,new java.lang.Integer(uFormat)}); 
    } 

    public static int EndPaint(int hWnd,examples.win32exam.win32.user.PaintStruct lpPaint) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[6]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "EndPaint"; 
            jnieasyMethod = jnieasyMethodList[6] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.PaintStruct.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hWnd),lpPaint}); 
    } 

    public static int GetClassInfoEx(int hinst,java.lang.String lpszClass,examples.win32exam.win32.user.WndClassEx lpwcx) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[7]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "GetClassInfoExA"; 
            jnieasyMethod = jnieasyMethodList[7] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(java.lang.String.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.WndClassEx.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hinst),lpszClass,lpwcx}); 
    } 

    public static int GetClassInfoEx(int hinst,int lpszClass,examples.win32exam.win32.user.WndClassEx lpwcx) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[8]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "GetClassInfoExA"; 
            jnieasyMethod = jnieasyMethodList[8] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.WndClassEx.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hinst),new java.lang.Integer(lpszClass),lpwcx}); 
    } 

    public static int GetClientRect(int hWnd,examples.win32exam.win32.def.Rect rect) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[9]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "GetClientRect"; 
            jnieasyMethod = jnieasyMethodList[9] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.def.Rect.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hWnd),rect}); 
    } 

    public static int GetMessage(examples.win32exam.win32.user.Msg lpMsg,int hwnd,int wMsgFilterMin,int wMsgFilterMax) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[10]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "GetMessageA"; 
            jnieasyMethod = jnieasyMethodList[10] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.Msg.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {lpMsg,new java.lang.Integer(hwnd),new java.lang.Integer(wMsgFilterMin),new java.lang.Integer(wMsgFilterMax)}); 
    } 

    public static int LoadCursor(int hInstance,int lpCursorName) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[11]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "LoadCursorA"; 
            jnieasyMethod = jnieasyMethodList[11] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hInstance),new java.lang.Integer(lpCursorName)}); 
    } 

    public static int LoadIcon(int hInstance,int lpIconName) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[12]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "LoadIconA"; 
            jnieasyMethod = jnieasyMethodList[12] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hInstance),new java.lang.Integer(lpIconName)}); 
    } 

    public static void PostQuitMessage(int nExitCode) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[13]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "PostQuitMessage"; 
            jnieasyMethod = jnieasyMethodList[13] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(void.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callVoid(new java.lang.Object[] {new java.lang.Integer(nExitCode)}); 
    } 

    public static short RegisterClassEx(examples.win32exam.win32.user.WndClassEx lpwcx) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[14]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "RegisterClassExA"; 
            jnieasyMethod = jnieasyMethodList[14] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(short.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.WndClassEx.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callShort(new java.lang.Object[] {lpwcx}); 
    } 

    public static int ShowWindow(int hWnd,int nCmdShow) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[15]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "ShowWindow"; 
            jnieasyMethod = jnieasyMethodList[15] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hWnd),new java.lang.Integer(nCmdShow)}); 
    } 

    public static int TranslateMessage(examples.win32exam.win32.user.Msg lpMsg) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[16]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "TranslateMessage"; 
            jnieasyMethod = jnieasyMethodList[16] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(examples.win32exam.win32.user.Msg.class).decVarType(com.innowhere.jnieasy.core.typedec.VarTypeNative.BY_PTR).decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {lpMsg}); 
    } 

    public static int UnregisterClass(java.lang.String lpClassName,int hInstance) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[17]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "UnregisterClassA"; 
            jnieasyMethod = jnieasyMethodList[17] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(java.lang.String.class).decVarType().decParameter(),jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {lpClassName,new java.lang.Integer(hInstance)}); 
    } 

    public static int UpdateWindow(int hWnd) 
    { 
        com.innowhere.jnieasy.core.method.NativeBehavior jnieasyMethod = jnieasyMethodList[18]; 
        if (jnieasyMethod == null)  
        { 
            String jnieasyFuncName = "UpdateWindow"; 
            jnieasyMethod = jnieasyMethodList[18] = jnieasyDLL.addCMethod(jnieasyFuncName, 
                jnieasyRoot.getTypeManager().dec(int.class).decVarType(), 
                new java.lang.Object[] {jnieasyRoot.getTypeManager().dec(int.class).decVarType().decParameter()}, 
                com.innowhere.jnieasy.core.typedec.CallConv.STD_CALL 
                ); 
        } 
        return ((com.innowhere.jnieasy.core.method.NativeStaticMethod)jnieasyMethod).callInt(new java.lang.Object[] {new java.lang.Integer(hWnd)}); 
    } 

}