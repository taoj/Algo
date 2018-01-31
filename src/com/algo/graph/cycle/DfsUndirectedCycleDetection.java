package com.algo.graph.cycle;

import com.algo.Starter;
import com.algo.graph.Graph;

/**
 * 
 * @author jingt
 * 
 *         对于无向图的cycle detection， 用dfs遍历。
 *         因为是无向图，每两个vertex之间的指向是双向的，所以在遍历中发现某个节点已经被访问过，而这个节点是当前节点的子节点，这并不构成cycle。
 *         判断的方法就是u == v。除此情况之外，如果发现已访问节点，证明graph有cycle。
 *
 */

public class DfsUndirectedCycleDetection implements Starter {

	public boolean undirectedGraphCycDetection(Graph graph) {
		boolean visited[] = new boolean[graph.v];

		int start = 0;

		return detectionUtil(graph, start, visited);

	}

	boolean detectionUtil(Graph graph, int start, boolean[] visited) {
		visited[start] = true;

		for (int neighbor : graph.adj[start]) {
			if (!visited[neighbor]) {
				return detectionUtil(graph, neighbor, visited);
			} else if (start != neighbor) {
				return true;
			}
		}

		return false;
	}

	@Override
	public void run() {
		Graph g1 = new Graph(5);
		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 0);
		g1.addEdge(0, 3);
		g1.addEdge(3, 4);

		System.out.println("detection result: " + undirectedGraphCycDetection(g1));

		Graph g2 = new Graph(3);
		g2.addEdge(0, 1);
		g2.addEdge(1, 2);

		System.out.println("detection result: " + undirectedGraphCycDetection(g2));

	}

}
