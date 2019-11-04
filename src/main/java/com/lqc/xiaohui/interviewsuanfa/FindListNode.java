package com.lqc.xiaohui.interviewsuanfa;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/4 10:58
 */
public class FindListNode {
    private int getListNodeLength(ListNode root) {
        ListNode t1 = root;
        ListNode t2 = root;
        while (t2 != null) {
            t1 = t1.next;
            t2 = t2.next.next;
            if (t1.val == t2.val) {
                int len = 1;//开始第二次走环,相遇了就算出长度了
                t1 = t1.next;
                t2 = t2.next.next;
                while (t1.val != t2.val) {
                    t1 = t1.next;
                    t2 = t2.next.next;
                    ++len;
                }
                return len;
            }
        }
        return -1;
    }

    private ListNode getEnterNode(ListNode root) {
        ListNode nul = null;
        ListNode t1 = root;
        ListNode t2 = root;
        while (t2 != null) {
            t1 = t1.next;
            t2 = t2.next.next;
            //找到公共交点了,此时t2回到开头,t1继续走,相遇时即入环点
            if (t1.val == t2.val) {
                t2 = root;
                while (t1.val != t2.val) {
                    t1 = t1.next;
                    t2 = t2.next;
                }
                return t1;
            }
        }
        return nul;
    }
}