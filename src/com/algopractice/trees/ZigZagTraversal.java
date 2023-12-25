package com.algopractice.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagTraversal {

    public  TreeNode createTree(Integer[] arr, int index) {
        if (index >= arr.length || arr[index] == null) {
            return null;
        }

        TreeNode node = new TreeNode(arr[index]);
        node.left = createTree(arr, 2 * index + 1); // Left child index: 2*i+1
        node.right = createTree(arr, 2 * index + 2); // Right child index: 2*i+2

        return node;
    }

    public static void main(String[] args) {
        Integer[] input = {1, 2, 3, 4, 5, null, 6};
        ZigZagTraversal zigZagTraversal = new ZigZagTraversal();
        TreeNode root = zigZagTraversal.createTree(input, 0);
        List<List<Integer>> listans = zigZagTraversal.zigZagTraversal(root);
        for(List<Integer> ans : listans) {
            System.out.println(ans);
        }
    }

    private List<List<Integer>> zigZagTraversal(TreeNode node) {
        List<List<Integer>> ans = new ArrayList<>();
        if(node==null)
            return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        boolean leftRightTrue = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> rs = new LinkedList<>();

            for (int i = 0; i < size; i++) {
                TreeNode t = queue.peek();
                queue.poll();
                if(leftRightTrue) rs.add(t.val);
                else rs.add(0, t.val);

                if(t.left != null ) queue.offer(t.left);
                if(t.right != null) queue.offer(t.right);
            }
            leftRightTrue = !leftRightTrue;
            ans.add(new LinkedList<>(rs));
        }
        return ans;
    }
}
