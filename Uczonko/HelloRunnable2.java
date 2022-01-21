class HelloRunnable2{
    public static void main(String[] args) {
        Runnable task = new Runnable(){
            public void run() {
                System.out.println("Witam z watku");
            }
        };
        Thread t = new Thread(task);
        t.start();
        System.out.println("Witam z maina");
    }
}