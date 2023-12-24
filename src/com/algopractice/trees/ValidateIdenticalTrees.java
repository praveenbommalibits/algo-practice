package com.algopractice.trees;

public class ValidateIdenticalTrees {

    public static void main(String[] args) {

        TreeNode root1 = new TreeNode(-10);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(20);
        root1.right.left = new TreeNode(15);
        root1.right.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(-10);
        root2.left = new TreeNode(9);
        root2.right = new TreeNode(30);
        root2.right.left = new TreeNode(15);
        root2.right.right = new TreeNode(7);

        ValidateIdenticalTrees identicalTrees = new ValidateIdenticalTrees();
        System.out.println(identicalTrees.identicalCheck(root1, root2));


    }

    private boolean identicalCheck(TreeNode t1, TreeNode t2) {
        if(t1 == null || t2==null) {
            return t1==t2;
        }

        return (t1.val==t2.val) &&
                identicalCheck(t1.left, t2.left) &&
                identicalCheck(t1.right, t2.right);

    }
}
