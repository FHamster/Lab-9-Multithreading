package Test2;

import sun.security.util.Length;

import java.util.Scanner;

public class Main
{
    public static void Dispatch(int total, int PartN)
    {


    }

    public static void main(String[] args) throws InterruptedException
    {
//        SumWorker worker = new SumWorker();
//        Thread thread = new Thread(worker);
//        int upLimit = 100000000;


        int upLimit = 100000000;
        System.out.println("upLimit is " + upLimit);
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        //记时开始
        long startTime = System.currentTimeMillis();

        int step = upLimit / n;

        if (upLimit % n != 0)
        {
            n++;
        }
        Thread[] threads = new Thread[n];
        SumWorker[] workers = new SumWorker[n];
        int min, max;
        for (int i = 0; i < threads.length; i++)
        {
            min = i * step;
            max = (i + 1) * step;
            if (max >= upLimit)
            {
                max = upLimit + 1;
            }
            workers[i] = new SumWorker(min, max);
        }

        int i = 0;
        for (SumWorker x : workers)
        {
            threads[i++] = new Thread(x);
        }

        for (Thread x : threads)
        {
            x.start();
        }
        for (Thread x : threads)
        {
            x.join();
        }

        long sum = 0;
        for (SumWorker x : workers)
        {
            System.out.println(x.getPartSum());
            sum += x.getPartSum();
        }

        //记时结束
        long endTime = System.currentTimeMillis();
        long Time = endTime - startTime;
        System.out.println(Time);
        System.out.println(sum);
    }

}
