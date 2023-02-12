package multithreadings;

//print sequence number using 3 threads
class SequenceGenerator implements Runnable {
    private static final int MAX = 10;
    private static final int NUMBER_OF_THREADS = 3;
    static int number = 1;
    int remainder;
    static final Object obj = new Object();

    public SequenceGenerator(int remainder) {
        this.remainder = remainder;
    }

    @Override
    public void run() {
        while (number < MAX - 1) {
            synchronized (obj) {
                while (number % NUMBER_OF_THREADS != remainder) {    // wait for numbers other than the threadNumber.
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number++);
                obj.notifyAll();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new SequenceGenerator(1), "T1"); // 1 represents Thread-1 remainder
        Thread t2 = new Thread(new SequenceGenerator(2), "T2"); // 2 represents Thread-2 remainder
        Thread t3 = new Thread(new SequenceGenerator(0), "T3"); // 0 represents Thread-3 remainder
        t1.start();
        t2.start();
        t3.start();
    }
}
