package com.algo.graph;

import java.util.List;

public class Graph {
    public int n;
    public List<Integer> adj[];

    public void addEdge(int w, int v){
        adj[w].add(v);
    }
}
