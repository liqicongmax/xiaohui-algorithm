package com.lqc.xiaohui.interviewsuanfa;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/4 8:46
 */
public class GreatestCommonDivisor {
    private int getGreatestCommonDivisor(int a, int b) {
        if (a == b) {
            return a;
        }
        if ((a & 1) == 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor(a>>1, b>>1) << 1;
        } else if ((a & 1) == 0 && (b & 1) != 0) {
            return getGreatestCommonDivisor(a >> 1, b);
        } else if ((a & 1) != 0 && (b & 1) == 0) {
            return getGreatestCommonDivisor(a, b >> 1);
        } else {
            int max = a > b ? a : b;
            int min=a+b-max;
            return getGreatestCommonDivisor(max-min,min);
        }
    }

    public static void main(String[] args){
        System.out.println(new GreatestCommonDivisor().getGreatestCommonDivisor(2,4));
    }
}
