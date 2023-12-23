package com.algopractice.recursions;

public class MColoringProblem {
    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>();
        graph.addVertex(0);
        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        // Adding edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 0);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(2, 0);
        graph.addEdge(2, 1);
        graph.addEdge(3, 0);
        graph.addEdge(3, 1);

        MColoringProblem mColoringProblem = new MColoringProblem();
        int colors[] = new int[4];

        if(mColoringProblem.mColoringRec(0, graph, 4, colors, 2)){
            System.out.println("Matched");
        } else {
            System.out.println("Not Matched");
        };

    }

    private  boolean mColoringRec(int node, Graph<Integer> graph, int n, int[] colors, int m) {
        if(node==n){
            return true;
        }

        for (int color = 1; color <= m  ; color++) {
            if(isPossible(node, color, graph, colors)) {
                colors[node] = color;
                if(mColoringRec(node+1,graph, n, colors, m))
                    return true;
                colors[node] = 0;
            }

        }
        return false;
    }

    private static boolean isPossible(int node, int color, Graph<Integer> graph, int[] colors) {
        for(int it:graph.getAdjacentVertices(node)) {
            if(colors[it] == color) return false;
        }
        return true;
    }
}
