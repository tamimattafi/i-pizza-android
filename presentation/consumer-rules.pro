-keep public class * implements com.bumptech.glide.module.GlideModule
-keep class * extends com.bumptech.glide.module.AppGlideModule {
 <init>(...);
}
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}
-keep class com.bumptech.glide.load.data.ParcelFileDescriptorRewinder$InternalRewinder {
  *** rewind();
}

-repackageclasses
-optimizations !method/removal/parameter,!code/simplification/variable,!code/simplification/cast,!code/simplification/field,!code/removal/variable,!field/marking/private

-assumenosideeffects class android.util.Log {
 public static *** d(...);
 public static *** i(...);
 public static *** v(...);
 public static *** w(...);
 public static *** e(...);
}

-keepattributes SourceFile,LineNumberTable        # Keep file names and line numbers.
-keep public class * extends java.lang.Exception  # Optional: Keep custom exceptions.