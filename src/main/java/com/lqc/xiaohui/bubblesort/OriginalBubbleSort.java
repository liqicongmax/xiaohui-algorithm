package com.lqc.xiaohui.bubblesort;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/31 15:37
 */
public class OriginalBubbleSort {
    /**
     * 冒泡排序V1
     * 基础冒泡排序
     * @param arr 待排序数组
     */
    private void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                }
            }
        }
    }
    public static void main(String[] args){
        int[] arr={3,1,2,4,5};
        new OriginalBubbleSort().bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}