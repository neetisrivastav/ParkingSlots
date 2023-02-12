package multithreadings;

public class ClassLevelLockExample
{
    public void classLevelLockMethod()
    {
        synchronized (ClassLevelLockExample.class)
        {
            //DO your stuff here
        }
    }
}
