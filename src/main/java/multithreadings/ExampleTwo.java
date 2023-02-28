package multithreadings;

class ExampleTwo extends Thread{
    public void run()
    {
        for (int h =1 ;h<=3 ;h++)
        {
            try
            {
                Thread.sleep(10);
            }
            catch (Exception e)
            {
                System.out.println("hello");
            }
            System.out.println(h+" ");
        }
    }

    public static void main(String[] args) {
        ExampleTwo e1 = new ExampleTwo();
        ExampleTwo e2 = new ExampleTwo();
        e1.setPriority(Thread.MAX_PRIORITY);
        e2.setPriority(Thread.MIN_PRIORITY);

        try
        {
            e1.join();
        }
        catch (Exception e)
        {
            System.out.println("hi");
        }
        e2.start();
    }
}
