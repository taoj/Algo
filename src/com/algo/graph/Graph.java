package com.algo.graph;

import java.util.List;

public class Graph {
	public int v;
	public List<Integer> adj[];

	public void addEdge(int w, int v) {
		adj[w].add(v);
	}
}
