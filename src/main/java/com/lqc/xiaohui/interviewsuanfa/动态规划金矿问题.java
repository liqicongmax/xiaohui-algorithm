package com.lqc.xiaohui.interviewsuanfa;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/7 9:59
 */
public class 动态规划金矿问题 {
    /**
     * @param w 矿工人数
     * @param p 开采金矿所需人数数组
     * @param g 金矿储量数组
     * @return 最大可以获取的金矿钱
     */
    public static int getBestGoldMining(int w, int[] p, int[] g) {
        int[] result = new int[w + 1];
        for (int i = 1; i <= g.length; i++) {
            for (int j = w; j >= 1; j--) {
                if (j >= p[i - 1]) {
                    result[j] = Math.max(result[j], result[j - p[i - 1]] + g[i - 1]);
                }
            }
        }
        return result[w];
    }

    /**
     *
     * @param w 矿工人数
     * @param n 剩余金矿数
     * @param p 开采金矿所需人数数组
     * @param g 金矿储量数组
     * @return 最大可以获取的金矿钱
     */
    public static int getMaxGold(int w,int n,int[] p,int[] g){
        if(w==0||n==0){
            return 0;
        }
        if(w<p[n-1]){
            return getMaxGold(w,n-1,p,g);
        }
        return Math.max(getMaxGold(w,n-1,p,g),getMaxGold(w-p[n-1],n-1,p,g)+g[n-1]);
    }

    public static void main(String[] args) {
        int workers = 10;
        int[] p = {5, 5, 3, 4, 3};
        int[] g = {400, 500, 200, 300, 350};
        System.out.println(getBestGoldMining(workers,p,g));
        System.out.println(getMaxGold(workers,5,p,g));
    }
}
