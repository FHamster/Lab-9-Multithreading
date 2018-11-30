package Test2;

import sun.security.util.Length;

import java.util.Scanner;

public class Main
{
    public static void Dispatch(int total, int PartN)
    {
        int length = total / PartN;
        Thread[] workers = new Thread[PartN];

        for (int i = 0; i < workers.length; i++)
        {
//            workers[i] = new Thread(new SumWorker(length * i, length * (i + 1)));
        }
        for (int i = 0; i < workers.length; i++)
        {
            try
            {
                workers[i].join();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < workers.length; i++)
        {
            workers[i].start();
        }


    }

    public static void main(String[] args) throws InterruptedException
    {
//        SumWorker worker = new SumWorker();
//        Thread thread = new Thread(worker);
//        int upLimit = 100000000;
        int upLimit = 1000;
        System.out.println(upLimit);
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int step = upLimit / n;

        if (100 % n != 0)
        {
            n++;
        }
        Thread[] threads = new Thread[n];

        int min, max;
        for (int i = 0; i < threads.length; i++)
        {
            min = i * step;
            max = (i + 1) * step;
            if (max >= upLimit)
            {
                max = upLimit + 1;
            }
            threads[i] = new Thread(new SumWorker(min, max));
        }
        for (Thread x : threads)
        {
            x.start();
        }
        for (Thread x : threads)
        {
           x.join();
        }

        System.out.println(SumWorker.getSum());
    }

}
