# Parámetros restantes de la línea de comandos definida en ant

-dontshrink
-dontoptimize
-dontusemixedcaseclassnames       

# Packages públicos

# package core
-keep class com.innowhere.jnieasy.core.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.* { <methods>; }

# package core.cgen
-keep class com.innowhere.jnieasy.core.cgen.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.cgen.* { <methods>; }

# package core.data
-keep class com.innowhere.jnieasy.core.data.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.data.* { <methods>; }

# package core.enh
-keep class com.innowhere.jnieasy.core.enh.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.enh.* { <methods>; }

# package core.util
-keep class com.innowhere.jnieasy.core.util.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.util.* { <methods>; }

# package core.listener
-keep class com.innowhere.jnieasy.core.listener.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.listener.* { <methods>; }

# package core.mem
-keep class com.innowhere.jnieasy.core.mem.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.mem.* { <methods>; }

# package core.method
-keep class com.innowhere.jnieasy.core.method.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.method.* { <methods>; }

# package core.txn
-keep class com.innowhere.jnieasy.core.txn.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.txn.* { <methods>; }

# package core.typedec
-keep class com.innowhere.jnieasy.core.typedec.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.typedec.* { <methods>; }

# Packages internos no públicos con clases/interfaces a preservar

#package core.impl.enhancer.rt
# Son clases usadas por las clases enhanced, no pueden ofuscarse 
-keep class com.innowhere.jnieasy.core.impl.enhancer.rt.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.impl.enhancer.rt.* { <methods>; }

#package core.impl.rt.natobjint
# Son clases usadas por las clases enhanced, no pueden ofuscarse 
-keep class com.innowhere.jnieasy.core.impl.rt.natobjint.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.impl.rt.natobjint.* { <methods>; }

#package core.impl.rt.natobjimpl.data
# Son clases usadas por las clases enhanced, no pueden ofuscarse, algunas clases son clases base
-keep class com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.impl.rt.natobjimpl.data.* { <methods>; }

# package core.impl.rt.natobjimpl.method
# Son clases usadas por las clases enhanced, no pueden ofuscarse, 
# algunas clases son clases base
# El caso del field jnieasyProxy es porque se debe preservar, 
# se usa su nombre en el enhancer

-keepclassmembers class * { protected static com.innowhere.jnieasy.core.method.NativeBehaviorReflection jnieasyProxy; }
-keep class com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.* { public protected <methods>; public static <fields>; }
-keep interface com.innowhere.jnieasy.core.impl.rt.natobjimpl.method.* { <methods>; }

# Clases con métodos nativos o con métodos llamados desde C++ (core.impl.jni)
-keep class com.innowhere.jnieasy.core.impl.jni.* { public protected <methods>; public static <fields>; }
# , están únicamente en impl.jni pero por si acaso
-keepclasseswithmembernames class * { native <methods>; }


# Recordamos la información de debug mínima para poder analizar un exception trace
-renamesourcefileattribute SourceFile
-keepattributes SourceFile,LineNumberTable         

# -verbose
# -printseeds
