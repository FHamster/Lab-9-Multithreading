package Test1;

public class ThreadTest
{
    public static void main(String[] args)
    {
//        Thread receive = new Thread(new ReceiveMailRunnable("thread-1"));
        Thread[] threads = new Thread[6];
        threads[0] = new Thread(new ReceiveMailRunnable("ReceiveThread-0"));
        threads[1] = new Thread(new ReceiveMailRunnable("ReceiveThread-1"));
        threads[2] = new Thread(new ReceiveMailRunnable("ReceiveThread-2"));
        threads[3] = new Thread(new SendMailRunnable("SendThread-2"));
        threads[4] = new Thread(new SendMailRunnable("SendThread-2"));
        threads[5] = new Thread(new SendMailRunnable("SendThread-2"));

        for (int i = 0; i < threads.length; i++)
        {
            threads[i].start();
        }

        for (int i = 0; i < threads.length; i++)
        {
            try
            {
                threads[i].join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("foxmail任务结束");
    }
}
