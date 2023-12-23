package com.algopractice.recursions;

import java.util.*;

public class Graph<T> {
    Map<T, List<T>> adjacencyList;

    public Graph() {
        this.adjacencyList = new HashMap<>();
    }



    void addVertex(T element) {
        adjacencyList.putIfAbsent(element, new ArrayList<>());
    }



    void addEdge(T source, T destination) {
        adjacencyList.computeIfAbsent(source, k-> new ArrayList<>()).add(destination);
        //adjacencyList.computeIfAbsent(destination, k-> new ArrayList<>()).add(source);
    }

    public List<T> getAdjacentVertices(T vertex) {
        return adjacencyList.getOrDefault(vertex, Collections.emptyList());
    }

    public static void main(String[] args) {
       /* Graph<Integer> graph = new Graph<>();

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

        System.out.println(graph.getAdjacentVertices(2));*/

    }




}
