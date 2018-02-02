package com.algo.graph.cycle;

import com.algo.Starter;
import com.algo.graph.Graph;

public class DisjointSetCycleDetection implements Starter {

	public int find(int[] parent, int node) {
		if (parent[node] == -1) {
			return node;
		}

		return find(parent, parent[node]);
	}

	// General Union
	public void union(int[] parent, int x, int y) {
		int px = find(parent, x);
		int py = find(parent, y);

		parent[px] = py;
	}

	public boolean hasCycle(Graph graph) {
		int[] parent = new int[graph.v];

		for (int i = 0; i < graph.v; i++) {
			parent[i] = -1;
		}

		for (int i = 0; i < graph.adj.length; i++) {
			for (int next : graph.adj[i]) {

				if (find(parent, i) == find(parent, next)) {
					return true;
				}
				union(parent, i, next);
			}
		}

		return false;
	}

	@Override
	public void run() {

		Graph graph = new Graph(3);
		graph.addEdge(0, 1);
		graph.addEdge(1, 2);
		graph.addEdge(0, 2);

		System.out.println("the graph has cycle: " + hasCycle(graph));

	}

}
