package com.lqc.xiaohui.applicationofalgorithm;

import java.util.HashMap;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/8 15:36
 */
public class MyLRUCache {
    /**
     * 定义LRU缓存的最大保存个数
     */
    private int limit;
    private Node head;
    private Node end;
    private HashMap<String,Node> hashMap;
    public MyLRUCache(int limit){
        this.limit=limit;
        hashMap=new HashMap<>();
    }

    class Node{
        Node(String key,String value){
            this.key=key;
            this.value=value;
        }
        public Node pre;
        public Node next;
        public String key;
        public String value;
    }

    public void put(String key,String value){
        Node node=hashMap.get(key);
        if(end!=null){
            end.next=node;
            node.pre=end;
            node.next=null;
        }else{
            end=node;
            if(head==null){
                head=node;
            }
        }
    }

    /**
     * todo
     * @param node
     */
    private void addNode(Node node){

    }
}