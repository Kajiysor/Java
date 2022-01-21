public class Deadlock {

    static class Worker {
        public String name;
        public Worker(String name) {
            this.name = name;
        }
        public synchronized void doWork(Worker w){
            System.out.println(this.name + " pracuje z " + w.name);
        try {
            Thread.sleep(1000); // pracujemy
        } catch (InterruptedException e) { }
            w.release();
        }
        public synchronized void release() {
            System.out.println(this.name + " jest znowu gotowy");
        }
    }
    public static void main(String[] args) {
            final Worker w1 = new Worker("w1");
            final Worker w2 = new Worker("w2");
            new Thread(new Runnable() {
                public void run() { w1.doWork(w2); }
            }).start();
            
            new Thread(new Runnable() {
                public void run() { w2.doWork(w1); }
            }).start();
        }
}