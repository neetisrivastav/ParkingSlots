package multithreadings;

public class ObjectLevelLockExample
{
    public void objectLevelLockMethod()
    {
        synchronized (this)
        {
            //DO your stuff here
        }
    }
}

