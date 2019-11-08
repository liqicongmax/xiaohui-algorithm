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

    public int size() {
        return this.size;
    }

    public long[] getWords() {
        return this.words;
    }

    public void setWords(long[] words) {
        this.words = words;
    }

    public void setSize(int size) {
        this.size = size;
    }

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

    public void setBit(int bitIndex) {
        if (bitIndex < 0 || bitIndex > size - 1) {
            throw new IndexOutOfBoundsException("超过BitMap有效范围");
        }
        //先定位到那个word
        int wordIndex = getWordIndex(bitIndex);
        words[wordIndex] |= (1L << bitIndex);
    }

    private int getWordIndex(int index) {
        return index >> 6;
    }

    /**
     * 实现两个BitMap的与操作
     *
     * @param bitMap1 bitMap1
     * @param bitMap2 bitMap2
     * @return 与操作后的bitmap
     * 可能两个bitMap长度不一样
     */
    private MyBitMap and(MyBitMap bitMap1, MyBitMap bitMap2) {
        if (bitMap1.size() < bitMap2.size()) {
            return and(bitMap2, bitMap1);
        }
        MyBitMap myBitMap = new MyBitMap(bitMap1.size());
        long[] tempData =new long[bitMap1.size()];
        for (int i = 0; i < bitMap2.size(); i++) {
            tempData[i] = (bitMap1.getWords()[i] & bitMap2.getWords()[i]);
        }
        //把bitMap1剩余的数组接到tempData
        for(int i=bitMap2.size();i<bitMap1.size();i++){
            tempData[i]=bitMap1.getWords()[i];
        }
        myBitMap.setWords(tempData);
        return myBitMap;
    }

}