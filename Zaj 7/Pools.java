import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Pools {
    public static void main(String[] args) {
        // ExecutorService es = Executors.newFixedThreadPool(5);
        ExecutorService es = Executors.newCachedThreadPool();

        for (int i = 1; i < 10; i++){
            final int id = i;
            es.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(id);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            System.out.println(i + " submitted");
        }
    }
}
