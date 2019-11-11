package com.lqc.xiaohui.interviewsuanfa;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/6 13:25
 */
public class 删去K个数字后的最小值 {
    /**
     * 给出一个整数,从整数中去掉K个数字,要求剩下的数字尽可能小,如何选取被去掉的数字
     */
    public static String removeKdigits(String num, int k) {
        next:for(int j=0;j<k;j++) {
            for (int i = 0; i < num.length() - 1; i++) {
                if (num.charAt(i) > num.charAt(i + 1)) {
                    num=num.substring(0,i)+num.substring(i+1);
                    continue next;
                }
            }
            num=num.substring(0,num.length()-1);

        }
        num=removeZero(num);
        if(num.length()==0){
            return "0";
        }
        return num;
    }

    private static String removeZero(String num){
        for(int i=0;i<num.length()-1;i++){
            if(num.charAt(0)!='0'){
                break;
            }
            num=num.substring(1,num.length());
        }
        return num;
    }

    public static String solution(String num,int k){
        if(k==num.length()){
            return "0";
        }
        int newLength=num.length()-k;
        char[] stack=new char[num.length()];
        int top=0;
        for(int i=0;i<num.length();i++){
            char c=num.charAt(i);
            while(top>0&&stack[top-1]>c&&k>0){
                top-=1;
                k-=1;
            }
            stack[top++]=c;
        }
        int offset=0;
        while(offset<newLength&&stack[offset]=='0'){
            offset++;
        }
        return offset==newLength?"0":new String(stack,offset,newLength-offset);
    }
    public static void main(String[] args){
        System.out.println(solution("10022",2));

    }
}
