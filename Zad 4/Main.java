public class Main {

    public static void main(String[] args) {

        PQueue<String> pq = new PQueue<String>(3);
        pq.add("Ginger Snap", 0);
        pq.add("Natalie Attired", 3);
        pq.add("Emanuel", 2);
        pq.add("Gene", 3);
        pq.add("Kay", 2);

        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());
        System.out.println(pq.remove());

    }
}