package com.lqc.xiaohui.interviewsuanfa;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/5 8:32
 */
public class 无序数组排序后的最大相邻差 {
    /**
     * 给出一个无序数组,求其排序后的最大相邻差
     * 肯定不是先排序再来做的
     */
    /**
     * 解法1
     *
     * @param nums 待排序数组
     * @return 最大相邻差
     */
    private int solution(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        //找完最大值和最小值,开始创数组空间
        int offset = min;
        int len = max - min + 1;
        int[] container = new int[len];
        for (int i : nums) {
            container[i - offset] = 1;
        }
        //数组里面放完了0,统计连续最长的0
        int maxCha = 0;
        int lenOfZero = 0;
        for (int i = 0; i < container.length; i++) {
            if (container[i] == 0) {
                lenOfZero++;
                if (lenOfZero > maxCha) {
                    maxCha = lenOfZero;
                }
            } else {
                lenOfZero = 0;
            }

        }
        return maxCha;
    }

    /**
     * 解法2,优化
     *
     * @param nums
     * @return
     */
    private static int solution2(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int max = nums[0];
        int min = nums[0];
        for (int i : nums) {
            if (max < i) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
        int d = max - min;
        if (max == min) {
            return 0;
        }
        // 计算桶个数
        int bucketSize = (Math.max(1,d / (nums.length - 1)));
        int bucketNum = (max - min) / bucketSize + 1;
        // 创建桶组
        Bucket[] buckets = new Bucket[bucketNum];
        // 放数据
        for (int i = 0; i < nums.length; ++i) {
            int bucketIndex = (nums[i]-min)/bucketSize;
            if(buckets[bucketIndex]==null){
                buckets[bucketIndex]=new Bucket();
            }
            buckets[bucketIndex].max=Math.max(nums[i],buckets[bucketIndex].max);
            buckets[bucketIndex].min=Math.min(nums[i],buckets[bucketIndex].min);
        }
        int previousMax = buckets[0].max; int maxGap = Integer.MIN_VALUE;
        for (int i = 1; i < buckets.length; i++) {
            if (buckets[i] != null ) {
                maxGap = Math.max(maxGap, buckets[i].min - previousMax);
                previousMax = buckets[i].max;
            }

        }
        return maxGap;
    }
    public static void main(String[] args){
        int[] nums={1,1,1,1,1,5,5,5,5,5};
        System.out.println(solution2(nums));
    }
}
