package com.algopractice.trees;

import java.util.*;

public class TopViewBT {

    class Tuple {
        TreeNode node;
        int vertex;

        public Tuple(TreeNode node, int vertex) {
            this.node = node;
            this.vertex = vertex;
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);

        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);


        root.right.right = new TreeNode(7);
        TopViewBT topViewBT= new TopViewBT();
        topViewBT.topViewbt(root);

    }

    private  void topViewbt(TreeNode root) {
        List<Integer> ans  = topviewHelper(root);
        for(Integer ele : ans) {
            System.out.print(ele +" ");
        }
    }

    private List<Integer> topviewHelper(TreeNode node) {

        List<Integer> ans = new ArrayList<>();
        if(node == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Tuple> queue = new LinkedList<>();
        queue.add(new Tuple(node, 0));

        while(!queue.isEmpty()) {
            Tuple t = queue.poll();
            TreeNode pNode = t.node;
            int v = t.vertex;
            if(!map.containsKey(v))
                map.put(v, pNode.val);

            if(pNode.left != null) queue.offer(new Tuple(pNode.left, v-1));
            if(pNode.right != null) queue.offer(new Tuple(pNode.right, v+1));

        }

        for(Map.Entry<Integer, Integer> mapEntry: map.entrySet()) {
            ans.add(mapEntry.getValue());
        }
        return ans;
    }
}
