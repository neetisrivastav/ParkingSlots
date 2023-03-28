package multithreadings;

class Company
{
    int n;
    boolean f= false;
    synchronized void produce_item(int n) throws Exception
    {
        if(f)
        {
            System.out.println("waiting before producer");
            wait(); //
            System.out.println("waiting after producer");
        }
        this.n = n;
        System.out.println("produced" +this.n);
        f = true;
        notify();
    }
    synchronized public int consume_item() throws Exception
    {
        if(!f)
        {
            System.out.println("waiting before consumer");
            wait();
            System.out.println("waiting after consumer");
        }
        System.out.println("consumed"+this.n);
        f=false;
        notify();
        return this.n;
    }
}

class Producer extends Thread
{
    Company c;

    Producer(Company c)
    {
        this.c = c;
    }
    public void run()
    {
        int i = 1;
        while (true)
        {
            try
            {
                this.c.produce_item(i);
                Thread.sleep(10000);
            }
            catch (Exception e){

            }
            i++;
        }
    }
}

class Consumer extends Thread
{
    Company c;
    Consumer(Company c)
    {
        this.c = c;
    }
    public void run()
    {
        while(true)
        {
            try {
                this.c.consume_item();
                Thread.sleep(1000);
    ;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class Mains
{
    public static void main(String[] args) {
        Company comp = new Company();
        Producer p = new Producer(comp);
        Consumer c = new Consumer(comp);
        p.start();
        c.start();
    }
}