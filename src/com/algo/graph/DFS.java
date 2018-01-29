package com.algo.graph;

import java.util.LinkedList;

import com.algo.Starter;

public class DFS extends Graph implements Starter {

	void dfsUtil(boolean[] visited, int current) {

		System.out.println("dfs vertex " + current);

		for (int next : adj[current]) {
			if (!visited[next]) {
				visited[next] = true;

				dfsUtil(visited, next);
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void init(int num) {
		n = num;
		adj = new LinkedList[n];

		for (int i = 0; i < n; i++) {
			adj[i] = new LinkedList<>();
		}
	}

	public void dfs(int start) {
		boolean[] visited = new boolean[n];

		visited[start] = true;

		dfsUtil(visited, start);
	}

	@Override
	public void run() {
		init(4);
		addEdge(0, 1);
		addEdge(0, 2);
		addEdge(1, 2);
		addEdge(2, 0);
		addEdge(2, 3);
		addEdge(3, 3);

		dfs(2);
	}
}
