package com.lqc.xiaohui.interviewsuanfa;

import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2019/11/4 13:41
 * 生成最小栈
 */
public class MinimizedStack {
    private static final Stack<Integer> stack1 = new Stack<>();
    private static final Stack<Integer> stack2 = new Stack<>();

    private int pop() {
        int top = stack1.pop();
        if (stack2.size() > 0 && top <= stack2.peek()) {
            stack2.pop();
        }
        return top;
    }

    private void push(int i) {
        stack1.push(i);
        if(stack2.isEmpty()&&i<=stack2.peek()){
            stack2.push(i);
        }
    }

    private int getMin() {
        return stack2.peek();
    }
}
