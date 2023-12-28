package com.algopractice.trees;

public class SymmetricBT {
    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);


        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);


        root.right.right = new TreeNode(3);

        SymmetricBT symmetricBT = new SymmetricBT();
        System.out.println(symmetricBT.isSymmetric(root));
    }

    private boolean isSymmetric(TreeNode root) {

        return isSymmetricHelper(root.left, root.right);
    }

    private boolean isSymmetricHelper(TreeNode lNode, TreeNode rNode) {
        if(lNode == null|| rNode==null)
            return lNode==rNode;

        if(lNode.val != rNode.val)
            return false;

        return isSymmetricHelper(lNode.left, rNode.right) &&
                isSymmetricHelper(lNode.right, rNode.left);

    }
}
