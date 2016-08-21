/*
 * ManualExamples.java
 *
 * Author: Jose Maria Arranz
 * (C) 2006 Innowhere Software Services S.L.
 */

package examples.manual;

import com.innowhere.jnieasy.core.JNIEasy;
import com.innowhere.jnieasy.core.data.NativeInteger;
import com.innowhere.jnieasy.core.data.NativeIntegerArray;
import com.innowhere.jnieasy.core.data.NativeString;
import com.innowhere.jnieasy.core.data.NativeStringArray;
import com.innowhere.jnieasy.core.enh.NativeEnhancer;
import com.innowhere.jnieasy.core.mem.DLLManager;
import com.innowhere.jnieasy.core.mem.DynamicLibrary;
import com.innowhere.jnieasy.core.mem.JNIEasyLibrary;
import com.innowhere.jnieasy.core.mem.NativeBuffer;
import com.innowhere.jnieasy.core.mem.NativeBufferIterator;
import com.innowhere.jnieasy.core.mem.NativeManager;
import com.innowhere.jnieasy.core.method.CFieldMethod;
import com.innowhere.jnieasy.core.method.CMethod;
import com.innowhere.jnieasy.core.method.NativeConstructor;
import com.innowhere.jnieasy.core.method.NativeConstructorCallback;
import com.innowhere.jnieasy.core.method.NativeDirectInstanceFieldCallback;
import com.innowhere.jnieasy.core.method.NativeDirectStaticFieldCallback;
import com.innowhere.jnieasy.core.method.NativeDirectStaticMethodCallback;
import com.innowhere.jnieasy.core.method.NativeFieldMethod;
import com.innowhere.jnieasy.core.method.NativeInstanceMethodCallback;
import com.innowhere.jnieasy.core.method.NativeStaticFieldMethodReflection;
import com.innowhere.jnieasy.core.method.NativeStaticMethod;
import com.innowhere.jnieasy.core.method.NativeStaticMethodCallback;
import com.innowhere.jnieasy.core.method.NativeStaticMethodReflection;
import com.innowhere.jnieasy.core.txn.NativeTransaction;
import com.innowhere.jnieasy.core.typedec.CPPClassDescriptor;
import com.innowhere.jnieasy.core.typedec.CallConv;
import com.innowhere.jnieasy.core.typedec.NativeBehaviorDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeConstructorDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeFieldDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeFieldMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeFieldStructureDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeMethodSignature;
import com.innowhere.jnieasy.core.typedec.NativeMultipleFieldContainerDescriptor;
import com.innowhere.jnieasy.core.typedec.NativeSignatureManager;
import com.innowhere.jnieasy.core.typedec.NativeStaticMethodSignature;
import com.innowhere.jnieasy.core.typedec.StringEncoding;
import com.innowhere.jnieasy.core.typedec.TypeNativeArray;
import com.innowhere.jnieasy.core.typedec.TypeCanBeNativeCapable;
import com.innowhere.jnieasy.core.typedec.NativeTypeManager;
import com.innowhere.jnieasy.core.typedec.StructureDescriptor;
import com.innowhere.jnieasy.core.typedec.TypeNative;
import com.innowhere.jnieasy.core.typedec.TypeNativeObject;
import com.innowhere.jnieasy.core.typedec.TypeNativeStaticMethod;
import com.innowhere.jnieasy.core.typedec.TypeNativeString;
import com.innowhere.jnieasy.core.typedec.VarTypeNative;
import com.innowhere.jnieasy.core.util.NativeCapableFactory;
import com.innowhere.jnieasy.core.util.NativeCapableUtil;
import com.innowhere.jnieasy.core.util.NativePrimitiveUtil;
import examples.RunExamples;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class ManualExamples
{
           
    /**
     * Creates a new instance of ManualExamples
     */
    public ManualExamples()
    {
    }
    
    public static void runAll() throws Exception
    {   
        initMacros();

        Table_of_data_native_interfaces();
        Declaration_of_predefined_native_capable_classes(); 
        Declaration_of_predefined_native_capable_classes2();
        if (RunExamples.isWindows)
            Creation_of_proxies_of_DLL_methods_and_fields();
        Creation_of_proxies_of_DLL_methods_and_fields2();
        if (RunExamples.isWindows)        
            Creation_of_proxies_of_native_methods_and_fields_if_the_address_is_known();
        Creation_of_direct_and_reflection_callbacks();
        Creation_of_direct_and_reflection_callbacks2();
  
        if (RunExamples.isWindows)        
            Using_Java_reflection_as_proxy_of_native_methods();
        Making_native_allocating_native_memory();
       
        Making_native_attaching_native_memory_with_unfetch();
        Making_native_attaching_native_memory_untouched();
        Making_native_by_reachability_of_the_fields();
        Contiguous_fields_declared_as_unions();
      
        Java_methods_working_as_proxy_of_native_methods_lifecycle();
        Java_methods_working_as_proxy_of_native_methods_varargs();           
        Java_methods_working_as_native_callbacks_internal_instances();    

        Java_methods_working_as_native_callbacks_dynamic_linking_from_cpp();  
        Java_methods_working_as_native_callbacks_dynamic_linking_from_cpp2(); 
        
        Java_fields_working_as_native_field_callbacks();        
        Java_fields_working_as_native_field_callbacks2(); 
        
        User_defined_native_capable_direct_callbacks();
        User_defined_native_capable_direct_callbacks2();            
        if (RunExamples.isWindows)        
            User_defined_native_capable_direct_callbacks3();
        Static_callbacks_with_the_method_outside_the_class();
        Instance_callbacks();
        Exporting_the_callbacks_to_the_native_side();
        Mapping_native_legacy_classes();
        
        On_load_enhancer();
        Java_Code_Generation();
        Direct_memory_manipulation();
        Changing_the_default_size_and_alignment_of_a_native_element();
        C_inspired_macro_system_to_resolve_sizes_and_names();       
        Native_Transactions();
        Listeners_interfaces_implemented_by_native_classes();
        Interfaces_implemented_by_normal_classes_working_as_listeners();
        Serialization(); 
    }
    
    public static void initMacros()
    {
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();
        if (RunExamples.isWindows)
        {
            DynamicLibrary dll = JNIEasy.get().getDLLManager().get("MyLibrary");
            long address = dll.getAddress("?create@MyCPPClassOnDLL@@SGPAV1@HH@Z");
            if (address != 0)
                typeMgr.defineMacro("MSC");
            else 
                typeMgr.defineMacro("gcc"); // MinGW or cygwin gcc
        }
        else
        {
            typeMgr.defineMacro("gcc");
        }                
    }
    
    public static void Table_of_data_native_interfaces()
    {
        NativeTypeManager typeDecMgr = JNIEasy.get().getTypeManager();
        TypeCanBeNativeCapable typeDecStr = (TypeCanBeNativeCapable)typeDecMgr.dec(String.class);
        NativeString strObj = (NativeString)typeDecStr.wrapValue("any string");
        TypeNativeObject typeDecInt = (TypeNativeObject)typeDecMgr.dec(NativeInteger.class);
        NativeInteger objInt = (NativeInteger)typeDecInt.newValue();
    }
    
    public static void Declaration_of_predefined_native_capable_classes()
    {
        NativeTypeManager typeDecMgr = JNIEasy.get().getTypeManager();
        
        TypeNativeObject typeDecInt = (TypeNativeObject)typeDecMgr.dec(NativeInteger.class);
        NativeInteger natInt = (NativeInteger)typeDecInt.newValue();
        natInt.setIntValue(10);        
        
        TypeNativeString typeDecStr = typeDecMgr.decString(StringEncoding.UNICODE);
        
        NativeString natStr = (NativeString)typeDecStr.wrapValue("Hello");
        
        NativeString natStr2 = (NativeString)typeDecStr.newString("Hello");
        
        VarTypeNative varTypeDecStr = typeDecStr.decVarType();
        TypeNativeArray typeDecStrArray = typeDecMgr.decArray(2,varTypeDecStr);
        NativeStringArray strArray = (NativeStringArray)typeDecStrArray.wrapValue(new String[]{"hello","bye"});
    }
    
    public static void Declaration_of_predefined_native_capable_classes2()
    {
        NativeCapableFactory objFact = JNIEasy.get().getNativeCapableFactory();
        NativeString natStr = objFact.newString("Hello");
        
        NativeString natStr2 = (NativeString)objFact.wrapValue("Hello");

        NativeStringArray strArray = (NativeStringArray)objFact.wrapValue(new String[]{"hello","bye"});       
        
        NativeInteger natInt = objFact.newNativeInteger(10);
        
    }
    
    public static void Creation_of_proxies_of_DLL_methods_and_fields()
    {
        DLLManager dllMgr = JNIEasy.get().getDLLManager();
        DynamicLibrary dll = dllMgr.get("User32");    
        CMethod method = dll.addCMethod("FindWindowA",int.class,new Object[]{String.class,String.class},CallConv.STD_CALL);        
        int hwnd = method.callInt(new Object[]{null,"DDE Server Window"});
    }
    
    public static void Creation_of_proxies_of_DLL_methods_and_fields2()
    {
        DLLManager dllMgr = JNIEasy.get().getDLLManager();
        DynamicLibrary dll = dllMgr.get("MyLibrary");  
        CFieldMethod fieldMethod = dll.addCFieldMethod("aGlobalVar",int.class,CallConv.STD_CALL);                
        int value = fieldMethod.callInt(NativeFieldMethod.GET,0); // or .getInt();
        value += 10;
        fieldMethod.callInt(NativeFieldMethod.SET,value); // or .setInt(value);
    }    
    
    public static void Creation_of_proxies_of_native_methods_and_fields_if_the_address_is_known()    
    {
        DynamicLibrary dll = JNIEasy.get().getDLLManager().get("User32");
        long methodAddress = dll.getAddress("FindWindowA");
        NativeSignatureManager sigMgr = JNIEasy.get().getSignatureManager();
        NativeStaticMethodSignature sig = sigMgr.decStaticMethod(int.class,new Object[]{String.class,String.class},CallConv.STD_CALL);        
        NativeStaticMethod method = (NativeStaticMethod)sig.attachBehavior(methodAddress);
        int hwnd = method.callInt(new Object[]{null,"DDE Server Window"});
    }
    
    public static void Creation_of_direct_and_reflection_callbacks() throws Exception
    {
        // Static method: java.lang.Math.max(int,int)
        Method method = Math.class.getDeclaredMethod("max",new Class[]{int.class,int.class});
        NativeSignatureManager sigMgr = JNIEasy.get().getSignatureManager();
        NativeMethodSignature sig = sigMgr.decMethod(method,CallConv.STD_CALL);        
        
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        NativeStaticMethodReflection objReflect = (NativeStaticMethodReflection)sig.newMethodReflection(method);
        natMgr.makeNative(objReflect);
        int max = objReflect.callInt(new Object[]{new Integer(5),new Integer(3)}); 
        System.out.println("Must be 5: " + max);
        
        NativeDirectStaticMethodCallback objDirectCb = (NativeDirectStaticMethodCallback)sig.newDirectMethodCallback(method);        
        natMgr.makeNative(objDirectCb);        
        int max2 = objDirectCb.callInt(new Object[]{new Integer(5),new Integer(3)}); 
        System.out.println("Must be 5: " + max2);
        
        long methodAddress = NativeCapableUtil.getAddress(objReflect);
        NativeStaticMethod proxy = (NativeStaticMethod)sig.attachBehavior(methodAddress);
        int max3 = proxy.callInt(new Object[]{new Integer(5),new Integer(3)}); 
        System.out.println("Must be 5: " + max3);        
    }
    
    public static void Creation_of_direct_and_reflection_callbacks2() throws Exception
    {
        // Static field: java.lang.Math.PI
        Field field = Math.class.getDeclaredField("PI");
        NativeSignatureManager sigMgr = JNIEasy.get().getSignatureManager();
        NativeFieldMethodSignature sig = sigMgr.decFieldMethod(field,CallConv.STD_CALL);        
        NativeManager natMgr = JNIEasy.get().getNativeManager();

        NativeStaticFieldMethodReflection objReflect = (NativeStaticFieldMethodReflection)sig.newFieldMethodReflection(field);
        natMgr.makeNative(objReflect);
        double Pi1 = objReflect.getDouble(); 
        System.out.println("Must be true: " + (Pi1 == java.lang.Math.PI));
        
        NativeDirectStaticFieldCallback objDirectCb = (NativeDirectStaticFieldCallback)sig.newDirectFieldCallback(field);
        natMgr.makeNative(objDirectCb);        
        double Pi2 = objDirectCb.getDouble();         
       
        System.out.println("Must be true: " + (Pi2 == java.lang.Math.PI));        
    }    
    
    public static void Using_Java_reflection_as_proxy_of_native_methods() throws Exception
    {
        DynamicLibrary dll = JNIEasy.get().getDLLManager().get("User32");
        long methodAddress = dll.getAddress("FindWindowA");        
        NativeSignatureManager sigMgr = JNIEasy.get().getSignatureManager();
        NativeStaticMethodSignature sig = sigMgr.decStaticMethod(int.class,new Object[]{String.class,String.class},CallConv.STD_CALL);        
        TypeNativeStaticMethod type = sig.decStaticMethod(NativeStaticMethodReflection.class);
        NativeStaticMethodReflection obj = (NativeStaticMethodReflection)type.newValue();
        JNIEasy.get().getNativeManager().attach(obj,methodAddress);
        Method method = obj.getMethod();
        Integer hwnd = (Integer)method.invoke(null,new Object[]{null,"DDE Server Window"});
        System.out.println("Handle: " + hwnd.intValue());
    }
    
    public static void Making_native_allocating_native_memory()
    {
        MyStructure obj = new MyStructure();
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        natMgr.makeNative(obj);
        long address = NativeCapableUtil.getAddress(obj);
        Object obj2 = natMgr.findObject(address);
        System.out.println("Must be true: " + (obj == obj2));        
    }
    
    public static void Making_native_attaching_native_memory_with_unfetch()
    {
        MyStructure original = new MyStructure();
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        natMgr.makeNative(original);
        original.setIntArray3(null);
        System.out.println("Must be null: " + original.getIntArray3());
        long address = NativeCapableUtil.getAddress(original);
        
        MyStructure attached = new MyStructure();
        natMgr.makeNative(attached,address);        
        attached.setIntArray3(new int[]{1,2}); 
        /* Modifies the native memory of "original" */      
        System.out.println("Must be 1: " + original.getIntArray3()[0]);      
    }    
    
    public static void Making_native_attaching_native_memory_untouched()
    {
        MyStructure original = new MyStructure();
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        natMgr.makeNative(original);
        original.setIntArray3(new int[]{1,2});
        System.out.println("Must be 2: " + original.getIntArray3()[1]);
        long address = NativeCapableUtil.getAddress(original);
        
        MyStructure attached = new MyStructure();
        natMgr.attach(attached,address);        
        System.out.println("Must be 2: " + attached.getIntArray3()[1]);      
    }       
    
    public static void Making_native_by_reachability_of_the_fields()    
    {
        MyStructure obj = new MyStructure();
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        natMgr.makeNative(obj);
        NativeCapableFactory factory = JNIEasy.get().getNativeCapableFactory();
        NativeIntegerArray newValue = (NativeIntegerArray)factory.wrapValue(new int[]{10,11});
        obj.setIntArray1(newValue);        
    }
    
    public static void Contiguous_fields_declared_as_unions()
    {
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();
        NativeMultipleFieldContainerDescriptor classDesc = (NativeMultipleFieldContainerDescriptor)typeMgr.getClassDescriptor(Dimension.class);
        NativeFieldStructureDescriptor xField = (NativeFieldStructureDescriptor)classDesc.getField("x");
        NativeFieldStructureDescriptor yField = (NativeFieldStructureDescriptor)classDesc.getField("y");        
        System.out.println("Must be 4 (int size): " + xField.size()); 
        System.out.println("Must be 8 (double size): " + yField.size());  
        System.out.println("Must be true : " + (xField.getOffset() == yField.getOffset()));        
        
        // Wrong example
        Dimension dim = new Dimension();
        dim.setX(10);
        JNIEasy.get().getNativeManager().makeNative(dim); 
        // BAD!!!! "y" field with 0 overwrites the "x" field value set the native memory !
        System.out.println("Must be true : " + (dim.getX() == 0));
        
        // Correct example
        Dimension dim2 = new Dimension();
        JNIEasy.get().getNativeManager().makeNative(dim2); 
        dim2.setX(10);        
        System.out.println("Must be true : " + (dim2.getX() == 10));
        
    }
    
    public static void Java_methods_working_as_proxy_of_native_methods_lifecycle()
    {
        long res = MyCPPClassOnDLL.addStatic(1,2);
        System.out.println("Must be 3: " + res);
        
        MyCPPClassOnDLL obj = new MyCPPClassOnDLL(1,2); // Calls create() C++ method. New object is already native
        System.out.println("Must be 3: " + obj.getValue());
            // Java method getValue() is not native (but field "value" is native) 
        
        double res2 = obj.sub(1,2);
        System.out.println("Must be 0: " + res2);    
        
        MyCPPClassOnDLL.destroy(obj); // Calls the C++ method destroy(), the memory is freed.               
    }

    public static void Java_methods_working_as_proxy_of_native_methods_varargs()
    {
        byte[] buffer = new byte[256];
        MyCPPClassOnDLL.varargsEx(buffer,new Object[]{"Joe",new Integer(25),new Integer(2)});
        String res = NativePrimitiveUtil.toString(buffer);
        System.out.println("Must be true: " + "Joe is 25 years old and has 2 brothers".equals(res));
    }
    
    public static void Java_methods_working_as_native_callbacks_internal_instances() throws Exception
    {
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();
        NativeMultipleFieldContainerDescriptor classDesc = (NativeMultipleFieldContainerDescriptor)typeMgr.getClassDescriptor(MyCPPClassOnJava.class);
        Constructor construc = MyCPPClassOnJava.class.getDeclaredConstructor(new Class[]{int.class,int.class});
        NativeConstructorDescriptor constrDesc = (NativeConstructorDescriptor)classDesc.getBehavior(construc);
        NativeConstructor natConstr = constrDesc.getNativeConstructor();        
    }
    
    public static void Java_methods_working_as_native_callbacks_dynamic_linking_from_cpp() throws Exception
    {    
        NativeCapableUtil.initializeClass(MyCPPClassOnJava.class); // Ensure the class is loaded and initialized
        
        DynamicLibrary dll = JNIEasy.get().getDLLManager().get("MyLibrary");  
        String nativeName = "MSC:_MyCPPClassOnJava_example@0;gcc:MyCPPClassOnJava_example";
        CMethod method = dll.addCMethod(nativeName,double.class,new Object[0],CallConv.STD_CALL);
        double res = method.callDouble(null);   
        System.out.println("Must be 0: " + res);      
    }
    
    public static void Java_methods_working_as_native_callbacks_dynamic_linking_from_cpp2() throws Exception
    {    
        NativeCapableUtil.initializeClass(MyCPPClassOnJava.class); // Ensure the class is loaded and initialized
        
        DynamicLibrary dll = JNIEasy.get().getDLLManager().get("MyLibrary");
        String nativeName = "MSC:_MyCPPClassOnJava_example2@0;gcc:MyCPPClassOnJava_example2";        
        CMethod method = dll.addCMethod(nativeName,double.class,new Object[0],CallConv.STD_CALL);
        double res = method.callDouble(null);   
        System.out.println("Must be 0: " + res);        
    }
    
    public static void Java_fields_working_as_native_field_callbacks() throws Exception
    {
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();
        CPPClassDescriptor classDesc = (CPPClassDescriptor)typeMgr.getClassDescriptor(MyCPPClassOnJava.class);
        Field field = MyCPPClassOnJava.class.getDeclaredField("value");
        NativeBehaviorDescriptor methodDesc = classDesc.getBehavior(field);

        NativeDirectInstanceFieldCallback callback = (NativeDirectInstanceFieldCallback)methodDesc.getNativeBehavior(); 
        // If used useReflection="true" :
        // NativeInstanceFieldMethodReflection callback2 = (NativeInstanceFieldMethodReflection)methodDesc.getNativeBehavior(); 
    }
    
    public static void Java_fields_working_as_native_field_callbacks2() throws Exception
    {    
        DynamicLibrary dll = JNIEasy.get().getDLLManager().get("MyLibrary");
        String nativeName = "MSC:_MyCPPClassOnJava_field_example@0;gcc:MyCPPClassOnJava_field_example";                
        CMethod method = dll.addCMethod(nativeName,double.class,new Object[0],CallConv.STD_CALL);
        double res = method.callDouble(null);   
        System.out.println("Must be 10: " + res);     
    }
       
    public static void User_defined_native_capable_direct_callbacks()
    {
        NativeStaticMethodCallback cb = (NativeStaticMethodCallback)new AddTwoNumbersCallback();
        JNIEasy.get().getNativeManager().makeNative(cb);        
        long res = cb.callLong(new Object[] { new Integer(2), new Integer(3) }); 
        System.out.println("Must be 5: " + res);    
    }
    
    public static void User_defined_native_capable_direct_callbacks2()
    {
        NativeStaticMethodCallback cb = (NativeStaticMethodCallback)new AddTwoNumbersCallbackConcrete();
        JNIEasy.get().getNativeManager().makeNative(cb);        
        long res = cb.callLong(new Object[] { new Integer(2), new Integer(3) }); 
        System.out.println("Must be 5: " + res);    
    }    
    
    public static void User_defined_native_capable_direct_callbacks3()
    {    
        /*
        BOOL EnumWindows(
          WNDENUMPROC lpEnumFunc,  // pointer to callback function
          LPARAM lParam            // application-defined value
        );
         */

        DynamicLibrary dll = JNIEasy.get().getDLLManager().get("User32");    
        CMethod method = dll.addCMethod("EnumWindows",int.class,new Object[]{EnumWindowsProc.class,int.class},CallConv.STD_CALL);        
        
        EnumWindowsProcConcrete lpEnumFunc = new EnumWindowsProcConcrete();
        int res = method.callInt(new Object[]{lpEnumFunc,new java.lang.Integer(5)});
        System.out.println("Opened windows: " + lpEnumFunc.getWindowCount());
    }

    public static void Static_callbacks_with_the_method_outside_the_class()
    {
        NativeStaticMethodCallback cb = (NativeStaticMethodCallback)new AddTwoNumbersCallbackOutside();
        JNIEasy.get().getNativeManager().makeNative(cb);        
        long res = cb.callLong(new Object[] { new Integer(2), new Integer(3) }); 
        System.out.println("Must be 5: " + res);        
    }
    
    public static void Instance_callbacks()
    {
        NativeConstructorCallback constCb = (NativeConstructorCallback)new MyCPPClassOnJavaConstructorCallback();
        JNIEasy.get().getNativeManager().makeNative(constCb);        
        Object[] args = new Object[] { new Integer(2), new Integer(3) };
        Object obj = (MyCPPClassOnJava)constCb.call(args); // Calls constructor, returns a native MyCPPClassOnJava instance
        
        NativeInstanceMethodCallback cb = (NativeInstanceMethodCallback)new MyCPPClassOnJavaSubCallback();
        JNIEasy.get().getNativeManager().makeNative(cb);        
        args = new Object[] { new Integer(2), new Integer(3) };
        double res = cb.callDouble(obj,args); // Calls sub(int,int)
        
        NativeStaticMethodCallback destCb = (NativeStaticMethodCallback)new MyCPPClassOnJavaDestroyCallback();
        JNIEasy.get().getNativeManager().makeNative(destCb);        
        destCb.callVoid(new Object[]{obj}); // Calls destroy(MyCPPClassOnJava)
    }    
    
    public static void Exporting_the_callbacks_to_the_native_side()
    {
        JNIEasyLibrary dll = JNIEasy.get().getJNIEasyLib();
        String sig = "examples.manual.AddTwoNumbersCallback.add(int,int)";
        NativeStaticMethod method = (NativeStaticMethod)dll.findExportedMethodAddress(sig);
        long res = method.callLong(new Object[]{new Integer(1),new Integer(2)}); // add(1,2)
        System.out.println("Must be 3: " + res);
    }
    
    public static void Mapping_native_legacy_classes()
    {
        long res = MyLegacyClassOnDLL.addStatic(1,2);
        System.out.println("Must be 3: " + res);
        
        MyLegacyClassOnDLL obj = new MyLegacyClassOnDLL(1,2); // Calls create() C++ method. New object is already native
        System.out.println("Must be 3: " + obj.getValue());
            // Java method getValue() is not native (but field "value" is native) 
        
        double res2 = obj.sub(1,2);
        System.out.println("Must be 0: " + res2);    
        
        MyLegacyClassOnDLL.destroy(obj); // Calls the C++ method destroy(), the memory is freed.               
    }
    
    public static void On_load_enhancer() throws Exception
    {
        NativeEnhancer enhancer = JNIEasy.get().getEnhancer();
        ClassLoader myParentLoader = Thread.currentThread().getContextClassLoader();
        String[] included = new String[] { "examples.manual.*" };
        String[] excluded = new String[] {StartInterface.class.getName() };        
        ClassLoader enhancerCL = enhancer.enableOnLoad(included,excluded,myParentLoader);
        Class clsStart = Class.forName("examples.manual.Start",true, enhancerCL); 
        // Start class implements StartInterface
        StartInterface start = (StartInterface)clsStart.newInstance(); 
        start.run();    
    }
    
    public static void Java_Code_Generation()
    {
        long res = MyCPPClassOnDLLGen.addStatic(1,2); 
        System.out.println("Must be 3: " + res);
    }
    
    public static void Direct_memory_manipulation()
    {
        NativeBuffer buffer = JNIEasy.get().getNativeManager().allocateBuffer(1024);
        long offset = 16;
        double value = buffer.getDouble(offset);
        value = value*2;
        buffer.setDouble(offset,value);
        
        NativeBufferIterator it = buffer.newBufferIterator();
        for(int i = 0; i < 10; i++)
            it.setInt(i);      
    }

    public static void Changing_the_default_size_and_alignment_of_a_native_element()
    {
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();
        StructureDescriptor strucDesc = (StructureDescriptor)typeMgr.getClassDescriptor(MyStructure.class);
        NativeFieldDescriptor fieldDesc = strucDesc.getField("cChar");
        TypeNative fieldType = fieldDesc.getVarType().getType();
        System.out.println("Must be 1: " + fieldType.size());
        System.out.println("Must be 1: " + fieldType.preferredAlignSize());        
    }
        
    public static void C_inspired_macro_system_to_resolve_sizes_and_names()
    {
        NativeTypeManager typeMgr = JNIEasy.get().getTypeManager();        
        String osname = System.getProperty("os.name");
        if (osname.startsWith("Windows"))
            typeMgr.defineMacro("Windows");
        else if (osname.startsWith("Linux"))
            typeMgr.defineMacro("Linux");
        else if (osname.startsWith("Mac OS X"))
            typeMgr.defineMacro("MacOSX");        
        else if (osname.startsWith("SunOS"))
            typeMgr.defineMacro("SunOS");        
        else
            throw new RuntimeException("Platform not supported: " + osname);
        
        String dllName = "Windows: MSVCRT ;Linux: /lib/libc.so.6;MacOSX: /usr/lib/libc.dylib;SunOS: /lib/libc.so.1";
        DLLManager dllMgr = JNIEasy.get().getDLLManager();
        DynamicLibrary dll = dllMgr.get(dllName);
        CMethod method = dll.addCMethod("abs",int.class,new Object[]{int.class},CallConv.C_CALL);
        int res = method.callInt(new Object[]{ new Integer(-10) });
        System.out.println("Must be true: " + (res == 10));
    }
    
    public static void Native_Transactions()
    {
        NativeManager nativeMgr = JNIEasy.get().getNativeManager();        

        MyStructure structUpdatedInside = new MyStructure();
        structUpdatedInside.setIntArray4(new int[]{1,2});
        nativeMgr.makeNative(structUpdatedInside);

        MyStructure structNewInside = new MyStructure();
        structNewInside.setIntArray4(new int[]{1,2});

        MyStructure structFreedInside = new MyStructure();
        nativeMgr.makeNative(structFreedInside);            
        structFreedInside.setIntArray4(new int[]{1,2});     

        NativeTransaction txn = nativeMgr.currentTransaction();

        txn.begin();

        nativeMgr.makeNative(structNewInside);                
        structNewInside.setIntArray4(new int[]{3,4});

        nativeMgr.free(structFreedInside);
        structFreedInside.setIntArray4(new int[]{3,4});

        structUpdatedInside.setIntArray4(new int[]{3,4});

        txn.rollback();

        boolean res;
        int[] array;
        
        res = NativeCapableUtil.isNative(structNewInside);
        System.out.println("Must be false: " + res);              
        array = structNewInside.getIntArray4();
        System.out.println("Must be 1: " + array[0]); 
        
        res = NativeCapableUtil.isNative(structFreedInside);
        System.out.println("Must be true: " + res);   
        array = structFreedInside.getIntArray4();        
        System.out.println("Must be 1: " + array[0]);         
        
        array = structUpdatedInside.getIntArray4();        
        System.out.println("Must be 1: " + array[0]);          
    }
    
    public static void Listeners_interfaces_implemented_by_native_classes()
    {
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        MyStructure obj = new MyStructure();
        natMgr.makeNative(obj); // Calls jnieasyPreMakeNative() and jnieasyPostMakeNative()
        NativeBuffer address = NativeCapableUtil.getBuffer(obj);
        
        MyStructure obj2 = new MyStructure();
        natMgr.makeNative(obj2,address,0); // Calls jnieasyPreMakeNative(Address,long) and jnieasyPostMakeNative()
    }
    
    public static void Interfaces_implemented_by_normal_classes_working_as_listeners()    
    {
        MakeNativeListenerExample listener = new MakeNativeListenerExample();
        JNIEasy.get().getNativeManager().addInstanceLifecycleListener(listener,new Class[]{MyStructure.class});
        
        NativeManager natMgr = JNIEasy.get().getNativeManager();
        MyStructure obj = new MyStructure();
        natMgr.makeNative(obj); // Calls preMakeNative() and postMakeNative()
        NativeBuffer address = NativeCapableUtil.getBuffer(obj);

        MyStructure obj2 = new MyStructure();
        natMgr.makeNative(obj2,address,0); // Calls preMakeNative() and postMakeNative()
    }
    
    public static void Serialization() throws Exception
    {
        MyStructure struct = new MyStructure();    
        JNIEasy.get().getNativeManager().makeNative(struct);      
        struct.setCrossPlatNativeLong(null); // Deserialization doesn't work with cross-platform wrappers (the custom native type is forgotten when serializing).
        struct.setCrossPlatNativeLongObject(null); // "
        
        MyStructure structCopy = (MyStructure)JNIEasy.get().getNativeManager().detachCopy(struct);
        
        ByteArrayOutputStream repOut = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(repOut);
        oos.writeObject(struct);
        oos.close();        

        ByteArrayInputStream repIn = new ByteArrayInputStream(repOut.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(repIn);
        MyStructure structCopy2 = (MyStructure)ois.readObject();
        ois.close();
                
        MyStructure struct2 = new MyStructure();    
        JNIEasy.get().getNativeManager().makeNative(struct2);
        
        System.out.println("Must be true: " + (struct2.getIntArray3() != null));        
        structCopy2.setIntArray3(null);
        JNIEasy.get().getNativeManager().attachCopy(struct2,structCopy2);
        System.out.println("Must be null: " + struct2.getIntArray3());
    }
}
