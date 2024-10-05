package Concurrency;

public class RunnableDemo implements Runnable {

    static Thread mainThread;

    @Override
    public void run() {
        try {
            // Main Thread will execute first
            mainThread.join();

            for (int i = 0; i < 3; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out
                        .println("Thread Task " + i + " with Priority " + Thread.currentThread().getPriority()
                                + " Peformed By "
                                + Thread.currentThread().getName());
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        mainThread = Thread.currentThread();
        var obj = new RunnableDemo();
        Thread t1 = new Thread(obj);
        Thread t2 = new Thread(obj);
        t1.start();
        t2.start();

        System.out.println("Main Task Peformed By " + Thread.currentThread().getName());
    }

}
