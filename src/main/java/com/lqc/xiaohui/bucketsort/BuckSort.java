package com.lqc.xiaohui.bucketsort;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/1 9:53
 */
public class BuckSort {
    private void buckSort(int[] arr) {
        int max = arr[0];
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        int bucketCount = (max - min) / (arr.length - 1);
        int[][] buckets=new int[bucketCount][];
        for(int i=0;i<arr.length;i++){
            int index=(int)Math.floor((arr[i]-min)/(arr.length-1));
            arrAppend(buckets[index],arr[i]);
        }
//        for(int i=0;i<buckets.length;)
    }
    private int[] arrAppend(int[] arr, int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }
}
