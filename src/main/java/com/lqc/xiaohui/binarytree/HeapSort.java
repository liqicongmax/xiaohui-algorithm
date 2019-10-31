package com.lqc.xiaohui.binarytree;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/30 13:21
 */
public class HeapSort {
    private void maxAdjust(int[] arr,int parentIndex,int length){
        int temp=arr[parentIndex];
        int childrenIndex=parentIndex*2+1;
        while(childrenIndex<length){
            if(childrenIndex+1<length&&arr[childrenIndex]<arr[childrenIndex+1]){
                childrenIndex++;
            }
            if(temp>arr[childrenIndex]){
                break;
            }
            arr[parentIndex]=arr[childrenIndex];
            parentIndex=childrenIndex;
            childrenIndex=childrenIndex*2+1;
        }
        arr[parentIndex]=temp;
    }

    private void maxHeapSort(int[] arr){
        for(int i=(arr.length-2)/2;i>=0;i--){
            maxAdjust(arr,i,arr.length);
        }
        for(int i=arr.length-1;i>=0;i--){
            int temp=arr[0];
            arr[0]=arr[i];
            arr[i]=temp;
            maxAdjust(arr,0,i);
        }
    }

    public static void main(String[] args){
        int[] arr={5,3,2,1,4};
        new HeapSort().maxHeapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
