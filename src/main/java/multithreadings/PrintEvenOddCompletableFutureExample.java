package multithreadings;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

public class PrintEvenOddCompletableFutureExample
{
    private static Object object = new Object();
    private static IntPredicate evenCond = e->e%2==0;
    private static IntPredicate oddCond = e->e%2!=0;

    public static void printNumber(IntPredicate condition)
    {
        IntStream.rangeClosed(1,10).filter(condition).forEach(PrintEvenOddCompletableFutureExample::execute);
    }

    public static void execute(int number)
    {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + ":" + number);
                object.notify();
                object.wait();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) throws InterruptedException {
       CompletableFuture.runAsync(()-> PrintEvenOddCompletableFutureExample.printNumber(oddCond));
        CompletableFuture.runAsync(()-> PrintEvenOddCompletableFutureExample.printNumber(evenCond));
        Thread.sleep(1000);
    }

}
