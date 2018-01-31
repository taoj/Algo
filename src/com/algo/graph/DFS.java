package com.algo.graph;

import com.algo.Starter;

public class DFS implements Starter {

	private Graph graph;

	void dfsUtil(boolean[] visited, int current) {

		System.out.println("dfs vertex " + current);

		for (int next : graph.adj[current]) {
			if (!visited[next]) {
				visited[next] = true;

				dfsUtil(visited, next);
			}
		}
	}

	// @SuppressWarnings("unchecked")
	// public void init(int num) {
	// v = num;
	// adj = new LinkedList[v];
	//
	// for (int i = 0; i < v; i++) {
	// adj[i] = new LinkedList<>();
	// }
	// }

	public void dfs(int start) {
		boolean[] visited = new boolean[graph.v];

		visited[start] = true;

		dfsUtil(visited, start);
	}

	@Override
	public void run() {

		graph = new Graph(4);
		graph.addEdge(0, 1);
		graph.addEdge(0, 2);
		graph.addEdge(1, 2);
		graph.addEdge(2, 0);
		graph.addEdge(2, 3);
		graph.addEdge(3, 3);

		dfs(2);
	}
}
