public class HelloRunnable implements Runnable {
    public void run() {
        System.out.println("Witam z watku");
    }
    public static void main(String args[]) {
        Thread t = new Thread(new HelloRunnable());
        t.start();
        System.out.println("Witam z programu");
    }
}
