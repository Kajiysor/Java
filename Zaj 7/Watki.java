public class Watki {

    boolean flag = true;

    public synchronized void changeFlag(){
        this.flag = !this.flag;
        if (this.flag){
            System.out.println("Zwolnienie blokady");
            notifyAll(); // budzi wszystkie watki
            // notify(); // budzi jeden watek
        }
    }

    public synchronized void print(String s){ // Synchronized korzysta z blokady obiektu
        while (!this.flag){
            try {
                System.out.println("Czekam zeby wypisac: " + s);
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        changeFlag();
        for (int i = 0; i < 10; i++){
            System.out.println(i + " " + s);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        final Watki w1 = new Watki(); // w2 = new Watki();
        Thread t1 = new Thread(new Runnable(){
            public void run(){
                for (int i = 0; i < 10; i++){
                    w1.print("(" + i + ")" + " Pierwszy watek"); // w1 -> jedna blokada 
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){
            public void run(){
                for (int i = 0; i < 10; i++){
                    w1.print("(" + i + ")" + " Drugi watek"); // w2 -> druga blokada
                }
            }
        });

        Thread t3 = new Thread(new Runnable() {
            public void run(){
                for (int i = 0; i < 50; i++){
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    w1.changeFlag();
                }
            }
        });
        t1.start();
        // t1.join();
        t2.start();
        t3.start();
    }
}
