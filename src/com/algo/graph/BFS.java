package com.algo.graph;

import java.util.LinkedList;

import com.algo.Starter;

/**
 * 图的bfs和树的bfs很类似，要注意的是图中可能有循环cycle。所以要有一个visit来记录某个节点是否已经被访问过。
 *
 * 如果图不是联通的 connected， 要做的就是对每个节点vertex 进行bfs
 *
 * 时间复杂度为 O（v+E）
 *
 * 空间复杂度为 O（v）
 */

public class BFS implements Starter {

	private Graph graph;

	public BFS() {
	}

	// public void init(int num) {
	// v = num;
	// adj = new LinkedList[v];
	//
	// for (int i = 0; i < v; i++) {
	// adj[i] = new LinkedList<>();
	// }
	// }

	public void bfs(int first) {

		boolean[] visit = new boolean[graph.v];
		LinkedList<Integer> queue = new LinkedList<>();

		// 初始状态
		visit[first] = true;
		queue.offer(first);

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			System.out.println("process node " + cur);

			for (int next : graph.adj[cur]) {
				if (!visit[next]) {
					visit[next] = true;
					queue.offer(next);
				}
			}
		}

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

		bfs(2);
	}
}
