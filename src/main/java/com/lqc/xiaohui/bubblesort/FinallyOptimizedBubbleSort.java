package com.lqc.xiaohui.bubblesort;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/31 15:56
 */
public class FinallyOptimizedBubbleSort {
    /**
     * 目前的最终版本.双重优化
     * 记录最后一次换位的位置,在这之后的肯定都是有序了
     * @param arr 待排序的数组
     */
    private void bubbleSort(int[] arr){
        int lastIndex=arr.length-1;
        int pos=0;
        for(int i=0;i<arr.length-1;i++){
            boolean flag=false;
            for(int j=0;j<lastIndex;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                    pos=j;
                }
            }
            if(flag){
                break;
            }
            lastIndex=pos;
        }
    }
    public static void main(String[] args){
        int[] arr={3,1,2,4,5};
        new FinallyOptimizedBubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}