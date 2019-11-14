package com.lqc.xiaohui.interviewsuanfa;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/7 14:22
 */
public class 五行缺个整数 {
    /**
     * 1~100共n个数(所有数都有),98个整数出现了偶数次,2个整数出现了奇数次,求这个奇数
     *
     * @param nums
     * @return
     */
    public static int[] lackOfInteger(int[] nums) {
        int res = 0;
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (checkNum(nums[i], getFirst1(res))) {
                result[0] ^= nums[i];
            } else {
                result[1] ^= nums[i];

            }
        }
        //
        return result;
    }

    public static boolean checkNum(int num, int pos) {
        return ((num >> pos)&1) == 1;
    }

    //定位到两个数二进制表现下不一样的地方
    public static int getFirst1(int num) {
        int index = 0;
        while ((((num & 1) == 0)) && index < 32) {
            index++;
            num = (num >> 1);
        }
        return index;
    }
}
