public class WitamWatek extends Thread {
    public void run() {
        System.out.println("Witam z wątku");
    }
    public static void main(String args[]) {
        Thread t = new WitamWatek();
        t.start();
        System.out.println("Witam z programu");
    }
}