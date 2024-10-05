package Concurrency;

class ThreadDemo extends Thread {

    @Override
    public void run() {
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
    }

    public static void main(String[] args) {
        var t1 = new ThreadDemo();
        var t2 = new ThreadDemo();
        t1.start();
        t2.start();

        // Main Thread will wait for Thread t1 to complete the task first
        try {
            t1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Main Task Performed By " + Thread.currentThread().getName());
    }

}