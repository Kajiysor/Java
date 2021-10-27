import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.Vector;

public class Kolekcje{

    public static void initializeCollection(Collection<Integer> c){
        Date d0 = new Date();
        for (int i = 0; i<1000000; i++){
            c.add((int)(Math.random()*2000000000));
        }
        Date d1 = new Date();
        System.out.println("Zainicjalizowano w czasie " + (d1.getTime() - d0.getTime()) + "[ms]");
    }

    public static void testCollection(Collection<Integer> c){
        Date d0 = new Date();
        int counter = 0;
        for (int i = 1; i < 10000; i++){
            int k = (int)(Math.random()*2000000000);
            if (c.contains(k)){
                counter++;
            }
        }
        Date d1 = new Date();
        System.out.println("Znaleziono " + counter + " w czasie " + (d1.getTime() - d0.getTime() + "[ms]"));

    }

    public static void testArrayList() {
        ArrayList<Integer> al = new ArrayList<>();
        Kolekcje.initializeCollection(al);
        Kolekcje.testCollection(al);
    }

    public static void testVector(){
        Vector<Integer> v = new Vector<>();
        Kolekcje.initializeCollection(v);
        Kolekcje.testCollection(v);
    }

    public static void testTreeSet(){
        TreeSet<Integer> ts = new TreeSet<>();
        Kolekcje.initializeCollection(ts);
        Kolekcje.testCollection(ts);
    }

    public static void testHashSet(){
        HashSet<Integer> hs = new HashSet<>();
        Kolekcje.initializeCollection(hs);
        Kolekcje.testCollection(hs);
    }
    public static void main(String[] args) {
        System.out.println("Array list: ");
        Kolekcje.testArrayList();
        System.out.println("Vector: ");
        Kolekcje.testVector();
        System.out.println("Tree Set: ");
        Kolekcje.testTreeSet();
        System.out.println("Hash Set: ");
        Kolekcje.testHashSet();
    }
}