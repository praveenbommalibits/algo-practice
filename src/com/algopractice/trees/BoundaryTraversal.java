package com.algopractice.trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryTraversal {

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5, 6,  7};

        TreeNode root = TreeBasics.createTree(input, 0);
        List<Integer> ans = new ArrayList<>();
        BoundaryTraversal boundaryTraversal = new BoundaryTraversal();
        boundaryTraversal.printBoundaryTraversal(root, ans);

        for (int a: ans) {
            System.out.println(a);
        }

    }

    private List<Integer> printBoundaryTraversal(TreeNode root, List<Integer> ans) {
        if(root == null) return ans;
        if(!isLeaf(root))
            ans.add(root.val);
        addleftBoundary(root, ans);
        addLeaves(root, ans);
        addrightBoundary(root, ans);
        return ans;
    }

    private void addrightBoundary(TreeNode root, List<Integer> ans) {
        TreeNode cur = root.right;
        List<Integer> tmp = new ArrayList<>();
        while(cur != null) {
            if(!isLeaf(cur)) tmp.add(cur.val);
            if(cur.right != null) cur = cur.right;
            else cur = cur.left;
        }
        for (int i = tmp.size()-1; i >=0 ; i--) {
            ans.add(tmp.get(i));
        }
    }

    private void addLeaves(TreeNode root, List<Integer> ans) {
        if(isLeaf(root)) {
            ans.add(root.val);
            return;
        }
        if(root.left != null) addLeaves(root.left, ans);
        if(root.right != null)  addLeaves(root.right, ans);
    }

    private void addleftBoundary(TreeNode root, List<Integer> ans) {
        TreeNode cur = root.left;
        while(cur !=null){
            if(!isLeaf(cur)) ans.add(cur.val);
            if(cur.left != null) cur = cur.left;
            else  cur = cur.right;
        }
    }

    private boolean isLeaf(TreeNode root) {
        return (root !=null) && (root.left==null) && (root.right ==null);
    }
}
