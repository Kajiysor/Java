import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Field;

public class Test {
    public static String s;
    public int i;

    // public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException, SecurityException, InstantiationException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
    //     Test c = (Test) Class.forName("Test").getDeclaredConstructor().newInstance();
    //     c.getClass().getField("i").set(c, 10);
    //     System.out.println(c.i);
    // }

    public static void main(String[] args) throws Exception{
        Test test = new Test();
        Field t;
        t = Test.class.getField("s");
        t.get(null); // zwróci null bo s nie zainicjowane
        t.set(null, "Ala"); // FieldExamle.s = “Ala”
        t = test.getClass().getField("i");
        t.set(test, 10); // fex.i = 10
    }
}
