package com.algopractice.trees;

public class DiameterBT {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.left.left = new TreeNode(5);
        root.right.left.left.left = new TreeNode(6);


        root.right.right = new TreeNode(7);
        root.right.right.right = new TreeNode(8);
        root.right.right.right.right = new TreeNode(9);

        DiameterBT diameterBT = new DiameterBT();
        int[] diameter = new int[1];
        diameterBT.findMaxDiameter(root,diameter);
        System.out.println(diameter[0]);

    }

    private int findMaxDiameter(TreeNode root, int[] diameter) {

        if(root == null) return 0;

        int lh = findMaxDiameter(root.left, diameter);
        int rh = findMaxDiameter(root.right, diameter);
        diameter[0] = Math.max(diameter[0], (lh+rh));

        return 1+ Math.max(lh,rh);

    }
}
