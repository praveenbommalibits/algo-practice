package com.algopractice.heap_pq;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class KClosetPointsToOrigin {
    public static void main(String[] args) {
        KClosetPointsToOrigin pointsToOrigin = new KClosetPointsToOrigin();
        int points[][] = new int[][]{{3,3},{5,-1},{-2,4}};
        int[][] ans = pointsToOrigin.kClosest(points, 2);
        for (int[] point: ans) {
            System.out.println(point[0]+" " + point[1]);
        }
    }

    public int[][] kClosest(int[][] p, int k) {
        PriorityQueue<node> pq = new PriorityQueue<>((a,b) -> a.dis - b.dis);
        for(int i =0;i<p.length;i++){
            int total = p[i][0]*p[i][0] + p[i][1]*p[i][1];
            node n = new node(total,p[i][0],p[i][1]);
            pq.add(n);
        }
        int[][] ans = new int[k][2];
        for(int i =0;i<k && pq.size()>0;i++){
            node n = pq.poll();
            ans[i][0] = n.x;
            ans[i][1] = n.y;
        }
        return ans;
    }
}

    class node{
        node value;
        int dis;
        int x;
        int y;
        node(int dis, int x , int y){
            this.dis = dis;
            this.x = x;
            this.y = y;
        }
}
