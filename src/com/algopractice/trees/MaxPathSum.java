package com.algopractice.trees;

public class MaxPathSum {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);




        MaxPathSum maxPathSum = new MaxPathSum();
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        maxPathSum.maxPath(root, maxSum);
        System.out.println(maxSum[0]);
    }

    private int maxPath(TreeNode node, int[] maxSum) {

        if(node == null ) return 0;

        int lMax = Math.max(0, maxPath(node.left, maxSum));
        int rMax = Math.max(0, maxPath(node.right, maxSum));

        maxSum[0] = Math.max(maxSum[0], lMax+rMax+node.val);
        return node.val + Math.max(lMax, rMax);
    }
}
