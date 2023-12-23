package com.algopractice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeBasics {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String[] args) {
        TreeBasics basics = new TreeBasics();

        TreeNode root = basics.treeRepresentation();
        System.out.println("Pre Order : ");
        basics.preOrderTraversal(root);
        System.out.println("\nIn Order : ");
        basics.inOrderTraversal(root);
        System.out.println("\nPost Order : ");
        basics.postOrderTraversal(root);

        System.out.println("\n Level Order : ");
        List<List<Integer>> listans = basics.levelOrderTraversal(root);
        for(List<Integer> ans: listans) {
            System.out.println(ans);
        }



    }

    private List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue =  new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if(root == null) return wrapList;
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelnum  = queue.size();
            List<Integer> subList =new LinkedList<>();

            for (int i = 0; i < levelnum; i++) {
                if(queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if(queue.peek().right != null)
                    queue.offer(queue.peek().right);

                subList.add(queue.poll().val);
            }
            wrapList.add(new LinkedList<>(subList));
        }

        return wrapList;
    }

    private void postOrderTraversal(TreeNode root) {
        if(root == null ) return;
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
        System.out.print(" "+ root.val);
    }

    private void inOrderTraversal(TreeNode root) {
        if(root == null ) return;
        preOrderTraversal(root.left);
        System.out.print(" "+ root.val);
        preOrderTraversal(root.right);
    }

    private void preOrderTraversal(TreeNode root) {
        if(root == null ) return;
        System.out.print(" "+ root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    private TreeNode treeRepresentation() {
        TreeNode root  = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        return root;


    }
}
