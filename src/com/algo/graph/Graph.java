package com.algo.graph;

import java.util.LinkedList;
import java.util.List;

public class Graph {
	public int v;
	public List<Integer> adj[];

	public void addEdge(int w, int v) {
		adj[w].add(v);
	}

	@SuppressWarnings("unchecked")
	public Graph(int num) {
		v = num;
		adj = new LinkedList[v];

		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
		}
	}
}
