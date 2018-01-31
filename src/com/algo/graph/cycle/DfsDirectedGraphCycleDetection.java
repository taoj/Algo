package com.algo.graph.cycle;

import com.algo.Starter;
import com.algo.graph.Graph;

/**
 * 对于有向图的cycle detection，需要一个visited
 * stack。因为在有向图中，当遍历到一个已经访问过的vertex的时候并不能说明cycle的存在。 比如说 a->b a->c b->c
 * 这个图中没有cycle存在。所以需要一个recstack来记录当前节点是否在recstack中。在stack中的会造成cycle。遍历后把当前vertex出stack。
 * 
 * @author jingt
 *
 */
public class DfsDirectedGraphCycleDetection implements Starter {

	boolean cycleDetection(Graph graph) {

		boolean[] visited = new boolean[graph.v];
		boolean[] stk = new boolean[graph.v];

		for (int i = 0; i < graph.v; i++) {
			if (detectionUtil(graph, i, visited, stk)) {
				return true;
			}
		}
		return false;
	}

	boolean detectionUtil(Graph graph, int start, boolean[] visited, boolean[] stk) {

		visited[start] = true;
		stk[start] = true;

		for (int neighbor : graph.adj[start]) {
			if (!visited[neighbor]) {
				return detectionUtil(graph, neighbor, visited, stk);
			} else if (stk[neighbor]) {
				return true;
			}
		}

		stk[start] = false;
		return false;
	}

	@Override
	public void run() {
		Graph g = new Graph(4);
		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("detection result: " + cycleDetection(g));
	}
}
