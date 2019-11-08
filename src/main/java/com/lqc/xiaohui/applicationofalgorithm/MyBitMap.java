package com.lqc.xiaohui.applicationofalgorithm;


import java.util.BitSet;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/8 11:24
 */
public class MyBitMap {
    /**
     * 每一个word是个long类型元素,对应一个64位2进制数据
     */
    private long[] words;
    /**
     * word的个数
     */
    private int size;

    public MyBitMap(int size) {
        this.size = size;
        this.words = new long[getWordIndex(size - 1) + 1];
    }

    public boolean getBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过BitMap有效范围");
        }
        int wordIndex = getWordIndex(bitIndex);
        return (words[wordIndex] & (1L << bitIndex)) != 0;
    }

    public void setBit(int bitIndex){
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过BitMap有效范围");
        }
        //先定位到那个word
        int wordIndex=getWordIndex(bitIndex);
        words[wordIndex]|=(1L<<bitIndex);

    }

    private int getWordIndex(int index) {
        return index >> 6;
    }

}
