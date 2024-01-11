package com.algopractice.graphs;

import java.util.LinkedList;

public class DFSImpl {
    int v ;

    private LinkedList<Integer> adjlist[];
    boolean[] visited;

    public DFSImpl(int v) {
        this.v = v;
        adjlist = new LinkedList[v];
        visited = new boolean[v];
        for (int i = 0; i < v; i++) {
            adjlist[i] = new LinkedList<>();
        }
    }

    private void addEdge(int src, int dest) {
        adjlist[src].add(dest);
        //adjlist[dest].add(src);
    }

    public static void main(String[] args) {
        DFSImpl graph = new DFSImpl(6);
        int nodes = 5, edges=7;
        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,3);
        graph.addEdge(1,2);
        graph.addEdge(3,4);
        graph.addEdge(2,5);
        System.out.println(graph.dfsHelper(0,5));

    }

    private boolean dfsHelper(int src, int dest) {
        visited[src] = true;
        dfs(src, visited);
        return visited[dest];

    }

    private void dfs(int src, boolean[] visited) {
        if(visited[src]) return;
        for (int i = 0; i < adjlist[src].size(); i++) {
            int cv = adjlist[src].get(i);
            visited[cv] = true;
            dfs(cv, visited);
        }
    }


}
