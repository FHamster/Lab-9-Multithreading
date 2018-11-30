package Test1;

import Test1.myUtil.MyUtil;

public class ReceiveMailRunnable extends MailRunnable
{
    public ReceiveMailRunnable(String threadName)
    {
        super(threadName);
    }

    @Override
    public void run()
    {
        int n = MyUtil.getRandomNumber(10, 20);
        for (int i = 0; i < n ; i++)
        {
            System.out.printf("%s is receiving emails\n", getThreadName());
            try
            {
                Thread.sleep(MyUtil.getRandomNumber(1000, 2000));
            } catch (InterruptedException e)
            {
//                e.printStackTrace();
                System.err.println("interrupted");
            }
        }
        System.out.printf("当前线程%s正要退出\n", getThreadName());
    }
}