package com.lqc.xiaohui.bubblesort;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/31 15:50
 */
public class OptimizedBubbleSort {
    /**
     * 优化V1版本冒泡,当这次循环中没有进行任何大小的置换,则说明顺序已经OK,无需进行后续的多余操作
     * @param arr
     */
    private void bubbleSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            boolean flag=false;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=temp;
                    flag=true;
                }
            }
            if(flag){
                break;
            }
        }
    }
}
