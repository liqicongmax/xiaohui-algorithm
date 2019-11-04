package com.lqc.xiaohui.bubblesort;

import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/31 16:19
 */
public class CocktailSort {
    /**
     * 鸡尾酒排序,先从左往右把最大的排出来
     *
     * @param arr
     */
    private void cocktailSort(int[] arr) {
        for (int i = 0; i < (arr.length / 2); i++) {

        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 5, 2};
        new CocktailSort().cocktailSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
