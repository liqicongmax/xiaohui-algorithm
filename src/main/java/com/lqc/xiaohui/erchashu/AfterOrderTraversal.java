package com.lqc.xiaohui.erchashu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/30 10:32
 */
public class AfterOrderTraversal {
    /**
     * 后序遍历递归
     *
     * @param root 根节点
     */
    private void diguiSolution(TreeNode root) {
        if (root != null) {
            diguiSolution(root.left);
            diguiSolution(root.right);
            System.out.println(root.val);
        }
    }

    /**
     * 后序遍历非递归
     *
     * @param root 根节点
     * @return 遍历结果集合
     */
    private List<Integer> solution(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                stack1.push(root);
                root = root.right;
            }
            if (!stack.isEmpty()) {
                root = stack.pop().left;
            }

        }
        while (!stack1.isEmpty()) {
            list.add(stack1.pop().val);
        }

        return list;
    }

    private List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                list.addFirst(root.val);
                stack.push(root);
                root=root.right;
            }else{
                root=stack.pop();
                root=root.left;
            }
        }
        return list;
    }
}
