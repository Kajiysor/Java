import java.util.*;

public class Generics {
    public static void main(String[] args) {
        List<Integer> li = new ArrayList<Integer>();
        List<? extends Number> ln = li;
        li.add(35);
        System.out.println(li);
        // ln.add(35);
    }
}
