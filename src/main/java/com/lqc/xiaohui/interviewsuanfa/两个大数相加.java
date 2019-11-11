package com.lqc.xiaohui.interviewsuanfa;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/6 15:38
 */
public class 两个大数相加 {
    public String add(String num1, String num2) {
        if(num2.length()>num1.length()){
            return add(num2,num1);
        }
        int[] arr1=strTonumArr(num1);
        int[] arr2=strTonumArr(num2);
        int[] result=new int[arr1.length+1];
        int carry=0;
        int sum=0;
        // 大数的尾巴开始加了
        for(int i=0;i<num2.length();i++){
            sum=arr1[i]+arr2[i]+carry;
            carry=sum/10;
            result[i]=sum%10;
        }
        for(int i=num2.length();i<num1.length();i++){
            sum=arr1[i]+carry;
            carry=sum/10;
            result[i]=sum%10;
        }
        if(carry==1){
            result[result.length-1]=1;
        }
        result=Arrays.copyOfRange(result,0,result.length-1);
        return numArrToStr(result);
    }

    private int[] strTonumArr(String num) {
        int[] arr = new int[num.length()];
        for (int i = num.length()-1; i >=0 ; i--) {
            arr[num.length()-1-i] = Integer.valueOf(String.valueOf(num.charAt(i)));
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
    private String numArrToStr(int[] nums){
        StringBuilder sb=new StringBuilder();
        for(int i:nums){
            sb.append(i);
        }
        return sb.toString();
    }
    public static void main(String[] args){
        System.out.println(new 两个大数相加().add("21311","999"));
    }
}
