package com.lqc.xiaohui.erchashu;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author liqicong@myhexin.com
 * @date 2019/10/30 9:14
 */
public class PreOrderTraversal {
    /**
     * 前序遍历递归版
     * @param treeNode 根节点
     */
    private void diguiSolution(TreeNode treeNode){
        if(treeNode!=null){
            System.out.println(treeNode.val);
            diguiSolution(treeNode.left);
            diguiSolution(treeNode.right);
        }
    }

    /**
     * 前序遍历非递归版
     * @param root 根节点
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||!stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                list.add(root.val);
                root=root.left;
            }
            if(!stack.isEmpty()){
                root=stack.pop().right;
            }
        }
        return list;
    }

}