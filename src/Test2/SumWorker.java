package Test2;


public class SumWorker implements Runnable
{
//    private int i = 0;
    private int min = 0;
    private int max = 0;
    private static long sum = 0;

    public SumWorker(int min, int max)
    {
        this.min = min;
        this.max = max;
    }

    public long getResult()
    {
        return sum;
    }

    @Override
    public void run()
    {
        for (int i = min; i < max; i++)
        {
            add(i);
        }
    }

    private synchronized void add(int n)
    {
        System.out.printf("%s %d\n",Thread.currentThread().getName(),n);
        sum += n;
    }

    public static long getSum()
    {
        return sum;
    }
}
