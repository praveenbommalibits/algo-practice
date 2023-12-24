package com.algopractice.trees;

public class BalancedBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        root.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        BalancedBT balancedBT = new BalancedBT();
        if(balancedBT.validateBalanceTree(root) != -1)
            System.out.println("Balanced");
        else
            System.out.println("UnBalanced");

    }

    private int validateBalanceTree(TreeNode root) {

        if(root == null) return  0;

        int lh= validateBalanceTree(root.left);
        if(lh ==-1) return -1;
        int rh = validateBalanceTree(root.right);
        if(rh==-1) return -1;

        if(Math.abs(lh-rh) > 1) return -1;
        return Math.max(lh, rh) +1;
    }
}
