package Test1;

abstract public class MailRunnable implements Runnable
{
    private String ThreadName;

    public MailRunnable(String threadName)
    {
        ThreadName = threadName;
        System.out.printf("创建线程%s\n", ThreadName);
    }

    public String getThreadName()
    {
        return ThreadName;
    }

   /* public void setThreadName(String threadName)
    {
        ThreadName = threadName;
    }*/
}
