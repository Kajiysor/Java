import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;


public class testKolekcje{

    public static void initializeCollection(Collection<Integer> c){
        Date d0 = new Date();
        for (int i = 0; i<1000000; i++){
            c.add((int)(Math.random()*2000000000));
        }
        Date d1 = new Date();
        System.out.println("Zainicjalizowano w czasie " + (d1.getTime() - d0.getTime()) + "[ms]");
    }

    public static void testFind(Collection<Integer> c){
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

    public static void testRemove(Collection<Integer> c){
        Date d0 = new Date();
        int counter = 0;
        for (int i = 0; i < 10000; i++){
            c.remove(i);
            counter ++;
        }
        Date d1 = new Date();
        System.out.println("Usunieto " + counter + " elementow w czasie "+ (d1.getTime() - d0.getTime() + "[ms]"));
    }

    public static void testToArray(Collection<Integer> c){
        Date d0 = new Date();
        c.toArray();
        Date d1 = new Date();
        System.out.println("Wykonano funkcje toArray() w czasie "+ (d1.getTime() - d0.getTime() + "[ms]"));
    }

    public static void testArrayList() {
        ArrayList<Integer> al = new ArrayList<>();
        System.out.println("Array list: ");
        testKolekcje.initializeCollection(al);
        testKolekcje.testFind(al);
        testKolekcje.testRemove(al);
        //Kolekcje.testToArray(al);
    }

    public static void testVector(){
        Vector<Integer> v = new Vector<>();
        System.out.println("Vector: ");
        testKolekcje.initializeCollection(v);
        testKolekcje.testFind(v);
        testKolekcje.testRemove(v);
        //Kolekcje.testToArray(v);
    }

    public static void testTreeSet(){
        TreeSet<Integer> ts = new TreeSet<>();
        System.out.println("Tree Set: ");
        testKolekcje.initializeCollection(ts);
        testKolekcje.testFind(ts);
        testKolekcje.testRemove(ts);
        //Kolekcje.testToArray(ts);
    }

    public static void testHashSet(){
        HashSet<Integer> hs = new HashSet<>();
        System.out.println("Hash Set: ");
        testKolekcje.initializeCollection(hs);
        testKolekcje.testFind(hs);
        testKolekcje.testRemove(hs);
        //Kolekcje.testToArray(hs);
    }

    public static void testLinkedList(){
        LinkedList<Integer> ll = new LinkedList<>();
        System.out.println("Linked List: ");
        testKolekcje.initializeCollection(ll);
        testKolekcje.testFind(ll);
        testKolekcje.testRemove(ll);
        //Kolekcje.testToArray(ll);
    }

    public static void testStack(){
        Stack<Integer> s = new Stack<>();
        System.out.println("Stack: ");
        testKolekcje.initializeCollection(s);
        testKolekcje.testFind(s);
        testKolekcje.testRemove(s);
        //Kolekcje.testToArray(s);
    }

    public static void testPriorityQueue(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        System.out.println("Priority Queue: ");
        testKolekcje.initializeCollection(pq);
        testKolekcje.testFind(pq);
        testKolekcje.testRemove(pq);
        //Kolekcje.testToArray(pq);
    }
    public static void main(String[] args) {
        System.out.println("====================================");
        testKolekcje.testArrayList();
        System.out.println("====================================");
        testKolekcje.testVector();
        System.out.println("====================================");
        testKolekcje.testTreeSet();
        System.out.println("====================================");
        testKolekcje.testHashSet();
        System.out.println("====================================");
        testKolekcje.testLinkedList();
        System.out.println("====================================");
        testKolekcje.testStack();
        System.out.println("====================================");
        testKolekcje.testPriorityQueue();
        System.out.println("====================================");
    }
}