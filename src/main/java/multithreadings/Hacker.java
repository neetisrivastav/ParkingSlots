package multithreadings;

class Hacker extends Thread{
    private volatile boolean stop_flag = true;
    public void stopRunning(){
        stop_flag = false;
    }

    @Override
    public void run()
    {
        while(stop_flag)
        {
            System.out.println("Thread is running...");
        }
    }
}

 class Main
{
    public static void main(String[] args) {
        Hacker stop_thread = new Hacker();
        stop_thread.start();
        try{
            Thread.sleep(0);
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        stop_thread.stopRunning();
    }
}
