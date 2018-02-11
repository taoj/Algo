package com.algo.graph;

import com.algo.Starter;

/**
 * Dijkstra 对有向和无向图同时适用。但没法处理权制为负数的情况。
 * 
 * 时间复杂度为O(v^2),
 * 
 * @author jingt
 *
 */
public class Dijkstra implements Starter {

	public void process(int[][] graph) {
		int len = graph.length;
		boolean[] inSet = new boolean[len];

		int[] parent = new int[len];

		int[] dist = new int[len];

		for (int i = 0; i < len; i++) {
			parent[i] = -1;
			dist[i] = Integer.MAX_VALUE;
		}

		dist[0] = 0;
		int cur = 0;

		for (int i = 0; i < len; i++) {

			int next = findNext(dist, inSet);
			inSet[next] = true;
			// 这一步不需要，因为当前next的dist在上一步的时候已经更新了，
			// 这一步要做的选出最小的后，去更新未来的值。
			// dist[next] = dist[cur] + graph[cur][next];

			update(dist, graph[next], dist[next]);

			parent[next] = cur;
			cur = next;

		}

		printSolution(dist);

	}

	int findNext(int[] dist, boolean[] inSet) {
		int min = Integer.MAX_VALUE;
		int index = -1;
		for (int i = 0; i < dist.length; i++) {
			if (dist[i] < min && !inSet[i]) {
				index = i;
				min = dist[i];
			}
		}

		return index;
	}

	void update(int[] dist, int[] adj, int value) {
		for (int i = 0; i < adj.length; i++) {
			if (adj[i] != 0 && adj[i] + value < dist[i]) {
				dist[i] = value + adj[i];
			}
		}
	}

	void printSolution(int dist[]) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " tt " + dist[i]);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		process(graph);

	}

}
