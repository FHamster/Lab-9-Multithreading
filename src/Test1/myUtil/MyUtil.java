package Test1.myUtil;

import java.util.*;

public class MyUtil
{

    /**
     * @param
     * @return 返回分布在[0, upLimit]的随机整数
     */
    public static int getRandomNumber(int upLimit)
    {
        return new Random().nextInt(upLimit + 1);
    }

    /**
     * @param min
     * @param max
     * @return 返回分布在[min, max]的随机整数
     */
    public static int getRandomNumber(int min, int max)
    {
        if (min > max)
        {
            throw new IllegalArgumentException("min =" + min + ">" + "max=" + max);
        }
        return min + new Random().nextInt(max + 1 - min);
    }
}
