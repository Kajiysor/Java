
public class JNIHello {
    static {
    System.loadLibrary("hello"); // nazwa biblioteki z kodem
    // natywnym, moze zalezec od systemu operacyjnego
    }
   
    // deklaracja metody natywnej (ktora znajduje się w bibliotece)
    private native void sayHello();
    public static void main(String[] args) {
    JNIHello h = new JNIHello();
    h.sayHello(); // wywolanie metody natywnej
    }
   }