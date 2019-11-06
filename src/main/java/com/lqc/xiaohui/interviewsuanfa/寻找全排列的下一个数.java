package com.lqc.xiaohui.interviewsuanfa;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/6 8:01
 */
public class 寻找全排列的下一个数 {
    /**
     * 通俗说就是在一个正整数所包含数字的全部组合中,找到一个大于且仅大于原数的新整数
     * 1.确定逆序区域
     * 2.找到逆序区域前一位的数字,在逆序区域里找到大于这个数的最小数并换位
     * 3.把逆序区域的数字转成有序的
     * 1244322739611
     * 273961
     * 276139
     */
    public static int nextInt(int[] nums){
        // 字典序没用
        int changeIndex=0;
        for(int i=nums.length-1;i>=1;i--){
            if(nums[i]>nums[i-1]){
                changeIndex=i;
                //找到第一个逆序区域即可退出
                break;
            }
        }
        //用这个数去找后面大于这个数中最小的一个
        int pos=changeIndex-1;
        int cur=nums[pos];
        int min=nums[changeIndex];
        for(int i=changeIndex;i<nums.length;i++){
            if(nums[i]>cur&&nums[i]<=min){
                    min=nums[i];
                    //nums[i]和cur换位了
                int temp=nums[pos];
                nums[pos]=nums[i];
                nums[i]=temp;
            }
        }
        // 调整逆序区域,从小到大
        int[] tail=Arrays.copyOfRange(nums,changeIndex,nums.length);
        Arrays.sort(tail);
        int[] head=Arrays.copyOfRange(nums,0,changeIndex);
        int[] total=new int[tail.length+head.length];
        for(int i=0;i<head.length;i++){
            total[i]=head[i];
        }
        for(int i=0;i<tail.length;i++){
            total[i+head.length]=tail[i];
        }
        System.out.println(Arrays.toString(total));
        return 0;
    }
    public static void main(String[] args){
        nextInt(new int[]{2,7,3,9,6,1});
    }
}
