package multithreadings;

public class PrintEvenOddUsingTwoThread {

    int counter = 1;
    static int N;

    public void printOddNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(counter + " ");
                counter++;
                notify();
            }
        }
    }
    public void printEvenNumber() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (
                            InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(
                        counter + " ");

                counter++;
                notify();
            }
        }
    }

    public static void main(String[] args) {
        N = 10;
        PrintEvenOddUsingTwoThread mt = new PrintEvenOddUsingTwoThread();
        Thread t1 = new Thread(() -> mt.printEvenNumber());
        Thread t2 = new Thread(() -> mt.printOddNumber());

//        Runnable r2 = () -> {   // lambda expression
//            System.out.println("Runnable with Lambda Expression");
//        };
        t1.start();
        t2.start();
    }


}

