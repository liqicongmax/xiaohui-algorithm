package com.lqc.xiaohui.interviewsuanfa;

import java.util.Arrays;
import java.util.Random;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/11 17:14
 */
public class 发红包算法 {
    static Random random = new Random();

    static {
        random.setSeed(System.currentTimeMillis());
    }

    public void hb() {
        // 金额，个数，最少值
        int total = 10000;
        int num = 25;
        int min = 100;
        for (int i = 1; i < num; i++) {
            int safe_total = (total - (num - i) * min) / (num - i);
            int money = (int) (Math.random() * (safe_total - min) + min);
            total = total - money;

            System.out.println("第" + i + "个红包：" + money + ",余额为:" + total + "元");
        }
        System.out.println("第" + num + "个红包：" + total + ",余额为:0元");
    }

    /**
     * 生产min和max之间的随机数，但是概率不是平均的，从min到max方向概率逐渐加大。
     * 先平方，然后产生一个平方值范围内的随机数，再开方，这样就产生了一种“膨胀”再“收缩”的效果。
     *
     * @param min
     * @param max
     * @return
     */
    static long xRandom(long min, long max) {
        return sqrt(nextLong(sqr(max - min)));
    }

    static long sqrt(long n) {
        // 改进为查表？
        return (long) Math.sqrt(n);
    }

    static long sqr(long n) {
        // 查表快，还是直接算快？
        return n * n;
    }

    static long nextLong(long n) {
        return random.nextInt((int) n);
    }

    static long nextLong(long min, long max) {
        return random.nextInt((int) (max - min + 1)) + min;
    }

    /**
     * @param total 红包总额
     * @param count 红包个数
     * @param max   每个小红包的最大额
     * @param min   每个小红包的最小额
     * @return 存放生成的每个小红包的值的数组
     */
    public static long[] generate(long total, int count, long max, long min) {
        long[] result = new long[count];
        long average = total / count;
        long a = average - min;
        long b = max - min;
        //
        // 这样的随机数的概率实际改变了，产生大数的可能性要比产生小数的概率要小。
        // 这样就实现了大部分红包的值在平均数附近。大红包和小红包比较少。
        long range1 = sqr(average - min);
        long range2 = sqr(max - average);
        for (int i = 0; i < result.length; i++) {
            // 因为小红包的数量通常是要比大红包的数量要多的，因为这里的概率要调换过来。
            // 当随机数>平均值，则产生小红包
            // 当随机数<平均值，则产生大红包
            if (nextLong(min, max) > average) {
                // 在平均线上减钱
                // long temp = min + sqrt(nextLong(range1));
                long temp = min + xRandom(min, average);
                result[i] = temp;
                total -= temp;
            } else {
                // 在平均线上加钱
                // long temp = max - sqrt(nextLong(range2));
                long temp = max - xRandom(average, max);
                result[i] = temp;
                total -= temp;
            }
        }
        // 如果还有余钱，则尝试加到小红包里，如果加不进去，则尝试下一个。
        while (total > 0) {
            for (int i = 0; i < result.length; i++) {
                if (total > 0 && result[i] < max) {
                    result[i]++;
                    total--;
                }
            }
        }
        // 如果钱是负数了，还得从已生成的小红包中抽取回来
        while (total < 0) {
            for (int i = 0; i < result.length; i++) {
                if (total < 0 && result[i] > min) {
                    result[i]--;
                    total++;
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        long[] bags=generate(1000L,20,300,10);
        System.out.println(Arrays.toString(bags));
    }
}
