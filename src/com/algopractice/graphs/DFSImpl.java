package com.algopractice.graphs;

import java.util.Iterator;
import java.util.LinkedList;

public class DFSImpl {
    int v ;

    private LinkedList<Integer> adjlist[];





    @SuppressWarnings("unchecked")
    public DFSImpl(int v) {
        this.v = v;
        adjlist = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adjlist[i] = new LinkedList<>();
        }
    }

    private void addEdge(int src, int dest) {
        adjlist[src].add(dest);
        //adjlist[dest].add(src);
    }



    private boolean dfsHelper(int src, int dest) {
        boolean[] visited = new boolean[this.v];
        dfs(src, visited);
        return visited[dest];
    }

    private void dfs(int src, boolean[] visited) {
        if(visited[src]) return;
        visited[src] = true;

        Iterator<Integer> i = adjlist[src].listIterator();
        while(i.hasNext()){
            int n = i.next();
            if(!visited[n])
                dfs(n, visited);
        }
    }

    public static void main(String[] args) {
        DFSImpl graph = new DFSImpl(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println(graph.dfsHelper(2, 0));

    }


}
