package com.lqc.xiaohui.erchashu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/30 10:15
 */
public class InOrderTraversal {
    /**
     * 中序遍历递归
     *
     * @param root 根节点
     */
    private void diguiSolution(TreeNode root) {
        if (root != null) {
            diguiSolution(root.left);
            System.out.println(root.val);
            diguiSolution(root.right);
        }
    }

    /**
     * 中序遍历非递归
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
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            list.add(root.val);
            root = root.right;
        }


        return list;
    }
}
